<template>
  <v-container class="text-center">
    <h1 class="blue lighten-2">Performance</h1>

    <v-container mx-12>
      <v-data-table :headers="headers" :items="covers" item-key="Weightage">
      
       
      
      
      
      
      
      
      </v-data-table>
    </v-container>
    <div class="text-center">
    <v-btn class="primary mr-8" :to="{name:'AwardCertificate'}" >Certify</v-btn>
      <v-btn class="danger" :to="{name:'RejectedBid'}" >Reject</v-btn>
    </div>
  </v-container>
</template>

<script>
export default {
  name: "AssignedBids",

  data() {
    return {
      covers: [
        {
            sno:"1",
            parameter:"",
            delivery:"",
            quality:"",
            Reliability:"",
            total:""
        },
        {
            sno:"2",
            parameter:"",
            delivery:"",
            quality:"",
            Reliability:"",
            total:""
        }
        ,{
            sno:"3",
            parameter:"",
            delivery:"",
            quality:"",
            Reliability:"",
            total:""
        }










      ],
      headers: [
          {
          text: "#",
          value: "sno"
        },
        {
          text: "Performance Parameter",
          value: "parameter"
        },
        
        {
          text: "Delivery/ Completion Performance",
          value: "delivery"
        },
        {
          text: "Quality Performance",
          value: "quality"
        },
        {
          text: "Reliability Performance",
          value: "Reliability"
        },
        {
          text: "Total",
          value: "total"
        },
      ]
    };
  }
};
</script>

<style>
.pre-formatted {
  white-space: pre;
}
</style>