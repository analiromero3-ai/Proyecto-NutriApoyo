package NutriApoyo.model;

/** Roles permitidos para acceder a los módulos de NutriApoyo. */
public enum RolUsuario {
    ADMINISTRADOR("Administrador"),
    EVALUADOR("Evaluador"),
    PERSONAL_SALUD("Personal de salud"),
    TUTOR("Tutor");

    private final String nombreVisible;

    RolUsuario(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }
}
