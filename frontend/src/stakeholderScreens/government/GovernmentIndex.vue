<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="governmentNavItems" :miniVariant="miniVariant" />
        <v-main app>
            <v-container fluid>
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
    name: 'GovernmentIndex',
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
            governmentNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'GovernmentDashboard' },
                },

                {
                    title: 'Active Lots',
                    icon: 'fa-check',
                    route: { name: 'ActiveLotsForGovernment' },
                },

                {
                    title: 'Pending Assignments',
                    icon: 'fa-spinner',
                    route: { name: 'PendingAssignments' },
                },

                {
                    title: 'Track Product Status',
                    icon: 'fa-cube',
                    route: { name: 'TrackProductStatus' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
