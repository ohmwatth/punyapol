package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerReq(@NotBlank String name) {
	
}
