    import com.sap.it.api.mapping.*;

/*Add MappingContext parameter to read or set headers and properties
def String customFunc1(String P1,String P2,MappingContext context) {
         String value1 = context.getHeader(P1);
         String value2 = context.getProperty(P2);
         return value1+value2;
}

Add Output parameter to assign the output value.
def void custFunc2(String[] is,String[] ps, Output output, MappingContext context) {
        String value1 = context.getHeader(is[0]);
        String value2 = context.getProperty(ps[0]);
        output.addValue(value1);
        output.addValue(value2);
}*/

def void singlePay(String[] compCode, String[] bankCountry, String[] payAlone, Output output, MappingContext context){
        def flag = 0;
        def match;
         for(int i=0; i<compCode.size(); i++)
        {
         for(int j=0; j<bankCountry.size(); j++)
         {
             if(compCode[i] == bankCountry[j]){
                 flag = 1;
                 match = j;
             }
         }
         if(flag == 1){
             output.addValue(payAlone[match]);
             flag = 0;
         }
         else{
             output.addValue("No");
         }
        }
}

def String trimSpace( String arg){
    int x = arg.length();
    if(arg != "" && x > 1 && arg.substring(x-1,x) == " "){
            return arg.substring(0,x-1)
    }
    else{
     return ""
    }
}

def void truncateName(String[] input, Output output1, MappingContext context){
    String[] str;
    int len;
    int y;
    str = input[0].split(" ");
    String n="", Name1="", Name2="";

    if (input[0].length() == 0)
    {
            output1.addValue("");
            output2.addValue("");
    }
    else if(input[0].length() > 0)
    {
    for(int x=0; x<str.size(); x++){
        n = n + str[x] + " ";
        len = n.length();
        
        if(len <= 40 && len > 1)
        {
            Name1 = Name1 + str[x] + " ";
        }
    }
    output1.addValue(Name1);
    }
}

def void splitName(String[] input, Output output1, Output output2, MappingContext context){
    String[] str;
    int len;
    int y;
    str = input[0].split(" ");
    String n="", Name1="", Name2="";

    if (input[0].length() == 0)
    {
            output1.addValue("");
            output2.addValue("");
    }
    else if(input[0].length() > 0)
    {
    for(int x=0; x<str.size(); x++){
        n = n + str[x] + " ";
        len = n.length();
        
        if(len <= 35 && len > 1)
        {
            Name1 = Name1 + str[x] + " ";
        }
        
        else if(len > 35 && len <= 70){ 
            def cal = Name2.length() + str[x].length() +1;
            if(cal < 35){
              Name2 = Name2 + str[x] + " ";
            }
            }
		/*	y = Name1.length();
			def z = input[0].length() >= 70?70:input[0].length();
			Name2 = input[0].substring(y,z);*/
      
           
    }
    output1.addValue(Name1);
    output2.addValue(Name2);
    }
}



def void bankenddate(String[] endDate, Output output, MappingContext context){
        
        for(int i=1; i<endDate.size(); i++){
            output.addValue(endDate[i]);
        }
        
}
    
def void siteNewCompCode(String[] compCode, String[] aravocompCode, Output output, MappingContext context){
        def s4code = compCode[0].split(",");
        /*def s4codesplit = s4code.findAll{it.startsWith("US")};
        def aravoCode = aravocompCode.findAll{it.startsWith("US")};*/
        
        def newCodes = (aravocompCode - s4code);
        for (int i=0; i< newCodes.size(); i++)
        {
            output.addValue(newCodes[i]);
        }
}

def void copycompCode(String[] WHTax, String[] compCode, Output output, MappingContext context){
        def value1 = WHTax[0].split(",");
       
         for(int i=0; i<compCode.size(); i++)
        {
         for(int j=0; j<value1.size(); j++)
         {
             output.addValue(compCode[i]);
         }
        }
        
}
    
def void combineWHTax(String[] WHTax, String[]compCode, Output output, MappingContext context){
        def value1 = WHTax[0].split(",");
       for(int i=0; i<compCode.size(); i++)
        {
         for(int j=0; j<value1.size(); j++)
         {
             output.addValue(value1[j]);
         }
         output.addContextChange();
        }
}


def void newCompCode(String[] compCode, String[] aravocompCode, Output output, MappingContext context){
        def s4code = compCode[0].split(",");
        def s4codesplit = s4code.findAll{it.startsWith("US")};
        def aravoCode = aravocompCode.findAll{it.startsWith("US")};
        
        def newCodes = (aravoCode - s4codesplit);
        for (int i=0; i< newCodes.size(); i++)
        {
            output.addValue(newCodes[i]);
        }
}

def void compareCompCode(String[] taxType, String[] compCode, String[] aravocompCode, Output output, MappingContext context){
        def s4code = compCode[0].split(",");
        def s4codesplit = s4code.findAll{it.startsWith("US")};
        def aravoCode = aravocompCode.findAll{it.startsWith("US")};
        
        def newCodes = (aravoCode - s4codesplit);
        for (int i=0; i< newCodes.size(); i++)
        {
            output.addValue(taxType[0]);
        }
}

