package com.ymagis.emulator.appliancesnmp.snmp.exception;

public class SnmpClientException extends RuntimeException {

    public SnmpClientException() {
    }

    public SnmpClientException(String message) {
        super(message);
    }

    public SnmpClientException(Throwable cause) {
        super(cause);
    }

    public SnmpClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
