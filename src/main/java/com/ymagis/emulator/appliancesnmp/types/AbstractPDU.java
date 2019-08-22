package com.ymagis.emulator.appliancesnmp.types;

import com.ymagis.emulator.appliancesnmp.asn.AsnSequence;
import com.ymagis.emulator.appliancesnmp.asn.ber.BerTlv;
import com.ymagis.emulator.appliancesnmp.asn.exception.AsnObjectValueException;

import java.util.List;

public abstract class AbstractPDU extends AsnSequence {

    public AbstractPDU() {
    }

    public AbstractPDU(List value) throws AsnObjectValueException {
        super(value);
    }

    public AbstractPDU(BerTlv tlv) {
        super(tlv);
    }
}
