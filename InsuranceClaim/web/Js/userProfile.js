var info = document.querySelector("#info");
      var logs = document.querySelector("#logs");
      var cover = document.querySelector("#cover");
      var infodiv = document.querySelector("#infodiv");
      var logdiv = document.querySelector("#logdiv");
      var det = document.querySelector(".det");
      var entries = document.querySelector(".entries");
      var notify = document.querySelector("#notify");
      var notifdiv = document.querySelector("#notifdiv");

      logs.addEventListener("click", () => {
        cover.style.left = "51%";
        // det.style.display = "none";
        // entries.style.display = "none";
        infodiv.style.height = "0%";
        logdiv.style.height = "100%";
      });
      info.addEventListener("click", () => {
        cover.style.left = "7%";
        infodiv.style.height = "100%";
        logdiv.style.height = "0%";
      });

      // let flag = false;
      // const information = () => {};

      // const recentLogs = () => {};
      function toggle() {
        var main = document.querySelector("#main");
        main.classList.toggle("active");
        var notifdiv = document.querySelector("#notifdiv");
        notifdiv.classList.toggle("active");
      }

      var cancel = document.querySelector("#cancel");
      cancel.addEventListener("click", () => {
        location.reload();
      });

      inwords();

      function inwords() {
        // const num = document.getElementById("num");
        const inwords = document.getElementById("inwords");
        const num = "4393";

        const ones = {
          0: "Zero",
          1: "One",
          2: "Two",
          3: "Three",
          4: "Four",
          5: "Five",
          6: "Six",
          7: "Seven",
          8: "Eight",
          9: "Nine",
          10: "Ten",
          11: "Eleven",
          12: "Twelve",
          13: "Thirteen",
          14: "Fourteen",
          15: "Fifteen",
          16: "Sixteen",
          17: "Seventeen",
          18: "Eighteen",
          19: "Nineteen",
        };

        const prefixes = {
          2: "Twenty",
          3: "Thirty",
          4: "Fourty",
          5: "Fifty",
          6: "Sixty",
          7: "Seventy",
          8: "Eighty",
          9: "Ninety",
        };

        // event.preventDefault();

        if (+num in ones) {
          inwords.innerHTML = ones[+num] + " Rs. /-";
        }

        const numArray = num.split("");
        if (numArray.length === 2 && +num > 19) {
          inwords.innerHTML = prefixes[numArray[0]] + " " + ones[numArray[1]] + " Rs. /-";
        }

        if (numArray.length === 3) {
          if (+numArray[1] === 0) {
            inwords.innerHTML =
              ones[numArray[0]] + " hundred " + " " + ones[numArray[2]] + " Rs. /-";
          } else if (+numArray[1] < 2) {
            inwords.innerHTML =
              ones[numArray[0]] +
              " hundred " +
              " " +
              ones[+[numArray[1], numArray[2]].join("")] + " Rs. /-";
          } else {
            inwords.innerHTML =
              ones[numArray[0]] +
              " hundred " +
              prefixes[numArray[1]] +
              " " +
              ones[numArray[2]] + " Rs. /-";
          }
        }

        if (numArray.length === 4) {
          if (+numArray[1] === 0) {
            inwords.innerHTML =
              ones[numArray[0]] +
              " thousand " +
              " " +
              ones[+[numArray[2], numArray[3]].join("")] + " Rs. /-";
          } else if (+numArray[1] < 2) {
            inwords.innerHTML =
              ones[numArray[0]] +
              " thousand " +
              ones[numArray[1]] +
              " hundred " +
              " " +
              ones[+[numArray[2], numArray[3]].join("")] + " Rs. /-";
          } else {
            inwords.innerHTML =
              ones[numArray[0]] +
              " thousand " +
              ones[numArray[1]] +
              " hundred " +
              prefixes[numArray[2]] +
              " " +
              ones[numArray[3]] + " Rs. /-";
          }
        }
      } 