<template>
    <div class="text-center">
        <h1 class="blue lighten-2">Administrative Evaluation</h1>

        <v-container mx-12>
            <v-data-table :headers="headers" :items="covers" item-key="Weightage"></v-data-table>
        </v-container>
        <v-btn class="primary" :to="{name : 'TechnicalEval'}">Next</v-btn>
    </div>
</template>

<script>
export default {
    name: 'AssignedBids',

    data() {
        return {
            covers: [
                {
                    Weightage: '',

                    Creation: 'Validity of bid',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Cost of bid document',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Bid Security',
                    Marks: '',
                },

                {
                    Weightage: '',
                    Creation: 'Letter of authorization',
                    Marks: '',
                },
            ],
            headers: [
                {
                    text: 'Creation',
                    value: 'Creation',
                },
                {
                    text: 'Weightage',
                    value: 'Weightage',
                },

                {
                    text: 'Grade Marks',
                    value: 'Marks',
                },
            ],
        }
    },
}
</script>

<style>
.pre-formatted {
    white-space: pre;
}
</style>