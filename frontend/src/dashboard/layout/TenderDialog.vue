<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" scrollable width="600px">
            <v-card>
                <v-card-title>Tender Details</v-card-title>
                <v-divider></v-divider>
                <v-card-text style="height: 300px;">
                    <div class="text-left">
                        <v-row>
                            <v-col cols="6">Brief scope of work:</v-col>
                            <v-col cols="3" >{{ briefScopeOfWork }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6"
                                >Tender Reference Number and Date :</v-col
                            >
                            <v-col cols="3">{{
                                tenderReferenceNumberAndDate
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Tender Opening Date:</v-col>
                            <v-col cols="3">{{ tenderOpeningDate }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Type of Bidding System:</v-col>
                            <v-col cols="3">{{ typeOfBiddingSystem }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Tender Type:</v-col>
                            <v-col cols="3">{{ tenderType }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Form of contract:</v-col>
                            <v-col cols="3">{{ formOfContract }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">No of cover:</v-col>
                            <v-col cols="3">{{ noOfCover }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Tender Category:</v-col>
                            <v-col cols="3">{{ tenderCategory }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Account Type Head:</v-col>
                            <v-col cols="3">{{ accountTypeHead }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">No of Bid Openers:</v-col>
                            <v-col cols="3">{{ noOfBidOpeners }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6"
                                >Should Allow Offline Submission :</v-col
                            >
                            <v-col cols="3">{{
                                shouldAllowOfflineSubmission
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6"
                                >Should Allow Technical Evaluation :</v-col
                            >
                            <v-col cols="3">{{
                                shouldAllowTechnicalEvaluation
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6"
                                >Date, Time & Venu of Pre-Bid Meeting :</v-col
                            >
                            <v-col cols="3">{{
                                dateTimeVenuOfPreBidMeeting
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6"
                                >Due Date and Time for Bid Submission :</v-col
                            >
                            <v-col cols="3">{{
                                dueDateAndTimeForBidSubmission
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6"
                                >Date & Time of Un-Priced Bid Opening :</v-col
                            >
                            <v-col cols="3">{{
                                dateAndTimeUnPricedBidOpening
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Contact Name :</v-col>
                            <v-col cols="3">{{ contactName }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Email & Phone NO :</v-col>
                            <v-col cols="3">{{ emailPhoneNO }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Should allow Multi-currency:</v-col>
                            <v-col cols="3">{{
                                shouldAllowMultiCurrency
                            }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Payment mode:</v-col>
                            <v-col cols="3">{{ paymentMode }}</v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="6">Added Document:</v-col>
                            <v-col cols="3">{{ addedDocument }}</v-col>
                        </v-row>
                    </div>
                </v-card-text>
                <v-divider></v-divider>
                <v-card-actions>
                    <v-btn color="blue darken-1" @click="dialog = false" text>Close</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>
</template>
<script>
export default {
    name: 'TenderDialog',
    methods: {
        show2() {
            this.dialog = true
        },
    },
    data() {
        return {
            dialog: false,

            briefScopeOfWork: '',
            tenderReferenceNumberAndDate: '',
            tenderOpeningDate: '',
            typeOfBiddingSystem: '',
            tenderType: '',
            formOfContract: '',
            noOfCover: '',
            tenderCategory: '',
            accountTypeHead: '',
            noOfBidOpeners: '',
            shouldAllowOfflineSubmission: '',
            shouldAllowTechnicalEvaluation: '',
            dateTimeVenuOfPreBidMeeting: '',
            dueDateAndTimeForBidSubmission: '',
            dateAndTimeUnPricedBidOpening: '',
            contactName: '',
            emailPhoneNO: '',
            shouldAllowMultiCurrency: '',
            paymentMode: '',
            addedDocument: '',
        }
    },
}
</script>
