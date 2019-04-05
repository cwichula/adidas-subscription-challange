package com.subscription.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
class SubscriptionDTO {
    private Long id;
    private String email;
    private String firstName;
    private String gender;
    private String dateOfBith;
    private String newsletterId;
    private String isConsent;

    SubscriptionDTO(final String email,
                    final String firstName,
                    final String gender,
                    final String dateOfBith,
                    final String newsletterId,
                    final String isConsent) {
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBith = dateOfBith;
        this.newsletterId = newsletterId;
        this.isConsent = isConsent;
    }
}
