package cn.itcast.service;

import cn.itcast.domain.Book;

import java.util.List;

public interface BookService {


    List<Book> findAll(Integer page,Integer pageSize);

    int findTotal();

    
    
    Book findById(Integer id);

    void update(Integer id);

    void update1(Integer id);

    List<Book> SearchRecommend(Integer page, Integer pageSize);

    int findCount();

    List<Book> SearchNews(Integer page, Integer pageSize);

    int findNums();

    void update2(Integer id);

    void update3(Integer id);

    List<Book> SearchSale(Integer page, Integer pageSize);

    int findShu();

    void update4(Integer id);
    void update5(Integer id);

    void delete(Integer id);

    void updated(Integer id,String cover, String name, String price, String intro, String auther, String press, String pubdate);

    void add(String cover, String name, String price, String intro, String auther, String press, String pubdate, String special, String sale, String news, String categoryId);

    List<Book> search(String sous, Integer page, Integer pageSize);

    int findAllCount(String sous);

    List<Book> findSpecial(Integer page, Integer pageSize);

    List<Book> findNews(Integer page, Integer pageSize);

    List<Book> searchBookName(String searchName);

    List<Book> findByCategoryId(Integer id);
}
