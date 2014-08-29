package net.schlingel.bplaced.absorbreading.model.impl;

import android.util.Log;

import net.schlingel.bplaced.absorbreading.model.ReaderModel;
import net.schlingel.bplaced.absorbreading.presenter.ReaderPresenter;

/**
 * Created by zombie on 29.08.14.
 */
public class ModelTimer extends Thread {
    private static final long PAUSE_IN_MS = 120;
    private ReaderPresenter presenter;
    private ReaderModel model;
    private boolean isStartNeeded;

    public ModelTimer(ReaderModel model, ReaderPresenter presenter) {
        this.presenter = presenter;
        this.model = model;
        this.isStartNeeded = true;
    }

    @Override
    public void run() {
        isStartNeeded = false;

        while(true) {
            String currentWord = model.nextWord();
            boolean hasReachedLastWord = currentWord == null;

            if(hasReachedLastWord) {
                presenter.onNextWord("FINISH");
                return;
            }

            presenter.onNextWord(currentWord);

            sleep();
        }
    }

    public boolean isStartNeeded() {
        return isStartNeeded;
    }

    private void sleep() {
        try {
            Thread.currentThread().sleep(PAUSE_IN_MS);
        } catch (InterruptedException e) {
        }
    }
}
