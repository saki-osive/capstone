<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>Create New Tender</v-toolbar-title>
        </v-toolbar>
        <v-stepper v-model="e1" vertical>
            <v-stepper-header>
                <v-stepper-step editable :complete="e1 > 1" step="1">Enter Basic Details</v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step editable :complete="e1 > 2" step="2">Upload Documents</v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step editable step="3">Review and Submit</v-stepper-step>
            </v-stepper-header>

            <v-stepper-items>
                <v-stepper-content step="1">
                    <v-card class="mb-12" color="grey lighten-1">
                        <BasicDetailsItem ref="basicDetailsRef" />
                    </v-card>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>

                            <v-btn
                                color="success"
                                v-on:click="saveAsDraft()"
                                class="my-btn"
                            >Save Draft</v-btn>

                            <v-btn color="primary" class="my-btn" @click="e1 = 2">Continue</v-btn>

                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>

                <v-stepper-content step="2">
                    <v-card class="mb-12" color="grey lighten-1">
                        <DocumentsUploadItem ref="uploadDocumentChild" />
                    </v-card>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>

                            <v-btn color="success" class="my-btn">Save Draft</v-btn>

                            <v-btn color="primary" class="my-btn" @click="switchToTab3()">Continue</v-btn>

                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>

                <v-stepper-content step="3">
                    <v-card class="mb-12">
                        <ReviewAndSubmit ref="reviewAndSubmitComponent" />
                    </v-card>

                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>
                            <!-- 
                            <v-btn
                                color="success"
                                :to="{name: 'TenderTemplates'}"
                                class="my-btn"
                                >Save as Template</v-btn
                            >-->

                            <v-btn
                                color="success"
                                v-on:click="saveAsDraft()"
                                class="my-btn"
                            >Save Draft</v-btn>

                            <v-btn color="primary" v-on:click="submitTenderClicked()" class="my-btn">Submit</v-btn>

                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>
            </v-stepper-items>
        </v-stepper>
    </div>
</template>

<script>
import BasicDetailsItem from '@/stakeholderScreens/tenderCreator/src/stepperItems/BasicDetailsItem.vue'
import DocumentsUploadItem from '@/stakeholderScreens/tenderCreator/src/stepperItems/DocumentsUploadItem.vue'
import ReviewAndSubmit from '@/stakeholderScreens/tenderCreator/src/stepperItems/ReviewAndSubmit.vue'

export default {
    name: 'TenderCreateMain',
    components: {
        BasicDetailsItem,
        DocumentsUploadItem,
        ReviewAndSubmit,
    },
    data() {
        return {
            e1: 1,
        }
    },
    methods: {
        saveAsDraft() {

            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            let formData = new FormData();

            var filesToUpload = [];
            let coverItems = this.$refs.uploadDocumentChild.cover;
            coverItems.forEach(function(entry) {
                filesToUpload.push(entry.file);
                if (entry.sno === 1){
                    formData.append('tenderDocument', entry.file);
                }else {
                    formData.append('sorDocument', entry.file);
                }
            });

            //formData.append('files', filesToUpload[0]);

            var tenderObject = this.$refs.basicDetailsRef.input;
            tenderObject["draft"] = true;
            tenderObject["review"] = "";
            formData.append("tender",JSON.stringify(tenderObject));
            this.$api.post('/tender/uploadAndSave', formData,{
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){

                        this.$router.push({name:"DraftTendersList"});
                        this.showNotification("Success","Tender saved to draft Successfully.")
                    }else {
                        this.showNotification("Error","Failed to save Tender draft.","info")
                    }

                }, (error) => {
                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to save Tender draft.","error")
                });
        },
        switchToTab2() {
            this.e1 = 2;
            this.$refs.reviewAndSubmitComponent.populate(
                this.$refs.basicDetailsRef.input
            )
        },
        switchToTab3() {
            this.e1 = 3;
            this.$refs.reviewAndSubmitComponent.populate(
                this.$refs.basicDetailsRef.input
            )
        },
        submitTenderClicked(){

            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            let formData = new FormData();

            var filesToUpload = [];
            let coverItems = this.$refs.uploadDocumentChild.cover;
            coverItems.forEach(function(entry) {
                filesToUpload.push(entry.file);
                if (entry.sno === 1){
                    formData.append('tenderDocument', entry.file);
                }else {
                    formData.append('sorDocument', entry.file);
                }
            });

            //formData.append('files', filesToUpload[0]);

            var tenderObject = this.$refs.basicDetailsRef.input;
            tenderObject["approved"] = false;
            tenderObject["review"] = "";
            formData.append("tender",JSON.stringify(tenderObject));
            this.$api.post('/tender/uploadAndSave', formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){

                        this.$router.push({ name: 'ListOfTendersSentForApproval' });
                        this.showNotification("Success","Tender Created Successfully.")
                    }else {
                        this.showNotification("Error","Failed to create Tender.","info")
                    }

                }, (error) => {
                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to create Tender.","error")
                });
        }
    },
    computed: {},
}
</script>

<style lang="scss" scoped>
.my-btn {
    margin: 5px;
}
</style>
