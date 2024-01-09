package dev.aakarsh.movie;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("ALL")
class SeedFromJSON
{
    /*
    Public TreeSets for the AutoComplete TB and the Range Sliders
     */
    public static TreeSet sortedActorList;
    public static TreeSet sortedDirectorList;
    public static TreeSet sortedGenreList;
    public static TreeSet sortedYearList;
    public static TreeSet sortedRunningTimeList;
    public static TreeSet sortedIMDBList;
    public static TreeSet sortedRottenList;
    /*
    Public Lists for Searching
     */
    public static List indexedMovieNameList;
    public static List indexedActorList;
    public static List indexedDirectorList;
    public static List indexedGenreList;
    public static List indexedYearList;
    public static List indexedRunningTimeList;
    public static List indexedIMDBList;
    public static List indexedRottenList;

    public static int getNumberOfMovies()
    {
        return numberOfMovies;
    }

    /*
        Array of Movie Objects
         */
    private static int numberOfMovies;

    static Movie[] getAllTheMovies()
    {
        return allTheMovies;
    }

    private static Movie[] allTheMovies;

    SeedFromJSON() throws JSONException
    {
        String fileName = "src/main/resources/movieData.json";
        String content= "";
        FileInputStream f = null;
        try
        {
            content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        JSONArray allJSONData = new JSONObject(content).getJSONArray("movie");
        numberOfMovies = allJSONData.length();
        sortedActorList = getMeAllSortedNames(allJSONData, "Actors");
        sortedDirectorList = getMeAllSortedNames(allJSONData, "Director");
        sortedGenreList = getMeAllSortedNames(allJSONData, "Genre");
        for (Iterator iterator = sortedGenreList.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(next.toString());
        }
        sortedYearList = getMeAllTheNumbers(allJSONData, "Year");
        sortedRunningTimeList = getMeAllRunningTimes(allJSONData);
        sortedIMDBList = getMeAllIMDBRatings(allJSONData);
        sortedRottenList = getMeAllTheNumbers(allJSONData, "tomatoMeter");
        indexAllMovies(allJSONData);
    }
    /*
    1. indexAllLists
    2. PopulateCBs
    3. setGUI
    4. Sliders
    5. searchInJSON
    6. setUpAJSONSearchSHIT
     */
    private void indexAllMovies(JSONArray allJSONData) throws JSONException
    {
        allTheMovies = new Movie[numberOfMovies];
        for (int i = 0; i < numberOfMovies; i++)
        {
            allTheMovies[i] = new Movie();
            JSONObject jsonObjectIter = allJSONData.getJSONObject(i);
            allTheMovies[i].setTitle(jsonObjectIter.getString("Title"));
            allTheMovies[i].setYear(jsonObjectIter.getString("Year"));
            allTheMovies[i].setReleased(jsonObjectIter.getString("Released"));
            allTheMovies[i].setRuntime(jsonObjectIter.getString("Runtime"));
            allTheMovies[i].setGenre(jsonObjectIter.getString("Genre"));
            allTheMovies[i].setDirector(jsonObjectIter.getString("Director"));
            allTheMovies[i].setActors(jsonObjectIter.getString("Actors"));
            allTheMovies[i].setPlot(jsonObjectIter.getString("Plot"));
            allTheMovies[i].setLanguage(jsonObjectIter.getString("Language"));
            allTheMovies[i].setCountry(jsonObjectIter.getString("Country"));
            allTheMovies[i].setAwards(jsonObjectIter.getString("Awards"));
            allTheMovies[i].setPoster(jsonObjectIter.getString("Poster"));
            allTheMovies[i].setImdbRating(jsonObjectIter.getString("imdbRating"));
            allTheMovies[i].setTomatoMeter(jsonObjectIter.getString("tomatoMeter"));
            allTheMovies[i].setTomatoConsensus(jsonObjectIter.getString("tomatoConsensus"));
        }
    }

    private static TreeSet getMeAllRunningTimes(JSONArray allJSONData) throws JSONException
    {
        Set<Integer> setForRunningTime = new HashSet<Integer>();
        for(int i = 0 ; i < allJSONData.length() ; i++)
        {
            String runTime = allJSONData.getJSONObject(i).getString("Runtime");
            if(runTime.equals("N/A"))
                continue;
            runTime = runTime.replace("min","").trim();
            setForRunningTime.add(Integer.parseInt(runTime));
        }
        TreeSet sortedRunningList = new TreeSet();
        sortedRunningList.addAll(setForRunningTime);
        return sortedRunningList;
    }

    private static TreeSet getMeAllIMDBRatings(JSONArray allJSONData) throws JSONException
    {
        Set<Double> setForIMDB = new HashSet<Double>();
        for (int i = 0; i < allJSONData.length(); i++)
        {
            String rating = allJSONData.getJSONObject(i).getString("imdbRating");
            if(rating.equals("N/A"))
                continue;
            double imdb = Double.parseDouble(rating);
            setForIMDB.add(imdb);
        }
        TreeSet sortedIMDBList = new TreeSet();
        sortedIMDBList.addAll(setForIMDB);
        return sortedIMDBList;
    }

    private static TreeSet getMeAllTheNumbers(JSONArray allJSONData, String key) throws JSONException
    {

        Set<Integer> setForNumbers = new HashSet<Integer>();
        for(int i = 0 ; i < allJSONData.length() ; i++)
        {
            String number = allJSONData.getJSONObject(i).getString(key);
            System.out.println(allJSONData.getJSONObject(i).getString("Title"));

            if(number.equals("N/A"))
                continue;
            int num = Integer.parseInt(number);
            setForNumbers.add(num);
        }
        TreeSet sortedNumberList = new TreeSet();
        sortedNumberList.addAll(setForNumbers);
        return sortedNumberList;
    }

    private static TreeSet getMeAllSortedNames(JSONArray allJSONData, String key) throws JSONException
    {
        Set<String> placeHolderForNames = new HashSet<String>();
        for(int i = 0 ; i < allJSONData.length() ; i++)
        {
            String namesDump = allJSONData.getJSONObject(i).getString(key);
            String listOfNames [] = namesDump.split(",");
            for(String name: listOfNames)
            {
                if(name.equals("N/A"))
                    continue;
                placeHolderForNames.add(name.trim());
            }
        }
        TreeSet sortedNameList = new TreeSet();
        sortedNameList.addAll(placeHolderForNames);
        return sortedNameList;
    }
}
