<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="bidderNavItems" :miniVariant="miniVariant" />
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
    name: 'BidderManagerIndex',
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
            bidderNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'BidderDashboard' },
                },
                {
                    title: 'View Tenders For Bidding',
                    icon: 'fa-list',
                    route: { name: 'TendersList' },
                },
                {
                    title: 'My Submitted Bids',
                    icon: ' fa-minus-square',
                    route: { name: 'SubmittedBids' },
                },
              {
                title: 'Approved Bids',
                icon: 'fa-check-circle',
                route: { name: 'ApprovedBids' },
              },

                {
                    title: 'Profile',
                    icon: 'fa-users ',
                    route: { name: 'BidderProfile' },
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
