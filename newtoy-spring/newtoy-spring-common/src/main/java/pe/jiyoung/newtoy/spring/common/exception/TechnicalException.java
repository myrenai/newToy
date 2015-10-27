package pe.jiyoung.newtoy.spring.common.exception;

/**
 * {@code TechnicalException} is the subclasses of the {@code RuntimeException}
 * @author Jiyoung Park
 * @since  1.0.0
 */
public class TechnicalException extends RuntimeException {

    private static final long serialVersionUID = 5766918134228174336L;

    /** Constructs a new technical exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public TechnicalException() {
        super();
    }

    /** Constructs a new technical exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public TechnicalException(final String message) {
        super(message);
    }

    /**
     * Constructs a new technical exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.0.0
     */
    public TechnicalException(final String message, final Exception e) {
        super(message, e);
    }

    /** Constructs a new technical exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for technical exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.0.0
     */
    public TechnicalException(final Throwable cause) {
        super(cause);
    }


}
