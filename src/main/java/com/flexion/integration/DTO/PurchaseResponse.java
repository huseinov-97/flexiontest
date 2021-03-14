package com.flexion.integration.DTO;


import com.flexionmobile.codingchallenge.integration.Purchase;
import lombok.Setter;

import java.util.List;


@Setter
public class PurchaseResponse implements Purchase {
		
		private String id;
		private String itemId;
		private boolean consumed;
		private List<PurchaseResponse> purchases;
		
		public List<PurchaseResponse> getPurchases() {
				return purchases;
		}
		
		@Override
		public String getId() {
				return id;
		}
		
		@Override
		public boolean getConsumed() {
				return consumed;
		}
		
		@Override
		public String getItemId() {
				return itemId;
		}
}
