import { defineStore } from "pinia";
import { ref } from "vue";
import { authService, User } from "../services/auth";

export const useAuthStore = defineStore("auth", () => {
  const user = ref<User | null>(null);
  const isAuthenticated = ref(false);
  const isLoading = ref(false);
  const isInitialized = ref(false); // 초기화 상태 추가

  const setUser = (userData: User | null) => {
    user.value = userData;
    isAuthenticated.value = !!userData;
  };

  const loadUser = async () => {
    isLoading.value = true;
    try {
      const userData = await authService.getCurrentUser();
      setUser(userData);
    } catch (error) {
      console.log("User not authenticated or error occurred:", error);
      setUser(null);
    } finally {
      isLoading.value = false;
      isInitialized.value = true;
    }
  };

  const logout = async () => {
    try {
      await authService.logout();
      setUser(null);
      isInitialized.value = false; // 로그아웃 시 초기화 상태 리셋
    } catch (error) {
      console.error("Logout failed:", error);
    }
  };

  const login = () => {
    window.location.href = authService.getGoogleLoginUrl();
  };

  return {
    user,
    isAuthenticated,
    isLoading,
    isInitialized,
    setUser,
    loadUser,
    logout,
    login,
  };
});
