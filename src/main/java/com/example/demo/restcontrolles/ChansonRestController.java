package com.example.demo.restcontrolles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Chanson;
import com.example.demo.service.ChansonService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChansonRestController{
	
	@Autowired
	ChansonService chansonService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Chanson> getAllChansons(){
		return chansonService.getAllChansons();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Chanson getChansonById(@PathVariable("id") Long id) {
		return chansonService.getChanson(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Chanson createChanson(@RequestBody Chanson chanson) {
	return chansonService.saveChanson(chanson);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Chanson updateChanson(@RequestBody Chanson chanson) {
	return chansonService.updateChanson(chanson);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteChanson(@PathVariable("id") Long id)
	{
	chansonService.deleteChansonById(id);
	}
	@RequestMapping(value="/chansalbu/{idAlbum}",method = RequestMethod.GET)
	public List<Chanson> getChansonsByAlbumId(@PathVariable("idAlbum") Long idAlbum) {
	return chansonService.findByAlbumIdAlbum(idAlbum);
	}
	@RequestMapping(value="/chansByName/{titre}",method = RequestMethod.GET)
	public List<Chanson> findByNomProduitContains(@PathVariable("titre") String titre) {
	return chansonService.findByTitreChansonContains(titre);
	}
}
