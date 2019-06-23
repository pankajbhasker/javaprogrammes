public class LimitObjects {

    private static LimitObjects limitObjects;
    public static int objCount = 0; // Max object can have 5 only

    private LimitObjects(){
        objCount++;
    }

    public static synchronized LimitObjects getInstance(){
        if(objCount < 5 ){
            limitObjects = new LimitObjects();
        }
        else
        {
        limitObjects = null;
        }
        return limitObjects;
    }
}

public class LimitObjectCreation {

    public static void main(String[] args) {

        LimitObjects obj1 = LimitObjects.getInstance();
        LimitObjects obj2 = LimitObjects.getInstance();
        LimitObjects obj3 = LimitObjects.getInstance();
        LimitObjects obj4 = LimitObjects.getInstance();
        LimitObjects obj5 = LimitObjects.getInstance();
        LimitObjects obj6 = LimitObjects.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        System.out.println(obj4);
        System.out.println(obj5);
        System.out.println(obj6);
      }
}
