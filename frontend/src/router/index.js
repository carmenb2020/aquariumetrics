import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MetricsView from '../views/MetricsView.vue'
import AddMetricsView from '../views/AddMetricsView.vue'
import EditMetricsView from '../views/EditMetricsView.vue'

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
    }
  ]
})

export default router
