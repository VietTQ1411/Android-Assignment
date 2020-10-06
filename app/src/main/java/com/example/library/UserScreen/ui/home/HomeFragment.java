package com.example.library.UserScreen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.ConmonInterface.IActivity;
import com.example.library.Entity.BookModel;
import com.example.library.R;
import com.example.library.UserScreen.ui.home.adapters.BookAdapter;
import com.example.library.viewModel.BookActivityViewModel;

import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView bookRecyclerView;
    private BookActivityViewModel booksActivityViewModel;
    private RecyclerView.Adapter recyclerViewAdapter;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        //root.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setupUI(root);
        return root;
    }

    public void setupUI(View view) {
        bookRecyclerView = view.findViewById(R.id.bookRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getActivity().getApplicationContext(),
                RecyclerView.VERTICAL,false);
        bookRecyclerView.setLayoutManager(layoutManager);
        booksActivityViewModel = (new ViewModelProvider(this))
                .get(BookActivityViewModel.class);
        booksActivityViewModel.init();

        final BookAdapter bookAdapter = new BookAdapter(
                getActivity(),
                BookModel.generateFakeBooks()
        );
        booksActivityViewModel.getBooks().observe((LifecycleOwner) view,
                new Observer<List<BookModel>>() {
                    @Override
                    public void onChanged(List<BookModel> books) {
                        bookAdapter.notifyDataSetChanged();
                    }
                }
        );
        bookRecyclerView.setAdapter(bookAdapter);
    }
}