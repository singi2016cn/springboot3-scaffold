package top.singi.springboot3_scaffold.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.singi.springboot3_scaffold.dto.PaginationDTO;
import top.singi.springboot3_scaffold.dto.ResultDTO;
import top.singi.springboot3_scaffold.entity.Book;
import top.singi.springboot3_scaffold.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public PaginationDTO index(
        @RequestParam(required = false, defaultValue = "") String search,
        @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
        @RequestParam(name = "per_page", required = false, defaultValue = "10") Integer perPage
    ) {
        LambdaQueryChainWrapper<Book> lambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(Book.class);
        
        if (!search.isBlank()) {
            lambdaQueryChainWrapper.like(Book::getTitle, search);
        }
        
        IPage<Book> pageRes = lambdaQueryChainWrapper.page(new Page<>(page, perPage));
        return PaginationDTO.of(pageRes.getRecords(), pageRes.getTotal());
    }

    @GetMapping("/{id}")
    public ResultDTO show(@PathVariable Integer id) {
        return ResultDTO.success(bookService.getById(id));
    }

    @PostMapping
    public ResultDTO save(@RequestBody Book book) {
        bookService.save(book);
        return ResultDTO.success(book.getId());
    }

    @PutMapping("/{id}")
    public ResultDTO update(@RequestBody Book book, @PathVariable Integer id) {
        book.setId(id);
        bookService.updateById(book);
        return ResultDTO.success(book.getId());
    }

    @DeleteMapping("/{id}")
    public ResultDTO delete(@PathVariable Integer id) {
        bookService.removeById(id);
        return ResultDTO.success(id);
    }
}
