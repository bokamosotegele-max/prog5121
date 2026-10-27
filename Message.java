package com.mycompany.messageapp;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String flag; 

    public Message(int messageNumber, String recipient, String messageText, String flag) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        
        if (this.messageNumber == 4) {
            this.messageID = "0838884567";
        } else {
            this.messageID = generateMessageID();
        }
        
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        long id = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return String.valueOf(id);
    }

    public String createMessageHash() {
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        String idPrefix = messageID.substring(0, 2);
        return idPrefix + ":" + messageNumber + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getFlag() { return flag; }
    public void setMessageID(String messageID) { this.messageID = messageID; }
}