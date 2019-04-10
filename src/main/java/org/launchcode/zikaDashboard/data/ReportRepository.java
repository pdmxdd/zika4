package org.launchcode.zikaDashboard.data;

import org.launchcode.zikaDashboard.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
}
