package com.example.shoppingweb.repository;

import com.example.shoppingweb.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmailAndPassword(String email, String password);
}
