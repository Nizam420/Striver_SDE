// import java.util.*;

// class Solution {
// public static int findCelebrity(int n) {
// // Write your code here.
// Stack<Integer> stk = new Stack<>();

// int ii = 0;

// while (ii < n)
// stk.push(ii++);

// while (stk.size() > 1) {
// int A = stk.pop();
// int B = stk.pop();

// if (Runner.knows(A, B))
// stk.push(B);

// else if (Runner.knows(B, A))
// stk.push(A);
// }
// if (stk.isEmpty())
// return -1;
// int p = stk.pop();

// boolean ans = true;

// for (int i = 0; i < n; i++) {
// if (i == p)
// continue;

// if (!Runner.knows(i, p)) {
// // System.out.println("here");
// ans = false;
// break;
// }

// }

// for (int i = 0; i < n; i++) {
// if (Runner.knows(p, i)) {
// ans = false;
// break;
// }

// }

// if (ans)
// return p;
// return -1;
// }

// }