<template>
    <v-container>
        <v-card class="grey lighten-4 pa-8">

            <h3>Display Lot Record :  {{this.lot.id}}</h3>
            <v-row class="pa-4">
                <div>
                    Lot Reference Number :  {{this.lot.referenceNumber}}
                    <br>
                    Lot Name   :   {{this.lot.scopeOfWork}}
                    <br>
                    Lot Status  :  PUBLISHED
                    <br>
                    Lot Start Date  :  {{lotStartDate}}
                    <br>
                    Submission Deadline : {{this.lot.dueDateForProductSubmission}}
                    <br>
                    Lot Owner  :  {{this.lot.contactName}}
                </div>
            </v-row>
            <br>
            <br>
            <v-row>
                <!--                <v-btn class="mx-12 mb-4 mt-4">Technical Document</v-btn>-->
                <v-btn dark class="blue" v-on:click="openProductForm()">Submit Product</v-btn>
            </v-row>
        </v-card>

        <v-snackbar v-model="snackbar">Congratulations! You have registered Successfully</v-snackbar>

        <v-card flat class="mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Lot Record Details</v-tab>
                <v-tab>Lot Documents</v-tab>

                <v-tab-item >
                    <v-card flat>
                        <br />
                        <br />

                        <v-container class="pl-16 ml-16">
                            <div >
                                <v-row>
                                    <v-col cols="5" align="right">Brief scope of work:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.scopeOfWork }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Lot Reference Number and Date :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.referenceNumber }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Lot Opening Date:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.referenceDate }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Type of Lot System:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.typeOfProductdingSystem }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Lot Type:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.type }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Form of contract:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.formOfContract }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">No of cover:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.numberOfCover }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Lot Category:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.category }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Account Type Head:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.accountTypeHead }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">No of Product Openers:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.numberOfProductOpeners }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should allow re-product Submission:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.allowReProductSubmission }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should allow Withdrawal of Products:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.allowWithdrawalOfProducts }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Product Security :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.productSecurityEnabled }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should Allow Offline Submission :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.allowOfflineSubmission }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should Allow Technical Evaluation :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.allowTechnicalEvaluation }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Date and Time of Pre-Product Meeting :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.venue }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Venu of Pre-Product Meeting :</v-col>
                                    <v-col
                                            cols="3"
                                            align="left"
                                    >{{ this.lot.preProductMeetingDate }} {{ this.lot.preProductMeetingTime }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Due Date and Time for Product Submission :</v-col>
                                    <v-col
                                            cols="3"
                                            align="left"
                                    >{{ this.lot.dueDateForProductSubmission }} {{ this.lot.dueTimeForProductSubmission }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Date and Time of Un-Priced Product Opening :</v-col>
                                    <v-col
                                            cols="3"
                                            align="left"
                                    >{{ this.lot.unPricedProductOpeningDate}} {{ this.lot.unPricedProductOpeningTime }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Contact Name :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.contactName }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Email & Phone NO :</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.email }}, {{ this.lot.phoneNumber }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Should allow Multi-currency:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.shouldAllowMultiCurrency }}</v-col>
                                </v-row>
                                <v-row>
                                    <v-col cols="5" align="right">Payment mode:</v-col>
                                    <v-col cols="3" align="left">{{ this.lot.paymentMode }}</v-col>
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
                    <v-btn dark class="blue" v-on:click="openProductForm()">Submit Product</v-btn>
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
    name: 'LotDetailsForFarmer',
    props: ["lot"],
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
        openProductForm(){

            this.$router.push({name:'SubmitProduct',params:{lot:this.lot}})
        }
    },
    mounted() {
        console.log("lot props");
        console.log(this.lot);

        //generate document list from lot
        this.covers = [];
        this.covers.push({
            documentName:"Lot Description",
            category:"",
            "description":"Contains details about the lot.",
            filename:this.lot && this.lot.lotFileDocumentPath,
            version:"1.0",
            type:"Image"
        });

        this.covers.push({
            documentName:"SOR Document",
            category:"",
            "description":"Schedule of rates document.",
            filename:this.lot && this.lot.sorFilePath,
            version:"1.0",
            type:"Image"
        })
    },
    data() {
        return {
            showDialog:false,
            ocrText:"",
            snackbar: false,
            lotNumber: '8000017105',
            lotName: 'Assorted Valves SAPL Project',
            lotStatus: 'Published',
            lotStartDate: '28.07.2020 21:55:00 INDIA',
            deadline: '18.08.2020 14:00:00 INDIA',
            remainingTime: '19 Days 22:29:30',
            lotOwner: 'MECON',

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
