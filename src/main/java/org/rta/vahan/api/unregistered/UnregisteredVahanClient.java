package org.rta.vahan.api.unregistered;

import org.rta.vahan.api.VahanResponseModel;
import org.rta.vahan.api.unregistered.model.UnregisteredChassisInfo;
import org.rta.vahan.exception.IllegalEngineNumberException;

public interface UnregisteredVahanClient {

    public abstract VahanResponseModel<UnregisteredChassisInfo> getChassisInfo(String chassisNumber, String engineNumber) throws IllegalEngineNumberException;
    
}
