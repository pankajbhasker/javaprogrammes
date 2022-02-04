public class WhichWillCall {

  public static void main(String args[]){
    WhichWillCall obj  =  new WhichWillCall();
    obj.callmethod(null); // Compile time exeption  reference to callmethod is ambiguous

  }
  
  void callmethod(Integer a){
    System.out.println("Integer");
  }

  void callmethod(String a){
    System.out.println("String");

  }
  void callmethod(StringBuffer a){
    System.out.println("StringBuffer");
  }

  void callmethod(StringBuilder a){
    System.out.println("StringBuilder");
  }

}

