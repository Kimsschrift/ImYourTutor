import apiClient from "./api";

export interface User {
  id: number;
  email: string;
  name: string;
}

export const authService = {
  async getCurrentUser(): Promise<User | null> {
    try {
      const response = await apiClient.get("/api/auth/me");
      return response.data;
    } catch (error) {
      return null;
    }
  },

  async logout(): Promise<void> {
    try {
      await apiClient.post("/api/auth/logout");
    } catch (error) {
      console.error("Logout error:", error);
    }
  },

  getGoogleLoginUrl(): string {
    return `${process.env.VUE_APP_API_BASE_URL}/oauth2/authorization/google`;
  },
};
