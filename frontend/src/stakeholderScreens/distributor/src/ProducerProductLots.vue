<template>
  <div>
    <v-toolbar class="blue lighten-2 mb-8">
      <v-toolbar-title>Select Order for Custom Clearance</v-toolbar-title>
    </v-toolbar>
    <v-alert>All given freight orders are pending for custom clearance</v-alert>
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
        >Provide Custom Clearance</v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
name: "ProducerProductLots",
  data() {
    return {
      headers: [
        {
          text: 'HS Code',
          value: 'productId',
        },
        {
          text: 'Freight Order',
          value: 'lotName',
        },
        {
          text: 'Documents',
          value: 'documents',
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
          documents: '',
          submissionDate: '18.02.2020',
        },
      ],
    }
  },
}
</script>

<style scoped>

</style>