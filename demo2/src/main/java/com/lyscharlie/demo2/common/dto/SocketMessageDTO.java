package com.lyscharlie.demo2.common.dto;

import lombok.Data;

@Data
public class SocketMessageDTO {

	private String from;

	private String to;

	private String content;
}
