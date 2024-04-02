<template>
  <div>
    <AppBar @toMiniVariant="changeMiniVariant" />
    <SideBar :navItems="ClearingAgencyIndexItems" :miniVariant="miniVariant" />
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
name: "ClearingAgencyIndex",
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
      ClearingAgencyIndexItems: [
        {
          title: 'Dashboard',
          icon: 'fa-home',
          route: { name: 'ClearingAgencyDashboard' },
        },
        {
          title: 'Orders For Custom Clearance',
          icon: 'fa-address-book',
          route: { name: 'CustomClearanceOrders' },
        },
        {
          title: 'All Freight Orders',
          icon: 'fa-address-book',
          route: { name: 'AllFreightOrders' },
        },
        {
          title: 'Track Packaging Warehousing Distribution',
          icon: 'fa-address-book',
          route: { name: 'TrackFreightOrders' },
        },
      ],
    }
  },
}
</script>

<style scoped>

</style>