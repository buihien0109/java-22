let user = {
    name: "Nguyễn Văn A",
    age: 23,
    email: "abc@gmail.com",
    address : {
        city: "Hà Nội",
        district: "Cầu Giấy",
        ward: "Xuân Thủy"
    },
    languages: ["Tiếng Việt", "Tiếng Anh", "Tiếng Nhật"],
    eat : function() {
        console.log("Eating");
    },
    drink : function(name) {
        console.log("Drinking : " + name);
    }
}
console.log(user.age);
user.drink("Coca Cola");
user.eat();


// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3
const printProduct = (products) => {
    products.forEach(product => {
        console.log(`${product.name} - ${product.price} - ${product.brand} - ${product.count}`);
    });
};
printProduct(products);

// 3. Tìm các sản phẩm của thuơng hiệu "Apple"
const findByBrand = (products, brand) => {
    return products.filter(product => product.brand === brand);
};
console.log(findByBrand(products, "Apple"));
console.log(findByBrand(products, "Samsung"));