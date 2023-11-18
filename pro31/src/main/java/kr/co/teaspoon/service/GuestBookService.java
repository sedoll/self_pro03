package kr.co.teaspoon.service;

import kr.co.teaspoon.dto.GuestBook;

import java.util.List;

public interface GuestBookService {
    public List<GuestBook> guestBookList() throws Exception;
    public void writeArticle(GuestBook guestBookDto) throws Exception;
}
