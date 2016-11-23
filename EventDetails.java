import java.io.Serializable;

/**
 * Created by jlanham3 on 10/4/2016.
 */
public class EventDetails implements Serializable{

    public long serialVersionId = 1L;

    private String url;
    private String quantity;
    private String size;

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setQuantity(String quant){
        quantity = quant;
    }

    public String getQuantity(){
        return quantity;
    }

    public void setSize(String siz){
        size = siz;
    }

    public String getSize(){
        return size;
    }
}
