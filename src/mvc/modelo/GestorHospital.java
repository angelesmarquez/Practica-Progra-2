package mvc.modelo;

import java.util.Map;

public class GestorHospital {
    
    //Mapas
    private Map<Integer,AAPersona> vPersonal;
    private Map<Integer,Paciente> vPacientes;
    private Map <Integer, AATratamiento> vTratamiento;
    
    //C

    public GestorHospital(Map<Integer, AAPersona> vPersonal, Map<Integer, Paciente> vPacientes, Map<Integer, AATratamiento> vTratamiento) {
        this.vPersonal = vPersonal;
        this.vPacientes = vPacientes;
        this.vTratamiento = vTratamiento;
    }
    
    
    //Funcion que recibe los datos ingresados por el usuario y los guarda en el maps
    public void registrarPersonal (AAPersona nuevoPersonal){
        
        vPersonal.put(nuevoPersonal.getID(), nuevoPersonal);
        System.out.println("Se registró correctamente");
    }
    public void registrarPaciente(Paciente nuevoPaciente){
        
        vPacientes.put(nuevoPaciente.getIdP(),nuevoPaciente);
        System.out.println("Se Registró Paciente");
    }
    
    //Funcion que busca el paciente solicitado por el usuario y si no lo encuentra revienta el error generado
    public Paciente buscarPaciente (int ID) throws PacienteNoEncontradoException {
        
        Paciente encontrado = vPacientes.get(ID);
        if (encontrado == null){
            throw new PacienteNoEncontradoException("El Pacient solicitado no esta registrado en el sistema");
        }
        return encontrado;
    }
}
