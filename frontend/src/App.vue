<template>
  <div id="app">
    <GlobalLayout>
      <router-view />
    </GlobalLayout>
  </div>
</template>

<script setup lang="ts">
import GlobalLayout from './components/GlobalLayout.vue';
</script>

<style>
#app {
  height: 100vh;
}
</style>
