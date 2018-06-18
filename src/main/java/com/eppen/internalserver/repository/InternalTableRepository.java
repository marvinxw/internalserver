package com.eppen.internalserver.repository;

import com.eppen.internalserver.models.InternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InternalTableRepository extends JpaRepository<InternalTable, Long> {

    // 查询comment like 的所有库信息
    @Query(value = "select new Map(" +
            "id as id, " +
            "name as name, " +
            "uuid as uuid) " +
            "from ExternalTable " +
            "where updatedAt >= :timestamp " +
            " ")
    List<Map<String, Object>> getAllByUpdateTimeLimitn(@Param("timestamp") String timestamp);
}
