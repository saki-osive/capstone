<template>
    <div class="text-center">
        <v-row>
            <v-col cols="5" align="right">Brief scope of work:</v-col>
            <v-col cols="3" align="left">{{ inputData.scopeOfWork }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Tender Reference Number and Date :</v-col>
            <v-col cols="3" align="left">{{ inputData.referenceNumber }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Tender Opening Date:</v-col>
            <v-col cols="3" align="left">{{ inputData.referenceDate }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Type of Bidding System:</v-col>
            <v-col cols="3" align="left">{{ inputData.typeOfBiddingSystem }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Tender Type:</v-col>
            <v-col cols="3" align="left">{{ inputData.type }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Form of contract:</v-col>
            <v-col cols="3" align="left">{{ inputData.formOfContract }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">No of cover:</v-col>
            <v-col cols="3" align="left">{{ inputData.numberOfCover }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Tender Category:</v-col>
            <v-col cols="3" align="left">{{ inputData.category }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Account Type Head:</v-col>
            <v-col cols="3" align="left">{{ inputData.accountTypeHead }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">No of Bid Openers:</v-col>
            <v-col cols="3" align="left">{{ inputData.numberOfBidOpeners }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Should allow re-bid Submission:</v-col>
            <v-col cols="3" align="left">{{ inputData.allowReBidSubmission }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Should allow Withdrawal of bids:</v-col>
            <v-col cols="3" align="left">{{ inputData.allowWithdrawalOfBids }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Bid Security :</v-col>
            <v-col cols="3" align="left">{{ inputData.bidSecurityEnabled }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Should Allow Offline Submission :</v-col>
            <v-col cols="3" align="left">{{ inputData.allowOfflineSubmission }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Should Allow Technical Evaluation :</v-col>
            <v-col cols="3" align="left">{{ inputData.allowTechnicalEvaluation }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Date and Time of Pre-Bid Meeting :</v-col>
            <v-col cols="3" align="left">{{ inputData.venue }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Venu of Pre-Bid Meeting :</v-col>
            <v-col
                cols="3"
                align="left"
            >{{ inputData.preBidMeetingDate }} {{ inputData.preBidMeetingTime }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Due Date and Time for Bid Submission :</v-col>
            <v-col
                cols="3"
                align="left"
            >{{ inputData.dueDateForBidSubmission }} {{ inputData.dueTimeForBidSubmission }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Date and Time of Un-Priced Bid Opening :</v-col>
            <v-col
                cols="3"
                align="left"
            >{{ inputData.unPricedBidOpeningDate}} {{ inputData.unPricedBidOpeningTime }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Contact Name :</v-col>
            <v-col cols="3" align="left">{{ inputData.contactName }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Email & Phone NO :</v-col>
            <v-col cols="3" align="left">{{ inputData.email }}, {{ inputData.phoneNumber }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Should allow Multi-currency:</v-col>
            <v-col cols="3" align="left">{{ inputData.shouldAllowMultiCurrency }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="5" align="right">Payment mode:</v-col>
            <v-col cols="3" align="left">{{ inputData.paymentMode }}</v-col>
        </v-row>
    </div>
</template>

<script>
export default {
    name: 'ReviewAndSubmit',
    data() {
        return {
            inputData: '',
        }
    },
    methods: {
        populate(input) {
            this.inputData = input
            console.log(input)
        },
    },
}
</script>

<style lang="scss" scoped></style>
