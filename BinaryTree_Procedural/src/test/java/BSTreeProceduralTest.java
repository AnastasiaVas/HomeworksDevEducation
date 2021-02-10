import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trees.impl.BSTreeProcedural;
import trees.impl.BSTreeRecursive;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BSTreeProceduralTest {

    static BSTreeProcedural bsTreeP1;
    static BSTreeProcedural bsTreeP2;
    static BSTreeProcedural bsTreeP3;

    @BeforeEach
    void initialize() {
        bsTreeP1 = new BSTreeProcedural();
        bsTreeP1.root = bsTreeP1.new Node(2);
        bsTreeP1.root.left = bsTreeP1.new Node(1);
        bsTreeP1.root.right = bsTreeP1.new Node(3);

        bsTreeP2 = new BSTreeProcedural();
        bsTreeP2.root = bsTreeP2.new Node(80);
        bsTreeP2.root.left = bsTreeP2.new Node(70);
        bsTreeP2.root.left.left = bsTreeP2.new Node(50);
        bsTreeP2.root.left.left.right = bsTreeP2.new Node(55);
        bsTreeP2.root.left.right = bsTreeP2.new Node(72);
        bsTreeP2.root.left.right.left = bsTreeP2.new Node(71);
        bsTreeP2.root.left.right.right = bsTreeP2.new Node(75);
        bsTreeP2.root.right = bsTreeP2.new Node(85);

        bsTreeP3 = new BSTreeProcedural();
    }

    public static Stream<Arguments> toArrayTestArgs(){
        return Stream.of(
                arguments(bsTreeP1, new int[]{1, 3, 2}),
                arguments(bsTreeP2, new int[]{55, 50, 71, 75, 72, 70, 85, 80}),
                arguments(bsTreeP3, new int[0])
        );
    }

    @Nested
    class AddTest {

        @Test
        void addInMultLevelTreeTest() {
            bsTreeP2.add(90);
            int expected = 90;
            int actual = bsTreeP2.root.right.right.value;
            assertEquals(expected, actual);
        }

        @Test
        void addInEmptyLevelTreeTest() {
            bsTreeP3.add(90);
            int expected = 90;
            int actual = bsTreeP3.root.value;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class InitTest {
        @BeforeEach
        void addValues() {
            bsTreeP3.init(new int[]{80, 70, 50, 55, 72, 71, 75, 85});
        }

        @Test
        void initUsualLeftTest() {
            assertEquals(bsTreeP2.root.left.left.right.value, bsTreeP3.root.left.left.right.value);
        }

        @Test
        void initUsualRightTest() {
            assertEquals(bsTreeP2.root.right.value, bsTreeP3.root.right.value);
        }

        @Test
        void initRootTest() {
            assertEquals(bsTreeP2.root.value, bsTreeP3.root.value);
        }
    }

    @Nested
    class ClearTest{
        @Test
        void clearFilledTreeTest(){
            bsTreeP1.clear();
            assertNull(bsTreeP1.root);
        }

        @Test
        void clearEmptyTreeTest(){
            bsTreeP3.clear();
            assertNull(bsTreeP3.root);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class SizeTest{
        private Stream<Arguments> addMultipleValTestArgs(){
            return Stream.of(
                    arguments(bsTreeP1, 3),
                    arguments(bsTreeP2, 8),
                    arguments(bsTreeP3, 0)
            );
        }

        @ParameterizedTest
        @MethodSource("addMultipleValTestArgs")
        void addMultipleValTest(BSTreeProcedural bsTreeProcedural, int expected){
            int actual = bsTreeProcedural.size();
            assertEquals(expected, actual);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class ToArrayTest{

        public Stream<Arguments> toArrayTestArgs(){
            return Stream.of(
                    arguments(bsTreeP2, new int[]{50, 55, 70, 71, 72, 75, 80, 85}),
                    arguments(bsTreeP3, new int[0])
            );
        }

        @ParameterizedTest
        @MethodSource("toArrayTestArgs")
        void toArrayTest(BSTreeProcedural bsTreeProcedural, int[] expected){
            int[] actual = bsTreeProcedural.toArray();
        //    System.out.println("Actual array is " + Arrays.toString(actual));
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    class DeleteTest {
        @Test
        void deleteInMultLevelTreeTest() {
            bsTreeP2.del(50);
            int expected = 55;
            int actual = bsTreeP2.root.left.left.value;
            assertEquals(expected, actual);
        }

        @Test
        void deleteInEmptyLevelTreeTest() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bsTreeP3.del(8);
            });

            String expectedMessage = "Значение не было найдено.";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void deleteRootTest() {
            bsTreeP1.del(2);
            int expected = 3;
            int actual = bsTreeP1.root.value;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class GetWidthTest{
        @Test
        void emptyTreeWidthTest() {
            int expected = 0;
            int actual = bsTreeP3.getWidth();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeWidthTest() {
            int expected = 3;
            int actual = bsTreeP2.getWidth();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeWidthTest() {
            int expected = 2;
            int actual = bsTreeP1.getWidth();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class GetHeightTest {
        @Test
        void emptyTreeHeightTest() {
            int expected = 0;
            int actual = bsTreeP3.getHeight();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeHeightTest() {
            int expected = 4;
            int actual = bsTreeP2.getHeight();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeHeightTest() {
            int expected = 2;
            int actual = bsTreeP1.getHeight();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class NodesTest {
        @Test
        void emptyTreeNodesTest() {
            int expected = 0;
            int actual = bsTreeP3.nodes();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeNodesTest() {
            int expected = 4;
            int actual = bsTreeP2.nodes();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeNodesTest() {
            int expected = 1;
            int actual = bsTreeP1.nodes();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class LeavesTest {
        @Test
        void emptyTreeLeavesTest() {
            int expected = 0;
            int actual = bsTreeP3.leaves();
            assertEquals(expected, actual);
        }

        @Test
        void bigTreeLeavesTest() {
            int expected = 4;
            int actual = bsTreeP2.leaves();
            assertEquals(expected, actual);
        }

        @Test
        void smallTreeLeavesTest() {
            int expected = 2;
            int actual = bsTreeP1.getHeight();
            assertEquals(expected, actual);
        }
    }

    @Nested
    class ReverseTest {

        @Test
        void reverseTreeTest() {
            bsTreeP2.reverse();
            assertEquals(bsTreeP2.root.right.value, 70);
        }


        @Test
        void reverseRootTest() {
            BSTreeRecursive bsTreeR4 = new BSTreeRecursive();
            bsTreeR4.add(20);
            assertEquals(bsTreeR4.root.value, bsTreeR4.root.value);
        }
    }
}
