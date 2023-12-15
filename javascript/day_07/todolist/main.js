// todo : id, title, status
const API_URL = "http://localhost:8080/todos"
let todos = [];

const inputEl = document.querySelector("#input-todo");
const btnAdd = document.querySelector("#btn-add");
const todoListEl = document.querySelector("ul");

// Gọi API lấy dữ liệu todos từ server và hiển thị ra ngoài giao diện
const getAllTodos = async () => {
    try {
        // Gọi API
        let response = await fetch(API_URL);
        let data = await response.json();
        console.log(data);

        // Lưu lại dữ liệu trả về từ server
        todos = data;

        // Hiển thị dữ liệu
        renderTodos(todos);
    } catch (error) {
        console.log(error)
    }
}

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
                    <input 
                        type="checkbox" ${todo.status ? "checked" : ""} 
                        onchange="toggleStatus(${todo.id})">
                    <span class="${todo.status ? "active" : ""}">
                        ${todo.title}
                    </span>
                    <button onclick="editTodo(${todo.id})">Edit</button>
                    <button onclick="deleteTodo(${todo.id})">Delete</button>
                </li>
            `;
    });
    todoListEl.innerHTML = html;
};

// Thêm công việc
btnAdd.addEventListener("click", async () => {
    // Lấy giá trị từ input
    const value = inputEl.value;

    // Kiểm tra giá trị input có rỗng hay không
    if (value.trim() === "") {
        alert("Tiêu đề công việc không được để trống");
        return;
    }

    // Tạo todo mới
    const newTodo = {
        title: value,
        status: false,
    };

    // Gọi API gửi dữ liệu lên server
    try {
        let response = await fetch(API_URL, {
            method: 'POST',
            body: JSON.stringify(newTodo),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        let data = await response.json(); // {id, title, status}
        console.log(data)

        // Reload
        // C1: window.location.reload();
        // C2: getAllTodos();
        // C3:
        // Thêm vào mảng todos
        todos.push(data);

        // Render lại giao diện
        renderTodos(todos);

        inputEl.value = "";
    } catch (error) {
        console.log(error)
    }
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

getAllTodos();
