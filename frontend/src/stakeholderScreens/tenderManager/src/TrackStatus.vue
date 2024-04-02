<template>
    <div class="ma-12 pa-12">
        <v-stepper v-model="e13" vertical>
            <v-stepper-step color="green" step="1" complete>
                Successfully Uploaded Documents
            </v-stepper-step>
            <v-stepper-content step="1"></v-stepper-content>

            <v-stepper-step color="green" step="2" complete
                >Fee Confirmation</v-stepper-step
            >
            <v-stepper-content step="2"> </v-stepper-content>

            <v-stepper-step step="3">Bid Confirmation</v-stepper-step>

            <v-stepper-content step="1">
                <v-card
                    color="grey lighten-1"
                    class="mb-12"
                    height="200px"
                ></v-card>
            </v-stepper-content>

            <v-stepper-step step="4">Bid Evaluation Result</v-stepper-step>
        </v-stepper>
    </div>
</template>

<script>
export default {
    name: 'TrackStatus',
    data() {
        return {
            e13: 3,
        }
    },
}
</script>
