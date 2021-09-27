// 일급 객체(first-class object)  or  일급 함수
// https://en.wikipedia.org/wiki/First-class_citizen
//

//프로그래밍 언어를 디자인 할때 주어진 프로그래밍언어에서
// 일급 시민(또는 일급 타입, 일급 객체, 일급 엔티티, 일급 값)은
// 다른 엔티티들이 일반적으로 이용 가능한 모든 연산을 지원하는 엔티티를 뜻합니다.
// 여기서의 연산은 전형적으로 인자로 전달되고, 함수의 반환값으로 사용되고, 수정되고,
// 변수에 할당하는 것을 포함합니다."
// 자바스크립트의 함수는 일급 함수입니다. 자바스크립트에서의 함수는 사실 객체이므로 일급 객체라고 할수 있다.

/**
 *  클로저를 이야기하기 전에 일급 함수가 중요한 이유는 자바스트립트에서 클로저를 만들기 위해서는 함수를 변수에 대입하고
 *  ,반환값으로 반환되는 작업이 필요하기 대문
 *
 *
 *
 */

/**
 * 변수의 범위(scope) 및 수명(lifetime)
 *
 * 자바스크립트 변수들은 local 또는 global의 변수 변위를 갖는다
 *
 * 함수내에서 정의한 변수는 지역변수(loca variable)입니다.
 * 지역변수는 그것이 정의된 함수 내에서만 사용되어질수 있다.
 * 다른 함수에서는 당연하겠지만 사용할수 없다.
 *
 */

function printHello() {
  const hello = "hello";
  console.log(hello)
}

/**
 * 함수 밖에서 정의된 변수는 global variable(전역변수)입니다.
 * 전역변수는 윈도우(window)객체에 속합니다.
 * 전역변수는 페이지 내에서 모든 스크립트에서 사용되어질수 있습니다.
 *
 */
let hello2 = "hello2"

function printhello2() {
  console.log(hello2);
}

//전역변수와 지역변수가 있을때 둘은 서로 다른 변수입니다. 하나가 변경되더라더 다른것에 영향이 없고
//함수내의 전역변수와 이름이 같은 지역변수를 정의한다면 함수내에 전역변수는 사용할수없다.
let food = "김치볶음밥";

function printFood() {
  let food = "짜장면";
  console.log(food);
}

printFood();
console.log(food);

//변수생성시 var or let등의 키워드를 사용하지 않으면 항수내에 있더라도 이 변수는 항상 전역변수이다.
//변수의수명(lifetime)은 클로벌 변수일 경우는 애플리케이션이 살아있는 동안입니다. 지녁변수는 수명은
//함수안에서 생성되고 함수가 종료될때 지워집니다.

function printFruit() {
  fruit = "apple";

}

printFruit();
console.log(fruit);

/**
 * 중첩함수(Nested function)
 *
 * 중첩함수는 함수내에서 또 함수를 정의하고 사용하는 것을 말합니다.
 * 함수내에서는 함수 외부의 변수에 접근할 수 있습니다. 중첩함수에서도 외부의 변수를 접근할수 있습니다.
 */

let phoneName = "iphone";

function outerFun() {
  let outerPhoneName = "outerphone";

  function innerFun() {
    let innerPhoneName = "innerphone";
    console.log(phoneName);
    console.log(outerPhoneName);
    console.log(innerPhoneName);

  }

  innerFun();

}

outerFun();

/**
 * 함수의 반환
 *
 * 자바스크립트는 일급 함수를 지원하므로  함수를 변수로 저장하고
 * 파라미터로 함수를 넘기고 함수를 반환하는 것이 가능합니다
 */
let pay = 'vcash';

function makePay() {
  let outerPay = "card";

  function printPay() {
    let innerPay = "transfer";
    console.log(pay);
    console.log(outerPay);
    console.log(innerPay);
  }

  return printPay;
}

let print = makePay();
print();

/**
 * let print = makePay(); 로 반환을 받는것이 closer(클로저)입니다
 * makePay()함수내에서 정의된 지역변수인 outerPay가 자신의 수명이 makePay의 수명이
 * 끝났지만 print를 호출할때 살아있는것 transfer가 출력된다
 *
 * 클로저는 자신을 포함하고 있는 외부 함수의 인자, 지역변수 등을 외부 함수가 종료된 후에도 사용할 수 있습니다.
 * 이러한 변수를 자유 변수(free variable) 이라고 부릅니다.
 *  클로저가 생성될 때 범위내의 지역 변수들을 자유 변수로 만드는 것을 캡쳐(capture) 라고 합니다.
 *  이 자유변수는 외부에서는 직접 접근할 수 없고, 항상 클로저를 통해서만 사용할 수 있습니다.
 *  객체 지향언어의 private 멤버 변수와 같은 효과를 냅니다.
 *   이처럼 자유 변수를 가지는 코드를 클로저라고 합니다.
 */

function makeGreeting(name) {
  let greeting = "Hi.. ";
  return () => {
    console.log(greeting + name);
  }
}

const g1 = makeGreeting("bbn");
const g2 = makeGreeting("ccd");

g1();
g2();

const checkPrint = (function () {
  let checkName = "bbn";
  return function () {
    console.log(checkName)
  }

})();

checkPrint();

let checkPrint3 = (function (name) {
  let helloMsg = "hi! ";
  return function () {
    console.log(helloMsg + name)
  }

})("bbn");

checkPrint3("ccc");

// 카운터 클로저를 생성합니다.
var counter = (function () { // private 변수 입니다.(외부 접근 불가)
  var privateCounter = 0; // private 함수 입니다.(외부 접근 불가)
  function changeCounter(val) {
    privateCounter += val;
  } // public 함수를 가지는 객체를 반환합니다.
  return { // 증가 기능을 가지는 public 함수 입니다.
    inc: function () {
      changeCounter(1);
    },
// 감소 기능을 가지는 public 함수 입니다.
    dec: function () {
      changeCounter(-1);
    }, // public 함수 입니다.(현재값 조회)
    val: function () {
      return privateCounter;
    }
  };
})();
counter.inc();
counter.inc();
console.log("after increment : " + counter.val());
counter.dec();
console.log("after decrement : " + counter.val());
