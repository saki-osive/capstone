<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Bidders</v-toolbar-title>
        </v-toolbar>
        <v-alert>All users status can be seen here.</v-alert>
        <v-container mx-auto>
            <v-data-table :headers="headers" :items="covers" item-key="name">
                <template v-slot:item.active="{ item }">
                    <v-checkbox small v-model="item.active"></v-checkbox>
                </template>
                <template v-slot:item.edit="{ item }">
                    <v-btn small v-model="item.edit" icon>
                        <v-icon>fa-pen</v-icon>
                    </v-btn>
                </template>
                <template v-slot:item.delete="{ item }">
                    <v-btn small v-model="item.delete" icon>
                        <v-icon>fa-times-circle</v-icon>
                    </v-btn>
                </template>
            </v-data-table>
        </v-container>
    </div>
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
                    text: 'id',
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
                    text: 'Active',
                    value: 'active',
                },
                {
                    text: 'Activated Since',
                    value: 'date',
                },
                {
                    text: 'Edit',
                    value: 'edit',
                },
                {
                    text: ' ',
                    value: 'delete',
                },
            ],
        }
    },
}
</script>
