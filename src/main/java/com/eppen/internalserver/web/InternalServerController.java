package com.eppen.internalserver.web;

import com.eppen.internalserver.common.ApiResponse;
import com.eppen.internalserver.models.InternalTable;
import com.eppen.internalserver.repository.InternalTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/internal")
public class InternalServerController {

    @Autowired
    private InternalTableRepository internalTableRepository;

    @RequestMapping("")
    public String index(ModelMap map) {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponse<InternalTable> save(@ModelAttribute(value="internalTable") InternalTable internalTable) {

        internalTable.setDelFlag(1l);
        internalTableRepository.save(internalTable);
        ApiResponse<InternalTable> res = new ApiResponse<>();
        res.setCode(ApiResponse.OK);
        res.setData(internalTable);
        res.setMsg("成功!!!");

        return res;
    }
}
