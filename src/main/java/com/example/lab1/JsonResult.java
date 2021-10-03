package com.example.lab1;

public class JsonResult {
    private boolean success;
    private String url;
    private String message;

    public JsonResult(){

    }

    public JsonResult(boolean success, String url, String message){
        this.success = success;
        this.url = url;
        this.message = message;
    }
    public JsonResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
