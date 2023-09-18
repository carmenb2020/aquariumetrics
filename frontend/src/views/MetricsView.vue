<script setup>
  import DataConnection from '../services/DataConnection'
  import { ref, reactive, onBeforeMount } from 'vue'
  import { RouterLink, useRouter } from 'vue-router'
  import NavDecoration from '../components/NavDecoration.vue'

  const	router = useRouter();
  const aquariums = ref();
  const metrics = reactive({value:[]});

  const getAquariums = async () => {
    let response = await DataConnection.getAllAquariums();
    aquariums.value = response.data
  };

  const getMetrics = async () => {
    let response = await DataConnection.getAllMetrics();
    metrics.value = response.data
    metrics.value.sort(((a, b) => {
      const orderByAquariums = (a.aquariums.id) - (b.aquariums.id);
      const orderByDate = new Date(b.day).getDate() - new Date(a.day).getDate();
      return (orderByAquariums === 0 ? orderByDate : orderByAquariums);
    }));
  };

  const editItem= (itemid) => {
    router.push({name: 'editmetric', params: {id: itemid}});
  }

  async function DeleteMetric(id) {
    await DataConnection.deleteMetricById(id);
    alert(`Metric #${id} successfully deleted`);
    location.reload();
  }

  onBeforeMount(() => {
    getAquariums();
    getMetrics();
  }
  );

</script>

<template>
  <header>
    <NavDecoration></NavDecoration>
  </header>
  <main>
    <div class="container">
      <v-card
      class="mx-auto"
      max-width="500"
      >
        <v-card-item class="bg-orange-darken-1">
          <v-card-title>
            Metrics List
          </v-card-title>

        <template v-slot:append>
          <router-link to="/addmetrics" custom
            v-slot="{ navigate }">
            <v-btn
              color="white"
              icon="mdi-plus-circle"
              size="small"
              variant="tonal"
              @click="navigate"
              role="link"
            ></v-btn>
          </router-link>
        </template>
      </v-card-item>
        
        <v-divider></v-divider>

        <v-virtual-scroll
          :items="metrics.value"
          height="320"
          item-height="48"
        >
          <template v-slot:default="{ item }">
            <v-list-item
              :title="`${item.day}`"
              :subtitle="`${item.aquariums.name}`"
            >
              <template v-slot:prepend>
                <v-icon class="bg-primary" icon="mdi-certificate"></v-icon>
              </template>
              <template v-slot:append>
                  <v-btn
                    icon="mdi-pencil"
                    size="x-small"
                    variant="tonal"
                    class="mx-3"
                    color="success"
                    @click="editItem(item.id)"
                    role="link"
                  ></v-btn>
                <v-btn
                  icon="mdi-trash-can-outline"
                  size="x-small"
                  variant="tonal"
                  color="error"
                  @click="DeleteMetric(item.id)"
                ></v-btn>
              </template>
            </v-list-item>
          </template>
        </v-virtual-scroll>
      </v-card>
    </div>
  </main>
</template>
<style scoped>
  .container{
    margin-top:5rem;
  }
</style>
