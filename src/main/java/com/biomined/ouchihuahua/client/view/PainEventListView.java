package com.biomined.ouchihuahua.client.view;

import com.biomined.ouchihuahua.client.presenter.PainEventListPresenter;
import com.biomined.ouchihuahua.shared.model.PainEventSummary;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.*;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarSpacer;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;

import java.util.List;

public class PainEventListView extends Composite implements PainEventListPresenter.Display {

    private final LayoutPanel main = new LayoutPanel();
    private final HeaderPanel headerPanel = new HeaderPanel();
    private final ScrollPanel scrollPanel = new ScrollPanel();
    private final ButtonBar footerPanel = new ButtonBar();

    private final Button addButton;
    private CellList<PainEventSummary> painEventsList;
    private final LayoutPanel contentTable;
    private Label username = new Label();

    public PainEventListView() {

        contentTable = new LayoutPanel();

        LayoutPanel layoutPanel = new LayoutPanel();
        PullPanel pullPanel = new PullPanel();

        BasicCell<PainEventSummary> cell = new BasicCell<PainEventSummary>() {

            @Override
            public String getDisplayString(PainEventSummary painEventSummary) {
                return painEventSummary.getDisplayString();
            }
        };

        painEventsList = new CellList<PainEventSummary>(cell);
        painEventsList.setRound(true);


        layoutPanel.add(pullPanel);
        pullPanel.add(painEventsList);

        addButton = new Button("Add");

        addButton.setRound(true);

        footerPanel.add(new ButtonBarSpacer());
        footerPanel.add(addButton);
        footerPanel.add(new ButtonBarSpacer());

        contentTable.add(layoutPanel);
        scrollPanel.add(contentTable);

        headerPanel.setRightWidget(username);

        main.add(headerPanel);
        main.add(scrollPanel);
        main.add(footerPanel);

        initWidget(main);

    }

    @Override
    public Button getAddButton() {
        return addButton;
    }

    @Override
    public CellList<PainEventSummary> getList() {
        return painEventsList;
    }

    @Override
    public void setData(List<PainEventSummary> data) {
        painEventsList.render(data);
    }

    @Override
    public int getClickedRow(CellSelectedEvent event) {
        return event.getIndex();
    }

    @Override
    public List<Integer> getSelectedRows() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public void setUserName(String username) {
        this.username.setText("Username: " + username);
    }

}
