<template>
  <div>
    <AppBar @toMiniVariant="changeMiniVariant" />
    <SideBar :navItems="bidderNavItems" :miniVariant="miniVariant" />
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
name: "InternationalBidderIndex",
  components: {
    SideBar,
    AppBar,
    Footer,
  },
  methods: {
    changeMiniVariant() {
      this.miniVariant = !this.miniVariant
    },
  },
  data() {
    return {
      miniVariant: false,
      bidderNavItems: [
        {
          title: 'Dashboard',
          icon: 'fa-home',
          route: { name: 'InternationalBidderDashboard' },
        },

        {
          title: 'Profile',
          icon: 'fa-users ',
          route: { name: 'InternationalBidderProfile' },
        },
        {
          title: 'My Submitted Bids',
          icon: ' fa-minus-square',
          route: { name: 'InternationalSubmittedBids' },
        },
        {
          title: 'View Open Tenders',
          icon: 'fa-list',
          route: { name: 'InternationalTendersList' },
        },
        {
          title: 'Notifications',
          icon: 'fa-bell',
          route: { name: 'InternationalNotifications' },
        },

      ],
    }
  },
}
</script>

<style scoped>

</style>