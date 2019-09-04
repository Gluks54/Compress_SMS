package com.pl.sms_compressor.Compressors;

public interface Compressor {
    String compress(String text);

    String decompress(String text);
}
