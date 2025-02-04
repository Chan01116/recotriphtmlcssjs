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
  

  document.addEventListener("DOMContentLoaded", () => {
    const menuButton = document.getElementById("menu-toggle");
    const sideMenu = document.getElementById("side-menu");

    // 메뉴 버튼 클릭 시 슬라이드 메뉴 활성화
    menuButton.addEventListener("click", () => {
        sideMenu.classList.toggle("active");
    });

    // 메뉴 외부 클릭 시 자동 닫기
    document.addEventListener("click", (event) => {
        if (!menuButton.contains(event.target) && !sideMenu.contains(event.target)) {
            sideMenu.classList.remove("active");
        }
    });
});


document.addEventListener("DOMContentLoaded", () => {
    // Register GSAP Plugins
    gsap.registerPlugin(ScrollTrigger);
  
    // Parallax Layers Animation
    document.querySelectorAll('[data-parallax-layers]').forEach((triggerElement) => {
      let tl = gsap.timeline({
        scrollTrigger: {
          trigger: triggerElement,
          start: "top top", // Trigger at the top
          end: "bottom top", // End when the bottom reaches the top
          scrub: true // Smooth scrubbing effect
        }
      });
  
      // Define Layer Animations
      const layers = [
        { layer: "1", yPercent: 70 }, // Slowest layer
        { layer: "2", yPercent: 50 },
        { layer: "3", yPercent: 30 }, // Title layer
        { layer: "4", yPercent: 10 }  // Fastest layer
      ];
  
      // Apply animations to each layer
      layers.forEach((layerObj) => {
        tl.to(
          triggerElement.querySelectorAll(`[data-parallax-layer="${layerObj.layer}"]`),
          {
            yPercent: layerObj.yPercent,
            ease: "none" // Smooth easing
          },
          0 // All animations start together
        );
      });
    });
  
    // Smooth Scrolling using Lenis
    const lenis = new Lenis({
      duration: .8, // Adjust scrolling speed
      easing: (t) => t * (2 - t), // Default easing
    });
  
    lenis.on('scroll', ScrollTrigger.update);
    gsap.ticker.add((time) => {
      lenis.raf(time * 1000);
    });
  });

  document.addEventListener("DOMContentLoaded", () => {
    gsap.registerPlugin(ScrollTrigger);

    document.querySelectorAll('[data-parallax-layers]').forEach((triggerElement) => {
        let tl = gsap.timeline({
            scrollTrigger: {
                trigger: triggerElement,
                start: "top top",
                end: "bottom top",
                scrub: true
            }
        });


 
// .to(element, { x: value }) → 수평 이동
// .to(element, { yPercent: value }) → 스크롤 이동 효과
// .to(element, { scale: value }) → 크기 조정 가능
// .to(element, { rotate: value }) → 회전 가능

        // 개별 레이어 위치 조정 (애니메이션)
//         tl.to(triggerElement.querySelectorAll('[data-parallax-layer="1"]'), {
//             yPercent: 70,
//             x: -50,  // 왼쪽 이동
//             scale: 1.1,
//             ease: "none"
//         });

//         tl.to(triggerElement.querySelectorAll('[data-parallax-layer="2"]'), {
//             yPercent: 50,
//             x: 50,  // 오른쪽 이동
//             scale: 0.9,
//             ease: "none"
//         });

//         tl.to(triggerElement.querySelectorAll('[data-parallax-layer="3"]'), {
//             yPercent: 30,
//             x: 0,  // X축 이동 없음
//             rotate: -5,
//             ease: "none"
//         });
     });
});




  
  
  
  
  
  
  // 헤더와 풋터를 가져와서 삽입하는 함수
function loadComponent(id, file, callback) {
    fetch(file)
        .then(response => response.text())
        .then(data => {
            document.getElementById(id).innerHTML = data;
            if (callback) callback(); // 콜백 함수 실행 (로드 후 이벤트 리스너 추가)
        })
        .catch(error => console.error(`Error loading ${file}:`, error));
}

// 헤더 및 풋터 로드 후 이벤트 리스너 추가
document.addEventListener("DOMContentLoaded", () => {
    loadComponent("header-placeholder", "header.html", () => {
        // 헤더 로드 완료 후 메뉴 버튼 이벤트 리스너 추가
        const menuButton = document.getElementById("menu-toggle");
        const sideMenu = document.getElementById("side-menu");

        if (menuButton && sideMenu) {
            menuButton.addEventListener("click", () => {
                sideMenu.classList.toggle("active");
            });

            // 외부 클릭 시 메뉴 닫기
            document.addEventListener("click", (event) => {
                if (!menuButton.contains(event.target) && !sideMenu.contains(event.target)) {
                    sideMenu.classList.remove("active");
                }
            });
        }
    });

    loadComponent("footer-placeholder", "footer.html");
});




  // 헤더와 풋터를 가져와서 삽입하는 함수
  function loadComponent(id, file, callback) {
    fetch(file)
        .then(response => response.text())
        .then(data => {
            document.getElementById(id).innerHTML = data;
            if (callback) callback(); // 콜백 함수 실행 (로드 후 이벤트 리스너 추가)
        })
        .catch(error => console.error(`Error loading ${file}:`, error));
}

// 헤더 및 풋터 로드 후 이벤트 리스너 추가
document.addEventListener("DOMContentLoaded", () => {
    loadComponent("header-placeholder1", "header1.html", () => {
        // 헤더 로드 완료 후 메뉴 버튼 이벤트 리스너 추가
        const menuButton = document.getElementById("menu-toggle");
        const sideMenu = document.getElementById("side-menu");

        if (menuButton && sideMenu) {
            menuButton.addEventListener("click", () => {
                sideMenu.classList.toggle("active");
            });

            // 외부 클릭 시 메뉴 닫기
            document.addEventListener("click", (event) => {
                if (!menuButton.contains(event.target) && !sideMenu.contains(event.target)) {
                    sideMenu.classList.remove("active");
                }
            });
        }
    });

    loadComponent("footer-placeholder", "footer.html");
});






document.addEventListener('DOMContentLoaded', () => {
    const dropdownBtn = document.querySelector('.dropdown-btn');
    const dropdownMenu = document.querySelector('.dropdown-menu');
  
    // 버튼 클릭 시 드롭다운 메뉴 토글
    dropdownBtn.addEventListener('click', () => {
      dropdownMenu.classList.toggle('visible');
    });
  
    // 메뉴 외부 클릭 시 드롭다운 메뉴 숨기기
    document.addEventListener('click', (event) => {
      if (!dropdownBtn.contains(event.target) && !dropdownMenu.contains(event.target)) {
        dropdownMenu.classList.remove('visible');
      }
    });
  });