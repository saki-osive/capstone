<template>
    <div>
         <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Select Bid</v-toolbar-title>
        </v-toolbar>
        <v-data-table
            :headers="headers"
            :items="covers"
            item-key="name"
            :search="search"
        >
            <template v-slot:item.view="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.view"
                    text
                    :to="{name: 'ProductDeliveryStatus'}"
                >View Status</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
    export default {
        name: 'StatusOfFreight',
        data() {
        return {
            headers: [
                {
                    text: 'Bidder Id',
                    value: 'bidId',
                },
                {
                    text: 'Tender Name',
                    value: 'tenderName',
                },
                {
                    text: 'Trans Type',
                    value: 'transType',
                },
                {
                    text: 'Delivery Date',
                    value: 'submissionDate',
                },
                {
                    text: 'Track Status',
                    value: 'view',
                },
            ],
            covers: [
                {
                    bidId: 8541256326,
                    tenderName: 'Assorted Valves SAPL Project',
                    transType: 'Open Tender 2 Bid',
                    submissionDate: '18.02.2020',
                },
            ],
        }
    },
    }
</script>

<style lang="scss" scoped>

</style>