package com.biomined.ouchihuahua.client.widgets;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/9/13
 * Time: 11:31 AM
 */
public class RememberMeCheckbox extends Composite implements HasValue<Boolean> {

    private final MCheckBox widget = new MCheckBox();
    private final Label label = new Label();

    public RememberMeCheckbox(String text) {

        HorizontalPanel fieldLayout = new HorizontalPanel();

        label.setText(text);
        label.setStyleName("labelStyle");

        fieldLayout.add(label);

        fieldLayout.add(widget);

        initWidget(fieldLayout);

    }

    @Override
    public Boolean getValue() {
        return widget.getValue();
    }

    @Override
    public void setValue(Boolean value) {
        widget.setValue(value);
    }

    @Override
    public void setValue(Boolean value, boolean fireEvents) {
        widget.setValue(value, fireEvents);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
        return widget.addValueChangeHandler(handler);
    }
}
