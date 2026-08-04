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

def String AddressID2(String input, MappingContext context){
     if(input!= "")
     {
         def array = input.split(",");
         if(array.size()== 3)
         {
         String output1 = array[2];
         return output1;
         }
       }
       else    
       {       
        return "";
       } 
}


def String BPIDTypeDUNS(String input1, String input2, MappingContext context){
       
    if(input1!= "" && input2!= "")
     {
         def array1 = input1.split(",");
         def array2 = input2.split(",");
         String output1 = array1[0];
         if(output1 == "BUP001")
         {  
             String output2 = array2[0];
             return output2;
         }
         else
         
             if(output1 == "CRM001" && array2.size() == 2)
             {  
                 String output2 = array2[1];
                 return output2;
             }
         
         else
         
             if(output1 == "CRM001" && array2.size() == 1)
             {  
                 String output2 = "";
                 return output2;
             }
         
         
     }
       else    
       {       
        return "";
       } 
}



