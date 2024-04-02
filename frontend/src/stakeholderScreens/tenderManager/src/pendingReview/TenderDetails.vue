<template>
    <v-container>
        
        <v-card class="mx-auto mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Basic Details</v-tab>
                <v-tab>Cover Details</v-tab>

            <v-container class="pl-16 ml-16">
                            <div >
                                <v-row>
                                    <v-col cols="5" align="right">Brief scope of work:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.scopeOfWork }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Tender Reference Number and Date :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.referenceNumber }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Tender Opening Date:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.referenceDate }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Type of Bidding System:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.typeOfBiddingSystem }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Tender Type:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.type }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Form of contract:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.formOfContract }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">No of cover:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.numberOfCover }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Tender Category:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.category }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Account Type Head:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.accountTypeHead }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">No of Bid Openers:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.numberOfBidOpeners }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should allow re-bid Submission:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.allowReBidSubmission }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should allow Withdrawal of bids:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.allowWithdrawalOfBids }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Bid Security :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.bidSecurityEnabled }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should Allow Offline Submission :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.allowOfflineSubmission }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should Allow Technical Evaluation :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.allowTechnicalEvaluation }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Date and Time of Pre-Bid Meeting :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.venue }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Venu of Pre-Bid Meeting :</v-col>
                                    <v-col
                                            cols="3"
                                            align="left"
                                    >{{ this.tender.preBidMeetingDate }} {{ this.tender.preBidMeetingTime }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Due Date and Time for Bid Submission :</v-col>
                                    <v-col
                                            cols="3"
                                            align="left"
                                    >{{ this.tender.dueDateForBidSubmission }} {{ this.tender.dueTimeForBidSubmission }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Date and Time of Un-Priced Bid Opening :</v-col>
                                    <v-col
                                            cols="3"
                                            align="left"
                                    >{{ this.tender.unPricedBidOpeningDate}} {{ this.tender.unPricedBidOpeningTime }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Contact Name :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.contactName }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Email & Phone NO :</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.email }}, {{ this.tender.phoneNumber }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should allow Multi-currency:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.shouldAllowMultiCurrency }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Payment mode:</v-col>
                                    <v-col cols="3" align="left">{{ this.tender.paymentMode }}</v-col>
                                </v-row>
                            </div>
                        </v-container>
                

                <v-tab-item >
                    <v-card flat>
                        <br />
                        <br />
                        <br />
                        <v-container>
                            <v-data-table :headers="headers" :items="covers" item-key="name">
                                <template v-slot:item.download="{ item }">
                                    <v-btn class="blue"
                                           dark
                                           small
                                           text
                                           v-on:click="startDownload(item)">

                                        Download
                                    </v-btn>

                                </template>
                                <template v-slot:item.ocr="{ item }">
                                    <v-btn class="blue"
                                           dark
                                           small
                                           text
                                           v-on:click="startOcr(item)">

                                        Convert to Text
                                    </v-btn>

                                </template>
                            </v-data-table>
                        </v-container>
                    </v-card>
                </v-tab-item>

            </v-tabs>
            <div class="text-center">
                <v-btn class="mx-4" small to="PendingReview">Cancel</v-btn>
                <v-btn class="mx-4" small @click.stop="Corregendum = true">Corregendum</v-btn>
                <v-btn class="mx-4" small :to="{ name: 'AcceptTender'}">Submit and Next</v-btn>
                <v-btn class="mx-4" small @click.stop="Reject= true">Reject Tender</v-btn>

                <v-dialog v-model="Corregendum" max-width="490">
                    <v-card>
                        <v-toolbar class="blue lighten-4">
                            <v-toolbar-title class="headline">Specify the corrections to be made</v-toolbar-title>
                        </v-toolbar>
                        <br />
                        <v-col cols="8" class="mx-auto">
                            <v-text-field single-line label="Reference Number" outlined></v-text-field>
                        </v-col>
                        <v-col cols="8" class="mx-auto">
                            <v-text-field single-line label="Reason" outlined></v-text-field>
                        </v-col>

                        <br />
                        <v-row justify="center" class="ma-0">
                            <v-btn color="blue darken-1" text @click="Corregendum = false">Cancel</v-btn>

                            <v-btn
                                color="blue darken-1"
                                text
                                to="MarkedCorregendum"
                                @click="Corregendum = false"
                            >Submit</v-btn>
                        </v-row>
                        <br />
                    </v-card>
                </v-dialog>

                <v-dialog v-model="Reject" max-width="490">
                    <v-card>
                        <v-toolbar class="blue lighten-4">
                            <v-toolbar-title class="headline">Rejection Reason</v-toolbar-title>
                        </v-toolbar>
                        <br />
                        <v-col cols="8" class="mx-auto">
                            <v-text-field single-line label="Reference Number" outlined></v-text-field>
                        </v-col>
                        <v-col cols="8" class="mx-auto">
                            <v-text-field single-line label="Reason" outlined></v-text-field>
                        </v-col>

                        <br />
                        <v-row justify="center" class="ma-0">
                            <v-btn color="blue darken-1" text @click="Reject = false">Cancel</v-btn>

                            <v-btn
                                color="blue darken-1"
                                text
                                :to="{name : 'RejectTender'}"
                                @click="Reject = false"
                            >Submit</v-btn>
                        </v-row>
                        <br />
                    </v-card>
                </v-dialog>

                <v-dialog v-model="showDialog" width="600px">
                    <v-card>
                        <v-card-title>
                            <span class="headline">Document to Text</span>
                        </v-card-title>
                        <v-card-text>{{ocrText}}</v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue darken-1" text @click="showDialog = false">OK</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </div>

            <br />
            <br />
            <br />
        </v-card>
    </v-container>
