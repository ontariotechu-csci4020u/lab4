import static java.lang.System.out;

public class Check {
    public FSM a1;
    public Check() {
        a1 = new FSM();
        a1.add(0, 1, "a");
        a1.add(0, 1, "b");
        a1.add(1, 1, "b");
        a1.add(1, 2, "c");
        a1.add(1, 0, "a");
        a1.add(2, 0, "");
        a1.initState(0);
        a1.finalState(2);
        a1.finalState(0);
    }
    public void Test0() {
        a1.print();
    }
    public void Test1() {
        for(String input: new String[]{"a", "b", "c"}) {
            out.printf("Reachable states of \"%s\": %s\n",
                input, a1.reachable(input));
        }
    }

    public void Test2() {
        for(String input: new String[]{
            "a", "ab", "abc"
        }) {
            out.printf("Reachable states of \"%s\": %s\n",
                input, a1.reachable(input));
        }
    }

    public void Test3() {
        for(String input: new String[]{
            "a", "ab", "abc"
        }) {
            out.printf("Accept \"%s\"? %s\n",
                input, a1.accept(input));
        }

    }

    public void Test4() {
        String[] inputs = new String[] {
            "abbaaaa",
            "abccc",
            "aaaaaa",
            "abababa"
        };
        for(String input: inputs) {
            out.printf("Longest \"%s\": \"%s\"\n",
                    input, a1.matchLongest(input));
        }
    }

    public void Test5() {
        FSM id = FSM.ID();
        String[] inputs = new String[] {
            "hello",
            "1hello",
            "hello1",
            "hello world",
            "hello_world"
        };
       
        for(String input: inputs) {
            out.printf("Is \"%s\" valid? %s\n",
                   input, id.accept(input));
        }
    }

    public void Test6() {
        FSM whitespace = FSM.Whitespace();

        String[] inputs = new String[] {
            "  hello world",
            "\t\t  \thello world",
            "\n\n\t\t  \nhello world"
        };

        for(String input: inputs) {
            String ws = whitespace.matchLongest(input);
            String output = input.substring(ws.length());
            out.printf("Whitespace removed: \"%s\"\n",
                    output);
        }
    }

    public static void main(String[] args) {
        Check check = new Check();
        check.Test0();
        check.Test1();
        check.Test2();
        check.Test3();
        check.Test4();
        check.Test5();
        check.Test6();
    }
}
