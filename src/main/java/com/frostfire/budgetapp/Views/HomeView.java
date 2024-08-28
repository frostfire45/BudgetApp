package com.frostfire.budgetapp.Views;

import com.frostfire.budgetapp.Views.Components.NavigationComponent;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends AppLayout {
    TextField filterText = new TextField();
    public HomeView(){
        setContent(new NavigationComponent());

    }

    
}
