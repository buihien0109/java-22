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

// Nhặt rau - Rửa rau - Luộc rau
// async function task1() {};
const handleTask = async () => {
    try {
        let rs = await doTask("Nhặt rau", 3000, true)
        console.log(rs);

        let rs1 = await doTask("Rửa rau", 2000, true)
        console.log(rs1);

        let rs2 = await doTask("Luộc rau", 4000, true)
        console.log(rs2);
    } catch (error) {
        console.log(error);
    }
};

handleTask();