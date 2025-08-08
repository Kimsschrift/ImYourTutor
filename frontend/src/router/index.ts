import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import LoginView from "../views/LoginView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    redirect: "/login",
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
  {
    path: "/dashboard",
    name: "dashboard",
    component: () => import("../views/DashboardView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// 라우터 가드 임시 비활성화
// router.beforeEach(async (to, from, next) => {
//   const authStore = useAuthStore();

//   if (!authStore.user && !authStore.isLoading) {
//     await authStore.loadUser();
//   }

//   if (to.meta.requiresAuth && !authStore.isAuthenticated) {
//     next("/login");
//   } else if (to.meta.requiresGuest && authStore.isAuthenticated) {
//     next("/dashboard");
//   } else {
//     next();
//   }
// });

export default router;
