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

import com.noesis.domain.persistence.NgMisLogWebtool;
import com.noesis.domain.repository.NgMisLogWebtoolRepository;

@Service
public class NgMisLogWebtoolService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NgMisLogWebtoolRepository ngMisLogWebtoolRepository;
	
	public List<NgMisLogWebtool> getAllNgMisWebtoolData(String userName) {
		List<NgMisLogWebtool> ngMisLogWebtoolList =  ngMisLogWebtoolRepository.findByUserName(userName);
		logger.info("Total records found in view: "+ngMisLogWebtoolList);
		return ngMisLogWebtoolList;
	}
	
	public List<NgMisLogWebtool> getAllNgMisWebtoolData(String userName, String fromDate, String toDate, String mobileNumber, String senderId) throws ParseException {
		List<NgMisLogWebtool> ngMisLogWebtoolList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(fromDate==null || fromDate.length()==0) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
				LocalDateTime currDateTime = LocalDateTime.now();
				fromDate = dtf.format(currDateTime);
			}else {
				fromDate = fromDate+":00";
			}
			Date finalFromDate =	sdf.parse(fromDate);
			
			if(toDate == null || toDate.length()==0) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime currDateTime = LocalDateTime.now();
				toDate = dtf.format(currDateTime);
			}else {
				toDate = toDate+":00";
			}
			Date finalToDate = sdf.parse(toDate);
		
		if((mobileNumber == null || mobileNumber.length()==0) && (senderId == null || senderId.length()==0)) {
			logger.info("Going to hit query without mobile number");
			ngMisLogWebtoolList =  ngMisLogWebtoolRepository.findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(userName, finalFromDate, finalToDate);
		}else if(senderId == null || senderId.length()==0){
			logger.info("Going to hit query with mobile number : {}",mobileNumber);
			ngMisLogWebtoolList =  ngMisLogWebtoolRepository.findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqualAndMobileNumber(userName, finalFromDate, finalToDate, mobileNumber);
		}else if(mobileNumber == null || mobileNumber.length()==0){
			logger.info("Going to hit query with mobile number : {}",mobileNumber);
			ngMisLogWebtoolList =  ngMisLogWebtoolRepository.findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqualAndSenderId(userName, finalFromDate, finalToDate, senderId);
		}else {
			logger.info("Going to hit query with mobile number : {}",mobileNumber);
			ngMisLogWebtoolList =  ngMisLogWebtoolRepository.findByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqualAndSenderIdAndMobileNumber(userName, finalFromDate, finalToDate, senderId, mobileNumber);
		}
		
		logger.info("Total records found in view: "+ngMisLogWebtoolList);
		
		return ngMisLogWebtoolList;
	} 
	

	public Long getAllNgMisWebtoolDataForMonth(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-30);
			Date fromDate = cal.getTime();
			String fromDateAsString = sdf.format(fromDate);
			Date finalFromDate = sdf.parse(fromDateAsString);
			
			cal = Calendar.getInstance();
			cal.setTime(new Date());
			Date toDate = cal.getTime();
			String toDateAsString = sdf.format(toDate);
			Date finalToDate = sdf.parse(toDateAsString);
		
			Long monthDataCount =  ngMisLogWebtoolRepository.countByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(userName, finalFromDate, finalToDate);
		return monthDataCount;
	} 
	

	public Long getAllNgMisWebtoolDataForWeek(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-7);
			Date fromDate = cal.getTime();
			String fromDateAsString = sdf.format(fromDate);
			Date finalFromDate = sdf.parse(fromDateAsString);
			
			cal = Calendar.getInstance();
			cal.setTime(new Date());
			Date toDate = cal.getTime();
			String toDateAsString = sdf.format(toDate);
			Date finalToDate = sdf.parse(toDateAsString);
		
			Long weekDataCount =  ngMisLogWebtoolRepository.countByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(userName, finalFromDate, finalToDate);
			return weekDataCount;
	}
	
	public Long getAllNgMisDataWebtoolForTwoMonths(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-60);
			Date fromDate = cal.getTime();
			String fromDateAsString = sdf.format(fromDate);
			Date finalFromDate = sdf.parse(fromDateAsString);
			
			cal = Calendar.getInstance();
			cal.setTime(new Date());
			Date toDate = cal.getTime();
			String toDateAsString = sdf.format(toDate);
			Date finalToDate = sdf.parse(toDateAsString);
		
			Long twoMonthsDataCount =  ngMisLogWebtoolRepository.countByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(userName, finalFromDate, finalToDate);
			return twoMonthsDataCount;
	}
	
	public Long getAllNgMisDataWebtoolForToday(String userName) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			//cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-60);
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
		
			Long todayDataCount =  ngMisLogWebtoolRepository.countByUserNameAndReceivedTsGreaterThanEqualAndReceivedTsLessThanEqual(userName, finalFromDate, finalToDate);
			return todayDataCount;
	}
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
		LocalDateTime currDateTime = LocalDateTime.now();
		String currDate = dtf.format(currDateTime);
		System.out.print("currDate: "+currDate);
	}

}
