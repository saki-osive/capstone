<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="dashboardNavItems" :miniVariant="miniVariant" />
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
    name: 'Dashboard',
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
            dashboardNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'Dashboard' },
                },

                {
                    title: 'Bidder',
                    icon: 'fa-address-card',
                    route: { name: 'BidderIndex' },
                },
                {
                  title: 'InternationalBidder',
                  icon: 'fa-circle',
                  route: { name: 'InternationalBidderIndex' },
                },

                {
                    title: 'Bidder Manager',
                    icon: 'fa-cube',
                    route: { name: 'BidderManagerIndex' },
                },

                {
                    title: 'CVO ',
                    icon: 'fa-users ',
                    route: { name: 'CVOIndex' },
                },
                {
                    title: 'OnBoarding',
                    icon: 'fa-address-card',
                    route: { name: 'OnBoardingIndex' },
                },
                {
                    title: 'Tender Manager',
                    icon: 'fa-binoculars',
                    route: { name: 'TenderManagerIndex' },
                },
                {
                    title: 'Tender Creator',
                    icon: 'fa-plus',
                    route: { name: 'TenderCreatorIndex' },
                },

                {
                    title: 'Bid Evaluation Expert',
                    icon: ' fa-flask',
                    route: { name: 'BidEvalExpert' },
                },
                {
                    title: 'Bid Evaluation Chairman',
                    icon: 'fa-id-card',
                    route: { name: 'BidEvalChairman' },
                },
                {
                  title: 'Auditor',
                  icon: 'fa-id-card',
                  route: { name: 'AuditorIndex' },
                },
                {
                    title: 'Freight Forwarder',
                    icon: 'fa-id-card',
                    route: { name: 'FreightIndex' },
                },
                {
                    title: 'Shipper',
                    icon: 'fa-id-card',
                    route: { name: 'ShipperIndex' },
                },
              {
                title: 'Clearing Agency',
                icon: ' fa-check-circle',
                route: { name: 'ClearingAgencyIndex' },
              },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

