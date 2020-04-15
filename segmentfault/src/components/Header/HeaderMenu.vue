<template>
  <div class="header_menu">
    <div
      :class="['menu_item', { 'active': index === active }]"
      v-for="(item,index) in list"
      :key="index"
    >
      <router-link :to="{path: item.href}">{{item.label}}</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HeaderMenu',
  data() {
    return {
      list: [
        { label: '首页', href: '/', type: 'link' },
        { label: '回答', href: '/', type: 'link' },
        { label: '专栏', href: '/', type: 'link' },
        { label: '资讯', href: '/', type: 'link' },
        { label: '课程', href: '/', type: 'link' },
        { label: '活动', href: '/', type: 'link' },
        { label: '发现', href: '/', type: 'show' },
      ],
      active: 0,
    };
  },
};
</script>

<style lang="less" scoped>
.header_menu {
  display: flex;
  .menu_item {
    &.active > a {
      color: var(--primary);
      font-weight: bold;
    }

    a {
      text-decoration: none;
      height: 34px;
      color: #757575;
      font-weight: 500;
      border-radius: 4px;
      padding: 10px 12px;

      &:hover {
        background: #F3F3F3;
      }
    }
  }
}
</style>
