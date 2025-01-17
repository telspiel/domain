package com.noesis.domain.platform;

import java.util.Map;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DeliveryReceipt {
	public static final int FIELD_ERR_MAX_LEN = 5;

	private static final DateTimeFormatter dateFormatTemplate = DateTimeFormat.forPattern("yyMMddHHmm");
	private static final DateTimeFormatter dateFormatTemplateWithSeconds = DateTimeFormat.forPattern("yyMMddHHmmss");
	// an example of a 3rd format 20110303100008 (yyyyMMddHHmmss)
	private static final DateTimeFormatter dateFormatTemplateWithFullYearAndSeconds = DateTimeFormat
			.forPattern("yyyyMMddHHmmss");

	public static final String FIELD_ID = "id:";
	public static final String FIELD_SUB = "sub:";
	public static final String FIELD_DLVRD = "dlvrd:";
	public static final String FIELD_SUBMIT_DATE = "submit date:";
	public static final String FIELD_DONE_DATE = "done date:";
	public static final String FIELD_STAT = "stat:";
	public static final String FIELD_ERR = "err:";
	public static final String FIELD_TEXT = "text:";
	public static final byte STATE_FAILED = (byte) 0x09;

	public static final byte STATE_ENROUTE = (byte) 0x01;
	public static final byte STATE_DELIVERED = (byte) 0x02;
	public static final byte STATE_EXPIRED = (byte) 0x03;
	public static final byte STATE_DELETED = (byte) 0x04;
	public static final byte STATE_UNDELIVERABLE = (byte) 0x05;
	public static final byte STATE_ACCEPTED = (byte) 0x06;
	public static final byte STATE_UNKNOWN = (byte) 0x07;
	public static final byte STATE_REJECTED = (byte) 0x08;

	// field "id": id of message originally submitted
	private String messageId;
	// field "sub": number of messages originally submitted
	private int submitCount;
	// field "dlvrd": number of messages delivered
	private int deliveredCount;
	// field "submit date": date message was originally submitted at
	private DateTime submitDate;
	// field "done date": date message reached a final "done" state
	private DateTime doneDate;
	// field "stat": final state of message
	private byte state;
	// field "err": network/smsc specific error code
	private int errorCode;
	// smpp 3.4 spec states that the "err" field is a length 3 c-octet string
	// in order to allow for reverse compatibility we will store both values
	private String rawErrorCode;
	// field "text": first 20 characters of original message
	private String text;
	private String originalDoneDate;
	private String originalSubmitDate;
	private String dlrStat;
	public DeliveryReceipt() {
		setErrorCode(0);
	}

	public DeliveryReceipt(String messageId, int submitCount,
			int deliveredCount, String submitDate, String doneDate,
			byte state, int errorCode, String text, DateTimeZone zone) {
		this.messageId = messageId;
		this.submitCount = submitCount;
		this.deliveredCount = deliveredCount;
		this.submitDate = parseDateTimeHelper(submitDate, zone);
		this.doneDate = parseDateTimeHelper(doneDate, zone);
		this.originalDoneDate = doneDate;
		this.originalSubmitDate = submitDate;
		this.state = state;
		setErrorCode(errorCode);
		this.text = text;
	}
	
	public DeliveryReceipt(String messageId, int submitCount, int deliveredCount, DateTime submitDate,
			DateTime doneDate, byte state, int errorCode, String text) {
		this.messageId = messageId;
		this.submitCount = submitCount;
		this.deliveredCount = deliveredCount;
		this.submitDate = submitDate;
		this.doneDate = doneDate;
		this.state = state;
		setErrorCode(errorCode);
		this.text = text;
	}

	public DeliveryReceipt(String messageId, int submitCount, int deliveredCount, DateTime submitDate,
			DateTime doneDate, byte state, String errorCode, String text) {
		this.messageId = messageId;
		this.submitCount = submitCount;
		this.deliveredCount = deliveredCount;
		this.submitDate = submitDate;
		this.doneDate = doneDate;
		this.state = state;
		setRawErrorCode(errorCode);
		this.text = text;
	}

	public int getDeliveredCount() {
		return deliveredCount;
	}

	public void setDeliveredCount(int deliveredCount) {
		this.deliveredCount = deliveredCount;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;

		this.rawErrorCode = String.format("%03d", errorCode);
	}

	public String getRawErrorCode() {
		return rawErrorCode;
	}

	/**
	 * Smpp 3.4 spec states that the "err" field is a <= 3 c-octet string, this
	 * field takes that into account and will be chained with the
	 * {@link #setErrorCode(int)} field if the "err" field is valid
	 * 
	 * @param rawErrorCode
	 */
	public void setRawErrorCode(String rawErrorCode) {
		this.rawErrorCode = rawErrorCode;

		try {
			this.errorCode = Integer.parseInt(rawErrorCode);
		} catch (Exception e) {
		}
	}

	public DateTime getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(DateTime finalDate) {
		this.doneDate = finalDate;
	}

	public String getMessageId() {
		return messageId;
	}

	public long getMessageIdAsLong() throws NumberFormatException {
		return Long.parseLong(this.messageId);
	}

	/**
	 * Sets the "id" field to the exact String we'll use. Utility method provided
	 * for setting this value as a long.
	 * 
	 * @param messageId
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * Sets the "id" field parameter as a long value that is zero padded to 10
	 * digits.
	 * 
	 * @param messageId
	 */
	public void setMessageId(long messageId) {
		this.messageId = String.format("%010d", messageId);
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public int getSubmitCount() {
		return submitCount;
	}

	public void setSubmitCount(int submitCount) {
		this.submitCount = submitCount;
	}

	public DateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(DateTime submitDate) {
		this.submitDate = submitDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	static public DeliveryReceipt parseShortMessage(String shortMessage, DateTimeZone zone, boolean checkMissingFields)
			throws DeliveryReceiptException {
		// for case insensitivity, convert to lowercase (normalized text)
		String normalizedText = shortMessage.toLowerCase();

		// create a new DLR with fields set to "uninitialized" values
		DeliveryReceipt dlr = new DeliveryReceipt(null, -1, -1, null, null, (byte) -1, -1, null);
		TreeMap<Integer, String> fieldsByStartPos = new TreeMap<Integer, String>();

		// find location of all possible fields in text of message and add to
		// treemap by their startPos so that we'll end up with an ordered list
		// of their occurrence
		// a field "value" only technically ends wit the start of the next field
		// "label"
		// since a field value could technically contain ":" or spaces
		// SMPP really has HORRIBLE specs for delivery receipts...
		findFieldAndAddToTreeMap(normalizedText, FIELD_ID, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_SUB, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_DLVRD, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_SUBMIT_DATE, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_DONE_DATE, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_STAT, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_ERR, fieldsByStartPos);
		findFieldAndAddToTreeMap(normalizedText, FIELD_TEXT, fieldsByStartPos);

		// process all fields in the order they appear
		Map.Entry<Integer, String> curFieldEntry = fieldsByStartPos.firstEntry();
		while (curFieldEntry != null) {
			Map.Entry<Integer, String> nextFieldEntry = fieldsByStartPos.higherEntry(curFieldEntry.getKey());

			// calculate the positions for the substring to extract the field
			// value
			int fieldLabelStartPos = curFieldEntry.getKey().intValue();
			int startPos = fieldLabelStartPos + curFieldEntry.getValue().length();
			int endPos = (nextFieldEntry != null ? nextFieldEntry.getKey().intValue() : normalizedText.length());

			String fieldLabel = curFieldEntry.getValue();
			String fieldValue = shortMessage.substring(startPos, endPos).trim();

			// logger.debug("startPos [" + curFieldEntry.getKey() + "] label ["
			// + curFieldEntry.getValue() + "] value [" + fieldValue + "]");

			if (!StringUtil.isEmpty(fieldValue)) {
				if (fieldLabel.equalsIgnoreCase(FIELD_ID)) {
					dlr.messageId = fieldValue;
				} else if (fieldLabel.equalsIgnoreCase(FIELD_SUB)) {
					try {
						dlr.submitCount = Integer.parseInt(fieldValue);
					} catch (NumberFormatException e) {
						throw new DeliveryReceiptException(
								"Unable to convert [sub] field with value [" + fieldValue + "] into an integer");
					}
				} else if (fieldLabel.equalsIgnoreCase(FIELD_DLVRD)) {
					try {
						dlr.deliveredCount = Integer.parseInt(fieldValue);
					} catch (NumberFormatException e) {
						throw new DeliveryReceiptException(
								"Unable to convert [dlvrd] field with value [" + fieldValue + "] into an integer");
					}
				} else if (fieldLabel.equalsIgnoreCase(FIELD_SUBMIT_DATE)) {
					try {
						dlr.originalSubmitDate = fieldValue;
						dlr.submitDate = parseDateTimeHelper(fieldValue, zone);
					} catch (IllegalArgumentException e) {
						throw new DeliveryReceiptException("Unable to convert [submit date] field with value ["
								+ fieldValue + "] into a datetime object");
					}
				} else if (fieldLabel.equalsIgnoreCase(FIELD_DONE_DATE)) {
					try {
						dlr.originalDoneDate = fieldValue;
						dlr.doneDate = parseDateTimeHelper(fieldValue, zone);
					} catch (IllegalArgumentException e) {
						//throw new DeliveryReceiptException("Unable to convert [done date] field with value ["
							//	+ fieldValue + "] into a datetime object");
						dlr.doneDate = dlr.submitDate;
					}
				}else if (fieldLabel.equalsIgnoreCase(FIELD_STAT)) {
					dlr.dlrStat = fieldValue;
					dlr.state = DeliveryReceipt.toState(fieldValue);
					if (dlr.state < 0) {
						throw new DeliveryReceiptException(
								"Unable to convert [stat] field with value [" + fieldValue + "] into a valid state");
					}
				} else if (fieldLabel.equalsIgnoreCase(FIELD_ERR)) {
					if (isValidErrorCode(fieldValue))
						dlr.setRawErrorCode(fieldValue);
					else
						throw new DeliveryReceiptException(
								"The [err] field was not of a valid lengh of <= " + FIELD_ERR_MAX_LEN);
				} else if (fieldLabel.equalsIgnoreCase(FIELD_TEXT)) {
					dlr.text = fieldValue;
					dlr.text = "xx";
				} else {
					throw new DeliveryReceiptException("Unsupported field [" + fieldValue + "] found");
				}
			}

			curFieldEntry = nextFieldEntry;
		}

		if (checkMissingFields) {
			if (StringUtil.isEmpty(dlr.messageId)) {
				throw new DeliveryReceiptException(
						"Unable to find [id] field or empty value in delivery receipt message");
			}

			if (dlr.submitCount < 0) {
				throw new DeliveryReceiptException(
						"Unable to find [sub] field or empty value in delivery receipt message");
			}

			if (dlr.deliveredCount < 0) {
				throw new DeliveryReceiptException(
						"Unable to find [dlvrd] field or empty value in delivery receipt message");
			}

			if (dlr.submitDate == null) {
				throw new DeliveryReceiptException(
						"Unable to find [submit date] field or empty value in delivery receipt message");
			}

			if (dlr.doneDate == null) {
				throw new DeliveryReceiptException(
						"Unable to find [done date] field or empty value in delivery receipt message");
			}

			if (dlr.state < 0) {
				throw new DeliveryReceiptException(
						"Unable to find [stat] field or empty value in delivery receipt message");
			}

			if (StringUtil.isEmpty(dlr.rawErrorCode) && dlr.errorCode < 0) {
				throw new DeliveryReceiptException(
						"Unable to find [err] field or empty value in delivery receipt message");
			}
		}

		return dlr;
	}

	private static boolean isValidErrorCode(String errorCode) {
		if (StringUtil.isEmpty(errorCode)
				|| (!StringUtil.isEmpty(errorCode) && errorCode.length() <= FIELD_ERR_MAX_LEN))
			return true;
		else
			return false;
	}

	static private DateTime parseDateTimeHelper(String value, DateTimeZone zone) {
		if (value == null) {
			return null;
		}
		// pick the correct template based on length
		if (value.length() == 14) {
			return dateFormatTemplateWithFullYearAndSeconds.withZone(zone).parseDateTime(value);
		} else if (value.length() == 12) {
			return dateFormatTemplateWithSeconds.withZone(zone).parseDateTime(value);
		} else {
			return dateFormatTemplate.withZone(zone).parseDateTime(value);
		}
	}

	static public void findFieldAndAddToTreeMap(String normalizedText, String field,
			TreeMap<Integer, String> fieldsByStartPos) {
		int startPos = normalizedText.indexOf(field);
		// logger.debug("Found field " + field + " at startPos " + startPos);
		if (startPos >= 0) {
			fieldsByStartPos.put(startPos, field);
		}
	}

	public String toShortMessage() {
		StringBuilder buf = new StringBuilder(200);
		buf.append(FIELD_ID);
		buf.append(this.messageId);
		buf.append(" ");
		buf.append(FIELD_SUB);
		buf.append(String.format("%03d", this.submitCount));
		buf.append(" ");
		buf.append(FIELD_DLVRD);
		buf.append(String.format("%03d", this.deliveredCount));
		buf.append(" ");
		buf.append(FIELD_SUBMIT_DATE);
		if (this.submitDate == null) {
			buf.append("0000000000");
		} else {
			buf.append(originalSubmitDate);
		}
		buf.append(" ");
		buf.append(FIELD_DONE_DATE);
		if (this.doneDate == null) {
			buf.append("0000000000");
		} else {
			buf.append(originalDoneDate);
		}
		buf.append(" ");
		buf.append(FIELD_STAT);
		buf.append(toStateText(this.state));
		buf.append(" ");
		buf.append(FIELD_ERR);
		buf.append(this.rawErrorCode);
		buf.append(" ");
		buf.append(FIELD_TEXT);
		if (this.text != null) {
			if (this.text.length() > 20) {
				buf.append(this.text.substring(0, 20));
			} else {
				buf.append(this.text);
			}
		}
		return buf.toString();
	}
	
	static public String toStateText(byte state) {
		switch (state) {
		case STATE_DELIVERED:
			return "DELIVRD";
		case STATE_EXPIRED:
			return "EXPIRED";
		case STATE_DELETED:
			return "DELETED";
		case STATE_UNDELIVERABLE:
			return "UNDELIV";
		case STATE_ACCEPTED:
			return "ACCEPTD";
		case STATE_UNKNOWN:
			return "UNKNOWN";
		case STATE_REJECTED:
			return "REJECTD";
		case STATE_ENROUTE:
			return "ENROUTE";
		case STATE_FAILED:
			return "FAILED";	
		
		default:
			return "BADSTAT";
		}
	}
	
	public String customToShortMessage() {
		StringBuilder buf = new StringBuilder(200);
		buf.append(FIELD_ID);
		buf.append(this.messageId);
		buf.append(" ");
		buf.append(FIELD_SUB);
		buf.append(String.format("%03d", this.submitCount));
		buf.append(" ");
		buf.append(FIELD_DLVRD);
		buf.append(String.format("%03d", this.deliveredCount));
		buf.append(" ");
		buf.append(FIELD_SUBMIT_DATE);
		if (this.submitDate == null) {
			buf.append("0000000000");
		} else {
			buf.append(originalSubmitDate);
		}
		buf.append(" ");
		buf.append(FIELD_DONE_DATE);
		if (this.doneDate == null) {
			buf.append("0000000000");
		} else {
			buf.append(originalDoneDate);
		}
		buf.append(" ");
		buf.append(FIELD_STAT);
		buf.append(this.dlrStat);
		buf.append(" ");
		buf.append(FIELD_ERR);
		buf.append(this.rawErrorCode);
		buf.append(" ");
		buf.append(FIELD_TEXT);
		if (this.text != null) {
			if (this.text.length() > 20) {
				buf.append(this.text.substring(0, 20));
			} else {
				buf.append(this.text);
			}
		}
		return buf.toString();
	}

	static public byte toState(String stateText) {

		if (stateText == null) {
			return -1;
		}

		if (stateText.equalsIgnoreCase("DELIVRD")) {
			return STATE_DELIVERED;
		} else if (stateText.equalsIgnoreCase("EXPIRED")) {
			return STATE_EXPIRED;
		} else if (stateText.equalsIgnoreCase("DELETED")) {
			return STATE_DELETED;
		} else if (stateText.equalsIgnoreCase("UNDELIV")) {
			return STATE_UNDELIVERABLE;
		} else if (stateText.equalsIgnoreCase("ACCEPTD")) {
			return STATE_ACCEPTED;
		} else if (stateText.equalsIgnoreCase("UNKNOWN")) {
			return STATE_UNKNOWN;
		} else if (stateText.equalsIgnoreCase("REJECTD")) {
			return STATE_REJECTED;
		} else if (stateText.equalsIgnoreCase("ENROUTE")) {
			return STATE_ENROUTE;
		} else if (stateText.equalsIgnoreCase("FAILED")) {
			return STATE_FAILED;
		} else {
			return STATE_FAILED;
		}
	}
	
	public static String getStateTextFromByte(byte state) {

		if (state == STATE_DELIVERED) {
			return "DELIVRD";
		} else if (state == STATE_EXPIRED) {
			return "EXPIRED";
		} else if (state == STATE_DELETED ) {
			return "DELETED";
		} else if (state == STATE_UNDELIVERABLE) {
			return "UNDELIV";
		} else if (state == STATE_ACCEPTED) {
			return "ACCEPTD";
		} else if (state == STATE_UNKNOWN) {
			return "UNKNOWN";
		} else if (state == STATE_REJECTED) {
			return "REJECTD";
		} else if (state == STATE_ENROUTE) {
			return "ENROUTE";
		} else if (state == STATE_FAILED) {
			return "FAILED";
		} else {
			return "FAILED";
		}
	}

	static public DeliveryReceipt parseShortMessage(String shortMessage,
			DateTimeZone zone) throws DeliveryReceiptException {
		return parseShortMessage(shortMessage, zone, true);
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder(160);
		buf.append("(id=");
		buf.append(this.messageId);
		buf.append(" sub=");
		buf.append(this.submitCount);
		buf.append(" dlvrd=");
		buf.append(this.deliveredCount);
		buf.append(" submitDate=");
		buf.append(this.submitDate);
		buf.append(" doneDate=");
		buf.append(this.doneDate);
		buf.append(" state=");
		buf.append(this.state);
		buf.append("[");
		buf.append(this.state);
		buf.append("] err=");
		buf.append(this.rawErrorCode);
		buf.append(" text=[");
		buf.append(this.text);
		buf.append("])");
		return buf.toString();
	}

	public String getOriginalDoneDate() {
		return originalDoneDate;
	}

	public void setOriginalDoneDate(String originalDoneDate) {
		this.originalDoneDate = originalDoneDate;
	}

	public String getOriginalSubmitDate() {
		return originalSubmitDate;
	}

	public void setOriginalSubmitDate(String originalSubmitDate) {
		this.originalSubmitDate = originalSubmitDate;
	}

	public String getDlrStat() {
		return dlrStat;
	}

	public void setDlrStat(String dlrStat) {
		this.dlrStat = dlrStat;
	}
	
}