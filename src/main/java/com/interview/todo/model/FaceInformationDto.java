package com.interview.todo.model;

import lombok.ToString;

@ToString
public class FaceInformationDto {

	private String faceName;

	public String getFaceName() {
		return faceName;
	}

	public void setFaceName(String faceName) {
		this.faceName = faceName;
	}
}
