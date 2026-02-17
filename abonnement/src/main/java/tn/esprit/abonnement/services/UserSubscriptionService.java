package tn.esprit.abonnement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.abonnement.entity.UserSubscription;
import tn.esprit.abonnement.repository.UserSubscriptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSubscriptionService {

    private final UserSubscriptionRepository userSubscriptionRepository;

    public UserSubscription create(UserSubscription subscription) {
        return userSubscriptionRepository.save(subscription);
    }

    public UserSubscription update(Long id, UserSubscription subscription) {
        UserSubscription existing = userSubscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserSubscription not found with id: " + id));

        existing.setUserId(subscription.getUserId());
        existing.setPlan(subscription.getPlan());
        existing.setSubscribedAt(subscription.getSubscribedAt());
        existing.setExpiresAt(subscription.getExpiresAt());
        existing.setStatus(subscription.getStatus());

        return userSubscriptionRepository.save(existing);
    }

    public void delete(Long id) {
        if (!userSubscriptionRepository.existsById(id)) {
            throw new RuntimeException("UserSubscription not found with id: " + id);
        }
        userSubscriptionRepository.deleteById(id);
    }

    public UserSubscription getById(Long id) {
        return userSubscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserSubscription not found with id: " + id));
    }

    public List<UserSubscription> getAll() {
        return userSubscriptionRepository.findAll();
    }
}
