package MVC.model;

public class Contact {
    private int id;
    private String fullname;
    private String email;
    private String website;
    private String subject;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Contact() {
    }

    public Contact(int id, String fullname, String email, String website, String subject, String content) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.website = website;
        this.subject = subject;
        this.content = content;
    }
}
