package minesweeper.numberDisplay.formatter;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Created by snyder on 2015-07-14.
 */
    public class NumberDisplayDigitFormatter extends NumberFormat {
        @Override
        public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
            throw new IllegalStateException("Does not support formatting decimal numbers");
        }

        @Override
        public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
            String format = "000" + Math.abs(number);
            format = format.substring(format.length()-3);
            toAppendTo.append(format);
            if(number < 0)
                toAppendTo.setCharAt(0, '-');

            return toAppendTo;
        }

        @Override
        public Number parse(String source, ParsePosition parsePosition) {
            throw new IllegalStateException("Does not support parsing numbers");
        }
    }
