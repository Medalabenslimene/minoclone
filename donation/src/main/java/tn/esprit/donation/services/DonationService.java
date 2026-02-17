package tn.esprit.donation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.donation.entity.Donation;
import tn.esprit.donation.repository.DonationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public Donation create(Donation donation) {
        return donationRepository.save(donation);
    }

    public Donation update(Long id, Donation donation) {
        Donation existing = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found with id: " + id));

        existing.setUserId(donation.getUserId());
        existing.setAmount(donation.getAmount());
        existing.setMessage(donation.getMessage());
        existing.setAnonymous(donation.getAnonymous());
        existing.setStatus(donation.getStatus());
        existing.setPaymentMethod(donation.getPaymentMethod());
        existing.setDonatedAt(donation.getDonatedAt());

        return donationRepository.save(existing);
    }

    public void delete(Long id) {
        if (!donationRepository.existsById(id)) {
            throw new RuntimeException("Donation not found with id: " + id);
        }
        donationRepository.deleteById(id);
    }

    public Donation getById(Long id) {
        return donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found with id: " + id));
    }

    public List<Donation> getAll() {
        return donationRepository.findAll();
    }
}
