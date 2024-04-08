<template>
  <div>
    <v-toolbar flat class=" blue ma-0 pa-0">
      <v-toolbar-title>Track the Lot Product </v-toolbar-title>
    </v-toolbar>
    <v-card flat class="mx-12 my-4 ">

      <v-row>
        <v-card-actions>
          <StreamBarcodeReader @decode="onDecode" @loaded="onLoaded"></StreamBarcodeReader>
        </v-card-actions>
      </v-row>

      <v-row>
        <v-card-actions>
          <ImageBarcodeReader @decode="onDecode" @error="onError"></ImageBarcodeReader>
        </v-card-actions>
      </v-row>

      <v-row>
        <v-card-actions>
          <p>
            <strong>The decoded value in QR/barcode is:</strong>
          </p>
        </v-card-actions>
      </v-row>


      <v-container>

        <pre v-if="decodedText">
            <h4>{{decodedText}}</h4>
            <br>
            Product ID             : {{ProductID}}
            Farm Location          : {{FarmLocation}}
            Harvest Date           : {{HarvestDate}}
            Transport Details      : {{TransportDetails}}
            Arrival at Store       : {{StoreArrivalDate}}
            Shelf Life             : {{ShelfLife}}
            Barcode Hash           : {{Barcode}}
            Blockchain Record      : {{BlockchainURL}}
          <br>
           <v-btn
               class="blue"
               dark
               small
               text
               @click="showTrackProduct = !showTrackProduct"
           >View Journey</v-btn>
        </pre>

      </v-container>

      <v-container v-if="showTrackProduct">
        <div>
          <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Track Product</v-toolbar-title>
          </v-toolbar>

          <v-stepper v-model="e13" vertical>
            <v-stepper-step step="1" complete>Freight Request Created</v-stepper-step>

            <v-stepper-content step="1"> 07 Jul  07:33</v-stepper-content>

            <v-stepper-step step="2" complete
            >Freight Approved</v-stepper-step
            >
            <v-stepper-content step="2">  07 Jul  07:34</v-stepper-content>

            <v-stepper-step step="3" complete >Agent Assigned</v-stepper-step>

            <v-stepper-content step="3">
              07 Jul  07:40
            </v-stepper-content>

            <v-stepper-step step="4">Pick-up Confirmed</v-stepper-step>
            <v-stepper-content step="4">

            </v-stepper-content>



            <v-stepper-step step="5">Delivery Confirmed</v-stepper-step>
            <v-stepper-content step="5">

            </v-stepper-content>

            <v-stepper-step step="6">POD upload</v-stepper-step>
            <v-stepper-content step="6">

            </v-stepper-content>

            <v-stepper-step step="6">POD approved</v-stepper-step>

          </v-stepper>

<!--          <div class="text-center">-->
<!--            <v-btn-->
<!--                class="red"-->
<!--                dark-->
<!--                small-->
<!--                text-->
<!--                :to="{ name: 'CustomerScanner' }"-->
<!--            >CLose</v-btn-->
<!--            >-->
<!--          </div>-->
        </div>
      </v-container>

    </v-card>
  </div>
</template>

<script>

import StreamBarcodeReader from "@/scanner/components/StreamBarcodeReader.vue";
import ImageBarcodeReader from "@/scanner/components/ImageBarcodeReader.vue";

export default {
  name: 'CustomerScanner',
  components: {StreamBarcodeReader, ImageBarcodeReader},

  data(){
    return {
      showTrackProduct: false,
      decodedText: '',
      ProductID: 'P123456',
      FarmLocation: 'Haryana, India',
      HarvestDate: '2024-04-08',
      TransportDetails: 'Transported by XYZ Logistics',
      StoreArrivalDate: '2024-04-15',
      ShelfLife: '2 weeks',
      Barcode: '789101112',
      BlockchainURL: 'https://blockchainrecords.com/record/P123456',
      states: ["Haryana", "Delhi", "Punjab", "Telangana"],
      cities: ["Panipat", "Chandigarh", "Hissar", "Jaipur", "Surat"],
      ports: ["Origin Warehouse", "Origin Port", "Destination Port", "Destination Warehouse"],
      PortName: "Steel and tin Warehouse",
      PortID: "123",
      Address: "Plot no. 78 and 79, North-west Road,Powder road, Gorakhpur ",
      InchargeName: "Ramesh Chaturvedi",
      ContactNo: "9886764569",
      AltNo: "9876543210",
      Email: "ramesh24@steelntin.com"
    }
  },
  methods: {
    onDecode(result) {
      this.decodedText = '{\n' +
          '  "blockchain": "Bitcoin",\n' +
          '  "address": "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",\n' +
          '  "transaction_id": "f4184fc596403b9d638783cf57adfe4c75c605f6356fbc91338530e9831e9e16",\n' +
          '  "amount": 0.1,\n' +
          '  "timestamp": "2024-04-08T18:11:20+05:30"\n' +
          '}\n'
      console.error(result);
      //this.decodedText = result;
    },
    onLoaded() {
      console.log('Camera is loaded');
    },
    onError(error) {
      console.error(error);
    }
  }
}
</script>
