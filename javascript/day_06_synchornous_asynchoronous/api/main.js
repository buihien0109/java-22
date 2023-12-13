/*
API: Application Programming Interface

Monolithic, Microservice: 

API: URL, HTTP Method, HTTP Status Code, Response Body, Request Body (tạo mới, cập nhật)
CRUD: Create (POST), Read (GET), Update (PUT, PATCH), Delete (DELETE)
*/

const btn = document.getElementById("btn");
const image = document.getElementById("image");

// Promise
btn.addEventListener("click", () => {
    fetch("https://dog.ceo/api/breeds/image/random") // GET method default
        .then(res => {
            console.log(res);
            return res.json();
        })
        .then(data => {
            console.log(data);
            image.src = data.message;
        })
        .catch(err => {
            console.log(err);
        });
});

// Async/Await
btn.addEventListener("click", async () => {
    try {
        let response = await fetch("https://dog.ceo/api/breeds/image/random")
        let data = await response.json(); // {message, status}
        image.src = data.message;
    } catch (error) {
        console.log(err);
    }
});
