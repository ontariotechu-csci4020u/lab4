# Lab 4: FSM based token recognizer

In this lab, you are to implement a simple finite state machine (FSM) library that can be used to perform tokenization.

## Representing FSM

- States are _integers_ represented as Java `int`.
- Labeled transitions are single-letter _strings_.  They are represented as `java.lang.String`
with length 1.
- We also support epsilon transitions.  These transitions will be labeled by the empty string `""`.
- There can only be _one_ initial state.
- There can be multiple final states.

## Implementation

The implementation must have _at least_ the following methods:

```java
public class FSM {
  // Adds a transition from the source state to the target state.
  // The transition is labeled by the string label.
  // The label is considered as a single character symbol. If label
  // is the empty string, then the transition is considered
  // as the epsilon transition.
  public void add(int source, int target, String label);
  
  // Marks the initial state.
  public void initState(int state);
  
  // Marks a final state.  This can be used multiple
  // times if there are multiple final states.
  public void finalState(int state);
  
  // Returns the states that can be reached
  // by the input _string_.  The input is
  // considered as a sequence of characters.
  public Set<Integer> reachable(String input);
  
  // Returns if the input string (sequence of chars)
  // is accepted by the FSM.
  public boolean accept(String input);
  
  // Returns the longest prefix of the input string
  // that is accepted by the FSM.
  public String matchLongest(String input);
  
  // Prints the transitions of the FSM
  // in the order added.
  public void print();
  
  // Construct a FSM that recognizes valid Java identifiers
  public static FSM ID();
  
  // Constructs a FSM that recognizes whitespaces.
  public static FSM Whitespace();
}
```

## Hints

- Use Java utility data structures to simplify your code.  For example, to compute
set union and intersection, you can use the `java.util.HashSet<...>.addAll(...)` and
`HashSet<>.retainAll(...)` methods.

- Write down the algorithm mathematically first (refer to lecture notes) before diving into
the implementation.  If you get the formal definition of the algorithms, translating them
to Java is actually quite straightforward.  However, thinking in Java is both unpleasant and
error prune, and you will end up with a lot of bugs that are difficult to locate.

# Evaluation

- You are given the `Check.java` code that checks the correctness of your implementation.
- A `Makefile` is provided to help you with the compilation and tests.
  - `make compile` will compile your implementation.
  - `make check` checks your code against the expected behaviour.
