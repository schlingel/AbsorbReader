package net.schlingel.bplaced.absorbreading.view;

import net.schlingel.bplaced.absorbreading.presenter.ReaderPresenter;

/**
 * Created by zombie on 29.08.14.
 */
public interface ReaderView {
    public void showWord(String Word);
    public void setPresenter(ReaderPresenter presenter);
}
