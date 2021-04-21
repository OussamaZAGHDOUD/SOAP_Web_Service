package com.oussama.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.oussama.registrationeligibility.StudentRequest;
import com.oussama.registrationeligibility.WsResponse;
import com.oussama.service.StudentEligService;

@Endpoint
public class StudentEligEndPoint {
	public final static String nameSpace="http://www.oussama.com/registrationEligibility";
	@Autowired
	private StudentEligService service ;
	@PayloadRoot(namespace = nameSpace,localPart = "StudentRequest")
	@ResponsePayload
	public WsResponse getStatus(@RequestPayload StudentRequest studentRequest) {			
		return service.checkEligibility(studentRequest);
	}
}
