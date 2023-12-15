// FILEPATH: /home/ranzani/Development/UFSCar/2023-2/ES2/Seminário/GitHub Copilot VS Code/fibonacciCopilot.test.js
const { fibonacci, fibonacciIterative, timeTest } = require('./fibonacciCopilot');

describe('Fibonacci Tests', () => {
  test('Recursive Fibonacci function should return correct value', () => {
    expect(fibonacci(0)).toBe(0);
    expect(fibonacci(1)).toBe(1);
    expect(fibonacci(2)).toBe(1);
    expect(fibonacci(3)).toBe(2);
    expect(fibonacci(10)).toBe(55);
  });

  test('Iterative Fibonacci function should return correct value', () => {
    expect(fibonacciIterative(0)).toBe(0);
    expect(fibonacciIterative(1)).toBe(1);
    expect(fibonacciIterative(2)).toBe(1);
    expect(fibonacciIterative(3)).toBe(2);
    expect(fibonacciIterative(10)).toBe(55);
  });

  test('Iterative and Recursive Fibonacci functions should return the same value', () => {
    for(let i = 0; i < 10; i++) {
      expect(fibonacci(i)).toBe(fibonacciIterative(i));
    }
  });
});

describe('Time Test', () => {
  // This test is more of a sanity check since we can't assert on console.time
  test('timeTest function should not throw an error', () => {
    expect(() => timeTest(10)).not.toThrow();
  });
});
