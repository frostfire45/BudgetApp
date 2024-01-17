package com.frostfire.budgetapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.frostfire.budgetapp.dao")
public class BudgetAppApplication {
    private static final Logger log = LoggerFactory.getLogger(BudgetAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BudgetAppApplication.class, args);
    }
/*
    @Bean
    public CommandLineRunner loadData(BankRepository repository, BankTransactionDao transaction) throws FileNotFoundException {

        LocalDate cal = Utility.convertStringToDate("11/27/2023");
        File file = new File("BankTransaction/myspending.csv");


        try (FileReader filerReader = new FileReader(file)){
            List<BankTransaction> transList = new ArrayList<>();

            BufferedReader br = new BufferedReader(filerReader);
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] coliumSplit = line.split(",");
                BankTransaction tran = new BankTransaction(Utility.convertStringToDate(coliumSplit[0]),
                        Double.parseDouble(coliumSplit[1]),
                        Integer.parseInt(coliumSplit[2]),
                        coliumSplit[3],
                        coliumSplit[4]);
                transaction.addNewTransaction(tran);
            }
            transaction.savedSession();
            filerReader.close();
        }
        catch (IOException ioe){

        }
        return (args) -> {

            //repository.save(new Bank(2,"Chase","3322ii33-3221", Bank.AccountType.Checking,3422.21));
            //transaction.addNewTransaction(new BankTransaction(cal,-3.13,' ',"Circle K #2740981",""));
            // fetch all customers
            //log.info("Customers found with findAll():");
            //log.info("-------------------------------");
            //for (Bank bank : repository.findAll()) {
            //    log.info(bank.toString());
            //}
           // log.info("");
        };
    }
    
 */
}
