<script setup>
  import DataConnection from '../services/DataConnection'
  import { ref, onBeforeMount, computed } from 'vue';
  
  import Navbar from '../components/Navbar.vue'
  import Card from '../components/Card.vue'

  const aquariums = ref();
  const metrics = ref();

  defineProps({
    onSendData: {
      type: String
    }
  });

  const objectFromChild=ref();

  function RecoversFromSon(data){
    objectFromChild.value=data;
  }

  const myObject = computed(() => {
    return objectFromChild.value;
  });

  const getAquariums = async () => {
    let response = await DataConnection.getAllAquariums();
    aquariums.value = response.data;
  };

  const getMetrics = async () => {
    let response = await DataConnection.getAllMetrics();
    metrics.value = response.data;
    metrics.value.sort(((a, b) => {
      const orderByAquariums = (a.aquariums.id) - (b.aquariums.id);
      const orderByDate = new Date(b.day).getDate() - new Date(a.day).getDate();
      return (orderByAquariums === 0 ? orderByDate : orderByAquariums);
    }));
  };

  onBeforeMount(() => 
  {
    getAquariums();
    getMetrics();
  }
  )
</script>

<template>
  <header>
    <Navbar :metrics="metrics" :aquariums="aquariums" @sendData="RecoversFromSon"></Navbar>
  </header>
  <main>

    <v-container
      class="mb-6 mt-3"
    >
      <v-row
        align="center"
        no-gutters
        style="height: 150px;"
      >
        <v-col
        v-for="(metric,index) in metrics"
          :key="index"
        >
          <v-sheet class="pa-0 ma-1 bg-green-lighten-4" v-if="metric.aquariums.name === myObject">
            <Card :metric="metric" :data="myObject"></Card>
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>

  </main>
</template>
