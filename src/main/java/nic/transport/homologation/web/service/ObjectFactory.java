
package nic.transport.homologation.web.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nic.transport.homologation.web.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetChassisInfo_QNAME = new QName("http://service.web.homologation.transport.nic/", "getChassisInfo");
    private final static QName _GetChassisInfoResponse_QNAME = new QName("http://service.web.homologation.transport.nic/", "getChassisInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nic.transport.homologation.web.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetChassisInfoResponse }
     * 
     */
    public GetChassisInfoResponse createGetChassisInfoResponse() {
        return new GetChassisInfoResponse();
    }

    /**
     * Create an instance of {@link GetChassisInfo }
     * 
     */
    public GetChassisInfo createGetChassisInfo() {
        return new GetChassisInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChassisInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.homologation.transport.nic/", name = "getChassisInfo")
    public JAXBElement<GetChassisInfo> createGetChassisInfo(GetChassisInfo value) {
        return new JAXBElement<GetChassisInfo>(_GetChassisInfo_QNAME, GetChassisInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChassisInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.homologation.transport.nic/", name = "getChassisInfoResponse")
    public JAXBElement<GetChassisInfoResponse> createGetChassisInfoResponse(GetChassisInfoResponse value) {
        return new JAXBElement<GetChassisInfoResponse>(_GetChassisInfoResponse_QNAME, GetChassisInfoResponse.class, null, value);
    }

}
