package com.necar.fingerprint.daoImpl;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.necar.fingerprint.beans.FingerPrintLog;
import com.necar.fingerprint.dao.FingerPrintLogDAO;
import com.necar.fingerprint.repositories.FingerPrintLogCrudRepository;
import com.necar.fingerprint.repositories.FingerPrintLogJpaRepository;


@Repository
@Transactional
public class FingerPrintLogDaoImpl implements FingerPrintLogDAO {

	@Autowired 
	private FingerPrintLogCrudRepository fingerPrintLogCrudRepository;
	@Autowired 
	private FingerPrintLogJpaRepository fingerPrintLogJpaRepository;	

	@Override
	public boolean save(FingerPrintLog fingerPrintLog) {
		fingerPrintLogCrudRepository.save(fingerPrintLog);
		return true;
	}

	@Override
	public List<FingerPrintLog> findAllSucessful() {
		List<FingerPrintLog> r= fingerPrintLogJpaRepository.findAllByResult('S');
		return r;
	}

	@Override
	public List<FingerPrintLog> findAllFailed() {
		List<FingerPrintLog> r= fingerPrintLogJpaRepository.findAllByResult('F');
		return r;
	}

}
