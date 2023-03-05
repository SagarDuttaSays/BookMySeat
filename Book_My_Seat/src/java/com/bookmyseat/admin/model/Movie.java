package com.bookmyseat.admin.model;
//this is homologous to the bean class where all the columns of a table are created
//in the form of variables and values are temporarily retrieved and sent 
public class Movie 
{
    private int id;
    private String name;
    private String director;
    private String releasing_Date;
    private String casts;
    private String description;
    private String poster;
    private String trailer;
    private String category;
    private String duration;

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", director=" + director + ", releasing_Date=" + releasing_Date + ", casts=" + casts + ", description=" + description + ", poster=" + poster + ", trailer=" + trailer + ", category=" + category + ", duration=" + duration + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleasing_Date() {
        return releasing_Date;
    }

    public void setReleasing_Date(String releasing_Date) {
        this.releasing_Date = releasing_Date;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Movie(int id, String name, String director, String releasing_Date, String casts, String description, String poster, String trailer, String category, String duration) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.releasing_Date = releasing_Date;
        this.casts = casts;
        this.description = description;
        this.poster = poster;
        this.trailer = trailer;
        this.category = category;
        this.duration = duration;
    }

    public Movie(String name, String director, String releasing_Date, String casts, String description, String poster, String trailer, String category, String duration) {
        this.name = name;
        this.director = director;
        this.releasing_Date = releasing_Date;
        this.casts = casts;
        this.description = description;
        this.poster = poster;
        this.trailer = trailer;
        this.category = category;
        this.duration = duration;
    }

    

    public Movie() {
    }
}
