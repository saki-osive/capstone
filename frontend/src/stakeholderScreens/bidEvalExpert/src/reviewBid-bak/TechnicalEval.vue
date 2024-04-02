<template>
    <div class="text-center">
        <h1 class="blue lighten-2">Technical Evaluation</h1>

        <v-container mx-12>
            <v-data-table :headers="headers" :items="covers" item-key="Weightage"></v-data-table>
        </v-container>
        <v-btn class="primary" :to="{name:'FinalcialEval'}">Next</v-btn>
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

                    Creation: 'Financial Strength',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Experience in similar class of work',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Performance on timely attaining completion',
                    Marks: '',
                },

                {
                    Weightage: '',
                    Creation: 'ISO certifications/ other accreditations',
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