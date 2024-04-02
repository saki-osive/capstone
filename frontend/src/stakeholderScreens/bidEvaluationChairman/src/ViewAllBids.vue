<template>
    <div class="pre-formatted">
        <template>
            <v-stepper v-model="e1">
                <v-stepper-header>
                    <v-stepper-step :complete="e1 > 1" step="1"
                        >Basic Details</v-stepper-step
                    >

                    <v-divider></v-divider>

                    <v-stepper-step :complete="e1 > 2" step="2"
                        >Assign Technical Expert</v-stepper-step
                    >

                    <v-divider></v-divider>

                    <v-stepper-step :complete="e1 > 3" step="3"
                        >Assign Financial Expert</v-stepper-step
                    >

                    <v-divider></v-divider>

                    <v-stepper-step step="4">Review and Submit</v-stepper-step>
                </v-stepper-header>

                <v-stepper-items>
                    <v-stepper-content step="1">
                        <v-card flat class="mb-12">
                            <v-container class="pl-16 ml-16">
                                <pre>                            
Company Name                       :      AMC Networks PTE Limited
Bid Type                           :      Service    
Bid Submission Date                :      28-7-2019
Company Registration Number        :      SG808332 <br />Company Contact Person             :      Rajesh Kumar <br />Company Contact Person Number      :      9865667521 <br />Tender Category                    :      Services <br />Main E-Mail Address                :      rajesh@amc.co.in <br />Telephone(Office)                  :      0116774755 <br />Mobile Number                      :      9867545723 <br />Main Company Address               :      F3/277, Mogli Building, Noida, UP
          
          </pre>
                                <v-divider />
                                <br />
                                <pre> Document Submitted                :      <v-icon> fa-folder-open </v-icon> GST /Registration Certification </pre>
                            </v-container>
                        </v-card>
                        <div class="text-center">
                            <v-btn color="primary" @click="e1 = 2" class="mr-6">
                                Continue
                            </v-btn>

                            <v-btn text>Cancel</v-btn>
                        </div>
                    </v-stepper-content>

                    <v-stepper-content step="2">
                        <v-card flat class="mb-12">
                            <div class="text-center">
                                <v-toolbar class="blue lighten-2">
                                    <v-toolbar-title
                                        >Technical Expert
                                        Details</v-toolbar-title
                                    >
                                </v-toolbar>
                                <v-container mx-auto class="pre-formatted">
                                    <v-data-table
                                        hide-default-footer
                                        :headers="headers"
                                        :items="experts"
                                        item-key="name"
                                    >
                                        <template v-slot:item.edit="{ item }">
                                            <v-btn
                                                small
                                                v-model="item.edit"
                                                text
                                                v-if="item.class == 'green'"
                                                color="blue"
                                                outlined
                                                >Unassign</v-btn
                                            >
                                            <v-btn
                                                small
                                                v-model="item.edit"
                                                text
                                                v-if="item.class == 'red'"
                                                color="blue"
                                                outlined
                                                >Assign</v-btn
                                            >
                                        </template>

                                        <template v-slot:item.assign="{ item }">
                                            <v-btn
                                                small
                                                v-model="item.assign"
                                                icon
                                                dark
                                                :class="item.class"
                                            >
                                                <v-icon>{{ item.icon }}</v-icon>
                                            </v-btn>
                                        </template>
                                    </v-data-table>
                                </v-container>
                            </div>
                        </v-card>
                        <div class="text-center">
                            <v-btn color="primary" @click="e1 = 3" class="mr-6">
                                Continue
                            </v-btn>

                            <v-btn text>Cancel</v-btn>
                        </div>
                    </v-stepper-content>

                    <v-stepper-content step="3">
                        <v-card flat class="mb-12">
                            <div class="text-center">
                                <v-toolbar class="blue lighten-2">
                                    <v-toolbar-title>
                                        Financial Expert
                                        Details</v-toolbar-title
                                    >
                                </v-toolbar>
                                <v-container mx-auto class="pre-formatted">
                                    <v-data-table
                                        hide-default-footer
                                        :headers="Headers"
                                        :items="FExperts"
                                        item-key="name"
                                    >
                                        <template v-slot:item.edit="{ item }">
                                            <v-btn
                                                small
                                                v-model="item.edit"
                                                text
                                                v-if="item.class == 'green'"
                                                color="blue"
                                                outlined
                                                >Unassign</v-btn
                                            >
                                            <v-btn
                                                small
                                                v-model="item.edit"
                                                text
                                                v-if="item.class == 'red'"
                                                color="blue"
                                                outlined
                                                >Assign</v-btn
                                            >
                                        </template>

                                        <template v-slot:item.assign="{ item }">
                                            <v-btn
                                                small
                                                v-model="item.assign"
                                                icon
                                                dark
                                                :class="item.class"
                                            >
                                                <v-icon>{{ item.icon }}</v-icon>
                                            </v-btn>
                                        </template>
                                    </v-data-table>
                                </v-container>
                            </div>
                        </v-card>
                        <div class="text-center">
                            <v-btn color="primary" @click="e1 = 4" class="mr-6">
                                Continue
                            </v-btn>

                            <v-btn text>Cancel</v-btn>
                        </div>
                    </v-stepper-content>

                    <v-stepper-content step="4">
                        <v-card flat class="pb-12 grey lighten-4">
                            <div class="text-center pt-8">
                                <h3>Bid Details</h3>
                            </div>
                            <v-container class="pl-16 ml-16">
                                <pre>                            
