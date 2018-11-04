package org.richardliao.job.manager.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.richardliao.job.manager.domain.Job;
import org.richardliao.job.manager.db.JobRepository;
import org.richardliao.job.manager.CommonResponce;

@RestController
@RequestMapping(value="/job", produces="application/json")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value="/books", method=GET)
    public Object bookList(@QueryParam("title") String title, @QueryParam("auth") String auth) {
        Map<String, String> query = new HashMap<>();
	if (null != title && !"".equals(title.trim())) query.put("title", title);
	if (null != auth && !"".equals(auth.trim())) query.put("auth", auth);
	List<Book> res = bookMapper.getBookList(query);
	return new CommonResponce(0, res);
    }

    @RequestMapping(value="/book/{id}", method=GET)
    public Object bookDetail(@PathVariable("id") String id) {
	Book res = bookMapper.getBookById(id);
	return new CommonResponce(0, res);
    }

    @RequestMapping(value="/book", method=POST)
    public Object addBook(@RequestBody Book book) {
	if (null == book || null == book.getId())
	    return new CommonResponce(1, "Failed. Book or Book.id is null!");
	bookMapper.add(book);
	return new CommonResponce(0, book);
    }

    @RequestMapping(value="/book", method=PUT)
    public Object updateBook(@RequestBody Book book) {
	if (null == book || null == book.getId())
	    return new CommonResponce(1, "Failed. Book or Book.id is null!");
	Book bookDb = bookMapper.getBookById(book.getId());
	if (null == bookDb) return new CommonResponce(1, "Failed. No Book [" + book.getId() + "] found!");
	bookMapper.update(book);
	return new CommonResponce(0, book);
    }

    @RequestMapping(value="/book/{id}", method=DELETE)
    public Object deleteBook(@PathVariable("id") String id) {
	Book bookDb = bookMapper.getBookById(id);
        if (null == bookDb) return new CommonResponce(1, "Failed. No Book [" + id + "] found!");
	bookMapper.delete(id);
	return new CommonResponce(0, bookDb);
    }
}
