package com.frostfire.budgetapp.Views.AccountPayable;

import com.frostfire.budgetapp.model.AccountPayable;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;


@Route("accountPayable")
@PageTitle("Account Payable")
public class AccountPayableView extends VerticalLayout {
    final private AccountPayableViewModel accntPayModel;

    Grid<AccountPayable> grid = new Grid<>(AccountPayable.class);
    TextField filterText = new TextField();
    DatePicker startDate = new DatePicker();
    DatePicker endDate = new DatePicker();
    Button updateBtn = new Button();
    public AccountPayableView(AccountPayableViewModel accountPayableViewModel){
        this.accntPayModel = accountPayableViewModel;
        addClassName("account-payable-view");
        String cr = AccountPayable.class.toString();
        setSizeFull();
        configureGrid();
        add(getToolbar(),grid);
        updateList();
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        setUpdateBtn();
        setStartDatepicker();
        setEndDatePicker();
        setUpdateBtn();
        HorizontalLayout toolbar = new HorizontalLayout(filterText,startDate,endDate,updateBtn);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    private void setUpdateBtn(){
        updateBtn.setText("Update");
        updateBtn.addClickListener(buttonClickEvent -> updateList());
    }
    private void setStartDatepicker(){
        startDate.setAutoOpen(false);
        startDate.setClearButtonVisible(true);
        startDate.setInitialPosition(LocalDate.now().minusMonths(1));
        startDate.setLocale(accntPayModel.getLocale());
        startDate.addValueChangeListener(event -> accntPayModel.setStartDate(event.getValue()));
    }
    private void setEndDatePicker(){

        endDate.setAutoOpen(false);
        endDate.setClearButtonVisible(true);
        endDate.setInitialPosition(LocalDate.now().minusMonths(1));
        endDate.setLocale(accntPayModel.getLocale());
        endDate.addValueChangeListener(event -> accntPayModel.setEndDate(event.getValue()));
    }
    private void configureGrid() {
        grid.addClassNames("account-payable-grid");
        grid.setSizeFull();
        grid.setColumns("posted_date", "amount", "check_num","payee","memo","amtPaid");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList(){
        grid.setItems(accntPayModel.getAllTransaction());
    }
}
