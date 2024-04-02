<template>
    <div>
        <v-navigation-drawer
            v-model="drawer"
            color="#bd5c38"
            :mini-variant="miniVariant"
            app
            fixed
            dark
        >
            <v-img
                v-if="!miniVariant"
                width="100%"
                src="@/assets/img/nav-head.jpg"
                gradient="to top right, rgba(100,115,201,.33), rgba(25,32,72,.7)"
            >
                <v-row align="end">
                    <v-col align="center">
                        <v-avatar color="white" size="100">
                            <v-icon size="50" color="black">fa-user-alt</v-icon>
                        </v-avatar>
                        <br>
                        <br>
                        <h3 class="nav-img">{{username}}</h3>
                        <h3 class="nav-img">{{email}}</h3>

                        <br>
                    </v-col>
                </v-row>
            </v-img>
            <v-list v-if="miniVariant" nav dense>
                <v-list-item-avatar color="white">
                    <v-icon color="black">fa-user-alt</v-icon>
                </v-list-item-avatar>
            </v-list>
            <v-divider></v-divider>

            <v-list nav dense>
                <v-list-item v-for="item in navItems" :key="item.title" link v-on:click="onListItemClicked(item)">
                    <v-list-item-icon>
                        <v-icon>{{ item.icon }}</v-icon>
                    </v-list-item-icon>

                    <v-list-item-content>
                        <v-list-item-title>{{ item.title }}</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
            <v-list nav dense>
                <v-list-item v-on:click="logoutClicked()">
                    <v-list-item-icon>
                        <v-icon>fa-sign-out-alt</v-icon>
                    </v-list-item-icon>

                    <v-list-item-content >
                        <v-list-item-title>Logout</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>

            <!-- For Testing -->
            <!-- 
            <v-list nav dense>
                <v-list-item :to="{name: 'Dashboard'}">
                    <v-list-item-icon>
                        <v-icon>fa-arrow-circle-left</v-icon>
                    </v-list-item-icon>

                    <v-list-item-content>
                        <v-list-item-title>Retun to Stakeholder Dashboard</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>-->
        </v-navigation-drawer>
    </div>
</template>

<script>
export default {
    name: 'SideBar',
    methods:{
        logoutClicked(){
            this.$router.replace({name:"Login"})
        },
        onListItemClicked(item){
            if (item.route){

                this.$router.push(item.route)
            }
        }
    },
    props: {
        navItems: {
            type: Array,
            required: true,
        },
        miniVariant: {
            type: Boolean,
            default: true,
        },
    },
    mounted() {
        this.email = this.$localStorage.get("email","");
        this.username = this.$localStorage.get("name","");

    },
    data() {
        return {
            drawer: true,
            username:"",
            email:""
        }
    },
}
</script>

<style lang="scss" scoped>
.nav-img {
    color: white;
}
</style>
