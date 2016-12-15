package com.sample.generator;

import com.sample.response.Response;
import com.sample.response.ResponseDTO;

import java.util.function.Supplier;

public interface Generator {

    ResponseDTO<Object> response(Supplier<Response> function);
}
