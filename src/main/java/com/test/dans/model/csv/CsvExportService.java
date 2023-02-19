package com.test.dans.model.csv;

import com.test.dans.model.component.Job;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Writer;


@Service
public class CsvExportService {
//    private static final Logger log = getLogger(CsvExportService.class);

//    private final EmployeeRepository employeeRepository;
//
//    public CsvExportService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    public void writeJobsToCsv(Writer writer) {

        String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        RestTemplate restTemplate = new RestTemplate();
        Job[] jobs = restTemplate.getForObject(url, Job[].class);

        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withDelimiter(';'))) {

            for (Job job : jobs) {
//                ObjectMapper objectMapper = new ObjectMapper();
//                Job jobDtl = objectMapper.readValue(job, Job.class);
//                Job jobDtl = (Job) job;
//                System.out.println(jobDtl);
                csvPrinter.printRecord(job.getId(), job.getType(), job.getUrl(), job.getCreatedAt(), job.getCompany(), job.getCompanyUrl(), job.getLocation(), job.getTitle(), job.getDescription(), job.getHowToApply(), job.getCompanyLogo());
            }
        } catch (IOException e) {
//            log.error("Error While writing CSV ", e);
        }
    }
}
