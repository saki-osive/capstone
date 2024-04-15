/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class RetailerChaincode {

    @Property()
    private String value;

    public RetailerChaincode(){
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

    public static LotContract fromJSONString(String json) {
        String value = new JSONObject(json).getString("value");
        LotContract asset = new LotContract();
        asset.setValue(value);
        return asset;
    }
}
