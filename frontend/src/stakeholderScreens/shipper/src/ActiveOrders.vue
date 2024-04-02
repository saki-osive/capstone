<template>
    <div>
        <v-div class="text-center">
            <v-row>
                <v-col cols="4">
                    <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Search"
                        single-line
                        outlined
                        hide-details
                    ></v-text-field>
                </v-col>
            </v-row>

            <h1>Active Orders</h1>
            <br />

            <v-data-table :headers="headers" :items="covers" item-key="name" :search="search">
                <template v-slot:item.View="{ item }">
                    <v-btn class="blue" dark small v-model="item.View" text :to="{ name: 'ShippingOrderDetails' }">View</v-btn>
                </template>

                
            </v-data-table>
        </v-div>
        
    </div>
</template>

<script>
export default {
    name: 'Active Orders',

    data() {
        return {
            search: '',

            covers: [
                {
                    title: 'Tender supply Moulded grating ',
                    submissionDate: '4-12-2011',
                    bidderID: '5F5467G',
                    deliveryID: '3224',
                    carrierID: '767',
                    tenderID: '8754323567',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Delhi",
                
                },
                {
                    title: 'Tender supply for d1, d2 and d3 ',
                    submissionDate: '9-12-2001',
                    bidderID: 'E4E56F7',
                    deliveryID: '2416',
                    carrierID: '654',
                    tenderID: '843356895',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Noida",
                },
                {
                    title: 'Tender supply  CWEk-31/2019-20',
                    submissionDate: '29-12-2001',
                    bidderID: 'WZ4XE6V',
                    deliveryID: '8623',
                    carrierID: '753',
                    tenderID: '8643476543',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Delhi",
                },

                {
                    title: 'Tender supply Moulded grating ',
                    submissionDate: '4-12-2011',
                    bidderID: 'C5R6FTG7',
                    deliveryID: '1257',
                    carrierID: '564',
                    tenderID: '8654322340',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Nainderpur",
                },
                {
                    title: 'Tender supply for d1, d2 and d3 ',
                    submissionDate: '9-12-2001',
                    bidderID: '5C6FG7YH',
                    deliveryID: '3689',
                    carrierID: '754',
                    tenderID: '8754324689',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Sonipat",
                },
                {
                    title: 'Tender supply  CWEk-31/2019-20',
                    submissionDate: '29-12-2001',
                    bidderID: 'R5RF6GT',
                    deliveryID: '6754',
                    carrierID: '752',
                    tenderID: '8754314578',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Narela",
                },
            ],
            headers: [
                {
                    text: 'Delivery ID',
                    value: 'deliveryID',
                },

                {
                    text: 'Tender ID',
                    value: 'tenderID',
                },

{
                    text: 'Pickup location',
                    value: 'PickupLocation',
                },
{
                    text: 'Delivery location',
                    value: 'DeliveryLocation',
                },


                {
                    text: 'Submission Date',
                    value: 'submissionDate',
                },
             

                {
                    text: 'Title',
                    value: 'title',
                },

                {
                    text: 'Bidder ID',
                    value: 'bidderID',
                },
                {
                    text: ' ',
                    value: 'View',
                },
               
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>