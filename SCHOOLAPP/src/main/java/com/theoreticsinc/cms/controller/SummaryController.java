package com.theoreticsinc.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theoreticsinc.cms.model.Inventory;
import com.theoreticsinc.cms.services.InventoryService;
import com.theoreticsinc.cms.vo.InventorySummaryVO;

@Controller
@RequestMapping("/cms")
public class SummaryController {
	
	@Autowired
	InventoryService inventoryService;
	
	static final Logger logger = Logger.getLogger(SummaryController.class);

	@RequestMapping(value="/inventorysummary", method = RequestMethod.GET)
	public String getInventorySummary(ModelMap model) {
		logger.info("Received request to show Inventory Summary");
		model.addAttribute("message", "Inventory");
		return "inventorysumry";
	}
	
	@RequestMapping(value="/salessummary", method = RequestMethod.GET)
	public String getSalesSummary(ModelMap model) {
		logger.info("Received request to show Sales Summary");
		model.addAttribute("message", "Sales");
		return "salessumry";
	}
	
	/** GET Request 
	 * @throws JSONException **/
	@RequestMapping(value = "/searchInventoryCode/{productcode:.+}/{brand:.+}/{categorycode:.+}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<InventorySummaryVO> searchProductCodeGET(@PathVariable("productcode") String productcode,
			@PathVariable("brand") String brand, @PathVariable("categorycode") String categorycode) throws Exception{
		
		logger.info(" Request for searchInventoryCodeGET() " + productcode + "/" + brand + "/" + categorycode);
		List<InventorySummaryVO> searchInventoryList = new ArrayList<InventorySummaryVO>();
		
		try{
			searchInventoryList = inventoryService.searchProductCode(productcode, brand, categorycode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchInventoryList;
	}
}
