import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Test {
    private Main mainClass;

    @BeforeEach
    public void init(){ mainClass = new Main();}

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,5,6,7,4,8,9','8,9'",
            "'4,8,2,1,9','8,2,1,9'"
    })
    public void testFirst(String strInput, String strResult){
        String str[] = strInput.split(",");
        int[]arrInput = new int[str.length];
        String str2[] = strResult.split(",");
        int[]arrOut = new int[str2.length];
        for (int i = 0; i < str.length; i++) {
            arrInput[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < str2.length; i++) {
            arrOut[i] = Integer.parseInt(str2[i]);
        }
        System.out.println(strInput);
        System.out.println(strResult);
        Assertions.assertArrayEquals(arrOut,mainClass.arrayToReturn(arrInput));
    }

    @org.junit.jupiter.api.Test
    public void testFirstExeption(){
        final int[] arrInput = new int[]{2,3,5,6,7,8,9};
        Assertions.assertThrows(RuntimeException.class, ()->{mainClass.arrayToReturn(arrInput);});
    }

    @org.junit.jupiter.api.Test
    public void testSecond(){
        final int[] arrInput = new int[]{1,2,3,4,5,6,7,8,9};
        Assertions.assertTrue(mainClass.arrayToCheck(arrInput));
    }

    @org.junit.jupiter.api.Test
    public void testSecond2(){
        final int[] arrInput = new int[]{2,3,5,6,7,8,9};
        Assertions.assertFalse(mainClass.arrayToCheck(arrInput));
    }
}
