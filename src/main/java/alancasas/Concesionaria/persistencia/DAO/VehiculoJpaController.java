
package alancasas.Concesionaria.persistencia.DAO;

import alancasas.Concesionaria.logica.entidades.Vehiculo;
import alancasas.Concesionaria.persistencia.DAO.exceptions.NonexistentEntityException;
import alancasas.Concesionaria.persistencia.DAO.exceptions.RollbackFailureException;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class VehiculoJpaController implements Serializable {

    private EntityManagerFactory emf;

    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public VehiculoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("pelu_canina_PU");
    }

    private EntityManager getEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory no inicializado.");
        }
        return emf.createEntityManager();
    }

    /**
     * Persiste un nuevo Vehiculo en la base de datos.
     */
    public void create(Vehiculo vehiculo) throws RollbackFailureException {
        EntityManager em = null;

        try {
            em = getEntityManager();       // Obtengo EntityManager
            em.getTransaction().begin();   // Inicio transacción

            em.persist(vehiculo);          // Persisto entidad

            em.getTransaction().commit();  // Confirmo cambios
        } catch (Exception ex) {
            // Si algo falla, intento rollback
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al crear Vehiculo", ex
            );
        } finally {
            if (em != null) {
                em.close(); // Libero recursos
            }
        }
    }

    /**
     * Actualiza un Vehiculo existente.
     */
    public void edit(Vehiculo vehiculo)
            throws NonexistentEntityException, RollbackFailureException {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // merge devuelve la entidad administrada
            vehiculo = em.merge(vehiculo);

            em.getTransaction().commit();
        } catch (Exception ex) {
            // Si el ID no existe en BD
            if (findVehiculo(vehiculo.getId()) == null) {
                throw new NonexistentEntityException(
                        "El vehiculo con id " + vehiculo.getId() + " no existe."
                );
            }

            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al editar Vehiculo", ex
            );
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina un Vehiculo por ID.
     */
    public void destroy(int id)
            throws NonexistentEntityException, RollbackFailureException {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getId(); // Fuerza carga
            } catch (Exception e) {
                throw new NonexistentEntityException(
                        "El vehiculo con id " + id + " no existe."
                );
            }

            em.remove(vehiculo);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al eliminar Vehiculo", ex
            );
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Busca un Vehiculo por ID.
     */
    public Vehiculo findVehiculo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Devuelve todos los Vehiculos.
     */
    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    /**
     * Devuelve Vehiculos paginados.
     */
    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    /**
     * Implementación interna con Criteria API.
     */
    private List<Vehiculo> findVehiculoEntities(
            boolean all, int maxResults, int firstResult) {

        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Vehiculo> cq
                    = em.getCriteriaBuilder().createQuery(Vehiculo.class);

            cq.select(cq.from(Vehiculo.class));

            TypedQuery<Vehiculo> q = em.createQuery(cq);

            if (!all) {
                q.setMaxResults(maxResults);   // Cantidad por página
                q.setFirstResult(firstResult); // Offset
            }

            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Devuelve la cantidad total de Vehiculos.
     */
    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq
                    = em.getCriteriaBuilder().createQuery(Long.class);

            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));

            return em.createQuery(cq).getSingleResult().intValue();
        } finally {
            em.close();
        }
    }
}


