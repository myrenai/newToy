package pe.jiyoung.newtoy.spring.common.exception;

public class BusinessException extends Exception {
    private static final long serialVersionUID = 407133208634011113L;

    private final int returnCode;

    private final String severity;

    private String technicalCauseMessage;

    /** Constructs a new businexx exception with the specified {@code ExceptionAttr}.
     *
     * @param   exceptionAttr   the detail exception attributes.
     */
    public BusinessException(final ExceptionAttribute exceptionAttr) {
        super(exceptionAttr.getMsg());
        this.returnCode = exceptionAttr.getCode();
        this.severity = exceptionAttr.getSeverity();
    }

    /**
     * Constructs a new businexx exception with the specified {@code ExceptionAttr} and the {@code TechnicalException}.
     * @param exceptionAttr the detail exception attributes.
     * @param technicalException  the technicalException type original exception
     */
    public BusinessException(final ExceptionAttribute exceptionAttr, final TechnicalException technicalException) {
        super(exceptionAttr.getMsg());
        this.returnCode = exceptionAttr.getCode();
        this.severity = exceptionAttr.getSeverity();

        String causeClass = null;
        if (technicalException != null) {
            this.technicalCauseMessage = technicalException.getMessage();
            final Throwable cause = technicalException.getCause();
            if (cause != null) {
                final String extraCauseMessage = cause.getMessage();
                this.technicalCauseMessage = this.technicalCauseMessage + " [Cause: " + extraCauseMessage + "]";
                causeClass = cause.getClass().getSimpleName();
            } else {
                causeClass = technicalException.getClass().getSimpleName();
            }
            this.technicalCauseMessage = this.technicalCauseMessage + " CauseClass: " + causeClass;
        }
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSeverity() {
        return this.severity;
    }

    public String getTechnicalCauseMessage() {
        return this.technicalCauseMessage;
    }

    public void setTechnicalCauseMessage(final String technicalCauseMessage) {
        this.technicalCauseMessage = technicalCauseMessage;
    }

}
