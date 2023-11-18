package kr.co.teaspoon.dao;

import kr.co.teaspoon.dto.GuestBook;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestBookDAOImpl implements GuestBookDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<GuestBook> guestBookList() throws Exception {
        return null;
    }

    @Override
    public void writeArticle(GuestBook guestBookDto) throws Exception {
        sqlSession.insert("guestbook.writeArticle", guestBookDto);
    }

    @Override
    public void fileRegister(GuestBook guestBookDto) throws Exception {
        sqlSession.insert("guestbook.fileRegister", guestBookDto);
    }
}
