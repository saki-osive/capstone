<template>
    <v-img src="@/assets/graphbg2.gif">
        <v-container fluid>
            <v-row>
                <v-col cols="12">
                    <v-row :align="alignment" :justify="justify" class="grey lighten-5">
                        <v-card class="mr-12 pa-6" tile>
                            <v-img
                                src="@/assets/graph1.gif"
                                height="100"
                                width="100"
                                class="ml-12 pl-12"
                            />

                            <v-btn text class="py-8" :to="{name :'ScoredResponses'}">
                                Monitor Scored responses
                                <br />from experts
                            </v-btn>
                        </v-card>

                        <v-card class="ma-3 pa-6" tile>
                            <v-img
                                src="@/assets/graph.gif"
                                height="100"
                                width="100"
                                class="ml-12 pl-12"
                            />

                            <v-btn
                                text
                                class="py-8"
                                :to="{name : 'ResultSummary'}"
                            >See result Summary</v-btn>
                        </v-card>
                    </v-row>

                    <v-row>
                        <v-card class="mx-auto pa-6" tile>
                            <v-img
                                src="@/assets/graph2.gif"
                                height="100"
                                width="100"
                                class="mx-auto pa-6"
                            />

                            <v-btn
                                text
                                class="py-8"
                                :to="{name: 'EvaluationReport'}"
                            >Evaluation Report</v-btn>
                        </v-card>
                    </v-row>
                </v-col>
            </v-row>
        </v-container>
    </v-img>
</template>

<script>
export default {
    data() {
        return {
            alignmentsAvailable: [
                'start',
                'center',
                'end',
                'baseline',
                'stretch',
            ],
            alignment: 'center',
            dense: false,
            justifyAvailable: [
                'start',
                'center',
                'end',
                'space-around',
                'space-between',
            ],
            justify: 'center',
        }
    },
}
</script>