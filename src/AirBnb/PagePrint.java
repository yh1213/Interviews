import java.io.*;
import java.util.*;

class Solution {
  private static final int PAGE_SIZE = 12;
  
  private static void printPageNumber(int pageNum) {
    System.out.println(String.format("Page%d", pageNum));
  }
                       
  public static void printByPage(List<String> inputList) {
    if (inputList == null || inputList.size() <= 0) {
      return;
    }
    
    Set<String> hostIdSet = new HashSet<String>();
    Iterator<String> iterator = inputList.iterator();
    int pageNum = 1;
    
    printPageNumber(pageNum);
    
    while (iterator.hasNext()) {
      String curRecord = iterator.next();
      String hostId = curRecord.split(",")[0];
      if (!hostIdSet.contains(hostId)) {
        hostIdSet.add(hostId);
        iterator.remove();
        System.out.println(curRecord);
      }
      
      if (hostIdSet.size() == PAGE_SIZE) {
        hostIdSet.clear();
        iterator = inputList.iterator();
        pageNum++;
        if (iterator.hasNext()){
          printPageNumber(pageNum);
        }
      }
    }
  }
    
  public static void main(String[] args) {
    String[] inputs = new String[] {
      "1,28,300.1,SanFrancisco",
      "4,5,209.1,SanFrancisco",
      "20,7,208.1,SanFrancisco",
      "23,8,207.1,SanFrancisco",
      "16,10,206.1,Oakland",
      "1,16,205.1,SanFrancisco",
      "6,29,204.1,SanFrancisco",
      "7,20,203.1,SanFrancisco",
      "8,21,202.1,SanFrancisco",
      "2,18,201.1,SanFrancisco",
      "2,30,200.1,SanFrancisco",
      "15,27,109.1,Oakland",
      "10,13,108.1,Oakland",
      "11,26,107.1,Oakland",
      "12,9,106.1,Oakland",
      "13,1,105.1,Oakland",
      "22,17,104.1,Oakland",
      "1,2,103.1,Oakland",
      "28,24,102.1,Oakland",
      "18,14,11.1,SanJose",
      "6,25,10.1,Oakland",
      "19,15,9.1,SanJose",
      "3,19,8.1,SanJose",
      "3,11,7.1,Oakland",
      "27,12,6.1,Oakland",
      "1,3,5.1,Oakland",
      "25,4,4.1,SanJose",
      "5,6,3.1,SanJose",
      "29,22,2.1,SanJose",
      "30,23,1.1,SanJose"
    };
    List<String> inputList = new ArrayList<>(Arrays.asList(inputs));
    printByPage(inputList);
  }
}
