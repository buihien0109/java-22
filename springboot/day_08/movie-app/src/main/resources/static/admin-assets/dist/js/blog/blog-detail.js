let currentPage = 1;
let images = [];
let totalPages = null;

// Gọi api lấy danh sách image
const getImages = (page) => {
    axios.get(`/api/admin/images?page=${page}`)
        .then(res => {
            images = res.data.content;
            totalPages = res.data.totalPages;
            renderImages(images);
            renderPagination(totalPages);
        })
        .catch(err => {
            console.log(err);
            toastr.error(err.response.data.message);
        })
}

// Render danh sách image
const imageContainerEl = document.querySelector('.image-container');
const btnChoseImage = document.getElementById('btn-chose-image');
const btnDeleteImage = document.getElementById('btn-delete-image');
const inputImageEl = document.getElementById('avatar');
const thumbnailPreviewEl = document.getElementById('thumbnail');

// Hiển thị danh sách ảnh
const renderImages = images => {
    let html = "";
    images.forEach(image => {
        html += `
                <div class="image-item" onclick="choseImage(this)" data-id="${image.id}">
                    <img src="${image.url}" alt="">
                </div>
        `
    });
    imageContainerEl.innerHTML = html;
}


// Render pagination
const renderPagination = totalPages => {
    let html = "";
    for (let i = 1; i <= totalPages; i++) {
        html += `
            <li class="page-item ${i === currentPage ? 'active' : ''}">
              <a class="page-link" onclick="chosePage(${i})">${i}</a>
            </li>
        `
    }
    document.querySelector('.pagination-container').innerHTML = `
        ${totalPages > 1 ? `
            <nav aria-label="...">
              <ul class="pagination">
                <li class="page-item ${currentPage === 1 ? 'disabled' : ''}">
                  <a class="page-link" onclick="prevPage()">Previous</a>
                </li>
                ${html}
                <li class="page-item ${currentPage === totalPages ? 'disabled' : ''}">
                  <a class="page-link" onclick="nextPage()">Next</a>
                </li>
              </ul>
            </nav>
        ` : ""}
    `;
}

const chosePage = page => {
    currentPage = page;
    getImages(currentPage);
}

const prevPage = () => {
    if (currentPage > 1) {
        currentPage--;
        getImages(currentPage);
    }
}

const nextPage = () => {
    if (currentPage < totalPages) {
        currentPage++;
        getImages(currentPage);
    }
}

const choseImage = el => {
    const selectedEl = document.querySelector(".image-item.selected");
    if (selectedEl) {
        selectedEl.classList.remove("selected");
    }

    el.classList.add("selected");
    btnChoseImage.disabled = false;
    btnDeleteImage.disabled = false;
}

// Chọn ảnh
btnChoseImage.addEventListener("click", () => {
    const selectedEl = document.querySelector(".image-item.selected");
    if (!selectedEl) {
        toastr.warning("Vui lòng chọn ảnh");
        return;
    }

    const imageUrl = selectedEl.querySelector("img").getAttribute("src");
    thumbnailPreviewEl.src = imageUrl;

    $('#modal-image').modal('hide');
})


// Upload ảnh
inputImageEl.addEventListener("change", async (e) => {
    // Lấy ra thông tin của file upload
    const file = e.target.files[0];

    // Tạo đối tượng formData
    const formData = new FormData();
    formData.append("file", file);

    // Call api sử dụng axios
    try {
        const res = await axios.post("/api/admin/images", formData);
        toastr.success("Upload ảnh thành công");

        // Hiển thị ảnh đã upload
        currentPage = 1
        getImages(currentPage);
    } catch (err) {
        console.log(err);
        toastr.error(err.response.data.message);
    }

    e.target.value = "";
})

// Xóa ảnh
btnDeleteImage.addEventListener("click", async () => {
    const selectedEl = document.querySelector(".image-item.selected");
    if (!selectedEl) {
        toastr.warning("Vui lòng chọn ảnh cần xóa");
        return;
    }

    const imageId = selectedEl.dataset.id;

    try {
        await axios.delete(`/api/admin/images/${imageId}`)
        btnChoseImage.disabled = true;
        btnDeleteImage.disabled = true;
        toastr.success("Xoá ảnh thành công");

        // Hiển thị ảnh đã upload
        currentPage = 1
        getImages(currentPage);
    } catch (err) {
        console.log(err);
        toastr.error(err.response.data.message);
    }
})

// Update blog
const btnUpdate = document.getElementById('btn-update');
const titleEl = document.getElementById('title');
const descriptionEl = document.getElementById('description');
const statusEl = document.getElementById('status');
const thumbnailEl = document.getElementById('thumbnail');

btnUpdate.addEventListener('click', () => {
    // validate
    // tạo data
    const data = {
        title: titleEl.value,
        content: easyMDE.value(),
        description: descriptionEl.value,
        status: statusEl.value === "true",
        thumbnail: thumbnailEl.getAttribute('src') === "" ? null : thumbnailEl.getAttribute('src')
    }
    console.log(data);
})

getImages(currentPage);