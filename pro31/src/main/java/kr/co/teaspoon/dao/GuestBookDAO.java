package kr.co.teaspoon.dao;

import kr.co.teaspoon.dto.GuestBook;

import java.util.List;

public interface GuestBookDAO {
    public List<GuestBook> guestBookList() throws Exception;
    public void writeArticle(GuestBook guestBookDto) throws Exception;
    public void fileRegister(GuestBook guestBookDto) throws Exception;
}