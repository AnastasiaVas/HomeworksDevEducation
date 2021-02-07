import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trees.impl.BSTreeRecursive;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BSTreeTest {

    static BSTreeRecursive bsTreeR1 = new BSTreeRecursive();
    static BSTreeRecursive bsTreeR2 = new BSTreeRecursive();
    static BSTreeRecursive bsTreeR3 = new BSTreeRecursive();

    @BeforeAll
    static void initialize() {
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


//
    //   @ParameterizedTest
    //   @MethodSource("addMultipleValTestArgs")
    //   void addMultipleValTest(int expected, int actual){
    //       bsTreeR2.add(expected);
    //       System.out.println(expected + " is added");
    //       assertEquals(expected, actual);
    //   }

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

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class InitTest {
        @BeforeAll
        void addValues() {
            bsTreeR3.init(new int[]{80, 70, 50, 55, 72, 71, 75, 85});
        }

        @Test
        void initUsualLeftTest() {
            assertEquals(bsTreeR2.root.left.left.right.value, bsTreeR3.root.left.left.right.value);
        }

        @Test
        void initUsualRightTest() {
            assertEquals(bsTreeR2.root.right.value, bsTreeR2.root.right.value);
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
        private Stream<Arguments> toArrayTestArgs(){
            return Stream.of(
                    arguments(bsTreeR1, new int[]{1, 3, 20}),
                    arguments(bsTreeR2, new int[]{55, 50, 71, 75, 72, 70, 85, 80}),
                    arguments(bsTreeR3, new int[0])
            );
        }

        @ParameterizedTest
        @MethodSource("toArrayTestArgs")
        void toArrayTest(BSTreeRecursive bsTreeRecursive, int[] expected){
            int[] actual = bsTreeRecursive.toArray();
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    class DeleteTest{

    }

    @Nested
    class GetWidthTest{

    }

    @Nested
    class GetHeightTest {

    }

    @Nested
    class NodesTest {

    }

    @Nested
    class LeavesTest {

    }

    @Nested
    class ReverseTest {

    }
}
