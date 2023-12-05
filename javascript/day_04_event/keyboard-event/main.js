// // Lắng nghe sự kiện keydown
// document.addEventListener("keydown", function () {
//     console.log("keydown");
// });

// // Lắng nghe sự kiện keyup
// document.addEventListener("keyup", function () {
//     console.log("keyup");
// });

// // Lắng nghe sự kiện keypress
// document.addEventListener("keypress", function () {
//     console.log("keypress");
// });

// Lắng nghe sự kiện keydown
const input = document.querySelector("input");
const btn = document.querySelector("button");
const p = document.querySelector("p");
let history = [];

const search = () => {
    const value = input.value;
    if(value.trim() === "") {
        alert("Vui lòng nhập từ khóa");
        return;
    }
    p.innerText = `Kết quả bạn tìm kiếm là: ${value}`;
    input.value = "";
}

input.addEventListener("keydown", (e) => {
    console.log(e);
    if(e.keyCode === 13) {
        search();
    }
});
btn.addEventListener("click", search)