Company Name                       :      AMC Networks PTE Limited
Bid Type                           :      Service    
Bid Submission Date                :      28-7-2019
Company Registration Number        :      SG808332 <br />Company Contact Person             :      Rajesh Kumar <br />Company Contact Person Number      :      9865667521 <br />Tender Category                    :      Services <br />Main E-Mail Address                :      rajesh@amc.co.in <br />Telephone(Office)                  :      0116774755 <br />Mobile Number                      :      9867545723 <br />Main Company Address               :      F3/277, Mogli Building, Noida, UP
          
          </pre>
                                <v-divider />
                                <br />
                                <pre> Document Submitted                :      <v-icon> fa-folder-open </v-icon> GST /Registration Certification </pre>
                                <br />
                                <br />
                                <h3 class="mx-auto">
                                    Technical Experts Assigned
                                </h3>
                                <br />
                                <v-data-table
                                    hide-default-footer
                                    :headers="headers"
                                    :items="experts"
                                    item-key="name"
                                >
                                </v-data-table>

                                <br />
                                <br />
                                <h3 class="mx-auto">
                                    Financial Experts Assigned
                                </h3>
                                <br />
                                <v-data-table
                                    hide-default-footer
                                    :headers="Headers"
                                    :items="FExperts"
                                    item-key="name"
                                >
                                </v-data-table>
                            </v-container>

                            <div class="text-center mt-4">
                                <v-btn color="primary" class="mr-6">
                                    Submit
                                </v-btn>

                                <v-btn text>Cancel</v-btn>
                            </div>
                        </v-card>
                    </v-stepper-content>
                </v-stepper-items>
            </v-stepper>
        </template>
    </div>
</template>

<script>
export default {
    name: 'ViewAll',

    data() {
        return {
            e1: 1,
            experts: [
                {
                    id: '121',
                    fname: 'Tapi Sharma',
                    designation: 'Civil Engineer',
                    username: ' Tapish',
                    icon: 'fa-check',
                    class: 'green',
                },
                {
                    id: '122',
                    fname: 'Ravi Shapal',
                    designation: 'IT Engineer',
                    username: 'Ravish',
                    icon: 'fa-check',
                    class: 'green',
                },
                {
                    id: '123',
                    fname: 'voluptarem Bhatia',
                    designation: ' IT Engineer',

                    username: 'VBhatia',

                    icon: 'fa-times',
                    class: 'red',
                },
            ],
            headers: [
                {
                    text: 'Expert id',
                    value: 'id',
                },
                {
                    text: 'Full Name',
                    value: 'fname',
                },
                {
                    text: 'Designation',
                    value: 'designation',
                },
                {
                    text: 'Username',
                    value: 'username',
                },
                {
                    text: 'Assigned for evaluation ',
                    value: 'assign',
                },
                {
                    text: ' ',
                    value: 'edit',
                },
            ],

            FExperts: [
                {
                    id: '121',
                    fname: 'Tapi Sharma',
                    designation: 'CA',
                    username: ' Tapish',
                    icon: 'fa-check',
                    class: 'green',
                },
                {
                    id: '122',
                    fname: 'Ravi Shapal',
                    designation: 'CS',
                    username: 'Ravish',
                    icon: 'fa-check',
                    class: 'green',
                },
                {
                    id: '123',
                    fname: 'voluptarem Bhatia',
                    designation: ' Accountant',

                    username: 'VBhatia',

                    icon: 'fa-times',
                    class: 'red',
                },
            ],
            Headers: [
                {
                    text: 'Expert id',
                    value: 'id',
                },
                {
                    text: 'Full Name',
                    value: 'fname',
                },
                {
                    text: 'Designation',
                    value: 'designation',
                },
                {
                    text: 'Username',
                    value: 'username',
                },
                {
                    text: '  ',
                    value: 'assign',
                },
                {
                    text: ' ',
                    value: 'edit',
                },
            ],
        }
    },
}
</script>

<style>
.pre-formatted {
    white-space: pre;
}
</style>
