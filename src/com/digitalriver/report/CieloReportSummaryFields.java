
package com.digitalriver.report;

public enum CieloReportSummaryFields implements CieloReportFields {
	SUMMARY_LINE(1, 1),
	SUMMARY_BANK_MERCHANT_ID(2, 10),
	SUMMARY_BATCH_ID(12, 7),
	SUMMARY_INSTALLMENT_NUMBER(19, 2),
	SUMMARY_FILLER(21, 1),
	TOTAL_INSTALLMENT(22, 2),
	SUMMARY_TRANSACTION_TYPE(24, 2),
	SUMMARY_BANK_PROCESSING_DATE(26, 6),
	SUMMARY_VALUE_DATE(32, 6),
	SUMMARY_GROSS_AMOUNT(44, 14),
	SUMMARY_COMMISSION_FEE(58, 14),
	SUMMARY_DECLINED_AMOUNT(72, 14),
	SUMMARY_NET_AMOUNT(86, 14),
	SUMMARY_STATUS(123, 2),
	SUMMARY_TOTAL_ACCEPTED_TRANSACTIONS(125, 6),
	SUMMARY_TOTAL_DECLINED_TRANSACTIONS(133, 6),
	SUMMARY_ACCELARATION_IDENTIFIER(139, 1),
	SUMMARY_ADJUSTMENT_TYPE(146, 2),
	SUMMARY_ANTICIPATED_FLAG(161, 1);

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

	CieloReportSummaryFields(int start, int length) {

		this.start = start;
		this.length = length;
	}

	@Override
	public String getName() {

		return this.name();
	}
}
