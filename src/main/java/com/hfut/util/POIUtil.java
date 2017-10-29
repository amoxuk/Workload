package com.hfut.util;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;

@Component
public class POIUtil {

    public static String getStringCell(Cell cell) {
        String str = "";
        if (cell != null) {
            str = cell.getStringCellValue();
        }
        return str;
    }
    public static float getFloatCell(Cell cell) {
        float f = 0F;
        if (cell != null) {
            f = (float) cell.getNumericCellValue();
        }
        return f;
    }
    public static double getDoubleCell(Cell cell) {
        double d = 0;
        if (cell != null)
            d = cell.getNumericCellValue();
        return d;
    }
    public static int getIntCell(Cell cell) {
        int d = 0;
        if (cell != null)
            d = (int) cell.getNumericCellValue();
        return d;
    }
}