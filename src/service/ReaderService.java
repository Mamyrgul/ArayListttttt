package service;

import models.Reader;

import java.util.ArrayList;

public interface ReaderService {
    void saveReader(Reader reader);
    ArrayList<Reader> getAllReaders();
    Reader getReaderById(Long id);
    Reader updateReader(Long id, Reader reader);
    Reader assignReaderToLibrary(Long readerId, Long libraryId);
}
