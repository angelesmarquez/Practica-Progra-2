package mvc.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorHospital {
    
    //Mapas
    private Map<String,AAPersona> vPersonal;
    private Map<Integer,Paciente> vPacientes;
    private Map <Integer, AATratamiento> vTratamiento;
    
    //C
    public GestorHospital(Map<String, AAPersona> vPersonal, Map<Integer, Paciente> vPacientes, Map<Integer, AATratamiento> vTratamiento) {
        this.vPersonal = vPersonal;
        this.vPacientes = vPacientes;
        this.vTratamiento = vTratamiento;
    }

    public GestorHospital() {
        this.vPersonal = new HashMap<>();
        this.vPacientes = new HashMap<>();
        this.vTratamiento = new HashMap<>();
    }
    
    //G
    public Map<String, AAPersona> getvPersonal() {
        return vPersonal;
    }

    public Map<Integer, Paciente> getvPacientes() {
        return vPacientes;
    }

    public Map<Integer, AATratamiento> getvTratamiento() {
        return vTratamiento;
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
    
    //LE DICE COMO TAL AL MAPA BUSCAME ESTE ID Y DEVUELVEMELO, SE NECESITA PARA LUEGO LISTAR A LOS PACIENTES DEL MEDICO
    public void asignarMedico(int idPaciente, String idMedico) throws 
    PacienteNoEncontradoException, SinMedicoAsignadoException {
    
    Paciente paciente = vPacientes.get(idPaciente);
    if (paciente == null) {
        throw new PacienteNoEncontradoException("El paciente no existe");
    }
    
    AAPersona persona = vPersonal.get(idMedico);
    if (persona == null || !(persona instanceof AMedico)) {
        throw new SinMedicoAsignadoException("El medico no existe");
    }
    
    AMedico medico = (AMedico) persona;
    paciente.setMedicoAsignado(medico);
    System.out.println("Medico asignado correctamente");
    }
    
    //RECORRE TODOS LOS PACIENTES DEL MAPA Y FILTRA SOLO LOS QUE TIENE ASIGNADO ESE MEDICO 
    //CREA UNA LISTA VACIA DONDE SE VAN A GUARDAR LOS RESULTADOS 
    public ArrayList<Paciente> obtenerPacientesPorMedico(String idMedico) {
    
     ArrayList<Paciente> listaPacientes = new ArrayList<>();
    
     for (Paciente paciente : vPacientes.values()) {
        if (paciente.getMedicoAsignado() != null && paciente.getMedicoAsignado().getID().equals(idMedico)) {
            listaPacientes.add(paciente);
        }
     }
     return listaPacientes;
    }
    
    //AGREGA EL TRATAMIENTO AL ARRAYLIST DEL PACIENTE 
    public void asignarTratamiento(int idPaciente, int idTratamiento) 
        throws PacienteNoEncontradoException, SinMedicoAsignadoException {
    
     Paciente paciente = vPacientes.get(idPaciente);
     if (paciente == null) {
        throw new PacienteNoEncontradoException("El paciente no existe");
      }
    
     if (paciente.getMedicoAsignado() == null) {
        throw new SinMedicoAsignadoException("El paciente no tiene medico asignado");
      }
    
     AATratamiento tratamiento = vTratamiento.get(idTratamiento);
     if (tratamiento == null) {
        throw new PacienteNoEncontradoException("El tratamiento no existe");
     }
    
     paciente.agregarTratamiento(tratamiento);
     System.out.println("Tratamiento asignado correctamente");
    }
    
    //SE PUEDE DEJAR EL TEXTO GENERADO EN EL METODO EN LA INTERFAZ CON TEXT AREA 
    public String generarFactura(int idPaciente) throws PacienteNoEncontradoException {
    
     Paciente paciente = vPacientes.get(idPaciente);
      if (paciente == null) {
         throw new PacienteNoEncontradoException("El paciente no existe");
      }
    
     String factura = "===== FACTURA =====\n";
     factura += "Paciente: " + paciente.getNombre() + "\n";
     factura += "Medico: " + paciente.getMedicoAsignado().getNombre() + "\n";
     factura += "-------------------\n";
     factura += "Tratamientos:\n";
    
      float total = 0;
      for (AATratamiento t : paciente.getListaTratamientos()) {
         factura += "- " + t.getNomTrat() + ": $" + t.calcularcosto() + "\n";
         total += t.calcularcosto();
      }
    
     factura += "-------------------\n";
     factura += "TOTAL: $" + total + "\n";
     factura += "===================";
    
     return factura;
    }
    
}

