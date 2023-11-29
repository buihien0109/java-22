const heading = document.getElementById("heading");
console.log(heading);

const heading1 = document.querySelector("#heading");
console.log(heading1);

const p1 = document.querySelector("p");
console.log(p1);

// console.log(document.getElementsByClassName("para")[0]);
// console.log(document.getElementsByClassName("para")[1]);

const p2 = document.querySelector("p.para"); //
console.log(p2);

const p3 = document.querySelector(".para + .para");
console.log(p3);

const paraList = document.querySelectorAll("p");
console.log(paraList);

// style -> inline style css
heading.style.color = "red";
heading.style.backgroundColor = "black";

// paraList.forEach(p => {
//     p.style.color = "blue";
//     p.style.fontSize = "20px";
// })

Array.from(paraList).map((p) => {
    p.style.color = "blue";
    p.style.fontSize = "20px";
});

// get content
console.log(heading.innerHTML);
console.log(heading.innerText);
console.log(heading.textContent);

const ul1 = document.querySelector(".box ul");
console.log(ul1.innerHTML);
console.log(ul1.innerText);
console.log(ul1.textContent);

// set content
heading.innerHTML = "Xin chào <span>Việt Nam</span>";
p1.innerText = "Hello <span>World</span>";

// insert
// document.body.prepend(p3);
// document.body.appendChild(p3);

const ul2 = document.querySelector("body > ul");
// console.log(ul2);
// document.body.insertBefore(p3, ul2);

// const btn = document.createElement("button");
// btn.innerText = "Click me";
// console.log(btn);
// document.body.insertBefore(btn, p1);

ul2.insertAdjacentElement("beforebegin", p3);
// p1.insertAdjacentElement("beforebegin", btn);
p1.insertAdjacentHTML("beforebegin", "<button>Click me</button>");

// xóa
// document.body.removeChild(p1);
p1.parentNode.removeChild(p1);

// thay thế
const image = document.createElement("img");
image.src =
    "https://plus.unsplash.com/premium_photo-1700316993751-e79a424660dd?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyfHx8ZW58MHx8fHx8";
image.alt = "Ảnh cô gái ngắm hoàng hôn";
document.body.replaceChild(image, p2);

// sao chép
const box = document.querySelector(".box");
const box2 = box.cloneNode(true);
console.log(box2);
heading.insertAdjacentElement("beforebegin", box2);

const box3 = box.cloneNode(false);
console.log(box3);

// classList
const h2 = document.querySelector("h2");
console.log(h2);

h2.classList.add("text-big", "text-bold", "text-red");
h2.classList.remove("text-big", "text-bold");

console.log(h2.classList.contains('text-red')); // true
console.log(h2.classList.contains('text-big')); // false

// setInterval(() => {
//     h2.classList.toggle("text-red");
// }, 100) // 1000ms = 1s

// count-down
let time = 10;
heading.innerText = `${time}s`;

let interval = setInterval(() => {
    time--;
    heading.innerText = `${time}s`;

    if(time == 0) {
        clearInterval(interval);
        heading.innerText = "Happy new year";
    }
}, 1000) // 1000ms = 1s

// hiển thị danh sách mạng xã hội
const socialList = [
    {
        name : "Facebook",
        url : "https://facebook.com"
    },
    {
        name : "Google",
        url : "https://google.com"
    },
    {
        name : "Instagram",
        url : "https://instagram.com"
    }
];

const socialMediaEl = document.querySelector(".social-media");
socialList.forEach((social) => {
    // const link = document.createElement("a");
    // link.innerText = social.name;
    // link.href = social.url;

    // socialMediaEl.appendChild(link);
    socialMediaEl.insertAdjacentHTML("beforeend", `<a href="${social.url}">${social.name}</a>`);
});