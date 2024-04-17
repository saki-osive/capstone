<template>
 <div>
   <v-card class="mx-auto" outlined>

     <v-btn  style=" color: white; margin: 20px;" color="blue"  v-on:click="addItemClicked()">Add Item</v-btn>

     <v-data-table :headers="headers" :items="covers">
       <template v-slot:item.name="{ item }">
         <v-text-field  v-model="item.name" outlined>

         </v-text-field>
       </template >
       <template v-slot:item.description="{ item }">
         <v-text-field v-model="item.description" outlined>

         </v-text-field>
       </template>
       <template v-slot:item.costAmount="{ item }">
         <v-text-field v-model="item.costAmount" outlined type="number">

         </v-text-field>
       </template>
     </v-data-table>
   </v-card>
 </div>
</template>

<script>
export default {
name: "BillOfMaterial",
  methods:{
    addItemClicked(){

      let count = this.covers.length + 1;
      this.covers.push({

        sno: count,

        name: '',
        costAmount: '',
        description: '',
      })
    }
  },
  data() {
    return {
      headers: [
        {
          text: 'S.No.',
          value: 'sno',
        },
        { text: 'Name', value: 'name' },
        { text: 'Description', value: 'description'},
        { text: 'Cost Amount', value: 'costAmount' },
      ],
      covers: [],

    }
  },

}
</script>

<style scoped>

</style>