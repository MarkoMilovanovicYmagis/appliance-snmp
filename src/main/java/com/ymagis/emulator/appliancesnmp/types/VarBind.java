package com.ymagis.emulator.appliancesnmp.types;

import com.ymagis.emulator.appliancesnmp.asn.AsnOID;
import com.ymagis.emulator.appliancesnmp.asn.AsnObject;
import com.ymagis.emulator.appliancesnmp.asn.AsnSequence;
import com.ymagis.emulator.appliancesnmp.asn.ber.BerTlv;
import com.ymagis.emulator.appliancesnmp.asn.exception.AsnParsingException;

import java.io.ByteArrayInputStream;

public class VarBind extends AsnSequence {

    public VarBind() {
    }

    public VarBind(AsnOID oid, AsnObject value) {
        add(oid);
        add(value);
    }

    public VarBind(BerTlv tlv) {
        setValue(tlv);
    }

    public void setObjectName(AsnOID oid) {
        add(0, oid);
    }

    public AsnOID getObjectName() {
        return (AsnOID) get(0);
    }

    public void setObjectSyntax(AsnObject value) {
        add(1, value);
    }

    public AsnObject getObjectSyntax() {
        return get(1);
    }

    public void setValue(BerTlv tlv) {
        byte buf[] = tlv.getValue();
        ByteArrayInputStream stream = new ByteArrayInputStream(buf);
        BerTlv childTlv = new BerTlv();
        childTlv.decode(stream);
        AsnObject asn = AsnObject.getInstance(childTlv);
        if (!(asn instanceof AsnOID))
            throw new AsnParsingException("Bad object type. Must be an instance of AsnOID");
        setObjectName((AsnOID) asn);
        childTlv = new BerTlv();
        childTlv.decode(stream);
        asn = AsnObject.getInstance(childTlv);
        setObjectSyntax(asn);
        if (stream.available() > 0)
            throw new AsnParsingException("Provided TLV doesn't contain valid VarBind object");
        else
            return;
    }

    public String toString() {
        return getObjectName().toString() + " = " + getObjectSyntax().toString();
    }
}

