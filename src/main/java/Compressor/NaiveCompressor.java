package Compressor;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NaiveCompressor implements Compressor {


    @Override
    public String compress(String text) {
        return Arrays.stream(text.split(" "))
                .map(x -> x.length() > 0 ? x.substring(0, 1).toUpperCase() + x.substring(1) : x)
                .collect(Collectors.joining());
    }

    @Override
    public String decompress(String text) {
        return Arrays.stream(text.split("(?=\\p{Lu})"))
                .map(x -> x.length() > 0 ? x.substring(0, 1).toLowerCase() + x.substring(1) : x)
                .collect(Collectors.joining(" "));
    }
}