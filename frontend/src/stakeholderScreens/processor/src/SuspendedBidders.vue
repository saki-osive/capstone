<template>
    <v-container app>
        <div>
            <v-toolbar class="blue lighten-2">
                <v-toolbar-title>Bidders</v-toolbar-title>
            </v-toolbar>
            <v-alert>All users status can be seen here.</v-alert>
            <v-container mx-auto>
                <v-data-table :headers="headers" :items="covers" item-key="name">
                
                

                 <template v-slot:item.edit="{ item }">
                    <v-btn small v-model="item.edit" class="green" dark> Unsuspend</v-btn>
                </template>
                
                
                
                </v-data-table>
            </v-container>
        </div>
    </v-container>
</template>

<script>
export default {
    name: 'ViewAll',

    data() {
        return {
            covers: [
                {
                    id: '121',
                    CompanyName: 'ABC Tech ltd.',
                    UserID: 'EDRFT456',
                    date: '4-12-2011',
                    review: 'Suspended',
                },
                {
                    id: '122',
                    CompanyName: 'Wadhag International Ltd.',
                    UserID: ' RFG6H5R',
                    date: '9-12-2001',
                    review: 'Suspended',
                },
                {
                    id: '123',
                    CompanyName: 'RTB Corp. Ltd',
                    UserID: ' R5F6GTGY',
                    date: '29-12-2001',
                    review: 'Suspended',
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
                 {
                    text: ' ',
                    value: 'edit',
                },
            ],
        }
    },
}
</script>
