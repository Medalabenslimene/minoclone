package tn.esprit.abonnement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.abonnement.entity.UserSubscription;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
}
