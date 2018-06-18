package com.eppen.internalserver.web;

import com.eppen.internalserver.common.ApiResponse;
import com.eppen.internalserver.models.InternalTable;
import com.eppen.internalserver.repository.InternalTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/Internal")
public class InternalServerController {

    @Autowired
    private InternalTableRepository internalTableRepository;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponse<InternalTable> save(@ModelAttribute(value="InternalTable") InternalTable InternalTable) {

        InternalTable.setDelFlag(1l);
        internalTableRepository.save(InternalTable);
        ApiResponse<InternalTable> res = new ApiResponse<>();
        res.setCode(ApiResponse.OK);
        res.setData(InternalTable);
        res.setMsg("成功!!!");

        return res;
    }

    @RequestMapping("")
    public String indIn(ModelMap map) {
        return "index";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
//    @ResponseBody
//    public ApiResponse<InternalTable> addDatabase(@RequestBody String requestBody) {
//
//        InternalTable InternalTable = JSONObject.parseObject(requestBody, InternalTable.class);
//
//        InternalTable = InternalTableRepository.save(InternalTable);
//
//        ApiResponse<InternalTable> res = new ApiResponse<>();
//        res.setCode(ApiResponse.OK);
//        res.setMsg("SUCCESS");
//        res.setData(InternalTable);
//        return res;
//    }
}
