package tn.esprit.abonnement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.abonnement.entity.UserSubscription;
import tn.esprit.abonnement.services.UserSubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/abonnements")
@RequiredArgsConstructor
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    @PostMapping("/create-subscription")
    public ResponseEntity<UserSubscription> create(@RequestBody UserSubscription subscription) {
        UserSubscription created = userSubscriptionService.create(subscription);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-subscriptions")
    public ResponseEntity<List<UserSubscription>> getAll() {
        return ResponseEntity.ok(userSubscriptionService.getAll());
    }

    @GetMapping("/get-subscription/{id}")
    public ResponseEntity<UserSubscription> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userSubscriptionService.getById(id));
    }

    @PutMapping("/update-subscription/{id}")
    public ResponseEntity<UserSubscription> update(@PathVariable Long id,
                                                   @RequestBody UserSubscription subscription) {
        return ResponseEntity.ok(userSubscriptionService.update(id, subscription));
    }

    @DeleteMapping("/delete-subscription/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userSubscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
