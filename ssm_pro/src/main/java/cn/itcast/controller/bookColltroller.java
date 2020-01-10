package cn.itcast.controller;


import cn.itcast.domain.Book;
import cn.itcast.domain.Order;
import cn.itcast.domain.Role;
import cn.itcast.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/book")
public class bookColltroller {

    @Autowired
    private BookService service;


    @RequestMapping("/findAll.do")
    public ModelAndView findAllBook(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize) {
        List<Book> books = service.findAll(page, pageSize);
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(books);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("book-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }


    @RequestMapping("/update")
    public String  recommend(@RequestParam("id") Integer id) {
       /* Book book = service.findById(id);
        book.setSpecial(1);*/
        service.update(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/update1")

    public String  NoRecommend(@RequestParam("id") Integer id) {
        /*Book book = service.findById(id);
        book.setSpecial(0);*/
        service.update1(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/SearchRecommend")
    public ModelAndView SearchRecommend(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                  @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){

        List<Book> books = service.SearchRecommend(page, pageSize);
        int totalCount=service.findCount();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(books);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bookRecommend-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }

    @RequestMapping("/SearchNews")
    public ModelAndView SearchNews(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                        @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){

        List<Book> books = service.SearchNews(page, pageSize);
        int totalCount=service.findNums();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(books);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bookNews-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }

    @RequestMapping("/update2")
    public String  news(@RequestParam("id") Integer id) {
       /* Book book = service.findById(id);
        book.setSpecial(1);*/
        service.update2(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/update3")

    public String  NoNews(@RequestParam("id") Integer id) {
        /*Book book = service.findById(id);
        book.setSpecial(0);*/
        service.update3(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/SearchSale")
    public ModelAndView SearchSale(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                   @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){

        List<Book> books = service.SearchSale(page, pageSize);
        int totalCount=service.findShu();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(books);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bookSale-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }

    @RequestMapping("/update4")
    public String  sale(@RequestParam("id") Integer id) {
       /* Book book = service.findById(id);
        book.setSpecial(1);*/
        service.update4(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/update5")
    public String  NoSale(@RequestParam("id") Integer id) {
        /*Book book = service.findById(id);
        book.setSpecial(0);*/
        service.update5(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String  delete(@RequestParam("id") Integer id) {
        /*Book book = service.findById(id);
        book.setSpecial(0);*/
        service.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id",required = true) Integer id) {
        ModelAndView mv = new ModelAndView();
        Book book = service.findById(id);
        mv.addObject("book",book);
        mv.setViewName("book-update");
        return mv;
    }

    @RequestMapping("/findByCategoryId")
    public ModelAndView findByCategoryId(@RequestParam(name="id",required = true) Integer id) {
        ModelAndView mv = new ModelAndView();
        List<Book> books = service.findByCategoryId(id);
        mv.addObject("books",books);
        mv.setViewName("category-Booklist");
        return mv;
    }
    @RequestMapping("/update.do")
    public String update(@RequestParam(name = "id",required = true) Integer id,@RequestParam(name = "cover",required = true) String cover,
                         @RequestParam(name = "name",required = true) String name, @RequestParam(name = "price",required = true) String price,
                         @RequestParam(name = "intro",required = true) String intro, @RequestParam(name = "auther",required = true) String auther,
                         @RequestParam(name = "press",required = true) String press, @RequestParam(name = "pubdate",required = true) String pubdate
                        ){

        service.updated(id,cover,name,price,intro,auther,press,pubdate);
        return "redirect:findAll.do";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name = "sous",required = true) String sous,@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                               @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Book> books =service.search(sous,page,pageSize);
        int totalCount=service.findAllCount(sous);
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(books);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("book-SearchList");
        return mv;
    }


    @RequestMapping("/add.do")
    public String add(@RequestParam(name = "cover",required = true) String cover, @RequestParam(name = "name",required = true) String name, @RequestParam(name = "price",required = true) String price,
                      @RequestParam(name = "intro",required = true) String intro, @RequestParam(name = "auther",required = true) String auther,
                      @RequestParam(name = "press",required = true) String press, @RequestParam(name = "pubdate",required = true) String pubdate,
                      @RequestParam(name = "special",required = true) String special, @RequestParam(name = "sale",required = true) String sale,
                      @RequestParam(name = "news",required = true) String news, @RequestParam(name = "categoryId",required = true) String categoryId){

        service.add(cover,name,price,intro,auther,press,pubdate,special,sale,news,categoryId);
        return "redirect:findAll.do";
    }
}
