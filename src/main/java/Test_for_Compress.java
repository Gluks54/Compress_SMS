import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Test_for_Compress {
    public static void main(String[] args) {


        // Encode a String into bytes
        String inputString = "blahblahblah";
        byte[] input = new byte[0];
        try {
            input = inputString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Compress the bytes
        byte[] output = new byte[100];
        Deflater compresser = new Deflater();
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output);
        compresser.end();

        // Decompress the bytes
        Inflater decompresser = new Inflater();
        decompresser.setInput(output, 0, compressedDataLength);
        byte[] result = new byte[100];
        int resultLength = 0;
        try {
            resultLength = decompresser.inflate(result);
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        decompresser.end();

        // Decode the bytes into a String
        try {
            String outputString = new String(result, 0, resultLength, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
