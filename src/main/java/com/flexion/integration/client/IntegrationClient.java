package com.flexion.integration.client;


import com.flexion.integration.DTO.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "integration", url = "http://35.165.217.100:80/javachallenge/rest/developer")
@RequestMapping("/")
public interface IntegrationClient {
		
		@PostMapping("{developerId}/buy/{itemId}")
		PurchaseResponse buyItem(@PathVariable String developerId, @PathVariable String itemId);
		
		@GetMapping("{developerId}/all")
		PurchaseResponse getPurchases(@PathVariable String developerId);
		
		@PostMapping("{developerId}/consume/{purchaseId}")
		void consumeItem(@PathVariable String developerId, @PathVariable String purchaseId);
		
		
}
