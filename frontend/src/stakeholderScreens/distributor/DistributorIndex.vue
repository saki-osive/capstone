<template>
  <div>
    <AppBar @toMiniVariant="changeMiniVariant" />
    <SideBar :navItems="DistributorIndexItems" :miniVariant="miniVariant" />
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
name: "DistributorIndex",
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
      DistributorIndexItems: [
        {
          title: 'Dashboard',
          icon: 'fa-home',
          route: { name: 'DistributorDashboard' },
        },
        {
          title: 'Orders from Producer',
          icon: 'fa-address-book',
          route: { name: 'ProducerProductLots' },
        },
        {
          title: 'All Product Lots',
          icon: 'fa-address-book',
          route: { name: 'AllProductLots' },
        },
        {
          title: 'Track Packaging Warehousing Distribution',
          icon: 'fa-address-book',
          route: { name: 'TrackProductLots' },
        },
      ],
    }
  },
}
</script>

<style scoped>

</style>