<template>
  <v-div>
    <v-toolbar class="blue lighten-2 mb-4">
      <v-toolbar-title>Book for Supplier</v-toolbar-title>
    </v-toolbar>
    <div>
      <h1 align="center" class="font-weight-black">
        Supplier Order Details
      </h1>
    </div>
    <v-div class="ml-12 pl-12">
      <v-form>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Delivery ID
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Quality check details
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="3">
            <v-subheader>
              Name of Company
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
               Vendor Code
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Quality assurance details
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader> Product Delivery Date</v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Payment Mode
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>

          <v-col>
            <v-select
                label="-select-"
                :items="payment"
                outlined
            ></v-select>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              E-Mail Address
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Telephone
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined> </v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Address Details
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              Location
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
          <v-col cols="3">
            <v-subheader>
              Postal Code
              <span class="red--text">*</span>
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="3">
            <v-subheader>
              State
            </v-subheader>
          </v-col>
          <v-col>
            <v-text-field outlined></v-text-field>
          </v-col>
        </v-row>
      </v-form>
      <v-row >
        <v-col class="my-2" align="right">
          <v-btn
              :to="{ name: 'BookedForSupplierConfirmationScreen'}">
            Submit
          </v-btn>
        </v-col>
      </v-row>
    </v-div>
  </v-div>
</template>

<script>
export default {
name: "BookForSupplier"
}
</script>

<style scoped>

</style>