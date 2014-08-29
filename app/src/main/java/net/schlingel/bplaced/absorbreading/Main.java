package net.schlingel.bplaced.absorbreading;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.schlingel.bplaced.absorbreading.presenter.ReaderPresenter;
import net.schlingel.bplaced.absorbreading.presenter.impl.StaticReaderPresenter;
import net.schlingel.bplaced.absorbreading.view.ReaderView;


public class Main extends ActionBarActivity implements ReaderView, View.OnClickListener {
    private ReaderPresenter presenter;
    private Button btnStart;
    private TextView txtVwWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(new StaticReaderPresenter());
        attachEventHandler();
    }

    private void attachEventHandler() {
        btnStart = (Button)findViewById(R.id.btnStart);
        txtVwWord = (TextView)findViewById(R.id.txtVwWord);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void showWord(String word) {
        final String w = word;

        txtVwWord.post(new Runnable() {
            @Override
            public void run() {
                txtVwWord.setText(w);
            }
        });
    }

    @Override
    public void setPresenter(ReaderPresenter presenter) {
        this.presenter = presenter;
        this.presenter.setView(this);
    }

    @Override
    public void onClick(View view) {
        this.presenter.onStartReading();
    }
}
