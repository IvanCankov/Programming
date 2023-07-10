// An object with a method that returns a 'StarIterator'.
// Please, do not change this interface definition!
//
package MobileBT_Vorbereitung_2023.Lösung;
public interface StarIterable extends Iterable<Star> {

    // Returns an iterator over all 'Star' objects of the mobile.
    StarIterator iterator();
}
