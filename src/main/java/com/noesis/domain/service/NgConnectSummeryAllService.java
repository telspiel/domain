package com.noesis.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.dto.ConnectSenderIdSummaryQueryDto;
import com.noesis.domain.dto.ConnectSummaryQueryDto;
import com.noesis.domain.repository.NgConnectSummeryAllRepository;

@Service
public class NgConnectSummeryAllService {
	
	@Autowired
	private NgConnectSummeryAllRepository ngConnectSummeryAllRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<ConnectSummaryQueryDto> getNgConnectSummaryDataForToday(int id, String receiveDate, String custType) throws ParseException {
		List<ConnectSummaryQueryDto> connectSummaryList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		Date receivedDate = cal.getTime();
		String receiveDateAsString = sdf.format(receivedDate);
		Date finalReceiveDate= sdf.parse(receiveDateAsString);
		
		logger.info("Going to hit query with selecting date : {} user Id : {}",finalReceiveDate, id);
		
		if(custType.equalsIgnoreCase("superadmin")){
			return ngConnectSummeryAllRepository.getDayConnectSummaryDataForSuperAdminUser(id, finalReceiveDate);
		}else if(custType.equalsIgnoreCase("admin")) {
			return ngConnectSummeryAllRepository.getDayConnectSummaryDataForAdminUser(id, finalReceiveDate);
		}
		return connectSummaryList;
	}
	
	public List<ConnectSummaryQueryDto> getNgConnectSummaryDataForPreviousDay(int id, String receiveDate, String custType) throws ParseException {
		List<ConnectSummaryQueryDto> connectSummaryList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) -1);
		
		Date receivedDate = cal.getTime();
		String receiveDateAsString = sdf.format(receivedDate);
		Date finalReceiveDate= sdf.parse(receiveDateAsString);
		
		logger.info("Going to hit query with selecting date : {} user Id : {}",finalReceiveDate, id);
		
		if(custType.equalsIgnoreCase("superadmin")){
			return ngConnectSummeryAllRepository.getDayConnectSummaryDataForSuperAdminUser(id, finalReceiveDate);
		}else if(custType.equalsIgnoreCase("admin")) {
			return ngConnectSummeryAllRepository.getDayConnectSummaryDataForAdminUser(id, finalReceiveDate);
		}
		return connectSummaryList;
	}
	
	public List<ConnectSummaryQueryDto> getNgConnectSummaryDataForCurrentMonth(int id, String receiveDate, String custType) throws ParseException {
		List<ConnectSummaryQueryDto> connectSummaryList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		cal.set((Calendar.DAY_OF_MONTH),1);
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);
		
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);
		
		logger.info("Going to hit query with selecting date : {} user Id : {}",finalFromDate, id);
		
		if(custType.equalsIgnoreCase("superadmin")){
			return ngConnectSummeryAllRepository.getMonthConnectSummaryDataForSuperAdminUser(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("admin")) {
			return ngConnectSummeryAllRepository.getMonthConnectSummaryDataForAdminUser(id, finalFromDate, finalToDate);
		}
		return connectSummaryList;
	}
	
	public List<ConnectSummaryQueryDto> getNgConnectSummaryDataForPreviousMonth(int id, String receiveDate, String custType) throws ParseException {
		List<ConnectSummaryQueryDto> connectSummaryList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
		cal.set((Calendar.DAY_OF_MONTH),1);
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);
		
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);
		
		logger.info("Going to hit query with selecting date : {} user Id : {}",finalFromDate, id);
		
		if(custType.equalsIgnoreCase("superadmin")){
			return ngConnectSummeryAllRepository.getMonthConnectSummaryDataForSuperAdminUser(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("admin")) {
			return ngConnectSummeryAllRepository.getMonthConnectSummaryDataForAdminUser(id, finalFromDate, finalToDate);
		}
		return connectSummaryList;
	}	
	
	public List<ConnectSenderIdSummaryQueryDto> getNgConnectSenderIdSummaryDataForToday(int id, String fromDate, String toDate, String custType) throws ParseException {
		List<ConnectSenderIdSummaryQueryDto> connectSenderIdSummaryList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date finalFromDate = sdf.parse(fromDate);
		Date finalToDate = sdf.parse(toDate);
		
		logger.info("Going to hit query with selecting date : {} user Id : {}",finalFromDate, id);
		
		if(custType.equalsIgnoreCase("superadmin")){
			return ngConnectSummeryAllRepository.getDayConnectSenderIdSummaryDataForSuperAdminUser(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("admin")) {
			return ngConnectSummeryAllRepository.getDayConnectSenderIdSummaryDataForAdminUser(id, finalFromDate, finalToDate);
		}
		return connectSenderIdSummaryList;
	}
}
