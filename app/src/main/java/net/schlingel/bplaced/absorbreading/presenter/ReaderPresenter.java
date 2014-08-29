package net.schlingel.bplaced.absorbreading.presenter;

import net.schlingel.bplaced.absorbreading.model.ReaderModel;
import net.schlingel.bplaced.absorbreading.view.ReaderView;

/**
 * Created by zombie on 29.08.14.
 */
public interface ReaderPresenter {
    public void setModel(ReaderModel model);
    public void setView(ReaderView view);
    public void onNextWord(String word);
    public void onStartReading();
}
