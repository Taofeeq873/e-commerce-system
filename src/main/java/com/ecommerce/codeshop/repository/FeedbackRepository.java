package com.ecommerce.codeshop.repository;

import com.ecommerce.codeshop.model.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    List<Feedback> findFeedbacksByCustomerId(long CustomerId);
}
