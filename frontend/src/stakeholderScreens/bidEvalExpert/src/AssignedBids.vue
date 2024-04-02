<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Assigned Bids</v-toolbar-title>
        </v-toolbar>
        <br />
        <v-data-table :headers="headers" :items="covers" item-key="name">
            <template v-slot:item.technicalEval="{ item }">
                <v-btn
                    small
                    v-model="item.technicalEval"
                    text
                    color="blue"
                    outlined
                    :class="item.class"
                    :to="{name: 'ReviewTechnicalBid'}"
                >Technical Evaluation</v-btn>
            </template>
            <template v-slot:item.financialEval="{ item }">
                <v-btn
                    small
                    v-model="item.technicalEval"
                    text
                    color="blue"
                    outlined
                    :to="{name: 'ReviewFinancialBid'}"
                >Financial Eval</v-btn>
            </template>
        </v-data-table>
    </div>
</template>


<script>
export default {
  name: "AssignedBids",

    data() {
        return {
            covers: [
                {
                    bidId: '78657579',
                    tenderId: '8976786756',
                    tenderName:
                        ' HIRING OF PROJECT MANAGEMENT CONSULTANCY SERVICES',
                    submissionDate: '20.02.2020 12:52:00',
                },
            ],
            headers: [
                {
                    text: 'Bid ID',
                    value: 'bidId',
                },
                {
                    text: 'Tender Id',
                    value: 'tenderId',
                },

                {
                    text: 'Tender Name',
                    value: 'tenderName',
                },

                {
                    text: 'Submission Date',
                    value: 'submissionDate',
                },

                {
                    text: 'Technical Eval',
                    value: 'technicalEval',
                },
                {
                    text: 'Financial Eval',
                    value: 'financialEval',
                },
            ],
        }
     
    
   
  }
};
</script>

<style>
.pre-formatted {
  white-space: pre;
}
</style>