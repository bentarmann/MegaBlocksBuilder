/////////////////////////////////////////// FILE  HEADER /////////////////////////////////////////////
//
// Title: Mega Blocks Builder 
// Files: Color.java, LinkedListMegaBlock.java, LinkedMegaBlock.java, MegaBlock.java,
//	  MegaBlockBuilderTester.java
// This File: MegaBlockBuilderTester.java
// 
// Name: Benjamin Tarmann
// Email: btarmann@wisc.edu
//
///////////////////////////////////////// 100 COLUMNS WIDE /////////////////////////////////////////

/**
 * This class tests the MegaBlock, LinkedMegaBlock, and LinkedListMegaBlock classes
 * 
 * @author Benjamin Tarmann
 */
public class MegaBlockBuilderTester {

  /**
   * Checks for the correctness of the MegaBlock.equals() method
   * 
   * @return true if the method operates as expected, false if not
   */
  public static boolean testMegaBlockEquals() {
    // tests the case when the two objects being compared have the same reference
    MegaBlock test = new MegaBlock(Color.RED, 't');
    MegaBlock test2 = test;
    if (test.equals(test2) == false) {
      return false;
    }

    // tests the case when the two objects being compared have different colors
    test2 = new MegaBlock(Color.BLUE, 't');
    if (test.equals(test2) == true) {
      return false;
    }

    // tests the case when the two objects being compared have the same color but different labels
    test2 = new MegaBlock(Color.RED, 'a');
    if (test.equals(test2) == false) {
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of the MegaBlock.toString() method
   * 
   * @return true if the method operates as expected, false if not
   */
  public static boolean testMegaBlockToString() {
    MegaBlock test = new MegaBlock(Color.RED, 't');
    // checks that the toString() method returns the correct string
    if (test.toString().equals("RED t") == false) {
      return false;
    }

    return true; // returns true if above test passes
  }

  /**
   * Checks for the correctness of the LinkedMegaBlock class
   * 
   * @return true if the class operates as expected, false if not
   */
  public static boolean testLinkedMegaBlock() {
    // checks the functionality of the getBlock() method
    MegaBlock testMegaBlock = new MegaBlock(Color.RED, 'a');
    LinkedMegaBlock testLinkedMegaBlock = new LinkedMegaBlock(testMegaBlock);
    if (testLinkedMegaBlock.getBlock() != testMegaBlock) {
      return false;
    }

    // checks the functionality of the setBlock() method
    MegaBlock testMegaBlock2 = new MegaBlock(Color.BLUE, 'b');
    testLinkedMegaBlock.setBlock(testMegaBlock2);
    if (testLinkedMegaBlock.getBlock() != testMegaBlock2) {
      return false;
    }

    return true; // returns true if all above tests pass
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.addRed() method
   * 
   * @return true if the method operates as expected, false if not
   */
  public static boolean testLinkedMegaBlockListAddRed() {
    LinkedListMegaBlock testList = new LinkedListMegaBlock();

    testList.addRed(new MegaBlock(Color.RED, 'A'));

    // checks that testList has the correct size, redCount, and returns the correct string
    if (testList.size() != 1 || testList.getRedCount() != 1
        || !testList.toString().equals("RED A -> END")) {
      return false;
    }

    // checks that testList has the correct size, redCount, and returns the correct string when
    // another red block is added
    testList.addRed(new MegaBlock(Color.RED, 'B'));
    if (testList.size() != 2 || testList.getRedCount() != 2
        || !testList.toString().equals("RED B -> RED A -> END")) {
      return false;
    }

    return true; // returns true if all above tests pass
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.removeBlue() method
   * 
   * @return true if the method operates as expected, false if not
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    LinkedListMegaBlock testList = new LinkedListMegaBlock();

    // add a blue block and then remove it
    testList.addBlue(new MegaBlock(Color.BLUE, 'A'));
    testList.removeBlue();
    // checks that the list has a size of 0, a blueCount of 0, and returns an empty string
    if (testList.size() != 0 || testList.getBlueCount() != 0 || !testList.toString().equals("")) {
      return false;
    }

    // add two blue blocks and then remove one
    testList.clear();
    testList.addBlue(new MegaBlock(Color.BLUE, 'A'));
    testList.addBlue(new MegaBlock(Color.BLUE, 'B'));
    testList.removeBlue();
    // checks that the list has a size of 1, a blue count of 1, and returns the correct string
    if (testList.size() != 1 || testList.getBlueCount() != 1
        || !testList.toString().equals("BLUE A -> END")) {
      return false;
    }

    // add a red and a blue block and then remove the blue block
    testList.clear();
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.addBlue(new MegaBlock(Color.BLUE, 'B'));
    testList.removeBlue();
    // checks that the list has a size of 1, a blueCount of 0, and returns the correct string
    if (testList.size() != 1 || testList.getBlueCount() != 0
        || !testList.toString().equals("RED A -> END")) {
      return false;
    }

    // add a red, yellow, and blue block and then remove the blue block
    testList.clear();
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.addYellow(1, new MegaBlock(Color.YELLOW, 'C'));
    testList.addBlue(new MegaBlock(Color.BLUE, 'C'));
    testList.removeBlue();
    // checks that the list has a size of 2, a a blueCount of 0, and returns the correct string
    if (testList.size() != 2 || testList.getBlueCount() != 0
        || !testList.toString().equals("RED A -> YELLOW C -> END")) {
      return false;
    }

    return true; // returns true if all above tests pass
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.removeRed() method
   * 
   * @return true if the method operates as expected, false if not
   */
  public static boolean testLinkedListMegaBlockRemoveRed() {
    LinkedListMegaBlock testList = new LinkedListMegaBlock();

    // add a red block and then remove it
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.removeRed();
    // checks that the list has a size of 0, a redCount of 0, and returns the correct string
    if (testList.size() != 0 || testList.getRedCount() != 0 || !testList.toString().equals("")) {
      return false;
    }

    // add two red blocks and then remove one
    testList.clear();
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.addRed(new MegaBlock(Color.RED, 'B'));
    testList.removeRed();
    // checks that the list has a size of 1, a redCount of 1, and returns the correct string
    if (testList.size() != 1 || testList.getRedCount() != 1
        || !testList.toString().equals("RED A -> END")) {
      return false;
    }

    // add a red block and a blue block and remove the red block
    testList.clear();
    testList.addBlue(new MegaBlock(Color.BLUE, 'B'));
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.removeRed();
    // checks that the list has a size of 0, a redCount of 0, and returns the correct string
    if (testList.size() != 1 || testList.getRedCount() != 0
        || !testList.toString().equals("BLUE B -> END")) {
      return false;
    }

    // add a red, yellow, and blue block and then remove the red block
    testList.clear();
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.addYellow(1, new MegaBlock(Color.YELLOW, 'B'));
    testList.addBlue(new MegaBlock(Color.BLUE, 'C'));
    testList.removeRed();
    // checks that the list has a size of 2, a redCount of 0, and returns the correct string
    if (testList.size() != 2 || testList.getRedCount() != 0
        || !testList.toString().equals("YELLOW B -> BLUE C -> END")) {
      return false;
    }

    return true;
  }

  /**
   * Checks the correctness of the LinkedListMegaBlock.removeYellow() method
   * 
   * @return true if the method operates as expected, false if not
   */
  public static boolean testLinkedListMegaBlockRemoveYellow() {
    LinkedListMegaBlock testList = new LinkedListMegaBlock();
    
    // add a yellow block and then remove it
    testList.addYellow(0, new MegaBlock(Color.YELLOW, 'A'));
    testList.removeYellow(0);
    // checks that the list has a size of 0, a yellowCount of 0, and returns the correct string
    if (testList.size() != 0 || testList.getYellowCount() != 0 || !testList.toString().equals("")) {
      System.out.println(testList.toString() + testList.size() + testList.getYellowCount());
      return false; 
    }
    
    // add two yellow blocks and then remove one
    testList.clear();
    testList.addYellow(0, new MegaBlock(Color.YELLOW, 'A'));
    testList.addYellow(1, new MegaBlock(Color.YELLOW, 'B'));
    testList.removeYellow(0);
    // checks that the list has a size of 1, a yellowCount of 1, and returns the correct string
    if (testList.size() != 1 || testList.getYellowCount() != 1 || !testList.toString().equals("YELLOW B -> END")) {
      return false;
    }
    
    // add a yellow block between a red and blue block and then remove it
    testList.clear();
    testList.addRed(new MegaBlock(Color.RED, 'A'));
    testList.addYellow(1, new MegaBlock(Color.YELLOW, 'B'));
    testList.addBlue(new MegaBlock(Color.BLUE, 'C'));
    testList.removeYellow(1);
    // checks that the list has a size of 2, a yellowCount of 0, and returns the correct string
    if (testList.size() != 2 || testList.getYellowCount() != 0 || !testList.toString().equals("RED A -> BLUE C -> END")) {
        return false;
    }
    
    return true;
  }
  
  /**
   * Main method calls all test methods and displays a message if any of them fail (test method
   * returns false)
   * 
   * @param args
   */
  public static void main(String[] args) {
    if (testMegaBlockEquals() == false) {
      System.out.println("testMegaBlockEquals() has failed.");
    }

    if (testMegaBlockToString() == false) {
      System.out.println("testMegaBlockToString() has failed");
    }

    if (testLinkedMegaBlock() == false) {
      System.out.println("testLinkedMegaBlock() has failed.");
    }

    if (testLinkedMegaBlockListAddRed() == false) {
      System.out.println("testLinkedMegaBlockListAddRed() has failed.");
    }

    if (testLinkedListMegaBlockRemoveBlue() == false) {
      System.out.println("testLinkedListMegaBlockRemoveBlue() has failed.");
    }

    if (testLinkedListMegaBlockRemoveRed() == false) {
      System.out.println("testLinkedListMegaBlockRemoveRed() has failed.");
    }
    
    if (testLinkedListMegaBlockRemoveYellow() == false) {
      System.out.println("testLinkedListMegaBlockRemoveYellow() has failed.");
    }
  }

}
