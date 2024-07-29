package com.noesis.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.persistence.NgMisLog;
import com.noesis.domain.repository.NgMisLogRepository;

@Service
public class NgMisLogService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private NgMisLogRepository ngMisLogRepository;

	public List<NgMisLog> getAllNgMisData(String userName) {
		List<NgMisLog> ngMisLogList = ngMisLogRepository.findByUserName(userName);
		logger.info("Total records found in view: " + ngMisLogList);
		/*
		 * for (NgMisLog ngMisLog : ngMisLogList) {
		 * logger.info("Total Submit Count is: "+ngMisLog.getMessageId()); }
		 */
		return ngMisLogList;
	}

	public List<NgMisLog> getAllNgMisData(String userName, String fromDate, String toDate, String mobileNumber)
			throws ParseException {
		List<NgMisLog> ngMisLogList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (fromDate == null || fromDate.length() == 0) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
			LocalDateTime currDateTime = LocalDateTime.now();
			fromDate = dtf.format(currDateTime);
		} else {
			fromDate = fromDate + ":00";
		}
		Date finalFromDate = sdf.parse(fromDate);

		if (toDate == null || toDate.length() == 0) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime currDateTime = LocalDateTime.now();
			toDate = dtf.format(currDateTime);
		} else {
			toDate = toDate + ":00";
		}
		Date finalToDate = sdf.parse(toDate);

		if (mobileNumber == null || mobileNumber.length() == 0) {
			logger.info("Going to hit query without mobile number");
			ngMisLogList = ngMisLogRepository.findByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(userName,
					finalFromDate, finalToDate);
		} else {
			logger.info("Going to hit query with mobile number : {}", mobileNumber);
			ngMisLogList = ngMisLogRepository
					.findByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThanAndMobileNumber(userName, finalFromDate,
							finalToDate, mobileNumber);
		}

		logger.info("Total records found in view: " + ngMisLogList);

		return ngMisLogList;
	}

	public Long getAllNgMisDataForMonth(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);
		
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);

		Long monthDataCount = ngMisLogRepository.countByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(userName,
				finalFromDate, finalToDate);
		return monthDataCount;
	}

	public Long getAllNgMisDataForWeek(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_WEEK, 1);
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);

		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);

		Long weekDataCount = ngMisLogRepository.countByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(userName,
				finalFromDate, finalToDate);
		return weekDataCount;
	}

	public Long getAllNgMisDataForTwoMonths(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) -1);
		cal.set((Calendar.DAY_OF_MONTH),1);
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);
		
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);

		Long weekDataCount = ngMisLogRepository.countByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(userName,
				finalFromDate, finalToDate);
		return weekDataCount;
	}

	public Long getAllNgMisDataForToday(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-60);
		Date fromDate = cal.getTime();
		sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);

		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);

		Long weekDataCount = ngMisLogRepository.countByUserNameAndReceivedTsGreaterThanAndReceivedTsLessThan(userName,
				finalFromDate, finalToDate);
		return weekDataCount;
	}

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
		LocalDateTime currDateTime = LocalDateTime.now();
		String currDate = dtf.format(currDateTime);
		System.out.print("currDate: " + currDate);
	}

	public List<NgMisLog> getAllNgMisDataForUserMessageIdsSenderId(String userName, List<String> messageIds,
			String senderId) throws ParseException {
		List<NgMisLog> ngMisLogList = null;
		ngMisLogList = ngMisLogRepository.findByUserNameAndSenderIdAndMessageIdIn(userName, senderId, messageIds);
		logger.info("Total records found in view: " + ngMisLogList);
		return ngMisLogList;
	}
}
