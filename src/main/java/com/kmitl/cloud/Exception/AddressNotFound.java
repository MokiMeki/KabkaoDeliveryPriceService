package com.kmitl.cloud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.kmitl.cloud.Constant.ADDRESS_NOT_FOUND_MSG;

/**
 * Created by snow_ on 04-Mar-17.
 */
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason = ADDRESS_NOT_FOUND_MSG)
public class AddressNotFound extends RuntimeException{

}
