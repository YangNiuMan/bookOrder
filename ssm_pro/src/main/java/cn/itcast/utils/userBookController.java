package cn.itcast.utils;

import cn.itcast.domain.Book;
import cn.itcast.domain.shopCart;
import cn.itcast.service.BookService;
import cn.itcast.service.itemsService;
import cn.itcast.service.shopCartService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/userBook")
public class userBookController {

    @Autowired
    private BookService service;

    @Autowired
    private shopCartService SCservice;

    @Autowired
    private itemsService itService;
  /*  @RequestMapping("/findSpecial")
    private ModelAndView findSpecial(){
        ModelAndView mv = new ModelAndView();
        Book specials = service.findSpecial();
        mv.addObject("specials",specials);
        mv.setViewName("special");
        return mv;
    }*/

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") Integer id){
        Book book = service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("book",book);
        mv.setViewName("detail");
        return mv;
}
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name="searchName",required = true) String searchName){
        List<Book> books = service.searchBookName(searchName);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books",books);
        mv.setViewName("search");
        return mv;
    }

    @RequestMapping("/findByBookId")
    public ModelAndView findByBookId(@RequestParam("bookId") Integer bookId ,@RequestParam("amount") Integer amount,@RequestParam("userId") Integer userId){
        Book book = service.findById(bookId);
        shopCart cart=SCservice.findByBookIduserId(bookId,userId);
        if(cart!=null){
            amount=cart.getAmount()+1;
            Double total= book.getPrice()*amount;
            SCservice.update(bookId,amount,total);
            ModelAndView mv = new ModelAndView();
            List<shopCart> shopCarts=SCservice.findByUserId(userId);
            mv.addObject("shopCarts",shopCarts);
            mv.setViewName("index2");
            return mv;
        }
        Double total= book.getPrice()*amount;
        SCservice.add(bookId,book.getCover(),book.getName(),book.getPrice(),amount,total,userId);
        List<shopCart> shopCarts=SCservice.findByUserId(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("shopCarts",shopCarts);
        mv.setViewName("index2");
        return mv;
    }

    @RequestMapping("/SepcialList")
    public ModelAndView specialList(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                    @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Book> specials = service.findSpecial(page,pageSize);
        PageInfo pageInfo = new PageInfo(specials);
        int totalCount=service.findCount();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("page", pages);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("special");
        return mv;
    }

    @RequestMapping("/NewList")
    public ModelAndView NewList(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                    @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Book> news = service.findNews(page,pageSize);
        PageInfo pageInfo = new PageInfo(news);
        int totalCount=service.findCount();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("page", pages);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("new");
        return mv;
    }


    @RequestMapping("/SaleList")
    public ModelAndView SaleList(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Book> sale = service.SearchSale(page,pageSize);
        PageInfo pageInfo = new PageInfo(sale);
        int totalCount=service.findShu();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("page", pages);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("new");
        return mv;
    }
}
