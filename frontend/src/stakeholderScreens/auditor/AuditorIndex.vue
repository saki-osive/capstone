<template>
  <div>
    <AppBar @toMiniVariant="changeMiniVariant" />
    <SideBar :navItems="auditorNavItems" :miniVariant="miniVariant" />
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
  name: "AuditorIndex",
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
        auditorNavItems: [
          {
            title: 'Dashboard',
            icon: 'fa-home',
            route: { name: 'AuditorIndex' },
          },
          {
            title: 'AuditLogs',
            icon: 'fa-address-book',
            route: { name: 'AuditorLogs' },
          },
          {
            title: 'Blockchain Logs',
            icon: 'fa-address-book',
            route: { name: 'AuditorLogs' },
          },
        ],
      }
    },
  }
</script>

<style scoped>

</style>