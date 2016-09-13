package com.biomined.ouchihuahua.client.view;

import com.biomined.ouchihuahua.client.presenter.LoginPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.*;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarSpacer;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/20/13
 * Time: 2:24 PM
 */
public class LoginView extends Composite implements LoginPresenter.Display {

    private final LayoutPanel main = new LayoutPanel();
    private final HeaderPanel headerPanel = new HeaderPanel();
    private final ScrollPanel scrollPanel = new ScrollPanel();
    private final ButtonBar footerPanel = new ButtonBar();
    private final MTextBox username = new MTextBox();
    private final MPasswordTextBox password = new MPasswordTextBox();
    private final Button loginButton = new Button("login");
    private final Button registerButton = new Button("register");
    private final Button forgotPasswordButton = new Button("forgot password");
    private final MCheckBox rememberMeCheckbox = new MCheckBox();
    private final Label usernameLabel = new Label("Username");
    private final Label passwordLabel = new Label("Password");
    private final Label rememberMeLabel = new Label("Remember me");

    public LoginView() {

        usernameLabel.setStyleName("basicLabel");
        passwordLabel.setStyleName("basicLabel");
        rememberMeLabel.setStyleName("basicLabel");

//        loginButton.setSmall(true);
//        loginButton.setRound(true);
//        loginButton.setStyleName("loginButton");

        FlowPanel container = new FlowPanel();
        WidgetList widgetList = new WidgetList();
        widgetList.setRound(true);
        container.add(widgetList);

        scrollPanel.add(container);

        main.add(headerPanel);
        main.add(scrollPanel);
        main.add(footerPanel);

        widgetList.add(new FormListEntry(usernameLabel.getText(), username));
        widgetList.add(new FormListEntry(passwordLabel.getText(), password));
        widgetList.add(new FormListEntry(rememberMeLabel.getText(), rememberMeCheckbox));

//        loginButton.setRound(true);

        loginButton.setRound(true);
        registerButton.setRound(true);
        forgotPasswordButton.setRound(true);

        footerPanel.add(new ButtonBarSpacer());
        footerPanel.add(loginButton);
        footerPanel.add(registerButton);
        footerPanel.add(forgotPasswordButton);
        footerPanel.add(new ButtonBarSpacer());

        initWidget(main);
    }

    @Override
    public HasTapHandlers getLoginButton() {
        return loginButton;
    }

    @Override
    public HasTapHandlers getRegisterButton() {
        return registerButton;
    }

    @Override
    public HasTapHandlers getForgotPasswordButton() {
        return forgotPasswordButton;
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
}
