package net.rimaki.emotax.gui;

import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.element.custom.ElementDropdown;
import cn.nukkit.form.element.custom.ElementInput;
import cn.nukkit.form.element.custom.ElementSlider;
import cn.nukkit.form.element.custom.ElementStepSlider;
import cn.nukkit.form.window.CustomForm;

import java.util.ArrayList;
import java.util.List;

public class EmotaXCFGMenu extends CustomForm {

    public EmotaXCFGMenu() {
        super("EmotaX Menu"); // Set title

        // Steps for StepSlider
        List<String> steps = new ArrayList<>();
        steps.add("1");
        steps.add("2");

        // Options for Dropdown
        List<String> options = new ArrayList<>();
        options.add("a");
        options.add("b");

        // Create elements
        ElementDropdown dropdown = new ElementDropdown("Select", options);
        ElementInput input = new ElementInput("Enter something", "Default text", "Optional text");
        ElementLabel label = new ElementLabel("This is a label");

        float min = 0.0F;
        float max = 10.0F;
        int step = 1;
        float defaultValue = 2.0F;
        ElementSlider slider = new ElementSlider("Slide me", min, max, step, defaultValue);

        ElementStepSlider stepSlider = new ElementStepSlider("Choose a step", steps, 1);

        // Add elements to this form
        this.addElement(dropdown);
        this.addElement(input);
        this.addElement(label);
        this.addElement(slider);
        this.addElement(stepSlider);
    }
}