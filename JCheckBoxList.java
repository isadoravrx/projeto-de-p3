import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JCheckBoxList<E> extends JPanel {
    private List<JCheckBox> checkBoxes;

    public JCheckBoxList(List<E> items) {
        setLayout(new GridLayout(0, 1)); // Define o layout como uma coluna

        checkBoxes = new ArrayList<>();

        for (E item : items) {
            JCheckBox checkBox = new JCheckBox(item.toString());
            checkBoxes.add(checkBox);
            add(checkBox);
        }
    }

    public List<E> getSelectedItems() {
        List<E> selectedItems = new ArrayList<>();

        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedItems.add((E) checkBox.getText());
            }
        }

        return selectedItems;
    }
}

