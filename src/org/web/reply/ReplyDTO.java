package org.web.reply;

import java.sql.Timestamp;

public class ReplyDTO {

	private int reply_No;
	private int review_No;
	private int reply_Group;
	private int reply_Indent;
	private int reply_Step;
	private String reply_Subject;
	private String reply_Writer;
	private Timestamp reply_Date;
	private String reply_Contents;
	private String reply_Password;

	public ReplyDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReplyDTO(int reply_No, int review_No, int reply_Group, int reply_Indent, int reply_Step,
			String reply_Subject, String reply_Writer, Timestamp reply_Date, String reply_Contents,
			String reply_Password) {
		super();
		this.reply_No = reply_No;
		this.review_No = review_No;
		this.reply_Group = reply_Group;
		this.reply_Indent = reply_Indent;
		this.reply_Step = reply_Step;
		this.reply_Subject = reply_Subject;
		this.reply_Writer = reply_Writer;
		this.reply_Date = reply_Date;
		this.reply_Contents = reply_Contents;
		this.reply_Password = reply_Password;
	}

	public int getReply_No() {
		return reply_No;
	}

	public void setReply_No(int reply_No) {
		this.reply_No = reply_No;
	}

	public int getReview_No() {
		return review_No;
	}

	public void setReview_No(int review_No) {
		this.review_No = review_No;
	}

	public int getReply_Group() {
		return reply_Group;
	}

	public void setReply_Group(int reply_Group) {
		this.reply_Group = reply_Group;
	}

	public int getReply_Indent() {
		return reply_Indent;
	}

	public void setReply_Indent(int reply_Indent) {
		this.reply_Indent = reply_Indent;
	}

	public int getReply_Step() {
		return reply_Step;
	}

	public void setReply_Step(int reply_Step) {
		this.reply_Step = reply_Step;
	}

	public String getReply_Subject() {
		return reply_Subject;
	}

	public void setReply_Subject(String reply_Subject) {
		this.reply_Subject = reply_Subject;
	}

	public String getReply_Writer() {
		return reply_Writer;
	}

	public void setReply_Writer(String reply_Writer) {
		this.reply_Writer = reply_Writer;
	}

	public Timestamp getReply_Date() {
		return reply_Date;
	}

	public void setReply_Date(Timestamp reply_Date) {
		this.reply_Date = reply_Date;
	}

	public String getReply_Contents() {
		return reply_Contents;
	}

	public void setReply_Contents(String reply_Contents) {
		this.reply_Contents = reply_Contents;
	}

	public String getReply_Password() {
		return reply_Password;
	}

	public void setReply_Password(String reply_Password) {
		this.reply_Password = reply_Password;
	}

}
