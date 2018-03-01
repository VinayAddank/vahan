package org.rta.vahan.api.registered.model;

import org.rta.vahan.api.ResponseType;
import org.rta.vahan.api.VahanResponseModel;

public class RegisteredVahanResponseModel extends VahanResponseModel<RegisteredVehicleDetails> {

    private RegisteredVehicleDetails vehicleDetails;

    public RegisteredVahanResponseModel(ResponseType responseType, String errorDesc) {
        super(responseType, errorDesc);
    }
    
    public RegisteredVahanResponseModel(ResponseType responseType, String errorDesc, RegisteredVehicleDetails vehicleDetails) {
        super(responseType, errorDesc);
        this.vehicleDetails = vehicleDetails;
    }

    public void setResponseModel(RegisteredVehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    @Override
    public RegisteredVehicleDetails getResponseModel() {
        return vehicleDetails;
    }

}
