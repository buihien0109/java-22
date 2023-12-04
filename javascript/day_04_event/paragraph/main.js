// 1. Highlight tất cả các từ có độ dài lớn hơn hoặc bằng 5 ký tự trong đoạn văn (background = “yellow”)
const p = document.querySelector("p");
const content = p.innerText;
console.log(content);

const words = content.split(" ");
console.log(words);

// const newWords = [];
// words.forEach((word) => {
//     if (word.length >= 5) {
//         // khach => <span style="background-color: yellow">khach</span>
//         newWords.push(`<span style="background-color: yellow">${word}</span>`);
//     } else {
//         newWords.push(word);
//     }
// });
// console.log(newWords);

const newWords = words.map((word) => {
    // if (word.length >= 5) {
    //     // khach => <span style="background-color: yellow">khach</span>
    //     return `<span style="background-color: yellow">${word}</span>`;
    // } else {
    //     return word;
    // }

    return word.length >= 5 ? `<span style="background-color: yellow">${word}</span>` : word;
});
console.log(newWords);

p.innerHTML = newWords.join(" ");

// 2. Thêm link hiển thị text “facebook” link đến trang facebook.com ở sau thẻ p
p.insertAdjacentHTML("afterend", '<a href="https://facebook.com">facebook</a>');

// 3. Đếm số từ có trong đoạn văn. Tạo 1 thẻ div để hiển thị số từ
const characters = ["(", ")", ",", ".", "-"];
// const wordsWithoutCharacters = words.filter((word) => {
//     return !characters.includes(word);
// });
const wordsWithoutCharacters = [];
words.forEach((word) => {
    if (!characters.includes(word)) {
        wordsWithoutCharacters.push(word);
    }
});
console.log(wordsWithoutCharacters);
p.insertAdjacentHTML("afterend", `<div>${wordsWithoutCharacters.length} words</div>`);

// 4. Thay thế ký hiệu (, - dấu phẩy) => 🤔 và (. - dấu chấm) => 😲
p.innerHTML = p.innerHTML.replaceAll(",", "🤔");
p.innerHTML = p.innerHTML.replaceAll(".", "😲");