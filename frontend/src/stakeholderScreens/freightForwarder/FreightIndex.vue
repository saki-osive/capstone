<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="FreightIndexItems" :miniVariant="miniVariant" />
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
    name: 'FreightIndex',
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
            FreightIndexItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'FreightDashBoard' },
                },
                {
                    title: 'Create Freight Order',
                    icon: 'fa-address-book',
                    route: { name: 'CreateFreightOrder' },
                },
                {
                    title: 'Pending Freight Request',
                    icon: 'fa-address-book',
                    route: { name: 'PendingFreightRequest' },
                },
                {
                    title: 'Status of Freight',
                    icon: 'fa-address-book',
                    route: { name: 'StatusOfFreight' },
                },
                {
                    title: 'Offline Discussion',
                    icon: 'fa-address-book',
                    route: { name: 'OfflineDiscussion' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

