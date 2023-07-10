// An Exception thrown by 'BalancedStick'
//
package MobileBT_Vorbereitung_2023.Angabe;
public class UnbalancedException extends Exception {

    //TODO: define missing parts of this class.

    private String msg;
    public UnbalancedException(String a){
        msg=a;
    }

    public String getMessage() {
        return msg;
    }


}
