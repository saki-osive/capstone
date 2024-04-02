<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>Submitted Tenders</v-toolbar-title>
        </v-toolbar>
        <v-row>
            <v-col cols="5">
                <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Enter Tender Number or Tender Name"
                    solo
                    hide-details
                ></v-text-field>
            </v-col>
        </v-row>
        <v-data-table
            :headers="headers"
            :items="statusOfSubmittedList"
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
                    :to="{name: 'StatusOfSubmitted'}"
                >View Tender Status</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
import {TenderTableHeaders} from "../../datasource/TenderTableHeaders";

export default {
    name: 'SubmittedBids',
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/tender/allTendersSentForApproval', this.input)
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.statusOfSubmittedList = response.data;
                    this.showNotification("Success","Fetched all tenders.")
                }else {
                    this.showNotification("Note","No tenders available.","info")
                }

            }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","Failed to register user.","error")
            });
    },
    methods:{

    },
    data() {
        return {
            search: '',
            headers: TenderTableHeaders.header,
            statusOfSubmittedList: [
                {
                    id: 8541256326,
                    scopeOfWork: 'Assorted Valves SAPL Project',
                    type: 'Open Tender 2 Bid',
                    referenceDate: '18.02.2020',
                    typeOfBiddingSystem: 'single',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>