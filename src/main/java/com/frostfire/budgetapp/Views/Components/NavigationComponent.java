package com.frostfire.budgetapp.Views.Components;

import com.frostfire.budgetapp.Views.AccountPayable.AccountPayableView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;


public class NavigationComponent extends AppLayout {
    public NavigationComponent(){
        //addToNavbar(createSideNav());
        addToDrawer(createSideNav());

    }
    public SideNav createSideNav() {
        setPrimarySection(AppLayout.Section.DRAWER);
        SideNav nav = new SideNav();
        nav.setWidth(100, Unit.PERCENTAGE);
        SideNavItem accountPayable = new SideNavItem("Transactons", AccountPayableView.class);
        nav.addItem(accountPayable);
        return nav;
    }

}
