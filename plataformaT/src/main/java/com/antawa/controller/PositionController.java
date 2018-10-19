package com.antawa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.antawa.model.Position;
import com.antawa.services.PosService;
import com.antawa.util.ResponseObject;

@RestController
@RequestMapping("pos")
public class PositionController {

	@Autowired
	private PosService posService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseObject<?> findAllCoords() {
		ResponseObject<List<Position>> resp = new ResponseObject<>();
		try {
			List<Position> users = posService.findAll();
			resp.setResponse(users);
		} catch (Exception e) {
			resp.setResponse(null);
			resp.setStatus(HttpStatus.CONFLICT);
			resp.setMessage("ERROR obt objs");
		}
		return resp;
	}
}
