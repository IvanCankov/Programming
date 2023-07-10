package _2020_Basic.Lösung;

import java.util.NoSuchElementException;
import java.util.Objects;

// A painting color that is a mixture of at least two colors.
// 'Mixture' implements 'Paint'.
//
public class Mixture implements Paint {

    // Initializes this object.
    private Paint p1, p2;
    public Mixture(Paint p1, Paint p2) {
        this.p1=p1;
        this.p2=p2;
    }

    @Override
    public PaintIterator iterator() {
        PaintIterator p1Iter = p1.iterator();
        PaintIterator p2Iter = p2.iterator();
        return new PaintIterator() {
            @Override
            public boolean hasNext() {
                return p1Iter.hasNext() || p2Iter.hasNext();
            }

            @Override
            public Basic next() {
                if(!hasNext()) throw new NoSuchElementException();
                if(p1Iter.hasNext()) return p1Iter.next();
                else return p2Iter.next();
            }
        };
    }

    @Override
    public Paint mixWith(Paint paint) {
        return new Mixture(this, paint);
    }

    @Override
    public String toString() {
        String ret = "";
        for (Basic i:this) {
            ret+=i.toString()+"\n";
        }
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mixture basics = (Mixture) o;

        if (!Objects.equals(p1, basics.p1)) return false;
        return Objects.equals(p2, basics.p2);
    }

    @Override
    public int hashCode() {
        int result = p1 != null ? p1.hashCode() : 0;
        result = 31 * result + (p2 != null ? p2.hashCode() : 0);
        return result;
    }
}
