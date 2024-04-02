<template>
  <div>
    <v-toolbar class="blue lighten-2 mb-8">
      <v-toolbar-title>My Approved Bids</v-toolbar-title>
    </v-toolbar>
    <v-data-table
        :headers="approvedBidsHeaders"
        :items="approvedBidsCovers"
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
            :to="{name: 'BookForFreight'}"
        >Book for Freight</v-btn>
      </template>
      <template v-slot:item.action="{ item }">
        <v-btn
            class="blue"
            dark
            small
            v-model="item.action"
            text
            :to="{name: 'BookForSupplier'}"
        >Book for Supplier</v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
export default {
name: "ApprovedBids",
  data() {
    return {
      approvedBidsHeaders: [
        {
          text: 'S.no.',
          value: 'serialNumber',
        },
        {
          text: 'Tender no.',
          value: 'tenderNumber',
        },
        {
          text: 'Starting Date',
          value: 'startingDate',
        },
        {
          text: 'Closing Date',
          value: 'closingDate',
        },
        {
          text: 'Freight Forwarder',
          value: 'view',
        },
        {
          text: 'Supplier',
          value: 'action',
        },
      ],
      approvedBidsCovers: [
        {
          serialNumber: 1 ,
          tenderNumber: 8541256326,
          startingDate: '18.02.2020',
          closingDate: '1.12.2020',
        },
      ],
    }
  },
}
</script>

<style scoped>

</style>