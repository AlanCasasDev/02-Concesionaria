
package alancasas.Concesionaria.logica.entidades.enums;


public enum EnumColor {
    ROJO("Rojo"),
    BLANCO("Blanco"),
    NEGRO("Negro"),
    GRIS("Gris"),
    AZUL("Azul"),
    AMARILLO("Amarillo"),
    VIOLETA("Violeta"),
    VERDE("Verde");
    
    private String descripcion;

    private EnumColor(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescription() {
        return descripcion;
    }
}
