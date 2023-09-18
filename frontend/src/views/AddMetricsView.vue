<script setup>
    import DataConnection from '../services/DataConnection'
    import NavDecoration from '../components/NavDecoration.vue';
    import { ref, onBeforeMount, computed } from 'vue';
    import VueDatePicker from "@vuepic/vue-datepicker";
    import "@vuepic/vue-datepicker/dist/main.css";
    //import { vMaska } from "maska"
    
    const newMetric = ref({
    id: "",
    day: '',
    nh3: '',
    no2:'',
    no3: '',
    po4: '',
    gh: '',
    kh: '',
    ph: '',
    aquariums: {
        id: '',
    }
    })

    const aquariums = ref();
    const metrics = ref();
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
        return (newMetric.value.day.trim() !== '');
        }
    catch (error) {
            alert('Day is required')
        }
    });

    const submit = async () => {
        if ((rules) && (isFilledDay.value)) {
            await DataConnection.addMetric(newMetric.value);
            alert(`New metric #${newMetric.value.id} added`);
            location.reload();
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

    const getMetrics = async () => {
        let response = await DataConnection.getAllMetrics();
        metrics.value = response.data;
    };

    onBeforeMount(() => {
        getAquariums();
        getMetrics();
    })

</script>

<template>
    <header>
     <NavDecoration></NavDecoration>
    </header>
    <main>
        <v-container class="container">
            <v-card
            class="mx-auto"
            max-width="500"
            >
                <v-card-item class="bg-orange-darken-1">
                    <v-card-title>
                        Add new metric
                    </v-card-title>
                </v-card-item>

                <VueDatePicker v-model="newMetric.day" modelType="yyyy-MM-dd" ></VueDatePicker>

                <v-divider></v-divider>
                
                <v-sheet class="mx-auto">
                    <v-form @submit.prevent>
                        <v-container>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.nh3"
                                        :rules="rules"
                                        label="NH3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.no2"
                                        :rules="rules"
                                        label="NO2"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.no3"
                                        :rules="rules"
                                        label="NO3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.po4"
                                        :rules="rules"
                                        label="PO4"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.gh"
                                        :rules="rules"
                                        label="GH"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.kh"
                                        :rules="rules"
                                        label="KH"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="newMetric.ph"
                                        :rules="rules"
                                        label="PH"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-select
                                        v-model="newMetric.aquariums.id"
                                        label="Aquarium"
                                        :items="aquariums"
                                        item-title="name"
                                        item-value="id"
                                        id="selected"
                                        :rules="rules"
                                    >
                                    <template v-slot:item="{ props, item }">
                                        <v-list-item v-bind="props" :subtitle="item.raw.id"></v-list-item>
                                    </template>

                                    </v-select>
                                </v-col>
                            </v-row>
                            <v-row>
                                
                            </v-row>
                        </v-container>

                        <v-btn type="submit" block class="mt-2" @click = submit()>Save</v-btn>

                    </v-form>
                </v-sheet>

            </v-card>
           
        </v-container>
        
    </main>
</template>

<style>
    .container{
        margin-top:2rem;
    }

    .dp__theme_light {
        --dp-background-color: #dde4e6;
        --dp-icon-color: #09bcee;
        --dp-cell-size: 25px;
    }

</style>