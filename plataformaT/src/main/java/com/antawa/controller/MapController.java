package com.antawa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.antawa.model.Map;
import com.antawa.services.MapService;
import com.antawa.util.ResponseObject;

@RestController
@RequestMapping("map")
public class MapController {
	
	@Autowired
	private MapService mapService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseObject<?> findAllCoords() {
		ResponseObject<List<Map>> resp = new ResponseObject<>();
		try {
			List<Map> users = mapService.findAll();
			resp.setResponse(users);
		} catch (Exception e) {
			resp.setResponse(null);
			resp.setStatus(HttpStatus.CONFLICT);
			resp.setMessage("ERROR obt objs");
		}
		return resp;
	}

}
