<template>
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

        <div class="text-center">
            <v-btn
                class="red"
                dark
                small
                text
                :to="{ name: 'StatusOfFreight' }"
                >CLose</v-btn
            >
        </div>
    </div>
</template>

<script>
    export default {
        name: 'ProductDeliveryStatus',
    }
</script>

<style lang="scss" scoped>

</style>