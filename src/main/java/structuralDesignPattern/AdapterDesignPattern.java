package structuralDesignPattern;

public class AdapterDesignPattern {


    public static void main(String[] args) {
        IRestroApp app= new RestroApp();
        app.displayMenu(new XmlData());
        IRestroApp newUI= new FancyUIServiceAdapter();
        newUI.displayMenu(new XmlData());
    }
}
class XmlData{
    String data="display menu";
}
class JSONData{
    String data;
}
interface IRestroApp{
    void displayMenu(XmlData xmlData);
}
class RestroApp implements IRestroApp{  //old implemation

    @Override
    public void displayMenu(XmlData xmlData) {
        System.out.println(xmlData.data);
    }
}

class FancyUIService{
    public void displayMenu(JSONData jsonData){
        System.out.println(jsonData.data);
    }
}

class FancyUIServiceAdapter implements IRestroApp{ // using new fancy UI
    FancyUIService fancyUIService;
    public FancyUIServiceAdapter(){
        fancyUIService= new FancyUIService();
    }
    @Override
    public void displayMenu(XmlData xmlData) {
        JSONData jsonData= converXMltoJson(xmlData);
        fancyUIService.displayMenu(jsonData);
    }
   JSONData converXMltoJson(XmlData xmlData){
        JSONData data= new JSONData();
        data.data=xmlData.data;
        return data;
    }
}