package com.mycompany.messageapp;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {
    private List<Message> sentMessages = new ArrayList<>();
    private List<Message> storedMessages = new ArrayList<>();

    public void loadTestData() {
        addMessage(new Message(1, "+27834557896", "Did you get the cake?", "Sent"));
        addMessage(new Message(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored"));
        addMessage(new Message(3, "+27834484567", "Yohoooo, I am at your gate.", "Disregard"));
        
        Message msg4 = new Message(4, "0838884567", "It is dinner time !", "Sent");
        msg4.setMessageID("0838884567"); 
        addMessage(msg4);
        
        addMessage(new Message(5, "+27838884567", "Ok, I am leaving without you.", "Stored"));
    }

    private void addMessage(Message msg) {
        if (msg.getFlag().equals("Sent")) sentMessages.add(msg);
        if (msg.getFlag().equals("Stored")) storedMessages.add(msg);
    }

    public String getLongestMessage() {
        if (storedMessages.isEmpty()) return "No stored messages.";
        Message longest = storedMessages.get(0);
        for (Message msg : storedMessages) {
            if (msg.getMessageText().length() > longest.getMessageText().length()) longest = msg;
        }
        return longest.getMessageText();
    }

    public String searchByMessageID(String id) {
        for (Message msg : storedMessages) {
            if (msg.getMessageID().equals(id)) return "Recipient: " + msg.getRecipient() + "\nMessage: " + msg.getMessageText();
        }
        return "Message ID not found.";
    }

    public String searchByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder();
        for (Message msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) sb.append(msg.getMessageText()).append("\n");
        }
        return sb.toString().trim();
    }

    public String deleteByMessageHash(String hash) {
        for (int i = 0; i < storedMessages.size(); i++) {
            if (storedMessages.get(i).getMessageHash().equals(hash)) {
                String deletedText = storedMessages.get(i).getMessageText();
                storedMessages.remove(i);
                return "Message: \"" + deletedText + "\" successfully deleted.";
            }
        }
        return "Message hash not found.";
    }

    public String displayReport() {
        StringBuilder sb = new StringBuilder("--- Stored Messages Report ---\n");
        for (Message msg : storedMessages) {
            sb.append("Message Hash: ").append(msg.getMessageHash()).append("\n");
            sb.append("Recipient: ").append(msg.getRecipient()).append("\n");
            sb.append("Message: ").append(msg.getMessageText()).append("\n");
            sb.append("------------------------------\n");
        }
        return sb.toString();
    }

    public List<Message> getSentMessages() { return sentMessages; }
    public List<Message> getStoredMessages() { return storedMessages; }
}