<template>
    <div>
        <v-form>
            <v-toolbar color="#BD5C38">
                <v-toolbar-title>Add User</v-toolbar-title>
            </v-toolbar>
            <v-row>
                <v-col cols="3">
                    <v-subheader>User Name</v-subheader>
                </v-col>
                <v-col >
                    <v-text-field v-model="input.username" outlined></v-text-field>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>Password</v-subheader>
                </v-col>
                <v-col >
                    <v-text-field v-model="input.password" type="password" outlined></v-text-field>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>First Name</v-subheader>
                </v-col>
                <v-col >
                    <v-text-field v-model="input.firstName" outlined></v-text-field>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>Last Name</v-subheader>
                </v-col>
                <v-col>
                    <v-text-field v-model="input.lastName" outlined></v-text-field>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>Email</v-subheader>
                </v-col>
                <v-col >
                    <v-text-field v-model="input.email" outlined></v-text-field>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>Contact Primary</v-subheader>
                </v-col>
                <v-col >
                    <v-text-field v-model="input.primaryContact" outlined></v-text-field>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>Contact Secondary</v-subheader>
                </v-col>
                <v-col >
                    <v-text-field v-model="input.secondaryContact" outlined></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col cols="3">
                    <v-subheader>User Role</v-subheader>
                </v-col>
                <v-col >
                    <v-select
                        v-model="input.userRole"
                        placeholder="Select User Role"
                        :items="userRoleDataArray"
                        outlined
                    ></v-select>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="3">
                    <v-subheader>User Status</v-subheader>
                </v-col>
                <v-col >
                    <v-select
                        :items="userStatusDataArray"
                        placeholder="User Status"
                        v-model="input.userStatus"
                        outlined
                    ></v-select>
                </v-col>
            </v-row>
            <br />
            <div class="text-center">
                <v-btn class="primary" v-on:click="onAddUserClicked()">Add User</v-btn>
            </div>
        </v-form>
    </div>
</template>

<script>
export default {
    name: 'AddUser',
    data() {
        return {
            input: {
                userRole: '',
                username: '',
                firstName: '',
                lastName: '',
                password: '',
                email: '',
                primaryContact: '',
                secondaryContact: '',
                userStatus: '',
            },
            userStatusDataArray: ['Enable', 'Disable'],
            userRoleDataArray: [
                'ROLE_BIDDER_MANAGER',
                'ROLE_TENDER_CREATOR',
                'ROLE_TENDER_MANAGER',
                'ROLE_ADMIN',
                'ROLE_ONBOARDING',
                'ROLE_BID_EVALUATION_EXPERT',
                'ROLE_BID_EVALUATION_CHAIRMAN',
                'ROLE_CVO',
            ],
        }
    },
    methods:{
        onAddUserClicked(){
            console.log(this.input)

            //show loader
            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            });

            //hit api call
            this.input["roles"] = [this.input.userRole];
            
            this.$api.post('/auth/signup', this.input)
                .then((response) => {
                    loader.hide();
                    if (response.data.status === true){
                        this.showNotification("Success","User Created Successfully.")
                    }else {
                        this.showNotification("Error","Failed to register user.","info")
                    }

                }, (error) => {
                    loader.hide()
                    console.log(error)
                    this.showNotification("Error","Failed to register user.","error")
                });

        }
    }
}
</script>

<style lang="scss" scoped></style>
