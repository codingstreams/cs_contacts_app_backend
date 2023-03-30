package com.codingstreams.contactsapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "LABEL_NOT_FOUND")
public class LabelNotFoundException extends Exception {

}
