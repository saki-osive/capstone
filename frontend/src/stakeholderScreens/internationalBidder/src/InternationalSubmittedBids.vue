<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Select Bid</v-toolbar-title>
        </v-toolbar>
        <v-data-table
            :headers="headers"
            :items="submittedTendersList"
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
                    :to="{name: 'BidTrackStatus'}"
                >View</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
export default {
    name: 'InternationalSubmittedBids',
    data() {
        return {
            headers: [
                {
                    text: 'Bid Id',
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
                    text: 'Submission Date',
                    value: 'submissionDate',
                },
                {
                    text: 'Submission Time',
                    value: 'submissionTime',
                },
                {
                    text: '',
                    value: 'view',
                },
            ],
            submittedTendersList: [
                {
                    bidId: 8541256326,
                    tenderName: 'Assorted Valves SAPL Project',
                    transType: 'Open Tender 2 Bid',
                    submissionDate: '18.02.2020',
                    submissionTime: '13:00:00',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>