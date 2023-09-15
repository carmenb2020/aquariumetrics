<script setup>
    import { reactive } from 'vue';
    import DataConnection from '../services/DataConnection'

    const props = defineProps({
        metric:{
        type: Object,
        },
        data: {
            type: String,
        },
    })

    const reveal = reactive({ value: false });

    async function DeleteMetric(id) {
        await DataConnection.deleteMetricById(id);
        alert("Metric successfully deleted");
        location.reload();
    }
    
</script>

<template>
    <v-card
        class="mx-auto mt-15"
        max-width="364"
    >
        <v-card-text>
            <v-icon icon="mdi:mdi-fishbowl" color="info"></v-icon>
            <div class="text-caption">
                
                 {{metric.aquariums.name}}
            </div>
            <v-icon icon="mdi:mdi-calendar-month" color="warning"></v-icon> 
            <p class="text text--primary">
                
                {{(metric.day).toString()}}
            </p>
        </v-card-text>
        <v-card-actions>
            <v-btn
                variant="text"
                color="teal-accent-4"
                @click="reveal.value=true"
            >
                View More
            </v-btn>
        </v-card-actions>

        <v-expand-transition>
            <v-card
                v-if="reveal.value"
                class="v-card--reveal"
                style="height: 100%;"
            >
                <v-card-text class="pb-0">
                    <p>
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        NH3: {{ metric.nh3 }} mg/l
                    </p>
                    <p >
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        NO2: {{ metric.no2 }} mg/l
                    </p>
                    <p>
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        NO3: {{ metric.no3 }} mg/l
                    </p>
                    <p>
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        PO4: {{ metric.po4 }} mg/l
                    </p>
                    <p>
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        GH: &nbsp {{ metric.gh }} mg/l
                    </p>
                    <p>
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        KH: &nbsp {{ metric.kh }} mg/l
                    </p>
                    <p>
                        <v-icon icon="mdi: mdi-waves" color="success"></v-icon>
                        PH: &nbsp {{ metric.ph }} mg/l
                    </p>
                </v-card-text>
                <v-card-actions class="pt-0">
                    <v-btn
                        variant="text"
                        color="teal-accent-4"
                        @click="reveal.value=false"
                    >
                        Close
                    </v-btn>
                    <v-btn
                        variant="text"
                        color="error"
                        @click="DeleteMetric(metric.id)"
                    >
                        Delete
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-expand-transition>
    </v-card>
</template>
<style scoped>
    .v-card--reveal {
    bottom: 0;
    opacity: 1 !important;
    position: relative;
    width: 100%;
    }

    .cards{
    margin-top: 3rem;
    }
</style>