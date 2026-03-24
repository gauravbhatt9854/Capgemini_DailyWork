package com.gal.controller;


import com.gal.dto.IssueDTO;
import com.gal.model.Issue;
import com.gal.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    private Logger logger = LoggerFactory.getLogger(IssueController.class);

    @GetMapping("/unresolved")
    public ResponseEntity<List<IssueDTO>> findUnresolvedIssuesByEmployeeId(@RequestParam("emp_id") Long emp_id){

        logger.info("requst for findUnresolvedIssuesByEmployeeId for emp_id " +  emp_id);
        List<Issue> list;

        try{
            list = issueService.findUnresolvedIssuesByEmployeeId(emp_id);
        }
        catch (IllegalArgumentException exception){
            logger.warn("incorrect emloyee emp_id : " + emp_id);
            return ResponseEntity.badRequest().body(null);
        }

        List<IssueDTO> list1 =
                list.stream().map(IssueDTO::new).toList();

        logger.info("response for findByEmployeeId for emp_id " +  emp_id);
        return ResponseEntity.ok(list1);
    }

    @GetMapping("/currentmonth")
    public ResponseEntity<List<IssueDTO>> findAllIssueOfCurrentMonth(){

        logger.info("requst for findAllIssueOfCurrentMonth");
        List<Issue> list = issueService.findAllIssueOfCurrentMonth();
        List<IssueDTO> list1 =
                list.stream().map(IssueDTO::new).toList();

        logger.info("response for findAllIssueOfCurrentMonth");
        return ResponseEntity.ok(list1);
    }

    @GetMapping("/currentmonth/raisedBy")
    ResponseEntity<Set<String>> findEmployeeNameWhoRaisedIssueInCurrentMonth(){

        logger.info("requst for findEmployeeNameWhoRaisedIssueInCurrentMonth");
        Set<String> list = issueService.findEmployeeNameWhoRaisedIssueInCurrentMonth();
        logger.info("reponse for findEmployeeNameWhoRaisedIssueInCurrentMonth");
        return ResponseEntity.ok(list);
    }
}
