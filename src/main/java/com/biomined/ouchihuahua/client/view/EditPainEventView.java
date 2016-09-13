package com.biomined.ouchihuahua.client.view;

import com.biomined.ouchihuahua.client.presenter.EditEventPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.*;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarSpacer;

import java.util.Date;

public class EditPainEventView extends Composite implements EditEventPresenter.Display {

    //TODO:look at ElementsViewImpl in mgwt showcase
//    private List<StringTag> tags = new ArrayList<StringTag>();    //https://code.google.com/p/gwt-comp-tagging/

    private MDateBox creationDate = new MDateBox();
    private MDateBox onsetDate = new MDateBox();

    private MSlider severity = new MSlider();
    private MIntegerBox hoursSlept = new MIntegerBox();

    private MTextBox painType = new MTextBox();
    private MTextBox location = new MTextBox();
    private MTextBox notes = new MTextBox();
    private MTextBox tags = new MTextBox();
    private MTextBox remedies = new MTextBox();

    private Button saveButton = new Button("save");
    private Button cancelButton = new Button("cancel");
    private Button deleteButton = new Button("delete");

    private static final String DATE_FORMAT = "MMM d, yyyy HH:mm";

    public EditPainEventView() {

        LayoutPanel main = new LayoutPanel();
        ScrollPanel scrollPanel = new ScrollPanel();
        ButtonBar footerPanel = new ButtonBar();

        saveButton.setRound(true);
        cancelButton.setRound(true);
        deleteButton.setRound(true);

        footerPanel.add(new ButtonBarSpacer());
        footerPanel.add(saveButton);
        footerPanel.add(cancelButton);
        footerPanel.add(deleteButton);
        footerPanel.add(new ButtonBarSpacer());

        main.add(scrollPanel);
        main.add(footerPanel);

        FlowPanel container = new FlowPanel();
        WidgetList widgetList = new WidgetList();
        widgetList.setRound(true);
        container.add(widgetList);

        scrollPanel.add(container);

        creationDate.setReadOnly(true);
        location.setReadOnly(true);
        severity.setMax(10);
        creationDate.setFormat(DATE_FORMAT);
        onsetDate.setFormat(DATE_FORMAT);

        widgetList.add(new FormListEntry("Creation Date", creationDate));
        widgetList.add(new FormListEntry("Onset Date", onsetDate));
        widgetList.add(new FormListEntry("Severity", severity));
        widgetList.add(new FormListEntry("Pain Type", painType));
        widgetList.add(new FormListEntry("Hours Slept", hoursSlept));
        widgetList.add(new FormListEntry("Location", location));
        widgetList.add(new FormListEntry("Notes", notes));
        widgetList.add(new FormListEntry("Tags", tags));
        widgetList.add(new FormListEntry("Remedies", remedies));

        initWidget(main);
    }


    @Override
    public HasTapHandlers getSaveButton() {
        return saveButton;
    }

    @Override
    public HasTapHandlers getCancelButton() {
        return cancelButton;
    }

    @Override
    public HasValue<Date> getCreationDate() {
        return creationDate;
    }

    @Override
    public HasValue<Date> getOnsetDate() {
        return onsetDate;
    }

    @Override
    public HasValue<String> getPainType() {
        return painType;
    }

    @Override
    public HasValue<String> getLocation() {
        return location;
    }

    @Override
    public HasValue<String> getNotes() {
        return notes;
    }

    @Override
    public HasValue<String> getTags() {
        return tags;
    }

    @Override
    public HasValue<String> getRemedies() {
        return remedies;
    }

    @Override
    public HasValue<Integer> getHoursSlept() {
        return hoursSlept;
    }

    @Override
    public HasValue<Integer> getSeverity() {
        return severity;
    }

    @Override
    public HasTapHandlers getDeleteButton() {
        return deleteButton;
    }

    @Override
    public void setLocation(String location) {
        this.location.setValue(location);
    }

}
