/*
package one_dimensional_data_structures_book;

// Вметни класа SLLNode
// Вметни класа Stack
// Вметни класа ArrayStack
// Вметни класа LinkedStack

public class Parentheses {
    public static boolean daliZagraditeSePravilni(String phrase) {
        // Test whether phrase is well-bracketed.
        ArrayStack<Character> bracketStack = new ArrayStack<Character>(100);
        // LinkedStack<Character> bracketStack = new LinkedStack<>();  // за решение со LinkedStack откоментираjте го овоj ред

        for (int i = 0; i < phrase.length(); i++) {
            char cur = phrase.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{')
                bracketStack.push(cur);
            else if (cur == ')' || cur == ']' || cur == '}') {
                if (bracketStack.isEmpty())
                    return false;
                char left = bracketStack.pop();
                if (!daliSoodvetni(left, cur))
                    return false;
            }
        }
        return (bracketStack.isEmpty());
    }

    public static boolean daliSoodvetni(char left, char right) {
        // Провери дали left и right се совпаѓачки загради
        // (со претпоставка дека left е отворачка заграда и right е затворачка заграда).
        switch (left) {
            case '(':
                return (right == ')');
            case '[':
                return (right == ']');
            case '{':
                return (right == '}');
        }
        return false;
    }

    public static void main(String[] args) {
        String phrase = "s x (s - a) x (s - b) x (s - c)";
        // String phrase = "s x (s - a) x s - b) x (s - c)";
        System.out.println(phrase + " ima " + (daliZagraditeSePravilni(phrase) ? "korektni" : "nekorektni") + " zagradi.");
    }
}
*/
