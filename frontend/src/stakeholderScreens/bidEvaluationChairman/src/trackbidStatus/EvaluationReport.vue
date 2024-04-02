<template>

<div class="text-center">
    <h1 class="blue lighten-2">Evaluation Report Page</h1>
    <v-img src="@/assets/graph2.gif" height="150" width="350" class="mx-auto my-8" />

    <v-container mx-auto>
<v-data-table :headers="headers"
      :items="covers"
      item-key="name"
      >

<template v-slot:item.Rating="{ item }">
         <v-rating v-model="item.rating" :value="item.rating"></v-rating>
      </template>

      <template v-slot:item.Status="{ item }">
        <v-btn small v-model="item.Status" dark :class="item.class">{{item.Status}}</v-btn>
      </template>

</v-data-table>
    </v-container>
</div>
</template>

<script>

export default {
  name: "RatingdResponses",

  data() {
    return {
      
       covers: [
        {
          name:"John Boo",
            class:"green",
            Status:"ok ",
            Rating:"3",
          date: "4-12-2011"
        },
         {
          name:"Michael Robinson",
            class:"grey",
            Status:"Blocked ",
            Rating:"2",
           date: "9-12-2001"
        },
         {
          name:" Alexander Robinson",
            class:"blue",
            Status:"Suspect ",
            Rating:"5",
           date: "29-12-2001"
        },


        {
          name:"Bob Robson",
            class:"red",
            Status:" Violation",
            Rating:"3",
           date: "2-12-2001"
        },

        
        
  ],
  headers: [
        
        {
          text: 'Bidder Name',
          value: 'name',
        },
        {
          text: 'Status',
          value: 'Status',
        },

        {
          text: 'Rating ',
          value: 'Rating',
        },
         {
          text: 'Time of bid Submission',
          value: 'date',
        },
        
        


      ]

    }
  }
};
</script>

