package com.armatura.io;

public class ValvesMapedLocation {
    private static final String H329_H330 ="K-3 отм.9 СПРАВА ";
    private static final String H429_H430 ="K-4 отм.9 СПРАВА ";
    private static final String H327_H328 ="K-3 отм.9 СЛЕВА ";
    private static final String H427_H428 ="K-4 отм.9 СЛЕВА ";

    private static final String H326_H338_H339_H340_H341_H346 ="отм.9 Между АСВТ и РЩУ3";
    private static final String H426_H438_H439_H440_H441_H446 ="отм.9 Между БЩУ и РЩУ4";

    private static final String H332_336_H337 ="РЩУ-3 Сторона Турбины";
    private static final String H432_436_H437 ="РЩУ-4 Сторона Турбины";

    private static final String H344_325 ="РЩУ-3 Сторона Котла";
    private static final String H444 ="РЩУ-4 Сторона Котла";

    public static String insertPosition(String assembly){
        switch (assembly){
            case "329Н" :
            case "330Н" : return H329_H330;
            case "328Н" :
            case "327Н" : return H327_H328;
            case "326Н" :
            case "338Н" :
            case "339Н" :
            case "340Н" :
            case "341Н" :
            case "346Н" : return H326_H338_H339_H340_H341_H346;
            case "337Н" :
            case "332Н" :
            case "333Н" :
            case "334Н" :
            case "335Н" :
            case "336Н" : return H332_336_H337;
            case "344Н" :
            case "315Н" : return H344_325;
        }
        switch (assembly){
            case "429Н" :
            case "430Н" : return H429_H430;
            case "428Н" :
            case "427Н" : return H427_H428;
            case "426Н" :
            case "438Н" :
            case "439Н" :
            case "440Н" :
            case "441Н" :
            case "446Н" : return H426_H438_H439_H440_H441_H446;
            case "437Н" :
            case "432Н" :
            case "433Н" :
            case "434Н" :
            case "435Н" :
            case "436Н" : return H432_436_H437;
            case "444Н" : return H444;
        }
        return "NotFound";
    }

}
