<script setup>
  import { RouterLink } from 'vue-router'
  
  const props = defineProps({
    metrics:{
      type: Object,
    },
    aquariums: {
      type:Object,
    }
  })

  const emit = defineEmits(['sendData']);
  
  const items = props.aquariums.map((item) => {
      let itemfilter = [];
      itemfilter.push(item.name);
      return itemfilter;
    });

  function sendData() {
    let aquariumSelected = document.getElementById("selected").value;
    emit('sendData', aquariumSelected);
  }

  
</script>

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

        <v-app-bar-title>Aquarium Metrics</v-app-bar-title>

        <v-btn value="aquariums">
          <v-icon icon="mdi:mdi-fishbowl"></v-icon>
          <span class="text-subtitle-1">Aquariums</span>
        </v-btn>


        <router-link to="/metrics" custom
                v-slot="{ navigate }">
          <v-btn value="metrics" @click="navigate"
                role="link">
             <v-icon icon="mdi: mdi-waves">
            </v-icon>
            <span class="text-subtitle-1">Metrics</span>
          </v-btn>
        </router-link>
        
        
        <v-btn value="graphics">
          <v-icon icon="mdi: mdi-chart-bar"></v-icon>
          <span class="text-subtitle-1">Graphics</span>
        </v-btn>
        
        <v-spacer></v-spacer>
        <v-card-text>
          <v-select
            label="Select an aquarium"
            :items="items"
            id="selected"
          >
          </v-select>
        </v-card-text>

        <v-btn icon @click="sendData()">
          <v-icon icon="mdi:mdi-magnify"></v-icon>
        </v-btn>

        
      </v-app-bar>

    </v-layout>
  </v-card>
</template>