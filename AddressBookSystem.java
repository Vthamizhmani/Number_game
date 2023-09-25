package batchA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {
    // Contact class should be made static to be accessed in the main method.
    static class Contact implements Serializable {
        private String name;
        private String phoneNumber;
        private String emailAddress;

        public Contact(String name, String phoneNumber, String emailAddress) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress + "\n";
        }
    }

    static class AddressBook2 {
        private List<Contact> contacts;

        public AddressBook2() {
            contacts = new ArrayList<>();
        }

        public void addContact(Contact contact) {
            contacts.add(contact);
        }

        public void removeContact(Contact contact) {
            contacts.remove(contact);
        }

        public List<Contact> searchContacts(String keyword) {
            List<Contact> results = new ArrayList<>();
            for (Contact contact : contacts) {
                if (contact.getName().contains(keyword) || contact.getPhoneNumber().contains(keyword) || contact.getEmailAddress().contains(keyword)) {
                    results.add(contact);
                }
            }
            return results;
        }

        public void displayAllContacts() {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }

        public int getSize() {
            return contacts.size();
        }
    }

    public static void main(String[] args) {
        AddressBook2 addressBook = new AddressBook2(); // Corrected class instantiation
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book System Menu:");
            System.out.println("1. Add a contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();

                    if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
                        Contact newContact = new Contact(name, phoneNumber, emailAddress);
                        addressBook.addContact(newContact);
                        System.out.println("Contact added successfully.");
                    } else {
                        System.out.println("All fields are required. Contact not added.");
                    }
                    break;

                case 2:
                    if (addressBook.getSize() > 0) {
                        System.out.print("Enter the name to remove: ");
                        String removeName = scanner.nextLine();
                        List<Contact> searchResults = addressBook.searchContacts(removeName);
                        if (!searchResults.isEmpty()) {
                            System.out.println("Found matching contacts:");
                            for (Contact contact : searchResults) {
                                System.out.println(contact);
                            }
                            System.out.print("Enter the index of the contact to remove: ");
                            int indexToRemove = scanner.nextInt();
                            if (indexToRemove >= 0 && indexToRemove < searchResults.size()) {
                                addressBook.removeContact(searchResults.get(indexToRemove));
                                System.out.println("Contact removed successfully.");
                            } else {
                                System.out.println("Invalid index. Contact not removed.");
                            }
                        } else {
                            System.out.println("No matching contacts found.");
                        }
                    } else {
                        System.out.println("Address book is empty.");
                    }
                    break;

                case 3:
                    System.out.print("Enter a keyword to search for contacts: ");
                    String keyword = scanner.nextLine();
                    List<Contact> searchResults = addressBook.searchContacts(keyword);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Contact contact : searchResults) {
                            System.out.println(contact);
                        }
                    } else {
                        System.out.println("No matching contacts found.");
                    }
                    break;

                case 4:
                    if (addressBook.getSize() > 0) {
                        System.out.println("All Contacts:");
                        addressBook.displayAllContacts();
                    } else {
                        System.out.println("Address book is empty.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Address Book System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

