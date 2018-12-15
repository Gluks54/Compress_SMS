import Compressor.Compressor;

import java.nio.charset.StandardCharsets;

public class OptimalCompressor implements Compressor {
    Smaz smaz = new Smaz();
    @Override
    public String compress(String text) {
        byte[] compressed = smaz.compress(text);
        return new String(compressed,StandardCharsets.ISO_8859_1);
    }

    @Override
    public String decompress(String text) {
        byte[] temp = text.getBytes(StandardCharsets.ISO_8859_1);
        String uncompressedString = smaz.decompress(temp);
        return uncompressedString;
    }
}
