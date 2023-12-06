const questions = [
    {
        title: "What is the capital of France?",
        choices: ["New York", "London", "Paris", "Dublin"],
        answer: "Paris"
    },
    {
        title: "What is the capital of Ireland?",
        choices: ["London", "New York", "Paris", "Dublin"],
        answer: "Dublin"
    },
    {
        title: "What is the capital of England?",
        choices: ["New York", "Paris", "London", "Dublin"],
        answer: "London"
    },
    {
        title: "What is the capital of America?",
        choices: ["Dublin", "New York", "London", "Paris"],
        answer: "New York"
    },
    {
        title: "What is the capital of Germany?",
        choices: ["London", "Paris", "New York", "Berlin"],
        answer: "Berlin"
    }
];

let currentQuestionIndex = 0;
let score = 0;
let yourAnswers = [];

const questionTitleEl = document.querySelector("#question p");
const choicesEl = document.querySelector(".choices");
const btnNext = document.querySelector("#btn-next");
const btnFinish = document.querySelector("#btn-finish");

// Hiển thị thông tin câu hỏi hiện tại
const renderQuestion = () => {
    // Lấy thông tin câu hỏi hiện tại
    const currentQuestion = questions[currentQuestionIndex];
    console.log(currentQuestion);

    // Hiển thị title của câu hỏi
    questionTitleEl.innerHTML = `Câu hỏi ${currentQuestionIndex + 1}: ${currentQuestion.title}`

    // Hiển thị các lựa chọn của câu hỏi
    let choicesHtml = "";
    currentQuestion.choices.forEach((choice, index) => {
        choicesHtml += `
            <div class="choice-item">
                <input type="radio" name="choice" id="${index + 1}" value="${choice}">
                <label for="${index + 1}">${choice}</label>
            </div>
        `;
    });
    choicesEl.innerHTML = choicesHtml;
};

btnNext.addEventListener("click", () => {
    // Kiểm tra xem người dùng đã chọn đáp án chưa
    // Nếu chọn rồi -> next
    // Nếu chưa chọn -> thông báo cho người dùng chọn đáp án
    const checkedChoice = document.querySelector("input[type=radio]:checked");
    if (!checkedChoice) {
        alert("Bạn chưa chọn đáp án");
        return;
    }

    // Lưu đáp án của người dùng vào mảng yourAnswers
    yourAnswers.push(checkedChoice.value);
    console.log(yourAnswers);

    currentQuestionIndex++; // Chuyển sang câu hỏi tiếp theo
    renderQuestion(); // Hiển thị câu hỏi tiếp theo

    // Nếu là câu hỏi cuối cùng thì ẩn nút Next và hiển thị nút Finish
    if (currentQuestionIndex === questions.length - 1) {
        btnNext.classList.add("hide");
        btnFinish.classList.remove("hide");
    }
});

btnFinish.addEventListener("click", () => {
    const checkedChoice = document.querySelector("input[type=radio]:checked");
    if (!checkedChoice) {
        alert("Bạn chưa chọn đáp án");
        return;
    }

    yourAnswers.push(checkedChoice.value);
    console.log(yourAnswers);

    // Kiểm tra đáp án của người dùng
    questions.forEach((question, index) => {
        if (question.answer === yourAnswers[index]) {
            score++;
        }
    });

    // Thông báo kết quả
    alert(`Bạn trả lời đúng ${score} / ${questions.length} câu hỏi`);
});

renderQuestion();