<template>
    <div>
        <v-card flat>
            <v-div class="text-center">
                <h1>Order Details</h1>
            </v-div>
            <br />
            <br />

            <v-container class="pl-16 ml-16">
                <pre>OrderID             :      {{OrderID}}<br />Delivery ID         :      {{deliveryID}} <br />Pickup Location     :      {{PickupLocation}}  <br/>Bidder ID           :      {{bidderID}} <br />Title               :      {{title}} <br />Submission Date     :      {{submissionDate}} <br />Delivery Location   :      {{DeliveryLocation}} <br />Telephone(Office)   :      0116774755 <br />Mobile Number       :      9867545723 <br />
          
          </pre>
            </v-container>

            <br />
            <br />
                        <div><v-btn class="blue" dark small >Print associated packing slip</v-btn> <v-btn class="green ml-4" dark small :to="{name:'OrderStatus'}" >Track Status</v-btn> <v-btn class="yellow ml-4" dark small  @click.stop="statusdialog = true">Update status</v-btn><v-btn class="purple ml-4" dark small  @click.stop="notifydialog = true" >Notify</v-btn></div>
  <v-dialog
      v-model="statusdialog"
      max-width="290"
    >
      <v-card>
        <v-card-title class="headline">Update Status</v-card-title>
        <v-col cols="8" class="mx-auto">
        <v-select :items="statusoptions" outlined label="Select Status"/>
                <v-btn class="blue" dark @click.stop="statusdialog = false">Update</v-btn>

        </v-col>
      </v-card>



  </v-dialog>
    <v-dialog
      v-model="notifydialog"
      max-width="290"
    >
      <v-card>
        <v-card-title class="headline">Notify</v-card-title>

         <v-col cols="8" class="ma-auto">
        <v-select :items="notifyoptions" outlined label="Send to: "/>
        <v-textarea single-line label="Message"/>
        <v-btn class="blue" dark @click.stop="statusdialog = false">Send</v-btn>
        </v-col>
      </v-card>
    </v-dialog>





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
                    notifydialog:false,
                    statusdialog:false,
                    statusoptions:["active","cancelled"],
                    notifyoptions:["order-sender","order-receiver"]




        }
    }





}
</script>>