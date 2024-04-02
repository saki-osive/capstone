<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Track Product</v-toolbar-title>
        </v-toolbar>

        <v-stepper v-model="e13" vertical>
            <v-stepper-step step="1" complete>Order Accepted</v-stepper-step>

            <v-stepper-content step="1">07 Jul 07:33</v-stepper-content>

            <v-stepper-step step="2" complete>Order Picked</v-stepper-step>
            <v-stepper-content step="2">07 Jul 07:34</v-stepper-content>

            <v-stepper-step step="3" complete>Order shipped to origin Warehouse</v-stepper-step>

            <v-stepper-content step="3">07 Jul 07:40</v-stepper-content>

            <v-stepper-step step="4">Order shipped to origin Port</v-stepper-step>
            <v-stepper-content step="4"></v-stepper-content>

            <v-stepper-step step="5">Order shipped to Destination Port</v-stepper-step>
            <v-stepper-content step="5"></v-stepper-content>

            <v-stepper-step step="6">Order shipped to Destination Warehouse</v-stepper-step>
            <v-stepper-content step="6"></v-stepper-content>

            <v-stepper-step step="7">Delivered to Consignee</v-stepper-step>
            <v-stepper-content step="7"></v-stepper-content>

            <v-stepper-step step="8">Delivery Confirmed by receiver</v-stepper-step>
            <v-stepper-content step="8"></v-stepper-content>

            <v-stepper-step step="9">POD upload</v-stepper-step>
            <v-stepper-content step="9"></v-stepper-content>

            <v-stepper-step step="10">POD approved</v-stepper-step>
        </v-stepper>

        <div class="text-center">
            <v-btn class="red" dark small text :to="{ name: 'ActiveOrders' }">CLose</v-btn>
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