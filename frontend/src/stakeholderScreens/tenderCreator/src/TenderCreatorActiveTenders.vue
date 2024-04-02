<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>My Active Tenders</v-toolbar-title>
        </v-toolbar>
        <v-row>
            <v-col>
                <h3 style="color:#0099FF" align="left">Search</h3>
                <v-progress-linear
                    background-color="#0099FF"
                    color="#0099FF"
                    value="45"
                ></v-progress-linear>
            </v-col>
        </v-row>
        <v-row>
            <v-col cols>
                <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Enter Tender Number or Tender Name"
                    solo
                    hide-details
                ></v-text-field>
            </v-col>
        </v-row>
        <br />
        <v-data-table
            :headers="headers"
            :items="covers"
            item-key="name"
            :search="search"
        >
            <template v-slot:item.tenderNumber="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.tenderNumber"
                    text
                    v-on:click="onTenderOnClicked()"
                    >{{ item.tenderNumber }}</v-btn
                >
            </template>
        </v-data-table>
        <TenderDialog ref="tenderDialog" />
    </div>
</template>

<script>
import TenderDialog from '@/dashboard/layout/TenderDialog.vue'
import {TenderTableHeaders} from "../datasource/TenderTableHeaders";
export default {
    name: 'TenderCreatorActiveTenders',
    methods: {
        onTenderOnClicked() {
            this.$refs.tenderDialog.show2()
        },
    },
    components: {
        TenderDialog,
    },
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/tender/approvedTenders')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.covers = response.data;
                    this.showNotification("Success","Fetched all tenders.")
                }else {
                    this.showNotification("Note","No tenders available.","info")
                }

            }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","No tenders available.","error")
            });
    },
    data() {
        return {
            dialog: false,
            search: '',
            headers: TenderTableHeaders.header,
            covers: [
                {
                    tenderNumber: 8000078451,
                    tenderName: 'Supply, Installation of MG Anodes',
                    transType: 'Open Tender 2 Bid',
                    submissionDate: '14.02.2020',
                    submissionTime: '15:00:55',
                    startDate: '20:03:2020',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
