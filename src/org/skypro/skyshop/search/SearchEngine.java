package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private ArrayList<Searchable> Searchable = new ArrayList<>();

    public ArrayList<Searchable> search(String string) {
        ArrayList<Searchable> search = new ArrayList<>();
        for (Searchable searchable : Searchable) {
            if (searchable.searchTerm().contains(string)) {
                search.add(searchable);
            }
        }

        return search;
    }

    public void addSearchable(Searchable searchable) {
        Searchable.add(searchable);
    }

    public Searchable findBestMatch(String string) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : Searchable) {
            int count = countRepetition(searchable.searchTerm().toLowerCase(), string.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено ни одного результата поиска: " + string);
        }
        return bestMatch;
    }

    private int countRepetition(String str, String subStr) {
        int count = 0;
        int index = 0;
        index = str.indexOf(subStr, index);
        while (index != -1) {
            count++;
            index += subStr.length();
            index = str.indexOf(subStr, index);
        }
        return count;
    }
}


