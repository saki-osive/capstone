<template>
  <div>
    <v-toolbar class="blue lighten-2">
      <v-toolbar-title>Processor</v-toolbar-title>
    </v-toolbar>
    <v-alert>All lots received from farmers are displayed here.</v-alert>
    <v-container mx-auto>
      <v-data-table :headers="headers" :items="lots" item-key="id">
        <template v-slot:item.active="{ item }">
          <v-checkbox small v-model="item.active"></v-checkbox>
        </template>
        <template v-slot:item.edit="{ item }">
          <v-btn small v-model="item.edit" icon>
            <v-icon>mdi-pencil</v-icon>
          </v-btn>
        </template>
        <template v-slot:item.delete="{ item }">
          <v-btn small v-model="item.delete" icon>
            <v-icon>mdi-delete</v-icon>
          </v-btn>
        </template>
      </v-data-table>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'ViewAll',

  data() {
    return {
      lots: [
        {
          id: 'DLV123456',
          CompanyName: 'FarmFresh Foods Ltd.',
          EmployeeID: 'TRNSP789',
          ProductName: 'Organic Rice',
          ProductID: 'PROD12345',
          StorageConditions: 'Dry and ventilated',
          HarvestDate: '2024-04-10',
          Origin: 'Rice Farms Co.',
          ManufacturingDate: '2024-04-15',
          ExpirationDate: '2025-04-15',
          Location: 'Riceville, USA',
          GSTHSTQSTNo: 'ORG123456789',
          DateReceived: '2024-04-20',
        },
      ],
      headers: [
        {
          text: 'Delivery ID',
          value: 'id',
        },
        {
          text: 'Name of Company',
          value: 'CompanyName',
        },
        {
          text: 'Product Name',
          value: 'ProductName',
        },
        {
          text: 'Product ID',
          value: 'ProductID',
        },
        {
          text: 'Storage Conditions',
          value: 'StorageConditions',
        },
        {
          text: 'Harvest Date',
          value: 'HarvestDate',
        },
        {
          text: 'Origin',
          value: 'Origin',
        },
        {
          text: 'Manufacturing Date',
          value: 'ManufacturingDate',
        },
        {
          text: 'Expiration Date',
          value: 'ExpirationDate',
        },
        {
          text: 'Location',
          value: 'Location',
        },
        {
          text: 'GST/HST/QST No',
          value: 'GSTHSTQSTNo',
        },
        {
          text: 'Date Received',
          value: 'DateReceived',
        },
        {
          text: 'Verify',
          value: 'active',
        },
        {
          text: 'Edit',
          value: 'edit',
        },
        {
          text: 'Delete',
          value: 'delete',
        },
      ],
    };
  },
};
</script>
