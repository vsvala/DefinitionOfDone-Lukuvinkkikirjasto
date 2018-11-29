/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.database.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ReadMe.domain.News;
import java.util.Date;

/**
 *
 * @author madjanne
 */
public class NewsDaoTest {

    private File testFile;
    private Database testDatabase;
    ConsoleIO testIo;
    private NewsDao testDao;
    
    public NewsDaoTest() {
    }

    @Before
    public void setUp() throws ClassNotFoundException {
        
        testFile = new File("testReadMeBase.db");
        testDatabase = new SQLiteDatabase("jdbc:sqlite:" + testFile.getAbsolutePath());
        testDao = new NewsDao(testDatabase);
        testIo = new ConsoleIO();
    }

    @After
    public void tearDown() {
        testFile.delete();
    }

    @Test
    public void isListingCorrect() {
        testDao.add(new News(1, "author", "title", "www", "desc", "otava", 2018, false, new Date(5)));
        testDao.add(new News(3, "author1", "title2", "www4", "descr", "penguin", 2015, true, new Date(7)));
        
        List<News> newsArray = testDao.listAll();
        
        assertEquals(2, newsArray.size());
        assertEquals("title", newsArray.get(0).getNews_title());  
        assertEquals("descr", newsArray.get(0).getNews_description());  
    }
}