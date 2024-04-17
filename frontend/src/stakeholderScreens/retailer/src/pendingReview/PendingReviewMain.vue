<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Active Lots</v-toolbar-title>
        </v-toolbar>

        <br />
        <br />

        <v-container mx-auto>
            <v-row>
                <v-subheader inset>LotID</v-subheader>

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
                <template v-slot:item.review="{ item }">
                    <v-btn
                        class="blue"
                        dark
                        small
                        v-model="item.review"
                        text
                       v-on:click="onReviewClicked(item)"
                    >Review</v-btn>
                </template>
            </v-data-table>
        </v-container>
    </div>
</template>

<script>
import {LotTableHeaders} from "@/datasource/LotTableHeaders";

export default {
    name: 'PendingReview',
    methods:{
        onReviewClicked(lotItem){

            this.$router.push({name: 'LotDetails',params:{lot:lotItem}});
        }
    },
    mounted() {

        let loader = this.$loading.show({
            container: this.$refs.formContainer,
            canCancel: false,
            onCancel: null,
        });

        this.$api.get('/lot/allLotsSentForApproval')
            .then((response) => {
                loader.hide();
                if (response.data.length > 0){
                    this.covers = response.data;
                    this.showNotification("Success","Fetched all lots.")
                }else {
                    this.showNotification("Note","No lot records available.","info")
                }

            }, (error) => {
                loader.hide()
                console.log(error)
                this.showNotification("Error","No lot records available.","error")
            });
    },
    data() {
        return {
            search: '',
            covers: [

            ],
            headers: LotTableHeaders.getHeaderForPendingReview(),
        }
    },
}
</script>
