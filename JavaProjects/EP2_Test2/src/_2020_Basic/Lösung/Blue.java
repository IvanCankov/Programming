package _2020_Basic.Lösung;

import java.util.NoSuchElementException;

// A purely blue paint. It is one of the basic colors for mixing other paints.
// 'Blue' implements 'Basic'.
//
public class Blue implements Basic{

    @Override
    public PaintIterator iterator() {
        Basic sos = this;
        return new PaintIterator() {
            private boolean called;
            @Override
            public boolean hasNext() {
                return !called;
            }

            @Override
            public Basic next() {
                if(!hasNext()) throw new NoSuchElementException();
                called=true;
                return sos;
            }
        };
    }

    @Override
    public Paint mixWith(Paint paint) {
        return new Mixture(this,paint);
    }

    // only one instance is needed.
    public static final Blue BLUE = new Blue();

}
