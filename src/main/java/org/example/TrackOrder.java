package org.example;

public class TrackOrder {
    private Integer code;
    private Integer track;

    public TrackOrder(Integer code, Integer track) {
        this.code = code;
        this.track = track;
    }
    public TrackOrder(){}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }
}
