import java.sql.Date;
import java.sql.Timestamp;

public class MailBody {

//------------------------------------------DATA MEMBERS-----------------------------------------------------------

    private int id;
    private String recipient;
    private String sender;
    private String text;
    private String subject;
    private Date dateTime;
    private Timestamp timeStamp;
    private boolean recipient_starred;
    private boolean sender_starred;
    private boolean trash;
    private boolean unread;
    private boolean draft;
    private boolean spam;
    private int child_mail;
    private int permaTrash;
    private int draft_user;
    private String multiple_recipients;

//-------------------------------------------CONSTRUCTORS----------------------------------------------------------------

    public MailBody() { this.sender_starred = this.recipient_starred = this.trash = this.unread = this.draft = this.spam = false; }

    public MailBody (String recipient, String sender, String text, String subject, boolean recipient_starred,boolean sender_starred, boolean trash,boolean unread, boolean draft, boolean spam,int child_mail,int permaTrash) {
        this.recipient = recipient;
        this.sender = sender;
        this.text = text;
        this.subject = subject;
        this.recipient_starred = recipient_starred;
        this.sender_starred = sender_starred;
        this.trash = trash;
        this.unread = unread;
        this.draft = draft;
        this.spam = spam;
        this.child_mail=child_mail;
        this.permaTrash=permaTrash;
    }

//--------------------------------------------SETTERS/GETTERS------------------------------------------------------

    public void changeRecipientStarred() {
        if(isRecipient_starred())
        {
            setRecipient_starred(false);
        }
        else
        {
            setRecipient_starred(true);
        }
    }

    public void changeSenderStarred() {
        if(isSender_starred())
        {
            setSender_starred(false);
        }
        else
        {
            setSender_starred(true);
        }
    }


    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getDraft_user() {
        return draft_user;
    }
    public void setDraft_user(int draft_user) {
        this.draft_user = draft_user;
    }

    public String getMultiple_recipients() {
        return multiple_recipients;
    }
    public void setMultiple_recipients(String multiple_recipients) {
        this.multiple_recipients = multiple_recipients;
    }

    public boolean isRecipient_starred() {
        return recipient_starred;
    }
    public void setRecipient_starred(boolean recipient_starred) {
        this.recipient_starred = recipient_starred;
    }

    public boolean isSender_starred() {
        return sender_starred;
    }
    public void setSender_starred(boolean sender_starred) {
        this.sender_starred = sender_starred;
    }

    public int getPermaTrash() {
        return permaTrash;
    }
    public void setPermaTrash(int permaTrash) {
        this.permaTrash = permaTrash;
    }

    public int getChild_mail() {
        return child_mail;
    }
    public void setChild_mail(int child_mail) {
        this.child_mail = child_mail;
    }

    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSpam() {
        return spam;
    }
    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public boolean isDraft() {
        return draft;
    }
    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isUnread() {
        return unread;
    }
    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isTrash() {
        return trash;
    }
    public void setTrash(boolean trash) {
        this.trash = trash;
    }
}