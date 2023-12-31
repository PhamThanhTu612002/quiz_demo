package view;

import sound.Sound;

import javax.swing.*;
import java.awt.*;

public class Container {
    protected JPanel containerJp;
    private MainGameView gameView;
    private static final String TAG_MENU = "tag_menu";
    private static final String TAG_PLAYGAME = "tag_playgame";
    private static final String TAG_OPTION = "tag_option";
    private static final String TAG_HIGHTSCORE = "tag_hightscore";

    private CardLayout cardLayout;
    private MenuView menuView;
    private OptionView optionView;
    private PlaygameView playgameView;
    private HighScoreView highScoreView;


    public Container(MainGameView gameView) {
        this.gameView = gameView;
        containerJp = new JPanel();
        cardLayout = new CardLayout();
        containerJp.setLayout(cardLayout);
        menuView = new MenuView();
        containerJp.add(menuView.menuViewJp,TAG_MENU);
        optionView = new OptionView();
        containerJp.add(optionView.optionViewJp, TAG_OPTION);
        playgameView = new PlaygameView(this);
        containerJp.add(playgameView.playgameViewJp, TAG_PLAYGAME);
        highScoreView = new HighScoreView();
        containerJp.add(highScoreView.highScoreJp,TAG_HIGHTSCORE);
    }
    public void showMenu(){
        cardLayout.show(this.containerJp, TAG_MENU);
        menuView.menuViewJp.requestFocus();
        Sound.getInstance().stop();
        Sound.getInstance().getAudio(Sound.MENU).start();
        Sound.getInstance().getAudio(Sound.MENU).loop(10);
    }
    public void showOption(){
        cardLayout.show(this.containerJp, TAG_OPTION);
        optionView.optionViewJp.requestFocus();
    }
    public void showPlaygame(){
        playgameView.chooseActor();
        cardLayout.show(this.containerJp, TAG_PLAYGAME);
        playgameView.playgameViewJp.requestFocus();
    }
    public void showHighScore(){
        cardLayout.show(this.containerJp, TAG_HIGHTSCORE);
        highScoreView.highScoreJp.requestFocus();
    }

    public MenuView getMenu() {
        return menuView;
    }
    public OptionView getOption() {
        return optionView;
    }
    public PlaygameView getPlaygameView(){
        return playgameView;
    }

    public HighScoreView getHighScoreView() {
        return highScoreView;
    }
}
