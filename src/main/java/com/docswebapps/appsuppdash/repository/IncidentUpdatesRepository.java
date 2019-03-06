package com.docswebapps.appsuppdash.repository;

import com.docswebapps.appsuppdash.domain.IncidentUpdates;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Spring Data  repository for the IncidentUpdates entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IncidentUpdatesRepository extends JpaRepository<IncidentUpdates, Long> {
    @Query(value = "select * from incident_updates i where i.in_update_id = :incidentID", nativeQuery = true)
    List<IncidentUpdates> findIncidentUpdates(@Param("incidentID") Long incidentID);

    @Modifying
    @Transactional
    @Query(value = "delete from incident_updates i where i.in_update_id = :incidentID", nativeQuery = true)
    void deleteIncidentUpdates(@Param("incidentID") Long incidentID);
}