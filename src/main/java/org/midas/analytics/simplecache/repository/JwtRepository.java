package org.midas.analytics.simplecache.repository;

import org.midas.analytics.simplecache.model.JwtDetails;
import org.springframework.data.repository.CrudRepository;

public interface JwtRepository extends CrudRepository<JwtDetails, String> {

}
