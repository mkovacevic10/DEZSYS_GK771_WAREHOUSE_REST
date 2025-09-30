package rest.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WarehouseData {
	
	private String warehouseID;
	private String warehouseName;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
	private String timestamp;
    private List<ProductData> productdata;

    public void setProduktdata(List<ProductData> produktdata) {
        this.productdata = produktdata;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public List<ProductData> getProductdata() {
        return productdata;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    /**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}

	/**
	 * Setter and Getter Methods
	 */
	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", warehouseID, timestamp );
		return info;
	}
}
