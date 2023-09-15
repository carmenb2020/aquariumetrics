<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
        <RouterLink to="/"></RouterLink>
    </div>
  </header>
  <RouterView />
</template>

<style>
@font-face {
    font-family: 'inter-regular';
    src: url('./assets/fonts/static/Inter-Regular.ttf');
}

@font-face {
    font-family: 'inter-bold';
    src: url('./assets/fonts/static/Inter-Bold.ttf');
}

body {
    background-color: rgba(19, 142, 187, 0.74);
    background: no-repeat center
        linear-gradient(
            180.06deg,
            rgba(19, 142, 187, 0.74) -38.23%,
            rgba(254, 254, 254, 0.81) 139.89%
        );
    background-repeat: no-repeat;
    background-size: 100% auto;
    background-position: center top;
    background-attachment: fixed;
    font-family: 'inter-regular';
    font-size: 10px;
    color: white;
}

input {
    background: rgba(217, 217, 217, 0.08);
    border: 2px solid rgba(79, 79, 79, 0.09);
    border-radius: 20px;
}

h2 {
    margin: 0;
}

.centralize {
    display: flex;
    align-items: center;
    justify-items: center;
}

p {
    margin: 0;
}

</style>