</template>

<script>
export default {
    name: 'TenderDetails',
    props: ["tender"],
    methods:{
        startDownload(documentItem){
            console.log(documentItem)

            let request = {"fileName":documentItem.filename};

            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            //hit api call
            this.$api.post('/download/document', request)
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){

                        this.showNotification("Success","User Created Successfully.")
                        window.open(response.data.data, '_blank');
                    }else {
                        this.showNotification("Error","Failed to register user.","info")
                    }

                }, (error) => {

                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to register user.","error")
                });
        },
        startOcr(documentItem){
            console.log(documentItem)
            let request = {"fileName":documentItem.filename};

            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            //hit api call
            this.$api.post('/download/ocr', request)
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){

                        this.showNotification("Success","User Created Successfully.")
                        this.showDialog = true;
                        this.ocrText = response.data.data;
                    }else {
                        this.showNotification("Error","Failed to register user.","info")
                    }

                }, (error) => {

                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to register user.","error")
                });

        },
    },
    mounted() {

        console.log(this.tender)
        //generate document list from tender
        this.covers = [];
        this.covers.push({
            documentName:"Tender Description",
            category:"",
            "description":"Contains details about the tender.",
            filename:this.tender && this.tender.tenderFileDocumentPath,
            version:"1.0",
            type:"Image"
        });

        this.covers.push({
            documentName:"SOR Document",
            category:"",
            "description":"Schedule of rates document.",
            filename:this.tender && this.tender.sorFilePath,
            version:"1.0",
            type:"Image"
        })
    },
    data() {
        return {
            showDialog:false,
            ocrText:"",
            Corregendum: false,
            Reject: false,
            covers: [],
            headers: [
                {
                    text: 'Document Name',
                    value: 'documentName',
                },
                {
                    text: 'Description',
                    value: 'description',
                },
                {
                    text: 'File Name ',
                    value: 'filename',
                },
                {
                    text: 'Version ',
                    value: 'version',
                },
                {
                    text: 'Type ',
                    value: 'type',
                },
                {
                    text: 'Download',
                    value: 'download',
                },
                {
                    text:'Optical character recognition',
                    value: 'ocr',
                }
            ],
        }
    },
}
</script>
