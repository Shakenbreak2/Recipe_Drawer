package recipe_drawer.Models;

public class Report {
	private int commentId;
	private int reporterId;
	private String reportReason;
	private String reportTime;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(int commentId, int reporterId, String reportReason, String reportTime) {
		super();
		this.commentId = commentId;
		this.reporterId = reporterId;
		this.reportReason = reportReason;
		this.reportTime = reportTime;
	}

	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the reporterId
	 */
	public int getReporterId() {
		return reporterId;
	}

	/**
	 * @param reporterId the reporterId to set
	 */
	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
	}

	/**
	 * @return the reportReason
	 */
	public String getReportReason() {
		return reportReason;
	}

	/**
	 * @param reportReason the reportReason to set
	 */
	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	/**
	 * @return the reportTime
	 */
	public String getReportTime() {
		return reportTime;
	}

	/**
	 * @param reportTime the reportTime to set
	 */
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

}
