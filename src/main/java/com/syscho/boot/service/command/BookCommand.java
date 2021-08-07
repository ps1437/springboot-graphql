package com.syscho.boot.service.command;

import com.syscho.boot.model.BookDO;
import com.syscho.boot.repository.BookRepository;
import com.syscho.boot.vo.BookVO;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookCommand implements GraphQLMutationResolver {

    private final BookRepository bookRepository;

    @Transactional
    public String deleteById(int id) {
        return bookRepository.deleteById(id);
    }


    @Transactional
    public void save(BookVO bookVO) {
        BookDO bookDO = new BookDO();
        BeanUtils.copyProperties(bookVO, bookDO);
        bookRepository.save(bookDO);
    }

    @Transactional
    public BookVO update(BookVO bookVO) {
        BookDO bookDO = new BookDO();
        if (bookRepository.findByTitleContaining(bookVO.getTitle())
                .stream()
                .noneMatch(bookDO1 -> bookDO1.getTitle().equals(bookVO.getTitle()))) {
            throw new RuntimeException("Book Already Exist with title " + bookVO.getTitle());
        }
        BeanUtils.copyProperties(bookVO, bookDO);
        bookRepository.save(bookDO);
        return bookVO;
    }
}
