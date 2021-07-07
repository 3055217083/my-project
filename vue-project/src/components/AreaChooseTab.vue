<template>
  <a-tabs v-model:activeKey="pgSeqKey" @tabClick="tabClickPgSeq">
    <a-tab-pane key="1" tab="1"></a-tab-pane>
    <a-tab-pane key="2" tab="2"></a-tab-pane>
    <a-tab-pane key="3" tab="3"></a-tab-pane>
    <a-tab-pane key="4" tab="4"></a-tab-pane>
    <a-tab-pane key="5" tab="5"></a-tab-pane>
  </a-tabs>
</template>

<script lang="ts">
import {defineComponent, ref} from "vue";

export default defineComponent({
  name: "AreaChooseTag",
  emits: ['tabClick'],
  props: [],
  setup(props, context) {
    let pgSeq = 'CPG1'
    //切换大区tab
    const tabClickPgSeq = (targetKey: string) => {
      pgSeq = targetKey;
      context.emit('tabClick', targetKey);
    };
    return {
      pgSeqKey: ref(pgSeq), tabClickPgSeq
    }
  },
})
</script>

<style scoped>

</style>
