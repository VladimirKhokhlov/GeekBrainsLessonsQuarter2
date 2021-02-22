package lesson2;

public class AppTest {
    static int sum = 0;

    public static void main(String[] args) {
        String[][] array4x4 = {{"1", "1", "1", "S"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}};
        try {
            arrayException(array4x4);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            return;
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sum);
    }

    private static void arrayException(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        if (strings.length != 4) throw new MyArraySizeException("Размер мессива не соответствует требованиям");
        for (int x = 0; x < strings.length; x++) {
            for (int y = 0; y < strings[x].length; y++) {
                if (strings[x].length != 4)
                    throw new MyArraySizeException("Размер мессива не соответствует требованиям");
                try {
                    sum += Integer.parseInt(strings[x][y]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке с индексом " + x + "." + y + " находится буква");
                }
            }
        }
    }
}