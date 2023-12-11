// Promise
// const promise = new Promise((resolve, reject) => { });
// console.log(promise);

// const promiseSuccess = new Promise((resolve, reject) => {
//     resolve("Đi nhậu với bạn");
// });
// console.log(promiseSuccess);

// const promiseFail = new Promise((resolve, reject) => {
//     reject("Bận việc gia đình");
// });
// console.log(promiseFail);

// ==========================================
const doTask = (name, time, isOk) => {
    console.log("Thực hiện công việc: " + name);
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (isOk) {
                resolve("Hoàn thành công việc: " + name);
            } else {
                reject("Không thể hoàn thành công việc: " + name);
            }
        }, time);
    });
};

// Th1: Các tác vụ có liên quan đến nhau
// Nhặt rau - Rửa rau - Luộc rau
// doTask("Nhặt rau", 3000, true)
//     .then(rs => {
//         console.log(rs);
//         return doTask("Rửa rau", 2000, false);
//     })
//     .then(rs => {
//         console.log(rs);
//         return doTask("Luộc rau", 4000, true);
//     })
//     .then(rs => {
//         console.log(rs);
//     })
//     .catch(err => {
//         console.log(err);
//     })

// Th2: Các tác vụ không liên quan đến nhau
// Ăn cơm - Lướt facebook - Check mail
Promise.all([
    doTask("Ăn cơm", 3000, false),
    doTask("Lướt facebook", 2000, true),
    doTask("Check mail", 4000, true)
]).then((values) => {
    console.log(values);
}).catch(err => {
    console.log(err);
});