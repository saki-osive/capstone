<template>
<div>
<v-toolbar flat class=" blue ma-0 pa-0"><v-toolbar-title>Port Details </v-toolbar-title></v-toolbar>
<v-card flat class="mx-12 my-4 ">
<h4 style="color:blue;"> Select the location: </h4>
<v-row> 
<v-col cols="3">
<v-select outlined single-line :items="states" label="State"/>  </v-col>
<v-col cols="3">

<v-select outlined single-line label="City"  :items="cities"/>
</v-col><v-btn color="blue" >Search </v-btn></v-row>

<v-container>
<pre>
              <h4> {{PortName}}</h4>
<br>Address                :       {{Address}}<br/>Port ID                :       {{PortID}}<br/>Name of the incharge   :       {{InchargeName}}<br/>Contact details        :       {{ContactNo}}<br/>Alternate Number       :       {{AltNo}}<br/>E-mail ID              :       {{Email}}



</pre>
</v-container>

</v-card>
</div>   
</template>

<script>
export default {
    data(){
return{

states:["Haryana", "Delhi", "Punjab", "Telangana"],
cities:["Panipat", "Chandigarh", "Hissar", "Jaipur", "Surat"],
ports:["Origin Warehouse","Origin Port", "Destination Port","Destination Warehouse" ],
PortName:"Steel and tin Warehouse",
PortID:"123",
Address:"Plot no. 78 and 79, North-west Road,Powder road, Gorakhpur ",
InchargeName:"Ramesh Chaturvedi",
ContactNo:"9886764569",
AltNo:"9876543210",
Email:"ramesh24@steelntin.com"
}
    }

}
</script>>