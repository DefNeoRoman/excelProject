package stepik;

public class Unit4 {
    public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber that = (ComplexNumber) o;
            return im == that.getIm() && re == that.getRe();

        }

        @Override
        public int hashCode() {

         int prime = 31;
         int result =1;
         result = prime*result + Double.hashCode(re);
         result = prime*result + Double.hashCode(im);
         return result;
        }
    }
}
