package NutriApoyo.model;

/** Estado administrativo del registro; no elimina la información del menor. */
public enum EstadoBeneficiario {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private final String nombreVisible;

    EstadoBeneficiario(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }
}
