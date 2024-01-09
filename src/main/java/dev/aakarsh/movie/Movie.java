package dev.aakarsh.movie;

public class Movie
{
    private String Title;
    private String Year;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private String imdbRating;
    private String tomatoMeter;
    private String tomatoConsensus;

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public String getYear()
    {
        return Year;
    }

    public void setYear(String year)
    {
        Year = year;
    }

    public String getReleased()
    {
        return Released;
    }

    public void setReleased(String released)
    {
        Released = released;
    }

    public String getRuntime()
    {
        return Runtime;
    }

    public void setRuntime(String runtime)
    {
        Runtime = runtime;
    }

    public String getGenre()
    {
        return Genre;
    }

    public void setGenre(String genre)
    {
        Genre = genre;
    }

    public String getPlot()
    {
        return Plot;
    }

    public void setPlot(String plot)
    {
        Plot = plot;
    }

    public String getPoster()
    {
        return Poster;
    }

    public void setPoster(String poster)
    {
        Poster = poster;
    }

    public String getLanguage()
    {
        return Language;
    }

    public void setLanguage(String language)
    {
        Language = language;
    }

    public String getCountry()
    {
        return Country;
    }

    public void setCountry(String country)
    {
        Country = country;
    }

    public String getAwards()
    {
        return Awards;
    }

    public void setAwards(String awards)
    {
        Awards = awards;
    }

    public String getDirector()
    {
        return Director;
    }

    public void setDirector(String director)
    {
        Director = director;
    }

    public String getActors()
    {
        return Actors;
    }

    public void setActors(String actors)
    {
        Actors = actors;
    }

    public String getTomatoConsensus()
    {
        return tomatoConsensus;
    }

    public void setTomatoConsensus(String tomatoConsensus)
    {
        this.tomatoConsensus = tomatoConsensus;
    }

    public String getTomatoMeter()
    {
        return tomatoMeter;
    }

    public void setTomatoMeter(String tomatoMeter)
    {
        this.tomatoMeter = tomatoMeter;
    }

    public String getImdbRating()
    {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating)
    {
        this.imdbRating = imdbRating;
    }
}
