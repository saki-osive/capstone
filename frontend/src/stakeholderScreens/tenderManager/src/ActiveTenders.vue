<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Active Tenders</v-toolbar-title>
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
            ></v-data-table>
        </v-container>
    </div>
</template>

<script>
import {TenderTableHeaders} from "../../tenderCreator/datasource/TenderTableHeaders";

export default {
    name: 'ViewAll',
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
            search: '',
            covers: [
            ],
            headers: TenderTableHeaders.header,
        }
    },
}
</script>
