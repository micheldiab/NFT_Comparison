package ahmad;

public class Collection1 extends Collections {

		private double magicEdenFloorPrice;//magic provides long
		private double openSeaFloorPrice;//opensea provides float
		private String collectionName;
		private String symbol;
		private Boolean valid=true;
		
		
		
		
		
		public Boolean getValid() {
			return valid;
		}

		public void setValid(Boolean valid) {
			this.valid = valid;
		}

		@Override
		public boolean isNull() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public String toString() {
			return "Collection [magicEdenFloorPrice=" + magicEdenFloorPrice + ", openSeaFloorPrice=" + openSeaFloorPrice
					+ ", collectionName=" + collectionName + ", symbol=" + symbol + ", valid=" + valid + "]";
		}

		@Override
		public double getMagicEdenFloorPrice() {
			return magicEdenFloorPrice;
		}

		@Override
		public void setMagicEdenFloorPrice(double magicEdenFloorPrice) {
			this.magicEdenFloorPrice = magicEdenFloorPrice;
		}
		@Override
		public double getOpenSeaFloorPrice() {
			return openSeaFloorPrice;
		}
		@Override
		public void setOpenSeaFloorPrice(double openSeaFloorPrice) {
			this.openSeaFloorPrice = openSeaFloorPrice;
		}
		@Override
		public String getSymbol() {
			return symbol;
		}
		@Override
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		@Override
		public String getCollectionName() {
			return collectionName;
		}
		@Override
		public void setCollectionName(String collectionName) {
			this.collectionName = collectionName;
		}

		@Override
		protected void setValid(boolean b) {
			// TODO Auto-generated method stub
			
		}

		
		
		
	}

