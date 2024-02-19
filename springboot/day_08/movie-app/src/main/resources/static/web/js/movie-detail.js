const stars = document.querySelectorAll(".rating-container .star");
const ratingValue = document.getElementById("rating-value");

let currentRating = 0;

stars.forEach((star) => {
    star.addEventListener("mouseover", () => {
        resetStars();
        const rating = parseInt(star.getAttribute("data-rating"));
        highlightStars(rating);
    });

    star.addEventListener("mouseout", () => {
        resetStars();
        highlightStars(currentRating);
    });

    star.addEventListener("click", () => {
        currentRating = parseInt(star.getAttribute("data-rating"));
        ratingValue.textContent = `Bạn đã đánh giá ${currentRating} sao.`;
        highlightStars(currentRating);
    });
});

function resetStars() {
    stars.forEach((star) => {
        star.classList.remove("active");
    });
}

function highlightStars(rating) {
    stars.forEach((star) => {
        const starRating = parseInt(star.getAttribute("data-rating"));
        if (starRating <= rating) {
            star.classList.add("active");
        }
    });
}

// Xử lý mở modal đánh giá
let idReviewUpdate = null;
const modalReviewConfig = new bootstrap.Modal('#modalReview', {
    keyboard: false
})
const modalReviewTitleEl = document.getElementById("modal-review-title");
const reviewContentEl = document.getElementById("review-content");
const btnOpenModalReview = document.getElementById("btn-open-modal-review");

// Xử lý khi mở modal tạo mới review
btnOpenModalReview.addEventListener("click", () => {
    modalReviewConfig.show();
    modalReviewTitleEl.textContent = `Viết đánh giá`;
});

// Xử lý khi mở modal cập nhật review
const openModalUpdateReview = reviewId => {
    modalReviewConfig.show();
    modalReviewTitleEl.textContent = `Cập nhật đánh giá`;

    // Tìm kiếm review theo id
    const review = reviewList.find(review => review.id === reviewId);

    // Cập nhật dữ liệu cho modal
    reviewContentEl.value = review.comment;

    currentRating = review.rating;
    ratingValue.textContent = `Bạn đã đánh giá ${currentRating} sao.`;
    highlightStars(currentRating);

    // Lưu lại id review cần cập nhật
    idReviewUpdate = reviewId;
}

// Xử lý khi đóng modal
const modalReviewEl = document.getElementById('modalReview')
modalReviewEl.addEventListener('hidden.bs.modal', event => {
    // reset modal
    currentRating = 0;
    ratingValue.textContent = "";
    resetStars();
    reviewContentEl.value = "";

    // reset id review cần cập nhật
    idReviewUpdate = null;
})

// Xử lý khi click vào nút lưu đánh giá
const btnHandle = document.getElementById("btn-handle");
btnHandle.addEventListener("click", (e) => {
    e.preventDefault();

    if (idReviewUpdate) {
        updateReview();
    } else {
        createReview();
    }
})

// Tạo mới review
const createReview = () => {
    if (reviewContentEl.value.trim() === "") {
        alert("Vui lòng nhập nội dung đánh giá");
        return;
    }

    if (currentRating === 0) {
        alert("Vui lòng chọn số sao");
        return;
    }

    const data = {
        comment: reviewContentEl.value,
        rating: currentRating,
        movieId: movie.id
    }
    console.log(data);

    // Gọi API để tạo mới review
    axios.post("/api/reviews", data)
        .then((res) => {
            window.location.reload();
        })
        .catch((err) => {
            console.log(err);
            alert(err.response.data.message)
        });
}

// Cập nhật review
const updateReview = () => {
    if (reviewContentEl.value.trim() === "") {
        alert("Vui lòng nhập nội dung đánh giá");
        return;
    }

    if (currentRating === 0) {
        alert("Vui lòng chọn số sao");
        return;
    }

    const data = {
        comment: reviewContentEl.value,
        rating: currentRating,
        movieId: movie.id
    }
    console.log(data);

    // Gọi API để cập nhật review
    axios.put(`/api/reviews/${idReviewUpdate}`, data)
        .then((res) => {
            window.location.reload();
        })
        .catch((err) => {
            console.log(err);
            alert(err.response.data.message)
        });
}

// Xóa review
const deleteReview = id => {
    const isConfrim = confirm("Bạn có chắc chắn muốn xóa đánh giá này?");
    if (!isConfrim) return;

    // Gọi API để xóa review
    axios.delete(`/api/reviews/${id}`)
        .then((res) => {
            window.location.reload();
        })
        .catch((err) => {
            console.log(err);
            alert(err.response.data.message)
        });
}