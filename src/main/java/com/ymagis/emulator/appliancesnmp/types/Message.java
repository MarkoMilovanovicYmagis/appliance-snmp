package com.ymagis.emulator.appliancesnmp.types;

import com.ymagis.emulator.appliancesnmp.asn.AsnInteger;
import com.ymagis.emulator.appliancesnmp.asn.AsnOctetString;
import com.ymagis.emulator.appliancesnmp.asn.AsnSequence;
import com.ymagis.emulator.appliancesnmp.asn.ber.BerTlv;

public class Message extends AsnSequence {

    public Message() {
    }

    public Message(int version, String community, AbstractPDU pdu) {
        add(0, new AsnInteger(version));
        add(1, new AsnOctetString(community));
        add(2, pdu);
    }

    public Message(BerTlv tlv) {
        setValue(tlv);
    }

    public int getVersion() {
        return ((AsnInteger) get(0)).intValue();
    }

    public String getComunity() {
        return ((AsnOctetString) get(1)).stringValue();
    }

    public AbstractPDU getPDU() {
        return (AbstractPDU) get(2);
    }

    public String toString() {
        StringBuffer msgString = new StringBuffer("SNMP Message: [\n");
        msgString.append("version: ").append(getVersion()).append("\n").append("community: ").append(getComunity()).append("\n")
                .append("data: ").append(getPDU().toString()).append("]");
        return msgString.toString();
    }
}
