package com.example.task2_mobile;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task2_mobile.databinding.ActivityMainBinding;
import com.example.task2_mobile.databinding.FragmentSecondpageMainBinding;
import com.example.task2_mobile.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondpageMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondpageMainFragment extends Fragment {
    View SecondpageFragment;
    private FragmentSecondpageMainBinding mBinding;
    private List<String> nbaTeamsItemName;
    private MainViewModel mMainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SecondpageFragment = inflater.inflate(R.layout.fragment_secondpage_main, container, false);


        mBinding = FragmentSecondpageMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        nbaTeamsItemName = new ArrayList<>();

        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mMainViewModel.callApi();
        mMainViewModel.getNbaTeams().observe(this, nbaTeamItemResponseItems -> {
            mBinding.rvNbaTeams.setAdapter(new ViewTeamAdapter(nbaTeamItemResponseItems));
        });

        return SecondpageFragment;
    }
}