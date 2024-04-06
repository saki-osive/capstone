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
                    title: 'Farmer',
                    icon: 'fa-plus',
                    route: { name: 'FarmerIndex' },
                },
                // {
                //   title: 'InternationalBidder',
                //   icon: 'fa-circle',
                //   route: { name: 'InternationalBidderIndex' },
                // },

                {
                    title: 'Processor',
                    icon: 'fa-cube',
                    route: { name: 'ProcessorIndex' },
                },

                {
                  title: 'Distributor',
                  icon: 'fa-cube',
                  route: { name: 'TenderCreatorIndex' },
                },

                {
                  title: 'Retailer',
                  icon: 'fa-cube',
                  route: { name: 'TenderManagerIndex' },
                },

                {
                    title: 'Consumer',
                    icon: ' fa-binoculars', //fa-flask
                    route: { name: 'BidEvalExpert' },
                },

                {
                  title: 'OnBoarding',
                  icon: 'fa-users',
                  route: { name: 'OnBoardingIndex' },
                },


                {
                  title: 'CVO ',
                  icon: 'fa-address-card',
                  route: { name: 'CVOIndex' },
                },
                {
                    title: 'Government',
                    icon: 'fa-id-card',
                    route: { name: 'BidEvalChairman' },
                },
                {
                  title: 'Auditor',
                  icon: 'fa-id-card',
                  route: { name: 'AuditorIndex' },
                },
                // {
                //     title: 'Freight Forwarder',
                //     icon: 'fa-id-card',
                //     route: { name: 'FreightIndex' },
                // },
                // {
                //     title: 'Shipper',
                //     icon: 'fa-id-card',
                //     route: { name: 'ShipperIndex' },
                // },
                // {
                //   title: 'Clearing Agency',
                //   icon: ' fa-check-circle',
                //   route: { name: 'ClearingAgencyIndex' },
                // },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

