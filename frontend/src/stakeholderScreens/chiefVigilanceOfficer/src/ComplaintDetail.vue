<template>
    <div>
        <v-toolbar class="blue lighten-3">
            <v-icon class="mx-auto">fa-comments</v-icon>
            <h1 class="mx-auto">Complaint</h1>
            <v-icon class="mx-auto">fa-comments</v-icon>
        </v-toolbar>

        <v-container>
            <v-card class="mx-auto pb-12">
                <br />

                <v-container class="pl-16 ml-16">
                    <pre>
          Complaint ID                 :         221
          Complaint Reason             :      Unbiased Decision
          Details                      :      The lot was published last
                                              month. The demand was for castrol.
                                              We are the only supplier of Castrol 
                                              in this area. Still we didn't get the 
                                              lot.
          Lot Registration Number   :      SG808332
          Inviting Officer             :      Deepak Kumar
          Lot Type                  :      Service Contract
          Lot Category              :      Services
          No. of cover(s)              :      80
          Product Category             :      Machineries
          Lot Recieving Location    :      Mayapur
          Form Contract                :      Works
          Submission Date              :      October 23, 2019
          </pre
                    >
                    <br />
                    <div class="text-center">
                        <v-btn small class="green mx-auto" dark to="TrackLot"
                            >Track</v-btn
                        >
                    </div>
                </v-container>

                <br />
                <br />

                <div class="text-center">
                    <v-btn small class="primary mr-12" dark
                        >Contact Lot Creator</v-btn
                    >
                    <v-btn small class="secondary mr-12" dark
                        >Mark as invalid Complaint</v-btn
                    >
                    <v-btn small class="red mr-12" dark>Flag the lot</v-btn>
                </div>
                <br />
            </v-card>
        </v-container>

        <br />
        <br />
        <br />
    </div>
</template>
<script>
export default {
    name: "ComplainDetails",
}
</script>
