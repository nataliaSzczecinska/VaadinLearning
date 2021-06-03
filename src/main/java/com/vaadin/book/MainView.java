package com.vaadin.book;

import com.vaadin.book.domain.Book;
import com.vaadin.book.service.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private BookService bookService = BookService.getInstance();
    private Grid<Book> grid = new Grid<>(Book.class);

    public MainView() {
        //add(new Button("Click me", e -> Notification.show("Hello World")));
        grid.setColumns("title", "author", "publicationYear", "type");
        add(grid);
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(bookService.getBooks());
    }
}