
package alancasas.Concesionaria.logica.entidades;

import alancasas.Concesionaria.logica.entidades.enums.EnumCantPuertas;
import alancasas.Concesionaria.logica.entidades.enums.EnumColor;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //por lo general recomiendo IDENTITY
    @Column(name = "id_vehiculo")
    private int id;
    
    @Column(name ="modelo", nullable = false, length = 50)
    private String modelo;
    
    @Column(name ="marca", nullable = false, length = 50)
    private String marca; 
    
    @Column(name ="patente", nullable = false, length = 10)
    private String patente;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="color", nullable = false, length = 25)
    private EnumColor color;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="cant_puertas", nullable = false, length = 50)
    private EnumCantPuertas cantPuertas;

    
    public Vehiculo() {
    }

    //No hace falta poner el id en el constructor dado que el jpa lo genera solo
    public Vehiculo(String modelo, String marca, String patente, EnumColor color, EnumCantPuertas cantPuertas) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.patente = patente;
        this.cantPuertas = cantPuertas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public EnumCantPuertas getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(EnumCantPuertas cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", color=" + color.getDescription() + ", patente=" + patente + ", cantPuertas=" + cantPuertas.getDescription() + '}';
    }    
    
}
