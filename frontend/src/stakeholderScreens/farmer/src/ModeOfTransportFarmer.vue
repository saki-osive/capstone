<template>
    <div>
        <v-card class="mx-auto" outlined>
            <v-card-title class="justify-center">
                Choose Mode of Transport
            </v-card-title>
            <v-card-actions>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Provide Mode of Transport
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-select
                            label="-select-"
                            :items="modeOfTransport"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
            </v-card-actions>
            <v-row>
                <v-col>
                    <v-subheader>
                        Acknowledgment of the receipt of goods that are to be
                        shipped.
                        <span class="red--text">*</span>
                    </v-subheader>
                </v-col>
            </v-row>
            <v-row>
                <v-col class="my-2" justify="center" align="center">
                    <v-btn
                        @click="snackbar = true"
                        :to="{ name: 'ModeOfTransportFarmer' }"
                    >
                        Submit
                    </v-btn>
                </v-col>
            </v-row>
        </v-card>
        <v-snackbar v-model="snackbar" color="green"
            >Congratulations! You have Successfully Created the Lot Record</v-snackbar
        >
    </div>
</template>

<script>
export default {
    name: 'ModeOfTransportFarmer',
    data() {
        return {
            modeOfTransport: [
              'Air Freight',
              'Water Transport (Ships)',
              'Land Transport (including Railways or By Road Trucks)',
            ],
            snackbar: false,
        }
    },
}
</script>

<style lang="scss" scoped></style>
