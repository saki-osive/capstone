<template>
  <div class="text-center">
    <v-row>
      <v-col cols="4">
        <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                outlined
                hide-details
        ></v-text-field>
      </v-col>
    </v-row>

    <v-data-table
            :headers="headers"
            :items="covers"
            item-key="name"
            :search="search"
    >
      <template v-slot:item.viewBlob="{ item }">
        <v-btn
                class="blue"
                dark
                small
                text
                v-on:click="onBlobClicked(item)"
        >View Data Blob</v-btn>
      </template>

      <template v-slot:item.viewHyperledgerLogs="{ item }">
        <v-btn small class="blue" dark v-on:click="onLogsClicked(item)">
          View Hyperledger Logs
        </v-btn>

      </template>

    </v-data-table>

    <v-dialog v-model="showLogsDialog" width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">Hyperledger Logs</span>
        </v-card-title>
<!--        <v-card-text>{{ocrText}}</v-card-text>-->
        <VueTerminal :intro="intro"
                     console-sign="$"
                     allow-arbitrary
                     @command="onCliCommand"
                     height="600px"></VueTerminal>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="showLogsDialog = false">OK</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-dialog v-model="showBlobDialog" width="600px">
      <v-card>
        <v-card-title>
          <span class="headline">Blob Data</span>
        </v-card-title>
                <v-card-text>{{dialogBlobText}}</v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="showBlobDialog = false">OK</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
  import VueTerminal from 'vue-terminal-ui'
  export default {
    name: "AuditorLogs",
    methods:{

      onCliCommand(data, resolve, reject) {
        console.log(data);
        setTimeout(() => {
          resolve(data);
          console.log(reject)
        }, 10);
      },
      onLogsClicked(item){
        this.showLogsDialog = true;
        console.log(item)

      },
      onBlobClicked(item){
        console.log(item)
        this.showBlobDialog = true;
        this.dialogBlobText = item.blob;
      }
    },
    components:{
      VueTerminal
    },

    mounted() {

      let loader = this.$loading.show({
        container: this.$refs.formContainer,
        canCancel: false,
        onCancel: null,
      });

      this.$api.get('/transaction/all')
              .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                  this.covers = response.data;
                  this.showNotification("Success","Fetched all transactions.")
                }else {
                  this.showNotification("Note","No transactions available.","info")
                }

              }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","No transactions available.","error")
              });

    },
    data() {
      return {
        showLogsDialog:false,
        showBlobDialog:false,
        dialogBlobText:"",
        intro:"Assigning transaction_id:  0788d105901c9f12316bb84dc1c5345be6fe96edf626d427de9871cefac4f063\n" +
                "Transaction proposal was good\n" +
                "Response payload: {\"$class\":\"org.tender.tenderModel.PriceCalculation\n" +
                "Successfully sent Proposal and received ProposalResponse: Status - 200, message - \"\"\n" +
                "The transaction has been committed on peer localhost:7051\n" +
                "Send transaction promise and event listener promise have completed\n" +
                "Successfully sent transaction to the orderer.\n" +
                "Successfully committed the change to the ledger by the peer",
        search: '',
        covers: [],
        headers: [
          {
            text: 'Object ID',
            value: 'id',
          },

          {
            text: 'Blockchain Hashcode',
            value: 'hashCode',
          },
          {
            text: 'Event name',
            value: 'eventName',
          },
          {
            text: 'Created Date',
            value: 'createdDate',
          },
          {
            text: 'View Hyperledger Logs',
            value: 'viewHyperledgerLogs',
          },
          {
            text: 'View Transaction Blob',
            value: 'viewBlob',
          },
        ],
      }
    },
  }
</script>
