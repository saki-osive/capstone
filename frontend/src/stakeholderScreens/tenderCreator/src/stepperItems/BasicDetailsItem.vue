<template>
    <div>
        <v-card>
            <v-form>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                           Tender name
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="input.name" outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Scope of work/job
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-textarea v-model="input.scopeOfWork" outlined></v-textarea>
                    </v-col>
                </v-row>
              <v-row>
                <v-col cols="4">
                  <v-subheader>
                    Tender Opening Date
                    <span class="red--text">*</span>
                  </v-subheader>
                </v-col>
                <v-col>
                  <v-menu
                      v-model="fromDateMenu"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      lazy
                      transition="scale-transition"
                      offset-y
                      full-width
                      max-width="290px"
                      min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field
                          outlined
                          placeholder="Select Tender Opening Date"
                          prepend-inner-icon="fa-calendar-alt"
                          readonly
                          v-model="input.referenceDate"
                          v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                        locale="en-in"
                        v-model="input.referenceDate"
                        no-title
                        @input="fromDateMenu = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="4">
                  <v-subheader>
                    Due Date and Time for Bid Submission
                    <span class="red--text">*</span>
                  </v-subheader>
                </v-col>
                <v-col>
                  <v-menu
                      v-model="dueSubmissionDateMenu"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      lazy
                      transition="scale-transition"
                      offset-y
                      full-width
                      max-width="290px"
                      min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field
                          outlined
                          placeholder="Select Tender Opening Date"
                          prepend-inner-icon="fa-calendar-alt"
                          readonly
                          v-model="input.dueDateForBidSubmission"
                          v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                        locale="en-in"
                        v-model="input.dueDateForBidSubmission"
                        no-title
                        @input="dueSubmissionDateMenu = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
                <v-col>
                  <v-menu
                      v-model="dueSubmissionTimeMenu"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      lazy
                      transition="scale-transition"
                      offset-y
                      full-width
                      max-width="290px"
                      min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field
                          outlined
                          placeholder="Choose Tender Opening Time"
                          prepend-inner-icon="fa-clock"
                          readonly
                          v-model="input.dueTimeForBidSubmission"
                          v-on="on"
                      ></v-text-field>
                    </template>
                    <v-time-picker
                        v-model="input.dueTimeForBidSubmission"
                        @input="dueSubmissionTimeMenu = false"
                    ></v-time-picker>
                  </v-menu>
                </v-col>
              </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Tender Reference Number
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="input.referenceNumber" outlined></v-text-field>
                    </v-col>
                </v-row>


                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Type of Bidding System
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-radio-group v-model="input.typeOfBiddingSystem">
                            <v-radio label="Single Bid System" value="single"></v-radio>

                            <v-radio label="Two Bid System" value="double"></v-radio>
                        </v-radio-group>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Tender Type
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-select
                            v-model="input.type"
                            :items="tenderTypeDataArray"
                            label="-select-"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Form of contract
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-select
                            v-model="input.formOfContract"
                            :items="formOfContractDataArray"
                            label="-select-"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            No of cover(s)
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-select
                            v-model="input.numberOfCover"
                            :items="noOfCoverArray"
                            label="-select-"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Tender Category
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-select
                            v-model="input.category"
                            :items="tenderCatagoryArray"
                            label="-select-"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Account Type Head
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-select
                            v-model="input.accountTypeHead"
                            :items="accountTypeHeadArray"
                            label="-select-"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            No of Bid Openers
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-select
                            v-model="input.numberOfBidOpeners"
                            :items="noOfBidsOpenersArray"
                            label="-select-"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Should allow re-bid Submission
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group v-model="input.allowReBidSubmission" :mandatory="true">
                                <v-radio label="Yes" value="Yes"></v-radio>
                                <v-radio label="No" value="No"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>Should allow Withdrawal of bids</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group v-model="input.allowWithdrawalOfBids">
                                <v-radio label="Yes" value="Yes"></v-radio>
                                <v-radio label="No" value="No"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Bid Security/ Earnest Money Deposit
                            (EMD)
                        </v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group v-model="input.bidSecurityEnabled">
                                <v-radio label="Applicable" value="Applicable"></v-radio>
                                <v-radio label="Not Applicable" value="NotApplicable"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col>
                        <span>
                            Amount: INR: Nil
                            <br />(Refer clause no. 16 of 1TB)
                        </span>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>Should Allow Offline Submission</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group v-model="input.allowOfflineSubmission">
                                <v-radio label="Yes" value="Yes"></v-radio>
                                <v-radio label="No" value="No"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>Should Allow Technical Evaluation</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-container fluid>
                            <v-radio-group v-model="input.allowTechnicalEvaluation">
                                <v-radio label="Yes" value="Yes"></v-radio>
                                <v-radio label="No" value="No"></v-radio>
                            </v-radio-group>
                        </v-container>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Date, Time & Venu of Pre-Bid Meeting
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-menu
                            v-model="preBidDateMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            max-width="290px"
                            min-width="290px"
                        >
                            <template v-slot:activator="{ on }">
                                <v-text-field
                                    outlined
                                    placeholder="Select Tender Opening Date"
                                    prepend-inner-icon="fa-calendar-alt"
                                    readonly
                                    v-model="input.preBidMeetingDate"
                                    v-on="on"
                                ></v-text-field>
                            </template>
                            <v-date-picker
                                locale="en-in"
                                v-model="input.preBidMeetingDate"
                                no-title
                                @input="preBidDateMenu = false"
                            ></v-date-picker>
                        </v-menu>
                    </v-col>
                    <v-col>
                        <v-menu
                            v-model="preBidTimeMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            max-width="290px"
                            min-width="290px"
                        >
                            <template v-slot:activator="{ on }">
                                <v-text-field
                                    outlined
                                    placeholder="Choose Tender Opening Time"
                                    prepend-inner-icon="fa-clock"
                                    readonly
                                    v-model="input.preBidMeetingTime"
                                    v-on="on"
                                ></v-text-field>
                            </template>
                            <v-time-picker
                                v-model="input.preBidMeetingTime"
                                @input="preBidTimeMenu = false"
                            ></v-time-picker>
                        </v-menu>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="input.venue" outlined single-line label="Venue"></v-text-field>
                    </v-col>
                </v-row>


                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Date and Time of Un-Priced Bid Opening
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-menu
                            v-model="unPricedBidOpeningDateMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            max-width="290px"
                            min-width="290px"
                        >
                            <template v-slot:activator="{ on }">
                                <v-text-field
                                    outlined
                                    placeholder="Select Tender Opening Date"
                                    prepend-inner-icon="fa-calendar-alt"
                                    readonly
                                    v-model="input.unPricedBidOpeningDate"
                                    v-on="on"
                                ></v-text-field>
                            </template>
                            <v-date-picker
                                locale="en-in"
                                v-model="input.unPricedBidOpeningDate"
                                no-title
                                @input="unPricedBidOpeningDateMenu = false"
                            ></v-date-picker>
                        </v-menu>
                    </v-col>
                    <v-col>
                        <v-menu
                            v-model="unPricedBidOpeningTimeMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            max-width="290px"
                            min-width="290px"
                        >
                            <template v-slot:activator="{ on }">
                                <v-text-field
                                    outlined
                                    placeholder="Choose Tender Opening Time"
                                    prepend-inner-icon="fa-clock"
                                    readonly
                                    v-model="input.unPricedBidOpeningTime"
                                    v-on="on"
                                ></v-text-field>
                            </template>
                            <v-time-picker
                                v-model="input.unPricedBidOpeningTime"
                                @input="unPricedBidOpeningTimeMenu = false"
                            ></v-time-picker>
                        </v-menu>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Contact Name
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="input.contactName" single-line label="Name" outlined></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Email & Phone NO.
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="input.email" outlined single-line label="E-mail"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field
                            v-model="input.phoneNumber"
                            single-line
                            label="Phone Number"
                            outlined
                        ></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>Should Allow Multi-Currency</v-subheader>
                    </v-col>
                    <v-col cols="3">
                        <v-radio-group v-model="input.shouldAllowMultiCurrency">
                            <v-radio label="Yes" value="Yes"></v-radio>
                        </v-radio-group>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>Payment Mode:</v-subheader>
                    </v-col>

                    <v-radio-group v-model="input.paymentMode">
                        <v-radio label="Online" value="Online"></v-radio>
                        <v-radio label="Offline" value="Offline"></v-radio>
                    </v-radio-group>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Availability of Tender Document on website
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="6">
                        <v-alert>
                            From 01.03.2019 to 12.03.2019 upto 1400 Hrs. IST on
                            following website:
                            <br />
                            <br />(i) Gail's Tender Website-
                            <br />
                            <br />(ii) Govt. CPP Portal- https://eprocure.gov.in
                            <br />
                            <br />(iii) GAIL's e-Procurement Portal (e-Portal)-
                            https://etender.gail.co.in [in case of e-Tendering]
                            <br />
                            <br />(iv) Government E-Market (Gem) Portal
                        </v-alert>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-subheader>
                            Completion Contract Period
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col cols="6">
                        <v-alert>
                            Contract Period shall be 33 months from the date of
                            fax of acceptance, as under:
                            <br />
                            <br />Commissioning/ inertisation: Within 27months
                            from date of Fax of acceptance.
                            <br />
                            <br />Contract closures and Project closeout:
                            6months after Commissioning/ inertisation of
                            pipeline.
                            <br />
                            <br />The date of commissioning/ inerttisation will
                            be considered as date of completion. Price Reduction
                            Schedule shall be applicable on any delay beyond 27
                            months from date of Fax of Acceptance.
                        </v-alert>
                    </v-col>
                </v-row>
            </v-form>
        </v-card>
    </div>
