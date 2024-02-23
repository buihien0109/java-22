toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}

// Xử lý active menu
const activeMenu = () => {
    // Lấy ra đường dẫn hiện tại
    const pathName = window.location.pathname;
    console.log(pathName)

    // Lấy danh sách menu

    // Kiểm tra xem đường dẫn hiện tại có trùng với thuộc tính href của menu nào không?
    // Nếu có thì thêm class active vào menu đó
}

activeMenu();