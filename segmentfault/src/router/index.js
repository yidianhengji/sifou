import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const arr = require.context('../views', true, /\.vue$/).keys();
const routes = arr.map((v) => {
  const name = v.substring(2, v.indexOf('.vue'));
  return {
    path: `/${name}`,
    name,
    component: require(`@/views/${name}`).default,
  };
});

routes.unshift({
  path: '/',
  name: 'home',
  component: require('@/views/Home').default,
});

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
