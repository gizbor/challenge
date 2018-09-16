package com.necar.fingerprint.repositories;
import org.springframework.data.repository.CrudRepository;

import com.necar.fingerprint.beans.FingerPrintLog;

/**
 * Repositorio para las operaciones CRUD.
 * @author Gustavo M. Borello
 *
 */
public interface FingerPrintLogCrudRepository extends CrudRepository<FingerPrintLog, Integer> {

}
