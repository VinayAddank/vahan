package org.rta.vahan.api.unregistered;

import java.io.StringReader;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.rta.vahan.api.ResponseType;
import org.rta.vahan.api.VahanResponseModel;
import org.rta.vahan.api.unregistered.model.UnregisteredChassisInfo;
import org.rta.vahan.api.unregistered.model.UnregisteredVahanResponseModel;
import org.rta.vahan.exception.IllegalEngineNumberException;

import nic.transport.homologation.web.service.Dataportws;
import nic.transport.homologation.web.service.Getdataws;

public class UnregisteredVahanClientImpl implements UnregisteredVahanClient {

    private static final Logger logger = Logger.getLogger(UnregisteredVahanClientImpl.class);
    public static final Integer NUMBER_FIVE = 5;

    private final String userId;
    private final String trasactionPassword;
    private final Dataportws dataportws;

    public UnregisteredVahanClientImpl(String userId, String trasactionPassword) {
        this.userId = userId;
        this.trasactionPassword = trasactionPassword;
        this.dataportws = new Getdataws().getDataportwsPort();
    }

    @Override
    public VahanResponseModel<UnregisteredChassisInfo> getChassisInfo(String chassisNumber, String engineNumber)
            throws IllegalEngineNumberException {
        try {
            //engineNumber = StringsUtil.getLastChars(engineNumber, NUMBER_FIVE);
        } catch (IllegalArgumentException e) {
            throw new IllegalEngineNumberException("engine number is not valid");
        }
        return handleResponse(dataportws.getChassisInfo(userId, trasactionPassword, chassisNumber, engineNumber));
    }

    private VahanResponseModel<UnregisteredChassisInfo> handleResponse(String responseString) {
        UnregisteredChassisInfo vd = null;
        try {
            
//BIKE: responseString ="<ChassisInfoDobj><body_type>FULLY BUILD</body_type><chasi_no>ME4JF493FG8209684</chasi_no><color>REBEL RED METALLIC</color><cubic_cap>124.9</cubic_cap><eng_no>JF49E81243378</eng_no><engine_power>6.38</engine_power><f_axle_descp></f_axle_descp><f_axle_weight>0</f_axle_weight><fuel_descr>PETROL</fuel_descr><gvw>280</gvw><height>0</height><length>0</length><maker_descr>Honda Motorcycle and Scooter India (P) Ltd</maker_descr><monthYear>062016</monthYear><no_cyl>1</no_cyl><norms_descr>BHARAT STAGE III</norms_descr><o1_axle_descp></o1_axle_descp><o1_axle_weight>0</o1_axle_weight><o2_axle_descp></o2_axle_descp><o2_axle_weight>0</o2_axle_weight><o3_axle_descp></o3_axle_descp><o3_axle_weight>0</o3_axle_weight><o4_axle_descp></o4_axle_descp><o4_axle_weight>0</o4_axle_weight><o5_axle_descp></o5_axle_descp><o5_axle_weight>0</o5_axle_weight><r_axle_descp></r_axle_descp><r_axle_weight>0</r_axle_weight><seat_cap>2</seat_cap><stand_cap>0</stand_cap><t_axle_descp></t_axle_descp><t_axle_weight>0</t_axle_weight><unld_wt>110</unld_wt><vh_class>L2</vh_class><wheelbase>1260</wheelbase><width>0</width></ChassisInfoDobj>";
//CAR: responseString ="<ChassisInfoDobj><body_type>PASSENGER VEHICLE</body_type><chasi_no>MEXF16606GT094029</chasi_no><color>FLASH RED</color><cubic_cap>1198.0</cubic_cap><eng_no>CJL119782</eng_no><engine_power>55.0</engine_power><f_axle_descp></f_axle_descp><f_axle_weight>0</f_axle_weight><fuel_descr>PETROL</fuel_descr><gvw>1520</gvw><height>0</height><length>0</length><maker_descr>Volkswagen India Pvt Ltd</maker_descr><monthYear>062016</monthYear><no_cyl>3</no_cyl><norms_descr>BHARAT STAGE IV</norms_descr><o1_axle_descp></o1_axle_descp><o1_axle_weight>0</o1_axle_weight><o2_axle_descp></o2_axle_descp><o2_axle_weight>0</o2_axle_weight><o3_axle_descp></o3_axle_descp><o3_axle_weight>0</o3_axle_weight><o4_axle_descp></o4_axle_descp><o4_axle_weight>0</o4_axle_weight><o5_axle_descp></o5_axle_descp><o5_axle_weight>0</o5_axle_weight><r_axle_descp></r_axle_descp><r_axle_weight>0</r_axle_weight><seat_cap>5</seat_cap><stand_cap>0</stand_cap><t_axle_descp></t_axle_descp><t_axle_weight>0</t_axle_weight><unld_wt>1053</unld_wt><vh_class>M1</vh_class><wheelbase>2469</wheelbase><width>0</width></ChassisInfoDobj>";
//DEMO: responseString ="<ChassisInfoDobj><body_type>PASSENGER CAR</body_type><chasi_no>MEXH16603HT053237</chasi_no><color>BLUE SILK METALLIC</color><cubic_cap>1198.0</cubic_cap><eng_no>CJL122971</eng_no><engine_power>55.0</engine_power><f_axle_descp></f_axle_descp><f_axle_weight>0</f_axle_weight><fuel_descr>PETROL</fuel_descr><gvw>1500</gvw><height>0</height><length>0</length><maker_descr>Volkswagen India Pvt Ltd</maker_descr><monthYear>082016</monthYear><no_cyl>3</no_cyl><norms_descr>BHARAT STAGE IV</norms_descr><o1_axle_descp></o1_axle_descp><o1_axle_weight>0</o1_axle_weight><o2_axle_descp></o2_axle_descp><o2_axle_weight>0</o2_axle_weight><o3_axle_descp></o3_axle_descp><o3_axle_weight>0</o3_axle_weight><o4_axle_descp></o4_axle_descp><o4_axle_weight>0</o4_axle_weight><o5_axle_descp></o5_axle_descp><o5_axle_weight>0</o5_axle_weight><r_axle_descp></r_axle_descp><r_axle_weight>0</r_axle_weight><seat_cap>5</seat_cap><stand_cap>0</stand_cap><t_axle_descp></t_axle_descp><t_axle_weight>0</t_axle_weight><unld_wt>1059</unld_wt><vh_class>M1</vh_class><wheelbase>2470</wheelbase><width>0</width></ChassisInfoDobj>";
            
            if (Objects.isNull(responseString)) {
                return new UnregisteredVahanResponseModel(ResponseType.ERROR, responseString);
            }
            vd = (UnregisteredChassisInfo) getUnmarshaller(UnregisteredChassisInfo.class)
                    .unmarshal(new StringReader(responseString));
            return new UnregisteredVahanResponseModel(ResponseType.SUCCESS, responseString, vd);
        } catch (JAXBException e) {
            logger.debug(e.getMessage());
            logger.debug("response string : " + responseString);
            return new UnregisteredVahanResponseModel(ResponseType.ERROR, responseString);
        } catch (IllegalArgumentException e) {
            logger.debug(e.getMessage());
            logger.debug("response string : " + responseString);
            return new UnregisteredVahanResponseModel(ResponseType.ERROR, responseString);
        }
    }

    private Unmarshaller getUnmarshaller(Class<?> clazz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        return jaxbContext.createUnmarshaller();
    }

}
