<template>
    <div>
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title> Add New Bidder</v-toolbar-title>
        </v-toolbar>

        <v-container class="ml-8 pl-8 mt-6">
            <v-form>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>Company Name</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Company Registration Number</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Company Contact Person</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Company Person Number</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Tender Category</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="Service" outlined></v-select>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Main E-Mail Address</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Telephone (Office)</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Mobile Number</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-text-field outlined></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Main Company Address</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-textarea outlined></v-textarea>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>Status</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select label="Active" outlined></v-select>
                    </v-col>
                </v-row>

                <br />
                <div class="text-center">
                    <v-btn class="primary" :to="{name :'BidderAdded'}">Add Bidder</v-btn>
                </div>
            </v-form>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'AddBidder',
    data() {
        return {}
    },
}
</script>
