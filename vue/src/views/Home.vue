<template>
  <v-container>
    <v-sheet class="d-flex justify-center">
      <h1 id="header">
        {{
          $store.state.token != ""
            ? `Hello, ${$store.state.user.username}!`
            : "Welcome to"
        }}
      </h1>
      <v-img
        id="bannerImg"
        max-height="100"
        max-width="200"
        src="../assets/logo.png"
      />
    </v-sheet>
    <!-- <div id="banner"></div> -->
    <div>
      <router-link v-bind:to="{ name: 'recipes' }">
        <div id="search">
          <h2 class="text"><span>Search for a Recipe</span></h2>
        </div></router-link
      >
      <router-link v-bind:to="{ name: 'user-portal' }">
        <div id="save">
          <h2 class="text"><span>Save Your Favorites</span></h2>
        </div>
      </router-link>
      <router-link v-bind:to="{ name: 'user-portal' }">
        <div id="mealplan">
          <h2 class="text"><span>Create a Weekly Meal Plan</span></h2>
        </div>
      </router-link>
    </div>

    <v-spacer></v-spacer>
    <div id="facts-container">
      <img
        id="img"
        class="ml-5"
        src="../assets/cartoonfood-cutout-cropped.png"
      />
      <p class="my-10 text-left" id="random-facts">
        <strong>Did you know?</strong>
        <span class="font-italic">{{ foodFacts[generateRandomFact()] }}</span>
      </p>
    </div>
    <!-- <p>Jokes about our team, bullet pointed. // Man bites dog, Zac bites backend // Katy commits grand theft auto and terrorizes the city; </p> -->
  </v-container>
</template>

<script>
// import AppService from '../services/AppService';

export default {
  name: "home",
  data: () => ({
    foodFacts: [
      "Until 2011, Russia classified beer and any other alcoholic beverages under 10% ABV as soft drinks.",
      "Cheese is the most stolen food in the world.",
      "Bananas are classified as berries, but strawberries are not.",
      "Lobsters and oysters used to be considered working class food.",
      "You can hear rhubarb grow.",
      "Large groups of pistachios can spontaneously combust.",
      "The stickers on fruit are edible.",
      "Calorie for calorie, healthy foods cost up to ten times as much as junk foods.",
      "The sandwich is said to have been invented by the Earl of Sandwich, a gambling addict who didn't want to leave the table to eat.",
      "Mushrooms cannot be overcooked.",
      "In the Middle Ages black pepper was a luxury, and was so expensive it was sometimes used to pay rent and taxes.",
      "Nutella uses 25% of the world's hazelnuts.",
      "In 1965 a corned beef sandwich was smuggled into space by Astronaut John Young.",
      "Loud music can make you drink more, and drink faster.",
      "There would be no chocolate if there were no flies",
      "McDonald's burgers don't rot. They have low moisture content which basically leaves the burgers dehydrated.",
      "In 16th Century England the upper classes served Surprise Pie. When the pie was cut, a live animal would jump out.",
      "Peanut butter can be used to make diamonds.",
      "McDonald's chicken nuggets come in four shapes, and they all have names: the boot, the ball, the bone, and the bell.",
      "In America on the 4th of July, the number of hot dogs consumed could stretch from Washington D.C. to Los Angeles 5 times over.",
    ],
    //
  }),
  methods: {
    generateRandomFact() {
      let randomFactNumber = Math.floor(Math.random() * this.foodFacts.length)
      return randomFactNumber
    },
  },
}
</script>

<style scoped>
#search {
  text-align: center;
  padding: 50px;
  background-image: url("../assets/dough-yellow.png");
  background-size: cover;
  background-position: center;
}

#save {
  text-align: center;
  padding: 50px;
  background-image: url("../assets/beets-red.png");
  background-size: cover;
  background-position: center;
}

#mealplan {
  text-align: center;
  padding: 50px;
  background-image: url("../assets/spices-orange.png");
  background-size: cover;
  background-position: center;
}

.text {
  color: white;
}

#search .text span {
  background-color: #f8d85696;
  border-radius: 10px;
  padding-right: 10px;
  padding-left: 10px;
  padding-top: 5px;
  padding-bottom: 5px;
  border: solid 2px #f8d856;
}

#save .text span {
  background-color: #ff454b9d;
  border-radius: 10px;
  padding-right: 10px;
  padding-left: 10px;
  padding-top: 5px;
  padding-bottom: 5px;
  border: solid 2px #ff454b;
}

#mealplan .text span {
  background-color: #f88a30a2;
  border-radius: 10px;
  padding-right: 10px;
  padding-left: 10px;
  padding-top: 5px;
  padding-bottom: 5px;
  border: solid 2px #f88a30;
}

#random-facts {
  border: solid 3px #2ea734;
  border-radius: 10px;
  padding: 10px;
  grid-area: random-facts;
}

#img {
  width: 100px;
  height: auto;
  grid-area: img;
  margin-top: auto;
  margin-bottom: auto;
}
#facts-container {
  display: grid;
  grid-template-columns: 1fr 4fr;
  grid-template-areas: "img random-facts";
}

#header {
  grid-area: header;
  margin-top: auto;
  margin-bottom: auto;
}

/* #banner {
  height: 130px;
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: "header logo";
}

#bannerImg {
  grid-area: logo;
  width: 45%;
  height: auto;
} */

a:link {
  text-decoration: none;
}
a:visited {
  text-decoration: none;
}
a:hover {
  text-decoration: none;
}
a:active {
  text-decoration: none;
}
</style>
