import com.pl.sms_compressor.Compressors.OptimalCompressor;import com.pl.sms_compressor.Paginator.Smaz;import org.junit.Before;import org.junit.Test;import static org.junit.Assert.assertEquals;import static org.junit.Assert.assertTrue;/** * @author icedrake */public class OptimalCompressorTest {    private Smaz smaz = new Smaz();    OptimalCompressor optimalCompressor;    @Before    public void setUp() {        optimalCompressor = new OptimalCompressor();    }    @Test    public void simpleTest() {        String testString = "this is a simple test";        String compressed = optimalCompressor.compress(testString);        String uncompressedString = optimalCompressor.decompress(compressed);        assertEquals(testString, uncompressedString);    }    @Test(expected = IllegalArgumentException.class)    public void asciiOnlyTest() {        String testString = "this is a utf-8 string ÿ";        String actual = optimalCompressor.compress(testString);        assertTrue(testString.length() <= actual.length());    }    @Test    public void originalSmazCTest() {        String[] strings = {                "This is a small string",                "foobar",                "the end",                "not-a-g00d-Exampl333",                "com.pl.sms_compressor.Paginator.Smaz is a simple compression library",                "1000 numbers 2000 will 10 20 30 compress very little",                "and now a few italian sentences:",                "Nel mezzo del cammin di nostra vita, mi ritrovai in una selva oscura",                "Mi illumino di immenso",                "try it against urls",                "http://google.com",                "http://programming.reddit.com",                "http://github.com/antirez/smaz/tree/master"        };        String expectedOutput = "'This is a small string' compressed by 50%\n" +                "'foobar' compressed by 34%\n" +                "'the end' compressed by 58%\n" +                "'not-a-g00d-Exampl333' enlarged by 15%\n" +                "'com.pl.sms_compressor.Paginator.Smaz is a simple compression library' compressed by 39%\n" +                "'1000 numbers 2000 will 10 20 30 compress very little' compressed by 10%\n" +                "'and now a few italian sentences:' compressed by 41%\n" +                "'Nel mezzo del cammin di nostra vita, mi ritrovai in una selva oscura' compressed by 33%\n" +                "'Mi illumino di immenso' compressed by 37%\n" +                "'try it against urls' compressed by 37%\n" +                "'http://google.com' compressed by 59%\n" +                "'http://programming.reddit.com' compressed by 52%\n" +                "'http://github.com/antirez/smaz/tree/master' compressed by 46%\n";        StringBuilder output = new StringBuilder();        for (String str : strings) {            byte[] origBytes = str.getBytes();            System.out.println(str);            byte[] compressedBytes = smaz.compress(str);            int comprlevel = 100 - ((100 * compressedBytes.length) / origBytes.length);            if (comprlevel < 0) {                output.append(String.format("'%s' enlarged by %d%%\n", str, -comprlevel));            } else {                output.append(String.format("'%s' compressed by %d%%\n", str, comprlevel));            }        }        assertEquals(expectedOutput, output.toString());    }    @Test    public void TestOptimalCompressor() {        OptimalCompressor optimalCompressor = new OptimalCompressor();        Smaz smaz = new Smaz();        String actual = "Ala ma kota";        byte[] b = smaz.compress(actual);        System.out.println(b.length);        String expected = optimalCompressor.compress(actual);        assertTrue(expected.length() < actual.length());    }}