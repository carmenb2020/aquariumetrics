import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MetricsView from '../views/MetricsView.vue'
import AddMetricsView from '../views/AddMetricsView.vue'
import EditMetricsView from '../views/EditMetricsView.vue'
import AquariumsView from '../views/AquariumsView.vue'
import AddAquariumsView from '../views/AddAquariumsView.vue'
import EditAquariumsView from '../views/EditAquariumsView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/metrics',
      name: 'metrics',
      component: MetricsView
    },
    {
      path: '/addmetrics',
      name: 'addmetrics',
      component: AddMetricsView
    },
    {
      path: '/editmetric/:id',
      name: 'editmetric',
      component: EditMetricsView
    },
    {
      path: '/aquariums',
      name: 'aquariums',
      component: AquariumsView
    },
    {
      path: '/addaquariums',
      name: 'addaquariums',
      component: AddAquariumsView
    },
    {
      path: '/editaquarium/:id',
      name: 'editaquarium',
      component: EditAquariumsView
    }
  ]
})

export default router
