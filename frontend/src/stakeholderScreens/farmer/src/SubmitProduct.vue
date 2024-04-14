<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Submit Product Details</v-toolbar-title>
        </v-toolbar>
        <v-stepper v-model="e1">
            <v-stepper-header>
                <v-stepper-step editable :complete="e1 > 1" step="1">Enter Basic Details</v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step editable :complete="e1 > 2" step="2">Upload Documents</v-stepper-step>

                <v-divider></v-divider>

              <v-stepper-step editable :complete="e1 > 3" step="3">Bill of Material</v-stepper-step>

              <v-divider></v-divider>

                <v-stepper-step editable :complete="e1 > 4" step="4">Review and Submit</v-stepper-step>
            </v-stepper-header>

            <v-stepper-items>
                <v-stepper-content step="1">
                    <v-card class="mb-12" flat>
                        <LotInformation :lot="lotModel" ref="lotInformationRef"/>
                    </v-card>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>
                            <v-btn color="success" class="my-btn" v-on:click="saveAsDraftClicked()">Save Draft</v-btn>
                            <v-btn color="primary" class="my-btn" @click="tab1ContinueClicked()">Continue</v-btn>
                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>

                <v-stepper-content step="2" v-on:click="tab1ContinueClicked()">
                    <v-card class="mb-12" flat>
                        <UploadDocuments ref="uploadDocumentRef"/>
                    </v-card>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>
                            <v-btn color="success" class="my-btn" v-on:click="saveAsDraftClicked()">Save Draft</v-btn>
                            <v-btn color="primary" class="my-btn" @click="tab2ContinueClicked()">Continue</v-btn>
                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>
              <v-stepper-content step="3" >
                <v-card class="mb-12" flat>
                  <BillOfMaterial ref="billOfMaterial"/>
                </v-card>
                <v-card flat>
                  <v-row>
                    <v-spacer></v-spacer>
                    <v-btn color="success" class="my-btn" v-on:click="saveAsDraftClicked()">Save Draft</v-btn>
                    <v-btn color="primary" class="my-btn" @click="tab2ContinueClicked()">Continue</v-btn>
                    <v-btn text class="my-btn">Cancel</v-btn>
                  </v-row>
                </v-card>
              </v-stepper-content>

                <v-stepper-content step="4" v-on:click="tab2ContinueClicked()">
                    <div class="text-center">
                        <v-row>
                            <v-col cols="5" align="right">Currency:</v-col>
                            <v-col cols="3" align="left">{{ this.input.currency }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="5" align="right">Product Amount:</v-col>
                            <v-col cols="3" align="left">{{ this.input.bidAmount }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="5" align="right">GST Number:</v-col>
                            <v-col cols="3" align="left">{{ this.input.gstNumber }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="5" align="right">Lot Reference No:</v-col>
                            <v-col cols="3" align="left">{{ this.lotModel.referenceNumber }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="5" align="right">Lot Type:</v-col>
                            <v-col cols="3" align="left">{{ this.lotModel.type }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="5" align="right">Lot Category:</v-col>
                            <v-col cols="3" align="left">{{ this.lotModel.category }}</v-col>
                        </v-row>

                        <v-row>
                            <v-col cols="5" align="right">Financial Document:</v-col>
                            <v-col cols="3" align="left">{{ this.input.financialDoc }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="5" align="right">Technical Document:</v-col>
                            <v-col cols="3" align="left">{{ this.input.technicalDoc }}</v-col>
                        </v-row>
                    </div>
                    <v-divider></v-divider>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>
                            <v-btn color="success" class="my-btn" v-on:click="saveAsDraftClicked()" >Save Draft</v-btn>
                            <v-btn color="primary" class="my-btn" v-on:click="submitClicked()">Submit</v-btn>
                            <v-btn text class="my-btn" v-on:click="cancelClicked()">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>
            </v-stepper-items>
        </v-stepper>
    </div>
</template>

<script>
import LotInformation from '@/stakeholderScreens/farmer/src/productSubmissionTabItems/LotInformation.vue'
import UploadDocuments from '@/stakeholderScreens/farmer/src/productSubmissionTabItems/UploadDocuments.vue'
import BillOfMaterial from '@/stakeholderScreens/farmer/src/productSubmissionTabItems/BillOfMaterial.vue'


export default {
    name: 'SubmitProduct',
    props:["lot"],
    components: {
        LotInformation,
        UploadDocuments,
        BillOfMaterial ,
    },
    mounted() {

        console.log(this.lot);
        this.lotModel = this.lot;
        console.log("this.lotModel");
        console.log(this.lotModel);
        //this.$refs.lotInformationRef.updateUI(this.lot)
    },
    methods:{
        tab1ContinueClicked(){
            this.e1 = 2;
            this.input = this.$refs.lotInformationRef.input;
        },
        tab2ContinueClicked(){
            this.e1 = 3;
            this.input = this.$refs.lotInformationRef.input;
            this.documents = this.$refs.uploadDocumentRef.documents;

        },
        cancelClicked(){

        },
        saveAsDraftClicked(){

        },
        submitClicked(){

            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            var request = JSON.parse(JSON.stringify(this.input));
            request["lot"] = this.lotModel;
            request["bidItems"] = this.$refs.billOfMaterial.covers;

            let formData = new FormData();
            formData.append("product",JSON.stringify(request));

            this.documents.forEach(function(entry) {

                if (entry.sno === 1){
                    formData.append('technicalDoc', entry.file);
                }else {
                    formData.append('financialDoc', entry.file);
                }
            });

            this.$api.post('/product/create', formData,{
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){

                        this.$router.push({name:"SubmittedProducts"});
                        this.showNotification("Success","Product saved Successfully.")
                    }else {
                        this.showNotification("Error","Failed to save product.","info")
                    }

                }, (error) => {
                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to save product.","error")
                });

        }
    },
    data() {
        return {
            input:{
                financialDoc:"",
                technicalDoc:"",
                bidAmount:""
            },
            documents:[],
            lotModel:{},
            e1: 1,
        }
    },
}
</script>

<style lang="scss" scoped>
.my-btn {
    margin: 5px;
}
</style>