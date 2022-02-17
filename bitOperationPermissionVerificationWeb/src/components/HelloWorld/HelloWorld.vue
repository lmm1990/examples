<script lang="ts" src="./HelloWorld.Service.ts"></script>
<template>
  <div class="greetings">
    <h3>当前权限值：{{ currentPermissionValue }}</h3>
  </div>
  <div class="permission-action">
    增加权限：
    <button @click="onAddPermission(1)">+浏览权限</button>
    <button @click="onAddPermission(2)">+添加权限</button>
    <button @click="onAddPermission(3)">+修改权限</button>
    <button @click="onAddPermission(4)">+删除权限</button>
  </div>
  <div class="permission-action">
    删除权限：
    <button @click="onDeletePermission(1)">-浏览权限</button>
    <button @click="onDeletePermission(2)">-添加权限</button>
    <button @click="onDeletePermission(3)">-修改权限</button>
    <button @click="onDeletePermission(4)">-删除权限</button>
  </div>
  <div class="actions">
    拥有权限：
    <a v-if="pagePermissions.view">查看</a>
    <a v-if="pagePermissions.add">添加</a>
    <a v-if="pagePermissions.edit">修改</a>
    <a v-if="pagePermissions.delete">删除</a>
  </div>
</template>

<style scoped>
.actions {
  margin-top: 1rem;
}
a {
  text-decoration: none;
  color: hsla(160, 100%, 37%, 1);
  transition: 0.4s;
  cursor: pointer;
  margin-left: 0.2rem;
}
.greetings {
  text-align: center;
}
.permission-action {
  margin-top: 1rem;
}
.permission-action button {
  margin-left: 1rem;
}
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}
</style>
