package combo_suggestion;

import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
    }

    public void setModel(String informatika) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
