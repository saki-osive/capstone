<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="bideEvalChairmanNavItems" :miniVariant="miniVariant" />
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
    name: 'bidEvalChairmanIndex',
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
            bideEvalChairmanNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'BidEvalChairmanDashboard' },
                },

                {
                    title: 'Active Tenders',
                    icon: '',
                    route: { name: 'ActiveTendersForChairman' },
                },

                {
                    title: 'Pending Assignments',
                    icon: '',
                    route: { name: 'PendingAssignments' },
                },

                {
                    title: 'Track Bid Status',
                    icon: '',
                    route: { name: 'bidEvalChairmanBidStatus' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
