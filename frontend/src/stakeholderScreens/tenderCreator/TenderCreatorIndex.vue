<template>
    <div>
        <AppBar @toMiniVariant="changeMiniVariant" />
        <SideBar :navItems="TenderCreatorNavItems" :miniVariant="miniVariant" />
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
    name: 'TenderCreatorIndex',
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
            TenderCreatorNavItems: [
                {
                    title: 'Dashboard',
                    icon: 'fa-home',
                    route: { name: 'TCDashboard' },
                },
                {
                    title: 'Create Tender',
                    icon: 'fa-plus',
                    route: { name: 'CreateTender' },
                },
                {
                    title: 'Active Tenders',
                    icon: 'fa-snowboarding',
                    route: { name: 'TenderCreatorActiveTenders' },
                },
                {
                    title: 'Draft Tenders',
                    icon: 'fa-drafting-compass',
                    route: { name: 'DraftTendersList' },
                },
                {
                    title: 'Tenders Sent for Approval',
                    icon: 'fa-spinner',
                    route: { name: 'ListOfTendersSentForApproval' },
                },
                {
                    title: 'Past Tenders',
                    icon: 'fa-snowboarding',
                    route: { name: 'PastTenders' },
                },
                {
                    title: 'Publishing of Corrigendum',
                    icon: 'fa-pencil-square',
                    route: { name: 'TenderSentForCorrigendum' },
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
