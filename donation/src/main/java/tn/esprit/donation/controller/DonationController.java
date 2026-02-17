package tn.esprit.donation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.donation.entity.Donation;
import tn.esprit.donation.services.DonationService;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    @PostMapping("/create-donation")
    public ResponseEntity<Donation> create(@RequestBody Donation donation) {
        Donation created = donationService.create(donation);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-donations")   
    public ResponseEntity<List<Donation>> getAll() {
        return ResponseEntity.ok(donationService.getAll());
    }

    @GetMapping("/get-donation/{id}")
    public ResponseEntity<Donation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(donationService.getById(id));
    }

    @PutMapping("/update-donation/{id}")
    public ResponseEntity<Donation> update(@PathVariable Long id,
                                           @RequestBody Donation donation) {
        return ResponseEntity.ok(donationService.update(id, donation));
    }

    @DeleteMapping("/delete-donation/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        donationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
