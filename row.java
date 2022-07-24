package application;

public class row {
	
private String name;
private double opensea;
private double magic;
private Double diff;

public row(String name, Double opensea, Double magiccc, Double diff) {
	this.name = name;
	this.opensea = opensea;
	this.magic = magiccc;
	this.diff = diff;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Double getOpensea() {
	return opensea;
}

public void setOpensea(Double opensea) {
	this.opensea = opensea;
}

public Double getMagic() {
	return magic;
}

public void setMagic(double magic) {
	this.magic = magic;
}

public Double getDiff() {
	return diff;
}

public void setDiff(Double diff) {
	this.diff = diff;
}


}
