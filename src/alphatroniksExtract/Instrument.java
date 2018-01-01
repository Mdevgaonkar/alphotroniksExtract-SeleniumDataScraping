package alphatroniksExtract;

public class Instrument {
	
	private String instrumentName;
	private String instrumentSubtitle;
	private int mrp;
	private int sellingPrice;
	private String description;
	private String photoFile;
	private String type;
	public String getInstrumentName() {
		return instrumentName;
	}
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	public String getInstrumentSubtitle() {
		return instrumentSubtitle;
	}
	public void setInstrumentSubtitle(String instrumentSubtitle) {
		this.instrumentSubtitle = instrumentSubtitle;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getphotoFile() {
		return photoFile;
	}
	public void setphotoFile(String photoUrl) {
		this.photoFile = photoUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
