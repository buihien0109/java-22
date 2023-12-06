// todo : id, title, status
let todos = [
    {
        id: 1,
        title: "Đi chợ",
        status: false,
    },
    {
        id: 2,
        title: "Nấu cơm",
        status: true,
    },
    {
        id: 3,
        title: "Rửa bát",
        status: true,
    },
];

const inputEl = document.querySelector("#input-todo");
const btnAdd = document.querySelector("#btn-add");
const todoListEl = document.querySelector("ul");

const renderTodos = (todoList) => {
    todoListEl.innerHTML = "";
    if (todoList.length === 0) {
        todoListEl.insertAdjacentHTML(
            "afterbegin",
            "<li>Không có công việc nào trong danh sách</li>"
        );
        return;
    }

    let html = "";
    todoList.forEach((todo) => {
        html += `
                <li>
                    <input type="checkbox" ${
                        todo.status ? "checked" : ""
                    } onchange="toggleStatus(${todo.id})">
                    <span class="${todo.status ? "active" : ""}">${
            todo.title
        }</span>
                    <button onclick="editTodo(${todo.id})">Edit</button>
                    <button onclick="deleteTodo(${todo.id})">Delete</button>
                </li>
            `;
        // if(todo.status) {
        //     html += `
        //         <li>
        //             <input type="checkbox" checked>
        //             <span class="active">${todo.title}</span>
        //             <button>Edit</button>
        //             <button>Delete</button>
        //         </li>
        //     `
        // } else {
        //     html += `
        //         <li>
        //             <input type="checkbox">
        //             <span>${todo.title}</span>
        //             <button>Edit</button>
        //             <button>Delete</button>
        //         </li>
        //     `
        // }
    });
    todoListEl.innerHTML = html;
};

const randomId = () => {
    return Math.floor(Math.random() * 1000000);
};

// Thêm công việc
btnAdd.addEventListener("click", () => {
    // Lấy giá trị từ input
    const value = inputEl.value;

    // Kiểm tra giá trị input có rỗng hay không
    if (value.trim() === "") {
        alert("Tiêu đề công việc không được để trống");
        return;
    }

    // Tạo todo mới
    const newTodo = {
        id: randomId(),
        title: value,
        status: false,
    };

    // Thêm vào mảng todos
    todos.push(newTodo);

    // Render lại giao diện
    renderTodos(todos);

    inputEl.value = "";
});

// Xóa công việc
const deleteTodo = (id) => {
    console.log(id);
    const isConfirm = window.confirm(
        "Bạn có chắc chắn muốn xóa công việc này không?"
    );
    if (!isConfirm) return;

    todos = todos.filter((todo) => todo.id !== id);
    renderTodos(todos);
};

// Cập nhật tiêu đề công việc
const editTodo = (id) => {
    console.log(id);
    // Tìm kiếm cv cần sửa theo id
    const todo = todos.find((todo) => todo.id === id);

    // Sử dụng window.prompt để hiển thị popup nhập tiêu đề công việc
    let newTitle = window.prompt("Nhập tiêu đề công việc mới", todo.title);

    if (newTitle === null) return;
    if (newTitle.trim() === "") {
        alert("Tiêu đề công việc không được để trống");
        return;
    }

    // Cập nhật lại tiêu đề công việc
    todo.title = newTitle;

    // Render lại giao diện
    renderTodos(todos);
};

// Thay đổi trạng thái công việc
const toggleStatus = (id) => {
    console.log(id);
    const todo = todos.find((todo) => todo.id === id);
    todo.status = !todo.status;

    renderTodos(todos);
};

renderTodos(todos);
