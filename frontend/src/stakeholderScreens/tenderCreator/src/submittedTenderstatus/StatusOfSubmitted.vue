<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>Track Tender Status</v-toolbar-title>
        </v-toolbar>

        <v-stepper v-model="e13" vertical>
            <v-stepper-step step="1" complete>Technial Document Confirmation</v-stepper-step>

            <v-stepper-content step="1"></v-stepper-content>

            <v-stepper-step step="2" complete>Finincal Document</v-stepper-step>
            <v-stepper-content step="2"></v-stepper-content>

            <v-stepper-step step="3">Corrigendum</v-stepper-step>

            <v-stepper-content step="1">
                <v-card color="grey lighten-1" class="mb-12" height="200px"></v-card>
            </v-stepper-content>

            <v-stepper-step step="4">Need to Discuss with sir</v-stepper-step>
        </v-stepper>
    </div>
</template>

<script>
export default {
    name: 'StatusOfSubmitted',
    data() {
        return {
            e13: 3,
        }
    },
}
</script>
