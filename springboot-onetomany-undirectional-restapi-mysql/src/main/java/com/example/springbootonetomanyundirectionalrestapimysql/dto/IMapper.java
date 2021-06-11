package com.example.springbootonetomanyundirectionalrestapimysql.dto;

import com.example.springbootonetomanyundirectionalrestapimysql.jpa.Book;
import com.example.springbootonetomanyundirectionalrestapimysql.jpa.Library;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface IMapper {
    /* BookDto toBookDto(Book book);
     List<BookDto> toBookDtos(List<Book> books);
     Book toBook(BookDto bookDto);
     LibraryDto toLibraryDto(Library library);
     List<LibraryDto> toLibraryDtos(List<Library> libraries);
     Library toLibrary(LibraryDto libraryDto);*/
    BookDto toBookDto(Book book);
    List<BookDto> toBookDtos(List<Book> books);
    Book toBook(BookDto bookDto);
    List<LibraryDto> toLibraryDtos(List<Library> libraries);
    LibraryDto toLibraryDto(Library library);
    Library toLibrary(LibraryDto libraryDto);


}
