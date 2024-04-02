<template>
    <div>
        <v-container app>
            <p class="font-weight-black">All Users status can be seen here.</p>
            <v-simple-table height="300px">
                <template v-slot:default>
                    <thead>
                        <tr>
                            <th class="text-left">#ID</th>
                            <th class="text-left">First Name</th>
                            <th class="text-left">Last Name</th>
                            <th class="text-left">UserID/EmployeeID</th>
                            <th class="text-left">Active</th>
                            <th class="text-left">Destination</th>
                            <th class="text-left">Group ID</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="item in details" :key="item.firstname">
                            <td>{{item.id}}</td>
                            <td>{{ item.firstname }}</td>
                            <td>{{ item.lastname }}</td>
                            <td>{{ item.userid }}</td>
                            <td>
                                <v-checkbox v-model="systemR" class="mx-2"></v-checkbox>
                            </td>
                            <td>{{ item.destination }}</td>
                            <td>{{ item.groupid }}</td>
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'ViewAll',
    data() {
        return {
            details: [
                {
                    id: '800',
                    firstname: 'Example',
                    lastname: 'last',
                    userid: '000',
                    destination: 'Xyz',
                    groupid: '9000',
                },
                {
                    firstname: '',
                    lastname: '',
                    userid: '',
                    destination: '',
                    groupid: '',
                },
                {
                    firstname: '',
                    lastname: '',
                    userid: '',
                    destination: '',
                    groupid: '',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>