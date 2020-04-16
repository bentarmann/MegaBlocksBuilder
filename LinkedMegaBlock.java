/////////////////////////////////////////// FILE  HEADER /////////////////////////////////////////////
//
// Title: Mega Blocks Builder 
// Files: Color.java, LinkedListMegaBlock.java, LinkedMegaBlock.java, MegaBlock.java,
//	  MegaBlockBuilderTester.java
// This File: LinkedMegaBlock.java
// 
// Name: Benjamin Tarmann
// Email: btarmann@wisc.edu
//
///////////////////////////////////////// 100 COLUMNS WIDE /////////////////////////////////////////

/**
 * This class models a linked Mega Block
 * 
 * @author Benjamin Tarmann
 *
 */
public class LinkedMegaBlock {
  private MegaBlock block;
  private LinkedMegaBlock next;

  /**
   * Creates a new LinkedMegaBlock that has a specific MegaBlock as data and null as next reference
   * 
   * @param block - data field to be set for this new LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Creates a new LinkedMegaBlock with a specific data block and a specific reference to the next
   * LinkedMegaBlock
   * 
   * @param block - data field to be set for this new LinkedMegaBlock
   * @param next  - reference to the next LinkedMegaBlock of this LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this(block);
    this.next = next;
  }

  /**
   * Returns the block data field of this LinkedMegaBlock
   * 
   * @return the block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return this.block;
  }

  /**
   * Sets the block instance field of this LinkedMegaBlock
   * 
   * @param block - the block to set
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Returns the reference to the next field of this LinkedMegaBlock
   * 
   * @return the next
   */
  public LinkedMegaBlock getNext() {
    return this.next;
  }

  /**
   * Sets the reference to the next field of this LinkedMegaBlock
   * 
   * @param next - the next to set
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }

  /**
   * Returns a string representation of this LinkedMegaBlock object
   * 
   * @return a string representation of this LinkedMegaBlock object
   */
  @Override
  public String toString() {
    String message;
    // string representation indicates when a LinkedMegaBlock object is at the end (has no next)
    if (this.next != null) {
      message = block.toString() + " -> ";
    } else {
      message = block.toString() + " -> END";
    }

    return message;
  }



}
