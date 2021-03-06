package kg.geektech.homework340;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CountryFragment extends Fragment implements OnItemClick{
    private ArrayList<Continent> countries;
    private RecyclerView recyclerView;
    private ContinentAdapter adapter;
    private TextView test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String continent = bundle.getString(ContinentFragment.CONTINENT_KEY);
        loadData(continent);
        adapter = new ContinentAdapter(countries, this);
        recyclerView = view.findViewById(R.id.country_recycler);
        recyclerView.setAdapter(adapter);
    }

    private void loadData(String continent) {
        countries = new ArrayList<>();
        if (continent.equals(getString(R.string.Africa))) {
            loadAfrica();
        } else if (continent.equals(getString(R.string.Asia))) {
            loadAsia();
        } else if (continent.equals(getString(R.string.Europe))) {
            loadEurope();
        } else if (continent.equals(getString(R.string.North_America))) {
            loadNorthAmerica();
        } else if (continent.equals(getString(R.string.Oceania))) {
            loadOceania();
        } else if (continent.equals(getString(R.string.South_America))) {
            loadSouthAmerica();
        }
    }

    private void loadAfrica() {
        countries.add(new Continent("????????????", "https://www.countryflags.com/wp-content/uploads/nigeria-flag-png-large.png"));
        countries.add(new Continent("??????????????", "https://www.countryflags.com/wp-content/uploads/ethiopia-flag-png-large.png"));
        countries.add(new Continent("????????????", "https://www.countryflags.com/wp-content/uploads/egypt-flag-png-large.png"));
        countries.add(new Continent("??????????", "https://www.countryflags.com/wp-content/uploads/congo-democratic-republic-of-the-flag-png-large.png"));
        countries.add(new Continent("??????", "https://www.countryflags.com/wp-content/uploads/south-africa-flag-png-large.png"));
    }

    private void loadAsia() {
        countries.add(new Continent("??????????", "https://www.countryflags.com/wp-content/uploads/china-flag-png-large.png"));
        countries.add(new Continent("????????", "https://www.countryflags.com/wp-content/uploads/north-korea-flag-png-large.png"));
        countries.add(new Continent("?????????? ??????????", "https://www.countryflags.com/wp-content/uploads/south-korea-flag-png-large.png"));
        countries.add(new Continent("????????????????", "https://www.countryflags.com/wp-content/uploads/mongolia-flag-png-large.png"));
        countries.add(new Continent("????????????", "https://www.countryflags.com/wp-content/uploads/japan-flag-png-large.png"));
    }

    private void loadEurope() {
        countries.add(new Continent("??????????????", "https://www.countryflags.com/wp-content/uploads/flag-jpg-xl-10-2048x1365.jpg"));
        countries.add(new Continent("????????????????", "https://www.countryflags.com/wp-content/uploads/flag-jpg-xl-16-2048x1024.jpg"));
        countries.add(new Continent("????????????????", "https://www.countryflags.com/wp-content/uploads/germany-flag-png-large.png"));
        countries.add(new Continent("????????????", "https://www.countryflags.com/wp-content/uploads/italy-flag-png-large.png"));
        countries.add(new Continent("??????????????", "https://www.countryflags.com/wp-content/uploads/estonia-flag-png-large.png"));
    }

    private void loadNorthAmerica() {
        countries.add(new Continent("??????", "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png"));
        countries.add(new Continent("????????????????????", "https://www.countryflags.com/wp-content/uploads/greenland-flag-jpg-xl.jpg"));
        countries.add(new Continent("????????????", "https://www.countryflags.com/wp-content/uploads/canada-flag-png-large.png"));
        countries.add(new Continent("????????", "https://www.countryflags.com/wp-content/uploads/cuba-flag-png-large.png"));
        countries.add(new Continent("????????????", "https://www.countryflags.com/wp-content/uploads/jamaica-flag-png-large.png"));
    }

    private void loadOceania() {
        countries.add(new Continent("??????????????????", "https://www.countryflags.com/wp-content/uploads/flag-jpg-xl-9-2048x1024.jpg"));
        countries.add(new Continent("?????????? ????????????????", "https://www.countryflags.com/wp-content/uploads/new-zealand-flag-png-large.png"));
        countries.add(new Continent("??????????", "https://www.countryflags.com/wp-content/uploads/samoa-flag-png-large.png"));
        countries.add(new Continent("??????????", "https://www.countryflags.com/wp-content/uploads/fiji-flag-png-large.png"));
        countries.add(new Continent("??????????-?????????? ????????????", "https://www.countryflags.com/wp-content/uploads/papua-new-guinea-flag-png-large.png"));
    }

    private void loadSouthAmerica() {
        countries.add(new Continent("??????????????????", "https://www.countryflags.com/wp-content/uploads/flag-jpg-xl-7-2048x1283.jpg"));
        countries.add(new Continent("????????????????", "https://www.countryflags.com/wp-content/uploads/brazil-flag-png-large.png"));
        countries.add(new Continent("??????????????", "https://www.countryflags.com/wp-content/uploads/flag-jpg-xl-2048x1399.jpg"));
        countries.add(new Continent("????????????????", "https://www.countryflags.com/wp-content/uploads/colombia-flag-png-large.png"));
        countries.add(new Continent("????????", "https://www.countryflags.com/wp-content/uploads/peru-flag-png-large.png"));
    }

    @Override
    public void onItemClick(Continent continent) {
        Bundle bundle = getArguments();
        String continent2 = bundle.getString(ContinentFragment.CONTINENT_KEY);
        Toast.makeText(requireContext(), "?????? ???????????? ?? " + continent2, Toast.LENGTH_SHORT).show();
    }
}