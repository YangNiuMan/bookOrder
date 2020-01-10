package cn.itcast.dao;


import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookDao {

    @Select( "select * from book")
    List<Book> findAll();


    @Select("select count(*) from book")
    int findTotal();

    @Select("select * from book where id=#{id}")
    @Results({
            @Result(id=true, property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "price",column = "price"),
            @Result(property = "intro",column = "intro"),
            @Result(property = "auther",column = "auther"),
            @Result(property = "press",column = "press"),
            @Result(property = "pubdate",column = "pubdate"),
            @Result(property = "special",column = "special"),
            @Result(property = "news",column = "news"),
            @Result(property = "sale",column = "sale"),
            @Result(property = "category",column = "category_id",javaType = Category.class,one = @One(select = "cn.itcast.dao.categoryDao.findById")),
    })
    Book findById(Integer id);

    @Update("update book set special=1 where id=#{id}")
    void update(Integer id);

    @Update("update book set special=0 where id=#{id}")
    void update1(Integer id);

    @Select("select * from book where special=1")
    List<Book> SearchRecommend();

    @Select("select count(*) from book where special=1")
    int findCount();

    @Select("select * from book where news=1")
    List<Book> SearchNews();
    @Select("select count(*) from book where news=1")
    int findNums();

    @Update("update book set news=1 where id=#{id}")
    void update2(Integer id);

    @Update("update book set news=0 where id=#{id}")
    void update3(Integer id);

    @Select("select * from book where sale=1")
    List<Book> SearchSale();
    @Select("select count(*) from book where sale=1")
    int findShu();
    @Update("update book set sale=1 where id=#{id}")
    void update4(Integer id);
    @Update("update book set sale=0 where id=#{id}")
    void update5(Integer id);

    @Delete("delete from book where id=#{id}")
    void delete(Integer id);

    @Update("update book set cover=#{cover},name=#{name},price=#{price},intro=#{intro},auther=#{auther},press=#{press},pubdate=#{pubdate} where id=#{id}")
    void updated(@Param("id") Integer id,@Param("cover") String cover,@Param("name") String name,@Param("price") String price,@Param("intro") String intro,@Param("auther") String auther,@Param("press") String press,@Param("pubdate") String pubdate);

    @Insert("insert into book (cover,name,price,intro,auther,press,pubdate,special,sale,news,category_id) values(#{cover},#{name},#{price},#{intro},#{auther},#{press},#{pubdate},#{special},#{sale},#{news},#{categoryId})")
    void add(@Param("cover") String cover,@Param("name") String name,@Param("price") String price,@Param("intro") String intro,@Param("auther") String auther,@Param("press") String press,@Param("pubdate") String pubdate,@Param("special") String special,@Param("sale") String sale,@Param("news") String news,@Param("categoryId") String categoryId);

    @Select("select * from book where name like CONCAT('%',#{sous},'%')")
    List<Book> search(String sous);

    @Select("select count(*) from book where name like CONCAT('%',#{sous},'%')")
    int findAllCount(String sous);

    @Select("select * from book where special=1")
    List<Book> findSpecial();

    @Select("select * from book where news=1")
    List<Book> findNews();

    @Select("select * from book where name like CONCAT('%',#{searchName},'%')")
    List<Book> searchBookName(String searchName);

    @Select("select * from book where category_id=#{id}")
    List<Book> findByCategoryId(Integer id);
}
