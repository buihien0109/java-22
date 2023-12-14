console.log("Hello world");
// alert("Hello world");

// Khai báo biến
// Khai báo biến và không gán giá trị cho biến
let age;
console.log(age, typeof age); // undefined

age = 35;
console.log(age, typeof age); // 35

age = true;
console.log(age, typeof age);

// Khai báo biến và gán giá trị cho biến
let email = "hien@techmaster.vn"
console.log(email, typeof email); // "hien@techmaster"

let address = null;
console.log(address, typeof address); // null

const PI = 3.14;
console.log(PI); // 3.14

const fullName = "Nguyen Van A";
const first_name = "Nguyen";
const $age = 35;

// template string - es6
let name = "Bùi Hiên"
let year = 1997

console.log(`Xin chào các bạn, mình tên là ${name}. Năm nay ${2023 - year} tuổi`); // ` backtick
console.log("Xin chào các bạn, mình tên là " + name + ". Năm nay " + (2023 - year) + " tuổi");

// function
// c1: Regular function
function sum(a, b) {
    return a + b;
}
console.log(sum(2, 3));

// c2: Function expression
const sum1 = function (a, b) {
    return a + b;
};
console.log(sum1(20, 30));

// c3: Arrow function - es6
const sum2 = (a = 10, b = 20) => { // default parameter - es6
    console.log(a, b);
    return a + b;
};

// const sum2 = (a, b) => a + b;
console.log(sum2(200, 300)); // a = 200, b = 300
console.log(sum2(200)); // a = 200, b = 20
console.log(sum2()); // a = 10, b = 20

// Viết hàm tính diện tích hình chữ nhật
const calcRectangleArea = (width, height) => width * height;