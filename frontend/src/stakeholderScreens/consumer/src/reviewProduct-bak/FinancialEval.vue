<template>
    <div class="text-center">
        <h1 class="blue lighten-2">Financial Evaluation</h1>

        <v-container mx-12>
            <v-data-table :headers="headers" :items="covers" item-key="Weightage"></v-data-table>
        </v-container>
        <v-btn class="primary" :to="{name : 'PerformanceProductEval'}">Next</v-btn>
    </div>
</template>

<script>
export default {
    name: 'AssignedProducts',

    data() {
        return {
            covers: [
                {
                    Weightage: '',

                    Creation: 'Evaluation Product Price',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Document submitted',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Original document applicable',
                    Marks: '',
                },

                {
                    Weightage: '',
                    Creation: 'Commercial Responsiveness',
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