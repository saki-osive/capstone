<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Upcoming Tenders</v-toolbar-title>
        </v-toolbar>

        <br />
        <br />

        <v-container mx-auto>
            <v-row>
                <v-subheader inset>Tender ID</v-subheader>
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
                <v-spacer></v-spacer>
                <v-col>
                    <v-btn 
                    rounded 
                    color="primary"
                    to="InviteBidder"
                    >
                        Invite Bidders
                    </v-btn>
                </v-col>
            </v-row>
            <br />
            <v-data-table
                :headers="headers"
                :items="covers"
                item-key="id"
                :search="search"
            >
            </v-data-table>
        </v-container>
    
    </div>
</template>

<script>
export default {
    name: 'UpcomingTenders',

    data() {
        return {
            InviteBidder: false,
            search: '',
            covers: [
                {
                    id: '121',
                    refNo: '234567',
                    description: 'Office supply',
                    odate: '4-12-2011',
                    cdate: '29-12-2011',
                    category: 'supplier',
                },
                {
                    id: '122',
                    refNo: '876543',

                    description: ' procure medicine',
                    odate: '9-12-2001',
                    cdate: '9-1-2002',
                    category: 'IT',
                },
                {
                    id: '123',
                    refNo: '23456576',

                    description: ' event management',
                    odate: '29-12-2001',
                    cdate: '9-1-2002',
                    category: 'SDF',
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
                    text: 'Open Date',
                    value: 'odate',
                },

                {
                    text: 'Close Date',
                    value: 'cdate',
                },

                {
                    text: 'Work Category',
                    value: 'category',
                },
                {
                    text: 'Description',
                    value: 'description',
                },
            ],
        }
    },
}
</script>
