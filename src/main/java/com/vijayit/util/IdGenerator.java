package com.vijayit.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class IdGenerator {

	
    private Map<String, Integer> idCounters = new HashMap<>();

	private String getRolePrefix(String role) {
		if ("units".equalsIgnoreCase(role)) {
			return "UNI";
		} else if ("doctor".equalsIgnoreCase(role)) {
			return "DOC";
		} else if ("admin".equalsIgnoreCase(role)) {
			return "ADM";
		} else if ("technician".equalsIgnoreCase(role)) {
			return "TEC";

		} else {
			return "PAT";
		}
	}


	public synchronized String generateUniqueId(String rolePrefix) {
	   
	    rolePrefix = getRolePrefix(rolePrefix).toUpperCase();
	    
	    int count = idCounters.getOrDefault(rolePrefix, 0) + 1;
	    idCounters.put(rolePrefix, count);
	    return rolePrefix + count;
	}

}