def void getcompCode(String[] input, Output output, MappingContext context){
        def value1 = input[0].split(",");
        def value2 = value1.findAll{it.startsWith("US")};
       for(int i=0; i<value2.size(); i++)
        {
            output.addValue(value2[i]);
        }
}

def String getProperty(String arg1,MappingContext context){
    String arg2 = context.getProperty(arg1);
    arg1 = arg2;
	return arg1 
}

def String AddressID1(String input, MappingContext context){
     if(input!= "")
     {
         def array = input.split(",");
         def sort = array.sort();
         String output1 = sort[0];
         return output1;
       }
       else    
       {       
        return "";
       } 
    }

def String AddressID2(String input, MappingContext context){
     if(input!= "")
     {
         def array = input.split(",");
         def sort = array.sort();
         if(sort.size()== 3)
         {
         String output1 = sort[2];
         return output1;
         }
         else    
       {       
        return "";
       } 
       }
       else    
       {       
        return "";
       } 
    }
    
def String AddressCompare(String input, MappingContext context){
     if(input!= "")
     {
         def array = input.split(",");
         def sort = array.sort();
         if(sort.size() == 3)
         {
         String output1 = sort[0];
         String output2 = sort[2];
            if(output1 == output2)
            {
                return output1;
            }
            else    
            {       
                return "";
            } 
         
         }
         else    
           {       
            return "";
           } 
       }
       else    
       {       
        return "";
       } 
    }    
    
def String Ordnum1(String input, MappingContext context){
     if(input!= "" && input!= ",")
     {
         def array = input.split(",");
         String output1 = array[0];
         return output1; 
       }
       else    
       {       
        return "";
       } 
    }
    
def String Ordnum2(String input, MappingContext context){
     if(input!= "" && input!= ",")
     {
         def array = input.split(",");
         if(array.size() == 2){
         return array[1];
         }
         else    
       {       
        return "";
       } 
     }
       else    
       {       
        return "";
       } 
    }
    
/*def String multiTax1(String input, MappingContext context){
     if(input!= "")
        {
         def array = input.split(",");
         String output = array[0];
         return output;
         }
         else    
       {       
        return "";
       } 
    }*/
    
def String multiTax1(String input, MappingContext context) {
    if (input!= "") {
        // Split the input string by commas
        def array = input.split(",")
        // Sort the array
        def sortedArray = array.sort()
        // Take the first element of the sorted array
        String output = sortedArray[0]
        return output
    } else {
        return ""
    }
}

def String multiTax2(String input, MappingContext context){
     if(input!= "")
        {
         def array1 = input.split(",");
         def array = array1.sort()
         if(array.size() > 1)
         {
         String output = array[1];
         return output;
         }
         else    
       {       
        return "";
       }
     }
       else    
       {       
        return "";
       } 
    }

def void substringBankAcc(String[] input, Output output, MappingContext context)
    {
        for(int i=0; i<input.size(); i++)
        {
         def len = input[i].length();
         def array = input[i].substring(18,len);
         output.addValue(array);
        }
    }
    
def void bankKeyValidator(String[] bankKey, String[] bankKeyProperty, Output output, MappingContext context) {
    if (bankKey.length > 0) {
        String[] list = bankKeyProperty[0].split(",");
        Set<String> existingBanks = new HashSet<>(Arrays.asList(list)); 

        boolean allExisting = true; // Flag to track if all bank keys exist in the target
        
        for (String key : bankKey) {
            if (!existingBanks.contains(key)) { 
                allExisting = false;
                break;
            }
        }

        if (allExisting) {
            output.addValue("PATCH");
        } else {
            output.addValue("POST");
        }
    } else {
        output.addValue("");
    }
}

def void compCodeValidator(String[] compCode, String[] compCodeProperty, Output output, MappingContext context)
{
    String[] list = compCodeProperty[0].split(",");
    String code = compCode[0];
    
    def flag = 0
    
    if (list.length > 0){
        for (int j = 0; j < list.length; j++){
            if(code == list[j]){
                flag = 1
                break;
            }
            
        }
        
    }
    if(flag == 1){
            output.addValue("PATCH");
    }
    else if(flag == 0){
            output.addValue("POST");  
    }
}

def String convertTaxNum(String arg1){
    if (arg1 != ""){
    	return arg1.substring(2)
}
}

def String Identification(String input1, String input2,String input3, MappingContext context) {
    if (input1 && input2) {
        // Split the inputs by commas to create arrays
        def array1 = input1.split(",")
        def array2 = input2.split(",")
        
        // Ensure both arrays have the same length
        if (array1.size() == array2.size()) {
            // Iterate through array1 to check for "ISPAYN"
            for (int i = 0; i < array1.size(); i++) {
                if (array1[i].trim() == input3) {
                    // Return the corresponding value from array2
                    return array2[i].trim()
                }
            }
        }
    }
    // Return blank string if "ISPAYN" is not found or arrays are of different lengths
    return ""
}