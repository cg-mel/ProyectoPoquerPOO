import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Object[] games = {"5 Card Draw", "Texas Hold 'Em"};
        int gameOption = JOptionPane.showOptionDialog(null, "Elige el juego", "Bienvenido a Poker", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, games, games[0]);
        switch(gameOption){
            case 0: new FiveCardDraw(); break;
            case 1: new TexasHoldEm(); break;
        }
    }
}