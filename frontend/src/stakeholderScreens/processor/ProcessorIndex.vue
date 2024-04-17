<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="processorNavItems" :miniVariant="miniVariant" />
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
            processorNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'ProcessorDashboard' },
                },

                {
                    title: 'Add Farmer',
                    icon: 'fa-users ',
                    route: { name: 'AddFarmer' },
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
                    title: 'Suspended Farmer',
                    icon: ' fa-ban',
                    route: { name: 'SuspendedFarmer' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
