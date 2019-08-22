package com.ymagis.emulator.appliancesnmp.types;

import com.ymagis.emulator.appliancesnmp.asn.ber.BerTlv;
import com.ymagis.emulator.appliancesnmp.asn.exception.AsnParsingException;

public class GetNextRequestPDU extends PDU {

    public static final byte TAG_NUMBER = -95;

    public GetNextRequestPDU(long requestId, int errorStatus, long errorIndex, VarBindList varBindList) {
        super(requestId, errorStatus, errorIndex, varBindList);
        if (errorStatus != 0 || errorIndex != 0L)
            throw new AsnParsingException("errorStatus and errorIndex must be 0 for GetNextRequestPDU");
    }

    public GetNextRequestPDU(long requestId, VarBindList varBindList) {
        super(requestId, varBindList);
    }

    public GetNextRequestPDU(BerTlv tlv) {
        super(tlv);
    }

    public BerTlv toBerTlv() {
        return super.toBerTlv(TAG_NUMBER);
    }

}

