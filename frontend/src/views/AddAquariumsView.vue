<script setup>
    import DataConnection from '../services/DataConnection'
    import NavDecoration from '../components/NavDecoration.vue';
    import { ref, computed } from 'vue';
    import "@vuepic/vue-datepicker/dist/main.css";
    //import { vMaska } from "maska"
    
    const newAquarium = ref({
    id: '',
    name: '',
    anh3: '',
    ano2:'',
    ano3: '',
    apo4: '',
    agh: '',
    akh: '',
    aph: '',
    })

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
            return (newAquarium.value.name.trim() !== '');
            }
        catch (error) {
            alert('Name is required')
        }
    });

    const submit = async () => {
        if ((rules) && (isFilledName.value)){
            await DataConnection.addAquarium(newAquarium.value);
            alert(`New aquarium #${newAquarium.value.id} added`);
            location.reload();
        } else {
            alert('Please fill in all required fields')
        }
    }

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
                        Add new Aquarium
                    </v-card-title>
                </v-card-item>

                <v-divider></v-divider>
                
                <v-sheet class="mx-auto">
                    <v-form @submit.prevent>
                        <v-container>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                    v-model="newAquarium.name"
                                    label="Name"
                                    ></v-text-field>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    <v-text-field
                                        v-model="newAquarium.anh3"
                                        :rules="rules"
                                        label="NH3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newAquarium.ano2"
                                        :rules="rules"
                                        label="NO2"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newAquarium.ano3"
                                        :rules="rules"
                                        label="NO3"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newAquarium.apo4"
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
                                        v-model="newAquarium.agh"
                                        :rules="rules"
                                        label="GH"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newAquarium.akh"
                                        :rules="rules"
                                        label="KH"
                                        suffix="mg/l"
                                        step="0.1" 
                                        v-maska data-maska="##.#"
                                    ></v-text-field>
                                </v-col>
                                <v-col>
                                    <v-text-field
                                        v-model="newAquarium.aph"
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