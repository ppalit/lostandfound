package dev.lof.bean;

import java.io.Serializable;
import java.util.Arrays;

public class RegisterItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 163350592495047077L;

	private Long id;
	private String itemType;
	private String itemColor;
	private String publicDescription;
	private String secretDescription;
	private String foundDate;
	private byte[] image;
	private LocationBean location;
	private ReporterBean reporter;

	public RegisterItemBean() {
		super();
		location = new LocationBean();
		setReporter(new ReporterBean());
	}

	public String getBeanString() {
		return this.toString();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType
	 *            the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the itemColor
	 */
	public String getItemColor() {
		return itemColor;
	}

	/**
	 * @param itemColor
	 *            the itemColor to set
	 */
	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	/**
	 * @return the secretDescription
	 */
	public String getSecretDescription() {
		return secretDescription;
	}

	/**
	 * @param secretDescription
	 *            the secretDescription to set
	 */
	public void setSecretDescription(String secretDescription) {
		this.secretDescription = secretDescription;
	}

	/**
	 * @return the foundDate
	 */
	public String getFoundDate() {
		return foundDate;
	}

	/**
	 * @param foundDate
	 *            the foundDate to set
	 */
	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	
	/**
	 * @return the location
	 */
	public LocationBean getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(LocationBean location) {
		this.location = location;
	}

	/**
	 * @return the publicDescription
	 */
	public String getPublicDescription() {
		return publicDescription;
	}

	/**
	 * @param publicDescription
	 *            the publicDescription to set
	 */
	public void setPublicDescription(String publicDescription) {
		this.publicDescription = publicDescription;
	}

	
	public ReporterBean getReporter() {
		return reporter;
	}

	public void setReporter(ReporterBean reporter) {
		this.reporter = reporter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterItemBean ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (itemType != null ? "itemType=" + itemType + ", " : "")
				+ (itemColor != null ? "itemColor=" + itemColor + ", " : "")
				+ (publicDescription != null ? "publicDescription="
						+ publicDescription + ", " : "")
				+ (secretDescription != null ? "secretDescription="
						+ secretDescription + ", " : "")
				+ (foundDate != null ? "foundDate=" + foundDate + ", " : "")
				+ (image != null ? "image=" + Arrays.toString(image) + ", "
						: "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (reporter != null ? "reporter=" + reporter.toString() : "") + "]";
	}
	
	

}