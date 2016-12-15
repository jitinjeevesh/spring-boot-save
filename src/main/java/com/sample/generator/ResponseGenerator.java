package com.sample.generator;

import com.sample.response.ErrorResponseDTO;
import com.sample.response.Response;
import com.sample.response.ResponseDTO;
import com.sample.response.SuccessResponseDTO;
import com.sample.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public abstract class ResponseGenerator implements Generator {

    static final ErrorObject OBJECT = new ErrorObject();
    @Autowired
    private MessageUtil messageUtil;

    @SuppressWarnings("unchecked")
    public ResponseDTO<Object> response(Supplier<Response> supplier) {
        ResponseDTO<Object> responseDTO = null;
        Response response = supplier.get();
        if (!response.bindingResult().hasErrors()) {
            responseDTO = (ResponseDTO<Object>) new SuccessResponseDTO.SuccessResponseBuilder<>()
                    .setData(response)
                    .setMessage((response.successMessage() != null) ? response.successMessage() : "");
        } else {
            responseDTO = (ResponseDTO<Object>) new ErrorResponseDTO.ErrorResponseBuilder<>()
                    .setData(OBJECT)
                    .setMessage(messageUtil.getMessage(response.bindingResult().getAllErrors().get(0).getDefaultMessage()));
        }
        return responseDTO;
    }
}
