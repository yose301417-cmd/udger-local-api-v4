package org.udger.restapi.resource;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * The type Parse ua v 4 request.
 */
@XmlRootElement(name = "parseUaV4Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParseUaV4Request {
    @XmlElement
    String uaString;
    @XmlElement
    String secChUa;
    @XmlElement
    String secChUaFullVersionList;
    @XmlElement
    String secChUaMobile;
    @XmlElement
    String secChUaFullVersion;
    @XmlElement
    String secChUaPlatform;
    @XmlElement
    String secChUaPlatformVersion;
    @XmlElement
    String secChUaModel;

    @Override
    public String toString() {
        return "ParseUaV4Request{" +
                "uaString='" + uaString + '\'' +
                ", secChUa='" + secChUa + '\'' +
                ", secChUaFullVersionList='" + secChUaFullVersionList + '\'' +
                ", secChUaMobile='" + secChUaMobile + '\'' +
                ", secChUaFullVersion='" + secChUaFullVersion + '\'' +
                ", secChUaPlatform='" + secChUaPlatform + '\'' +
                ", secChUaPlatformVersion='" + secChUaPlatformVersion + '\'' +
                ", secChUaModel='" + secChUaModel + '\'' +
                '}';
    }
}
