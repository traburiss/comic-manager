<template>
  <div id="app">
    <LoginIn msg="welcome comic manager"/>
  </div>
</template>

<script>
import LoginIn from "@/components/LoginIn";

export default {
  name: 'App',
  components: {
      LoginIn
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
  width: 100%;
}
</style>
