document.addEventListener("DOMContentLoaded", () => {
    const step1Inputs = document.querySelectorAll("#step-1 input");
    const step2 = document.getElementById("step-2");
    const step3 = document.getElementById("step-3");
    const step4 = document.getElementById("step-4");
  
    // Step 1 -> Step 2
    step1Inputs.forEach(input => {
      input.addEventListener("input", () => {
        const allFilled = [...step1Inputs].every(input => input.value.trim() !== "");
        if (allFilled) {
          step2.classList.remove("hidden");
        }
      });
    });
  
    // Step 2 -> Step 3
    const phoneInput = document.getElementById("phone-number");
    phoneInput.addEventListener("input", () => {
      if (phoneInput.value.trim() !== "") {
        step3.classList.remove("hidden");
      }
    });
  
    // Step 3 -> Step 4
    const captchaButton = document.getElementById("check-captcha");
    captchaButton.addEventListener("click", () => {
      step4.classList.remove("hidden");
    });
  });
  