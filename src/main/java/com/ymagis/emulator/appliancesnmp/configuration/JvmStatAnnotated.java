package com.ymagis.emulator.appliancesnmp.configuration;

import com.ymagis.emulator.appliancesnmp.annotations.MibBean;
import com.ymagis.emulator.appliancesnmp.annotations.MibProperty;
import com.ymagis.emulator.appliancesnmp.asn.AsnInteger;
import com.ymagis.emulator.appliancesnmp.asn.AsnOctetString;
import com.ymagis.emulator.appliancesnmp.asn.SmiGauge32;

@MibBean
public class JvmStatAnnotated {
    private String appName = "JVM Statistics";
    private int poolSize = 10;
    private String emulatorStatus = "Projector is On";
    private String lampStatus;
    private String projectorMovie;

    public JvmStatAnnotated(String appName, int poolSize) {
        this.appName = appName;
        this.poolSize = poolSize;

    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.1.0", writable = true, requiredType = AsnOctetString.class)
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.2.0", writable = true, requiredType = AsnInteger.class)
    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.3.0", requiredType = AsnInteger.class)
    public int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.4.0", requiredType = SmiGauge32.class)
    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.5.0", requiredType = SmiGauge32.class)
    public long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.6.0", requiredType = SmiGauge32.class)
    public long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    @MibProperty(oid = "1.3.6.1.4.1.28824.99.7.0", requiredType = AsnInteger.class)
    public int getNumberOfThreads() {
        return Thread.activeCount();
    }


    //emulator oid
    @MibProperty(oid = "1.3.6.1.4.1.119.2.3.123.1.3", writable = true, requiredType = AsnOctetString.class)
    public String getEmulatorStatus() {
        return emulatorStatus;
    }


}
