package com.vladeks.testapp.repository;

import com.vladeks.testapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@PreAuthorize("hasRole('ROLE_USER')")
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends Question> S save(S s);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteById(Long aLong);


}
