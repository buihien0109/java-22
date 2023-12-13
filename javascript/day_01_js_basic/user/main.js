const API_URL = "https://api.github.com/users";
const ITEM_PER_PAGE = 5;

let userList = [];
let currentUserList = [];
let currentPage = 1;
let totalPages = 0;

const getAllUsers = async () => {
    try {
        let res = await axios(API_URL);
        userList = res.data;
        currentUserList = [...userList];
        renderPaginationAndUser(currentUserList);
    } catch (error) {
        console.log(error);
    }
};

const tableBodyEl = document.querySelector(".list-user tbody");
const renderUsers = (users) => {
    let html = "";
    users.forEach(user => {
        html += `
        <tr>
            <td>${user.id}</td>
            <td>
                <img src="${user.avatar_url}" alt="${user.login}">
            </td>
            <td>${user.login}</td>
            <td>${user.html_url}</td>
            <td>${user.repos_url}</td>
        </tr>
        `;
    });
    tableBodyEl.innerHTML = html;
};

const renderPaginationAndUser = (users) => {
    renderUsers(getUsersPerPage(users));
    renderPagination(users);
};

const getUsersPerPage = (users) => {
    const start = (currentPage - 1) * ITEM_PER_PAGE;
    const end = start + ITEM_PER_PAGE;
    return users.slice(start, end);
};

// Mặc định 10 user 1 trang
const paginationContainerEl = document.querySelector(".pagination-container");
const renderPagination = (users) => {
    totalPages = Math.ceil(users.length / ITEM_PER_PAGE);
    let html = "";
    if (totalPages <= 1) {
        paginationContainerEl.innerHTML = html;
        return;
    }
    html = `
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item ${currentPage === 1 ? "disabled" : ""}" onclick="prevPage()"><a class="page-link" href="#">Previous</a></li>
                ${Array.from({ length: totalPages })
                    .map((item, index) => {
                        return `
                                    <li class="page-item ${index + 1 === currentPage ? "active" : ""}" onclick="changePage(${index + 1})">
                                        <a class="page-link" href="#" onclick="changePage(${index + 1})">${index + 1}</a>
                                    </li>
                                `;
                    })
                    .join("")}
                <li class="page-item ${currentPage === totalPages ? "disabled" : ""}" onclick="nextPage()"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
        `;
    paginationContainerEl.innerHTML = html;
};

const changePage = (page) => {
    currentPage = page;
    renderPaginationAndUser(currentUserList);
};

const prevPage = () => {
    if (currentPage > 1) {
        currentPage--;
        renderPaginationAndUser(currentUserList);
    }
};

const nextPage = () => {
    if (currentPage < totalPages) {
        currentPage++;
        renderPaginationAndUser(currentUserList);
    }
};

const searchInputEl = document.querySelector(".seach-form-input");
const seachBtnEl = document.querySelector(".seach-form-button");

const seachUser = () => {
    const keyword = searchInputEl.value.trim();
    currentPage = 1;
    if (keyword === "") {
        currentUserList = [...userList];
        renderPaginationAndUser(currentUserList);
        return;
    }
    currentUserList = userList.filter((user) =>
        user.login.toLowerCase().includes(keyword.toLowerCase())
    );
    renderPaginationAndUser(currentUserList);
};

seachBtnEl.addEventListener("click", seachUser);
searchInputEl.addEventListener("keyup", (e) => {
    if (e.keyCode === 13) {
        seachUser();
    }
});

getAllUsers();
