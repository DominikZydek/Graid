import java.awt.*;

public class CustomLayoutManager {
    public static GridBagConstraints createGridBagConstraints(int gridx, int gridy, Insets insets) {
        GridBagConstraints gbc = createGridBagConstraints(gridx, gridy);
        gbc.insets = insets;
        return gbc;
    }
    public static GridBagConstraints createGridBagConstraints(int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        return gbc;
    }
}
