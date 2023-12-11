// Callback function là gì?

const funcA = (callback) => {
    callback();
};

const funcB = () => { };

funcA(funcB);

// Ví dụ 2
// const numbers = [1, 2, 3, 4, 5];
// numbers.forEach
// addEventListener
// numbers.map

const doTask = (name, time, cb) => {
    console.log("Thực hiện công việc: " + name);
    setTimeout(() => {
        cb();
    }, time);
}

const finish = () => {
    console.log("Hoàn thành công việc");
}

// doTask("Rửa bát", 2000, finish);

// Th1: Các tác vụ có liên quan đến nhau
// Nhặt rau - Rửa rau - Luộc rau
console.log("Start");
doTask("Nhặt rau", 3000, () => {
    doTask("Rửa rau", 2000, () => {
        doTask("Luộc rau", 4000, () => {
            finish();
        });
    });
});
console.log("End");

// Th2: Các tác vụ không liên quan đến nhau
// Ăn cơm - Lướt facebook - Check mail
// console.log("Start");
// doTask("Ăn cơm", 4000, () => {
//     console.log("Ăn cơm xong");
// });
// doTask("Lướt facebook", 2000, () => {
//     console.log("Lướt facebook xong");
// });
// doTask("Check mail", 2500, () => {
//     console.log("Check mail xong");
// });
// console.log("End");