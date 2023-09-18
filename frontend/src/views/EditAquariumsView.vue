<script setup>
    import DataConnection from '../services/DataConnection'
    import NavDecoration from '../components/NavDecoration.vue';
    import { ref, onBeforeMount, computed } from 'vue';
    import "@vuepic/vue-datepicker/dist/main.css";
    //import { vMaska } from "maska"
    import { useRouter, useRoute } from 'vue-router';
    
    const editedAquarium = ref({
    id: '',
    name: '',
    anh3: '',
    ano3: '',
    ano2: '',
    apo4: '',
    agh: '',
    akh: '',
    aph: '',
    })

    const router = useRouter();
    const route = useRoute();
    const aquarium = ref();
        
    const rules = [
    value => {
            if (!value) return 'Is required'
            else if (isNaN(value)) return 'Required number'
            else if (value < 0) return 'Required >= 0'
            else if (value > 99.9) return 'Max 99.9'
            else return true
        },
    ]

    const isFilledName = computed(() => {
        try {
            return (editedAquarium.value.name.trim() !== '');
            }
        catch (error) {
            alert('Name is required')
        }
    });

    const submit = async () => {
        if ((rules) && (isFilledName.value)) {
            await DataConnection.updateAquarium(editedAquarium.value.id, editedAquarium.value);
            alert(`Aquarium #${editedAquarium.value.id} updated `);
            router.push('/aquariums');
        } else {
            alert('Please fill in all required fields')
        }
    }

    const getAquariumById = async (id) => {
        let response = await DataConnection.getAquariumById(id);
        aquarium.value = response.data;
        editedAquarium.value.id = aquarium.value.id;
        editedAquarium.value.name = aquarium.value.name;
        editedAquarium.value.anh3 = aquarium.value.anh3;
        editedAquarium.value.ano3 = aquarium.value.ano3;
        editedAquarium.value.ano2 = aquarium.value.ano2;
        editedAquarium.value.apo4 = aquarium.value.apo4;
        editedAquarium.value.agh = aquarium.value.agh;
        editedAquarium.value.akh = aquarium.value.akh;
        editedAquarium.value.aph = aquarium.value.aph;
    };

    onBeforeMount(async() => {
        await getAquariumById(route.params.id);
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
                        Edit aquarium
                    </v-card-title>
                </v-card-item>
                
                <v-divider></v-divider>
                
                <v-sheet class="mx-auto">
                    <v-form @submit.prevent>
                        <v-container>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                    v-model="editedAquarium.name"
                                    label="Name"
                                    >
                                    </v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.anh3"
                                        :rules="rules"
                                        label="NH3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.ano2"
                                        :rules="rules"
                                        label="NO2"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.ano3"
                                        :rules="rules"
                                        label="NO3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.apo4"
                                        :rules="rules"
                                        label="PO4"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.agh"
                                        :rules="rules"
                                        label="GH"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.akh"
                                        :rules="rules"
                                        label="KH"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="editedAquarium.aph"
                                        :rules="rules"
                                        label="PH"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
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

<style>
    .container{
        margin-top:3rem;
    }
    .dp__theme_light {
        --dp-background-color: #dde4e6;
        --dp-icon-color: #09bcee;
        --dp-cell-size: 25px;
    }
</style>