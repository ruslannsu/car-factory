package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
    UIController uiController;
    public SliderListener(UIController uiController) {
        this.uiController = uiController;
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        uiController.execute(((JSlider)(e).getSource()).getName(), ((JSlider)(e).getSource()).getValue());
        //System.out.println(((JSlider)(e).getSource()).getName());
    }
}

