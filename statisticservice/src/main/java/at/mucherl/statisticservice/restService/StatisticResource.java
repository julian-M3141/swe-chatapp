package at.mucherl.statisticservice.restService;


import at.mucherl.statisticservice.dataAccess.RequestRepository;
import at.mucherl.statisticservice.models.RequestsPerDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/resource/statistic")
public class StatisticResource {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping
    List<RequestsPerDay> getAllRequestsPerDay(){
        return requestRepository.countAllByDay();
    }
}
