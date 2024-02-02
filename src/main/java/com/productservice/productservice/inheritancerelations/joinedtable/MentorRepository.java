package com.productservice.productservice.inheritancerelations.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_mentorRepository")
public interface MentorRepository extends JpaRepository<Mentor,Long> {

    @Override
    Mentor save(Mentor mentor);
}
