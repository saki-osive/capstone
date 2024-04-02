<template>
    <v-div >
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Submitted Bids</v-toolbar-title>
        </v-toolbar>
 <v-div class="mx-12 px-12">
        <v-row>
            <v-col cols="4">
                <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Search"
                    single-line
                    outlined
                    hide-details
                    class="mx-12 pl-12"
                ></v-text-field>
            </v-col>
        </v-row>

        <h1 class="text-center">Tenders</h1>
        <br />

        <v-container class="mx-12">
            <v-data-table
                :headers="headers"
                :items="covers"
                item-key="name"
                :search="search"
                class="mr-12"
            >
                <template v-slot:item.View="{ item }">
                    <v-btn class="blue" dark small v-model="item.View" text
                        >View</v-btn
                    >
                </template>

                <template v-slot:item.status="{ item }">
                    <v-btn
                        class="green"
                        dark
                        small
                        v-model="item.status"
                        text
                        :to="{ name: 'BidTrackStatus' }"
                        >Track</v-btn
                    >
                </template>

                <template v-slot:item.withdraw="{ item }">
                    <v-btn
                        class="red"
                        dark
                        small
                        v-model="item.withdraw"
                        text
                        @click.stop="dialog = true"
                        >Withdraw</v-btn
                    >
                </template>
            </v-data-table>

            <v-dialog v-model="dialog" max-width="290">
                <v-card>
                    <v-toolbar-title class="blue lighten-3 pa-4"
                        >Want to withdraw this bid?</v-toolbar-title
                    >

                    <v-text-field
                        outlined
                        single-line
                        class="ma-8"
                        label="Please specify reason "
                    ></v-text-field>

                    <v-card-actions>
                        <v-spacer></v-spacer>

                        <v-btn
                            color="green darken-1"
                            text
                            @click="dialog = false"
                            >Cancel</v-btn
                        >

                        <v-btn
                            color="green darken-1"
                            text
                            @click="dialog = false"
                            >Withdraw</v-btn
                        >
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-container>

    </v-div> </v-div>
</template>

<script>
export default {
    name: "History",
    data() {
        return {
            dialog: false,
            search: '',
            items: ['Active Tenders', 'Inactive Tenders'],

            covers: [
                {
                    title: 'Notice for tender supply Moulded grating ',
                    odate: '4-12-2011',
                    cdate: '9-12-2001',
                },
                {
                    title: 'Notice for tender supply for d1, d2 and d3 ',

                    odate: '9-12-2001',
                    cdate: '29-1-2002',
                },
                {
                    title: 'Notice for tender supply  CWEk-31/2019-20',
                    odate: '29-12-2001',
                    cdate: '9-2-2002',
                },

                {
                    title: 'Notice for tender supply Moulded grating ',
                    odate: '4-12-2011',
                    cdate: '9-12-2001',
                },
                {
                    title: 'Notice for tender supply for d1, d2 and d3 ',

                    odate: '9-12-2001',
                    cdate: '29-1-2002',
                },
                {
                    title: 'Notice for tender supply  CWEk-31/2019-20',
                    odate: '29-12-2001',
                    cdate: '9-2-2002',
                },
            ],
            headers: [
                {
                    text: 'title',
                    value: 'title',
                },

                {
                    text: 'Submitted Date',
                    value: 'odate',
                },
                {
                    text: 'Technical and Financial details',
                    value: 'View',
                },
                {
                    text: 'Track status',
                    value: 'status',
                },
                {
                    text: 'Withdraw Bid',
                    value: 'withdraw',
                },
            ],
        }
    },
}
</script>
