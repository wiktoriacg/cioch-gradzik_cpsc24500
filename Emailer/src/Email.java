import java.util.ArrayList;

public class Email {
    private String subject;
    private String body;
    private boolean status;
    private ArrayList<String> receptions;
    //its create default constructor
    public Email(){
        this("","",false,"");
    }
    //its creates constructor
    public Email(String sub, String bod,boolean sen, String rec) {
        setSubject(sub);
        setBody(bod);
        setSent(sen);
        receptions = new ArrayList<String>();
        setReceptions(rec);

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
        return status;
    }
    public void setSent(boolean status){
        this.status = status;
    }
    public void setReceptions(String rec){
        String [] emails = rec.split(" ");
        for(String e:emails) {
            receptions.add(e);
        }
    }

    /**
     * It is changing the receptions ArrayList to String
     * @return result-String witch contain all receptions separated by coma
     */
    public String getReceptionsAsString(){
        String result="";
        for (String rec: receptions){
            result = result + rec + ",";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }

    /**
     * It is changing status from boolean to string
     * @return send - String which contains proper send status
     */
    public String getSendToString(){
        String send = "not sent";
        if(status){
            send = "sent";
        }
        return send;
    }

    /**
     * It is changing sent to true
     */
    public void send(){
        status = true;
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
