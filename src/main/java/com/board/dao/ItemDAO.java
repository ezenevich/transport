package com.board.dao;

import com.board.instance.Item;

import java.util.List;


public interface ItemDAO {

    List<Item> getItems();

    Item getItemById(Integer id);

    void addItem(Item item);

    List<Item> getItemsByCategory(String category);

    List<Item> getItemsByLogin(String login);

    void updateItem(Item item);

    void deleteItem(Item item);
}
