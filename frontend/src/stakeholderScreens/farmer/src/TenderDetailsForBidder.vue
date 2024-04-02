<template>
    <v-container>
        <v-card class="grey lighten-4 pa-8">

            <h3>Display Tender :  {{this.tender.id}}</h3>
            <v-row class="pa-4">
                <div>
                    Tender Reference Number :  {{this.tender.referenceNumber}}
                    <br>
                    Tender Name   :   {{this.tender.scopeOfWork}}
                    <br>
                    Tender Status  :  PUBLISHED
                    <br>
                    Tender Start Date  :  {{tenderStartDate}}
                    <br>
                    Submission Deadline : {{this.tender.dueDateForBidSubmission}}
                    <br>
                    Tender Owner  :  {{this.tender.contactName}}
                </div>
            </v-row>
            <br>
            <br>
            <v-row>
                <!--                <v-btn class="mx-12 mb-4 mt-4">Technical Document</v-btn>-->
                <v-btn dark class="blue" v-on:click="openBidForm()">Submit BID</v-btn>
            </v-row>
        </v-card>

        <v-snackbar v-model="snackbar">Congratulations! You have registered Successfully</v-snackbar>

        <v-card flat class="mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Tender Details</v-tab>
                <v-tab>Tender Documents</v-tab>

                <v-tab-item >
                    <v-card flat>
                        <br />
                        <br />

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

                        <br />
                        <br />
                        <br />
                    </v-card>
                </v-tab-item>

                <v-tab-item >
                    <v-card flat>
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

            <br />
            <br />
            <br />
        </v-card>
        <v-row>
            <v-col>
                <div class="text-center">
                    <v-btn dark class="blue" v-on:click="openBidForm()">Submit Bid</v-btn>
                </div>
            </v-col>
        </v-row>

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
    </v-container>
</template>

<script>
export default {
    name: 'TenderDetailsForBidder',
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
        openBidForm(){

            this.$router.push({name:'SubmitBid',params:{tender:this.tender}})
        }
    },
    mounted() {
        console.log("tender props");
        console.log(this.tender);

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
