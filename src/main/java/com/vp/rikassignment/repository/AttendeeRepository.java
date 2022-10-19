package com.vp.rikassignment.repository;

import com.vp.rikassignment.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, String> {

}
