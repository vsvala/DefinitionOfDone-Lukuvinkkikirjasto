/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.classes;

import ReadMe.data_access.BookmarkDao;
import ReadMe.io.IO;
import java.util.List;

/**
 * UI object. Used to run console app.
 *
 * @author bisi
 */
public class UI {

    private IO io;
    private BookmarkDao dao;

    public UI(IO io, BookmarkDao dao) {
        this.io = io;
        this.dao = dao;
    }

    public Bookmark addBookmark() {
        String headline = io.readLine("Enter title: ");
        String description = io.readLine("Enter description: ");
        String link = io.readLine("Enter link: ");
        return new Bookmark(headline, description, link);
    }

    /**
     * Prints all Bookmarks from database
     */
    public void listBookmarks() {
        List<Bookmark> tips = dao.listAll();
        for (Bookmark rt : tips) {
            io.print(rt.toString());
        }
    }

    /**
     * Runs console UI
     */
    public void run() {
        this.io = io;
        io.print("Welcome to ReadTipper!\n\n");
        String choice = "";
        while (!choice.equals("q")) {
            io.print("Choose a to add new readtip, l to list all tips, q to quit app:");
            choice = io.readLine("Enter choice: ");
            switch (choice) {
                case "a":
                    io.print("Adding a new ReadTip!:\n\n");
                    dao.add(addBookmark());
                    io.print("Tip added!\n\n");
                    break;
                case "l":
                    io.print("All added tips: \n");
                    listBookmarks();
                    io.print("\n\n");
                    break;
                case "q":
                    break;
                default:
                    io.print("Choose a correct input!");
            }
        }
        io.print("Thank you!");
    }

}
