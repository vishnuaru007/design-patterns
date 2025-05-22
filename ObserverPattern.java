interface Observer {
    void update(String mail);
}

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

class Postman implements Subject {
    private List<Observer> recipients = new ArrayList<>();
    private String latestMail;

    public void attach(Observer o) {
        recipients.add(o);
    }

    public void detach(Observer o) {
        recipients.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : recipients) {
            o.update(latestMail);
        }
    }

    public void deliverMail(String mail) {
        this.latestMail = mail;
        notifyObservers();
    }
}

class Recipient implements Observer {
    private String name;
    public Recipient(String name) {
        this.name = name;
    }
    public void update(String mail) {
        System.out.println(name + " received mail: " + mail);
    }
}

class ObserverPatternDemo {
    public static void main(String[] args) {
        Postman postman = new Postman();
        Recipient r1 = new Recipient("Alice");
        Recipient r2 = new Recipient("Bob");
        postman.attach(r1);
        postman.attach(r2);
        postman.deliverMail("Your Amazon package has arrived.");
        postman.deliverMail("You got a letter from your friend.");
    }
}