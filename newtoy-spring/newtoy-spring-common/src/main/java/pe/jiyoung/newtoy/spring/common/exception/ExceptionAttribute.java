package pe.jiyoung.newtoy.spring.common.exception;

import pe.jiyoung.newtoy.spring.common.util.ToyPropertyResolver;

public class ExceptionAttribute {

    /**
     * Code d'erreur
     */
    private int code;
    /**
     * Message d'une exception
     */
    private String msg;

    /**
     * Severité
     */
    private String severity;

    /**
     * Constructeur par défaut
     */
    public ExceptionAttribute() {
        super();
        this.code = 1000;
        this.msg = "Une erreur technique est survenue dans l'application";
        this.severity = "ERROR";
    }

    public static ExceptionAttribute create(final ExceptionType type, final int code, final Object... extraArgs) {
        final String property = ToyPropertyResolver.getProperty(type.name() + "." + code);
        final String[] value = property.trim().split("\\s*;\\s*");
        return new ExceptionAttribute(code, value[0], value[1], extraArgs);
    }

    /**
     * @param code
     * @param msg
     * @param severity
     */
    public ExceptionAttribute(final int code, final String msg, final String severity) {
        super();
        this.code = code;
        this.msg = msg;
        this.severity = severity;
    }

    /**
     * Constructeur avec un code un message, une sévérité, et des arguments qui
     * servent à formatter le message
     *
     * @param code
     * @param msg
     * @param severity
     * @param extraArgs
     */
    public ExceptionAttribute(final int code, final String msg, final String severity, final Object... extraArgs) {
        super();
        this.code = code;
        if (extraArgs != null) {
            this.msg = String.format(msg, extraArgs);
        } else {
            this.msg = msg;
        }
        this.severity = severity;
    }


    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSeverity() {
        return this.severity;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setSeverity(final String severity) {
        this.severity = severity;
    }
}
