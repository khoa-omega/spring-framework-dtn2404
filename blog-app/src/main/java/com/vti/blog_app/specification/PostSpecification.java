package com.vti.blog_app.specification;

import com.vti.blog_app.entity.Post;
import com.vti.blog_app.form.PostFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostSpecification {
    public static Specification<Post> buildSpec(PostFilterForm form) {
        return form == null ? null : new Specification<Post>() {
            @Override
            public Predicate toPredicate(
                    Root<Post> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ) {
                var predicates = new ArrayList<Predicate>();

                String search = form.getSearch();
                if (search != null) {
                    // ... title LIKE "%...%"
                    var predicate = builder.like(
                            root.get("title"),
                            "%" + search + "%"
                    );
                    predicates.add(predicate);
                }

                var minCreatedDate = form.getMinCreatedDate();
                if (minCreatedDate != null) {
                    var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                    // ... WHERE created_at >= ?
                    var predicate = builder.greaterThanOrEqualTo(
                            root.get("createdAt"),
                            minCreatedAt
                    );
                    predicates.add(predicate);
                }

                var maxCreatedDate = form.getMaxCreatedDate();
                if (maxCreatedDate != null) {
                    var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                    // ... WHERE created_at <= ?
                    var predicate = builder.lessThanOrEqualTo(
                            root.get("createdAt"),
                            maxCreatedAt
                    );
                    predicates.add(predicate);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
