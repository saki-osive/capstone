<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="retailerNavItems" :miniVariant="miniVariant" />
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
    name: 'RetailerIndex',
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
            retailerNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'RetailerDashboard' },
                },
                {
                    title: 'Active Lots',
                    icon: 'fa-check',
                    route: { name: 'ActiveLots' },
                },
                {
                    title: 'Pending Review',
                    icon: 'fa-spinner',
                    route: { name: 'PendingReview' },
                },
                {
                    title: 'Rejected Lots ',
                    icon: 'fa-times',
                    route: { name: 'RejectedLotDetails' },
                },
                {
                    title: 'Upcoming Lots ',
                    icon: ' fa-box-open',
                    route: { name: 'UpcomingLots' },
                },
                // {
                //     title: 'View Submissions ',
                //     icon: ' fa-fill-drip',
                //     route: { name: 'ViewSubmissions' },
                // },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
