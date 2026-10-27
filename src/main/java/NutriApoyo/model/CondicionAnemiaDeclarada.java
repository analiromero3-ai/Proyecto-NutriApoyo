package NutriApoyo.model;

/** Condición declarada en el documento presentado; no constituye un diagnóstico del sistema. */
public enum CondicionAnemiaDeclarada {
    DIAGNOSTICO_DECLARADO("Diagnóstico declarado"),
    RIESGO_DECLARADO("Riesgo declarado");

    private final String nombreVisible;

    CondicionAnemiaDeclarada(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }
}
