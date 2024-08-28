package com.frostfire.budgetapp.Views.AccountPayable;

import com.frostfire.budgetapp.Service.CsvService;
import com.frostfire.budgetapp.Views.HomeView;
import com.frostfire.budgetapp.model.AccountPayable;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import java.io.InputStream;
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
    Button homeBtn = new Button();
    Button uploadBtn = new Button();
    MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
    VerticalLayout verticalLayoutTemp = new VerticalLayout();
    Div gridMain = new Div();
    Div sideMain = new Div();
    public AccountPayableView(AccountPayableViewModel accountPayableViewModel){
        this.accntPayModel = accountPayableViewModel;
        addClassName("account-payable-view");
        String cr = AccountPayable.class.toString();
        setSizeFull();
        configureGrid();
        //setSplitLayout();
        add(getToolbar(),getMain());
        updateList();
    }
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        setUpdateBtn();
        setStartDatepicker();
        setEndDatePicker();
        setUpdateBtn();
        setHomeButton();
        setUploadButton();
        HorizontalLayout toolbar = new HorizontalLayout(homeBtn,filterText,startDate,endDate,updateBtn,uploadBtn);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    private HorizontalLayout getMain(){
        HorizontalLayout main = new HorizontalLayout();
        main.setSizeFull();
        gridMain.add(grid);
        gridMain.setWidth(100,Unit.PERCENTAGE);
        sideMain.add(getSideBar());
        sideMain.setWidth(0,Unit.PERCENTAGE);
        main.add(gridMain,sideMain);
        return main;
    }
    private VerticalLayout getSideBar(){
        verticalLayoutTemp.setClassName("main-side-layout");
        verticalLayoutTemp.setWidth(25,Unit.PERCENTAGE);
        verticalLayoutTemp.setAlignSelf(Alignment.END);
        verticalLayoutTemp.setHeight(100,Unit.PERCENTAGE);
        verticalLayoutTemp.setVisible(false);
        verticalLayoutTemp.add(updateBtn);
        return verticalLayoutTemp;
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
        grid.setWidth(100,Unit.PERCENTAGE);
        grid.setColumns("posted_date", "amount", "check_num","payee","memo","amtPaid");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    private void setHomeButton(){
        homeBtn.setIcon(VaadinIcon.HOME.create());
        homeBtn.addClickListener(e -> homeBtn.getUI().ifPresent(ui -> ui.navigate(HomeView.class)));
    }
    private void setUploadButton(){
        updateBtn.addClickListener(buttonClickEvent -> {
            gridMain.setWidth(75,Unit.PERCENTAGE);
            verticalLayoutTemp.setVisible(true);

        });
//        upload.addSucceededListener(event -> {
//            String fileName = event.getFileName();
//            accntPayModel.uploadAccountCSV(buffer.getInputStream(fileName));
//        });
    }
    private void updateList(){
        grid.setItems(accntPayModel.getAllTransaction());
    }

}
