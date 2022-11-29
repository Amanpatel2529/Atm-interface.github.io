import java.util.Scanner;

class AtmMachine {

    public float transaction_history[] = new float[100];
    float amount = 0;
    float deposit_ammount = 0;
    float withdraw_ammount = 0;
    float transfer_ammount = 0;
    float total_ammount = 0;

    int transaction_count = 0;

    String transaction_operation[] = new String[100];
    int transaction_op_count = 0;

    Scanner sca = new Scanner(System.in);

    // Transcation History Records
    void transcationhistory() {
        System.out.println("\n Your Transcation History is : ");
        System.out.println("\t Sr. No. \t Ammount \t Operation\n");
        for (int i = 0; i < transaction_count && i < transaction_op_count; i++) {
            System.out.println("\t" + (i + 1) + "\t \t" + transaction_history[i] + "\t \t " + transaction_operation[i]);

        }
    }

    // Dwposite Function
    void deposite() {
        System.out.println("\n Enter the Deposite Ammount :");
        deposit_ammount = sca.nextFloat();

        total_ammount = total_ammount + deposit_ammount;
        System.out.println("\n Account Ballence is :" + total_ammount);

        transaction_history[transaction_count] = deposit_ammount;
        transaction_count++;

        transaction_operation[transaction_op_count] = "Deposite";
        transaction_op_count++;
    }

    // Withdrowl Function
    void Withdrowl() {
        System.out.println("\n Enter the Ammount want to Withdrowl :");
        withdraw_ammount = sca.nextFloat();

        if (withdraw_ammount <= total_ammount) {
            total_ammount = total_ammount - withdraw_ammount;
            System.out.println("\n Account Ballence is :" + total_ammount);

            transaction_history[transaction_count] = withdraw_ammount;
            transaction_count++;

            transaction_operation[transaction_op_count] = "Withdrow";
            transaction_op_count++;

        } else {
            System.out.println("\n Your Withdrowl amount is greter than Your Account Ballence !!!!");
        }
    }

    // Transfer Tunction
    void transfer() {
        System.out.println("\n Enter the Account Number of Tranfer To. : ");
        int tranfer_acc_no = sca.nextInt();

        System.out.println("\n Enter the name of Person : ");
        String person_name = sca.next();

        System.out.println("\n Enter the Ammount want to Tranfer :");
        transfer_ammount = sca.nextFloat();

        if (transfer_ammount <= total_ammount) {
            total_ammount = total_ammount - transfer_ammount;
            System.out.println("\n Account Ballence is :" + total_ammount);

            transaction_history[transaction_count] = transfer_ammount;
            transaction_count++;

            transaction_operation[transaction_op_count] = "Transfer";
            transaction_op_count++;

            System.out.println("\nAmmount " + transfer_ammount + "\nTranfer To Account Number " + tranfer_acc_no
                    + "\n Name " + person_name);
            System.out.println("\n Tranfer Successfull");
        } else {
            System.out.println("\n Your Tranfer amount is greter than Your Account Ballence !!!!");

        }
    }
};

public class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AtmMachine obj = new AtmMachine();
        int user_id = 123456;
        int user_pin = 4321;
        int choice = 0;

        System.out.println("Enter the User Id : ");
        user_id = sc.nextInt();

        System.out.println("Enter the User Pin : ");
        user_pin = sc.nextInt();

        // Main menu
        // User-Id = 123456
        // User-Pin = 4321

        if (user_id == 123456 && user_pin == 4321) {
            while (choice != 5) {
                System.out.println("\n \t ************ ATM Interface ************");
                System.out.println("\n \t 1.Transation History ");
                System.out.println("\t 2.Deposite");
                System.out.println("\t 3.Withdrowl");
                System.out.println("\t 4.Transfer");
                System.out.println("\t 5.Exit");
                System.out.println("Enter Your Choice : ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\n****** Transaction History ******");
                        obj.transcationhistory();
                        break;

                    case 2:
                        System.out.println("\n****** Deposite ******");
                        obj.deposite();
                        break;

                    case 3:
                        System.out.println("\n****** Withdrowl ******");
                        obj.Withdrowl();
                        break;

                    case 4:
                        System.out.println("\n****** Transfer ******");
                        obj.transfer();
                        break;

                    case 5:
                        System.out.println("\n Thank You !!!!");
                        break;
                }

            }
        } else {
            System.out.println("User Id And Pin Does not Match \n Try Again");
        }

        sc.close();

    }
}
