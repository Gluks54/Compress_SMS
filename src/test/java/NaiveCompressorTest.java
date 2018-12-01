import Compressor.Compressor;
import Compressor.NaiveCompressor;
import org.junit.Test;
import static org.junit.Assert.*;

public class NaiveCompressorTest {

    @Test
    public void NaivePositiveTest(){
        Compressor compr = new NaiveCompressor();
        assertEquals("AlaMaKota",compr.compress("Ala ma kota"));
    }
}
