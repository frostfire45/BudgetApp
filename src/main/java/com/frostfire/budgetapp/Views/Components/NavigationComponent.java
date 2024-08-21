package com.frostfire.budgetapp.Views.Components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;


public class NavigationComponent extends Composite<Component> {
    TextField filterText = new TextField();
    @Override
    protected Component initContent(){
        VerticalLayout vl = new VerticalLayout();
        vl.setWidth(100, Unit.PERCENTAGE);
        vl.setAlignSelf(FlexComponent.Alignment.START);
        vl.getStyle().set("border", "1px solid");
        SideNav nav = new SideNav();
        SideNavItem dashboardLink = new SideNavItem("Dashboard");
        SideNavItem inboxLink = new SideNavItem("Inbox");
        SideNavItem mainPageLink = new SideNavItem("Vaadin website");
        nav.addItem(dashboardLink,inboxLink,mainPageLink);
        vl.add(nav);
        return vl;
    }
    private HorizontalLayout getToolbar() {
        /*
        filterText.set("Filter by name...");
        filterText.set (true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addContactButton = new Button("Add contact");
        */
        var toolbar = new HorizontalLayout();
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
