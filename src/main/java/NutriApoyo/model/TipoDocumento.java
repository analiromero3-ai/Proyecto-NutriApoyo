package NutriApoyo.model;

public enum TipoDocumento {
    DNI("DNI"),
    CARNET_EXTRANJERIA("Carnet de extranjería"),
    OTRO("Otro");

    private final String nombreVisible;

    TipoDocumento(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }
}
