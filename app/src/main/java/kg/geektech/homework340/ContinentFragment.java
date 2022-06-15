package kg.geektech.homework340;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ContinentFragment extends Fragment implements OnItemClick{
    private ArrayList<Continent> continents;
    private RecyclerView recyclerView;
    private ContinentAdapter adapter;
    public static final String CONTINENT_KEY = "continent";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_continent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentAdapter(continents, this);
        recyclerView = view.findViewById(R.id.continent_recycler);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        continents = new ArrayList<>();
        continents.add(new Continent(getString(R.string.Africa), "https://i.imgur.com/eYbvaGT.png"));
        continents.add(new Continent(getString(R.string.Asia), "https://i.imgur.com/lblIwxp.png"));
        continents.add(new Continent(getString(R.string.Europe), "https://i.imgur.com/DHFCbWj.png"));
        continents.add(new Continent(getString(R.string.North_America), "https://i.imgur.com/AhvKmMF.png"));
        continents.add(new Continent(getString(R.string.Oceania), "https://i.imgur.com/UwOaRHi.png"));
        continents.add(new Continent(getString(R.string.South_America), "https://i.imgur.com/lXLYCiD.png"));
    }

    @Override
    public void onItemClick(Continent continent) {
        Bundle bundle = new Bundle();
        String continentName = continent.getNameContinent();
        bundle.putString(CONTINENT_KEY, continentName);
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, countryFragment).commit();
    }


    //https://i.imgur.com/eYbvaGT.png africa
    //https://imgur.com/a/JHUTBci asia
    //https://imgur.com/a/1kqm2RS europe
    //https://imgur.com/a/iT9ROXN north america
    //https://imgur.com/a/VhtWCaB oceania
    //https://imgur.com/a/UhWgIWj south america
}