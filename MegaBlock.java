/////////////////////////////////////////// FILE  HEADER /////////////////////////////////////////////
//
// Title: Mega Blocks Builder 
// Files: Color.java, LinkedListMegaBlock.java, LinkedMegaBlock.java, MegaBlock.java,
//	  MegaBlockBuilderTester.java
// This File: MegaBlock.java
// 
// Name: Benjamin Tarmann
// Email: btarmann@wisc.edu
//
///////////////////////////////////////// 100 COLUMNS WIDE /////////////////////////////////////////

/**
 * This class models a Mega Block
 *
 */
public class MegaBlock {
  private final Color COLOR; // color of this Mega Block
  private char label; // label of this Mega Block

  /**
   * Creates a new MegaBlock object with a specific color index and a specific label
   * 
   * @param color color of this MegaBlock object
   * @param label of this MegaBlock object
   */
  public MegaBlock(Color color, char label) {
    this.COLOR = color;
    this.label = label;
  }

  /**
   * Returns the label of this MegaBlock object
   * 
   * @return the label
   */
  public char getLabel() {
    return label;
  }

  /**
   * Sets the label of this MegaBlock object to a specific one
   * 
   * @param label the label to set
   */
  public void setLabel(char label) {
    this.label = label;
  }

  /**
   * Returns the color of this MegaBlock object
   * 
   * @return the color of this MegaBlock object
   */
  public Color getColor() {
    return COLOR;
  }

  /**
   * Returns a String representation of this MegaBlock object
   * 
   * @return a String representation of this MegaBlock object
   */
  @Override
  public String toString() {
    return COLOR.toString() + " " + this.label;
  }

  /**
   * Returns true if this megaBlock is equal to otherBlock, false otherwise
   * 
   * @param otherBlock object to which this megaBlock will be compared
   * @return true if otherBlock refers to an instance of MegaBlock and the color of this megablock
   *         equals the color of the provided otherBlock.
   */
  @Override
  public boolean equals(Object otherBlock) {
    return (otherBlock instanceof MegaBlock && this.COLOR.equals(((MegaBlock) otherBlock).COLOR));
  }
}
