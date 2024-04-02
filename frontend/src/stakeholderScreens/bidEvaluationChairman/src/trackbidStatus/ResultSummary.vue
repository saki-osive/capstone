<template>
  <div class="text-center">
    <h1 class="blue lighten-2">Result Summary Page</h1>
    <v-img src="@/assets/graph.gif" height="150" width="350" class="mx-auto my-8" />

    <v-container mx-12>
      <v-data-table :headers="headers" :items="covers" item-key="name"></v-data-table>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "Monitoring",

  data() {
    return {
      covers: [
        {
          name: "Total Bids",

          dayscore: "54",
          monthscore: "766"
        },
        {
          name: "Accepted Bids",

          dayscore: "45",
          monthscore: "567"
        },
        {
          name: " Rejected Bids",

          dayscore: " 78",
          monthscore: "671"
        },

        {
          name: "Bids blocked for Violation",

          dayscore: "76",
          monthscore: "456"
        }
      ],
      headers: [
        {
          text: " ",
          value: "name"
        },
        {
          text: "Last 7 days",
          value: "dayscore"
        },
        {
          text: "Last month",
          value: "monthscore"
        }
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