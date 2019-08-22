package com.ymagis.emulator.appliancesnmp.types;

import com.ymagis.emulator.appliancesnmp.asn.ber.BerTlv;
import com.ymagis.emulator.appliancesnmp.asn.exception.AsnParsingException;

public class SetRequestPDU extends PDU {

    public static final byte TAG_NUMBER = -93;

    public SetRequestPDU(long requestId, int errorStatus, long errorIndex, VarBindList varBindList) {
        super(requestId, errorStatus, errorIndex, varBindList);
        if (errorStatus != 0 || errorIndex != 0L)
            throw new AsnParsingException("errorStatus and errorIndex must be 0 for SetRequestPDU");
        else
            return;
    }

    public SetRequestPDU(long requestId, VarBindList varBindList) {
        super(requestId, varBindList);
    }

    public SetRequestPDU(BerTlv tlv) {
        super(tlv);
    }

    public BerTlv toBerTlv() {
        return super.toBerTlv(TAG_NUMBER);
    }

}