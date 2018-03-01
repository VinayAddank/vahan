package org.rta.vahan.api.unregistered.model;

import org.rta.vahan.api.ResponseType;
import org.rta.vahan.api.VahanResponseModel;

public class UnregisteredVahanResponseModel extends VahanResponseModel<UnregisteredChassisInfo> {

    private UnregisteredChassisInfo unregisteredChassisInfo;

    public UnregisteredVahanResponseModel(ResponseType responseType, String errorDesc) {
        super(responseType, errorDesc);
    }

    public UnregisteredVahanResponseModel(ResponseType responseType, String errorDesc,
            UnregisteredChassisInfo unregisteredChassisInfo) {
        super(responseType, errorDesc);
        this.unregisteredChassisInfo = unregisteredChassisInfo;
    }

    public void setUnregisteredChassisInfo(UnregisteredChassisInfo unregisteredChassisInfo) {
        this.unregisteredChassisInfo = unregisteredChassisInfo;
    }

    @Override
    public UnregisteredChassisInfo getResponseModel() {
        return unregisteredChassisInfo;
    }

}
