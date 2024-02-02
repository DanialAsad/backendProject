package com.productservice.productservice.inheritancerelations.tableperclass;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_studentRepository")
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Override
    <S extends Student> S save(S entity);
}
