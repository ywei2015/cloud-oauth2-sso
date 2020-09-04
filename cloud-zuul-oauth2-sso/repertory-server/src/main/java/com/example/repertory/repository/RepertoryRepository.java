package com.example.repertory.repository;

import com.example.common.entity.Repertory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yinweiwei
 * @date 2019-02-12
 */
public interface RepertoryRepository extends JpaSpecificationExecutor<Repertory>, JpaRepository<Repertory, Integer> {

}
