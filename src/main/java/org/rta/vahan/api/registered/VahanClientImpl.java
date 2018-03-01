package org.rta.vahan.api.registered;

import java.io.StringReader;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.rta.vahan.api.ResponseType;
import org.rta.vahan.api.StatusMessage;
import org.rta.vahan.api.VahanResponseModel;
import org.rta.vahan.api.registered.model.RegisteredVahanResponseModel;
import org.rta.vahan.api.registered.model.RegisteredVehicleDetails;
import org.rta.vahan.util.CryptographyAES;

import nic.vahan.web.server.VahanInfo;
import nic.vahan.web.server.VahanInfo_Service;

/**
 * Implementation for the VahanService.
 * Class calls vahan api and get response.
 * As per the vahan api response is encrypted with a secret key.
 * Firstly the response is decrypted with the secret key and then xml is parsed to get object.
 * 
 * @author rahul.sharma
 *
 */
public class VahanClientImpl implements VahanClient {

    private static final Logger logger = Logger.getLogger(VahanClientImpl.class);

    private VahanInfo vahanInfo;
    private CryptographyAES crypt;

    // @SuppressWarnings("restriction")
    public VahanClientImpl(String secretKey) {
        /*URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://vahan.nic.in/vahanws/VahanInfo?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VahanInfo_Service vs = new VahanInfo_Service().getPort(VahanInfo_Service.class);
        BindingProvider bp = (BindingProvider) vs.getPort(VahanInfo_Service.class);
        Map<String, Object> requestContext = bp.getRequestContext();
        requestContext.put(REQUEST_TIMEOUT, 3000); // Timeout in millis
        requestContext.put(CONNECT_TIMEOUT, 1000); // Timeout in millis
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);*/
        /*Service service = null;
        BindingProvider bindingProvider = null;
        try {
            bindingProvider = (BindingProvider)VahanInfo_Service.create(new URL("https://vahan.nic.in/vahanws/VahanInfo?wsdl"), new QName("http://server.web.vahan.nic/", "VahanInfo"));
            
        } catch (MalformedURLException e) {
            logger.debug(e);
        } catch (Exception e) {
            logger.error(e);
        }*/
        vahanInfo = new VahanInfo_Service().getVahanInfoPort();
        crypt = new CryptographyAES(secretKey);
    }

    @Override
    public VahanResponseModel<RegisteredVehicleDetails> getDetails(String clientId, String regnNo) {
        if (Objects.isNull(clientId) || Objects.isNull(regnNo)) {
            throw new IllegalArgumentException("clientId and regnNo can't be null");
        }
        return handleResponse(vahanInfo.getDetails(clientId, regnNo));
    }

    @Override
    public VahanResponseModel<RegisteredVehicleDetails> getChasisDetails(String clientId, String chasiNo) {
        if (Objects.isNull(clientId) || Objects.isNull(chasiNo)) {
            throw new IllegalArgumentException("clientId and chasiNo can't be null");
        }
        return handleResponse(vahanInfo.getChasisDetails(clientId, chasiNo));
    }

    private VahanResponseModel<RegisteredVehicleDetails> handleResponse(String responseString) {
        RegisteredVehicleDetails vd = null;
        try {
            responseString = decrypt(responseString);
            if (Objects.isNull(responseString)) {
                return new RegisteredVahanResponseModel(ResponseType.ERROR, responseString);
            }
            vd = (RegisteredVehicleDetails) getUnmarshaller(RegisteredVehicleDetails.class)
                    .unmarshal(new StringReader(responseString));
            if (vd.getStatusMessage() != null && vd.getStatusMessage().equals(StatusMessage.OK.label())) {
                return new RegisteredVahanResponseModel(ResponseType.SUCCESS, responseString, vd);
            }
            return new RegisteredVahanResponseModel(ResponseType.NOT_FOUND, responseString);
        } catch (JAXBException e) {
            logger.debug(e.getMessage());
            return new RegisteredVahanResponseModel(ResponseType.ERROR, responseString);
        } catch (IllegalArgumentException e) {
            logger.debug(e.getMessage());
            return new RegisteredVahanResponseModel(ResponseType.ERROR, responseString);
        }
    }

    private Unmarshaller getUnmarshaller(Class<?> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        return jaxbContext.createUnmarshaller();
    }

    private String decrypt(String text) {
        return crypt.decryptFile(text);
    }

}
