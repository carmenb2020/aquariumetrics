import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    /*{
      path: '/addmetric',
      name: 'AddMetric',
      component: AddMetricView
    },
    {
      path: '/editmetric/:id',
      name: 'EditMetric',
      component: EditMetricView
    }
    */
  ]
})

export default router
