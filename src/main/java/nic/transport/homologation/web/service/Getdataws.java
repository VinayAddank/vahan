
package nic.transport.homologation.web.service;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import org.apache.log4j.Logger;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "getdataws", targetNamespace = "http://service.web.homologation.transport.nic/", wsdlLocation = "/wsdl/dataportws.xml")
public class Getdataws
    extends Service
{
    private static final Logger logger = Logger.getLogger(Getdataws.class);
    private final static URL GETDATAWS_WSDL_LOCATION;
    private final static WebServiceException GETDATAWS_EXCEPTION;
    private final static QName GETDATAWS_QNAME = new QName("http://service.web.homologation.transport.nic/", "getdataws");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = Getdataws.class.getResource("/wsdl/dataportws.xml");
        } catch (Exception e1) {
            e = new WebServiceException(e1);
            logger.error("Failed to create URL for the wsdl Location: '/wsdl/dataportws.xml', retrying as a local file");
            logger.error(e1.getMessage());
        }
        GETDATAWS_WSDL_LOCATION = url;
        GETDATAWS_EXCEPTION = e;
    }

    public Getdataws() {
        super(__getWsdlLocation(), GETDATAWS_QNAME);
    }

    public Getdataws(WebServiceFeature... features) {
        super(__getWsdlLocation(), GETDATAWS_QNAME, features);
    }

    public Getdataws(URL wsdlLocation) {
        super(wsdlLocation, GETDATAWS_QNAME);
    }

    public Getdataws(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GETDATAWS_QNAME, features);
    }

    public Getdataws(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Getdataws(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Dataportws
     */
    @WebEndpoint(name = "dataportwsPort")
    public Dataportws getDataportwsPort() {
        return super.getPort(new QName("http://service.web.homologation.transport.nic/", "dataportwsPort"), Dataportws.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Dataportws
     */
    @WebEndpoint(name = "dataportwsPort")
    public Dataportws getDataportwsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.web.homologation.transport.nic/", "dataportwsPort"), Dataportws.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GETDATAWS_EXCEPTION!= null) {
            throw GETDATAWS_EXCEPTION;
        }
        return GETDATAWS_WSDL_LOCATION;
    }

}