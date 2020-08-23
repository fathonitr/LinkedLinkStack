package postfix;
import java.util.*;
import stack.LinkedListStack;
//import stack.Stack;
import stack.Underflow;

public class Postfix {

	public String infixToPostfix(String infix) {
		// TODO Auto-generated method stub
		return null;
	}

	public double evaluate(String postfix) throws Underflow {
		LinkedListStack<Integer> s= new LinkedListStack<Integer>();
		Scanner tokens = new Scanner(postfix);

		while (tokens.hasNext()) {
			if (tokens.hasNextInt()) {
				s.push( tokens.nextInt());
			} else {
				int num2 =s.pop();
				int num1 =s.pop();
				String op = tokens.next();

				if (op.equals("+")) {
					s.push(num1 + num2);
				} else if (op.equals("-")) {
					s.push(num1 - num2);
				} else if (op.equals("*")) {
					s.push(num1 * num2);
				} else {
					s.push(num1 / num2);
				}

				//  "+", "-", "*", "/"
			}
		}
		return s.pop();
	}
	public static void main(String[] args) throws Underflow {
		Postfix test=new Postfix();
		System.out.println(test.evaluate("1 2 +"));               // 3
		System.out.println(test.evaluate("1 2 3 * + 4 +"));       // 11
		System.out.println(test.evaluate("5 2 4 * + 7 -"));       // 6
		System.out.println(test.evaluate("2 3 + 4 5 * +"));       // 25
		System.out.println(test.evaluate("8 5 * 7 4 2 + * +"));   // 82
		System.out.println(test.evaluate("6 8 2 / 1 - *"));       // 18
	}

}
