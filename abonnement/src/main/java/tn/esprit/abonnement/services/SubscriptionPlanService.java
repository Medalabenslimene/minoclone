package tn.esprit.abonnement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.abonnement.entity.SubscriptionPlan;
import tn.esprit.abonnement.repository.SubscriptionPlanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanService {

    private final SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlan create(SubscriptionPlan plan) {
        return subscriptionPlanRepository.save(plan);
    }

    public SubscriptionPlan update(Long id, SubscriptionPlan plan) {
        SubscriptionPlan existing = subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubscriptionPlan not found with id: " + id));

        existing.setName(plan.getName());
        existing.setPrice(plan.getPrice());
        existing.setDurationDays(plan.getDurationDays());
        existing.setDescription(plan.getDescription());

        return subscriptionPlanRepository.save(existing);
    }

    public void delete(Long id) {
        if (!subscriptionPlanRepository.existsById(id)) {
            throw new RuntimeException("SubscriptionPlan not found with id: " + id);
        }
        subscriptionPlanRepository.deleteById(id);
    }

    public SubscriptionPlan getById(Long id) {
        return subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubscriptionPlan not found with id: " + id));
    }

    public List<SubscriptionPlan> getAll() {
        return subscriptionPlanRepository.findAll();
    }
}
