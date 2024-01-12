import com.sap.it.api.mapping.*;
import com.sap.gateway.ip.core.customdev.util.Message;
import groovy.xml.XmlUtil;
import groovy.util.XmlParser;

def Message processData(Message message) {
    String De = '01'
    String PropertyName = 'P_SemanaTrabalho'
    String PicklistName = 'SemanaTrabalho'

    def resultado = GetDePara( De,  PropertyName,  PicklistName, message)

    println resultado

    return message;
}


def String GetDePara(String De, String PropertyName, String PicklistName, Message message){

   String Para = '';
   def picklist= message.getProperty(PropertyName);

    // transforma a property em xml
    def xml_picklist = new XmlParser().parseText(picklist);
    //depara
    HashMap<String, String> depara = new HashMap<String, String>();    //create a new Hashmap object
    xml_picklist.PicklistOption.findAll { p ->
        p.picklistId[0].text().toString().equals(PicklistName)        //finding all salutation picklistid entities
    }.each { p ->
        depara.put((p.label[0].text().toString()),p.optionId[0].text().toString()) //put all value(label) key(optionId) pairs in Hashmap
    }


    if(De){
        def temp_variable = De.toString();    //get value of blood Group in UpperCase in temp_variable
        for (Map.Entry<String, String> entry : depara.entrySet()) {    //looping bloodGroup Hashmap to search corresponding value
               if(entry.getKey().equals(temp_variable)){        //Finding value of temp_variable in corresponding hashmap
                   def lv_val = entry.getValue().toString();        //access and store corresponding key in lv_val variable
                   Para = lv_val;    //replace value of particular xml element with unique key
               }
            }
    }

    return Para
}

def String GetDePara_ext_opId(String De, String PropertyName, String PicklistName,Message  message){

    println '2'
   String Para = '';
   def picklist= message.getProperty(PropertyName);


    // transforma a property em xml
    def xml_picklist = new XmlParser().parseText(picklist);

    //depara
    HashMap<String, String> depara = new HashMap<String, String>();    //create a new Hashmap object
    xml_picklist.PicklistOption.findAll { p ->
        p.picklistId[0].text().toString().equals(PicklistName)        //finding all salutation picklistid entities
    }.each { p ->
        depara.put((p.externalCode[0].text().toString()),p.optionId[0].text().toString()) //put all value(externalCode) key(optionId) pairs in Hashmap
    }


    if(De){
        def temp_variable = De.toString();    //get value of blood Group in UpperCase in temp_variable
        for (Map.Entry<String, String> entry : depara.entrySet()) {    //looping bloodGroup Hashmap to search corresponding value
               if(entry.getKey().equals(temp_variable)){        //Finding value of temp_variable in corresponding hashmap
                   def lv_val = entry.getValue().toString();        //access and store corresponding key in lv_val variable
                   Para = lv_val;    //replace value of particular xml element with unique key
               }
            }
    }

    return Para
}

def String GetDePara_lab_ext(String De, String PropertyName, String PicklistName, Message message){

    println '3'
   String Para = '';
   def picklist= message.getProperty(PropertyName);


    // transforma a property em xml
    def xml_picklist = new XmlParser().parseText(picklist);

    //depara
    HashMap<String, String> depara = new HashMap<String, String>();    //create a new Hashmap object
    xml_picklist.PicklistOption.findAll { p ->
        p.picklistId[0].text().toString().equals(PicklistName)        //finding all salutation picklistid entities
    }.each { p ->
        depara.put((p.label[0].text().toString()),p.externalCode[0].text().toString()) //put all value(externalCode) key(optionId) pairs in Hashmap
    }


    if(De){
        def temp_variable = De.toString();    //get value of blood Group in UpperCase in temp_variable
        for (Map.Entry<String, String> entry : depara.entrySet()) {    //looping bloodGroup Hashmap to search corresponding value
               if(entry.getKey().equals(temp_variable)){        //Finding value of temp_variable in corresponding hashmap
                   def lv_val = entry.getValue().toString();        //access and store corresponding key in lv_val variable
                   Para = lv_val;    //replace value of particular xml element with unique key
               }
            }
    }

    return Para
}

