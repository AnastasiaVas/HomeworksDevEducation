import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import view.CalcInterface;

import javax.swing.*;

public class CalculatorTest {

    @Mock
    private CalcInterface calculator = new CalcInterface();

    @Mock
    JTextField textF;

    @Mock
    JTextField textF2;

    @Mock
    JTextField textF3;

    @Mock
    JTextArea textArea;

    @Mock
    double answer;

    @InjectMocks
    private CalcInterface calc;

    @BeforeAll
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calcTest(){
        String returnedMsgTextF = "/";
        int returnedMsgTextF2 = 6;
        int returnedMsgTextF3 = 5;
        double returnedMsg = 1.2;

        Mockito.when(textF.getText()).thenReturn(returnedMsgTextF);
        Mockito.when(textF2.getText()).thenReturn(String.valueOf(returnedMsgTextF2));
        Mockito.when(textF3.getText()).thenReturn(String.valueOf(returnedMsgTextF3));

//        calc.valuesGetter();

        Mockito.verify(textArea, Mockito.only()).setText(String.valueOf(returnedMsg));
    }
}
