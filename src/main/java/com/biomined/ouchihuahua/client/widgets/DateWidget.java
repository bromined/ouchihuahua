package com.biomined.ouchihuahua.client.widgets;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.MDateBox;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/23/13
 * Time: 1:07 PM
 */
public class DateWidget extends Composite implements HasValue<Date> {

    private MDateBox widget = new MDateBox();
    private Label label = new Label();

    public DateWidget(String text) {

        HorizontalPanel fieldLayout = new HorizontalPanel();

        label.setText(text);
        label.setStyleName("labelStyle");

        fieldLayout.add(label);

        fieldLayout.add(widget);

        initWidget(fieldLayout);
    }

    @Override
    public Date getValue() {
        return widget.getValue();
    }

    @Override
    public void setValue(Date value) {
        widget.setValue(value);
    }

    @Override
    public void setValue(Date value, boolean fireEvents) {
        widget.setValue(value, fireEvents);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> handler) {
        return widget.addValueChangeHandler(handler);
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        widget.fireEvent(event);
    }
}
