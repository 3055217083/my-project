<template>
  <AreaChooseTag @tabClick="tabClick"></AreaChooseTag>
</template>
<script lang="ts">

import {defineComponent} from 'vue';
import AreaChooseTag from './components/AreaChooseTab.vue'

export default defineComponent({
  components: {
    AreaChooseTag,
  },
  setup() {
    let pgSeq = 'CPG1'
    //子组件传递大区
    const tabClick = (targetKey: string) => {
      pgSeq = targetKey;
      console.log(pgSeq);
    };
    return {
      tabClick
    }
  },
});
</script>
<style scoped>
</style>
