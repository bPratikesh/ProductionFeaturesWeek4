package com.pratikesh.prod_ready_features.prodReadyFeatures.repositories;

import com.pratikesh.prod_ready_features.prodReadyFeatures.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
