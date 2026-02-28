package dia_04.ContactManagerTryCatch;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagerTryCatch {

    public static String getCategoryText(int category){
        return switch (category){
            case 1 -> "Family";
            case 2 -> "Work";
            case 3 -> "Friends";
            default -> "Unknow";
        };
    }

    public static void addContact(ArrayList<String> fullNames,
                                  ArrayList<String> phoneNumbers,
                                  ArrayList<String> emails,
                                  ArrayList<String> categories,
                                  ArrayList<Boolean> favorites,
                                  String fullName,
                                  String phone,
                                  String email,
                                  int category){


        fullNames.add(fullName);
        phoneNumbers.add(phone);
        emails.add(email);
        categories.add(getCategoryText(category));
        favorites.add(false);

        System.out.println("Contact added successfully");
    }

    public static void showContacts (ArrayList<String> fullNames,
                                     ArrayList<String> phoneNumbers,
                                     ArrayList<String> emails,
                                     ArrayList<String> categories,
                                     ArrayList<Boolean> favorites){
        if(fullNames.isEmpty()){
            System.out.println("No contacts registered");
            return;
        }

        for (int i = 0; i < fullNames.size(); i++) {
            String category = categories.get(i);
            String favorite = favorites.get(i) ? "Yes" : "Not";

            System.out.println("\n----- Contact #" + (i + 1) + " -----");
            System.out.println("Name: " + fullNames.get(i));
            System.out.println("Phone: " + phoneNumbers.get(i));
            System.out.println("Email: " + emails.get(i));
            System.out.println("Category: " + category);
            System.out.println("Favorite: " + favorite);
        }
        System.out.println("-----------------------------------");
        System.out.println("Total of contact: " + fullNames.size());
    }

    public static int findContact(ArrayList<String> phoneNumbers, String phone){
        int index = -1;

        for (int i = 0; i < phoneNumbers.size(); i++) {
            if (phoneNumbers.get(i).equals(phone)){
                index = i;
            }
        }
        return index;
    }

    public static void editContact(ArrayList<String> fullNames,
                                   ArrayList<String> phoneNumbers,
                                   ArrayList<String> emails,
                                   ArrayList<String> categories,
                                   int indexContact,
                                   Scanner in){

        System.out.println("What do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Phone");
        System.out.println("3. Email");
        System.out.println("4. Category");
        System.out.println("--------------------------");
        System.out.print("Select an option: ");
        int option = in.nextInt();

        in.nextLine();
        switch (option){
            case 1 -> {
                System.out.print("New name: ");
                String name = in.nextLine();
                fullNames.set(indexContact, name);
            }case 2 -> {
                System.out.print("New phone number: ");
                String phone = in.nextLine();
                phoneNumbers.set(indexContact, phone);
            }case 3 -> {
                System.out.print("New email: ");
                String email = in.nextLine();
                emails.set(indexContact, email);
            }case 4 -> {
                System.out.println("New category: ");
                System.out.println("1. Family");
                System.out.println("2. Work");
                System.out.println("3. Friends");
                int newCategory = in.nextInt();
                String category = getCategoryText(newCategory);
                categories.set(indexContact, category);
            }case 5 -> {
                System.out.print("New name: ");
                fullNames.set(indexContact, in.nextLine());
                System.out.print("New phone number: ");
                phoneNumbers.set(indexContact, in.nextLine());
                System.out.print("New email: ");
                emails.set(indexContact,in.nextLine());
                System.out.println("New category: ");
                System.out.println("1. Family");
                System.out.println("2. Work");
                System.out.println("3. Friends");
                categories.set(indexContact, getCategoryText(in.nextInt()));
            }default -> System.out.println("Contact not edited");
        }

        System.out.println("Contact edited successfully");
    }

    public static void deleteContact(ArrayList<String> fullNames,
                                     ArrayList<String> phoneNumbers,
                                     ArrayList<String> emails,
                                     ArrayList<String> categories,
                                     ArrayList<Boolean> favorites,
                                     int indexContact){
        fullNames.remove(indexContact);
        phoneNumbers.remove(indexContact);
        emails.remove(indexContact);
        categories.remove(indexContact);
        favorites.remove(indexContact);

        System.out.println("Contact deleted successfully");
    }

    public static void searchContact(ArrayList<String> fullNames,
                                     ArrayList<String> phoneNumbers,
                                     ArrayList<String> emails,
                                     ArrayList<String> categories,
                                     ArrayList<Boolean> favorites,
                                     int indexContact){

        String favorite = favorites.get(indexContact) ? "Yes" : "Not";
        System.out.println("Name: " + fullNames.get(indexContact));
        System.out.println("Phone number: " + phoneNumbers.get(indexContact));
        System.out.println("Email: " + emails.get(indexContact));
        System.out.println("Category: " + categories.get(indexContact));
        System.out.println("Favorite: " + favorite);
    }

    public static void markAsFavorite(ArrayList<String> fullNames,
                                      ArrayList<Boolean> favorites,
                                      int indexContact){
        if (favorites.get(indexContact) == true){
            System.out.println("Already a favorite");
        }else {
            favorites.set(indexContact, true);
            System.out.println(fullNames.get(indexContact) +  " mask as favorite successfully");
        }

    }

    public static void showFavorites(ArrayList<String> fullNames,
                                     ArrayList<String> phoneNumbers,
                                     ArrayList<String> emails,
                                     ArrayList<String> categories,
                                     ArrayList<Boolean> favorites){

        int countFavorite = 0;
        for (int i = 0; i < favorites.size(); i++) {
            if (favorites.get(i) == true){
                searchContact(fullNames, phoneNumbers, emails, categories, favorites, i);
                countFavorite++;
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Total of contact favorites: " + countFavorite);
    }

    public static void filterByCategory(ArrayList<String> fullNames,
                                        ArrayList<String> phoneNumbers,
                                        ArrayList<String> emails,
                                        ArrayList<String> categories,
                                        ArrayList<Boolean> favorites,
                                        int category){

        int count = 0;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).equals(getCategoryText(category))){
                System.out.println("\n---- Contact #" + (count + 1) + " ----");
                count++;
                searchContact(fullNames, phoneNumbers, emails, categories, favorites, i);
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("Total of category " + getCategoryText(category) + ": " + count);

    }

    public static void showStatistics(ArrayList<String> fullNames,
                                      ArrayList<String> categories,
                                      ArrayList<Boolean> favorites){

        int totalFavoriteContacts = 0;
        for (Boolean favorite : favorites){
            if (favorite) totalFavoriteContacts++;
        }
        int totalCategoryFamily = 0;
        int totalCategoryWork = 0;
        int totalCategoryFriends= 0;
        for(String category : categories){
            if (category.equals("Family")) totalCategoryFamily++;
            else if (category.equals("Work")) totalCategoryWork++;
            else totalCategoryFriends++;
        }
        System.out.println("Total contacts: " + fullNames.size());
        System.out.println("Favorite contacts: " + totalFavoriteContacts);
        System.out.println("By category: ");
        System.out.println("  Family: " + totalCategoryFamily );
        System.out.println("  Work: " + totalCategoryWork );
        System.out.println("  Friends: " + totalCategoryFriends );


    }
    public static void displayMenu(Scanner in) {
        ArrayList<String> fullNames = new ArrayList<>();
        ArrayList<String> phoneNumbers = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Boolean> favorites = new ArrayList<>();

        int option;
        do {
            System.out.println("\n-------- MENU CONTACT MANAGER --------");
            System.out.println("1. Add contact");
            System.out.println("2. Show all contacts");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Search contact");
            System.out.println("6. Mark as favorite");
            System.out.println("7. Show favorites");
            System.out.println("8. Filter by category");
            System.out.println("9. View statistics");
            System.out.println("0. Exit");

            System.out.println("--------------------------------------");
            System.out.print("Select an option: ");
            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("\n------- Add contact -------");
                    System.out.print("Full name: ");
                    String fullName = in.nextLine();
                    System.out.print("Phone number: ");
                    String phoneNumber = in.nextLine();
                    System.out.print("Email address: ");
                    String email = in.nextLine();
                    System.out.println("Category: ");
                    System.out.println("1. Family");
                    System.out.println("2. Work");
                    System.out.println("3. Friends");
                    int category = in.nextInt();
                    addContact(fullNames, phoneNumbers, emails, categories, favorites, fullName, phoneNumber, email, category);
                }case 2 -> {
                    System.out.println("\n------- All contacts -------");
                    showContacts(fullNames, phoneNumbers, emails, categories, favorites);
                }case 3 -> {
                    System.out.println("\n------- Edit contact -------");

                    if(fullNames.isEmpty()){
                        System.out.println("There aren't contacts saved");
                    }else{
                        System.out.print("Phone number: ");
                        String phone = in.nextLine();

                        int indexFindContact = findContact(phoneNumbers, phone);
                        if ( indexFindContact == -1){
                            System.out.println("Contact not found");
                        }else {
                            editContact(fullNames,phoneNumbers,emails,categories, indexFindContact, in);
                        }
                    }

                }case 4 -> {
                    System.out.println("\n------- Delete contact -------");
                    if (fullNames.isEmpty()){
                        System.out.println("There aren't contacts saved");
                    }else {
                        System.out.print("Phone number: ");
                        String phone = in.nextLine();

                        int indexFindContact = findContact(phoneNumbers, phone);
                        if ( indexFindContact == -1){
                            System.out.println("Contact not found");
                        }else {
                            deleteContact(fullNames,phoneNumbers,emails,categories, favorites, indexFindContact);
                        }
                    }
                }case 5 -> {
                    System.out.println("\n------- Search contact -------");
                    if (fullNames.isEmpty()){
                        System.out.println("There aren't contacts saved");
                    }else {
                        System.out.print("Phone number: ");
                        String phone = in.nextLine();

                        int indexFindContact = findContact(phoneNumbers, phone);
                        if ( indexFindContact == -1){
                            System.out.println("Contact not found");
                        }else {
                            searchContact(fullNames,phoneNumbers,emails,categories, favorites, indexFindContact);
                        }
                    }
                } case 6 -> {
                    System.out.println("\n------- Mark as favorite contact -------");
                    if (fullNames.isEmpty()){
                        System.out.println("There aren't contacts saved");
                    }else {
                        System.out.print("Phone number: ");
                        String phone = in.nextLine();

                        int indexFindContact = findContact(phoneNumbers, phone);
                        if ( indexFindContact == -1) {
                            System.out.println("Contact not found");
                        }else {
                            markAsFavorite(fullNames,favorites,indexFindContact);
                        }
                    }
                } case 7 -> {
                    System.out.println("\n------- Show favorites -------");
                    if (fullNames.isEmpty()){
                        System.out.println("There aren't contacts saved");
                    }else {
                        showFavorites(fullNames, phoneNumbers, emails, categories, favorites);
                    }
                } case 8 -> {
                    System.out.println("\n------- Filter by category -------");
                    if (fullNames.isEmpty()) {
                        System.out.println("There aren't contacts saved");
                    }else {
                        System.out.print("Number category: ");
                        int category = in.nextInt();
                        filterByCategory(fullNames, phoneNumbers, emails, categories, favorites, category);
                    }
                }case 9 ->{
                    System.out.println("\n------- View statistics -------");
                    if (fullNames.isEmpty()){
                        System.out.println("There aren't contacts saved");
                    }else {
                        showStatistics(fullNames,categories, favorites);
                    }

                }
            }
        } while (option != 0);
    }

     public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        displayMenu(in);
    }
}
