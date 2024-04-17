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
                //   title: 'InternationalFarmer',
                //   icon: 'fa-circle',
                //   route: { name: 'InternationalFarmerIndex' },
                // },

                {
                    title: 'Processor',
                    icon: 'fa-cube',
                    route: { name: 'ProcessorIndex' },
                },

                // {
                //   title: 'Distributor',
                //   icon: 'fa-cube',
                //   route: { name: 'LotCreatorIndex' },
                // },

                {
                  title: 'Distributor',
                  icon: ' fa-check-circle',
                  route: { name: 'DistributorIndex' },
                },

                {
                  title: 'Retailer',
                  icon: 'fa-cube',
                  route: { name: 'RetailerIndex' },
                },

                {
                    title: 'Consumer',
                    icon: ' fa-binoculars', //fa-flask
                    route: { name: 'ConsumerIndex' },
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
                    route: { name: 'GovernmentIndex' },
                },
                {
                  title: 'Auditor',
                  icon: 'fa-id-card',
                  route: { name: 'AuditorIndex' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

