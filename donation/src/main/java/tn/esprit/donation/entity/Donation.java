package tn.esprit.donation.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "donations")

public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId; // nullable → anonymous donation

    private Double amount;

    private String message;

    private Boolean anonymous = false;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    private String paymentMethod; // CARD, STRIPE, FAKE

    private LocalDateTime donatedAt = LocalDateTime.now();
}
