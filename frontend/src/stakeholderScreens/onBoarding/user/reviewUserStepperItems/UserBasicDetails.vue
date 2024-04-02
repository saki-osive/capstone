<template>
    <div class="text-center">
        <v-row>
            <v-col cols="6">UserID:</v-col>
            <v-col cols="3" align>{{ useID }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Company Name:</v-col>
            <v-col cols="3">{{ companyName }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Vendor Code:</v-col>
            <v-col cols="3">{{ gailVendorCode }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">TENDER REF:</v-col>
            <v-col cols="3">{{ gailIndiaTenderRef }}</v-col>
        </v-row>
        <p>
            <Strong>Address Data</Strong>
        </p>
        <v-row>
            <v-col cols="6">E-Mail Address * :</v-col>
            <v-col cols="3">{{ email }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Telephone * :</v-col>
            <v-col cols="3">{{ telephone }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Mobile No. * :</v-col>
            <v-col cols="3">{{ mobile }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">GST No:</v-col>
            <v-col cols="3">{{ gstNo }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">PAN Number :</v-col>
            <v-col cols="3">{{ panNo }}</v-col>
        </v-row>
        <v-row>
            <v-col cols="6">Products Category Deliver:</v-col>
            <v-col cols="3">{{ productCategoryDeliver }}</v-col>
        </v-row>
    </div>
</template>

<script>
export default {
    name: 'UserBasicDetails',
    data() {
        return {}
    },
}
</script>

<style lang="scss" scoped>
</style>