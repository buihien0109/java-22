// Lập trình đồng bộ, bất đồng bộ (Event Loop)
// Callback function
// Promise (ES6)
// Async/Await (ES7)

console.log("Start");
// setTimeout(function () {
//     console.log("Timeout");
// }, 1000);
fetch('https://jsonplaceholder.typicode.com/todos')
      .then(response => response.json())
      .then(json => console.log(json))
console.log("End");