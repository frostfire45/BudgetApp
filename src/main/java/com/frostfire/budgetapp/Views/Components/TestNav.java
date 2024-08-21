package com.frostfire.budgetapp.Views.Components;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;

public class TestNav extends AppLayout {
    public TestNav(){
        addToNavbar(createSideNav());
        addToDrawer(new TextField("Stuff"));

    }
    public SideNav createSideNav() {
        setPrimarySection(Section.DRAWER);
        SideNav nav = new SideNav();
        nav.setWidth(20, Unit.PERCENTAGE);
        nav.addItem(new SideNavItem("Something"));
        return nav;
    }




}
