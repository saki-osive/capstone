<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Select Product</v-toolbar-title>
        </v-toolbar>
        <v-data-table
            :headers="headers"
            :items="submittedLotsList"
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
    name: 'SubmittedProducts',
    methods:{

        onTechDownloadClicked(item){
            console.log(item)
            this.downloadFile(item.technicalDocumentPath)
        },

        onTrackClicked(item){
            console.log(item);
            this.$router.push({name: 'ProductTrackStatus'})
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

        this.$api.get('/product/all')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.submittedLotsList = response.data;
                    this.showNotification("Success","Fetched all products.")
                }else {
                    this.showNotification("Note","No products available.","info")
                }

            }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","No products available.","error")
            });
    },
    data() {
        return {
            headers: [
                {
                    text: 'Product Id',
                    value: 'id',
                },
                {
                    text: 'Lot Name',
                    value: 'lot.scopeOfWork',
                },
                {
                    text: 'Lot Category',
                    value: 'lot.category',
                },
                {
                    text: 'Submission Date',
                    value: 'lot.dueDateForProductSubmission',
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
            submittedLotsList: [

            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>