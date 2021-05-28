package persistence;

import java.util.ArrayList;

import data.Book;

public interface IBookDAO {
	ArrayList <Book> loadBooks();
}
