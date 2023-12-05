// document.addEventListener('click', function () {
//     console.log('click');
// })

// document.addEventListener('mousedown', function () {
//     console.log('mousedown');
// })

// document.addEventListener('mousemove', function () {
//     console.log('mousemove');
// })

// document.addEventListener('mouseup', function () {
//     console.log('mouseup');
// })

document.addEventListener('click', function (event) {
    console.log(event);
    // Xóa hình tròn cũ đi (nếu có)
    const currentCircle = document.querySelector('.circle');
    if(currentCircle != null) {
        currentCircle.parentElement.removeChild(currentCircle);
    }

    // Tạo hình tròn
    const circleEl = document.createElement('div');
    circleEl.classList.add('circle');

    // Set vị trí cho hình tròn
    circleEl.style.top = `${event.offsetY - 50}px`;
    circleEl.style.left = `${event.offsetX - 50}px`;

    document.body.appendChild(circleEl);
})

// Vẽ mới lần đầu tiên
// Từ lần 2 -> di chuyển vị trí
// transition