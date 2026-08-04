import com.sap.gateway.ip.core.customdev.util.Message;
import org.apache.http.StatusLine;
import org.apache.olingo.client.api.communication.ODataClientErrorException;
import org.apache.olingo.commons.api.ex.ODataError;

def Message processData(Message message) {
    def ex = message.getProperty("CamelExceptionCaught");
    if (ex!=null) {
   
            def odataException = ex.getCause().getCause().getCause().getMessage();
            if (ex.getCause().getCause().getCause().getClass().getCanonicalName().equals("org.apache.olingo.odata2.core.ep.EntityProviderProducerException"))
            {
                
                def errBody = odataException.toString();
                message.setProperty("errMsg",errBody);
               throw new Exception(errBody);
            }

    }
    return message;
}