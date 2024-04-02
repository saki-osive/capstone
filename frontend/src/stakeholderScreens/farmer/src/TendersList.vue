<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <h1 class="mx-auto">Tenders</h1>
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
                
            >Active Tenders</v-btn>
        </v-row>

        <br />

        <v-data-table :headers="headers" :items="covers"  :search="search">
            <template v-slot:item.id="{ item }">
                <v-btn
                    color="blue"
                    text
                    v-on:click="onTenderIdClicked(item)"
                >{{item.id}}</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
import {TenderTableHeaders} from "../../tenderCreator/datasource/TenderTableHeaders";

export default {
    name: "TenderList",
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/tender/allTendersSentForApproval')
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
    methods:{

        onTenderIdClicked(tenderItem){
            console.log("tenderitem push");
            console.log(tenderItem);

            this.$router.push({name: 'TenderDetailsForBidder',params:{tender:tenderItem}});
        }
    },
    data() {
        return {
            search: '',
            items: ['Active Tenders', 'Inactive Tenders'],

            covers: [
                {
                    title: 'test tender for BSE ',
                    sdate: '4-12-2011',
                    time: '9:12:00',
                    tendernumber: '8456557532',
                    transtype: 'Open Tender to bid',
                },
                {
                    title: 'tender supply for d1, d2 and d3 ',

                    sdate: '9-12-2001',
                    time: '02:09:01',
                    tendernumber: '8454678532',
                    transtype: 'Open Tender to bid',
                },
                {
                    title: 'tender supply  CWEk-31/2019-20',
                    sdate: '29-12-2001',
                    time: '09:02:20',
                    tendernumber: '8456535780',
                    transtype: 'Open Tender to bid',
                },

                {
                    title: 'tender supply Moulded grating ',
                    sdate: '4-12-2011',
                    time: '09:12:20',
                    tendernumber: '8567457678',
                    transtype: 'Open Tender to bid',
                },
                {
                    title: 'tender supply for d1, d2 and d3 ',

                    sdate: '9-12-2001',
                    time: '02:09:02',
                    tendernumber: '8567756821',
                    transtype: 'Open Tender to bid',
                },
                {
                    title: 'tender supply  CWEk-31/2019-20',
                    sdate: '29-12-2001',
                    time: '19:02:22',
                    tendernumber: '80086414680',
                    transtype: 'Open Tender to bid',
                },
            ],
            headers: TenderTableHeaders.header,
        }
    },
}
</script>
