package org.perscholas.login.model;





import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="profile")
public class Profile {

	
	@Id
	@Column(name="id")
	private int id;
	
    @Size(max = 125)
    @Column(name = "name")
	private String pName;
    
    @Size(max = 500)
	@Column(name="bio")
	private String pBio;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "dob")
	private Date dob;
	
	@Lob@Basic(fetch=FetchType.LAZY)
	   @Column(name="picture", columnDefinition="BLOB")
	private byte[] picture;
	
	@OneToOne
	@MapsId
	private Login login;
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(String pName, String pBio, Date dob, byte[] picture) {
		super();
		this.pName = pName;
		this.pBio = pBio;
		this.dob = dob;
		this.picture = picture;
	}
	
	public int getId() {
		return id;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setId(int pId) {
		this.id = pId;
	}
	/**
	 * @return the pName
	 */
	
	public String getpName() {
		return pName;
	}
	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * @return the pBio
	 */
	
	public String getpBio() {
		return pBio;
	}
	/**
	 * @param pBio the pBio to set
	 */
	public void setpBio(String pBio) {
		this.pBio = pBio;
	}
	/**
	 * @return the address
	 */
	
	public Date getAddress() {
		return dob;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the picture
	 */
	
	public byte[] getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
	
}
