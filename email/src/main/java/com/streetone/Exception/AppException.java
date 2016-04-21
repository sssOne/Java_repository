package com.streetone.Exception;

import com.streetone.common.ErrorCodes;

/**
 * The Class AppException.
 * 
 * @author Shalaka Nayal
 */
public class AppException extends Exception {

    private static final long serialVersionUID = 1L;

    int code;
    String message;
    String name;
    Throwable ex;
    String description;

    public AppException(ErrorCodes errorCode) {
        this.code = errorCode.getErrorCode();
        this.description = errorCode.getDescription();
        this.name = errorCode.name();
    }

    public AppException(ErrorCodes errorCode, String message) {
        this.code = errorCode.getErrorCode();
        this.description = errorCode.getDescription();
        this.name = errorCode.name();
        this.message = message;
    }

    public AppException(ErrorCodes errorCode, Throwable ex) {
        this.code = errorCode.getErrorCode();
        this.description = errorCode.getDescription();
        this.ex = ex;
    }

    /**
     * Gets the code.
     * 
     * @return the code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Sets the code.
     * 
     * @param code the new code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the name.
     * 
     * @return name name of the exception
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for being able to set the new value.
     * 
     * @param name name of the exception
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the ex.
     * 
     * @return the ex
     */
    public Throwable getEx() {
        return ex;
    }

    /**
     * Sets the ex.
     * 
     * @param ex the new ex
     */
    public void setEx(Throwable ex) {
        this.ex = ex;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * 
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
