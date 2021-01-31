import memory.Memory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.MatcherAssert.assertThat;


public class MemoryTest {

    Memory memory1;
    Memory memory2;
    Memory memory3;

    String[] memoryCell1;
    String[] memoryCell2;
    String[] memoryCell3;

    @Nested
    class MemoryConstructorTest{
        String[] stringArray;

        @Test public void memoryConstructorTest() {
            try {
                memory1 = new Memory(memoryCell1);
                memory2 = new Memory(memoryCell2);
                memory3 = new Memory(memoryCell3);
            } catch (Exception e) {
                Assertions.fail(e.getMessage());
            }
        }

        @Test
        public void memoryConstructorTest_EXCEPTION() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new Memory(new String[]{"a", "b", "c"});
                new Memory(stringArray);
                new Memory(new String[]{null, "b", null});
            });


            String expectedMessage = "Provided array should be initialized and empty.";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class MethodsTest{

        @BeforeAll
        void memoryCellsInitialization() {
            memoryCell1 = new String[5];
            memory1 = new Memory(memoryCell1);
            memory1.save("a");
            memory1.save("b");
            memory1.save("c");
        }

        @Order(1)
        @Test
        void readLastTest() {
            String expected = "c";
            String actual = memory1.readLast();
            assertEquals(expected, actual);
        }

        @Order(3)
        @Test
        void removeLastTest() {
            String expected = "d";
            String actual = memory1.removeLast();
            assertEquals(expected, actual);
        }

        @Order(2)
        @Test
        void saveTest() {
            boolean expected = true;
            boolean actual = memory1.save("d");
            assertEquals(expected, actual);
        }

        @Order(4)
        @Test
        void getMemoryInfoTest() {
            Memory.MemoryInfo expected = new Memory.MemoryInfo(5, 0.6);
            Memory.MemoryInfo actual = memory1.getMemoryInfo();
            assertThat(expected, samePropertyValuesAs(actual));
        }
    }
}
