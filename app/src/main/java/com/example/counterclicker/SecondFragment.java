package com.example.counterclicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.counterclicker.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;




public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    int oner=0;
    int twoner=0;
    int threener=0;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState


    ) {

//

        int Counter = Sharecontext.MyVar.counter;
        ArrayList<Integer> arrayList = null;
        arrayList = Sharecontext.MyVar.arrayList;
//        View contentView = inflater.inflate(R.layout.fragment_second, container, false);
//        ListView listViews= contentView.findViewById(R.id.lister);


        for (int i = 0; i < arrayList.size(); i++){
            // Printing and display the elements in ArrayList
            if (arrayList.get(i)== 1){
                oner+=1;
            }else if (arrayList.get(i)== 2){
                twoner+=1;
            }else if (arrayList.get(i)== 3){
                threener+=1;
            }
            System.out.print(arrayList.get(i) + ":  " + i);
    }




        binding = FragmentSecondBinding.inflate(inflater, container, false);

        binding.textView.setText(Sharecontext.MyVar.event1 + ":"  + Integer.toString(oner));
        binding.textView2.setText(Sharecontext.MyVar.event2 + " : " + Integer.toString(twoner));
        binding.textView3.setText(Sharecontext.MyVar.event3 + " : " + Integer.toString(threener));
        binding.textView4.setText("Total Counts : " + Sharecontext.MyVar.counter);


        List<String> list = new ArrayList<>();

        for(int i = 0; i<Sharecontext.MyVar.arrayList.size(); i++)
            if (Sharecontext.MyVar.arrayList.get(i)==1)
                list.add(Sharecontext.MyVar.event1);
            else if (Sharecontext.MyVar.arrayList.get(i)==2)
                list.add(Sharecontext.MyVar.event2);
            else if(Sharecontext.MyVar.arrayList.get(i)==3)
                list.add(Sharecontext.MyVar.event3);
        CustomAdapter listAdapter = new CustomAdapter(list);
        binding.lister.setAdapter(listAdapter);
        return binding.getRoot();
//            return  contentView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    class CustomAdapter extends BaseAdapter {
        List<String> items;

        public CustomAdapter(List<String> items) {
            super();
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return items.get(i).hashCode();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(getContext());
            textView.setText(items.get(i));
            return textView;
        }
    }

}