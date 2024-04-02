<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Select Bid</v-toolbar-title>
        </v-toolbar>
        <v-data-table
            :headers="headers"
            :items="submittedTendersList"
            item-key="name">
            <template v-slot:item.downloadTechDoc="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    text

                    v-on:click="onTechDownloadClicked(item)"
                >Download</v-btn>
            </template>
            <template v-slot:item.downloadFinancialDoc="{ item }">
            <v-btn
                    class="blue"
                    dark
                    small
                    text
                    v-on:click="onFinancialDownloadClicked(item)"
            >Download</v-btn>
        </template>
            <template v-slot:item.status="{ item }">
                <v-btn
                        class="blue"
                        dark
                        small
                        text
                    v-on:click="onTrackClicked(item)"
                >View Status</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
export default {
    name: 'SubmittedBids',
    methods:{

        onTechDownloadClicked(item){
            console.log(item)
            this.downloadFile(item.technicalDocumentPath)
        },

        onTrackClicked(item){
            console.log(item);
            this.$router.push({name: 'BidTrackStatus'})
        },
        onFinancialDownloadClicked(item){
            console.log(item)
            this.downloadFile(item.financialDocumentPath)
        },
        downloadFile(filename){
            console.log(filename)

            let request = {"fileName":filename};

            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            //hit api call
            this.$api.post('/download/document', request)
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){

                        this.showNotification("Success","User Created Successfully.")
                        window.open(response.data.data, '_blank');
                    }else {
                        this.showNotification("Error","Failed to register user.","info")
                    }

                }, (error) => {

                    loader.hide();
                    console.log(error);
                    this.showNotification("Error","Failed to register user.","error")
                });

        }
    },
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/bid/all')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.submittedTendersList = response.data;
                    this.showNotification("Success","Fetched all bids.")
                }else {
                    this.showNotification("Note","No bids available.","info")
                }

            }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","No bids available.","error")
            });
    },
    data() {
        return {
            headers: [
                {
                    text: 'Bid Id',
                    value: 'id',
                },
                {
                    text: 'Tender Name',
                    value: 'tender.scopeOfWork',
                },
                {
                    text: 'Tender Category',
                    value: 'tender.category',
                },
                {
                    text: 'Submission Date',
                    value: 'tender.dueDateForBidSubmission',
                },
                {
                    text: 'Currency',
                    value: 'currency',
                },
                {
                    text: 'Name of Company',
                    value: 'nameOfCompany',
                },
                {
                    text: 'Technical Document',
                    value: 'downloadTechDoc',
                },
                {
                    text: 'Financial Document',
                    value: 'downloadFinancialDoc',
                },
                {
                    text: 'Track Status',
                    value: 'status',
                },
            ],
            submittedTendersList: [

            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>