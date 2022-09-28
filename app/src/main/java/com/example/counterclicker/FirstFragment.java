package com.example.counterclicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.counterclicker.databinding.FragmentFirstBinding;

import java.sql.Array;

public class FirstFragment extends Fragment{


    private FragmentFirstBinding binding;
    int counh = Sharecontext.MyVar.counter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.Countshower.setText("Total Counts :" + Sharecontext.MyVar.counter);
        binding.Event1.setText(Sharecontext.MyVar.event1);
        binding.Event2.setText(Sharecontext.MyVar.event2);
        binding.Event3.setText(Sharecontext.MyVar.event3);
        binding.ShowCounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment=new SecondFragment();
                Bundle args=new Bundle();
                args.putInt("counter",Sharecontext.MyVar.counter);
                args.putIntegerArrayList("Counterarray",Sharecontext.MyVar.arrayList);
                secondFragment.setArguments(args);

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });
       binding.Settingsss.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ThirdFragment thirdfrag=new ThirdFragment();
               Bundle args=new Bundle();
               args.putInt("counter",Sharecontext.MyVar.counter);
               args.putIntegerArrayList("Counterarray",Sharecontext.MyVar.arrayList);
               thirdfrag.setArguments(args);

               NavHostFragment.findNavController(FirstFragment.this)
                       .navigate(R.id.action_FirstFragment_to_thirdFragment);

           }
       });
        binding.Event1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Sharecontext.MyVar.setCounter();
              Sharecontext.MyVar.setCounterarray(1);
                binding.Countshower.setText("Total Count: " +Sharecontext.MyVar.counter );

            }
        }));

        binding.Event2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharecontext.MyVar.setCounter();
                Sharecontext.MyVar.setCounterarray(2);
                binding.Countshower.setText("Total Count: " +Sharecontext.MyVar.counter );

            }
        }));
        binding.Event3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharecontext.MyVar.setCounter();
                Sharecontext.MyVar.setCounterarray(3);
                binding.Countshower.setText("Total Count: " +Sharecontext.MyVar.counter );

            }
        }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}