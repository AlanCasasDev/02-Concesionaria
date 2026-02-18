package alancasas.Concesionaria.persistencia.DAO.exceptions;
/**
 * Excepción lanzada cuando una entidad no existe en la base de datos
 */
public class RollbackFailureException extends Exception {
    public RollbackFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public RollbackFailureException(String message) {
        super(message);
    }
}