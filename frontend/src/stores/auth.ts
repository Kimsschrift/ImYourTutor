import { defineStore } from "pinia";
import { ref } from "vue";
import { authService, User } from "../services/auth";

export const useAuthStore = defineStore("auth", () => {
  const user = ref<User | null>(null);
  const isAuthenticated = ref(false);
  const isLoading = ref(false);

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
      setUser(null);
    } finally {
      isLoading.value = false;
    }
  };

  const logout = async () => {
    try {
      await authService.logout();
      setUser(null);
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
    setUser,
    loadUser,
    logout,
    login,
  };
});
