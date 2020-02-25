package sample;

import java.util.Stack;

public class Maths{
    public int result(String expression) {
        Stack <Integer> operands = new Stack<Integer>();
        Stack <Character> operator = new Stack<Character>();
        for(int i=0; i < expression.length(); i++){
            Character temp = expression.charAt(i);
            if(temp == '+' || temp == '-' || temp == '*' || temp == '/'){
                while(!operator.empty() && precedence(operator.peek()) >= precedence(temp)){
                    calculate(operands, operator.peek());
                    operator.pop();
                }
                operator.push(temp);
            }
            else{
                int number = 0;
                for(; i < expression.length() && (expression.charAt(i) >= '0' && expression.charAt(i) <= '9'); number = number*10 + (expression.charAt(i++) - '0'));
                i--;
                operands.push(number);
            }
        }
        while(!operator.empty()){
            calculate(operands, operator.peek());
            operator.pop();
        }
        return operands.peek();
    }
    private void calculate(Stack<Integer> tokens, Character operator) {
        Integer a = tokens.peek(); tokens.pop();
        Integer b = tokens.peek(); tokens.pop();
        switch (operator){
            case '+': tokens.push(b+a); break;
            case '-': tokens.push(b-a); break;
            case '*': tokens.push(b*a); break;
            case '/': tokens.push(b/a); break;
        }
    }
    private int precedence(Character operator) {
        if(operator == '/' || operator == '*')
            return 1;
        if(operator == '+' || operator == '-')
            return 0;
        return -1;
    }
}
