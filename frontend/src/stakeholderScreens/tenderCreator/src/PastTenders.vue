<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>Closed Tenders</v-toolbar-title>
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
            <v-col cols="6">
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
            <template v-slot:item.republish="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.republish"
                    text
                    :to="{ name: 'CreateTender' }"
                    >Republish</v-btn
                >
            </template>
        </v-data-table>
    </div>
</template>
<script>
import {TenderTableHeaders} from "../datasource/TenderTableHeaders";

export default {
    name: 'ClosedTenders',
    mounted() {
        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/tender/pastTenders')
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
            search: '',
            headers: TenderTableHeaders.header,
            covers: [
                {
                    tenderNumber: 8000078451,
                    tenderName: 'Supply, Installation of MG Anodes',
                    transType: 'Open Tender 2 Bid',
                    submissionDate: '14.02.2020',
                    closedDate: '14.05.2020',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
