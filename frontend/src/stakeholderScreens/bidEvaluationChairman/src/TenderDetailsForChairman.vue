<template>
    <v-container>
        <v-card class="grey lighten-4 pa-4 px-8">
            <h4>Display Tender : 8000017105</h4>
            <v-row>
                <v-btn class="mx-12 mb-4 mt-4">Technical Document</v-btn>
                
               
            </v-row>
            <v-row>
                <pre>Tender Number :  {{tenderNumber}}                              Tender Name   :   {{tenderName}}
Tender Status  :  {{tenderStatus}}                              Tender Start Date  :  {{tenderStartDate}}
Submission Deadline : {{deadline}}          Remaining Time  :  {{remainingTime}}
Tender Owner  :  {{tenderOwner}}
                </pre>
            </v-row>
        </v-card>

        <v-snackbar v-model="snackbar">Congratulations! You have registered Successfully</v-snackbar>

        <v-card flat class="mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Basic Details</v-tab>
                <v-tab>Cover Details</v-tab>

                <v-tab-item :key="tab1">
                    <v-card flat>
                        <br />
                        <br />

                        <v-container class="pl-16 ml-16">
                            <v-form>
                                <v-row>
                                    <v-col cols="3">Time Zone</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="INDIA" outlined></v-text-field>
                                    </v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="3">Start Date</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="28.07.2020" outlined></v-text-field>
                                    </v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="20:07.20" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Submission Deadline</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="18.08.2020" outlined></v-text-field>
                                    </v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="00:00.00" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Currency</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="INR" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Pre-Bid Conference Venue</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="Over VC" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Pre-Bid Conference Time</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="15:00:00" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Pre-Bid Conference Date</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="05.08.2020" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Last Time for Tender Fee Payment</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value=" 00:00:00" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Last Date for Tender Fee Payment</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value=" " outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">EMD Amount in USD</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="0.00" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">EMD Amount in INR</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="0.00" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Phone Number</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="011-22401143" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">E-mail</v-col>
                                    <v-col cols="3">
                                        <v-text-field
                                            disabled
                                            value="cont-delhi#mecon.co.in"
                                            outlined
                                        ></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Dealing Officer</v-col>
                                    <v-col cols="3">
                                        <v-text-field
                                            disabled
                                            value="Sr. GM (Contracts) Mecon LTD., Delhi"
                                            outlined
                                        ></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Technical Bid Opening Date</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="18.08.2020" outlined></v-text-field>
                                    </v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="18:00:20" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Technical Bid Opening Date</v-col>
                                    <v-col cols="3">
                                        <v-text-field
                                            disabled
                                            value="Local Competitive Bid"
                                            outlined
                                        ></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Tender Fee (INR)</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value="0.00" outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Technical Analysis Date</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value outlined></v-text-field>
                                    </v-col>
                                </v-row>

                                <v-row>
                                    <v-col cols="3">Commercial Analysis Date</v-col>
                                    <v-col cols="3">
                                        <v-text-field disabled value outlined></v-text-field>
                                    </v-col>
                                </v-row>
                            </v-form>
                        </v-container>

                        <br />
                        <br />
                        <br />
                    </v-card>
                </v-tab-item>

                <v-tab-item :key="tab2">
                    <v-card flat>
                        <br />

                        <br />
                        <v-container>
                            <v-data-table :headers="headers" :items="covers" item-key="name">
                                <template v-slot:item.checkout="{ item }">
                                    <v-checkbox small v-model="item.checkout" icon></v-checkbox>
                                </template>
                            </v-data-table>
                        </v-container>
                    </v-card>
                </v-tab-item>
            </v-tabs>

            <br />
            <br />
            <br />
        </v-card>
       
    </v-container>
</template>

<script>
export default {
    name: 'TenderDetailsForBidder',

    data() {
        return {
            snackbar: false,
            tenderNumber: '8000017105',
            tenderName: 'Assorted Valves SAPL Project',
            tenderStatus: 'Published',
            tenderStartDate: '28.07.2020 21:55:00 INDIA',
            deadline: '18.08.2020 14:00:00 INDIA',
            remainingTime: '19 Days 22:29:30',
            tenderOwner: 'MECON',

            Corregendum: false,
            Reject: false,
            covers: [
                {
                    assigned: 'Document Header',
                    category: 'Standard Attachment',
                    Description: 'SOR',
                    filename: 'SORWEB.XLS.sig',
                    version: '1',
                    type: 'sig',
                    size: '79',
                    changedby: 'XMEC-RSHARMA',
                    changedon: '28.07.2020',
                },
            ],
            headers: [
                {
                    text: 'Assigned to',
                    value: 'assigned',
                },
                {
                    text: 'Category',
                    value: 'category',
                },
                {
                    text: 'Description',
                    value: 'Description',
                },

                {
                    text: 'File Name ',
                    value: 'filename',
                },

                {
                    text: 'Checkout ',
                    value: 'checkout',
                },

                {
                    text: 'Version ',
                    value: 'version',
                },
                {
                    text: 'Processor ',
                    value: 'processor',
                },

                {
                    text: 'Type ',
                    value: 'type',
                },

                {
                    text: 'Size (KB) ',
                    value: 'size',
                },

                {
                    text: 'Changed by',
                    value: 'changedby',
                },

                {
                    text: 'Changed on',
                    value: 'changedon',
                },
            ],
        }
    },
}
</script>
