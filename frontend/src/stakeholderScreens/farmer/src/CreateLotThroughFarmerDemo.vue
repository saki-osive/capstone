<template>
    <v-div>
        <v-toolbar class="blue lighten-2 mb-4">
            <v-toolbar-title>Application for New Lot Record</v-toolbar-title>
        </v-toolbar>
        <div>
            <h1 align="center" class="font-weight-black">
                Farmer Lot Record Details
            </h1>
        </div>
        <v-div class="ml-12 pl-12">
            <v-form>

 <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Delivery ID
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>




 <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Carrier ID
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>




                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Name of Company
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Vendor Code</v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                    <v-col cols="3">
                        <v-subheader>Lot Reference</v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader> Product Delivery Date</v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Payment Mode
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>

                    <v-col>
                        <v-select
                            label="-select-"
                            :items="payment"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Language
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>

                    <v-col>
                        <v-select
                            label="-select-"
                            :items="languageItems"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col align="left">
                        <v-subheader>
                            Product Level Details
                        </v-subheader>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Product Name
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Product ID
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined> </v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Storage Conditions
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Harvest Date
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                    <v-col cols="3">
                        <v-subheader>
                          Origin
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Manufacturing Date
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Expiration Date
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Location
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                    <v-col cols="3">
                        <v-subheader>
                            Postal Code
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          Certifications
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                          GST/HST/QST No
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>
            </v-form>
            <v-row >
                <v-col class="my-2" align="right">
                    <v-btn 
                    :to="{ name: 'ModeOfTransportFarmer'}">
                        Next
                    </v-btn>
                </v-col>
            </v-row>
        </v-div>
    </v-div>
</template>
<script>
export default {
    name: 'CreateLotThroughFarmerDemo',
   

    data() {
        return {
            languageItems: ['English', 'French'],
            payment: ['Online', 'Offline',]
        }
    },
}
</script>
