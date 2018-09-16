package com.necar.fingerprint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.necar.fingerprint.beans.FingerPrintLog;

public interface FingerPrintLogJpaRepository extends JpaRepository<FingerPrintLog, Long> {

	List<FingerPrintLog> findAllByResult(char c);

}
