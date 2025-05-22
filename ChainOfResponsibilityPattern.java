abstract class LeaveApprover {
    protected LeaveApprover nextApprover;
    public void setNextApprover(LeaveApprover next) {
        this.nextApprover = next;
    }
    public abstract void processLeaveRequest(int days);
}

class TeamLead extends LeaveApprover {
    public void processLeaveRequest(int days) {
        if (days <= 2) System.out.println("TeamLead approved " + days + " day(s) leave.");
        else if (nextApprover != null) nextApprover.processLeaveRequest(days);
    }
}

class Manager extends LeaveApprover {
    public void processLeaveRequest(int days) {
        if (days <= 5) System.out.println("Manager approved " + days + " day(s) leave.");
        else if (nextApprover != null) nextApprover.processLeaveRequest(days);
    }
}

class Director extends LeaveApprover {
    public void processLeaveRequest(int days) {
        System.out.println("Director approved " + days + " day(s) leave.");
    }
}

class ChainOfResponsibilityPatternDemo {
    public static void main(String[] args) {
        LeaveApprover lead = new TeamLead();
        LeaveApprover manager = new Manager();
        LeaveApprover director = new Director();
        lead.setNextApprover(manager);
        manager.setNextApprover(director);
        lead.processLeaveRequest(1);
        lead.processLeaveRequest(4);
        lead.processLeaveRequest(10);
    }
}