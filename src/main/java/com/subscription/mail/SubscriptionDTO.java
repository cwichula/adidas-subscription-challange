package com.subscription.mail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubscriptionDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String mail;
    private String age;

    public SubscriptionDTO(String id, String firstName, String lastName, String mail, String age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.age = age;
    }
}
