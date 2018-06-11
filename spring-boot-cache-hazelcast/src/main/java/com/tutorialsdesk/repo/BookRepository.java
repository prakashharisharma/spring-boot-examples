package com.tutorialsdesk.repo;

import com.tutorialsdesk.model.Book;

public interface BookRepository {

	Book getByIsbn(String isbn);
}
