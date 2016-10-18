import java.io.*;
import java.util.*;

class Solution {
  public static class Iterator{
    private int row;
    private int col;
    private List<List<Integer>> arrays;
    
    public Iterator(List<List<Integer>> arrays) {
      this.arrays = arrays;
      row = 0;
      col = -1;
    }
     
    public boolean hasNext() {
      int r = row;
      int c = col;
      while(r < arrays.size() && c == arrays.get(r).size() - 1) {
        r++;
        c = -1;
      }
      return r != arrays.size();
    }
    
    public int next() {
      while (col == arrays.get(row).size() - 1) {
        row++;
        col = -1;
      }
      col++;
      return arrays.get(row).get(col);
    }
    
    public void remove() {
      arrays.get(row).remove(col);
      col--;
    }
  }
  
  public static void main(String[] args) {
    List<List<Integer>> arrays = new ArrayList<List<Integer>>();
    List<Integer> firstRow = new ArrayList<Integer>();
    firstRow.add(1);
    firstRow.add(2);
    firstRow.add(3);
    arrays.add(firstRow);
    
    List<Integer> secondRow = new ArrayList<Integer>();
    arrays.add(secondRow);
    
    List<Integer> thirdRow = new ArrayList<Integer>();
    thirdRow.add(4);
    thirdRow.add(5);
    arrays.add(thirdRow);
    
    Solution.Iterator iterator = new Solution.Iterator(arrays);
    
    while (iterator.hasNext()) {
      int cur = iterator.next();
      System.out.println(cur);
      
      if (cur == 3) {
        iterator.remove();
      }
    }
    
    for (List<Integer> row : arrays) {
      System.out.println(row.toString());
    }
  }
}
