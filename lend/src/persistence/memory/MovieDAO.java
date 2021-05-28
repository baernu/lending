package persistence.memory;

import java.util.ArrayList;
import java.util.logging.Logger;

import data.Actor;
import data.Movie;
import persistence.IMovieDAO;

public class MovieDAO implements IMovieDAO {
	private static final Logger LOGGER = Logger.getLogger(MovieDAO.class.getName());

	@Override
	public ArrayList<Movie> loadMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		log("load movies");

		Movie movie = new Movie(574, "Star Wars");
		movie.addActor(new Actor("Norton", "Edward"));
		movie.addActor(new Actor("Delon", "Alain"));
		movie.addActor(new Actor("Depp", "Johnny"));
		movies.add(movie);

		movie = new Movie(632, "The Earth");
		movie.addActor(new Actor("Hathaway", "Anne"));
		movie.addActor(new Actor("Black", "Edward"));
		movie.addActor(new Actor("Delon", "Alain"));
		movies.add(movie);

		movie = new Movie(661, "Ice");
		movie.addActor(new Actor("Aniston", "Jennifer"));
		movie.addActor(new Actor("Norton", "Edward"));
		movie.addActor(new Actor("Bale", "Christian"));
		movies.add(movie);

		movie = new Movie(721, "Shapes");
		movie.addActor(new Actor("Portman", "Natalie"));
		movie.addActor(new Actor("Delon", "Alain"));
		movie.addActor(new Actor("Hathaway", "Anne"));
		movies.add(movie);

		movie = new Movie(810, "The Queen");
		movie.addActor(new Actor("Depp", "Johnny"));
		movie.addActor(new Actor("Stein", "Christian"));
		movie.addActor(new Actor("Hathaway", "Anne"));
		movies.add(movie);

		return movies;
	}

	private void log(String stmt) {
		LOGGER.info(stmt);
	}
}
