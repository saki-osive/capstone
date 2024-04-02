<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>Draft Tenders</v-toolbar-title>
        </v-toolbar>
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
        <v-data-table :headers="headers" :items="draftTendersItem" item-key="name" :search="search">
            <template v-slot:item.continue="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.continue"
                    text
                    :to="{name: 'CreateTender'}"
                >Continue</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
import {TenderTableHeaders} from "../datasource/TenderTableHeaders";

export default {
    name: 'DraftTendersList',
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/tender/allDraftTenders')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.draftTendersItem = response.data;
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
            draftTendersItem: [

            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>