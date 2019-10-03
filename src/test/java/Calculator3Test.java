import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Calculator3Test {

    private Calculator3 cal;

    @Before
    public void setUp(){
        cal = new Calculator3();
    }

    @Test
    public void 빈문자열을_입력할_경우_0을_반환해야_한다(){
        // given
        String text = " ";

        // then
        assertEquals(0, cal.add(text));
    }

    @Test
    public void null값을_입력할_경우_0을_반환해야_한다(){
        // given
        String text = null;

        // then
        assertEquals(0, cal.add(text));
    }
    @Test
    public void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(){
        // given
        String text = "1";

        // then
        assertEquals(1, cal.add(text));
    }
    @Test
    public void 숫자_두개를_쉼표_구분자로_입력할_경우_두_숫자의_합을_반환한다(){
        // given
        String text = "1,2";

        // then
        assertEquals(3, cal.add(text));
    }
    @Test
    public void 구분자를_쉼표_이외에_콜론을_사용할_수_있다(){
        // given
        String text = "1,2:3";

        // then
        assertEquals(6, cal.add(text));
    }
    @Test
    public void 슬러시두개와_역슬러시n_문자_사이에_커스텀_구분자를_지정할_수_있다(){
        // given
        String text = "//;\n1;2;3";

        // then
        assertEquals(6, cal.add(text));
    }
    @Test(expected = RuntimeException.class)
    public void 문자열_계산기에_음수를_전달하는_경우_RuntimeException_예외_처리를_한다(){
        // given
        String text = "-1";

        // then
        assertEquals(0, cal.add(text));
    }

}