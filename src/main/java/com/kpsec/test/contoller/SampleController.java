package com.kpsec.test.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kpsec.test.model.NonServiceCustomerResult;
import com.kpsec.test.model.TopCustomerResult;
import com.kpsec.test.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Sample")
@RestController
@RequestMapping("/api/")
public class SampleController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "first")
    @GetMapping(value = "/first")
    @ResponseBody
    public List<TopCustomerResult> getTopCustomerOfYear(String branchCode) {
    	List<TopCustomerResult> list = accountService.getTopCustomerOfYear(branchCode);
        return list;
    }

    @ApiOperation(value = "second")
    @GetMapping(value = "/second")
    @ResponseBody
    public List<NonServiceCustomerResult> getNonServiceCustomer() {
    	List<NonServiceCustomerResult> list = accountService.getNonServiceCustomer();
    	return list;
    }
    
//    
//    @ApiOperation(value = "third")
//    @GetMapping(value = "/third")
//    public List<AccountResult> getThird(String branchCode) {
//    	List<AccountResult> list = accountService.getAccountByBranchCode(branchCode);
//    	return list;
//    }
//    
//    @ApiOperation(value = "fourth")
//    @GetMapping(value = "/fourth")
//    public List<AccountResult> getFourth(String branchCode) {
//    	List<AccountResult> list = accountService.getAccountByBranchCode(branchCode);
//    	return list;
//    }
    
    
}
