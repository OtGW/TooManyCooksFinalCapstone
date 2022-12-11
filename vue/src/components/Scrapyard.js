{
	/* 
	ORIGINAL Login.vue COMPONENT:
	<template>
	<div id="login" class="text-center">
		<form class="form-signin" @submit.prevent="login">
			<h1 class="display-1">Please Sign In</h1>
			<div class="alert alert-danger" role="alert" v-if="invalidCredentials">Invalid username and password!</div>
			<div class="alert alert-success" role="alert" v-if="this.$route.query.registration">Thank you for registering, please sign in.</div>
			<label for="username" class="sr-only">Username</label>
			<input type="text" id="username" class="form-control" placeholder="Username" v-model="user.username" required autofocus />
			<label for="password" class="sr-only">Password</label>
			<input type="password" id="password" class="form-control" placeholder="Password" v-model="user.password" required />
			<router-link :to="{ name: 'register' }">Need an account?</router-link>
			<button type="submit">Sign in</button>
		</form>
	</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
	name: 'login',
	components: {},
	data() {
		return {
			user: {
				username: '',
				password: '',
			},
			invalidCredentials: false,
		};
	},
	methods: {
		login() {
			authService
				.login(this.user)
				.then((response) => {
					if (response.status == 200) {
						this.$store.commit('SET_AUTH_TOKEN', response.data.token);
						this.$store.commit('SET_USER', response.data.user);
						this.$router.push('/');
					}
				})
				.catch((error) => {
					const response = error.response;

					if (response.status === 401) {
						this.invalidCredentials = true;
					}
				});
		},
	},
};
</script> 







ORIGINAL Register.vue COMPONENT:
<template>
	<div id="register" class="text-center">
		<form class="form-register" @submit.prevent="register">
			<h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
			<div class="alert alert-danger" role="alert" v-if="registrationErrors">
				{{ registrationErrorMsg }}
			</div>
			<label for="username" class="sr-only">Username</label>
			<input type="text" id="username" class="form-control" placeholder="Username" v-model="user.username" required autofocus />
			<label for="password" class="sr-only">Password</label>
			<input type="password" id="password" class="form-control" placeholder="Password" v-model="user.password" required />
			<input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password" v-model="user.confirmPassword" required />
						<router-link :to="{ name: 'login' }">Have an account?</router-link>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Create Account</button>
		</form>
	</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
	name: 'register',
	data() {
		return {
			user: {
				username: '',
				password: '',
				confirmPassword: '',
				role: 'user',
			},
			registrationErrors: false,
			registrationErrorMsg: 'There were problems registering this user.',
		};
	},
	methods: {
		register() {
			if (this.user.password != this.user.confirmPassword) {
				this.registrationErrors = true;
				this.registrationErrorMsg = 'Password & Confirm Password do not match.';
			} else {
				authService
					.register(this.user)
					.then((response) => {
						if (response.status == 201) {
							this.$router.push({
								path: '/login',
								query: { registration: 'success' },
							});
						}
					})
					.catch((error) => {
						const response = error.response;
						this.registrationErrors = true;
						if (response.status === 400) {
							this.registrationErrorMsg = 'Bad Request: Validation Errors';
						}
					});
			}
		},
		clearErrors() {
			this.registrationErrors = false;
			this.registrationErrorMsg = 'There were problems registering this user.';
		},
	},
};
</script>

<style></style>










*/
}
