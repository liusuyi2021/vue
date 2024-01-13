<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  methods: {
    login(){
      this.$router.push("/login");
    },
    getFirst() {
      this.$router.push("/first");
    },
    getSecond() {
      this.$router.push("/second");
    }
  }
}
</script>
<style>
#app {
  height: 100%;
}
</style>
