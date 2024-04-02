<template>
    <div>
        <v-card flat>
            <v-div class="text-center">
                <h1>Order Details</h1>
            </v-div>
            <br />
            <br />

            <v-container class="pl-16 ml-16">
            <pre>OrderID            :           {{OrderID}}<br />Delivery ID        :           {{deliveryID}} <br />Pickup Location    :           {{PickupLocation}}  <br/>Bidder ID          :           {{bidderID}} <br />Title              :      {{title}} <br />Submission Date    :      {{submissionDate}} <br />Delivery Location  :      {{DeliveryLocation}} <br />Telephone(Office)  :      0116774755 <br />Mobile Number      :      9867545723 <br />
          
          </pre>
            </v-container>

            <br />
            <br />

            <div><v-btn class="green" dark small :to="{name:'ActiveOrders'}">Accept</v-btn> <v-btn class="red" dark small :to="{name:'NewOrders'}" >Reject</v-btn></div>
        </v-card>
    </div>
</template>

<script>
export default {
    data(){
        return{
        OrderID:"123",
 title: 'Tender supply Moulded grating ',
                    submissionDate: '4-12-2011',
                    bidderID: '5F5467G',
                    deliveryID: '3224',
                    orderID: '767',
                    tenderID: '8754323567',
                    PickupLocation: "Gorakhpur",
                    DeliveryLocation:"Delhi",



        }
    }





}
</script>>