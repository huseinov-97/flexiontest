package com.flexion.integration.controller;


import com.flexion.integration.DTO.PurchaseResponse;
import com.flexion.integration.service.IntegrationService;
import com.flexionmobile.codingchallenge.integration.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/integration")
@RequiredArgsConstructor
public class Controller {
		
		private final IntegrationService service;
		
		@PostMapping("/buy/{itemId}")
		public Purchase buyItem(@PathVariable String itemId) {
				
				return service.buy(itemId);
		}
		
		@GetMapping("/all")
		public List<Purchase> getPurchaseList() {
				return service.getPurchases();
		}
		
		@PostMapping("/consume/{purchaseId}")
		public void consume(@PathVariable String purchaseId) {
				Purchase purchase = new PurchaseResponse();
				((PurchaseResponse) purchase).setId(purchaseId);
				service.consume(purchase);
		}
		
		
}
