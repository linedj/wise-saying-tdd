package app.global;

import java.util.HashMap;
import java.util.Map;

public class Command {

    String actionName;

    Map<String, String> paramMap;

    public Command(String cmd) {

        paramMap = new HashMap<String, String>();

        String[] cmdBits = cmd.split("\\?"); //[삭제, id=1]
        actionName = cmdBits[0];

        if(cmdBits.length < 2) {
            return;
        }

        String queryString = cmdBits[1];
        String[] params = queryString.split("&");

        for(String param : params) {
            String[] paramBits = param.split("=", 2);

            if(paramBits.length < 2) {
                continue;
            }

            paramMap.put(paramBits[0], paramBits[1]);
        }
    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String Key) {
        return paramMap.get(Key);
    }

    public int getParamAsInt(String key) {
        try {
            String param = getParam(key);
            return Integer.parseInt(param);
        }catch(NumberFormatException e) {
            return 0;
        }
    }
}