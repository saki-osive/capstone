<template>
    <v-app-bar absolute app flat>
        <v-app-bar-nav-icon @click="toMiniVariant"></v-app-bar-nav-icon>

        <v-toolbar-title>Tenders</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-avatar color="blue" size="36">
            <v-icon dark>mdi-account-circle</v-icon>
        </v-avatar>
        <v-menu offset-y>
            <template v-slot:activator="{ attrs, on }">
                <v-btn color="black" text small v-on="on" v-bind="attrs">{{name}}</v-btn>
            </template>

            <v-list>
                <v-list-item v-for="item in items" :key="item" link v-on:click="itemClicked()">
                    <v-list-item-title v-text="item"></v-list-item-title>
                </v-list-item>
            </v-list>
        </v-menu>
    </v-app-bar>
</template>
<script>
export default {
    mounted() {

        this.name =  this.$localStorage.get("name","User");
    },
    methods: {
        itemClicked(){

            this.$router.replace({name:"Login"})
        },
        toMiniVariant() {
            this.$emit('toMiniVariant')
        },
    },
    data() {
        return {
            name:"",
            items: ['Account Settings', 'Log out'],
        }
    },
}
</script>
