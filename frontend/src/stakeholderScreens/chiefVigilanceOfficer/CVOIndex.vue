<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="CVONavItems" :miniVariant="miniVariant" />
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
    name: 'CVOIndex',
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
            CVONavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'CVODashboard' },
                },
                {
                    title: 'CVO Profile',
                    icon: 'fa-address-card',
                    route: { name: 'CVOProfile' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>

