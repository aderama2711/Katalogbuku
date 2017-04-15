package com.example.adrama.katalogbuku_ramadha.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adrama.katalogbuku_ramadha.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookFormActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_title)
    EditText edittitle;
    @BindView(R.id.edit_author)
    EditText editauthor;
    @BindView(R.id.edit_genre)
    EditText editgenre;
    @BindView(R.id.edit_isbn)
    EditText editisbn;
    @BindView(R.id.edit_year)
    EditText edityear;
    @BindView(R.id.edit_synopsis)
    EditText editsynopsis;
    @BindView(R.id.btn_submit)
    EditText btnsubmit;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_form_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnsubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (validate()) {
                    Toast.makeText(BookFormActivity.this, "Data Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private boolean validate() {
        boolean valid = true;

        String isbn = editisbn.getText().toString();
        String booktitle = edittitle.getText().toString();
        String bookauthor = editauthor.getText().toString();
        String publishedyear = edityear.getText().toString();

        if (isbn.isEmpty()) {
            editisbn.setError("Enter ISBN");
            valid = false;
        } else {
            editisbn.setError(null);
        }

        if (booktitle.isEmpty()) {
            edittitle.setError("Enter Book Title");
            valid = false;
        } else {
            edittitle.setError(null);
        }

        if (bookauthor.isEmpty()) {
            editauthor.setError("Enter Book Author");
            valid = false;
        } else {
            editauthor.setError(null);
        }
        if (publishedyear.isEmpty() || publishedyear.length() < 4) {
            edityear.setError("Published Year Empty or must in YYYY format");
            valid = false;
        } else {
            edityear.setError(null);
        }
        return valid;
    }

}
