package com.sample.generator;

import com.sample.response.ErrorResponseDTO;
import com.sample.response.Response;
import com.sample.response.ResponseDTO;
import com.sample.response.SuccessResponseDTO;
import com.sample.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

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
        BindingResult bindingResult = response.bindingResult();
        if (bindingResult == null) {
            responseDTO = new SuccessResponseDTO.SuccessResponseBuilder<>()
                    .setData(response)
                    .setMessage((response.successMessage() != null) ? response.successMessage() : "").build();
        } else {
            if (!bindingResult.hasErrors()) {
                responseDTO = new SuccessResponseDTO.SuccessResponseBuilder<>()
                        .setData(response)
                        .setMessage((response.successMessage() != null) ? response.successMessage() : "").build();
            } else {
                responseDTO = new ErrorResponseDTO.ErrorResponseBuilder<>()
                        .setData(OBJECT)
                        .setMessage(messageUtil.getMessage(response.bindingResult().getAllErrors().get(0).getDefaultMessage())).build();
            }
        }
        return responseDTO;
    }
}
