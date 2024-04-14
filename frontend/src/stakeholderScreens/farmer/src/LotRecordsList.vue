<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <h1 class="mx-auto">Lot Records</h1>
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
        <h3 >Active Queries</h3>

        <v-row>
            <v-btn
                small
                color="blue"
                class="ml-8 mb-4"
                text
                
            >Active Lot Records</v-btn>
        </v-row>

        <br />

        <v-data-table :headers="headers" :items="covers"  :search="search">
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
    name: "LotRecordsList",
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
                loader.hide()
                console.log(error)
                this.showNotification("Error","No lot records available.","error")
            });

    },
    methods:{

        onLotIdClicked(lotItem){
            console.log("lotitem push");
            console.log(lotItem);

            this.$router.push({name: 'LotDetailsForFarmer',params:{lot:lotItem}});
        }
    },
    data() {
        return {
            search: '',
            items: ['Active Lots', 'Inactive Lots'],

            covers: [
                {
                    title: 'test lot for BSE ',
                    sdate: '4-12-2011',
                    time: '9:12:00',
                    lotnumber: '8456557532',
                    transtype: 'Open Lot to product',
                },
                {
                    title: 'lot supply for d1, d2 and d3 ',

                    sdate: '9-12-2001',
                    time: '02:09:01',
                    lotnumber: '8454678532',
                    transtype: 'Open Lot to product',
                },
                {
                    title: 'lot supply  CWEk-31/2019-20',
                    sdate: '29-12-2001',
                    time: '09:02:20',
                    lotnumber: '8456535780',
                    transtype: 'Open Lot to product',
                },

                {
                    title: 'lot supply Moulded grating ',
                    sdate: '4-12-2011',
                    time: '09:12:20',
                    lotnumber: '8567457678',
                    transtype: 'Open Lot to product',
                },
                {
                    title: 'lot supply for d1, d2 and d3 ',

                    sdate: '9-12-2001',
                    time: '02:09:02',
                    lotnumber: '8567756821',
                    transtype: 'Open Lot to product',
                },
                {
                    title: 'lot supply  CWEk-31/2019-20',
                    sdate: '29-12-2001',
                    time: '19:02:22',
                    lotnumber: '80086414680',
                    transtype: 'Open Lot to product',
                },
            ],
            headers: LotTableHeaders.header,
        }
    },
}
</script>
