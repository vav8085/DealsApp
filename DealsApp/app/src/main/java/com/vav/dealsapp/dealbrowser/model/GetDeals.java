
package com.vav.dealsapp.dealbrowser.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDeals {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("data")
    @Expose
    private List<Deal> data = null;
    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Deal> getData() {
        return data;
    }

    public void setData(List<Deal> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
