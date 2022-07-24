package ahmad;

public abstract class Collections {
	
	public abstract double getMagicEdenFloorPrice();
	public abstract double getOpenSeaFloorPrice();
	public abstract String getSymbol();
	public abstract void setMagicEdenFloorPrice(double magicEdenFloorPrice) ;
	public abstract void setOpenSeaFloorPrice(double openSeaFloorPrice) ;

	public abstract void setSymbol(String symbol) ;
	public abstract String getCollectionName() ;

	public abstract void setCollectionName(String collectionName);
	public abstract boolean isNull();
	public abstract Boolean getValid();
	protected abstract void setValid(boolean b);
	

}
