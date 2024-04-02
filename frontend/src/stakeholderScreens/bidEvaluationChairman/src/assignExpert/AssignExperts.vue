<template>
    <div class="text-center">
        <v-toolbar class="blue lighten-2">
            <v-toolbar-title>Expert Details</v-toolbar-title>
        </v-toolbar>
        <v-container mx-auto class="pre-formatted">
            <v-data-table :headers="headers" :items="covers" item-key="name">
                <template v-slot:item.edit="{ item }">
                    <v-btn small v-model="item.edit" text color="blue" outlined>Edit</v-btn>
                </template>

                <template v-slot:item.assign="{ item }">
                    <v-btn small v-model="item.assign" icon dark :class="item.class">
                        <v-icon>{{item.icon}}</v-icon>
                    </v-btn>
                </template>
            </v-data-table>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'ViewAllBids',

    data() {
        return {
            covers: [
                {
                    id: '121',
                    fname: 'Tapi',
                    lname: 'Sharma',
                    username: ' Tapish',
                    icon: 'fa-check',
                    class: 'green',
                },
                {
                    id: '122',
                    fname: 'Ravi',
                    lname: 'Shapal',
                    username: 'Ravish',
                    icon: 'fa-check',
                    class: 'green',
                },
                {
                    id: '123',
                    fname: 'voluptarem.',
                    lname: 'Bhatia',

                    username: 'VBhatia',

                    icon: 'fa-times',
                    class: 'red',
                },
            ],
            headers: [
                {
                    text: 'Bid id',
                    value: 'id',
                },
                {
                    text: 'First Name',
                    value: 'fname',
                },
                {
                    text: 'Last Name',
                    value: 'lname',
                },
                {
                    text: 'Username',
                    value: 'username',
                },
                {
                    text: 'Assigned for evaluation ',
                    value: 'assign',
                },
                {
                    text: ' ',
                    value: 'edit',
                },
            ],
        }
    },
}
</script>

<style>
.pre-formatted {
    white-space: pre;
}
</style>