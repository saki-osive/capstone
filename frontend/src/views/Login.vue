<template>
    <v-app class="login">
        <v-img aspect-ratio="2" src="@/assets/login_bg.png">
            <v-card width="400" class="mx-auto mt-8">
                <v-toolbar>
                    <v-toolbar-title class="pb-0">
                        <h4>Member Login</h4>
                    </v-toolbar-title>
                </v-toolbar>
                <v-card-text>
                    <v-form @submit.prevent="login">
                        <v-text-field
                            label="Username"
                            prepend-icon="fa-user"
                            v-model="input.email"
                            text--primary
                            required
                        />
                        <v-text-field
                            :type="showPassword ? 'text' : 'password'"
                            label="Password"
                            v-model="input.password"
                            prepend-icon="fa-lock"
                            :append-icon="
                                showPassword ? 'fa-eye' : 'fa-eye-slash'
                            "
                            @click:append="showPassword = !showPassword"
                            text--primary
                            required
                        />
                    </v-form>
                </v-card-text>
                <v-divider></v-divider>

                <v-card-actions>
                    <v-btn color="info" width="385" v-on:click="loginClicked()"
                        >Login</v-btn
                    >
                </v-card-actions>
                <v-card-actions>

                    <v-btn color="info" width="385" to="/dashboard">Fake Login </v-btn>

                </v-card-actions>
                <v-row justify="center" align="center" >
                    <v-btn text
                    :to="{name: 'Register'}"
                     small>Request User ID (For New Farmers)</v-btn>
                </v-row>
            </v-card>
        </v-img>
    </v-app>
</template>

<script>
import { RoleConstants } from '@/datasource/RoleConstants'

export default {
    name: 'login',
    data() {
        return {
            showPassword: 'true',
            input: {
                email: null,
                password: null,
            },
        }
    },
    mounted() {
        this.$localStorage.set("email","");
        this.$localStorage.set("username","");
        this.$localStorage.set("token","");
    },

    methods: {
        saveDataToLocalStorage(loginResponse){

            this.$localStorage.set("email",loginResponse.email);
            this.$localStorage.set("name",loginResponse.username);
            this.$localStorage.set("token",loginResponse.token);

        },

        loginClicked() {
            let loader = this.$loading.show({
                container: this.$refs.formContainer,
                canCancel: false,
                onCancel: null,
            })

            this.$api.post('/auth/signin', this.input).then(
                response => {
                    loader.hide()
                    if (response.data.status === true) {
                        let role = response.data.roles[0];
                        this.saveDataToLocalStorage(response.data);
                        switch (role) {
                            case RoleConstants.ROLE_FARMER:
                                this.$router.push({ path: '/farmer' });
                                break;
                            case RoleConstants.ROLE_PROCESSOR:
                                this.$router.push({ path: '/processor' });
                                break;
                            case RoleConstants.ROLE_DISTRIBUTOR:
                                this.$router.push({ path: '/tenderCreator' });
                                break;
                            case RoleConstants.ROLE_RETAILER:
                                this.$router.push({ path: '/tenderManager' });
                                break;
                            case RoleConstants.ROLE_ADMIN:
                                this.$router.push({ path: '/farmer' });
                                break;
                            case RoleConstants.ROLE_ONBOARDING:
                                this.$router.push({ path: '/onboarding' });
                                break;
                            case RoleConstants.ROLE_CONSUMER:
                                this.$router.push({ path: '/consumer' });
                                break;
                            case RoleConstants.ROLE_GOVERNMENT:
                                this.$router.push({ path: '/bidEvalChairman' });
                                break;
                            case RoleConstants.ROLE_CVO:
                                this.$router.push({ path: '/cvo' });
                                break;
                                case RoleConstants.ROLE_SUSTAINABILITY_AUDITOR:
                                    this.$router.push({ path: '/auditorIndex' });
                                    break;
                            default:
                        }

                        this.showNotification('Success', 'Login Success')
                    } else {
                        this.showNotification(
                            'Error',
                            'Invalid Login details.',
                            'error'
                        )
                    }
                },
                error => {
                    loader.hide()
                    console.log(error)
                    this.showNotification(
                        'Error',
                        'Invalid Login details.',
                        'error'
                    )
                }
            )
        },
    },
}
</script>
