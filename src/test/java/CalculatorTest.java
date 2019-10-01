import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator cal;

    @Before
    public void setUp(){
        cal = new Calculator();
    }

    @Test(expected = RuntimeException.class)
    public void 최종테스트(){
        //given
        String str1 = " ";
        String str2 = "1,2";
        String str3 = "1,2,3";
        String str4 = "1,2:3";
        String str5 = "//;\n1;2;3";
        String str6 = "//;\n1;2;-3";

        // when then
        assertEquals(0, cal.add(str1));
        assertEquals(3, cal.add(str2));
        assertEquals(6, cal.add(str3));
        assertEquals(6, cal.add(str4));
        assertEquals(6, cal.add(str5));
        assertEquals(6, cal.add(str6));
    }

    @Test
    public void 쉼표_콜론_구분자로_숫자를_분리한다(){
        //given
        String str1 = " ";
        String str2 = "1,2";
        String str3 = "1,2,3";
        String str4 = "1,2:3";

        // when/then
        assertArrayEquals(new String[]{}, cal.split(str1));
        assertArrayEquals(new String[]{"1", "2"}, cal.split(str2));
        assertArrayEquals(new String[]{"1","2", "3"}, cal.split(str3));
        assertArrayEquals(new String[]{"1", "2", "3"}, cal.split(str4));
    }

    @Test
    public void 문자배열을_숫자배열로_바꾼다(){
        // given
        String []  strings1 = new String[]{};
        String []  strings2 = new String[]{"1", "2"};
        String []  strings3 = new String[]{"1","2", "3"};
        String []  strings4 = new String[]{"1", "2", "3"};

        // when then
        assertArrayEquals(new int []{}, cal.parseInt(strings1));
        assertArrayEquals(new int []{1,2}, cal.parseInt(strings2));
        assertArrayEquals(new int []{1,2,3}, cal.parseInt(strings3));
        assertArrayEquals(new int []{1,2,3}, cal.parseInt(strings4));
    }

    @Test
    public void 숫자배열의_합을_반환한다(){
        //given
        int [] intArr1 = new int []{};
        int [] intArr2 = new int []{1,2};
        int [] intArr3 = new int []{1,2,3};
        int [] intArr4 = new int []{1,2,3};

        // when then
        assertEquals(0, cal.sum(intArr1));
        assertEquals(3, cal.sum(intArr2));
        assertEquals(6, cal.sum(intArr3));
        assertEquals(6, cal.sum(intArr4));

    }

    @Test
    public void 커스텀구분자를_지정할_수_있다(){
        //given
        String customDivider = ";";
        String str = "1,2;3:4";

        // when
        cal.setCustomDivider(customDivider);

        // then
        assertArrayEquals(new String[]{"1", "2", "3","4"}, cal.split(str));
    }

    @Test
    public void 커스텀구분자는_슬러시두개와_역슬러시엔_사이에_값으로_입력한다(){
        //given
        String customDivider = "//;\n1;2;3";

        //when then
        assertArrayEquals(new String[]{"1","2","3"}, cal.split(customDivider));

    }

    @Test(expected = RuntimeException.class)
    public void 음수가_입력되면_런타임에러_발생한다(){
        //given
        String minusStr = "1,2,-3";

        // when
        String [] strings = cal.split(minusStr);

        // then
        cal.parseInt(strings);
    }

}