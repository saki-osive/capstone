<template>
    <v-container app>
        <v-app-bar>
            <img src="../assets/img/gaillogo.png" alt />
            <v-toolbar-title>
                <h1> Tenders</h1>
            </v-toolbar-title>
        </v-app-bar>
        <v-card absolute flat color="#FFFFFF">
            <div>
                <h2 align="center">Welcome to e-Procurement Portal</h2>
            </div>
        </v-card>
        <div>
            <p align="center" class="font-weight-black">
                Bidder Self Registration For  Tenders
            </p>
            <p align="center">*Required</p>
            <p align="center" class="font-weight-black">Company Details</p>
        </div>
        <v-card width="70%" class="mx-auto mt-12" align="center">
            <v-form>
                <h1>Add New User</h1>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Username
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                                outlined
                                v-model="input.username"
                        ></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Name of Company
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                            outlined
                            v-model="input.companyName"
                        ></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Language
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>

                    <v-col>
                        <v-select
                            label="-select-"
                            :items="languageItems"
                            v-model="input.language"
                            outlined
                        ></v-select>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            E-Mail Address
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                            v-model="input.email"
                            outlined
                        ></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Password
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                                v-model="input.password"
                                outlined
                        ></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Mobile No
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                            v-model="input.mobile"
                            outlined
                        ></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            Address
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                            v-model="input.address"
                            outlined
                        ></v-text-field>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            GST No
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                            v-model="input.gstNumber"
                            outlined
                        ></v-text-field>
                    </v-col>
                </v-row>



                <v-row>
                    <v-col cols="3">
                        <v-subheader>
                            PAN Number
                            <span class="red--text">*</span>
                        </v-subheader>
                    </v-col>
                    <v-col>
                        <v-text-field
                            v-model="input.pan"
                            outlined
                        ></v-text-field>
                    </v-col>
                </v-row>

              <v-row>
                <v-col cols="3">
                  <v-subheader>
                    Bidder Type
                    <span class="red--text">*</span>
                  </v-subheader>
                </v-col>
                <v-col>
                  <v-select
                      label="-select-"
                      v-model="typeOfBidder"
                      :items="countryArray"
                      outlined
                  ></v-select>

                </v-col>
              </v-row>
              <v-row v-show="typeOfBidder === 'Domestic Bidder'">
                <v-card color="grey lighten-1" class="mx-auto" outlined>
                  <v-card-title class="justify-center">Documents Upload for Domestic Bidder</v-card-title>
                  <v-data-table :headers="headers" :items="coverDomesticBidder">
                    <template v-slot:item.adddoc="{ item }">
                      <v-file-input ref="inputUpload" v-model="item.file"  v-on:change="handleFileUpload(item)" dense></v-file-input>
                    </template>
                  </v-data-table>
                </v-card>
              </v-row>

              <v-row v-show="typeOfBidder === 'International Bidder'">
                <v-card color="grey lighten-1" class="mx-auto" outlined>
                  <v-card-title class="justify-center">Documents Upload for International Bidder</v-card-title>
                  <v-data-table :headers="headers" :items="coverInternationalBidder">
                    <template v-slot:item.adddoc="{ item }">
                      <v-file-input ref="inputUpload" v-model="item.file"  v-on:change="handleFileUpload(item)" dense></v-file-input>
                    </template>
                  </v-data-table>
                </v-card>
              </v-row>
                <v-row>
                    <v-col cols="1">
                        <v-checkbox class="mx-2"></v-checkbox>
                    </v-col>
                    <v-col>
                        Yes, I have read the data privacy statement and accept
                        the terms. Required Document : Scanned copy of the
                        Certificate of Incorporation / GST Registration
                        Certificate Select file to upload(PDF or JPG file with
                        maximum 300 KB in Size)
                    </v-col>
                </v-row>
                <v-row>
                    <v-col>Required Document:</v-col>
                </v-row>
                <v-row>
                    <v-col>
                        Scanned copy of the certificate of Incoporation / GSt
                        Registration Certificate
                    </v-col>
                </v-row>
                <v-row>
                    <v-col>
                        <input type="file" id="myFile" name="filename" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col>
                        <v-btn tile outlined Primary v-on:click="signup()"
                            >Submit</v-btn
                        >
                    </v-col>
                    <v-col>
                        <v-btn tile outlined Primary>Reset</v-btn>
                    </v-col>
                </v-row>
            </v-form>
        </v-card>
    </v-container>
</template>

<script>
export default {
    name: 'Register',
    data() {
        return {
            countryArray: [
                'Domestic Bidder',
                'International Bidder',
            ],
            typeOfBidder:"",
            languageItems: ['English', 'Hindi'],
            input: {
                email: '',
                companyName: '',
                gailVendorCode: '',
                gailTenderRef: '',
                language: '',
                telephone: '',
                mobile: '',
                address: '',
                gstNumber: '',
                country: '',
                gstCertificatePath: '',
                pOBoxLocation: '',
                pOBoxCountry: '',
                english: '',
                roles:["ROLE_BIDDER"]
            },
          headers: [
            {
              text: 'S.No.',
              value: 'sno',
            },
            { text: 'Cover Name', value: 'name' },
            { text: 'Cover Type', value: 'type' },
            { text: 'Cover Document', value: 'doc' },
            { text: 'Add Document', value: 'adddoc' },
          ],
          coverDomesticBidder: [
            {
              sno: 1,
              name: 'Bidder Domestic Profile Document',
              type: 'Standard Attachment',
              doc: 0,
              file:null
            },
            {
              sno: 2,
              name: 'Bidder Certificates',
              type: 'Standard Attachment  ',
              doc: 0,
              file:null
            },
          ],
          coverInternationalBidder: [
            {
              sno: 1,
              name: 'Bidder Profile Document',
              type: 'Standard Attachment',
              doc:  0 ,
              file:null
            },
            {
              sno: 2,
              name: 'Bidder Certificates/ Documentary Proof',
              type: 'Standard Attachment  ',
              doc: 0,
              file:null
            },
          ],
        }
    },
    mounted() {},
    methods: {
      handleFileUpload(item){

        console.log(item.name);
        let file = item.file
        console.log(file)
      },
        signup() {
            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            })

            this.$api.post('/auth/signup', this.input).then(
                response => {
                    loader.hide()
                    if (response.data.status === true) {
                        this.$router.push({ path: '/login' })
                        this.showNotification(
                            'Success',
                            'User Created Successfully.'
                        )
                    } else {
                        this.showNotification(
                            'Error',
                            'Failed to register user.',
                            'error'
                        )
                    }
                },
                error => {
                    loader.hide()
                    console.log(error)
                    this.showNotification(
                        'Error',
                        'Failed to register user.',
                        'error'
                    )
                }
            )
        },
        validateUI() {
            var result = false

            return result
        },
    },
}
</script>

<style lang="scss" scoped>
img {
    max-width: 50px;
    max-height: 30px;

    padding: 5px;
    width: 150px;
}
div h2 {
    color: red;
}
</style>
