<template>
    <v-container fluid >
        <v-row>
            <v-col cols="12">
                <v-row
                    align="start"
                    justify="center"
                    class="grey lighten-5"
                    style="height: 100px;"
                >
                    <v-card class="ma-3 pa-6" outlined tile
                        >12 new submitted bids</v-card
                    >
                    <v-card class="ma-3 pa-6" outlined tile
                        >25 Active Tenders</v-card
                    >
                    <v-card class="ma-3 pa-6" outlined tile
                        >7 Approved Bids</v-card
                    >
                    <v-card class="ma-3 pa-6" outlined tile
                        >5 Rejected Bids</v-card
                    >
                </v-row>
            </v-col>
        </v-row>


  <v-row>
      <v-col
        cols="12"
        md="6"
      >

<v-card>
        <v-sparkline
            :labels="labels"
            :value="value"
            :gradient="gradient"
            padding="8"
            line-width="13"
            type="bar"
            auto-draw
            :show-labels="showLabels"
            label-size="5"
        ></v-sparkline>

         <v-card-text class="pt-0">
      <div class="title font-weight-light mb-2">Active Bids</div>
      <div class="subheading font-weight-light grey--text">Active Bids in month of July </div>
      <v-divider class="my-2"></v-divider>
      <v-icon
        class="mr-2"
        small
      >
        mdi-clock
      </v-icon>
      <span class="caption grey--text font-weight-light">last updated 26 minutes ago</span>
    </v-card-text> 
</v-card>
      </v-col>



  <v-col
        cols="12"
        md="4"
      >


 <v-card
    class="mt-4 mx-auto"
    max-width="400"
  >
    <v-sheet
      class="v-sheet--offset mx-auto"
      color="cyan"
      elevation="12"
      max-width="calc(100% - 32px)"
    >
      <v-sparkline
        :labels="labels"
        :value="value"
        color="white"
        line-width="2"
        padding="16"
      ></v-sparkline>
    </v-sheet>

    <v-card-text class="pt-0">
      <div class="title font-weight-light mb-2">Total Bids</div>
      <div class="subheading font-weight-light grey--text">Total bids submitted in june and july </div>
      <v-divider class="my-2"></v-divider>
      <v-icon
        class="mr-2"
        small
      >
        mdi-clock
      </v-icon>
      <span class="caption grey--text font-weight-light">last updated 26 minutes ago</span>
    </v-card-text>
  </v-card>



  </v-col>




  </v-row>   
  <v-row>

 <v-col
        cols="12"
        sm="6"
        lg="3"
      >
       
<v-card>
 <v-progress-circular
      :rotate="360"
      :size="200"
      :width="25"
      :value="Pvalue"
      color="teal"
    >
      {{ Pvalue }}
    </v-progress-circular>








</v-card>

      </v-col>



      <v-col
        cols="12"
        sm="6"
        lg="3"
      >
       

 <v-progress-circular
      :rotate="360"
      :size="200"
      :width="25"
      :value="Pvalue"
      color="red"
    >
      {{ Pvalue }}
    </v-progress-circular>

      </v-col>




 <v-col
        cols="12"
        sm="6"
       class="mx-auto"
      >
 <div class="text-center">
    
  <v-row> Financial </v-row>

<v-row><v-rating 
      v-model="rating"
      background-color="orange lighten-3"
      color="orange"
      medium
    ></v-rating>
  </v-row>

<v-row> Technical </v-row>

<v-row>
     <v-rating 
      v-model="rating"
      background-color="orange lighten-3"
      color="orange"
      medium
    ></v-rating>

</v-row>

<v-row>
Administrative:
</v-row>

<v-row>
     <v-rating 
      v-model="rating"
      background-color="orange lighten-3"
      color="orange"
      medium
    ></v-rating>
</v-row>


    

  </div>
 </v-col>





  </v-row>     
        

        <v-divider></v-divider>

        <v-row >
            <v-col cols="8" md="4">
                <v-row  align="center">
                    <v-item-group v-model="gradient" mandatory>
                        <v-row>
                            <v-item
                                v-for="(gradient, i) in gradients"
                                :key="i"
                                :value="gradient"
                            >
                                <v-card
                                    :style="{
                                        background:
                                            gradient.length > 1
                                                ? `linear-gradient(0deg, ${gradient})`
                                                : gradient[0],
                                    }"
                                    width="0"
                                    height="0"
                                    class="mr-2"
                                ></v-card>
                            </v-item>
                        </v-row>
                    </v-item-group>
                </v-row>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
const gradients = [['red', 'orange', 'yellow']]

export default {
    name: 'BidderDashboard',
    data() {
        return {
            rating:4,
            alignmentsAvailable: [
                'start',
                'center',
                'end',
                'baseline',
                'stretch',
            ],
            alignment: 'center',
            dense: false,
            justifyAvailable: [
                'start',
                'center',
                'end',
                'space-around',
                'space-between',
            ],
            justify: 'center',

            gradient: gradients,
            value: [2, 5, 9, 5, 10, 3, 5, 14, 10, 1, 8, 2],

            gradients,

            labels: [
                '12am',
                '3am',
                '6am',
                '9am',
                '12pm',
                '3pm',
                '6pm',
                '9pm',
                '10pm',
                '11pm',
                '12am',
                '3am',
            ],



 interval: {},
        Pvalue: 20,        
        }

    },


 beforeDestroy () {
      clearInterval(this.interval)
    },
    mounted () {
      this.interval = setInterval(() => {
        if (this.Pvalue === 100) {
          return (this.Pvalue = 0)
        }
        this.Pvalue += 10
      }, 10000)
    },












}
</script>
