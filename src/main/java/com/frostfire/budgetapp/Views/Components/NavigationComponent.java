package com.frostfire.budgetapp.Views.Components;

import com.frostfire.budgetapp.Service.WebConfigService;
import com.frostfire.budgetapp.Views.BankViews.BankTransactionView;
import com.frostfire.budgetapp.Views.home.HomeView;
import com.frostfire.budgetapp.model.WebConfig;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = HomeView.class)
public class NavigationComponent extends VerticalLayout {
    //private final WebConfigService wcs;

    public NavigationComponent() {
        //this.wcs = wcs;
        addNavigationBar();
    }

    private Component addNavigationBar() {
        SideNav nav = new SideNav();

        SideNavItem dashboardLink = new SideNavItem("Dashboard", HomeView.class, VaadinIcon.DASHBOARD.create());
        SideNavItem inboxLink = new SideNavItem("Inbox", BankTransactionView.class, VaadinIcon.ENVELOPE.create());
        SideNavItem mainPageLink = new SideNavItem(
                "Vaadin website","something",
                VaadinIcon.VAADIN_H.create());

        nav.addItem(dashboardLink, inboxLink, mainPageLink);
        return nav;
    }
}
