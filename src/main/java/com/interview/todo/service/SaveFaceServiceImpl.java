package com.interview.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interview.todo.model.FaceInformation;
import com.interview.todo.repository.FaceRepository;

@Service
@Transactional
public class SaveFaceServiceImpl implements SaveFaceService {

	@Autowired
	FaceRepository faceRepo;

	@Override
	public FaceInformation addTodo(FaceInformation faceInformation) {
		return this.faceRepo.save(faceInformation);
	}

}
