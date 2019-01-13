package org.web.boarddto;

import java.sql.Timestamp;

public class BoardReview {

	private int review_No;
	private int review_Group;
	private int review_Indent;
	private int review_Step;
	private int review_Hit;
	private String review_Subject;
	private String review_Writer;
	private Timestamp review_date;
	private String review_fileDBName;
	private String review_fileRealName;
	private String review_fileDBName2;
	private String review_fileRealName2;
	private String review_Contents;
	private String review_Password;

	public BoardReview() {
		// TODO Auto-generated constructor stub
	}

	public BoardReview(int review_No, int review_Group, int review_Indent, int review_Step, int review_Hit,
			String review_Subject, String review_Writer, Timestamp review_date, String review_fileDBName,
			String review_fileRealName, String review_fileDBName2, String review_fileRealName2, String review_Contents,
			String review_Password) {
		super();
		this.review_No = review_No;
		this.review_Group = review_Group;
		this.review_Indent = review_Indent;
		this.review_Step = review_Step;
		this.review_Hit = review_Hit;
		this.review_Subject = review_Subject;
		this.review_Writer = review_Writer;
		this.review_date = review_date;
		this.review_fileDBName = review_fileDBName;
		this.review_fileRealName = review_fileRealName;
		this.review_fileDBName2 = review_fileDBName2;
		this.review_fileRealName2 = review_fileRealName2;
		this.review_Contents = review_Contents;
		this.review_Password = review_Password;
	}

	public final int getReview_No() {
		return review_No;
	}

	public final void setReview_No(int review_No) {
		this.review_No = review_No;
	}

	public final int getReview_Group() {
		return review_Group;
	}

	public final void setReview_Group(int review_Group) {
		this.review_Group = review_Group;
	}

	public final int getReview_Indent() {
		return review_Indent;
	}

	public final void setReview_Indent(int review_Indent) {
		this.review_Indent = review_Indent;
	}

	public final int getReview_Step() {
		return review_Step;
	}

	public final void setReview_Step(int review_Step) {
		this.review_Step = review_Step;
	}

	public final int getReview_Hit() {
		return review_Hit;
	}

	public final void setReview_Hit(int review_Hit) {
		this.review_Hit = review_Hit;
	}

	public final String getReview_Subject() {
		return review_Subject;
	}

	public final void setReview_Subject(String review_Subject) {
		this.review_Subject = review_Subject;
	}

	public final String getReview_Writer() {
		return review_Writer;
	}

	public final void setReview_Writer(String review_Writer) {
		this.review_Writer = review_Writer;
	}

	public final Timestamp getReview_date() {
		return review_date;
	}

	public final void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}

	public final String getReview_fileDBName() {
		return review_fileDBName;
	}

	public final void setReview_fileDBName(String review_fileDBName) {
		this.review_fileDBName = review_fileDBName;
	}

	public final String getReview_fileRealName() {
		return review_fileRealName;
	}

	public final void setReview_fileRealName(String review_fileRealName) {
		this.review_fileRealName = review_fileRealName;
	}

	public final String getReview_fileDBName2() {
		return review_fileDBName2;
	}

	public final void setReview_fileDBName2(String review_fileDBName2) {
		this.review_fileDBName2 = review_fileDBName2;
	}

	public final String getReview_fileRealName2() {
		return review_fileRealName2;
	}

	public final void setReview_fileRealName2(String review_fileRealName2) {
		this.review_fileRealName2 = review_fileRealName2;
	}

	public final String getReview_Contents() {
		return review_Contents;
	}

	public final void setReview_Contents(String review_Contents) {
		this.review_Contents = review_Contents;
	}

	public final String getReview_Password() {
		return review_Password;
	}

	public final void setReview_Password(String review_Password) {
		this.review_Password = review_Password;
	}

}
