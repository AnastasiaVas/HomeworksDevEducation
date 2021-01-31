import memory.Memory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import processor.Processor;
import processor.ProcessorArm;
import processor.ProcessorX86;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessorTest {

    static Processor processor1;
    static Processor processor2;


    @Nested
    class ProcessorConstructorTest{

        @Test public void processorConstructorTest() {
            try {
                new ProcessorArm(1, "L1", (byte)64);
                new ProcessorX86(8.723F, "L3", (byte)4);
                new ProcessorArm(4.4F, "L2", (byte)32);
                new ProcessorX86(2.3F, "L3", (byte)16);
            } catch (Exception e) {
                Assertions.fail(e.getMessage());
            }
        }

        @Test
        public void processorConstructorTest_FREQUENCY() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new ProcessorArm(0F, "2L",  (byte) 32);
                new ProcessorArm(-3F, "2L",  (byte) 32);
                new ProcessorArm(9F, "2L",  (byte) 32);
            });


            String expectedMessage = "Frequency can't be lower that 1 Ghz or higher than 8.723 Ghz.";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        public void processorConstructorTest_CACHE() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new ProcessorArm(1.5F, null,  (byte) 32);
                new ProcessorArm(1.5F, "3L",  (byte) 32);
                new ProcessorArm(1.5F, "L4",  (byte) 32);
            });


            String expectedMessage = "Cache should be L1, L2 or L3.";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        public void processorConstructorTest_BIT_CAPACITY() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                new ProcessorArm(1.5F, "L1",  (byte) 12);
                new ProcessorArm(1.5F, "L2",  (byte) -32);
                new ProcessorArm(1.5F, "L3",  (byte) 2);
            });


            String expectedMessage = "Bit capacity should be: 4, 8, 16, 32 or 64.";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class GetDetailsTest{

        @BeforeAll
        void variablesInitialization(){
            processor1 =  new ProcessorArm(3.2F, "L1", (byte) 64);
            processor2 = new ProcessorX86(2F, "L3", (byte) 32);
        }

      private Stream<Arguments> getDetailsArgs() {
          return Stream.of(
                  Arguments.of(processor1, "processor.Processor details are as follows: frequency 3.2 GHz, cache L1, bit capacity 64 bits"),
                  Arguments.of(processor2, "processor.Processor details are as follows: frequency 2.0 GHz, cache L3, bit capacity 32 bits")
          );
      }

        @ParameterizedTest
        @MethodSource("getDetailsArgs")
        void getDetailsTest(Processor processor, String expected){
            String actual = processor.getDetails();
            assertEquals(actual, expected);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class DataProcessTest{

        @BeforeAll
        void variablesInitialization(){
            processor1 =  new ProcessorArm(3.2F, "L1", (byte) 64);
            processor2 = new ProcessorX86(2F, "L3", (byte) 32);
        }

        private Stream<Arguments> dataProcessLongTestArgs() {
            return Stream.of(
                    Arguments.of(processor1, 19034, 19037),
                    Arguments.of(processor2, 19034, 19031),
                    Arguments.of(processor1, 0, 3),
                    Arguments.of(processor2, 0, -3),
                    Arguments.of(processor1, -10, -7),
                    Arguments.of(processor2, -10, -13)
            );
        }

        private Stream<Arguments> dataProcessStringTestArgs() {
            return Stream.of(
                    Arguments.of(processor1, "House", "HouseA"),
                    Arguments.of(processor2, "House", "HouseB"),
                    Arguments.of(processor1, "a", "aA"),
                    Arguments.of(processor2, "b", "bB"),
                    Arguments.of(processor1, "", "A"),
                    Arguments.of(processor2, "", "B")
            );
        }

        private Stream<Arguments> dataProcessExceptionTestArgs() {
            return Stream.of(
                    Arguments.of(processor1, null),
                    Arguments.of(processor2, null)
            );
        }

        @ParameterizedTest
        @MethodSource("dataProcessLongTestArgs")
        void dataProcessLongTest(Processor processor, long input, long expected){
            long actual = processor.dataProcess(input);
            assertEquals(actual, expected);
        }

        @ParameterizedTest
        @MethodSource("dataProcessStringTestArgs")
        void dataProcessStringTest(Processor processor, String input, String expected){
            String actual = processor.dataProcess(input);
            assertEquals(actual, expected);
        }

        @ParameterizedTest
        @MethodSource("dataProcessExceptionTestArgs")
        void dataProcessExceptionTest(Processor processor, String input){
            Assertions.assertThrows(NullPointerException.class, () -> {
                processor.dataProcess(input);
            });
        }
    }
}
