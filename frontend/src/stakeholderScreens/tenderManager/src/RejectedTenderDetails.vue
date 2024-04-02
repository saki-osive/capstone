<template>
    <v-container>
        <v-card class="mx-auto mb-0 pb-0">
            <v-tabs background-color="blue" centered dark text>
                <v-tabs-slider></v-tabs-slider>

                <v-tab>Basic Details</v-tab>
                <v-tab>Cover Details</v-tab>

                <v-tab-item :key="tab1">
                    <v-card flat>
                        <v-div class="text-center">
                            <br />
                            <h1>Tender Details</h1>
                        </v-div>
                        <br />
                        <br />

                        <v-container class="pl-16 ml-16">
                            <pre>Tender Registration Number   :      SG808332 <br />Inviting Officer             :      Deepak Kumar <br />Tender Type                  :      Service Contract <br />Tender Category              :      Services <br />No. of cover(s)              :      80<br />Product Category             :      Machineries<br />Tender Recieving Location    :      Mayapur<br />Form Contract                :      Works<br />Submission Date              :      October 23, 2019</pre>
                        </v-container>

                        <br />
                        <br />
                        <br />
                    </v-card>
                </v-tab-item>

                <v-tab-item :key="tab2">
                    <v-card flat>
                        <br />
                        <br />
                        <pre class="text-center"> Tender Registration Number              :               GEUF353G</pre>
                        <br />
                        <br />
                        <v-container>
                            <v-data-table :headers="headers" :items="covers" item-key="name">
                                <template v-slot:item.ViewDoc="{ item }">
                                    <v-btn small v-model="item.ViewDoc" icon>
                                        <v-icon>fa-folder-open</v-icon>
                                    </v-btn>
                                </template>
                            </v-data-table>
                        </v-container>
                    </v-card>
                </v-tab-item>
            </v-tabs>
            
            <br />
            <br />
            <br />
        </v-card>
    </v-container>
</template>

<script>
export default {
    name: 'BidderDetail',

    data() {
        return {
            Corregendum: false,
            Reject: false,
            covers: [
                {
                    id: '121',
                    CoverName: 'ABCTechltd.pdf',
                    DocType: 'GST /Registration Certification',
                },
            ],
            headers: [
                {
                    text: '#',
                    value: 'id',
                },
                {
                    text: 'Cover Name',
                    value: 'CoverName',
                },
                {
                    text: 'Document Type',
                    value: 'DocType',
                },

                {
                    text: 'View Document',
                    value: 'ViewDoc',
                },
            ],
        }
    },
}
</script>
