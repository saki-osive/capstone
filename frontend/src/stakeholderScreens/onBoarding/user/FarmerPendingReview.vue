<template>
    <div>
        <v-toolbar class="blue lighten-2 mb-8">
            <v-toolbar-title>Products Pending Assignment</v-toolbar-title>
        </v-toolbar>
        <br />
        <v-row>
            <v-subheader inset>User ID/ User Name</v-subheader>

            <v-col cols="4" class="my-0 py-0">
                <v-text-field
                    v-model="search"
                    clearable
                    flat
                    solo-inverted
                    hide-details
                    prepend-inner-icon="fa-search"
                    label="Search"
                ></v-text-field>
            </v-col>
        </v-row>
        <br />
        <v-data-table :headers="headers" :items="covers" item-key="id" :search="search">
            <template v-slot:item.review="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.review"
                    text
                    :to="{name: 'ReviewUser'}"
                >Review</v-btn>
            </template>
        </v-data-table>
    </div>
</template>

<script>
export default {
    name: 'UserPendingReview',
    data() {
        return {
            headers: [
                {
                    text: 'User ID',
                    value: 'userID',
                },
                {
                    text: 'Company Name',
                    value: 'companyName',
                },
                {
                    text: 'Email Address',
                    value: 'email',
                },
                {
                    text: 'TENDER REF',
                    value: 'gailIndiaLotRef',
                },
                {
                    text: 'Review',
                    value: 'review',
                },
            ],
            covers: [
                {
                    userID: 'HGD78678DB',
                    companyName: 'Demo Company',
                    email: 'demo@gail.in',
                    gailIndiaLotRef: '8765678679',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>