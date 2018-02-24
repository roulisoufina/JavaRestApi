package rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.api.dao.SongDao;
import rest.api.model.Song;

@Service
@Transactional(readOnly = true)
public class SongServiceImpl implements SongService {

	@Autowired
	private SongDao songDao;

	public List<Song> getAllSongs() {
		return songDao.list();
	}

	@Override
	public Song getSong(long id) {
		return songDao.getSong(id);
	}

	@Override
	@Transactional
	public void deleteSong(long id) {
		songDao.deleteSong(id);
	}

	@Override
	@Transactional
	public long createSong(Song song) {
		return songDao.createSong(song);
	}

	@Override
	@Transactional
	public void updateSong(long id, Song song) {
		songDao.updateSong(id, song);
	}
}
