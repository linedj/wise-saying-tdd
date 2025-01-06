package app;

public class Command {

    String actionName;

    public Command(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];
    }

    public String getActionName(){
        return actionName;
    }
    //쪼개기 전문가

}
