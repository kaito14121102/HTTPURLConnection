package com.example.minh.httpurlconnection;

/**
 * Created by Minh on 8/11/2018.
 */

public class KhoaHoc {
    private String noihoc;
    private String monhoc;

    public KhoaHoc(String noihoc, String monhoc) {
        this.noihoc = noihoc;
        this.monhoc = monhoc;
    }

    public KhoaHoc() {
    }

    public String getNoihoc() {
        return noihoc;
    }

    public void setNoihoc(String noihoc) {
        this.noihoc = noihoc;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }
}
