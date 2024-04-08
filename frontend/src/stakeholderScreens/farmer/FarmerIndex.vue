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
    name: 'ProcessorIndex',
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
                    route: { name: 'FarmerDashboard' },
                },
                {
                  title: 'View Lot Records',
                  icon: ' fa-minus-square',
                  route: { name: 'SubmittedProducts' },
                },
                // {
                //     title: 'Create Lot Record',
                //     icon: 'fa-list',
                //     route: { name: 'LotRecordsList' },
                // },
                {
                  title: 'Create Lot Record',
                  icon: 'fa-list',
                  route: { name: 'CreateLotThroughFarmerDemo' },
                },
                {
                  title: 'Verify Certifications',
                  icon: 'fa-check-circle',
                  route: { name: 'ApprovedProducts' },
                },
                {
                    title: 'Profile',
                    icon: 'fa-users ',
                    route: { name: 'FarmerProfile' },
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
