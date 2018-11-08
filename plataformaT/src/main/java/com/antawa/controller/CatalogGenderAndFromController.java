package com.antawa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antawa.model.CatalogGenderAndFrom;
import com.antawa.model.repository.CatalogGenderAndFromRepository;
import com.antawa.services.CatalogGenderFromService;
import com.antawa.util.ResponseObject;

@RestController
@RequestMapping("api")
public class CatalogGenderAndFromController {
	
	/**
	 * Service of catalog.
	 */
	@Autowired
	private CatalogGenderFromService catalogGFService;
	
	@Autowired
	private CatalogGenderAndFromRepository catalogGFRepository;

	@RequestMapping(value = "/get/catalog", method = RequestMethod.GET)
	public ResponseObject<?> findAllGendersFRoms() {
		ResponseObject<List<CatalogGenderAndFrom>> response = new ResponseObject<>();
		try {
			List<CatalogGenderAndFrom> cataloggf = catalogGFService.findAll();
			response.setResponse(cataloggf);
		} catch (Exception e) {
			response.setResponse(null);
			response.setStatus(HttpStatus.CONFLICT);
			response.setMessage("ERROR obt objs");
		}
		return response;
	}
	
	@RequestMapping(value = "/get/gender", method = RequestMethod.GET)
	public ResponseObject<?> getCatalogGender(@RequestParam(value = "id") Long id) {
		ResponseObject<List<CatalogGenderAndFrom>> respuesta = new ResponseObject<>();
		try {
			System.out.println("id");
			System.out.println(id);
			List<CatalogGenderAndFrom> result = catalogGFRepository.findGenderByIdFather(id);
			respuesta.setResponse(result);
			return respuesta;
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setMessage("Error obtain information");
			respuesta.setStatus(HttpStatus.CONFLICT);
			return respuesta;
		}
	}
	
	@RequestMapping(value = "/get/from", method = RequestMethod.GET)
	public ResponseObject<?> getCatalogFrom(@RequestParam(value = "id") Long id) {
		ResponseObject<List<CatalogGenderAndFrom>> respuesta = new ResponseObject<>();
		try {
			System.out.println("id");
			System.out.println(id);
			List<CatalogGenderAndFrom> result = catalogGFRepository.findFromByIdFather(id);
			respuesta.setResponse(result);
			return respuesta;
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setMessage("Error obtain information");
			respuesta.setStatus(HttpStatus.CONFLICT);
			return respuesta;
		}
	}

}
