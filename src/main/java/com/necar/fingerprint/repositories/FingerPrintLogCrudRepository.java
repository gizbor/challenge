package com.necar.fingerprint.repositories;
import org.springframework.data.repository.CrudRepository;

import com.necar.fingerprint.beans.FingerPrintLog;

public interface FingerPrintLogCrudRepository extends CrudRepository<FingerPrintLog, Integer> {

}
