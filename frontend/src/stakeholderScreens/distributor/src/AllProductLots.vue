<template>
  <div>
    <v-toolbar class="blue lighten-2 mb-8">
      <v-toolbar-title>All Freight Orders</v-toolbar-title>
    </v-toolbar>
    <v-data-table
        :headers="headers"
        :items="covers"
        item-key="name"
        :search="search"
    >
      <template v-slot:item.view="{ item }">
        <v-btn
            class="blue"
            dark
            small
            v-model="item.view"
            text
            :to="{name: 'ProductDeliveryStatus'}"
        >View Status</v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
name: "AllProductLots",
  data() {
    return {
      headers: [
        {
          text: 'Order Id',
          value: 'productId',
        },
        {
          text: 'Customs',
          value: 'lotName',
        },
        {
          text: 'Trans Type',
          value: 'transType',
        },
        {
          text: 'Delivery Date',
          value: 'submissionDate',
        },
        {
          text: 'Track Status',
          value: 'view',
        },
      ],
      covers: [
        {
          productId: 8541256326,
          lotName: 'Assorted Valves SAPL Project',
          transType: 'Pending for clearance',
          submissionDate: '18.02.2020',
        },
      ],
    }
  },
}
</script>

<style scoped>

</style>