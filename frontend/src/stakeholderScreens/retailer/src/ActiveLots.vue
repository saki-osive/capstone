<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Active Lots</v-toolbar-title>
        </v-toolbar>

        <br />
        <br />

        <v-container mx-auto>
            <v-row>
                <v-subheader inset>LotID</v-subheader>

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
import {LotTableHeaders} from "@/datasource/LotTableHeaders";

export default {
    name: 'ActiveLots',
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/lot/approvedLots')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.covers = response.data;
                    this.showNotification("Success","Fetched all lots.")
                }else {
                    this.showNotification("Note","No lot records available.","info")
                }

            }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","No lot records available.","error")
            });
    },
    data() {
        return {
            search: '',
            covers: [
            ],
            headers: LotTableHeaders.header,
        }
    },
}
</script>
