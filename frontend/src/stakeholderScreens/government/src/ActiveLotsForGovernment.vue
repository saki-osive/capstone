<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title >Active Lots</v-toolbar-title>
        </v-toolbar>
        <v-row>
            <v-col>
                <h3 style="color:#3498DB" >Search</h3>

                <v-progress-linear color="#3498DB" rounded value="100" max-width="10"></v-progress-linear>
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="4">
                <v-text-field 
                    v-model="search"
                    append-icon="mdi-magnify"
                    single-line
                    outlined
                    hide-details
                ></v-text-field>
            </v-col>
        </v-row>
      

     
        <br />

        <v-data-table :headers="headers" :items="covers" :search="search">
            <template v-slot:item.id="{ item }">
                <v-btn
                        color="blue"
                        text
                        v-on:click="onLotIdClicked(item)"
                >{{item.id}}</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
import {LotTableHeaders} from "@/datasource/LotTableHeaders";

export default {
    name: "ActiveLotsForGovernment",
    methods:{

        onLotIdClicked(item){
            console.log(item)

        }
    },
    mounted() {
        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/lot/allLotsSentForApproval')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.covers = response.data;
                    this.showNotification("Success","Fetched all lots.")
                }else {
                    this.showNotification("Note","No lot records available.","info")
                }

            }, (error) => {
                loader.hide();
                console.log(error);
                this.showNotification("Error","No lot records available.","error")
            });
    },
    data() {
        return {
            search: '',
            items: ['Active Lots', 'Inactive Lots'],

            covers: [

            ],
            headers: LotTableHeaders.header,
        }
    },
}
</script>
