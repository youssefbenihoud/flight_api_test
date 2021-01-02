package com.thb.flightapiv1.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thb.flightapiv1.domain.bean.Plane;

@Repository
public interface PlaneDao extends JpaRepository<Plane, Long> {

	public Plane findByHexcode(String hexcode);
}
