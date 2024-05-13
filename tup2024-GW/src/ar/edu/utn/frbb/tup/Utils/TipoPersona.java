package ar.edu.utn.frbb.tup.Utils;

public enum TipoPersona {

    PERSONA_FISICA("F"),
    PERSONA_JURIDICA("J");

    private final String descripcion;//final, termina ahi, no se puede modificar

    TipoPersona(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoPersona fromString(String text) {//evalua que el texto ingresado sea una opcion del enum tipopersona
        for (TipoPersona tipo : TipoPersona.values()) {
            if (tipo.descripcion.equalsIgnoreCase(text)) {//le quita el casesensitive
                return tipo;
            }
        }
        throw new IllegalArgumentException("No se pudo encontrar un TipoPersona con la descripción: " + text);
    }
}


