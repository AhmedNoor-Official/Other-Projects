//This program scans the barcodes and calculates the prices of a supermarket.
//by Ahmed Noor Aboo

//directives to include libraries.
#include <iostream>
#include <iomanip>
#include <stdlib.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

//This is the programs function.
/* Takes the item names, all the barcodes for the items, and all the prices of the items as parameters.*/
vector<string> welcome(string item_names[], string barcodes[], float prices[])
{
    float prod_amount;
    float total = 0;
    float total_price = 0;

    string products;
    string receipt_item;
    string barcode_entered;

    vector<string> basket;

//welcome screen message.
    cout << "*****************************************************\n";
    cout << "*   WELCOME TO HERTS SUPERMARKET CHECKOUT SYSTEM    *\n";
    cout << "* Scan the barcode or manually type the barcode ID  *\n";
    cout << "*****************************************************\n";

    int i;

    while (barcode_entered != "f" && barcode_entered != "F")
    {
        cout << "Please scan or enter your barcode. Enter 'F' when done" << endl;
        cin >> barcode_entered;

        for (int i= 0; i < 10; ++i)
        {
            if (barcode_entered == barcodes[i])
            {
                cout << "Item purchased: " << item_names[i] <<endl;
                basket.push_back(barcodes[i]); // Copies the value at the memory address of barcodes[i] and inserts it at the back of the basket vector.
                total_price += prices[i]; // Adds the price of the barcode that was inputted to the total price.
                cout << "Barcode (type F to finish)" <<endl;
            }
        }
    }

    cout << fixed;
    cout << "Total Price: " << char(156) << setprecision(2) << total_price << endl;

    float cash_recieved;
    float change;

    cout << "please enter amount of cash: "<< char(156);
    cin >> cash_recieved; //cin >> is asking the customer to input amount of cash.

    while(cin.fail()) //checking for user inputs that are not numbers
            {cout << "[Error!] Please input numbers only!";
            cin.clear();
            cin.ignore();
            cin >> cash_recieved;}
    if (cash_recieved >= total_price)
    {
        change = cash_recieved - total_price;
        cout << "Change given is: " << char(156)<< change << endl;
        cout << "WE HOPE TO SEE YOU AGAIN!\n\n\n\n";
    }
    else
    {
        while(cash_recieved < total_price)
        {
            total_price = total_price - cash_recieved ; // calculating how much the user has left to pay
            cout << "[Insuficiant Amount!] More cash needed!: " << char(156);
            cout << total_price << "\n";
            cout << "cash received: " << char(156);
            cin >> cash_recieved;

         while(cin.fail()) //checking for user inputs that are not numbers
            {cout << "[Error!] Please input numbers only!";
            cin.clear();
            cin.ignore();
            cin >> cash_recieved;}
        }
        total = cash_recieved - total_price;
        cout << "your change is: " << char(156) << total << endl;
    }

    return basket;
}
// Prints the receipt
/* Takes in by parameters the basket of items selected in the welcome function.
   The item names, all the barcodes for the items, and all the prices of the items.
*/
void print_receipt (vector<string> basket, string item_names[], string barcodes[], float prices[])
{
    /* Print the header for the reciept*/
    cout << "------------------------------" << endl;
    cout << "           RECEIPT     " << endl;
    cout << "------------------------------" << endl;

    cout << "ITEM" << setw(16) << "BARCODE" << setw(10) << "PRICE" << endl; // Print the headings of each of the columns for the receipt.

    // Loop for every string within the vector 'basket'.
    for (string item_barcode : basket)
    {
        // Loop 10 times to go through all elements of the barcodes array.
        for (int i = 0; i < 10; i++)
        {
            if (item_barcode == barcodes[i]) // If the string in basket and barcodes match do the following.
            {
                cout << item_names[i] << setw(20 - item_names[i].length()) << barcodes[i] << setw(10) << prices[i] << endl; // output the name with a spacing between the barcodes column and then finally print the prices.
            }
        }
    }

    cout << endl << endl; // Double spacing.
}

int main(){

    //These are the items and barcodes stored in an array.
    string item_names[10] = {"milk","bread","chocolate","towel","toothpaste","soap","pen","biscuits","lamp","battery"};
    string barcodes[10] = {"0120001","0120002","0120003","0120004","0120005","0120006","0120007","0120008","0120009","0120010"};
    float prices[10] = {10.50,5.50,8.00,12.10,6.75,5.20,2.00,4.45,20.50,10.00};

    bool new_customer = true; // Initialise the boolean for new customer to true.

    // While new customer is true loop.
    while (new_customer)
    {
        vector<string> basket = welcome(item_names, barcodes, prices); //this is the main function that repeats when users enter y, otherwise program ends.
        print_receipt(basket, item_names, barcodes, prices); // Prints the receipt after the welcome function as all items have been selected and placed in the customers basket.

        char input; // variable used for the user to input whether there is another customer.
        cout << "new customer Y/N" <<endl; // Prompt the user for a value.
        cin >> input; // User input


        if (input != 'y'&& input != 'Y') // If the input is either lowercase or uppercase 'y'.
        {
            cout << "THANK YOU FOR SHOPPING AT HERTS." << endl;
            new_customer = false;
        }
        else {
            system("CLS"); // Clear the previous lines in the console.

        }

    }
}
