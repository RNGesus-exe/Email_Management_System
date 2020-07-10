import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Mail {

    private User user;
    private ArrayList <MailBody> mails;
    private ArrayList <MailBody> sent;
    private ArrayList <MailBody> draft;

    public Mail() {
    }

    public ArrayList<MailBody> getMails() {
        return mails;
    }

    public int getIndexOfMail(MailBody mail) {
        for(int i=0;i<mails.size();i++)
        {
            if(mails.get(i).equals(mail))
            {
                return i;
            }
        }
        return -1;
    }


    public void setDraft(ArrayList<MailBody> draft) {
        this.draft = draft;
    }

    public User getUser() {
        return user;
    }

    public void setSent(ArrayList<MailBody> sent)
    {
        this.sent = sent;
    }

    public void setMails(ArrayList<MailBody> mails) {
        this.mails=mails;
    }

    public void setUser(User user){
        this.user=user;
    }

    public Mail(User user, ArrayList<MailBody> mails, ArrayList<MailBody> sent) {
        this.user = user;
        this.mails = mails;
        this.sent = sent;
    }

    public String checkMultipleUsers(String names) {
        StringTokenizer tokens = new StringTokenizer(names,",");
        while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();
            if(getId(token)==-1){
                return token;
            }
        }
        return null;
    }

    public void loadUserdata(int id) {
        Driver.dataAgent.loadUserDataFromDataBase(id);
    }

    public void updateUserdata(int id) {
        Driver.dataAgent.updateUserDataBase(id);
    }

    public int getId(String username) {
        return Driver.dataAgent.getId(username);
    }

    public int getId(String username,String password) {
        return Driver.dataAgent.getId(username,password);
    }

    public void setChildMail(int sender_id)
    {
        Driver.mail.setChildMail(sender_id);
    }

    public int getChildMail(int sender_id) {return Driver.mail.getChildMail(sender_id);}

    public ArrayList<MailBody> getBrotherMails(int id, Date dateTime) {
        ArrayList<MailBody> brotherMails = new ArrayList<MailBody>();
        for (MailBody mail : mails) {
            if (mail.getId() == id && mail.getDateTime() == dateTime) {
                brotherMails.add(mail);
            }
        }
        return brotherMails;
    }

    public int getAmountOfInboxMails() {
        return mails.size();
    }
    public int getAmountOfSentMails() {
        return sent.size();
    }
    public int getAmountOfDraftMails() {
        int count = 0;
        for (MailBody mailBody : mails) {
            if (mailBody.isDraft()) { count++; }
        } return count;
    }
    public int getAmountOfStarredMails() {
        int count = 0;
        for (MailBody mailBody : mails) {
            if (mailBody.isRecipient_starred()) { count++; }
        } return count;
    }
    public int getAmountOfTrashMails() {
        int count = 0;
        for (MailBody mailbody : mails) {
            if (mailbody.isTrash()) { count++; }
        } return count;
    }

    public ArrayList<MailBody> getSpam(){
        ArrayList<MailBody> spam = new ArrayList<>();
        for(MailBody mailbody: mails)
        {
            if(mailbody.isSpam())
            {
                spam.add(mailbody);
            }
        }return spam;
    }
    public ArrayList<MailBody> getInbox(){
        ArrayList<MailBody> inbox = new ArrayList<>();
        for(MailBody mailbody: mails)
        {
            if(!mailbody.isSpam() && (mailbody.getPermaTrash()!=getUser().getId()))
            {
                inbox.add(mailbody);
            }
        }return inbox;
    }
    public ArrayList<MailBody> getDraft() {
        return draft;
    }
    public ArrayList<MailBody> getStarred() {
        ArrayList<MailBody> starred = new ArrayList<MailBody>();
        for (MailBody mailbody: mails) {
            if (mailbody.isRecipient_starred()) {
                starred.add(mailbody);
            }
        }
        for (MailBody mailbody: sent) {
            if (mailbody.isSender_starred()) {
                starred.add(mailbody);
            }
        }

        return starred;
    }
    public ArrayList<MailBody> getTrash() {
        ArrayList<MailBody> trash = new ArrayList<MailBody>();
        for (MailBody mailbody: mails) {
            if (mailbody.isTrash()) { trash.add(mailbody); }
        } return trash;
    }
    public ArrayList<MailBody> getSent() {
        return sent;
    }
    public ArrayList<MailBody> getAllMails() {
        ArrayList<MailBody> allMails = new ArrayList<>();
        allMails.addAll(mails);
        allMails.addAll(sent);
        allMails.addAll(draft);
        ArrayList<Timestamp> timeStamps = new ArrayList<>();
        for (MailBody allMail : allMails) {
            timeStamps.add(allMail.getTimeStamp());
        }
        ArrayList<MailBody> temp = new ArrayList<>(); //Stores all correct order of all mails
        Collections.sort(timeStamps);  //Sorts the whole array according to the time stamps
        for (Timestamp timeStamp : timeStamps) {
            for (MailBody allMail : allMails) {
                if (allMail.getTimeStamp() == timeStamp) {
                    temp.add(allMail);
                }
            }
        }
        return temp;
    }


}