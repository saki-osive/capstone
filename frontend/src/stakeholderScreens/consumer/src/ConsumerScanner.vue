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
            <v-stepper-step step="1" complete>Organic Rice Cultivated</v-stepper-step>
            <v-stepper-content step="1">Cultivated on April 1, 2024</v-stepper-content>

            <v-stepper-step step="1" complete>Transportation Initiated</v-stepper-step>
            <v-stepper-content step="1">Transported on April 4, 2024</v-stepper-content>

            <v-stepper-step step="1" complete>Processing Completed</v-stepper-step>
            <v-stepper-content step="1">Processed on April 8, 2024</v-stepper-content>

            <v-stepper-step step="1" complete>Pick-up Confirmed</v-stepper-step>
            <v-stepper-content step="1">Confirmed on April 10, 2024</v-stepper-content>

            <v-stepper-step step="1" complete>Delivery Confirmed</v-stepper-step>
            <v-stepper-content step="1">Confirmed on April 15, 2024</v-stepper-content>

            <v-stepper-step step="1" complete>Quality Assurance</v-stepper-step>
            <v-stepper-content step="1">Quality checked on April 15, 2024</v-stepper-content>

            <v-stepper-step step="1" complete>Equipment Utilization</v-stepper-step>
            <v-stepper-content step="1">Best equipment used throughout</v-stepper-content>

            <v-stepper-step step="1" complete>Inventory Management</v-stepper-step>
            <v-stepper-content step="1">Inventory managed efficiently</v-stepper-content>

            <v-stepper-step step="1" complete>System Administration</v-stepper-step>
            <v-stepper-content step="1">Systems maintained for operations</v-stepper-content>

            <v-stepper-step step="1" complete>Data Analysis</v-stepper-step>
            <v-stepper-content step="1">Data analyzed for service improvement</v-stepper-content>

            <v-stepper-step step="11" complete>Sustainability Practices</v-stepper-step>
            <v-stepper-content step="1">Committed to sustainability</v-stepper-content>

            <v-stepper-step step=""  color="grey">Product Sold At </v-stepper-step>
            <v-stepper-content step="12">Received by you on April 22, 2024</v-stepper-content>
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
  name: 'ConsumerScanner',
  components: {StreamBarcodeReader, ImageBarcodeReader},

  data(){
    return {
      showTrackProduct: false,
      decodedText: '',
      ProductID: 'PROD12345',
      FarmLocation: 'Rice Farms Co., Riceville, USA',
      HarvestDate: '2024-04-10',
      TransportDetails: 'Transported by XYZ Logistics',
      StoreArrivalDate: '2024-04-15',
      ShelfLife: '1 year',
      Barcode: 'DLV123456',
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
          '  "blockchain": "Hyperledger Fabric",\n' +
          '  "address": "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",\n' +
          '  "transaction_id": "f4184fc596403b9d638783cf57adfe4c75c605f6356fbc91338530e9831e9e16",\n' +
          '  "amount": 0.1,\n' +
          '  "timestamp": "2024-04-08T18:11:20+05:30",\n' +
          '  "ProductID": "PROD12345",\n' +
          '  "ProductName": "Organic Rice",\n' +
          '  "Origin": "Rice Farms Co.",\n' +
          '  "HarvestDate": "2024-04-10",\n' +
          '  "TransportDetails": "Transported by TRNSP789",\n' +
          '  "DeliveryID": "DLV123456",\n' +
          '  "LotReference": "LOT2024001"\n' +
          '}\n';
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
