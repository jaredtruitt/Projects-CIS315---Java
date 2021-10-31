//Jared Truitt
//CIS-315
//June 21, 2021
//Stack Of Integers

public class StackOfIntegersTest {
    public static void main(String[] args){
        StackOfIntegers stack = new StackOfIntegers();

        for(int i=0; i<10; i++){
            stack.push(i);
        }

        System.out.println("Pop all elements in the stack, you will get:");
        for(int i=0; i<10; i++){
            System.out.print(stack.pop() + " ");
        }
    }
}
