package com.sample.response;

public interface ResponseDTO<T> {

    public Integer getCode();

    public T getData();

    public String getMessage();

    public Integer getStatus();

    public void setCode(Integer code);

    public void setData(T data);

    public void setMessage(String message);

    public void setStatus(Integer status);

    public abstract class ResponseBuilder<T> {

        private Integer code;
        private T data;
        private String message = null;
        private Integer status;
        private Response response;

        public Integer getCode() {
            return code;
        }

        public ResponseBuilder setCode(Integer code) {
            this.code = code;
            return this;
        }

        public T getData() {
            return data;
        }

        public ResponseBuilder setData(T data) {
            this.data = data;
            return this;
        }

        public String getMessage() {
            return message;
        }

        public ResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public ResponseBuilder setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Response getResponse() {
            return response;
        }

        public ResponseBuilder setResponse(Response response) {
            this.response = response;
            return this;
        }

        public abstract ResponseDTO<T> build();

    }

}