<script setup>
    import DataConnection from '../services/DataConnection'
    import NavDecoration from '../components/NavDecoration.vue';
    import { ref, onBeforeMount, computed } from 'vue';
    import VueDatePicker from "@vuepic/vue-datepicker";
    import "@vuepic/vue-datepicker/dist/main.css";
    import { vMaska } from "maska"
    import { useRouter, useRoute } from 'vue-router';
    
    const editedMetric = ref({
    id: '',
    day: '',
    nh3: '',
    no3: '',
    no2: '',
    po4: '',
    gh: '',
    kh: '',
    ph: '',
    aquariums: {
        id: '',
    }
    })

    const router = useRouter();
    const route = useRoute();
    const metric = ref();
    const aquariums = ref();
    const items = ref();
    
        
    const rules = [
    value => {
            if (!value) return 'Is required'
            else if (isNaN(value)) return 'Required number'
            else if (value < 0) return 'Required >= 0'
            else if (value > 99.9) return 'Max 99.9'
            else return true
        },
    ]

    const isFilledDay = computed(() => {
        try {
            return (editedMetric.value.day.trim() !== '');
            }
        catch (error) {
            alert('Day is required')
        }
    });

    const submit = async () => {
        if ((rules) && (isFilledDay.value)) {
            await DataConnection.updateMetric(editedMetric.value.id, editedMetric.value);
            alert(`Metric #${editedMetric.value.id} updated `);
            router.push('/metrics');
        } else {
            alert('Please fill in all required fields')
        }
    }

    const getAquariums = async () => {
        let response = await DataConnection.getAllAquariums();
        aquariums.value = response.data;
        items.value = response.data.map((item) => {
        let itemfilter = [];
        itemfilter.push(item.name);
        return itemfilter;
        })
    }

    const getMetricById = async (id) => {
        let response = await DataConnection.getMetricById(id);
        metric.value = response.data;
        editedMetric.value.id = metric.value.id;
        editedMetric.value.day = metric.value.day;
        editedMetric.value.nh3 = metric.value.nh3;
        editedMetric.value.no3 = metric.value.no3;
        editedMetric.value.no2 = metric.value.no2;
        editedMetric.value.po4 = metric.value.po4;
        editedMetric.value.gh = metric.value.gh;
        editedMetric.value.kh = metric.value.kh;
        editedMetric.value.ph = metric.value.ph;
        editedMetric.value.aquariums.id = metric.value.aquariums.id;
        console.log(editedMetric.value);
    };

    onBeforeMount(async() => {
        await getMetricById(route.params.id);
        await getAquariums();
    });

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
                        Edit metric
                    </v-card-title>
                    
                </v-card-item>
                <VueDatePicker v-model="editedMetric.day" modelType="yyyy-MM-dd" dark></VueDatePicker>
                <v-divider></v-divider>
                
                <v-sheet class="mx-auto">
                    <v-form @submit.prevent>
                        <v-container>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.nh3"
                                        :rules="rules"
                                        label="NH3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.no2"
                                        :rules="rules"
                                        label="NO2"
                                        type="number"
                                        suffix="mg/l"
                                        step="0.1" 
                                        max="99.9"
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.no3"
                                        :rules="rules"
                                        label="NO3"
                                        type="number"
                                        suffix="mg/l"
                                        step="0.1" 
                                        max="99.9"
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.po4"
                                        :rules="rules"
                                        label="PO4"
                                        type="number"
                                        suffix="mg/l"
                                        step="0.1" 
                                        max="99.9"
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.gh"
                                        :rules="rules"
                                        label="GH"
                                        type="number"
                                        suffix="mg/l"
                                        step="0.1" 
                                        max="99.9"
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.kh"
                                        :rules="rules"
                                        label="KH"
                                        type="number"
                                        suffix="mg/l"
                                        step="0.1" 
                                        max="99.9"
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="editedMetric.ph"
                                        :rules="rules"
                                        label="PH"
                                        type="number"
                                        step="0.1" 
                                        max="99.9"
                                        min="0"
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-select
                                        v-model="editedMetric.aquariums.id"
                                        label="Aquarium"
                                        :items="aquariums"
                                        item-title="name"
                                        item-value="id"
                                        :rules="rules"
                                    >
                                    <template v-slot:item="{ props, item }">
                                        <v-list-item v-bind="props" :subtitle="item.raw.id"></v-list-item>
                                    </template>

                                    </v-select>
                                </v-col>
                            </v-row>
                        </v-container>

                    <v-btn type="submit" block class="mt-2" @click = submit()>Save</v-btn>
                    </v-form>
                </v-sheet>

            </v-card>
           
        </div>
        
    </main>
</template>

<style scoped>
    .container{
        margin-top:5rem;
    }
</style>