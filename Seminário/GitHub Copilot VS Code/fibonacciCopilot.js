// make a fibonacci functions that makes a cache of the values already calculated
const cache = {};
function fibonacci(n) {
  if (n <= 1) {
    return n;
  } else {
    if (cache[n]) {
      return cache[n];
    } else {
      cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
      return cache[n];
    }
  }
}

function fibonacci(n) {
  if (n <= 1) {
    return n;
  } else {
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

// faça uma nova função fibonacci de forma iterativa
function fibonacciIterative(n) {
  let a = 0;
  let b = 1;
  let c = 0;
  if (n <= 1) {
    return n;
  } else {
    for (let i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}


// faça uma função que teste o tempo de execução das duas funções
function timeTest(n) {
  console.time("fibonacci");
  fibonacci(n);
  console.timeEnd("fibonacci");

  console.time("fibonacciIterative");
  fibonacciIterative(n);
  console.timeEnd("fibonacciIterative");
}

// teste a função timeTest
timeTest(30);

module.exports = {
  fibonacci,
  fibonacciIterative,
  timeTest
};
