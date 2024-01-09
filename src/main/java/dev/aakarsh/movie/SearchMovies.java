package dev.aakarsh.movie;

class SearchMovies
{
    private static SearchFields fields;
    private final Movie[] allTheMovies;
    private static int numberOfMovies;
    private final Movie[] matchedMovies;

    public Movie[] getMatchedMovies()
    {
        return matchedMovies;
    }

    public static int getNumberOfMatchedMovies()
    {
        return numberOfMatchedMovies;
    }

    private static int numberOfMatchedMovies;
    SearchMovies(SearchFields fields, Movie[] allTheMovies)
    {
        SearchMovies.fields = fields;
        this.allTheMovies = allTheMovies;
        SearchMovies.numberOfMovies = allTheMovies.length;
        matchedMovies = new Movie[numberOfMovies];
        numberOfMatchedMovies = 0;
        searchMoviesForMatch();
    }

    private void searchMoviesForMatch()
    {
        for(int i=0; i<numberOfMovies; i++)
        {
            String runtimeString = allTheMovies[i].getRuntime();
            String yearString = allTheMovies[i].getYear();
            String IMDBString = allTheMovies[i].getImdbRating();
            String rottenString = allTheMovies[i].getTomatoMeter();
            int iterRuntime, iterYear, iterRotten;
            String iterIMDB;
            iterRuntime = !runtimeString.equals("N/A") ? Integer.parseInt(runtimeString.replace("min", "").trim()) : SearchFields.getMinRunning();
            iterYear = !yearString.equals("N/A") ? Integer.parseInt(yearString) : SearchFields.getMinYear();
            iterRotten = !rottenString.equals("N/A") ? Integer.parseInt(rottenString) : SearchFields.getMinRotten();
            iterIMDB = !IMDBString.equals("N/A") ? IMDBString : SearchFields.getMinIMDB() + "";
            if(inRange(iterRuntime, SearchFields.getMinRunning(), SearchFields.getMaxRunning()))
            {
                if(inRange(iterYear, SearchFields.getMinYear(), SearchFields.getMaxYear()))
                {
                    if(inRange(iterRotten, SearchFields.getMinRotten(), SearchFields.getMaxRotten()))
                    {
                        if (inRange(iterIMDB, SearchFields.getMinIMDB(), SearchFields.getMaxIMDB()))
                        {
                            if(matchComboSearchFields(allTheMovies[i]))
                            {
                                matchedMovies[numberOfMatchedMovies++] = allTheMovies[i];
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean matchComboSearchFields(Movie currentMovie)
    {
        boolean actorFlag;
        boolean directorFlag;
        boolean genreFlag;
        String[] actors = getActorsForIter(currentMovie);
        String[] directors = getDirectorsForIter(currentMovie);
        String[] genre = getGenreForIter(currentMovie);
        actorFlag = SearchFields.getActor() == null || customContains(actors, SearchFields.getActor());
        directorFlag = SearchFields.getDirector() == null || customContains(directors, SearchFields.getDirector());
        genreFlag = SearchFields.getGenre() == null || customContains(genre, SearchFields.getGenre());
        return actorFlag && directorFlag && genreFlag;
    }

    private boolean customContains(String[] array, String key)
    {
        for(String item: array)
        {
            if(key.equalsIgnoreCase(item.trim()))
            {
                return true;
            }
        }
        return false;
    }

    private String[] getGenreForIter(Movie currentMovie)
    {
        return currentMovie.getGenre().split(",");
    }

    private String[] getDirectorsForIter(Movie currentMovie)
    {
        return currentMovie.getDirector().split(",");
    }

    private String[] getActorsForIter(Movie currentMovie)
    {
        return currentMovie.getActors().split(",");
    }

    private boolean inRange(int value, int minValue, int maxValue)
    {
        if(value >= minValue)
        {
            return value <= maxValue;
        }
        return false;
    }

    private boolean inRange(String value, int minValue, int maxValue)
    {
        int intValue = Integer.parseInt(value.charAt(0)+"");
        if(intValue >= minValue)
        {
            return intValue <= maxValue;
        }
        return false;
    }
}
