package rest.api.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rest.api.model.Song;

@Repository
public class SongDaoImpl implements SongDao {

	@Autowired
	public SessionFactory sessionFactory;

	public List<Song> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Song> cq = cb.createQuery(Song.class);
		Root<Song> root = cq.from(Song.class);
		cq.select(root);
		Query<Song> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Song getSong(long id) {
		Session session = sessionFactory.getCurrentSession();
		Song song = session.get(Song.class, id);
		return song;
	}

	@Override
	public void deleteSong(long id) {
		Session session = sessionFactory.getCurrentSession();
		Song song = session.byId(Song.class).load(id);
		session.delete(song);
	}
	
	@Override
	public long createSong(Song song) {
		Session session = sessionFactory.getCurrentSession();
		session.save(song);
		return song.getId();
	}
	
	@Override
	public void updateSong(long id, Song song) {
		Session session = sessionFactory.getCurrentSession();
		Song newSong = session.byId(Song.class).load(id);
		newSong.setTitle(song.getTitle());
		newSong.setSinger(song.getSinger());
		session.flush();
		
	}
}
