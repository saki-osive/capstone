/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class SupplyChainContracts {

    @Property()
    private String value;

    public SupplyChainContracts(){
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static TenderContract fromJSONString(String json) {
        String value = new JSONObject(json).getString("value");
        TenderContract asset = new TenderContract();
        asset.setValue(value);
        return asset;
    }

    public void Shipper(){
        String value = new JSONObject().getString("value");
        TenderContract asset = new TenderContract();
        asset.setValue(value);

    }

    public void Transporter(){

        String value = new JSONObject().getString("value");
        TenderContract asset = new TenderContract();
        asset.setValue(value);
    }

    public void FreightForwarder(){

        String value = new JSONObject().getString("value");
        TenderContract asset = new TenderContract();
        asset.setValue(value);
    }

    public void Customs(){

        String value = new JSONObject().getString("value");
        TenderContract asset = new TenderContract();
        asset.setValue(value);
    }


    public void ClearingAgency(){

        String value = new JSONObject().getString("value");
        TenderContract asset = new TenderContract();
        asset.setValue(value);
    }





}
