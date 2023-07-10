package MobileTree_Vorbereitung_2023.Lösung;

public class StickBreaksException extends Exception{
    private String detailMessage;
    public StickBreaksException(String s){ detailMessage=s;
    }

    @Override
    public String getMessage() {
        return detailMessage;
    }
}
