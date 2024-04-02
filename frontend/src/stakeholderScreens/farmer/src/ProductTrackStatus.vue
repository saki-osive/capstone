<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Track Bid Status</v-toolbar-title>
        </v-toolbar>

        <v-stepper v-model="e13" vertical>
            <v-stepper-step step="1" complete>Successfully Uploaded Documents</v-stepper-step>

            <v-stepper-content step="1"></v-stepper-content>

                <v-stepper-step step="2" complete
                    >BID Registered</v-stepper-step
                >
                <v-stepper-content step="2"></v-stepper-content>

            <v-stepper-step step="3">Bid Confirmation: IN PROGRESS</v-stepper-step>

                <v-stepper-content step="1">
                    <v-card
                        color="grey lighten-1"
                        class="mb-12"
                        height="200px"
                    ></v-card>
                </v-stepper-content>

            <v-stepper-step step="4">Bid Reviewed by Manager</v-stepper-step>
            <v-stepper-step step="5">Bid Evaluation Result</v-stepper-step>
        </v-stepper>

        <div class="text-center">
<!--            <v-btn-->
<!--                class="red"-->
<!--                dark-->
<!--                small-->
<!--                text-->
<!--                :to="{ name: 'TenderDetailsView' }"-->
<!--                >Resubmit</v-btn-->
<!--            >-->
        </div>
    </div>
</template>

<script>
export default {
    name: "BidTrackStatus",
    data() {
        return {
            e13: 3,
        }
    },
}
</script>
