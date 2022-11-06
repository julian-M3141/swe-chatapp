package at.mucherl.statisticservice.dataAccess;

import at.mucherl.statisticservice.models.Request;
import at.mucherl.statisticservice.models.RequestsPerDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Long> {

    @Query("select new at.mucherl.statisticservice.models.RequestsPerDay(  r.date ,count(r.date)) "
            + " from Request r group by r.date")
    List<RequestsPerDay> countAllByDay();

}
