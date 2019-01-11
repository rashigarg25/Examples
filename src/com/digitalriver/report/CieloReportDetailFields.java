
package com.digitalriver.report;

public enum CieloReportDetailFields implements CieloReportFields {
	DETAIL_LINE(1, 1),
	DETAIL_BANK_MERCHANT_ID(2, 10),
	DETAIL_BATCH_ID(12, 7),
	DETAIL_CARD_NUMBER(19, 19),
	DETAIL_BANK_PROCESSING_DATE(38, 8),
	DETAIL_INITIAL_GROSS_AMOUNT(46, 14),
	DETAIL_INSTALLMENT_NUMBER(60, 2),
	DETAIL_TOTAL_INSTALLMENTS(62, 2),
	DETAIL_DECLINE_REASON(64, 3),
	DETAIL_BANK_AUTH_CODE(67, 6),
	DETAIL_BANK_REF_ID(73, 20),
	DETAIL_NSU(93, 6),
	DETAIL_CARD_NUMBER_LENGTH(112, 2),
	DETAIL_ORDER_AMOUNT(114, 13),
	DETAIL_SUBSEQUENT_GROSS_AMOUNT(127, 13);

	private int start;
	private int length;

	public int getStart() {

		return start;
	}

	public void setStart(int start) {

		this.start = start;
	}

	public int getLength() {

		return length;
	}

	public void setLength(int length) {

		this.length = length;
	}

	CieloReportDetailFields(int start, int length) {

		this.start = start;
		this.length = length;
	}

	@Override
	public String getName() {

		return this.name();
	}
}
