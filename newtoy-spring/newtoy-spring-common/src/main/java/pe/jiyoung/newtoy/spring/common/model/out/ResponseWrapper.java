package pe.jiyoung.newtoy.spring.common.model.out;

import java.util.HashMap;

import pe.jiyoung.newtoy.spring.common.exception.BusinessException;


/**
 *
 * @author Jiyoung Park
 *
 * @param <T>
 */
public class ResponseWrapper<T> {

    public final static String DATA = "data";
    public final static String RETURN_CODE = "returnCode";
    public final static String MESSAGE = "message";
    public final static String SEVERITY = "severity";

    private int returnCode;
    private final String message;
    private final String severity;
    private T data;

    public ResponseWrapper() {
        this.message = new String();
        this.severity = new String();
    }

    /** Constructs a new response wrapper with {@code BusinessException} as its
     * content.
     * @param e the business exception to send
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper(final BusinessException e) {
        this.returnCode = e.getReturnCode();
        this.message = e.getMessage();
        this.severity = e.getSeverity();
        final HashMap<String, Object> dataMap = new HashMap<String, Object>();
        final String technicalCauseMessage = e.getTechnicalCauseMessage();
        if (technicalCauseMessage != null) {
            dataMap.put("commentError", technicalCauseMessage);
        }
        this.data = (T) dataMap;
    }

    /** Constructs a new response wrapper with the returnCode, message, severity and data
     *
     * @param returnCode
     * @param message
     * @param severity
     * @param data
     */
    public ResponseWrapper(final int returnCode, final String message, final String severity, final T data) {
        this.returnCode = returnCode;
        this.message = message;
        this.severity = severity;
        this.data = data;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(final int returnCode) {
        this.returnCode = returnCode;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public String getSeverity() {
        return this.severity;
    }

}
