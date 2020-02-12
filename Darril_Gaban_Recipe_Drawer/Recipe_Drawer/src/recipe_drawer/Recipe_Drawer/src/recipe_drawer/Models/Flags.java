package recipe_drawer.Models;

public class Flags {
	private int flagId;
	private String flagName;
	
	public Flags() {
		// TODO Auto-generated constructor stub
	}

	public Flags(int flagId, String flagName) {
		super();
		this.flagId = flagId;
		this.flagName = flagName;
	}

	/**
	 * @return the flagId
	 */
	public int getFlagId() {
		return flagId;
	}

	/**
	 * @param flagId the flagId to set
	 */
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}

	/**
	 * @return the flagName
	 */
	public String getFlagName() {
		return flagName;
	}

	/**
	 * @param flagName the flagName to set
	 */
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

}
