<template>
  <div class="header">
    <div class="container">
      <div class="logo">
        <a href="/"></a>
      </div>
      <div class="menu">
        <header-menu />
        <header-search-input />
      </div>
      <div class="opts">
        <header-opts/>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderMenuVue from './Header/HeaderMenu.vue';
import HeaderSearchInputVue from './Header/HeaderSearchInput.vue';
import HeaderOptsVue from './Header/HeaderOpts.vue';

export default {
  name: 'Header',
  components: {
    HeaderMenu: HeaderMenuVue,
    HeaderSearchInput: HeaderSearchInputVue,
    HeaderOpts: HeaderOptsVue,
  },
};
</script>

<style lang="less" scoped>
.header {
  border-top: 3px solid var(--primary);
  box-shadow: 0px 2px 10px 0px rgba(0, 0, 0, 0.1), 0 1px rgba(0, 0, 0, 0.1);
  background: var(--background);
}

@media (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media (min-width: 992px) {
  .container {
    width: 970px;
  }
}

@media (min-width: 1200px) {
  .container {
    width: 1140px;
  }
}

.container {
  height: 64px;
  line-height: 64px;
  margin: 0 auto;
  display: flex;

  .logo {
    a {
      width: 150px;
      display: block;
      background: url("../assets/logo.svg") no-repeat center;
      height: 64px;
    }
  }

  @media (min-width: 768px) {
    .menu {
      width: 50%;
    }
  }

  @media (min-width: 1200px) {
    .menu {
      width: 54%;
    }
  }

  .menu {
    display: flex;
    position: relative;
    margin-left: 20px;
  }
}
</style>
