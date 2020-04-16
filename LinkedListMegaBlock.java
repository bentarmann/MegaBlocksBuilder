/////////////////////////////////////////// FILE  HEADER /////////////////////////////////////////////
//
// Title: Mega Blocks Builder 
// Files: Color.java, LinkedListMegaBlock.java, LinkedMegaBlock.java, MegaBlock.java,
//	  MegaBlockBuilderTester.java
// This File: LinkedListMegaBlock.java
// 
// Name: Benjamin Tarmann
// Email: btarmann@wisc.edu
//
///////////////////////////////////////// 100 COLUMNS WIDE /////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class models a list/chain of linked mega blocks
 * 
 * @author Benjamin Tarmann
 */
public class LinkedListMegaBlock {
  private LinkedMegaBlock head; // head of this list
  public LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of MegaBlocks stored in this list)
  private int redCount; // number of RED MegaBlocks stored in this block
  private int yellowCount; // number of YELLOW MegaBlocks stored in this list
  private int blueCount; // number of BLUE MegaBlocks stored in this list

  /**
   * Creates an empty linked list of mega blocks
   */
  LinkedListMegaBlock() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Return true if this list contains no elements
   * 
   * @return true if this list is empty, and false otherwise
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the size of this list
   * 
   * @return the number of MegaBlocks stored in this list
   */
  public int size() {
    return size;
  }

  /**
   * Removes all of the elements from this list. This list will be empty after this call returns
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Adds a blue block at the end of this list
   * 
   * @param blueBlock - new element to be added to this list
   * @throws IllegalArgumentException - if blueBlock is null or if the color of the specific
   *                                  blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) {
    // checks that blueBlock is not null
    if (blueBlock == null) {
      throw new IllegalArgumentException("blueBlock is null.");
    }

    // checks that the color of blueBlock is equal to Color.BLUE
    if (blueBlock.getColor() != Color.BLUE) {
      throw new IllegalArgumentException("blueBlock cannot be a color other than blue.");
    }

    LinkedMegaBlock linkedBlueBlock = new LinkedMegaBlock(blueBlock);

    if (size == 0) { // list empty
      head = linkedBlueBlock;
      tail = linkedBlueBlock;
    } else { // list not empty (insert at end)
      tail.setNext(linkedBlueBlock);
      tail = linkedBlueBlock;
    }

    size++;
    blueCount++;
  }

  /**
   * Adds a new object at the head of this list
   * 
   * @param redBlock - new element to be added to this list
   * @throws IllegalArgumentException - if redBlock is null or if its color does not equal Color.RED
   */
  public void addRed(MegaBlock redBlock) {
    // checks that redBlock is not null
    if (redBlock == null) {
      throw new IllegalArgumentException("redBlock is null.");
    }

    // checks that the color of redBlock is equal to Color.RED
    if (redBlock.getColor() != Color.RED) {
      throw new IllegalArgumentException("redBlock cannot be a color other than red.");
    }

    LinkedMegaBlock linkedRedBlock = new LinkedMegaBlock(redBlock);
    LinkedMegaBlock temp;

    if (size == 0) { // list empty
      head = linkedRedBlock;
      tail = linkedRedBlock;
    } else { // list not empty (insert at beginning)
      temp = head;
      head = linkedRedBlock;
      head.setNext(temp);
    }
    
    size++;
    redCount++;
  }

  /**
   * Adds the provided yellowBlock at the position index in this list
   * 
   * @param index       - index at which the specified yellow block is to be inserted
   * @param yellowBlock - new element to be added to this list
   * @throws IllegalArgumentException  - if yellowBlock is null or if it does not have a
   *                                   Color.YELLOW color
   * @throws IndexOutOfBoundsException - if the index is out of the range reserved for yellow blocks
   *                                   (index < redCount || index > size - blueCount)
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    // checks that yellowBlock is not null
    if (yellowBlock == null) {
      throw new IllegalArgumentException("yellowBlock is null.");
    }

    // checks that the color of yellowBlock is equal to Color.YELLOW
    if (yellowBlock.getColor() != Color.YELLOW) {
      throw new IllegalArgumentException("yellowBlock cannot be a color other than yellow.");
    }

    // checks that the index is within the range reserved for yellow blocks
    if (index < redCount || index > size - blueCount) {
      throw new IndexOutOfBoundsException("Index is out of the range reserved for yellow blocks.");
    }

    LinkedMegaBlock linkedYellowBlock = new LinkedMegaBlock(yellowBlock);
    LinkedMegaBlock temp = null;

    if (size == 0) { // list empty (insert at beginning / as first index)
      head = linkedYellowBlock;
      tail = linkedYellowBlock;
    }
    else if (index == this.size) { // insert at end (only when there are no blue blocks, checked above)
      tail.setNext(linkedYellowBlock);
      tail = linkedYellowBlock;
    }
    else { // list not empty (insert in middle)
      // sets temp equal to the block at index - 1
      for (int i = 0; i <= index - 1; i++) {
        if (i == 0) {
          temp = head;
        } else {
          temp = temp.getNext();
        }
      }

      linkedYellowBlock.setNext(temp.getNext());
      temp.setNext(linkedYellowBlock);
    }

    size++;
    yellowCount++;
  }

  /**
   * Returns the element stored at position index of this list without removing it
   * 
   * @param index - position within this list
   * @return the megablock object stored at position index of this list
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index is out of range.");
    }

    LinkedMegaBlock temp = head;
    for (int i = 0; i <= index; i++) {
      if (i == 0) {
        continue;
      }
      else {
        temp = temp.getNext();
      }
    }

    return temp.getBlock();
  }

  /**
   * Replaces the MegaBlock at the specified position in this list with the specified element if
   * they have the same color
   * 
   * @param index - index of the block to replace
   * @param block - element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IllegalArgumentException  - if object is null or is not equal to the megablock already
   *                                   at index position
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size)
   */
  public MegaBlock set(int index, MegaBlock block) {
    // checks that block is not null
    if (block == null) {
      throw new IllegalArgumentException("Block cannot be null.");
    }

    // checks that the index is within the correct range
    if (size < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index is out of range.");
    }
     
    LinkedMegaBlock blockBeforeReplacedBlock = null;
    LinkedMegaBlock removedBlock = null;
    
    // finds the block before the block to be replaced
    if (index == 0) {
      removedBlock = head;
      blockBeforeReplacedBlock = head;
    }
    else if (index == this.size - 1) {
      removedBlock = tail;
      blockBeforeReplacedBlock = tail;
    }
    else {
      for (int i = 0; i <= index; i++) {
        if (i == 0) {
          removedBlock = head;
        }
        else {
          removedBlock = removedBlock.getNext(); // sets oldBlock to the block at index i + 1
        }
      }
    }
    
    // checks that newBlock and oldBlock have the same color
    if (block.getColor() != removedBlock.getBlock().getColor()) {
      throw new IllegalArgumentException("newBlock must have the same color as oldBlock.");
    }
    
    LinkedMegaBlock oldBlock = removedBlock;
    LinkedMegaBlock newBlock = new LinkedMegaBlock(block);
    if (index == 0) {
      head = newBlock;
      newBlock.setNext(removedBlock.getNext());
    }
    else if (index == this.size - 1) {
      tail = new LinkedMegaBlock(block);
    }
    else {
      removedBlock = newBlock;
      newBlock.setNext(removedBlock.getNext());
    }


    return removedBlock.getBlock();
  }

  /**
   * Removes and returns the mega block at the head of this list if its color is red
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException - if this list does not contain any red mega block
   */
  public MegaBlock removeRed() {
    // checks that the list contains red blocks
    if (head.getBlock().getColor() != Color.RED) {
      throw new NoSuchElementException("List does not contain any red mega blocks.");
    }

    LinkedMegaBlock oldBlock = head;
    if (size == 1) { // only element in the list is the one to remove
      clear();
    }
    else { 
      head = oldBlock.getNext();
      redCount--;
      size--;
    }

    return oldBlock.getBlock();
  }

  /**
   * Removes and returns the element at the tail of this list if it has a blue color
   * 
   * @return a reference to the element at the tail of this list if it has a blue color
   * @throws NoSuchElementException - if this list does not contain any blue block
   */
  public MegaBlock removeBlue() {
    // checks that the list contains blue blocks
    if (tail.getBlock().getColor() != Color.BLUE) {
      throw new NoSuchElementException("List does not contain any blue mega blocks.");
    }

    LinkedMegaBlock oldBlock = tail;
    if (size == 1) { // singular blue block in list
      clear();
    } else {
      LinkedMegaBlock nodeBeforeOldBlock = null;
      // find the node before the block to remove
      for (int i = 0; i <= size - 2; i++) {
        if (i == 0) {
          nodeBeforeOldBlock = head;
        }
        else {
          nodeBeforeOldBlock = nodeBeforeOldBlock.getNext();
        }
      }  
      tail = nodeBeforeOldBlock;
      tail.setNext(null);
      size--;
      blueCount--;
    }

    return oldBlock.getBlock();
  }

  /**
   * Removes and returns the element stored at index position in this list
   * 
   * @param index - position of the element to remove in this list
   * @return a reference to the removed element
   * @throws IndexOutOfBoundsException - if the index is out of range (index < redCount || index >=
   *                                   size - blueCount)
   */
  public MegaBlock removeYellow(int index) {
    // checks that the index is within the correct range
    if (index < redCount || index >= size - blueCount) {
      throw new IndexOutOfBoundsException("Index is out of range.");
    }
    
    LinkedMegaBlock oldBlock = null;
    LinkedMegaBlock blockBeforeOldBlock = null;
    if (size == 1) { // block to remove is only block in list
      oldBlock = head;
      clear();
    }
    else { // more than one block in list
      for (int i = 0; i <= index; i++) {
        if (i == 0) {
          oldBlock = head;
        } else {
          oldBlock = oldBlock.getNext();
        }
      }
      if (index != 0) { // removing from middle or end of list
        for (int i = 0; i <= index - 1; i++) {
          if (i == 0) {
            blockBeforeOldBlock = head;
          } else {
            blockBeforeOldBlock = blockBeforeOldBlock.getNext();
          }
        }
        blockBeforeOldBlock.setNext(oldBlock.getNext());
      }
      else { // removing from beginning of list
        head = oldBlock.getNext();
      }
      
      
      size--;
      yellowCount--;
    }
    
    return oldBlock.getBlock();
  }

  /**
   * Returns the number of red mega blocks stored in this list
   * 
   * @return the redCount
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * Returns the number of yellow mega blocks stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * Returns the number of blue mega blocks stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * Returns a String representation of this list
   * 
   * @return a String representation of the content of this list. If this list is empty, an empty
   *         String ("") will be returned
   */
  public String toString() {
    if (size == 0) {
      return "";
    }
    
    LinkedMegaBlock currentNode = null;
    String s = "";
    
    for (int i = 0; i <= size - 1; i++) {
      if (i == 0) {
        currentNode = head;
      }
      else {
        currentNode = currentNode.getNext();
      }
      s += currentNode.toString();
    }
    
    return s;
  }
}
