package com.board.instance;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "myitems")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private String smallimg;

    private String img;

    @Column(nullable = false)
    private String about;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String owner;

    public Item(String name, int price, String smallimg, String img, String about, String category, String owner) {
        this.name = name;
        this.price = price;
        this.smallimg = smallimg;
        this.img = img;
        this.about = about;
        this.category = category;
        this.owner = owner;
    }

    public Item() {
    }

    public String getOwner(){ return owner; }
    public String getCategory(){ return category; }
    public String getImg(){ return img; }
    public String getAbout(){ return about; }
    public String getName(){ return name; }
    public String getSmallimg(){ return smallimg; }
    public int getId(){ return id; }
    public int getPrice(){ return price; }
}
