package cn.itcast.service.impl;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.service.BookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class bookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;

    @Override
    public List<Book> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public Book findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void update(Integer id) {
         dao.update(id);
    }

    @Override
    public void update1(Integer id) {
         dao.update1(id);
    }

    @Override
    public List<Book> SearchRecommend(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.SearchRecommend();
    }

    @Override
    public int findCount() {
        return dao.findCount();
    }

    @Override
    public List<Book> SearchNews(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.SearchNews();
    }

    @Override
    public int findNums() {
        return dao.findNums();
    }

    @Override
    public void update2(Integer id) {
        dao.update2(id);
    }

    @Override
    public void update3(Integer id) {
        dao.update3(id);
    }

    @Override
    public List<Book> SearchSale(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.SearchSale();
    }

    @Override
    public int findShu() {
        return dao.findShu();
    }

    @Override
    public void update4(Integer id) {
         dao.update4(id);
    }

    @Override
    public void update5(Integer id) {
        dao.update5(id);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void updated(Integer id,String cover, String name, String price, String intro, String auther, String press, String pubdate) {
        dao.updated(id,cover,name,price,intro,auther,press,pubdate);
    }

    @Override
    public void add(String cover, String name, String price, String intro, String auther, String press, String pubdate, String special, String sale, String news, String categoryId) {
        dao.add(cover,name,price,intro,auther,press,pubdate,special,sale,news,categoryId);
    }

    @Override
    public List<Book> search(String sous, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        return dao.search(sous);
    }

    @Override
    public int findAllCount(String sous) {
        return dao.findAllCount(sous);
    }

    @Override
    public List<Book> findSpecial(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findSpecial();
    }

    @Override
    public List<Book> findNews(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findNews();
    }

    @Override
    public List<Book> searchBookName(String searchName) {
        return dao.searchBookName(searchName);
    }

    @Override
    public List<Book> findByCategoryId(Integer id) {
        return dao.findByCategoryId(id);
    }
}
