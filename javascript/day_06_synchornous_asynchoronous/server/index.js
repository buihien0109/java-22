const fs = require('node:fs');

console.log("Start");
// const data = fs.readFileSync('test.txt', 'utf8');
// console.log(data);

fs.readFile('test.txt', 'utf8', (err, data) => {
    if (err) {
      console.error(err);
      return;
    }
    console.log(data);
  });

console.log("End");