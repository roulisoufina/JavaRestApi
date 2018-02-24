package rest.api.service;

import java.util.List;

import rest.api.model.Song;

public interface SongService {

	public List<Song> getAllSongs();
	public Song getSong(long id);
	public void deleteSong(long id);
	public long createSong(Song song);
	public void updateSong(long id, Song song);
}
