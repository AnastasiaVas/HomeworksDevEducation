import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import trees.impl.AVLTree;
import trees.impl.BSTreeRecursive;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AVLTreeTest {

    static AVLTree AVLTreeEven;
    static AVLTree AVlTreeLeftImb;
    static AVLTree AVlTreeRightImb;
    static AVLTree AVLTreeEmpty;

    @BeforeEach
    void initialize() {
        AVLTreeEven = new AVLTree();
        AVLTreeEven.root = AVLTreeEven.new Node(2);
        AVLTreeEven.root.left = AVLTreeEven.new Node(1);
        AVLTreeEven.root.right = AVLTreeEven.new Node(3);

        AVlTreeLeftImb = new AVLTree();
        AVlTreeLeftImb.root = AVlTreeLeftImb.new Node(80);
        AVlTreeLeftImb.root.left = AVlTreeLeftImb.new Node(70);
        AVlTreeLeftImb.root.left.left = AVlTreeLeftImb.new Node(50);
        AVlTreeLeftImb.root.left.left.right = AVlTreeLeftImb.new Node(55);
        AVlTreeLeftImb.root.left.right = AVlTreeLeftImb.new Node(72);
        AVlTreeLeftImb.root.left.right.left = AVlTreeLeftImb.new Node(71);
        AVlTreeLeftImb.root.left.right.right = AVlTreeLeftImb.new Node(75);
        AVlTreeLeftImb.root.right = AVlTreeLeftImb.new Node(85);
        AVlTreeLeftImb.root.right.right = AVlTreeLeftImb.new Node(90);

        AVlTreeRightImb = new AVLTree();
        AVlTreeRightImb.root = AVlTreeLeftImb.new Node(80);
        AVlTreeRightImb.root.left = AVlTreeLeftImb.new Node(70);
        AVlTreeRightImb.root.left.left = AVlTreeLeftImb.new Node(50);
        AVlTreeRightImb.root.left.right = AVlTreeLeftImb.new Node(72);
        AVlTreeRightImb.root.right = AVlTreeLeftImb.new Node(85);
        AVlTreeRightImb.root.right.left = AVlTreeLeftImb.new Node(83);
        AVlTreeRightImb.root.right.right = AVlTreeLeftImb.new Node(90);
        AVlTreeRightImb.root.right.right.right = AVlTreeLeftImb.new Node(95);
        AVlTreeRightImb.root.right.right.left = AVlTreeLeftImb.new Node(88);


        AVLTreeEmpty = new AVLTree();
    }

    public static Stream<Arguments> toArrayTestArgs(){
        return Stream.of(
                arguments(AVLTreeEven, new int[]{1, 3, 2}),
                arguments(AVlTreeLeftImb, new int[]{55, 50, 71, 75, 72, 70, 85, 80}),
                arguments(AVLTreeEmpty, new int[0])
        );
    }

    @Nested
    class AddTest {

        @Test
        void addLeftTurnTreeTest() {
            AVlTreeRightImb.add(100);
            int expected = 90;
            int actual = AVlTreeRightImb.root.left.value;
            assertEquals(expected, actual);
        }

        @Test
        void addRightTurnTreeTest() {
            AVlTreeLeftImb.add(77);
            int expected = 72;
            int actual = AVlTreeLeftImb.root.right.right.value;
            assertEquals(expected, actual);
        }

        @Test
        void addEvenTreeTest() {
            AVLTreeEven.add(90);
            int expected = 90;
            int actual = AVLTreeEven.root.right.right.value;
            assertEquals(expected, actual);
        }

        @Test
        void addInEmptyLevelTreeTest() {
            AVLTreeEmpty.add(90);
            int expected = 90;
            int actual = AVLTreeEmpty.root.value;
            assertEquals(expected, actual);
        }
    }

  //  @Nested
  //  class InitTest {
  //      @BeforeEach
  //      void addValues() {
  //          bsTreeR3.init(new int[]{80, 70, 50, 55, 72, 71, 75, 85});
  //      }
//
  //      @Test
  //      void initUsualLeftTest() {
  //          assertEquals(bsTreeR2.root.left.left.right.value, bsTreeR3.root.left.left.right.value);
  //      }
//
  //      @Test
  //      void initUsualRightTest() {
  //          assertEquals(bsTreeR2.root.right.value, bsTreeR3.root.right.value);
  //      }
//
  //      @Test
  //      void initRootTest() {
  //          assertEquals(bsTreeR2.root.value, bsTreeR3.root.value);
  //      }
  //  }
//
  //  @Nested
  //  class ClearTest{
  //      @Test
  //      void clearFilledTreeTest(){
  //          bsTreeR1.clear();
  //          assertNull(bsTreeR1.root);
  //      }
//
  //      @Test
  //      void clearEmptyTreeTest(){
  //          bsTreeR3.clear();
  //          assertNull(bsTreeR3.root);
  //      }
  //  }
//
  //  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  //  @Nested
  //  class SizeTest{
  //      private Stream<Arguments> addMultipleValTestArgs(){
  //          return Stream.of(
  //                  arguments(bsTreeR1, 3),
  //                  arguments(bsTreeR2, 8),
  //                  arguments(bsTreeR3, 0)
  //          );
  //      }
//
  //      @ParameterizedTest
  //      @MethodSource("addMultipleValTestArgs")
  //      void addMultipleValTest(BSTreeRecursive bsTreeRecursive, int expected){
  //          int actual = bsTreeRecursive.size();
  //          assertEquals(expected, actual);
  //      }
  //  }
//
  //  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  //  @Nested
  //  class ToArrayTest{
//
  //      public Stream<Arguments> toArrayTestArgs(){
  //          return Stream.of(
  //                  arguments(bsTreeR2, new int[]{55, 50, 71, 75, 72, 70, 85, 80}),
  //                  arguments(bsTreeR3, new int[0])
  //          );
  //      }
//
  //      @ParameterizedTest
  //      @MethodSource("toArrayTestArgs")
  //      void toArrayTest(BSTreeRecursive bsTreeRecursive, int[] expected){
  //          int[] actual = bsTreeRecursive.toArray();
  //          assertArrayEquals(expected, actual);
  //      }
  //  }
//
  //  @Nested
  //  class DeleteTest{
  //      @Test
  //      void deleteInMultLevelTreeTest() {
  //          bsTreeR2.del(50);
  //          int expected = 55;
  //          int actual = bsTreeR2.root.left.left.value;
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void deleteRootTest() {
  //          bsTreeR1.del(2);
  //          int expected = 3;
  //          int actual = bsTreeR1.root.value;
  //          assertEquals(expected, actual);
  //      }
  //  }
//
  //  @Nested
  //  class GetWidthTest{
  //      @Test
  //      void emptyTreeWidthTest() {
  //          int expected = 0;
  //          int actual = bsTreeR3.getWidth();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void bigTreeWidthTest() {
  //          int expected = 3;
  //          int actual = bsTreeR2.getWidth();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void smallTreeWidthTest() {
  //          int expected = 2;
  //          int actual = bsTreeR1.getWidth();
  //          assertEquals(expected, actual);
  //      }
  //  }
//
  //  @Nested
  //  class GetHeightTest {
  //      @Test
  //      void emptyTreeHeightTest() {
  //          int expected = 0;
  //          int actual = bsTreeR3.getHeight();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void bigTreeHeightTest() {
  //          int expected = 4;
  //          int actual = bsTreeR2.getHeight();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void smallTreeHeightTest() {
  //          int expected = 2;
  //          int actual = bsTreeR1.getHeight();
  //          assertEquals(expected, actual);
  //      }
  //  }
//
  //  @Nested
  //  class NodesTest {
  //      @Test
  //      void emptyTreeNodesTest() {
  //          int expected = 0;
  //          int actual = bsTreeR3.nodes();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void bigTreeNodesTest() {
  //          int expected = 4;
  //          int actual = bsTreeR2.nodes();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void smallTreeNodesTest() {
  //          int expected = 1;
  //          int actual = bsTreeR1.nodes();
  //          assertEquals(expected, actual);
  //      }
  //  }
//
  //  @Nested
  //  class LeavesTest {
  //      @Test
  //      void emptyTreeLeavesTest() {
  //          int expected = 0;
  //          int actual = bsTreeR3.leaves();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void bigTreeLeavesTest() {
  //          int expected = 4;
  //          int actual = bsTreeR2.leaves();
  //          assertEquals(expected, actual);
  //      }
//
  //      @Test
  //      void smallTreeLeavesTest() {
  //          int expected = 2;
  //          int actual = bsTreeR1.getHeight();
  //          assertEquals(expected, actual);
  //      }
  //  }
//
  //  @Nested
  //  class ReverseTest {
//
  //      @Test
  //      void reverseTreeTest() {
  //          bsTreeR2.reverse();
  //          assertEquals(bsTreeR2.root.right.value, 70);
  //      }
//
//
  //      @Test
  //      void reverseRootTest() {
  //          BSTreeRecursive bsTreeR4 = new BSTreeRecursive();
  //          bsTreeR4.add(20);
  //          assertEquals(bsTreeR4.root.value, bsTreeR4.root.value);
  //      }
  //  }
}
