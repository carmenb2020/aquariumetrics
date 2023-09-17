<template>
    <v-card max-width="448" class="mx-auto" color="grey-lighten-3">
      <v-layout>
        <v-app-bar
          color="teal-darken-4"
          image="https://picsum.photos/1920/1080?random">
          <template v-slot:image>
            <v-img
              gradient="to top right, rgba(19,84,122,.8), rgba(128,208,199,.8)"
            ></v-img>
          </template>
          <router-link to="/" custom
          v-slot="{ navigate }">
            <v-btn value="home" icon="mdi-home" size="x-large" @click="navigate"
              role="link">
            </v-btn>
          </router-link>
          
          <v-app-bar-title>
            Aquarium Metrics
          </v-app-bar-title>
  
          
  
        </v-app-bar>
  
      </v-layout>
    </v-card>
  </template>