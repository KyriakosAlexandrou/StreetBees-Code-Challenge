
package com.alexandroukyriakos.streetbeescodechallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("limit")
    @Expose
    private String limit;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("results")
    @Expose
    private List<Comic> comics = new ArrayList<Comic>();

    /**
     * @return The offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset The offset
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * @return The limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * @param limit The limit
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    /**
     * @return The total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return The count
     */
    public String getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * @return The comics
     */
    public List<Comic> getComics() {
        return comics;
    }

    /**
     * @param comics The comics
     */
    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }

}
