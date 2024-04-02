<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Reveiw User Details</v-toolbar-title>
        </v-toolbar>
        <br />
        <v-stepper v-model="e1">
            <v-stepper-header>
                <v-stepper-step editable :complete="e1 > 1" step="1">Basic Details</v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step editable :complete="e1 > 2" step="2">Documents Verification</v-stepper-step>

                <v-divider></v-divider>

                <v-stepper-step editable step="3">Review and Submit</v-stepper-step>
            </v-stepper-header>

            <v-stepper-items>
                <v-stepper-content step="1">
                    <v-card class="mb-12" flat>
                        <UserBasicDetails />
                    </v-card>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>
                            <v-btn color="success" class="my-btn">Save Draft</v-btn>

                            <v-btn color="primary" class="my-btn" @click="e1 = 2">Continue</v-btn>

                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>

                <v-stepper-content step="2">
                    <v-card class="mb-12" flat>
                        <ReviewDocuments />
                    </v-card>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>

                            <v-btn color="success" class="my-btn">Save Draft</v-btn>

                            <v-btn color="primary" class="my-btn" @click="e1 = 3">Continue</v-btn>

                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>

                <v-stepper-content step="3">
                    <v-card class="mb-12" color="grey lighten-1" height="200px"></v-card>
                    <v-divider></v-divider>
                    <v-card flat>
                        <v-row>
                            <v-spacer></v-spacer>

                            <v-btn color="success" class="my-btn">Save Draft</v-btn>

                            <v-dialog v-model="dialog" max-width="290">
                                <template v-slot:activator="{ on, attrs }">
                                    <v-btn
                                        color="primary"
                                        class="my-btn"
                                        @click="dialog = true"
                                        dark
                                        v-bind="attrs"
                                        v-on="on"
                                    >Submit Evaluation</v-btn>
                                </template>
                                <v-card class="text-center" style="top: 50%;" height="100">
                                    User Sucessfully Registered and notified via email
                                    <br />
                                    <strong>Registration RefID: {{ refRegistrationID }}</strong>
                                </v-card>
                            </v-dialog>

                            <v-btn text class="my-btn">Cancel</v-btn>
                        </v-row>
                    </v-card>
                </v-stepper-content>
            </v-stepper-items>
        </v-stepper>
    </div>
</template>

<script>
import UserBasicDetails from '@/stakeholderScreens/onBoarding/user/reviewUserStepperItems/UserBasicDetails.vue'
import ReviewDocuments from '@/stakeholderScreens/onBoarding/user/reviewUserStepperItems/ReviewDocuments.vue'

export default {
    name: 'ReviewUser',
    components: {
        UserBasicDetails,
        ReviewDocuments,
    },
    data() {
        return {
            e1: 1,
            refRegistrationID: 'HGFH7886VG',
        }
    },
}
</script>

<style lang="scss" scoped>
.my-btn {
    margin: 10px;
}
</style>