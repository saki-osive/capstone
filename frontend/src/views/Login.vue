<template>
  <v-app class="login">
    <v-img aspect-ratio="2" src="@/assets/login_bg.png">
      <v-container fluid fill-height>
        <v-layout align-start justify-space-around style="padding-top: 10%;">
          <v-flex xs12 sm10 md8 lg6>
            <v-card class="elevation-12">
              <v-toolbar color="#36454f" dark flat>
                <v-toolbar-title>Login</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                      label="Username"
                      prepend-icon="mdi-account"
                      v-model="input.email"
                      required
                  />
                  <v-text-field
                      :type="showPassword ? 'text' : 'password'"
                      label="Password"
                      prepend-icon="mdi-lock"
                      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                      @click:append="showPassword = !showPassword"
                      v-model="input.password"
                      required
                  />
                </v-form>
              </v-card-text>
              <v-card-actions class="justify-center">
                <v-btn color="#87CEEB" class="mx-2" style="width: 200px;" @click="loginClicked()">Login</v-btn>
                <v-btn color="secondary" class="mx-2" style="width: 250px;" to="/dashboard">Fake-Demo Login</v-btn>
              </v-card-actions>
              <v-card-actions class="justify-center">
                <v-btn color="#87CEEB" :to="{name: 'Register'}" style="width: 300px;">New to LotLock? Register Here</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
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
                                this.$router.push({ path: '/lotCreator' });
                                break;
                            case RoleConstants.ROLE_RETAILER:
                                this.$router.push({ path: '/retailer' });
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
                                this.$router.push({ path: '/government' });
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

<style>
.login {
  background-color: #f5f5f5;
}</style>
