<template>
    <v-div class="text-center">
        <v-row>
            <v-col cols="4">
                <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Search"
                    single-line
                    outlined
                    hide-details
                ></v-text-field>
            </v-col>
        </v-row>

        <h1>Active Tenders</h1>
        <br />

        <v-data-table
            :headers="headers"
            :items="covers"
            item-key="name"
            :search="search"
        >
            <template v-slot:item.View="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.View"
                    text
                    :to="{ name: 'TenderDetailsView' }"
                    >View</v-btn
                >
            </template>
        </v-data-table>
    </v-div>
</template>

<script>
export default {
    name: "ActiveTendersView",
    data() {
        return {
            search: '',

            covers: [
                {
                    title: 'Notice for tender supply Moulded grating ',
                    cdate: '4-12-2011',
                    refNo: '5F5467G',
                },
                {
                    title: 'Notice for tender supply for d1, d2 and d3 ',
                    cdate: '9-12-2001',
                    refNo: 'E4E56FGT7',
                },
                {
                    title: 'Notice for tender supply  CWEk-31/2019-20',
                    cdate: '29-12-2001',
                    refNo: 'WZ4XE5CR6V',
                },

                {
                    title: 'Notice for tender supply Moulded grating ',
                    cdate: '4-12-2011',
                    refNo: 'C5R6FTG7',
                },
                {
                    title: 'Notice for tender supply for d1, d2 and d3 ',
                    cdate: '9-12-2001',
                    refNo: '5C6FG7YH',
                },
                {
                    title: 'Notice for tender supply  CWEk-31/2019-20',
                    cdate: '29-12-2001',
                    refNo: 'R5RF6GT',
                },
            ],
            headers: [
                {
                    text: 'Closing Date',
                    value: 'cdate',
                },

                {
                    text: 'Tender Subject',
                    value: 'title',
                },

                {
                    text: 'Ref. No',
                    value: 'refNo',
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
