<template>
  <div :class="['header_search_wrapper', { 'full-width': focus }]">
    <div class="header_search_input">
      <input type="text" @focus="handleFocus" @blur="handleBlur" placeholder="搜索问题或关键字" />
      <i class="iconfont icon-search"></i>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HeaderSearchInput',
  data() {
    return {
      focus: false,
    };
  },
  methods: {
    handleFocus() {
      this.focus = true;
    },
    handleBlur() {
      this.focus = false;
    },
  },
};
</script>

<style lang="less" scoped>
.header_search_wrapper {
  position: absolute;
  right: 0;
  transition: all .5s;
  width: 200px;

  &.full-width {
    width: 100%;
  }
}
.header_search_input {
  position: relative;
  input {
    box-sizing: border-box;
    width: 100%;
    border-radius: 4px;
    padding: 6px 12px;
    padding-right: 24px;
    border: 1px solid #ccc;
    outline: 0;
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    transition: all .5s;
    font-size: 14px;
    line-height: 1.42858;
    color: #555;

    &:focus {
      border: 1px solid #3b99fc;
      -webkit-box-shadow: 0 0 3px 0px #3b99fc;
      box-shadow: 0 0 3px 0px #3b99fc;
    }

    &::placeholder {
      color: #999;
    }
  }

  .iconfont {
    position: absolute;
    color: #555;
    font-size: 18px;
    right: 5px;
    cursor: pointer;
  }
}
</style>
