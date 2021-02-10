import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trees.impl.BSTreeRecursive;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BSTreeRecursiveTest {

    static BSTreeRecursive bsTreeR1;
    static BSTreeRecursive bsTreeR2;
    static BSTreeRecursive bsTreeR3;

    @BeforeEach
    void initialize() {
        bsTreeR1 = new BSTreeRecursive();
        bsTreeR1.root = bsTreeR1.new Node(2);
        bsTreeR1.root.left = bsTreeR1.new Node(1);
        bsTreeR1.root.right = bsTreeR1.new Node(3);

        bsTreeR2 = new BSTreeRecursive();
        bsTreeR2.root = bsTreeR2.new Node(80);
        bsTreeR2.root.left = bsTreeR2.new Node(70);
        bsTreeR2.root.left.left = bsTreeR2.new Node(50);
        bsTreeR2.root.left.left.right = bsTreeR2.new Node(55);
        bsTreeR2.root.left.right = bsTreeR2.new Node(72);
        bsTreeR2.root.left.right.left = bsTreeR2.new Node(71);
        bsTreeR2.root.left.right.right = bsTreeR2.new Node(75);
        bsTreeR2.root.right = bsTreeR2.new Node(85);

        bsTreeR3 = new BSTreeRecursive();
    }

    public static Stream<Arguments> toArrayTestArgs(){
        return Stream.of(
                arguments(bsTreeR1, new int[]{1, 3, 2}),
                arguments(bsTreeR2, new int[]{55, 50, 71, 75, 72, 70, 85, 80}),
                arguments(bsTreeR3, new int[0])
        );
    }

    @Nested
    class AddTest {

        @Test
        void addInMultLevelTreeTest() {
            bsTreeR2.add(90);
            int expected = 90;
            int actual = bsTreeR2.root.right.right.value;
            assertEquals(expected, actual);
        }

        @Test
        void addInEmptyLevelTreeTest() {
            bsTreeR3.add(90);
            int expected = 90;
            int actual = bsTreeR3.root.value;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class InitTest {
        @BeforeEach
        void addValues() {
            bsTreeR3.init(new int[]{80, 70, 50, 55, 72, 71, 75, 85});
        }

        @Test
        void initUsualLeftTest() {
            assertEquals(bsTreeR2.root.left.left.right.value, bsTreeR3.root.left.left.right.value);
        }

        @Test
        void initUsualRightTest() {
            assertEquals(bsTreeR2.root.right.value, bsTreeR3.root.right.value);
        }

        @Test
        void initRootTest() {
            assertEquals(bsTreeR2.root.value, bsTreeR3.root.value);
        }
    }

    @Nested
    class ClearTest{
        @Test
        void clearFilledTreeTest(){
            bsTreeR1.clear();
            assertNull(bsTreeR1.root);
        }

        @Test
        void clearEmptyTreeTest(){
            bsTreeR3.clear();
            assertNull(bsTreeR3.root);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class SizeTest{
        private Stream<Arguments> addMultipleValTestArgs(){
            return Stream.of(
                    arguments(bsTreeR1, 3),
                    arguments(bsTreeR2, 8),
                    arguments(bsTreeR3, 0)
            );
        }

        @ParameterizedTest
        @MethodSource("addMultipleValTestArgs")
        void addMultipleValTest(BSTreeRecursive bsTreeRecursive, int expected){
            int actual = bsTreeRecursive.size();
            assertEquals(expected, actual);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class ToArrayTest{

        ToArrayTest(){
            BSTreeRecursive bsTreeR1 = new BSTreeRecursive();
            bsTreeR1.root = bsTreeR1.new Node(2);
            bsTreeR1.root.left = bsTreeR1.new Node(1);
            bsTreeR1.root.right = bsTreeR1.new Node(3);

            BSTreeRecursive bsTreeR2 = new BSTreeRecursive();
            bsTreeR2.root = bsTreeR2.new Node(80);
            bsTreeR2.root.left = bsTreeR2.new Node(70);
            bsTreeR2.root.left.left = bsTreeR2.new Node(50);
            bsTreeR2.root.left.left.right = bsTreeR2.new Node(55);
            bsTreeR2.root.left.right = bsTreeR2.new Node(72);
            bsTreeR2.root.left.right.left = bsTreeR2.new Node(71);
            bsTreeR2.root.left.right.right = bsTreeR2.new Node(75);
            bsTreeR2.root.right = bsTreeR2.new Node(85);

            BSTreeRecursive bsTreeR3 = new BSTreeRecursive();
        }

     public Stream<Arguments> toArrayTestArgs(){
         return Stream.of(
                 arguments(bsTreeR2, new int[]{55, 50, 71, 75, 72, 70, 85, 80}),
                 arguments(bsTreeR3, new int[0])
         );
     }

        @ParameterizedTest
        @MethodSource("toArrayTestArgs")
        void toArrayTest(BSTreeRecursive bsTreeRecursive, int[] expected){
            int[] actual = bsTreeRecursive.toArray();
            System.out.println("Actual array is " + Arrays.toString(actual));
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    class DeleteTest{
        @Test
        void deleteInMultLevelTreeTest() {
            bsTreeR2.del(50);
            int expected = 55;
            int actual = bsTreeR2.root.left.left.value;
            assertEquals(expected, actual);
        }

        @Test
        void deleteRootTest() {
            bsTreeR1.del(2);
            int expected = 3;
            int actual = bsTreeR1.root.value;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class GetWidthTest{
        @Test
        void emptyTreeWidthTest() {
            int expected = 0;
            int actual = bsTreeR3.getWidth();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeWidthTest() {
            int expected = 3;
            int actual = bsTreeR2.getWidth();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeWidthTest() {
            int expected = 2;
            int actual = bsTreeR1.getWidth();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class GetHeightTest {
        @Test
        void emptyTreeHeightTest() {
            int expected = 0;
            int actual = bsTreeR3.getHeight();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeHeightTest() {
            int expected = 4;
            int actual = bsTreeR2.getHeight();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeHeightTest() {
            int expected = 2;
            int actual = bsTreeR1.getHeight();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class NodesTest {
        @Test
        void emptyTreeNodesTest() {
            int expected = 0;
            int actual = bsTreeR3.nodes();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeNodesTest() {
            int expected = 4;
            int actual = bsTreeR2.nodes();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeNodesTest() {
            int expected = 1;
            int actual = bsTreeR1.nodes();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class LeavesTest {
        @Test
        void emptyTreeLeavesTest() {
            int expected = 0;
            int actual = bsTreeR3.leaves();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeLeavesTest() {
            int expected = 4;
            int actual = bsTreeR2.leaves();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeLeavesTest() {
            int expected = 2;
            int actual = bsTreeR1.getHeight();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class ReverseTest {

        @Test
        void reverseTreeTest() {
            bsTreeR2.reverse();
            assertEquals(bsTreeR2.root.right.value, 70);
        }


        @Test
        void reverseRootTest() {
            BSTreeRecursive bsTreeR4 = new BSTreeRecursive();
            bsTreeR4.add(20);
            assertEquals(bsTreeR4.root.value, bsTreeR4.root.value);
        }
    }
}
