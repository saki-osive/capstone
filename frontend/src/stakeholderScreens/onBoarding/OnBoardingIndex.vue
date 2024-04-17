<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="onBoardingNavItems" :miniVariant="miniVariant" />
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
    name: 'OnBoardingindex',
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
            onBoardingNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'OnboardingDashboard' },
                },
                {
                    title: 'Users Pending Review',
                    icon: 'fa-user-clock',
                    route: { name: 'UserPendingReview' },
                },
                {
                    title: 'Add User',
                    icon: 'fa-plus-circle',
                    route: { name: 'AddUser' },
                },
                {
                    title: 'View All ',
                    icon: 'fa fa-globe',
                    route: 'viewAll',
                },
                {
                    title: 'All User Roles ',
                    icon: 'fa-users ',
                    route: { name: 'AllUserRoles' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
