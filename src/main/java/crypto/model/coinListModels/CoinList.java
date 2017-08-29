package crypto.model.coinListModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CoinList {

    String response;
    String Message;
    String baseImageUrl;
    String baseLinkUrl;
    Data data;
    int type;

}
