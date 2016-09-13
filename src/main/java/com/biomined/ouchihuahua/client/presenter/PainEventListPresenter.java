package com.biomined.ouchihuahua.client.presenter;

import com.biomined.ouchihuahua.client.event.AddPainEvent;
import com.biomined.ouchihuahua.client.event.EditPainEventEvent;
import com.biomined.ouchihuahua.client.services.PainEventServiceAsync;
import com.biomined.ouchihuahua.shared.model.PainEventSummary;
import com.biomined.ouchihuahua.shared.model.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import java.util.ArrayList;
import java.util.List;

public class PainEventListPresenter implements Presenter {

    private final PainEventServiceAsync painEventServiceAsync;
    private final HandlerManager eventBus;
    private final Display display;
    private final UserDTO user;
    private ArrayList<PainEventSummary> painEventSummaries;

    public PainEventListPresenter(PainEventServiceAsync painEventServiceAsync, HandlerManager eventBus, Display display, UserDTO user) {

        this.painEventServiceAsync = painEventServiceAsync;
        this.eventBus = eventBus;
        this.display = display;
        this.user = user;
    }

    public interface Display {

        Button getAddButton();

        CellList<PainEventSummary> getList();

        void setData(List<PainEventSummary> data);

        int getClickedRow(CellSelectedEvent event);

        List<Integer> getSelectedRows();

        Widget asWidget();

        void setUserName(String username);
    }

    public void bind() {

        display.setUserName(user.getUsername());

        painEventServiceAsync.getPainEventSummaryList(user.getId(), new AsyncCallback<ArrayList<PainEventSummary>>() {
            @Override
            public void onFailure(Throwable caught) {

                GWT.log(caught.getMessage());

            }

            @Override
            public void onSuccess(final ArrayList<PainEventSummary> result) {

                if (result != null) {

                    painEventSummaries = result;

                    display.getList().addCellSelectedHandler(new CellSelectedHandler() {

                        @Override
                        public void onCellSelected(CellSelectedEvent cellSelectedEvent) {

                            int selectedRow = display.getClickedRow(cellSelectedEvent);

                            if (selectedRow >= 0) {

                                String id = result.get(selectedRow).getId().toString();

                                if (id != null) {
                                    eventBus.fireEvent(new EditPainEventEvent(id));
                                }
                            }
                        }
                    });


                    display.setData(result);
                }
            }
        });

        display.getAddButton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                eventBus.fireEvent(new AddPainEvent());
            }
        });
    }

    public void go(final HasWidgets container) {
        bind();
        container.clear();
        container.add(display.asWidget());
    }

    public void sortPainEventDetails() {

//        List<PainEvent> painEvents = user.getPainEvents();

//        for (int i = 0; i < painEvents.size(); ++i) {
//            for (int j = 0; j < painEvents.size() - 1; ++j) {
//                if (painEvents.get(j).getDisplayString().compareToIgnoreCase(painEvents.get(j + 1).getDisplayString()) >= 0) {
//                    PainEvent tmp = painEvents.get(j);
//                    painEvents.set(j, painEvents.get(j + 1));
//                    painEvents.set(j + 1, tmp);
//                }
//            }
//        }
    }

    private void deleteSelectedPainEvent() {

        PopupPanel popupPanel = new PopupPanel(true, true);
        popupPanel.setAnimationEnabled(true);
        popupPanel.add(new Label("Feature not implemented"));

        List<Integer> selectedRows = display.getSelectedRows();
        ArrayList<String> ids = new ArrayList<String>();

        for (int i = 0; i < selectedRows.size(); ++i) {
            ids.add(painEventSummaries.get(selectedRows.get(i)).getId().toString());
        }


//        painEventServiceAsync.deletePainEvent(ids, new AsyncCallback<Long id>() {
//            public void onSuccess(ArrayList<IPainEvent> result) {
//                IPainEvents = result;
//                sortPainEventDetails();
//                display.setData(IPainEvents);
//
//            }
//
//            public void onFailure(Throwable caught) {
//                Window.alert("Error deleting selected ouchihuahua");
//            }
//        });
    }
}
