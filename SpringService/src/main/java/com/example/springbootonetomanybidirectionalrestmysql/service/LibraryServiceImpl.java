package com.example.springbootonetomanybidirectionalrestmysql.service;


import com.example.springbootonetomanybidirectionalrestmysql.jpa.Library;
import com.example.springbootonetomanybidirectionalrestmysql.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;


    @Override
    public List<Library> listLibrary() {
        try{
            List<Library> libraries = libraryRepository.findAll();
            return libraries;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Library getLibraryById(int library_id) {
        try{
            Library library = libraryRepository.findById(library_id).get();
            return library;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveLibrary(Library library) {
        try{
            libraryRepository.save(library);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteLibrary(int library_id) {
        try{
            libraryRepository.deleteById(library_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateLibrary(Library library) {
        try{
            libraryRepository.save(library);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
