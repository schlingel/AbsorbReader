package net.schlingel.bplaced.absorbreading.model.impl;

import net.schlingel.bplaced.absorbreading.model.ReaderModel;
import net.schlingel.bplaced.absorbreading.presenter.ReaderPresenter;

/**
 * Created by zombie on 29.08.14.
 */
public class StaticReaderModel implements ReaderModel {
    // part of the article: http://www.spiegel.de/international/germany/german-considers-turkey-to-be-official-target-for-spying-a-986656.html
    private static final String[] WORDS = new String[] {
            "For", "more", "than", "a", "year", "now,", "German", "officials", "have", "criticized", "the", "US", "for", "the", "NSA's", "mass", "spying", "on", "Europeans", "and", "even", "Chancellor", "Angela", "Merkel.", "Now,", "embarrassing", "revelations", "show", "that", "Germany", "has", "inadvertently", "spied", "on", "Hillary", "Clinton", "and", "John", "Kerry,", "and", "has", "also", "deliberately", "targeted", "Turkey.",
            "It", "was", "mid-July,", "and", "the", "German", "government", "had", "something", "it", "could", "be", "a", "bit", "proud", "of.", "For", "the", "first", "time", "in", "the", "never-ending", "spying", "affair,", "it", "had", "reacted", "quickly,", "unanimously", "and", "toughly.", "A", "spy", "for", "the", "Americans", "had", "been", "exposed", "inside", "Germany's", "foreign", "intelligence", "service,", "the", "Bundesnachrichtendienst", "(BND),", "and", "the", "government", "in", "Berlin", "ordered", "the", "CIA's", "top", "official", "in", "Germany", "to", "leave", "the", "country,", "demonstrating", "to", "Washington", "that", "it", "refused", "to", "put", "up", "with", "just", "anything.", "Berlin", "seemed", "to", "be", "going", "on", "the", "offensive.",
    };

    private ReaderPresenter presenter;
    private int currentWord = 0;
    private ModelTimer timerThread;

    public StaticReaderModel() {
        this.timerThread = null;
    }

    @Override
    public void setPresenter(ReaderPresenter presenter) {
        this.presenter = presenter;
        this.timerThread = new ModelTimer(this, presenter);
    }

    @Override
    public String nextWord() {
        return currentWord >= WORDS.length ? null : WORDS[currentWord++];
    }

    @Override
    public void setActive(boolean isActive) {
        if(isActive) {
            startTimerIfPossible();
        }
    }

    private void startTimerIfPossible() {
        if(timerThread != null && timerThread.isStartNeeded()) {
            timerThread.start();
        }
    }
}
