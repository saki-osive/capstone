<template>
    <v-app app>
        <notifications position="bottom right" group="main" />
        <router-view></router-view>
    </v-app>
</template>

<script>
export default {
    name: 'App',

    components: {},
    data() {
        return {}
    },
}
</script>

<style lang="scss">


</style>