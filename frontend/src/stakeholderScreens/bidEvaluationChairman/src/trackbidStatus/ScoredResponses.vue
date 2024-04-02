<template>

<div class="pre-formatted">
<v-toolbar class="blue lighten-2"> <v-toolbar-title> Monitoring and Analysis</v-toolbar-title></v-toolbar>

    <v-container mx-auto>
<v-data-table :headers="headers"
      :items="covers"
      item-key="name"
      >



      <template v-slot:item.Status="{ item }">
        <v-btn small v-model="item.Status" dark :class="item.class">{{item.Status}}</v-btn>
      </template>

</v-data-table>
    </v-container>
</div>
</template>

<script>

export default {
  name: "ScoredResponses",

  data() {
    return {
      
       covers: [
        {
          name:"John Boo",
            class:"green",
            Status:"ok ",
            score:"A+",
          date: "4-12-2011"
        },
         {
          name:"Michael Robinson",
            class:"grey",
            Status:"Blocked ",
            score:"A",
           date: "9-12-2001"
        },
         {
          name:" Alexander Robinson",
            class:"blue",
            Status:"Suspect ",
            score:" ",
           date: "29-12-2001"
        },


        {
          name:"Bob Robson",
            class:"red",
            Status:" Violation",
            score:"A+",
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
          text: 'Time of bid Submission',
          value: 'date',
        },
        
        {
          text: 'Score ',
          value: 'score',
        },


      ]

    }
  }
};
</script>

<style>
.pre-formatted {
  white-space: pre;
}
</style>