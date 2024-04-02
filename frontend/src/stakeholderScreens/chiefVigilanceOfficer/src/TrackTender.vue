<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Track the Status</v-toolbar-title>
        </v-toolbar>
        <div class="ma-12 pa-12">
            <v-stepper v-model="e13" vertical>
                <v-stepper-step step="1" complete>Tender published on 12-3-2019</v-stepper-step>

                <v-stepper-content step="1"></v-stepper-content>

                <v-stepper-step step="2" complete>11 Bidders showed interest till 18-3-2019</v-stepper-step>
                <v-stepper-content step="2"></v-stepper-content>

                <v-stepper-step step="3">Bid ID: 223 was approved</v-stepper-step>

                <v-stepper-content step="1">
                    <v-card color="grey lighten-1" class="mb-12" height="200px"></v-card>
                </v-stepper-content>

                <v-stepper-step step="4">Waiting for confirmation from Bidder</v-stepper-step>
            </v-stepper>
        </div>

        <div class="text-center">
            <v-btn small to="ComplaintDetail">Back</v-btn>
        </div>
    </div>
</template>

<script>
export default {
    name: "TrackTender",
    data() {
        return {
            e13: 3,
        }
    },
}
</script>