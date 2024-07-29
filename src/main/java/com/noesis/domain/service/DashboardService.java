package com.noesis.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noesis.domain.repository.DashboardRepository;

@Service
public class DashboardService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DashboardRepository dashboardRepository;
	
	public Long getAllNgSummaryDataForToday(int id, String custType) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);
		
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);
		
		logger.info("Going to get summary count for today for user id : {} and fromDate {} and toDate {}",id, fromDate, toDate);
		
		if(custType.equalsIgnoreCase("reseller")){
			return dashboardRepository.getSummaryForDateRangeForReseller(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("seller")) {
			return dashboardRepository.getSummaryForDateRangeForSeller(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("admin"))) {
			return dashboardRepository.getSummaryForDateRangeForAdmin(id, finalFromDate, finalToDate);
		}else if ((custType.equalsIgnoreCase("superadmin"))) {
			return dashboardRepository.getSummaryForDateRangeForSuperAdmin(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("client"))) {
			return dashboardRepository.getSummaryForDateRangeForClient(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("accountmanager"))) {
			return dashboardRepository.getSummaryForDateRangeForAccountManager(id, finalFromDate, finalToDate);
		}		
		return 0L;
	}
	
	public Long getAllNgSummaryDataForWeek(int id, String custType) throws ParseException {
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
		
		if(custType.equalsIgnoreCase("reseller")){
			return dashboardRepository.getSummaryForDateRangeForReseller(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("seller")) {
			return dashboardRepository.getSummaryForDateRangeForSeller(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("admin"))) {
			return dashboardRepository.getSummaryForDateRangeForAdmin(id, finalFromDate, finalToDate);
		}else if ((custType.equalsIgnoreCase("superadmin"))) {
			return dashboardRepository.getSummaryForDateRangeForSuperAdmin(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("client"))) {
			return dashboardRepository.getSummaryForDateRangeForClient(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("accountmanager"))) {
			return dashboardRepository.getSummaryForDateRangeForAccountManager(id, finalFromDate, finalToDate);
		}
		return 0L;
	}
	
	public Long getAllNgSummaryDataForMonth(int id, String custType) throws ParseException {
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
	
		if(custType.equalsIgnoreCase("reseller")){
			return dashboardRepository.getSummaryForDateRangeForReseller(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("seller")) {
			return dashboardRepository.getSummaryForDateRangeForSeller(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("admin"))) {
			return dashboardRepository.getSummaryForDateRangeForAdmin(id, finalFromDate, finalToDate);
		}else if ((custType.equalsIgnoreCase("superadmin"))) {
			return dashboardRepository.getSummaryForDateRangeForSuperAdmin(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("client"))) {
			return dashboardRepository.getSummaryForDateRangeForClient(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("accountmanager"))) {
			return dashboardRepository.getSummaryForDateRangeForAccountManager(id, finalFromDate, finalToDate);
		}
		return 0L;
	}
	
	public Long getAllNgSummaryDataForTwoMonth(int id, String custType) throws ParseException {
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
	
		if(custType.equalsIgnoreCase("reseller")){
			return dashboardRepository.getSummaryForDateRangeForReseller(id, finalFromDate, finalToDate);
		}else if(custType.equalsIgnoreCase("seller")) {
			return dashboardRepository.getSummaryForDateRangeForSeller(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("admin"))) {
			return dashboardRepository.getSummaryForDateRangeForAdmin(id, finalFromDate, finalToDate);
		}else if ((custType.equalsIgnoreCase("superadmin"))) {
			return dashboardRepository.getSummaryForDateRangeForSuperAdmin(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("client"))) {
			return dashboardRepository.getSummaryForDateRangeForClient(id, finalFromDate, finalToDate);
		}else if((custType.equalsIgnoreCase("accountmanager"))) {
			return dashboardRepository.getSummaryForDateRangeForAccountManager(id, finalFromDate, finalToDate);
		}
		return 0L;
	}
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) -1);
		cal.set((Calendar.DAY_OF_MONTH),1);
		Date fromDate = cal.getTime();
		String fromDateAsString = sdf.format(fromDate);
		Date finalFromDate = sdf.parse(fromDateAsString);
		System.out.println(finalFromDate);
		
		cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date toDate = cal.getTime();
		String toDateAsString = sdf.format(toDate);
		Date finalToDate = sdf.parse(toDateAsString);
		System.out.println(finalToDate);
	}
}
