<template>
  <div>
    <v-toolbar class="blue lighten-2">
      <v-toolbar-title>Rejected Tenders</v-toolbar-title>
    </v-toolbar>

    <br />
    <br />

    <v-container mx-auto>
      <v-row>
        <v-subheader inset>TenderID</v-subheader>

        <v-col cols="4" class="my-0 py-0">
          <v-text-field
            v-model="search"
            clearable
            flat
            solo-inverted
            hide-details
            prepend-inner-icon="fa-search"
            label="Search"
          ></v-text-field>
        </v-col>
      </v-row>
      <br />
      <v-data-table :headers="headers" :items="covers" item-key="id" :search="search">
        <template v-slot:item.status="{ item }">
          <v-btn class="red" dark small v-model="item.status" text >Rejected</v-btn>
        </template>

        <template v-slot:item.View="{ item }">
          <v-btn class="blue" dark small v-model="item.View" text to="RejectedTenderDetails">View</v-btn>
        </template>



      </v-data-table>
    </v-container>
  </div>
</template>

<script>

export default {
  name: "PendingReview",

  data() {
    return {
        search: '',
       covers: [
        {
          id:"121",
          refNo:"234567",
          description:"Office supply", 
          odate: "4-12-2011",
          cdate:"29-12-2011",
          category:"supplier",
          officer: "Deepak Prasad"
          
        },
         {
          id:"122",
           refNo:"876543",
          officer: "S.P Sharma",
          description:"procure medicine", 
           odate: "9-12-2001",
           cdate: "9-1-2002",
          category:"IT"
        },
         {
          id:"123",
           refNo:"23456576",
          officer: "Kimi Mojil",
          description:"event management", 
           odate: "29-12-2001",
           cdate: "9-1-2002",
          category:"SDF"
        },
        
  ],
  headers: [
        {                                                                                                                                                                                                    

          text: 'Id',
          value: 'id',
        },
        {                                                                                                                                                                                                    

          text: 'Tender Reference No',
          value: 'refNo',
        },

        {
          text: 'Tender Type',
          value: 'category',
        },
        {
          text: 'Submission Date',
          value: 'odate',
        },

        {
          text: 'Inviting Officer',
          value: 'officer',
        },

            {
          text: 'Status',
          value: 'status',
        },

        
        {
          text: ' ',
          value: 'View',
        }
       
       


      ]

    }
  }
};
</script>