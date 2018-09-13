package com.game.millerstar.matchitnow;

import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {

    // For testing only!!!!!
    private static long SEED = -1;

    // class members
    private List<Card> cardDeck;
    private int deckSize;
    private final String[] drawableArray;

    // constructor
    public CardDeck(Level level) {
        this.drawableArray = new String[]{"chess_card_image", "classic_game_boy_card_image", "classic_game_watch_pad_card_image",
                "classic_gray_joystick_card_image", "domino_card_image", "double_game_watch_card_image", "five_dice_card_image",
                "game_board_card_image", "game_cards_image", "game_consul_card_image", "girl_card_image", "goblet_card_image",
                "gray_game_pad_card_image", "gray_game_watch_pad_card_image", "gray_joystick_card_image", "gray_monitor_card_image",
                "mixed_card_image", "mobile_phone_card_image", "orange_game_watch_pad_card_image", "pro_joystick_card_image",
                "retro_gamepad_card_image", "robot_card_image", "round_game_watch_pad_card_image", "round_gray_joystick_card_image",
                "round_joystick_card_image", "roundblue_dpad_card_image", "sd_case_card_image", "simple_game_watch_pad_card_image",
                "square_white_dpad_card_image", "tv_card_image", "wheel_card_image", "white_game_consul_card_image", "white_game_pad_card_image",
                "white_game_watch_pad_card_image", "wired_joystick_card_image", "xmix_card_image"};
        this.deckSize = level.getNumOfCards();
        this.cardDeck = new ArrayList<>();
        try {
            this.cardDeck = this.generateCardDeck();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // getters
    public List<Card> getCardDeck() {
        return cardDeck;
    }

    @VisibleForTesting
    static void setRandomSeed(long seed) {
        SEED = seed;
    }

    // methods
    private List<Card> generateCardDeck() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < this.deckSize; i++) {
            Card card = new Card(getDrawable(drawableArray[i]));
            cardDeck.add(card);
        }

        shuffleCards(cardDeck);
        return cardDeck;
    }

    private void shuffleCards(List<Card> cardDeck) {
        Random rand = SEED > 0 ? new Random(SEED) : new Random();

        Collections.shuffle(cardDeck, rand);
    }

    private int getDrawable(String name) throws NoSuchFieldException, IllegalAccessException {
        return R.drawable.class.getField(name).getInt(null);
    }

}
