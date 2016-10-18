import java.io.*;
import java.util.*;

class Solution {
  public static class Node {
    private int value;
    private boolean isLeaf;
    private List<Node> children;
    
    public Node(int value) {
      this.value = value;
      this.isLeaf = true;
    }
    
    public Node() {
      this.children = new ArrayList<Node>();
      this.isLeaf = false;
    }
    
    public void add(Node node) {
      this.children.add(node);
    }
    
    public Node parse(String str) {
      if (str == null || str.length() <= 0) {
        return null;
      }
      
      // special case, single integer
      if (str.charAt(0) != '[') {
        int val = Integer.parseInt(str);
        return new Node(val);
      }
      
      // left pointer to a string token
      int left = 0;
      Stack<Node> stack = new Stack<Node>();
      Node root = null;
      
      for (int i = 0; i < str.length(); i++) {
        Node node;
        char c = str.charAt(i);
        switch (c) {
          case '[':
            node = new Node();
            // if the stack is empty, then the first node is the root node
            if (stack.isEmpty()) {
              root = node;
            } else {
              stack.peek().add(node);
            }
            stack.push(node);
            // update the left pointer
            left = i + 1;
            break;
          case ']':
          case ',':
            if (left != i) {
              int val = Integer.parseInt(str.substring(left, i));
              node = new Node(val);
              stack.peek().add(node);
            }
            // reset the left pointer
            left = i + 1;
            
            // the current node is no longer needed in the stack
            if (c == ']') {
              stack.pop();
            }
            break;
        }
      }
      return root;
    }
    
    public String toString() {
      return this.isLeaf ? Integer.toString(this.value)  : this.children.toString();
    } 
  }
  public static void main(String[] args) {
    Solution.Node node = new Solution.Node();
    String input = "[123,456,[788,799,833],[[]],10,[]]";
    //String input = "234";
    Node result = node.parse(input);
    System.out.println(result.toString());
  }
}
