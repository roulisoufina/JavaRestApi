package rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rest.api.model.Song;
import rest.api.service.SongService;

@Controller
public class SongController {

	@Autowired
	private SongService songService;

	@RequestMapping(value = "/songs", method = RequestMethod.GET)
	@ResponseBody
	public List<Song> findAll() {
		List<Song> songs = songService.getAllSongs();
		return songs;
	}

	@RequestMapping(value = "/song/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Song findOne(@PathVariable("id") long id) {
		Song song = songService.getSong(id);
		return song;
	}

	@RequestMapping(value = "/song/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSong(@PathVariable("id") long id) {
		songService.deleteSong(id);
		return ResponseEntity.ok().body("Song has been deleted successfully.");
	}

	@RequestMapping(value = "/song", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createSong(@RequestBody Song song) {
		long id = songService.createSong(song);
		return ResponseEntity.ok().body("New song has been saved with ID:" + id);
	}

	@RequestMapping(value = "/song/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSong(@PathVariable("id") long id, @RequestBody Song song) {
		songService.updateSong(id, song);
		return ResponseEntity.ok().body("Song has been updated successfully.");
	}

}
