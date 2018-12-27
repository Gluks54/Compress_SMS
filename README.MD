Java 8. Kompresja sms-ow.

Program, ktory zmniejszy tresc sms-a naiwnie i optymalnie.
Naiwna metoda polega na usunieciu spacji i rozpoczeciu slowa od wielkiej litery np. “Ala ma kota” -> “AlaMaKota”. 

Zaawansowana metoda wykorzysta biblioteke jsmaz.

Program ma wczytac tekst ze standardowego wejscia (konsoli) lub z pliku i przeksztalcic go na krotszy uzywajac jednej z metod.
Dodatkowo powinien dzielic wynikowy tekst na fragmenty o dlugosci pojedynczego sms-a (160 znakow) i obliczac koszt wyslanej wiadomosci.
Kolejna dodatkowa funkcja jest dekodowanie zakodowanego tekstu
