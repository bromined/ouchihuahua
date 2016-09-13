package com.biomined.ouchihuahua.client.view;

import com.biomined.ouchihuahua.client.presenter.RegistrationPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.*;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarSpacer;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 5/9/13
 * Time: 1:24 PM
 */
public class RegistrationView extends Composite implements RegistrationPresenter.Display {

    private final LayoutPanel main = new LayoutPanel();
    private final HeaderPanel headerPanel = new HeaderPanel();
    private final ScrollPanel scrollPanel = new ScrollPanel();
    private final ButtonBar footerPanel = new ButtonBar();
    private final MTextBox username = new MTextBox();
    private final MPasswordTextBox password = new MPasswordTextBox();
    private final MPasswordTextBox passwordConfirmation = new MPasswordTextBox();
    private final Button registrationButton = new Button("register");
    private final MCheckBox rememberMeCheckbox = new MCheckBox();

    public RegistrationView() {

        FlowPanel container = new FlowPanel();
        WidgetList widgetList = new WidgetList();
        widgetList.setRound(true);
        container.add(widgetList);

        scrollPanel.add(container);

        widgetList.add(new FormListEntry("Username", username));
        widgetList.add(new FormListEntry("Password", password));
        widgetList.add(new FormListEntry("Retype Password", passwordConfirmation));
        widgetList.add(new FormListEntry("Remember me", rememberMeCheckbox));

        registrationButton.setRound(true);

        footerPanel.add(new ButtonBarSpacer());
        footerPanel.add(registrationButton);
        footerPanel.add(new ButtonBarSpacer());

        main.add(headerPanel);
        main.add(scrollPanel);
        main.add(footerPanel);

        initWidget(main);
    }

    @Override
    public HasTapHandlers getRegisterButton() {
        return registrationButton;
    }

    @Override
    public String getUserName() {
        return username.getValue();
    }

    @Override
    public String getPassword() {
        return password.getValue();
    }

    @Override
    public Boolean getRememberMe() {
        return rememberMeCheckbox.getValue();
    }

    @Override
    public String getPasswordConfirmation() {
        return passwordConfirmation.getValue();
    }
}
