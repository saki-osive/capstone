<template>
    <v-container app>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Invite Bidders</v-toolbar-title>
        </v-toolbar>
        <v-dvider></v-dvider>

        <v-card>
            <v-col>
                <v-toolbar class="green lighten-3">
                    <v-toolbar-title align="center"
                        >Invite Group of Bidders
                    </v-toolbar-title>
                </v-toolbar>
            </v-col>
            <br />
            <v-col cols="8" class="mx-auto">
                <v-text-field
                    single-line
                    label="Tender Number"
                    outlined
                ></v-text-field>
            </v-col>
            <v-col cols="8" class="mx-auto">
                <v-select
                    v-model="e7"
                    :items="states"
                    outlined
                    label="Select User Group :-"
                    multiple
                    chips
                ></v-select>
            </v-col>
            <v-col cols="8" class="mx-auto">
                <v-textarea
                    outlined
                    label="Message for Bidders"
                    multiple
                    chips>
                </v-textarea>
            </v-col>
            <v-col cols="8" class="mx-auto">
                
            </v-col>
            <br />
            <v-row justify="center" class="ma-0">
                <v-btn color="blue darken-1" text>Cancel</v-btn>

                <v-btn color="blue darken-1"  text
                    >Submit</v-btn
                >
            </v-row>
            <br />
        </v-card>
    </v-container>
</template>

<script>
export default {
    name: 'InviteBidder',
    e7: [],
    states: ['Group 1'],
}
</script>

<style lang="scss" scoped></style>
