package org.launchcode.zikaDashboard.data;

import org.launchcode.zikaDashboard.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByDateString(String dateString);

    @Query("SELECT DISTINCT dateString FROM Report")
    List<String> allDatesDistinct();
}
