package com.example.acer.jongnhams.model;

public class Anime {
    private String name;
    private String discount;
    private int bb_episode;
    private String image_url;

    public Anime () {

    }
    public Anime(String name, String discount, int bb_episode, String image_url) {
        this.name = name;
        this.discount = discount;
        this.bb_episode = bb_episode;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getDiscount() {
        return discount;
    }

    public int getBb_episode() {
        return bb_episode;
    }

    public String getImage_url() {
        return image_url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setBb_episode(int bb_episode) {
        this.bb_episode = bb_episode;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
