package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Album;
import com.example.demo.entities.Chanson;
import com.example.demo.repos.ChansonRepository;



@Service
public class ChansonServiceImpl implements ChansonService {

	@Autowired
	ChansonRepository chansonRepository;
	
	@Override
	public Chanson saveChanson(Chanson c) {
		return chansonRepository.save(c);
	}

	@Override
	public Chanson updateChanson(Chanson c) {
		return chansonRepository.save(c);
	}

	@Override
	public void deleteChanson(Chanson c) {
		chansonRepository.delete(c);
	}

	@Override
	public void deleteChansonById(Long id) {
		chansonRepository.deleteById(id);
	}

	@Override
	public Chanson getChanson(Long id) {
		return chansonRepository.findById(id).get();
	}

	@Override
	public List<Chanson> getAllChansons() {
		return chansonRepository.findAll();
	}
	
	@Override
	public List<Chanson> findByTitreChanson(String titre) {
		return chansonRepository.findByTitreChanson(titre);
	}

	@Override
	public List<Chanson> findByTitreChansonContains(String titre) {
		return chansonRepository.findByTitreChansonContains(titre);
	}

	@Override
	public List<Chanson> findByTitreDuree(String titre, Double duree) {
		return chansonRepository.findByTitreDuree(titre, duree);
	}
	
	@Override
	public List<Chanson> findByAlbum(Album album) {
		return chansonRepository.findByAlbum(album);
	}

	@Override
	public List<Chanson> findByAlbumIdAlbum(Long id) {
		return chansonRepository.findByAlbumIdAlbum(id);
	}

	@Override
	public List<Chanson> findByOrderByTitreChansonAsc() {
		return chansonRepository.findByOrderByTitreChansonAsc();
	}

	@Override
	public List<Chanson> trierChansonsTitresDuree() {
		return chansonRepository.trierChansonsTitresDuree();
	}


}
