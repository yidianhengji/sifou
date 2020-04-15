<template>
  <div class="home">
    <sf-header/>
  </div>
</template>

<script>
import HeaderVue from '../components/Header.vue';

export default {
  name: 'Home',
  components: {
    SfHeader: HeaderVue,
  },
};
</script>
