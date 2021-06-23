package com.kpsec.test.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kpsec.test.model.AccountResult;
import com.kpsec.test.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Sample")
@RestController
@RequestMapping("/test/")
public class SampleController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "sample")
    @GetMapping(value = "/account")
    public List<AccountResult> getAccountInfo(String branchCode) {
    	List<AccountResult> list = accountService.getAccountByBranchCode(branchCode);
        return list;
    }
}
