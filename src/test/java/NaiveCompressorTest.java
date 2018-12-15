import Compressor.Compressor;
import Compressor.NaiveCompressor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NaiveCompressorTest {

    Compressor compr;

    @Before
    public void seyUp(){
         compr = new NaiveCompressor();
    }

    @Test
    public void TestNaivePositiveCompress(){
        assertEquals("AlaMaKota",compr.compress("Ala ma kota"));
    }
    @Test
    public void TesNativePositiveCompress(){
        assertEquals("A",compr.compress("A"));
    }
    @Test
    public void TestNaiveNegativeLengthCompress(){
        String actual = "Ala ma kota";
        String expected = compr.compress("Ala ma kota");
        assertFalse(expected.length() > actual.length());
    }
    @Test
    public void TestNaivePositiveLengthCompress(){
        String actual = "Ala ma kota";
        String expected = compr.compress("Ala ma kota");
        assertTrue(expected.length() < actual.length());
    }
                             //Decompess

    @Test
    public void TestNaiveNegativeLengthDecompress() {
        String expected = "Ala ma kota";
        String actual = compr.decompress("AlaMaKota");
        assertFalse(expected.length() > actual.length());
    }
    @Test
    public void TestNaivePositiveLengthDecompress() {
        String expected = "Ala ma kota";
        String actual = compr.decompress("AlaMaKota");
        assertTrue(expected.length() <= actual.length());
    }

}
