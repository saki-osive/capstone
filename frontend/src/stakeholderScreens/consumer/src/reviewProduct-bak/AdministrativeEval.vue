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
    name: 'AssignedProducts',

    data() {
        return {
            covers: [
                {
                    Weightage: '',

                    Creation: 'Validity of product',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Cost of product document',
                    Marks: '',
                },
                {
                    Weightage: '',

                    Creation: 'Product Security',
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