</template>

<script>
export default {
    name: 'BasicDetailsItem',
    data() {
        return {
            formOfContractDataArray: [
                'Fixed-rate',
                'Item-Rate',
                'Lump-sum',
                'Multi-Stage',
                'Percentage',
                'Piece-work',
                'Service',
                'Supply',
            ],
            noOfCoverArray: ['1', '2', '3', '4'],
            tenderCatagoryArray: ['Goods', 'Services', 'Works'],
            accountTypeHeadArray: [
                'Central Goverment Fund',
                'Others',
                'New Accounts Head',
                'State Govermant',
            ],
            noOfBidsOpenersArray: ['2 off 4', '2 off 3', '3 off 3', '2 off 2'],
            input: {
                name:'',
                scopeOfWork: '',
                referenceNumber: '',
                referenceDate: '',
                typeOfBiddingSystem: '',
                type: '',
                formOfContract: '',
                numberOfCover: '',
                category: '',
                accountTypeHead: '',
                numberOfBidOpeners: '',
                allowReBidSubmission: '',
                allowWithdrawalOfBids: '',
                bidSecurityEnabled: '',
                allowOfflineSubmission: '',
                allowTechnicalEvaluation: '',
                preBidMeetingDate: '',
                preBidMeetingTime: '',
                dueDateForBidSubmission: '',
                dueTimeForBidSubmission: '',
                unPricedBidOpeningTime: '',
                unPricedBidOpeningDate: '',
                venue: '',
                contactName: '',
                email: '',
                phoneNumber: '',
                shouldAllowMultiCurrency: '',
                paymentMode: '',
            },
            items: [
                {
                    text: 'Create New Tender',
                    disabled: false,
                    href: '',
                },
                {
                    text: 'Basic Details',
                    disabled: true,
                    href: '',
                },
            ],

            tabitems: [
                {
                    tab: 'Basic Details',
                },
                { tab: 'Cover Details' },
            ],
            tenderTypeDataArray: [
                'EOI',
                'Limited',
                'Open Limited',
                'Open Tender',
                'Single',
                'Test',
            ],
            fromDateMenu: false,
            preBidDateMenu: false,
            preBidTimeMenu: false,
            dueSubmissionDateMenu: false,
            dueSubmissionTimeMenu: false,
            unPricedBidOpeningDateMenu: false,
            unPricedBidOpeningTimeMenu: false,
        }
    },
}
</script>

<style lang="scss" scoped></style>
