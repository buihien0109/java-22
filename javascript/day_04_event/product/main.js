const products = [
    {
        id: 1,
        name: "Iphone 12",
        price: 20000000,
        brand: "Apple",
        thumbnail:
            "https://images.unsplash.com/photo-1510557880182-3d4d3cba35a5?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aXBob25lfGVufDB8fDB8fHww",
        rating: 4.5,
    },
    {
        id: 2,
        name: "Iphone 11",
        price: 15000000,
        brand: "Apple",
        thumbnail:
            "https://plus.unsplash.com/premium_photo-1681336999500-e4f96fe367f8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8aXBob25lfGVufDB8fDB8fHww",
        rating: 4.1,
    },
    {
        id: 3,
        name: "Iphone 10",
        price: 1200000,
        brand: "Apple",
        thumbnail:
            "https://images.unsplash.com/photo-1556656793-08538906a9f8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8aXBob25lfGVufDB8fDB8fHww",
        rating: 4.7,
    },
    {
        id: 4,
        name: "Iphone 9",
        price: 900000,
        brand: "Apple",
        thumbnail:
            "https://images.unsplash.com/photo-1530319067432-f2a729c03db5?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8aXBob25lfGVufDB8fDB8fHww",
        rating: 3.5,
    },
    {
        id: 5,
        name: "Iphone 8",
        price: 8500000,
        brand: "Apple",
        thumbnail:
            "https://images.unsplash.com/photo-1591337676887-a217a6970a8a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGlwaG9uZXxlbnwwfHwwfHx8MA%3D%3D",
        rating: 4.8,
    },
    {
        id: 6,
        name: "Iphone 7",
        price: 6000000,
        brand: "Apple",
        thumbnail:
            "https://images.unsplash.com/photo-1585060544812-6b45742d762f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGlwaG9uZXxlbnwwfHwwfHx8MA%3D%3D",
        rating: 3.0,
    },
];

const formatPrice = (price) => {
    return price;
};

const productListEl = document.querySelector(".product-list");

const renderProducts = () => {
    let html = "";
    products.forEach((p) => {
        html += `
            <div class="col-md-3">
                <div class="course-item shadow-sm rounded mb-4">
                    <div class="course-item-image">
                        <img src="${p.thumbnail}"
                            alt="${p.name}" />
                    </div>
                    <div class="course-item-info p-3">
                        <h2 class="fs-5 mb-4 text-dark">
                            ${p.name}
                        </h2>
                        <div
                            class="d-flex justify-content-between align-items-center fw-light text-black-50">
                            <p class="type">${p.brand}</p>
                            <p class="rating">
                                <span>${p.rating}</span>
                                <span class="text-warning"><i class="fa-solid fa-star"></i></span>
                            </p>
                        </div>
                        <p class="price text-danger fs-5">
                            ${formatPrice(p.price)}
                        </p>
                    </div>
                </div>
            </div>
        `;
    });
    productListEl.innerHTML = html;
};

renderProducts();
