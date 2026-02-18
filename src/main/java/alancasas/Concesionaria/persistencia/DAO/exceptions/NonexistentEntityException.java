package alancasas.Concesionaria.persistencia.DAO.exceptions;
/**
 * Excepción lanzada cuando una entidad no existe en la base de datos
 */
public class NonexistentEntityException extends Exception {
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
