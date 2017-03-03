package com.kmitl.cloud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by snow_ on 04-Mar-17.
 */
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason = "Couldn't find a route to your location.")
public class RouteNotFound extends RuntimeException{

}
