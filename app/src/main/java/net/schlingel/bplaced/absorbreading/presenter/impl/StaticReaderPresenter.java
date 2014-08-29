package net.schlingel.bplaced.absorbreading.presenter.impl;

import net.schlingel.bplaced.absorbreading.model.ReaderModel;
import net.schlingel.bplaced.absorbreading.model.impl.StaticReaderModel;
import net.schlingel.bplaced.absorbreading.presenter.ReaderPresenter;
import net.schlingel.bplaced.absorbreading.view.ReaderView;

/**
 * Created by zombie on 29.08.14.
 */
public class StaticReaderPresenter implements ReaderPresenter {
    private ReaderView view;
    private ReaderModel model;

    public StaticReaderPresenter() {
        setModel(new StaticReaderModel());
    }

    @Override
    public void setModel(ReaderModel model) {
        this.model = model;
        this.model.setPresenter(this);
    }

    @Override
    public void setView(ReaderView view) {
        this.view = view;
    }

    @Override
    public void onNextWord(String word) {
        this.view.showWord(word);
    }

    @Override
    public void onStartReading() {
        this.model.setActive(true);
    }
}
