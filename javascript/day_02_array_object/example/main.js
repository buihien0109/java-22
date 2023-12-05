const selectEl = document.querySelector('.select');
const ulEl = document.querySelector('ul');
const liListEl = document.querySelectorAll('li');


document.addEventListener('click', (e) => {
    if (!selectEl.contains(e.target)) {
        ulEl.classList.remove('show');
    }
});

selectEl.addEventListener('click', () => {
    ulEl.classList.toggle('show');
});

liListEl.forEach((liEl) => {
    liEl.addEventListener('click', () => {
        liListEl.forEach((liEl) => {
            liEl.classList.remove('active');
        });
        selectEl.innerText = liEl.innerText;
        liEl.classList.add('active');
        ulEl.classList.remove('show');
    });
});