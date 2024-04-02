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

      <v-stepper-step step="3">Calculate Duty and VAT</v-stepper-step>

      <v-stepper-content step="1">
        <v-card
            color="grey lighten-1"
            class="mb-12"
            height="200px"
        ></v-card>
      </v-stepper-content>

      <v-stepper-step step="4">Provide Custom Clearance</v-stepper-step>
    </v-stepper>
  </div>
</v-app>



</template>

<script>
export default {
name: "TrackFreightOrders"
}
</script>

<style scoped>

</style>