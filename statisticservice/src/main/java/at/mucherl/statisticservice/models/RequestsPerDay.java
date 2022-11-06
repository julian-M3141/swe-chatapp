package at.mucherl.statisticservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestsPerDay {
    LocalDate day;
    Long numberOfRequests;
}
