<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="bideEvalExpertNavItems" :miniVariant="miniVariant" />
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
    name: 'bidEvalExpertIndex',
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
            bideEvalExpertNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: {name: 'ExpertDashboard'},
                },
                {
                    title: 'Assigned Bids',
                    icon: 'fa-square',
                    route: { name: 'AssignedBids' },
                },





            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
