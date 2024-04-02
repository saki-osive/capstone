<template>
    <v-div>
        <v-toolbar class="blue lighten-2 mb-4">
            <v-toolbar-title>Bidder Profile</v-toolbar-title>
        </v-toolbar>
        <v-div class="ml-12 pl-12">
            <v-form>
                <v-row>
                    <v-col cols="3">
                        <header>User ID</header>
                    </v-col>
                    <v-col cols="3" class="pt-0 ">
                        <v-text-field outlined />
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <header>Username</header>
                    </v-col>
                    <v-col cols="3" class="pt-0 ">
                        <v-text-field outlined />
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <header>Full Name</header>
                    </v-col>
                    <v-col cols="3" class="pt-0 ">
                        <v-text-field outlined />
                    </v-col>
                    <v-col cols="3" class="pt-0 ">
                        <v-text-field outlined />
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <header>Bidder ID</header>
                    </v-col>
                    <v-col cols="3" class="pt-0 ">
                        <v-text-field outlined />
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <header>E-mail ID</header>
                    </v-col>
                    <v-col cols="3" class="pt-0 ">
                        <v-text-field outlined />
                    </v-col>
                </v-row>

                <v-row>
                    <v-col class="ml-12 pl-12">
                        <v-col cols="3">
                            <header>Bidder Status</header>
                        </v-col>
                        <v-radio-group>
                            <v-radio label="Active"></v-radio>

                            <v-radio label="Inactive"></v-radio>
                        </v-radio-group>
                    </v-col>

                    <v-col>
                        <v-col cols="3">
                            <header>Bidder Type</header>
                        </v-col>
                        <v-radio-group>
                            <v-radio label="Business"></v-radio>

                            <v-radio label="Individual"></v-radio>
                        </v-radio-group>
                    </v-col>
                </v-row>

                <v-btn text class="mx-12 px-12">
                    Digital Signature Certificate</v-btn
                >
                <v-col class="mx-12 px-12">
                    <v-col class="d-flex" cols="6" sm="4">
                        <v-expansion-panels multiple>
                            <v-expansion-panel>
                                <v-expansion-panel-header
                                    >Company Details</v-expansion-panel-header
                                >
                                <v-expansion-panel-content>
                                    Coming soon
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                            <v-expansion-panel>
                                <v-expansion-panel-header
                                    >Address Details</v-expansion-panel-header
                                >
                                <v-expansion-panel-content>
                                    Coming soon
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                            <v-expansion-panel>
                                <v-expansion-panel-header
                                    >List of Submitted
                                    Bids</v-expansion-panel-header
                                >
                                <v-expansion-panel-content>
                                    Coming soon
                                </v-expansion-panel-content>
                            </v-expansion-panel>

                            <v-expansion-panel>
                                <v-expansion-panel-header
                                    >Additional
                                    Information</v-expansion-panel-header
                                >
                                <v-expansion-panel-content>
                                    Coming soon
                                </v-expansion-panel-content>
                            </v-expansion-panel>
                        </v-expansion-panels>
                    </v-col>
                </v-col>
            </v-form>
        </v-div>
    </v-div>
</template>
