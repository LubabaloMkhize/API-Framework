package Common;

import org.json.simple.JSONObject;

public class PayloadBuilder {

    public static JSONObject createNewUserObject(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","Lubabalo");
        jsonObject.put("job","Tester");

        return jsonObject;
    }

    public static JSONObject updateUserObject(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","Lubabalo");
        jsonObject.put("job","Tester");
        jsonObject.put("surname","Mkhize");

        return jsonObject;
    }
}
