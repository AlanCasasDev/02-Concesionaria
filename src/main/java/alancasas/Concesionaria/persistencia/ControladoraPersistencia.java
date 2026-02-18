/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alancasas.Concesionaria.persistencia;

import alancasas.Concesionaria.logica.entidades.Vehiculo;
import alancasas.Concesionaria.persistencia.DAO.VehiculoJpaController;
import alancasas.Concesionaria.persistencia.DAO.exceptions.NonexistentEntityException;
import alancasas.Concesionaria.persistencia.DAO.exceptions.RollbackFailureException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladoraPersistencia {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcesionariaPersistUnit");

    private VehiculoJpaController vehiCtrl = new VehiculoJpaController(emf);

    public boolean guardarVehiculo(Vehiculo vehiculo) {
        try {
            vehiCtrl.create(vehiculo);
            return true;
        } catch (RollbackFailureException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al crear vehiculo con Id: " + vehiculo.getId() + "/Marca: " + vehiculo.getMarca() + "/Modelo: " + vehiculo.getModelo(), e);
            return false;
        }
    }

    public List<Vehiculo> traerVehiculos() {
        try {
            return vehiCtrl.findVehiculoEntities();
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al traer la lista de Vehiculos", e);
            return null;
        }
    }

    public boolean borrarVehiculo(int id) {
        try {
            vehiCtrl.destroy(id);
            return true;           
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.WARNING, "Error: La enridad que desea borrar no existe.", e);
            return false;
        } catch (RollbackFailureException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error de rollback al eliminar vehiculo", e);            
            return false;
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error inesperado al eliminar vehiculo", e);                              
            return false;
        }
    }

    public Vehiculo buscarVehiculo(int id) {
        return vehiCtrl.findVehiculo(id);
    }

    public boolean editarVehiculo(Vehiculo vehi) {
        try{
            vehiCtrl.edit(vehi);
            return true;
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.WARNING, "Error: La entidad que desea editar no existe.", e);
            return false;
        } catch (RollbackFailureException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error de rollback al editar vehiculo", e);            
            return false;
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error inesperado al editar vehiculo", e);                              
            return false;
        }
    }
}
