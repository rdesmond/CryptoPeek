package crypto.model.historicalModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by daniel on 23.08.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoHour {

    String response;
    int type;
    boolean aggregated;
    Data[] data;
    int timeTo;
    int timeFrom;
    boolean firstValueInArray;
    ConversionType conversionType;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAggregated() {
        return aggregated;
    }

    public void setAggregated(boolean aggregated) {
        this.aggregated = aggregated;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(int timeTo) {
        this.timeTo = timeTo;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }

    public boolean isFirstValueInArray() {
        return firstValueInArray;
    }

    public void setFirstValueInArray(boolean firstValueInArray) {
        this.firstValueInArray = firstValueInArray;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }
}
