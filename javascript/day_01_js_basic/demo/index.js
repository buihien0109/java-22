const fs = require('fs');

// console.log('Start');
// let content = fs.readFileSync('text.txt', 'utf8');
// console.log(content);
// console.log('End');

console.log('Start');
fs.readFile('text.txt', 'utf8', (err, content) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(content);
});
console.log('End');