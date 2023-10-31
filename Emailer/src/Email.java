import java.util.ArrayList;
import java.util.Arrays;

public class Email {
    private String subject;
    private String body;
    private boolean sent;
    private ArrayList<String> receptions;

    public Email(){
        this("","",false);
    }

    public Email(String sub, String bod,boolean sen) {
        setSubject(sub);
        setBody(bod);
        setSent(sen);
        //setReceptions(rec);
        receptions = new ArrayList<String>();

    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body = body;
    }
    public boolean getSent(){
        return sent;
    }
    public void setSent(boolean sent){
        this.sent = sent;
    }
    public void setReceptions(String rec){
        String [] emails = rec.split(",");
        for(String e:emails) {
            receptions.add(e);
        }
    }
    public String getReceptionsAsString(){
        String result="";
        for (String rec: receptions){
            result = result + rec + ",";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }
    public String getSendToString(){
        String send = "unsent";
        if(sent){
            send = "sent";
        }
        return send;
    }
    public void send(){
        sent = true;
    }
    @Override
    public String toString(){
        String recep = getReceptionsAsString();
        String s = getSendToString();
        return String.format("%-20s%s\n%-20s%s\n%-20s%s\n%s\n%s","To:",recep, "Subject:",subject,"Status:", s, "Body:",body);
    }
    public String fileFriendlyString(){
        String rec = getReceptionsAsString();
        String s = getSendToString();
        return String.format("%s\t%s\t%s\t%s",rec, subject, body,s);
    }



}
