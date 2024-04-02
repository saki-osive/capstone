<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="ShipperIndexItems" :miniVariant="miniVariant" />
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
            ShipperIndexItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'ShipperDashboard' },
                },
                {
                    title: 'New Orders',
                    icon: 'fa-address-book',
                    route: { name: 'NewOrders' },
                },
                {
                    title: 'Active Orders',
                    icon: 'fa-address-book',
                    route: { name: 'ActiveOrders' },
                },
                {
                    title: 'History',
                    icon: 'fa-address-book',
                    route: { name: 'ShippingHistory' },
                },
                {
                    title: 'Ports',
                    icon: 'fa-address-book',
                    route: { name: 'Ports' },
                },
               
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

