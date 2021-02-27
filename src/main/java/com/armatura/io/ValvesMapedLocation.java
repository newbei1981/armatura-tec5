package com.armatura.io;

public class ValvesMapedLocation {
    private static final String H329_H330 ="K-3 отм.9 СПРАВА ";
    private static final String H429_H430 ="K-4 отм.9 СПРАВА ";
    private static final String H327_H328 ="K-3 отм.9 СЛЕВА ";
    private static final String H427_H428 ="K-4 отм.9 СЛЕВА ";
    private static final String H348 ="K-3 отм.0 СПРАВА ";

    private static final String H326_H338_H339_H340_H341_H346 ="отм.9 Между АСВТ и РЩУ3";
    private static final String H426_H438_H439_H440_H441_H446 ="отм.9 Между БЩУ и РЩУ4";

    private static final String H332_336_H337 ="РЩУ-3 Сторона Турбины";
    private static final String H432_436_H437 ="РЩУ-4 Сторона Турбины";

    private static final String H344_325 ="РЩУ-3 Сторона Котла";
    private static final String H444 ="РЩУ-4 Сторона Котла";

    public static String insertPosition(String assembly){
        switch (assembly){
            case "329Н" : return H329_H330;
            case "330Н" : return H329_H330;
            case "328Н" : return H327_H328;
            case "327Н" : return H327_H328;
            case "326Н" : return H326_H338_H339_H340_H341_H346;
            case "338Н" : return H326_H338_H339_H340_H341_H346;
            case "339Н" : return H326_H338_H339_H340_H341_H346;
            case "340Н" : return H326_H338_H339_H340_H341_H346;
            case "341Н" : return H326_H338_H339_H340_H341_H346;
            case "346Н" : return H326_H338_H339_H340_H341_H346;
            case "337Н" : return H332_336_H337;
            case "332Н" : return H332_336_H337;
            case "333Н" : return H332_336_H337;
            case "334Н" : return H332_336_H337;
            case "335Н" : return H332_336_H337;
            case "336Н" : return H332_336_H337;
            case "344Н" : return H344_325;
            case "315Н" : return H344_325;
        }
        return "NotFound";
    }

}
