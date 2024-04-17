<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="consumerNavItems" :miniVariant="miniVariant" />
        <v-main app>
            <v-container>
                <router-view></router-view>
            </v-container>
        </v-main>

        <Footer />
    </div>
</template>

<script>
import SideBar from '@/dashboard/layout/SideBar.vue'
import AppBar from '@/dashboard/layout/AppBar.vue'
import Footer from '@/dashboard/layout/Footer.vue'

export default {
    name: 'ConsumerIndex',
    methods: {
        changeMiniVariant() {
            this.miniVariant = !this.miniVariant
        },
    },
    components: {
        SideBar,
        AppBar,
        Footer,
    },
    data() {
        return {
            miniVariant: false,
            consumerNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: {name: 'ConsumerDashboard'},
                },
                {
                    title: 'Track Product Journey',
                    icon: 'fa-cube',
                    route: { name: 'ConsumerScanner' },
                },
                {
                  title: 'View Product Details',
                  icon: 'fa-binoculars',
                  route: {name: 'ConsumerDashboard'},
                },
                {
                  title: 'Provide Feedback',
                  icon: 'fa-square',
                  route: { name: 'AssignedProducts' },
                },
                {
                  title: 'Access Educational Content',
                  icon: 'fa-id-card',
                  route: {name: 'ConsumerDashboard'},
                },
                {
                  title: 'Profile',
                  icon: 'fa-users ',
                  route: { name: 'ConsumerProfile' },
                },
                {
                  title: 'Notifications',
                  icon: 'fa-bell',
                  route: { name: 'Notifications' },
                },


            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
