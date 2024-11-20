package serviceImpl;

import dataBase.DataBase;
import models.Library;
import models.Reader;
import service.ReaderService;

import java.util.ArrayList;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {
        DataBase.readers.add(reader);
    }

    @Override
    public ArrayList<Reader> getAllReaders() {
        return DataBase.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader:DataBase.readers){
            if (reader.getId()==id){
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i < DataBase.readers.size(); i++) {
            if (DataBase.readers.get(i).getId()==id){
                DataBase.readers.set(i,reader);
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader assignReaderToLibrary(Long readerId, Long libraryId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        Reader reader = new ReaderServiceImpl().getReaderById(readerId);
        if (library!=null && reader!=null){
            System.out.println(library.getReaders().add(reader));
        }
        return reader;
    }
}
