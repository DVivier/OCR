package OCR.testunitaires.test;

import OCR.testunitaires.main.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public int multiply(int a, int b) {
        return 0;
    }

    @Override
    public int divide(int a, int b) {
        if (b==0){
            throw new ArithmeticException();
        }

        int res = 0;
        int total = 0;
        boolean negatif = false;
        if (a < 0) {
            negatif=true;
            a = -a;
        }
        if (b < 0) {
            negatif=!negatif;
            b = -b;
        }

        while (total < a) {
            total = add(total,b);
            res++;
        }
        if (negatif) {
            res= -res;
        }
        return res;
    }

    @Override
    public int add(int a, int b) {
        int res = a;
        if (b > 0) {
            while (b-- != 0) {
                res++;
            }
        } else if (b < 0) {
            while (b++ != 0) {
                res--;
            }
        }
        return res;
    }

    @Override
    public int substract(int a, int b) {
        return 0;
    }
}

