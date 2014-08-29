package net.schlingel.bplaced.absorbreading.model;

import net.schlingel.bplaced.absorbreading.presenter.ReaderPresenter;

/**
 * Created by zombie on 29.08.14.
 */
public interface ReaderModel {
    public void setPresenter(ReaderPresenter presenter);
    public String nextWord();
    public void setActive(boolean isActive);
}
