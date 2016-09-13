package com.biomined.ouchihuahua.client.widgets;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.MIntegerBox;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/23/13
 * Time: 1:10 PM
 */
public class IntegerWidget extends Composite implements HasValue<Integer> {

    private MIntegerBox widget = new MIntegerBox();
    private Label label = new Label();

    public IntegerWidget(String text) {

        HorizontalPanel fieldLayout = new HorizontalPanel();

        label.setText(text);
        label.setStyleName("labelStyle");

        fieldLayout.add(label);

        fieldLayout.add(widget);

        initWidget(fieldLayout);
    }

    @Override
    public Integer getValue() {
        return widget.getValue();
    }

    @Override
    public void setValue(Integer value) {
        widget.setValue(value);
    }

    @Override
    public void setValue(Integer value, boolean fireEvents) {
        widget.setValue(value, fireEvents);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Integer> handler) {
        return widget.addValueChangeHandler(handler);
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        widget.fireEvent(event);
    }
}
