package pl.kuglin.algorithm;

import org.junit.Test;
import pl.kuglin.Utilities;

import static org.junit.Assert.assertTrue;

public class ArrayElementSelectionTest {

    private Double[] array = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};

    @Test
    public void selectNElement() {

        boolean isProperOrder = true;
        Double currentElement;
        Double previousElement = Utilities.selectElementFromArray(array, 1);

        for (int i = 1; i < array.length; i++) {
            currentElement = Utilities.selectElementFromArray(array, i + 1);
            if (currentElement < previousElement) {
                isProperOrder = false;
                break;
            }
            previousElement = currentElement;
        }

        assertTrue(isProperOrder);
    }

    @Test
    public void selectNElementReverseOrder() {

        boolean isProperOrder = true;
        Double currentElement;
        Double previousElement = Utilities.selectElementFromArray(array, array.length);

        for (int i = array.length - 1; i > 0; i--) {
            currentElement = Utilities.selectElementFromArray(array, i);
            if (currentElement > previousElement) {
                isProperOrder = false;
                break;
            }
            previousElement = currentElement;
        }

        assertTrue(isProperOrder);
    }
}