package recipe_drawer.Models;

public class CommentReply {
	private int commentId;
	private int commentParent;
	private String commentUser;
	private String commentText;
	private String commentTime;
	
	public CommentReply() {
		// TODO Auto-generated constructor stub
	}

	public CommentReply(int commentId, int commentParent, String commentUser, String commentText, String commentTime) {
		super();
		this.commentId = commentId;
		this.commentParent = commentParent;
		this.commentUser = commentUser;
		this.commentText = commentText;
		this.commentTime = commentTime;
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
	 * @return the commentParent
	 */
	public int getCommentParent() {
		return commentParent;
	}

	/**
	 * @param commentParent the commentParent to set
	 */
	public void setCommentParent(int commentParent) {
		this.commentParent = commentParent;
	}

	/**
	 * @return the commentUser
	 */
	public String getCommentUser() {
		return commentUser;
	}

	/**
	 * @param commentUser the commentUser to set
	 */
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	/**
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	/**
	 * @return the commentTime
	 */
	public String getCommentTime() {
		return commentTime;
	}

	/**
	 * @param commentTime the commentTime to set
	 */
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

}
