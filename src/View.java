import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class View implements Initializable {


    final int INITIAL_VALUE = 1;

    public Spinner <Integer> firstNumber;


    SpinnerValueFactory<Integer> firstRandom = new SpinnerValueFactory.IntegerSpinnerValueFactory(3, 10, INITIAL_VALUE);

    public Spinner <Integer> secondNumber;
    SpinnerValueFactory<Integer> secondRandom = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,10, INITIAL_VALUE);


    // textarea fro add text's
    public TextArea showResult;
    public TextArea addEvenNumbers;


    // random numbers empty array
    int[] randomNumbersArr = new int[20];

    public void handleGenerateNumbers(ActionEvent actionEvent) {

        // get Numbers value
        int firstNumValue = firstNumber.getValue();
        int secondNumValue = secondNumber.getValue();
        // get Numbers value


        Random rd = new Random();

        showResult.clear();
        showResult.appendText("შემთხვევითი რიცხვები [N;M] შუალედიდან  : ");
        for(int i = 0 ; i < 20 ; i++) {
            int randomNumbers = rd.nextInt(firstNumValue, secondNumValue);
            showResult.appendText(String.valueOf(randomNumbers) + " ");
            randomNumbersArr[i] = randomNumbers;
        }
        showResult.appendText("\n");

        // counting most repeated numbers in array


        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : randomNumbersArr) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }

        int maxCount = 0;
        int modeNumber = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                modeNumber = entry.getKey();
            }
        }


        showResult.appendText("ლისტში ყველაზე ხშირად გამეორებადი რიცხვებია : ");
        showResult.appendText(String.valueOf(modeNumber));
        showResult.appendText("\n");

        // counting most repeated numbers in array

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNumber.setValueFactory(firstRandom);
        secondNumber.setValueFactory(secondRandom);
    }

    public void handleDeleteOddNumbers(ActionEvent actionEvent) {

        // luwi ricxvebis washla
        addEvenNumbers.clear();

        for(int i = 0 ; i < randomNumbersArr.length; i++){
            if(randomNumbersArr[i] % 2 != 0){
                addEvenNumbers.appendText( String.valueOf(randomNumbersArr[i]) + " ");
            }
        }


    }
}
