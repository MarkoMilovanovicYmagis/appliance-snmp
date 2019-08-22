package com.ymagis.emulator.appliancesnmp.snmp.exception;

public class SnmpSystemException extends RuntimeException {

    public SnmpSystemException() {
    }

    public SnmpSystemException(String message) {
        super(message);
    }

    public SnmpSystemException(Throwable cause) {
        super(cause);
    }

    public SnmpSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
