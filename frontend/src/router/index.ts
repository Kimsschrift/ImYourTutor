import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import LoginView from "../views/LoginView.vue";
import { useAuthStore } from "../stores/auth";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "StartPage",
    component: () => import("../views/StartPage.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: LoginView,
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    component: () => import("../views/DashboardView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// 라우터 가드 완전 제거 - 백엔드에서 OAuth 처리

export default router;
