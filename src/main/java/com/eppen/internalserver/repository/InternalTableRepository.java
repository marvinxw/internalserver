package com.eppen.internalserver.repository;

import com.eppen.internalserver.models.InternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface InternalTableRepository extends JpaRepository<InternalTable, Long> {
    @Query(nativeQuery = true, value = "select ifnull(max(updated_at), '2018-06-18 17:20:45') as maxUpdatetime from eppen_internal_server_table")
    Map<String, Object> getMaxUpdateTime();
}
