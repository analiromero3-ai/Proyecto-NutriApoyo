package NutriApoyo.model;

public enum Sexo {
    FEMENINO("Femenino"),
    MASCULINO("Masculino"),
    NO_ESPECIFICADO("No especificado");

    private final String nombreVisible;

    Sexo(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }
}
