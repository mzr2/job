package com.test.dans.controller;

import com.test.dans.model.csv.CsvExportService;
import com.test.dans.model.component.Job;
import com.test.dans.model.response.BaseResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping(path = "job")
public class JobController {

    private final CsvExportService csvExportService;

    public JobController(CsvExportService csvExportService) {
        this.csvExportService = csvExportService;
    }

    @GetMapping("/obj2")
    public Object getJobList2(){
        try {
            String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
            RestTemplate restTemplate = new RestTemplate();
            Job[] jobs = restTemplate.getForObject(url, Job[].class);
            return jobs;
        } catch (Exception e) {
            return new BaseResponse("Data Not Found", HttpStatus.NO_CONTENT.value(), null);
        }
    }

    @GetMapping("")
    public BaseResponse getJobList(){
        try {
            String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
            RestTemplate restTemplate = new RestTemplate();
            Object[] jobs = restTemplate.getForObject(url, Object[].class);
            return new BaseResponse("Data Found", HttpStatus.OK.value(), jobs);
        } catch (Exception e) {
            return new BaseResponse("Data Not Found", HttpStatus.NO_CONTENT.value(), null);
        }
    }


//    @GetMapping("/{id}")
//    public BaseResponse getJobDetail(@PathVariable("id") String id){
    @GetMapping("/detail")
    @ResponseBody
    public BaseResponse getJobDetail(@RequestParam("id") String id){
        try {
            String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id;
            RestTemplate restTemplate = new RestTemplate();
            Object job = restTemplate.getForObject(url, Object.class);
            return new BaseResponse("Data Found", HttpStatus.OK.value(), job);
        } catch (Exception e) {
            return new BaseResponse("Data Not Found", HttpStatus.NO_CONTENT.value(), null);
        }
    }

//    @GetMapping("/downloadJobList")
//    public BaseResponse downloadJobList(){
//        try {
//
//        } catch (Exception e) {
//            return new BaseResponse();
//        }
//    }

    @RequestMapping(path = "/download-job-list")
    public void getAllJobsInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"Job_List.csv\"");
        csvExportService.writeJobsToCsv(servletResponse.getWriter());
    }

}
