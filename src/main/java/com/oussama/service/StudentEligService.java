package com.oussama.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oussama.registrationeligibility.ObjectFactory;
import com.oussama.registrationeligibility.StudentRequest;
import com.oussama.registrationeligibility.WsResponse;

@Service
public class StudentEligService {
public WsResponse checkEligibility(StudentRequest studentRequest) {
	WsResponse response= new ObjectFactory().createWsResponse();
	List<String> mismatch=response.getCriteriaMismatch();
	
	if(studentRequest.getAge()>=30 || studentRequest.getAge()<=18)
	mismatch.add("Student age must be between 18 and 30 !");
	
	if(studentRequest.getGraduationScore()<13)
	mismatch.add("Student graduation score must be greater than 13 !");
	
	if(studentRequest.getJavaLastYearScore()<13)
		mismatch.add("Student java last year score must be greater than 13 !");
		
	if(studentRequest.getNumberOfCertifications().intValue()<1)
		mismatch.add("Student must have at least one certification !");
		
	if(mismatch.isEmpty()) {
		response.setIsEligible(true);
		double score = (studentRequest.getGraduationScore()+studentRequest.getJavaLastYearScore())/2;
		response.setScoreOfApplicant(score);
	}
	else {
		response.setIsEligible(false);
		response.setScoreOfApplicant(0);
	}
	return response;
}
}
