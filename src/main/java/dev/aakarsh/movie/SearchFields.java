package dev.aakarsh.movie;

import lombok.Getter;

class SearchFields {
    @Getter
    private static String actor;
    @Getter
    private static String director;
    @Getter
    private static String genre;
    @Getter
    private static int minYear;
    @Getter
    private static int maxYear;
    @Getter
    private static int minRunning;
    @Getter
    private static int maxRunning;
    @Getter
    private static int minRotten;
    @Getter
    private static int maxRotten;
    @Getter
    private static int minIMDB;
    @Getter
    private static int maxIMDB;

    public static void setActor(String actor) {
        SearchFields.actor = actor;
    }

    public static void setDirector(String director) {
        SearchFields.director = director;
    }

    public static void setGenre(String genre) {
        SearchFields.genre = genre;
    }

    public static void setMinYear(int minYear) {
        SearchFields.minYear = minYear;
    }

    public static void setMaxYear(int maxYear) {
        SearchFields.maxYear = maxYear;
    }

    public static void setMinRunning(int minRunning) {
        SearchFields.minRunning = minRunning;
    }

    public static void setMaxRunning(int maxRunning) {
        SearchFields.maxRunning = maxRunning;
    }

    public static void setMinRotten(int minRotten) {
        SearchFields.minRotten = minRotten;
    }

    public static void setMaxRotten(int maxRotten) {
        SearchFields.maxRotten = maxRotten;
    }

    public static void setMinIMDB(int minIMDB) {
        SearchFields.minIMDB = minIMDB;
    }

    public static void setMaxIMDB(int maxIMDB) {
        SearchFields.maxIMDB = maxIMDB;
    }
}
