<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="TenderManagerNavItems" :miniVariant="miniVariant" />
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
    name: 'TenderManagerIndex',
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
            TenderManagerNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'TenderDashboard' },
                },
                {
                    title: 'Active Tenders',
                    icon: 'fa-check',
                    route: { name: 'ActiveTenders' },
                },
                {
                    title: 'Pending Review',
                    icon: 'fa-spinner',
                    route: { name: 'PendingReview' },
                },
                {
                    title: 'Rejected Tenders ',
                    icon: 'fa-times',
                    route: { name: 'RejectedTenders' },
                },
                {
                    title: 'Upcoming Tenders ',
                    icon: ' fa-box-open',
                    route: { name: 'UpcomingTenders' },
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
