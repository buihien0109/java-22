// Khai báo array rỗng
let arr = [];

// Khai báo array
let number = [];

// Gán giá trị cho các phần tử của array thông qua chỉ số
number[0] = 1;
number[1] = "Bùi Hiên";
number[2] = true;
console.log(number);

// Khai báo và khởi tạo giá trị cho array
let myArr = [1, 2, 3, 4, true, false, "Nguyễn Văn A"];
console.log(myArr);

const names = ["Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C"];
names[0] = "Nguyễn Văn D";
console.log(names);

names.forEach(name => {
    console.log(name);
})

// java : student : id, name, age. Sort age ASC
myArr.sort();

let name = "Nguyễn Văn A";
console.log(name)

function test() {
    fullName = "Nguyễn Văn C";
    console.log(fullName);
}
test();
console.log(fullName);

for (var i = 0; i < names.length; i++) {
    console.log(names[i]);
}
console.log(i);

{
    var firstName = "Nguyễn Văn D";
    console.log(fullName);
}
console.log(firstName);