package org.rta.vahan.api.registered;

import org.rta.vahan.api.VahanResponseModel;
import org.rta.vahan.api.registered.model.RegisteredVehicleDetails;

/**
 * VahanService provides details for vahan
 * 
 * @author rahul.sharma
 *
 */
public interface VahanClient {

    /**
     * Get details of vehicle using registration number
     * 
     * @param clientId
     * @param regnNo
     * @return returns VahanResponseModel
     */
    public VahanResponseModel<RegisteredVehicleDetails> getDetails(String clientId, String regnNo);

    /**
     * Get details of vehicle using chasiNo number
     * 
     * @param clientId
     * @param chasiNo
     * @return returns VahanResponseModel
     */
    public VahanResponseModel<RegisteredVehicleDetails> getChasisDetails(String clientId, String chasiNo);
    
}
