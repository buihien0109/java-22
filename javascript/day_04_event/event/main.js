const p = document.querySelector("p");

// Khi nhấn vào button “Change content” hiển thị một nội dung quote bất kỳ
const changeContent = () => {
    const quotes = [
        "The greatest glory in living lies not in never falling, but in rising every time we fall.",
        "The way to get started is to quit talking and begin doing.",
        "If life were predictable it would cease to be life, and be without flavor.",
        "Life is what happens when you're busy making other plans.",
    ];
    const rdIndex = Math.floor(Math.random() * quotes.length);
    p.innerText = quotes[rdIndex];
};

// Khi nhấn vào button “Change color” thì thay đổi màu của thẻ p (sử dụng màu HEX - cần viết 1 function để random màu HEX)
const randomHexColor = () => {
    return "#" + Math.floor(Math.random() * 16777215).toString(16);
};

const btn2 = document.getElementById("btn-2");
btn2.onclick = () => {
    p.style.color = randomHexColor();
};

// Khi nhấn vào button “Change background” thì thay đổi màu background-color của thẻ p (sử dụng màu RGB - cần viết 1 function để random màu RGB)
const randomRgbColor = () => {
    let r = Math.floor(Math.random() * 256); // Random between 0-255
    let g = Math.floor(Math.random() * 256); // Random between 0-255
    let b = Math.floor(Math.random() * 256); // Random between 0-255
    return "rgb(" + r + "," + g + "," + b + ")";
};

const btn3 = document.getElementById("btn-3");
btn3.addEventListener("click", () => {
    p.style.backgroundColor = randomRgbColor();
});
