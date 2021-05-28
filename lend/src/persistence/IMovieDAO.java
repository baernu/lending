package persistence;

import java.util.ArrayList;

import data.Movie;

public interface IMovieDAO {
	ArrayList<Movie> loadMovies();
}
