package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Member;
import com.example.shoppingweb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void registerMember(Member member) {
        LocalDateTime now = LocalDateTime.now();
        member.setRegisterDate(now);
        memberRepository.save(member);
    }
    public Member login(String id, String password) {
        return memberRepository.findByIdAndPassword(id, password).orElse(null); // 如果找不到，返回 null
    }

    public void update(Member updateMember) {
        if (memberRepository.findById(updateMember.getId()).isPresent()) {
            Member member = memberRepository.findById(updateMember.getId()).get();
            if (!member.getName().equals(updateMember.getName())) {
                member.setName(updateMember.getName());
            }
            if (!member.getPhone().equals(updateMember.getPhone())) {
                member.setPhone(updateMember.getPhone());
            }
            if (!member.getEmail().equals(updateMember.getEmail())) {
                member.setEmail(updateMember.getEmail());
            }
            if (!member.getPassword().equals(updateMember.getPassword())) {
                member.setPassword(updateMember.getPassword());
            }
            memberRepository.save(member);
        } else {
            System.out.println("Member not found");
        }
    }

    public Member findById(String id) {
        return memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Member not found with id: " + id));
    }
}
