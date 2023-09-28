package org.microtrack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseTrace {

    private int statusCode;
    private String message;

}
