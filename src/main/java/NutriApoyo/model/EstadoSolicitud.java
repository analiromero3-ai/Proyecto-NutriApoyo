package NutriApoyo.model;

public enum EstadoSolicitud {
    RECIBIDA("Recibida"),
    EN_EVALUACION("En evaluación"),
    OBSERVADA("Observada"),
    APROBADA("Aprobada"),
    RECHAZADA("Rechazada"),
    ENTREGADA("Entregada");

    private final String nombreVisible;

    EstadoSolicitud(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }
}
