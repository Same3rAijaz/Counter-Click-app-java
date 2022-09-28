package com.example.counterclicker;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.counterclicker.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {





        private FragmentThirdBinding binding;



    @Override
        public View onCreateView(
                LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState
        ) {

            binding = FragmentThirdBinding.inflate(inflater, container, false);
            return binding.getRoot();

        }
        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);


            binding.SaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sharecontext.MyVar.setEvent1(binding.Editnameforevent1.getText().toString());
                    Sharecontext.MyVar.setEvent2(binding.Editnameforevent2.getText().toString());
                    Sharecontext.MyVar.setEvent3(binding.Editnameforevent3.getText().toString());
                    Sharecontext.MyVar.setCountermax(Integer.parseInt(binding.Counterupd.getText().toString()));
                    NavHostFragment.findNavController(ThirdFragment.this)
                            .navigate(R.id.action_thirdFragment_to_FirstFragment);
                }
            });

        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }


    }


