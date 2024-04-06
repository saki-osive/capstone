<template>
    <v-container app>
        <div>
            <v-toolbar class="blue lighten-2">
                <v-toolbar-title>Bidders</v-toolbar-title>
            </v-toolbar>
            <v-alert>All users status can be seen here.</v-alert>
            <v-container mx-auto>
                <v-data-table :headers="headers" :items="covers" item-key="name">
                    <template v-slot:item.review="{ item }">
                        <v-btn
                            class="blue"
                            dark
                            small
                            v-model="item.review"
                            text
                            :to="{name :'BidderDetails'}"
                        >Review</v-btn>
                    </template>
                </v-data-table>
            </v-container>
        </div>
    </v-container>
</template>

<script>
export default {
    name: 'PendingForReview',

    data() {
        return {
            covers: [
                {
                    id: '121',
                    CompanyName: 'ABC Tech ltd.',
                    UserID: 'EDRFT456',
                    date: '4-12-2011',
                },
                {
                    id: '122',
                    CompanyName: 'Wadhag International Ltd.',
                    UserID: ' RFG6H5R',
                    date: '9-12-2001',
                },
                {
                    id: '123',
                    CompanyName: 'RTB Corp. Ltd',
                    UserID: ' R5F6GTGY',
                    date: '29-12-2001',
                },
            ],
            headers: [
                {
                    text: 'Id',
                    value: 'id',
                },
                {
                    text: 'Bidder/ Company Name',
                    value: 'CompanyName',
                },
                {
                    text: 'UserID/ Employee ID',
                    value: 'UserID',
                },

                {
                    text: 'Activated Since',
                    value: 'date',
                },
                {
                    text: ' ',
                    value: 'review',
                },
            ],
        }
    },
}
</script>
