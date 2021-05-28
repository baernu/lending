package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import data.Actor;
import data.Movie;
import persistence.DAOFactory;
import persistence.IMovieDAO;

public class MovieDAO implements IMovieDAO {
	private File movieFile;
	private String delimiter = DAOFactory.DELIMITER;
	private static final Logger LOGGER = Logger.getLogger(MovieDAO.class.getName());

	public MovieDAO() {
		ClassLoader classLoader = getClass().getClassLoader();
		this.movieFile = new File(classLoader.getResource(DAOFactory.FILM_FILE).getFile());
	}

	@Override
	public ArrayList<Movie> loadMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		log("Load movies from file");
		try (Scanner scanner = new Scanner(new FileReader(movieFile))) {
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				long id = Long.parseLong(tokens[0]);
				String title = tokens[1];
				Movie movie = new Movie(id, title);
				movie.addActor(new Actor(tokens[2], tokens[3]));
				movie.addActor(new Actor(tokens[4], tokens[5]));
				movie.addActor(new Actor(tokens[6], tokens[7]));
				movies.add(movie);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Movie Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Movie Datei ist korrupt");
		}
		return movies;
	}

	private void log(String stmt) {
		LOGGER.info(stmt);
	}
}
