package com.frostfire.budgetapp.Views;

import com.frostfire.budgetapp.Views.Components.NavigationComponent;
import com.frostfire.budgetapp.Views.Components.TestNav;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends AppLayout {
    TextField filterText = new TextField();
    public HomeView(){
        setContent(new TestNav());

//        add(new NavigationComponent(),
//                new Paragraph("Paragraph 1"),
//                new Paragraph("Paragraph 2")
//        );
    }

    
}
