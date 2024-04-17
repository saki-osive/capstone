<template>
<v-app >
  <div>
  <v-toolbar class="blue lighten-2 mb-8" app >
    <v-toolbar-title>Track Packaging Warehousing Distribution</v-toolbar-title>
  </v-toolbar>
  </div>
  <div class="ma-12 pa-12">
    <v-stepper v-model="e13" vertical>
      <v-stepper-step color="green" step="1" complete>
        Successfully Passed Documents at Customs
      </v-stepper-step>
      <v-stepper-content step="1"></v-stepper-content>

      <v-stepper-step color="green" step="2" complete
      >HS Codes Confirmed</v-stepper-step
      >
      <v-stepper-content step="2"> </v-stepper-content>

      <v-stepper-step step="3">Approve the LOT</v-stepper-step>

      <v-stepper-content step="1">
        <v-card
            color="grey lighten-1"
            class="mb-12"
            height="300px"
        >
          <v-card-title>Product Details</v-card-title>
          <v-card-text>
            <v-list dense>
              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title>Delivery ID:</v-list-item-title>
                  <v-list-item-subtitle>DLV123456</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title>Carrier ID:</v-list-item-title>
                  <v-list-item-subtitle>TRNSP789</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title>Product Name:</v-list-item-title>
                  <v-list-item-subtitle>Organic Rice</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-card-text>
          <v-card-actions>
            <v-btn color="primary"  @click="snackbar = true" :disabled="snackbar">Approve</v-btn>
            <v-btn color="error">Reject</v-btn>
          </v-card-actions>

        </v-card>
      </v-stepper-content>

      <v-stepper-step step="4">Provide Custom Clearance</v-stepper-step>
    </v-stepper>
  </div>

  <v-snackbar v-model="snackbar" color="green"
  >Approved the LOT</v-snackbar
  >
</v-app>


</template>

<script>
export default {
name: "TrackProductLots",
  data() {
  return {
    snackbar: false,
  }
  }
}
</script>

<style scoped>

</style>