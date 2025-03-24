package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] Searchable;

    public Searchable[] search(String string) {
        int i = 0;
        Searchable[] search = new Searchable[5];
        for (org.skypro.skyshop.search.Searchable searchable : Searchable) {
            if (searchable != null && searchable.searchTerm().contains(string) && i < 5) {
                search[i] = searchable;
                i++;
            }
        }
        return search;
    }

    public void addSearchable(Searchable searchable) {
        for (int i = 0; i < Searchable.length; i++) {
            if (Searchable[i] == null) {
                Searchable[i] = searchable;
                break;
            }
        }
    }

    public SearchEngine(int size) {
        this.Searchable = new Searchable[size];
    }
}
