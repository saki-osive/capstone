<template>
    <div>
        <p>
            <strong>Event Parameter</strong>
        </p>
        <v-row>
            <v-col cols="3">
                <v-chip class="ma-2" label>Currency</v-chip>
            </v-col>
          <v-row>
            <v-col cols="3">
                <v-select solo :items="currencies" v-model="input.currency"></v-select>
            </v-col>
          </v-row>

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
                  v-model="input.nameOfCompany"
              outline
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="3">
          <v-subheader>
            BID Amount
            <span class="red--text">*</span>
          </v-subheader>
        </v-col>
        <v-col>
          <v-text-field
                  v-model="input.bidAmount"
                  outline
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="3">
          <v-subheader>
            GST Number
            <span class="red--text">*</span>
          </v-subheader>
        </v-col>
        <v-col>
          <v-text-field
                  v-model="input.gstNumber"
              outline
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="3">
          <v-subheader>
            Tender Reference No
            <span class="red--text">*</span>
          </v-subheader>
        </v-col>
        <v-col>
          <v-text-field
              :value="this.tender.id"
              outline
              disabled
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="3">
          <v-subheader>
            Tender Type
            <span class="red--text">*</span>
          </v-subheader>
        </v-col>
        <v-col>
          <v-text-field
              :value="this.tender.type"
              outline
              disabled
          ></v-text-field>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="3">
          <v-subheader>
            Tender Category
            <span class="red--text">*</span>
          </v-subheader>
        </v-col>
        <v-col>
          <v-text-field :value="this.tender.category"
              disabled
              outline
          ></v-text-field>
        </v-col>
      </v-row>
    </div>
</template>

<script>
export default {
    name: 'TenderInformation',
    props:["tender"],
    mounted(){
      console.log(this.tender.id);
    },
    methods:{

      updateUI(tenderVal){
        console.log("updateUI");
        this.tender = tenderVal;

      }
    },
    data() {
        return {
            input:{
                nameOfCompany:"",
                gstNumber:"",
                currency:""
            },
            currencies: [
                'Albania Lek',
                'Afghanistan Afghani',
                'Argentina Peso',
                'Aruba Guilder',
                'Australia Dollar',
                'Azerbaijan New Manat',
                'Bahamas Dollar',
                'Barbados Dollar',
                'Bangladeshi taka',
                'Belarus Ruble',
                'Belize Dollar',
                'Bermuda Dollar',
                'Bolivia Boliviano',
                'Bosnia and Herzegovina Convertible Marka',
                'Botswana Pula',
                'Bulgaria Lev',
                'Brazil Real',
                'Brunei Darussalam Dollar',
                'Cambodia Riel',
                'Canada Dollar',
                'Cayman Islands Dollar',
                'Chile Peso',
                'China Yuan Renminbi',
                'Colombia Peso',
                'Costa Rica Colon',
                'Croatia Kuna',
                'Cuba Peso',
                'Czech Republic Koruna',
                'Denmark Krone',
                'Dominican Republic Peso',
                'East Caribbean Dollar',
                'Egypt Pound',
                'El Salvador Colon',
                'Estonia Kroon',
                'Euro Member Countries',
                'Falkland Islands (Malvinas) Pound',
                'Fiji Dollar',
                'Ghana Cedis',
                'Gibraltar Pound',
                'Guatemala Quetzal',
                'Guernsey Pound',
                'Guyana Dollar',
                'Honduras Lempira',
                'Hong Kong Dollar',
                'Hungary Forint',
                'Iceland Krona',
                'India Rupee',
                'Indonesia Rupiah',
                'Iran Rial',
                'Isle of Man Pound',
                'Israel Shekel',
                'Jamaica Dollar',
                'Japan Yen',
                'Jersey Pound',
                'Kazakhstan Tenge',
                'Korea (North) Won',
                'Korea (South) Won',
                'Kyrgyzstan Som',
                'Laos Kip',
                'Latvia Lat',
                'Lebanon Pound',
                'Liberia Dollar',
                'Lithuania Litas',
                'Macedonia Denar',
                'Malaysia Ringgit',
                'Mauritius Rupee',
                'Mexico Peso',
                'Mongolia Tughrik',
                'Mozambique Metical',
                'Namibia Dollar',
                'Nepal Rupee',
                'Netherlands Antilles Guilder',
                'New Zealand Dollar',
                'Nicaragua Cordoba',
                'Nigeria Naira',
                'Norway Krone',
                'Oman Rial',
                'Pakistan Rupee',
                'Panama Balboa',
                'Paraguay Guarani',
                'Peru Nuevo Sol',
                'Philippines Peso',
                'Poland Zloty',
                'Qatar Riyal',
                'Romania New Leu',
                'Russia Ruble',
                'Saint Helena Pound',
                'Saudi Arabia Riyal',
                'Serbia Dinar',
                'Seychelles Rupee',
                'Singapore Dollar',
                'Solomon Islands Dollar',
                'Somalia Shilling',
                'South Africa Rand',
                'Sri Lanka Rupee',
                'Sweden Krona',
                'Switzerland Franc',
                'Suriname Dollar',
                'Syria Pound',
                'Taiwan New Dollar',
                'Thailand Baht',
                'Trinidad and Tobago Dollar',
                'Turkey Lira',
                'Turkey Lira',
                'Tuvalu Dollar',
                'Ukraine Hryvna',
                'United Kingdom Pound',
                'United States Dollar',
                'Uruguay Peso',
                'Uzbekistan Som',
                'Venezuela Bolivar',
                'Viet Nam Dong',
                'Yemen Rial',
                'Zimbabwe Dollar',
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>