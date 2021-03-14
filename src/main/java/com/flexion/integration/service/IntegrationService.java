package com.flexion.integration.service;


import com.flexion.integration.DTO.PurchaseResponse;
import com.flexion.integration.client.IntegrationClient;
import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class IntegrationService implements Integration {
		
		private final IntegrationClient integrationClient;
		
		@Value("${integration.developer-id}")
		private String developerId;
		
		private final static String ITEM = "iphone";
		
		
		@Override
		public Purchase buy(String s) {
				PurchaseResponse purchaseResponse = integrationClient.buyItem(developerId, s);
				return purchaseResponse;
		}
		
		@Override
		public List<Purchase> getPurchases() {
				List<Purchase> purchases = new ArrayList<>();
				PurchaseResponse purchaseResponses = integrationClient.getPurchases(developerId);
				
				for (PurchaseResponse p : purchaseResponses.getPurchases()) {
						purchases.add(p);
				}
				
				return purchases;
		}
		
		@Override
		public void consume(Purchase pur) {
				integrationClient.consumeItem(developerId, pur.getId());
		}
}
