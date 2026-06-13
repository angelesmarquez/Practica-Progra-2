package mvc.modelo;
public class PacienteNoEncontradoException extends Exception {

    public PacienteNoEncontradoException() {
    }

    public PacienteNoEncontradoException(String message) {
        super(message);
    }  
}
