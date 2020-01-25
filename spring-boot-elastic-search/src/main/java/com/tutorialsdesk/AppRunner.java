package com.tutorialsdesk;

import com.tutorialsdesk.model.Book;
import com.tutorialsdesk.model.Student;
import com.tutorialsdesk.service.BookService;
import com.tutorialsdesk.service.StudentService;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;
    
    @Override
    public void run(String... strings) throws Exception {

       // printElasticSearchInfo();

        bookService.save(new Book("2001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("2002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("2003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

        studentService.save(new Student("1","ABC","XYZ"));
        
        //fuzzey search
        Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        books.forEach(x -> System.out.println(x));
    }

    //useful for debug
   /* private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsGroups();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("<--ElasticSearch--");
    }*/
}
