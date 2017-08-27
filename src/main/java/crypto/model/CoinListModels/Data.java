package crypto.model.CoinListModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Data {


    /**
     *
     * Calls for every coin that we will be doing need a POJO for each coin once we decide which ones we want.
     * The following will be in each coin POJO.
    String id;
    String url;
    String imageUrl;
    String name;
    String coinName;
    String fullName;
    String algorithm;
    String proofType;
    String sortOrder;
     */


}
