package rest.api.dao;

import java.util.List;

import rest.api.model.Song;

public interface SongDao {

	List<Song> list();
	Song getSong(long id);
	
	void deleteSong(long id);
	
	long createSong(Song song);
	void updateSong(long id, Song song);
	
}
