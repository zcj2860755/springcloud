package com.zdzc.baseModel;

public class FeignException {

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 状态码
     */
    private String status;

    /**
     * 错误内容
     */
    private String error;

    /**
     * 错误类型
     */
    private String trace;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 请求路径
     */
    private String path;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace.split(":")[0];
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
