
package alancasas.Concesionaria.logica;

import alancasas.Concesionaria.logica.entidades.Vehiculo;
import alancasas.Concesionaria.logica.entidades.enums.EnumCantPuertas;
import alancasas.Concesionaria.logica.entidades.enums.EnumColor;
import alancasas.Concesionaria.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    private ControladoraPersistencia controlPersist = new ControladoraPersistencia();

    
    public boolean guardarVehiculo(String modelo, String marca, String patente, String color, String cantPuertas) {

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setModelo(modelo);
        vehiculo.setMarca(marca);
        vehiculo.setPatente(patente);

        switch (color.toLowerCase()) {
            case "amarillo":
                vehiculo.setColor(EnumColor.AMARILLO);
                break;
            case "azul":
                vehiculo.setColor(EnumColor.AZUL);
                break;
            case "blanco":
                vehiculo.setColor(EnumColor.BLANCO);
                break;
            case "gris":
                vehiculo.setColor(EnumColor.GRIS);
                break;
            case "negro":
                vehiculo.setColor(EnumColor.NEGRO);
                break;
            case "rojo":
                vehiculo.setColor(EnumColor.ROJO);
                break;
            case "verde":
                vehiculo.setColor(EnumColor.VERDE);
                break;
            case "violeta":
                vehiculo.setColor(EnumColor.VIOLETA);
                break;
            default:
                IO.print("Error en la eleccion del color");
        }

        switch ((String)cantPuertas) {
            case "2":
                vehiculo.setCantPuertas(EnumCantPuertas.DOS_PUERTAS);
                break;
            case "3":
                vehiculo.setCantPuertas(EnumCantPuertas.TRES_PUERTAS);
                break;
            case "4":
                vehiculo.setCantPuertas(EnumCantPuertas.CUATRO_PUERTAS);
                break;
            case "5":
                vehiculo.setCantPuertas(EnumCantPuertas.CINCO_PUERTAS);
                break;
            default:
                IO.print("Error al elegir la cantidad de puertas");
        }

        return controlPersist.guardarVehiculo(vehiculo);
    }

    public List<Vehiculo> traerVehiculos() {
        return controlPersist.traerVehiculos();
    }

    public boolean borrarVehiculo(int id) {
        return controlPersist.borrarVehiculo(id);
    }

    public Vehiculo buscarVehiculo(int id) {
        return controlPersist.buscarVehiculo(id);
    }

    public boolean editarVehiculo(Vehiculo vehi) {
        return controlPersist.editarVehiculo(vehi);
    }

}
