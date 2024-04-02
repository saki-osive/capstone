<template>
    <div>
        <v-toolbar class="blue lighten-3">
            <v-icon class="mx-auto">fa-comments</v-icon>
            <h1 class="mx-auto">Complaints</h1>
            <v-icon class="mx-auto">fa-comments</v-icon>
        </v-toolbar>

        <br />
        <br />

        <v-container mx-auto>
            <v-row>
                <v-subheader inset>TenderID</v-subheader>

                <v-col cols="4" class="my-0 py-0">
                    <v-text-field
                        v-model="search"
                        clearable
                        flat
                        solo-inverted
                        hide-details
                        prepend-inner-icon="fa-search"
                        label="Search"
                    ></v-text-field>
                </v-col>
            </v-row>
            <br />
            <v-data-table
                :headers="headers"
                :items="covers"
                item-key="id"
                :search="search"
                class="mx-12"
            >
                <template v-slot:item.status="{ item }">
                    <v-btn
                        dark
                        :class="item.class"
                        outlined
                        small
                        v-model="item.status"
                        text
                    >{{item.status}}</v-btn>
                </template>

                <template v-slot:item.View="{ item }">
                    <v-btn
                        class="blue"
                        dark
                        small
                        v-model="item.View"
                        text
                        to="ComplaintDetail"
                    >ViewDetails</v-btn>
                </template>
            </v-data-table>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'Complaints',

    data() {
        return {
            search: '',
            covers: [
                {
                    id: '121',
                    refNo: '234567',
                    description: 'Office supply',
                    odate: '4-12-2011',
                    cdate: '29-12-2011',
                    category: 'supplier',
                    title: 'Unbiased choice',
                    status: 'Closed',
                    class: 'grey',
                },
                {
                    id: '122',
                    refNo: '876543',

                    description: ' procure medicine',
                    odate: '9-12-2001',
                    cdate: '9-1-2002',
                    category: 'IT',
                    title: 'Best Quality Rejected',
                    status: 'Closed',
                    class: 'grey',
                },
                {
                    id: '123',
                    refNo: '23456576',

                    description: ' event management',
                    odate: '29-12-2001',
                    cdate: '9-1-2002',
                    category: 'SDF',
                    title: 'No payment made',
                    status: 'Open',
                    class: 'yellow',
                },
            ],
            headers: [
                {
                    text: 'Complaint Id',
                    value: 'id',
                },

                {
                    text: 'Title',
                    value: 'title',
                },
                {
                    text: 'Tender Reference No',
                    value: 'refNo',
                },

                {
                    text: 'Complaint Date',
                    value: 'cdate',
                },

                {
                    text: 'Status',
                    value: 'status',
                },

                {
                    text: 'Work Category',
                    value: 'category',
                },

                {
                    text: ' ',
                    value: 'View',
                },
            ],
        }
    },
}
</script>