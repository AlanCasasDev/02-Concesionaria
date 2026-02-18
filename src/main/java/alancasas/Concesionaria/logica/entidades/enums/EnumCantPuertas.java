package alancasas.Concesionaria.logica.entidades.enums;

public enum EnumCantPuertas {

    DOS_PUERTAS(2),
    TRES_PUERTAS(3),
    CUATRO_PUERTAS(4),
    CINCO_PUERTAS(5);

    private int descripcion;

    private EnumCantPuertas(int puertas) {
        this.descripcion = puertas;
    }

    public int getDescription() {
        return descripcion;
    }

}
