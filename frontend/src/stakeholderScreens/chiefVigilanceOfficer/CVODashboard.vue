<template>
    <v-container fluid>
        <v-row>
            <v-col cols="12">
                <v-row
                    align="start"
                    justify="center"
                    class="grey lighten-5"
                    style="height: 100px;"
                >
                    <v-card class="ma-3 pa-6" outlined tile
                        >120 New Bids</v-card
                    >
                    <v-card class="ma-3 pa-6" outlined tile
                        >25 Complaints</v-card
                    >
                    <v-card class="ma-3 pa-6" outlined tile
                        >4 New Tenders</v-card
                    >
                    <v-card class="ma-3 pa-6" outlined tile
                        >175 Total Tenders</v-card
                    >
                </v-row>
            </v-col>
        </v-row>

        <v-row>
            <v-col cols="12" md="6">
                <v-card flat>
                    <v-sparkline
                        :labels="labels"
                        :value="value"
                        :gradient="gradient"
                        padding="8"
                        line-width="13"
                        type="bar"
                        auto-draw
                        :show-labels="showLabels"
                        label-size="5"
                    ></v-sparkline>

                    <v-card-title class="ml-12 pl-12">
                        Pending Complaints
                    </v-card-title>
                </v-card>
            </v-col>

            <v-row>
                <v-card flat>
                    <v-row>
                        <v-col cols="12" sm="6" lg="3" class="ml-12">
                            <v-progress-circular
                                :rotate="360"
                                :size="200"
                                :width="25"
                                :value="70"
                                color="teal"
                            >
                                Complaints resolved
                            </v-progress-circular>
                        </v-col>

                        <v-col cols="12" sm="6" lg="3" class="ml-12 pl-12 ">
                            <v-progress-circular
                                :rotate="360"
                                :size="200"
                                :width="25"
                                :value="45"
                                color="red"
                            >
                                Pending Complaints
                            </v-progress-circular>
                        </v-col>
                    </v-row>
                </v-card>
            </v-row>
        </v-row>

        <v-divider></v-divider>

        <v-row>
            <v-col cols="12" md="4">
                <v-row class="fill-height" align="center">
                    <v-item-group v-model="gradient" mandatory>
                        <v-row>
                            <v-item
                                v-for="(gradient, i) in gradients"
                                :key="i"
                                :value="gradient"
                            >
                                <v-card
                                    :style="{
                                        background:
                                            gradient.length > 1
                                                ? `linear-gradient(0deg, ${gradient})`
                                                : gradient[0],
                                    }"
                                    width="0"
                                    height="0"
                                    class="mr-2"
                                ></v-card>
                            </v-item>
                        </v-row>
                    </v-item-group>
                </v-row>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
const gradients = [['red', 'orange', 'yellow']]

export default {
    name: 'CVOProfile',
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

            gradient: gradients,
            value: [2, 5, 9, 5, 10, 3, 5, 14, 10, 1, 8, 2],

            gradients,

            labels: [
                '12am',
                '3am',
                '6am',
                '9am',
                '12pm',
                '3pm',
                '6pm',
                '9pm',
                '10pm',
                '11pm',
                '12am',
                '3am',
            ],
        }
    },
}
</script>
