package com.hunter.utils;

import com.hunter.GameController;
import com.hunter.actions.Action;

import java.util.Scanner;

public class PlayerListener extends PlayerSpeaker {

    static Scanner scanner = new Scanner(System.in);


    public static int readANumber(String forWhat, int maxValue) {
        int aNumber = 0;
        while (aNumber == 0) {
            speak(forWhat);
            if (scanner.hasNextInt()) {
                int inputValue = scanner.nextInt();
                if ( (maxValue < 0 && inputValue > 0) || (inputValue > 0 && inputValue < maxValue)) {
                    aNumber = inputValue;
                } else {
                    speak("Entered number is out of limit. Has to be greater than 0 and less than: " + maxValue);
                }
            } else {
                speak("Not a valid Number");
                scanner.next();
            }
        }
        return aNumber;
    }

    public static Action readAction() {
        Action action = null;
        while (action == null) {
            if (scanner.hasNext()) {
                action = GameController.findAction( scanner.next());
            }
        }
        return action;
    }
}
