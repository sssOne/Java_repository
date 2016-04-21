package com.streetone.common;

/**
 * The Enum ErrorCodes.
 * 
 * @author Shalaka Nayal
 */
public enum ErrorCodes {

    // Response code for success response
    TRANSACTION_OK(0, "Transaction sucessful"),

    // Response code for general errors [start Range: 1000]
    INTERNAL(1001, "Internal error occure. Please contact administrator."),
    SERVICE_UNAVAILABLE(1002, "Requested service unavailable"),
    SERVICE_NOT_FOUND(1003, "Requested service not found"),
    REQUEST_TIMEOUT(1004, "Request timeout"),
    REQUEST_NOT_AUTHORIZE(1005, "Requested service not authorize"),
    ACTION_UNSUPPORTED(1006, "Action or method Unsupported"),
    FILE_UPLOAD(1007, "File Upload failed");

    int errorCode;
    String description;

    /**
     * Instantiates a new error codes.
     * 
     * @param errorCode the error code
     * @param description the description
     */
    private ErrorCodes(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Gets the error code.
     * 
     * @return the error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     * 
     * @param errorCode the new error code
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
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