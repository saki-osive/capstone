<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="biddermanagerNavItems" :miniVariant="miniVariant" />
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
    name: 'BidderManagerindex',
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
            biddermanagerNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'BidderManagerDashboard' },
                },

                {
                    title: 'Add Bidder',
                    icon: 'fa-users ',
                    route: { name: 'AddBidder' },
                },
                {
                    title: 'View All',
                    icon: 'fa-globe ',
                    route: { name: 'ViewAll' },
                },
                {
                    title: 'Pending for Review',
                    icon: 'fa-clock',
                    route: { name: 'PendingForReview' },
                },
                {
                    title: 'Suspended Bidder',
                    icon: ' fa-ban',
                    route: { name: 'SuspendedBidder' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
