package dev.aakarsh.movie;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private String year;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private String imdbRating;
    private String tomatoMeter;
    private String tomatoConsensus;
}
