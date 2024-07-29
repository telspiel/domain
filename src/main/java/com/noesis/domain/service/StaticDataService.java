//package com.noesis.domain.service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import com.noesis.domain.constants.Constants;
//import com.noesis.domain.dto.UserRoutingData;
//import com.noesis.domain.dto.UserRoutingDataForAllUser;
//import com.noesis.domain.persistence.NgCarrierMaster;
//import com.noesis.domain.persistence.NgCircleMaster;
//import com.noesis.domain.persistence.NgContentTemplate;
//import com.noesis.domain.persistence.NgKannelGroupMapping;
//import com.noesis.domain.persistence.NgNumberCarrierCircleMapping;
//import com.noesis.domain.persistence.NgRoutingGroupMaster;
//import com.noesis.domain.persistence.NgRoutingInfoPromo;
//import com.noesis.domain.persistence.NgRoutingInfoTrans;
//import com.noesis.domain.persistence.NgRoutingInfoTransPromoDnd;
//import com.noesis.domain.persistence.NgRoutingInfoTransPromoNonDnd;
//import com.noesis.domain.persistence.NgRoutingTypeMaster;
//import com.noesis.domain.persistence.NgUserSenderIdMap;
//import com.noesis.domain.repository.NgCarrierRepository;
//import com.noesis.domain.repository.NgCircleRepository;
//import com.noesis.domain.repository.NgContentTemplateRepository;
//import com.noesis.domain.repository.NgKannelGroupMappingRepository;
//import com.noesis.domain.repository.NgNumberSeriesRepository;
//import com.noesis.domain.repository.NgRoutingGroupRepository;
//import com.noesis.domain.repository.NgRoutingInfoPromoRepository;
//import com.noesis.domain.repository.NgRoutingInfoTransPromoDndRepository;
//import com.noesis.domain.repository.NgRoutingInfoTransPromoNonDndRepository;
//import com.noesis.domain.repository.NgRoutingInfoTransRepository;
//import com.noesis.domain.repository.NgRoutingTypeRepository;
//import com.noesis.domain.repository.UserSenderIdMapRepository;
//
//@Service
//public class StaticDataService {
//
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//	
//	private static final String carrierDataMapKey = "CARRIER_DATA_MAP";
//	private static final String circleDataMapKey = "CIRCLE_DATA_MAP";
//	private static final String numberSeriesMapKey = "NUM_SERIES_DATA_MAP";
//	private static final String routingTypeMapKey = "ROUTING_TYPE_MAP";
//	private static final String routingInfoTransMapKey = "ROUTING_INFO_TRANS_MAP";
//	private static final String routingInfoPromoMapKey = "ROUTING_INFO_PROMO_MAP";
//	private static final String routingInfoTransPromoDndMapKey = "ROUTING_INFO_TRANS_PROMO_DND_MAP";
//	private static final String routingInfoTransPromoNonDndMapKey = "ROUTING_INFO_TRANS_PROMO_NON_DND_MAP";
//	private static final String routingGroupMapKey = "ROUTING_GROUP_MAP";
//	private static final String kannelGroupMapKey = "KANNEL_GROUP_MAP";
//	private static final String kannelGroupTpsMapKey = "KANNEL_GROUP_TPS_MAP";
//	private static final String routingSubmitterQueueMapKey = "ROUTING_SUBMITTER_QUEUE_MAP";
//	private static final String senderIdMapKey = "SENDER_ID_MAP";
//	private static final String entityIdMapKey = "ENTITY_ID_MAP";
//	private static final String shortCodeMapKey = "SHORT_CODE_MAP";
//	private static final String senderIdAndEntityIdMapKey = "SENDER_ID_AND_ENTITY_ID_MAP";
//	private static final String userSenderIdTemplateMapKey = "USER_SENDER_ID_TEMPLATE_MAP_KEY";
//
//	@Autowired
//	StringRedisTemplate stringTemplate; 
//
//	@Autowired 
//	private RedisTemplate<String, Set<String>> redisTemplateForContentTemplateList;
//	
//	@Autowired
//	UserSenderIdMapRepository userSenderIdMapRepository;
//	
//	@Autowired
//	NgCarrierRepository ngCarrierRepository;
//	
//	@Autowired
//	NgCircleRepository ngCircleRepository;
//	
//	@Autowired
//	NgRoutingGroupRepository ngRoutingGroupRepository;
//	
//	@Autowired
//	NgRoutingInfoTransRepository ngRoutingInfoTransRepository;
//	
//	@Autowired
//	NgRoutingInfoTransPromoDndRepository ngRoutingInfoTransPromoDndRepository;
//
//	@Autowired
//	NgRoutingInfoTransPromoNonDndRepository ngRoutingInfoTransPromoNonDndRepository;
//
//	@Autowired
//	NgRoutingInfoPromoRepository ngRoutingInfoPromoRepository;
//	
//	@Autowired
//	NgRoutingTypeRepository ngRoutingTypeRepository;
//	
//	@Autowired
//	NgKannelGroupMappingRepository ngKannelGroupMappingRepository;
//	
//	@Autowired
//	NgNumberSeriesRepository ngNumberSeriesRepository;
//	
//	@Autowired
//	UserSenderIdMapRepository senderIdMapRepository;
//
//	@Autowired
//	NgContentTemplateRepository ngContentTemplateRepository;
//	
//	public boolean loadCarrierData() {
//		stringTemplate.opsForHash().getOperations().delete(carrierDataMapKey);
//		Iterable<NgCarrierMaster> ngCarrierList = ngCarrierRepository.findAll();
//		for (NgCarrierMaster ngCarrierMaster : ngCarrierList) {
//			stringTemplate.opsForHash().put(carrierDataMapKey, Integer.toString(ngCarrierMaster.getId()), ngCarrierMaster.getCarrierName());
//		}
//		return true;
//	}
//
//	public boolean loadCircleData() {
//		stringTemplate.opsForHash().getOperations().delete(circleDataMapKey);
//		Iterable<NgCircleMaster> ngCircleList = ngCircleRepository.findAll();
//		for (NgCircleMaster ngCircleMaster : ngCircleList) {
//			stringTemplate.opsForHash().put(circleDataMapKey, Integer.toString(ngCircleMaster.getId()), ngCircleMaster.getCircleName());
//		}
//		
//		return true;
//	}
//
//	public boolean loadNumberSeriesData() {
//		stringTemplate.opsForHash().getOperations().delete(numberSeriesMapKey);
//		Iterable<NgNumberCarrierCircleMapping> ngNumSeriesMappingList = ngNumberSeriesRepository.findAll();
//		for (NgNumberCarrierCircleMapping ngNumberCarrierCircleMapping : ngNumSeriesMappingList) {
//			String numSeriesKey = ngNumberCarrierCircleMapping.getNumSeries();
//			String numSeriesValue = ngNumberCarrierCircleMapping.getCarrierId()+"#"+ngNumberCarrierCircleMapping.getCircleId();
//			stringTemplate.opsForHash().put(numberSeriesMapKey, numSeriesKey,numSeriesValue);
//		}
//		return true;
//	}
//
//	public boolean loadRoutingTypes() {
//		stringTemplate.opsForHash().getOperations().delete(routingTypeMapKey);
//		Iterable<NgRoutingTypeMaster> ngRoutingTypeList = ngRoutingTypeRepository.findAll();
//		for (NgRoutingTypeMaster ngRoutingTypeMaster : ngRoutingTypeList) {
//			//String routingTypeKey = Integer.toString(ngRoutingTypeMaster.getId());
//			String routingTypeKey = ngRoutingTypeMaster.getRoutingType()+"#"+ngRoutingTypeMaster.getPriority();
//			String routingTypeValue = ngRoutingTypeMaster.getRoutingType()+"#"+ngRoutingTypeMaster.getPriority();
//			stringTemplate.opsForHash().put(routingTypeMapKey, routingTypeKey, routingTypeValue);
//		}
//		
//		return true;
//	}
//
//	public boolean loadRoutingGroups() {
//		stringTemplate.opsForHash().getOperations().delete(routingGroupMapKey);
//		stringTemplate.opsForHash().getOperations().delete(routingSubmitterQueueMapKey);
//		Iterable<NgRoutingGroupMaster> ngRoutingGroupList = ngRoutingGroupRepository.findAll();
//		for (NgRoutingGroupMaster ngRoutingGroupMaster : ngRoutingGroupList) {
//			String routingGroupKey = Integer.toString(ngRoutingGroupMaster.getId());
//			String routingGroupValue = ngRoutingGroupMaster.getGroupName();
//			stringTemplate.opsForHash().put(routingGroupMapKey, routingGroupKey, routingGroupValue);
//			
//			routingGroupValue = ngRoutingGroupMaster.getSubmitterQueueName();
//			stringTemplate.opsForHash().put(routingSubmitterQueueMapKey, routingGroupKey, routingGroupValue);
//		}
//		
//		return true;
//	}
//
//	public boolean loadKannelGroupMapping() {
//		stringTemplate.opsForHash().getOperations().delete(kannelGroupMapKey);
//		stringTemplate.opsForHash().getOperations().delete(kannelGroupTpsMapKey);
//		Iterable<NgKannelGroupMapping> ngKannelGroupMappingList = ngKannelGroupMappingRepository.findAll();
//		for (NgKannelGroupMapping ngKannelGroupMapping : ngKannelGroupMappingList) {
//			String kannelGroupIdKey = Integer.toString(ngKannelGroupMapping.getGroupId());
//			String kannelIds = ngKannelGroupMapping.getKannelId();
//			stringTemplate.opsForHash().put(kannelGroupMapKey, kannelGroupIdKey, kannelIds);
//			
//			String kannelTps = ngKannelGroupMapping.getKannelAllowedTps();
//			stringTemplate.opsForHash().put(kannelGroupTpsMapKey, kannelGroupIdKey, kannelTps);
//		}
//		return true;
//	}
//	
//	public boolean loadKannelGroupMappingForGroup(Integer groupId) {
//		if(stringTemplate.opsForHash().get(kannelGroupMapKey, Integer.toString(groupId))!=null) {
//			stringTemplate.opsForHash().delete(kannelGroupMapKey, Integer.toString(groupId));
//		}
//		if(stringTemplate.opsForHash().get(kannelGroupMapKey, Integer.toString(groupId))!=null) {
//			stringTemplate.opsForHash().delete(kannelGroupMapKey, Integer.toString(groupId));
//		}
//		Iterable<NgKannelGroupMapping> ngKannelGroupMappingList = ngKannelGroupMappingRepository.findByGroupId(groupId);
//		for (NgKannelGroupMapping ngKannelGroupMapping : ngKannelGroupMappingList) {
//			String kannelGroupIdKey = Integer.toString(ngKannelGroupMapping.getGroupId());
//			String kannelIds = ngKannelGroupMapping.getKannelId();
//			stringTemplate.opsForHash().put(kannelGroupMapKey, kannelGroupIdKey, kannelIds);
//			
//			String kannelTps = ngKannelGroupMapping.getKannelAllowedTps();
//			stringTemplate.opsForHash().put(kannelGroupTpsMapKey, kannelGroupIdKey, kannelTps);
//		}
//		return true;
//	}
//	
//	public String getKannelIdsForGroupId(String groupId) {
//		if(stringTemplate.opsForHash().get(kannelGroupMapKey, groupId)!=null) {
//			String kannelIds = (String)stringTemplate.opsForHash().get(kannelGroupMapKey, groupId);
//			return kannelIds;
//		}
//		return null;
//	}
//
//	public boolean loadRoutingInfoTrans() {
//		stringTemplate.opsForHash().getOperations().delete(routingInfoTransMapKey);
//		Iterable<NgRoutingInfoTrans> ngRoutingInfoList = ngRoutingInfoTransRepository.findAll();
//		for (NgRoutingInfoTrans ngRoutingInfo : ngRoutingInfoList) {
//			StringBuffer sb = new StringBuffer();
//			if(ngRoutingInfo.getUserId() !=null) {
//				sb = sb.append(ngRoutingInfo.getUserId());
//			}
//			if(ngRoutingInfo.getParentUserId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}
//			}
//			if(ngRoutingInfo.getCarrierId() != null){
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}
//			}
//			if(ngRoutingInfo.getCircleId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}
//			}
//			if(ngRoutingInfo.getSenderId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}
//			}
//			stringTemplate.opsForHash().put(routingInfoTransMapKey, sb.toString(), Integer.toString(ngRoutingInfo.getGroupId()));
//		}
//		return true;
//	}
//	
//	public boolean loadRoutingInfoPromo() {
//		stringTemplate.opsForHash().getOperations().delete(routingInfoPromoMapKey);
//		Iterable<NgRoutingInfoPromo> ngRoutingInfoList = ngRoutingInfoPromoRepository.findAll();
//		for (NgRoutingInfoPromo ngRoutingInfo : ngRoutingInfoList) {
//			StringBuffer sb = new StringBuffer();
//			if(ngRoutingInfo.getUserId() !=null) {
//				sb = sb.append(ngRoutingInfo.getUserId());
//			}
//			if(ngRoutingInfo.getParentUserId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}
//			}
//			if(ngRoutingInfo.getCarrierId() != null){
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}
//			}
//			if(ngRoutingInfo.getCircleId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}
//			}
//			if(ngRoutingInfo.getSenderId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}
//			}
//			stringTemplate.opsForHash().put(routingInfoPromoMapKey, sb.toString(), Integer.toString(ngRoutingInfo.getGroupId()));
//		}
//		return true;
//	}
//	
//	public boolean loadRoutingInfoTransPromoDnd() {
//		stringTemplate.opsForHash().getOperations().delete(routingInfoTransPromoDndMapKey);
//		Iterable<NgRoutingInfoTransPromoDnd> ngRoutingInfoList = ngRoutingInfoTransPromoDndRepository.findAll();
//		for (NgRoutingInfoTransPromoDnd ngRoutingInfo : ngRoutingInfoList) {
//			StringBuffer sb = new StringBuffer();
//			if(ngRoutingInfo.getUserId() !=null) {
//				sb = sb.append(ngRoutingInfo.getUserId());
//			}
//			if(ngRoutingInfo.getParentUserId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}
//			}
//			if(ngRoutingInfo.getCarrierId() != null){
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}
//			}
//			if(ngRoutingInfo.getCircleId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}
//			}
//			if(ngRoutingInfo.getSenderId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}
//			}
//			stringTemplate.opsForHash().put(routingInfoTransPromoDndMapKey, sb.toString(), Integer.toString(ngRoutingInfo.getGroupId()));
//		}
//		return true;
//	}
//	
//	public boolean loadRoutingInfoTransPromoNonDnd() {
//		stringTemplate.opsForHash().getOperations().delete(routingInfoTransPromoNonDndMapKey);
//		Iterable<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoList = ngRoutingInfoTransPromoNonDndRepository.findAll();
//		for (NgRoutingInfoTransPromoNonDnd ngRoutingInfo : ngRoutingInfoList) {
//			StringBuffer sb = new StringBuffer();
//			if(ngRoutingInfo.getUserId() !=null) {
//				sb = sb.append(ngRoutingInfo.getUserId());
//			}
//			if(ngRoutingInfo.getParentUserId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getParentUserId());
//				}
//			}
//			if(ngRoutingInfo.getCarrierId() != null){
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCarrierId());
//				}
//			}
//			if(ngRoutingInfo.getCircleId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getCircleId());
//				}
//			}
//			if(ngRoutingInfo.getSenderId() != null) {
//				if(sb.length()==0) {
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}else {
//					sb = sb.append("#");
//					sb = sb.append(ngRoutingInfo.getSenderId());
//				}
//			}
//			stringTemplate.opsForHash().put(routingInfoTransPromoNonDndMapKey, sb.toString(), Integer.toString(ngRoutingInfo.getGroupId()));
//		}
//		return true;
//	}
//	
//	public Integer getRoutingGroupForKeyForTrans(String key) {
//		logger.info("Going to find group for key {} in map {}", key, routingInfoTransMapKey);
//		if(stringTemplate.opsForHash().get(routingInfoTransMapKey, key)!=null) {
//			Integer routingGroup = Integer.parseInt((String)stringTemplate.opsForHash().get(routingInfoTransMapKey, key));
//			return routingGroup;
//		}
//		return null;
//	}
//	
//	public Integer getRoutingGroupForKeyForPromo(String key) {
//		if(stringTemplate.opsForHash().get(routingInfoPromoMapKey, key)!=null) {
//			Integer routingGroup = Integer.parseInt((String)stringTemplate.opsForHash().get(routingInfoPromoMapKey, key));
//			return routingGroup;
//		}
//		return null;
//	}
//	
//	public Integer getRoutingGroupForKeyForTransPromoDnd(String key) {
//		if(stringTemplate.opsForHash().get(routingInfoTransPromoDndMapKey, key)!=null) {
//			Integer routingGroup = Integer.parseInt((String)stringTemplate.opsForHash().get(routingInfoTransPromoDndMapKey, key));
//			return routingGroup;
//		}
//		return null;
//	}
//	
//	public Integer getRoutingGroupForKeyForTransPromoNonDnd(String key) {
//		if(stringTemplate.opsForHash().get(routingInfoTransPromoNonDndMapKey, key)!=null) {
//			Integer routingGroup = Integer.parseInt((String)stringTemplate.opsForHash().get(routingInfoTransPromoNonDndMapKey, key));
//			return routingGroup;
//		}
//		return null;
//	}
//	
//	public String getCarrierCircleForSeries(String key) {
//		if(stringTemplate.opsForHash().get(numberSeriesMapKey, key)!=null) {
//			String carrierCircleData = (String)stringTemplate.opsForHash().get(numberSeriesMapKey, key);
//			return carrierCircleData;
//		}
//		return "999#999";
//	}
//	
//	public Set<Object> getAllRoutingTypes() {
//		if(stringTemplate.opsForHash().keys(routingTypeMapKey)!=null) {
//			Set<Object> routingTypes = stringTemplate.opsForHash().keys(routingTypeMapKey);
//			return routingTypes;
//		}
//		return null;
//	}
//	
//	public String getSubmitterQueueForGroupId(String groupId) {
//		if(stringTemplate.opsForHash().keys(routingSubmitterQueueMapKey)!=null) {
//			String submitterQueueName = (String)stringTemplate.opsForHash().get(routingSubmitterQueueMapKey, groupId);
//			return submitterQueueName;
//		}
//		return null;
//	}
//
//	/*public boolean loadAllSenderIdAndEntityIdData() {
//		stringTemplate.opsForHash().getOperations().delete(senderIdAndEntityIdMapKey);
//		Iterable<NgUserSenderIdMap> ngSenderIdList = senderIdMapRepository.findAll();
//		for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
//			String senderIdKey = ngUserSenderIdMap.getNgUser().getId()+"#"+ngUserSenderIdMap.getSenderId();
//			String entityId = ngUserSenderIdMap.getEntityId();
//			if(entityId == null) {
//				entityId = "";
//			}
//			String senderIdMapValue = Integer.toString(ngUserSenderIdMap.getId()) +"!!~~!!"+entityId;
//			stringTemplate.opsForHash().put(senderIdAndEntityIdMapKey, senderIdKey, senderIdMapValue);
//		}
//		return true;
//	}*/
//	
//	public boolean loadAllSenderId() {
//		stringTemplate.opsForHash().getOperations().delete(senderIdMapKey);
//		Iterable<NgUserSenderIdMap> ngSenderIdList = senderIdMapRepository.findAll();
//		for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
//			String senderIdKey = ngUserSenderIdMap.getNgUser().getId()+"#"+ngUserSenderIdMap.getSenderId();
//			String senderIdMapValue = Integer.toString(ngUserSenderIdMap.getId());
//			stringTemplate.opsForHash().put(senderIdMapKey, senderIdKey, senderIdMapValue);
//		}
//		return true;
//	}
//	
//	public boolean loadSpecificSenderIdForUser(int userId, String senderId) {
//		NgUserSenderIdMap ngUserSenderIdMap = senderIdMapRepository.findBySenderIdAndUserId(senderId, userId);
//		String senderIdKey = ngUserSenderIdMap.getNgUser().getId()+"#"+ngUserSenderIdMap.getSenderId();
//		String senderIdMapValue = Integer.toString(ngUserSenderIdMap.getId());
//		stringTemplate.opsForHash().put(senderIdMapKey, senderIdKey, senderIdMapValue);
//		return true;
//	}
//	
//	public boolean loadAllEntityIdData() {
//		stringTemplate.opsForHash().getOperations().delete(entityIdMapKey);
//		Iterable<NgUserSenderIdMap> ngSenderIdList = senderIdMapRepository.findAll();
//		for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
//			if(ngUserSenderIdMap.getEntityId() != null) {
//				String senderIdKey = ngUserSenderIdMap.getNgUser().getId()+"#"+ngUserSenderIdMap.getSenderId();
//				String senderIdMapValue = ngUserSenderIdMap.getEntityId();
//				stringTemplate.opsForHash().put(entityIdMapKey, senderIdKey, senderIdMapValue);
//			}
//		}
//		return true;
//	}
//	
//	public boolean loadAllShortCodeData() {
//		stringTemplate.opsForHash().getOperations().delete(shortCodeMapKey);
//		Iterable<NgUserSenderIdMap> ngSenderIdList = senderIdMapRepository.findAll();
//		for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
//			if(ngUserSenderIdMap.getEntityId() != null) {
//				String senderIdKey = ngUserSenderIdMap.getNgUser().getId()+"#"+ngUserSenderIdMap.getSenderId();
//				String senderIdMapValue = ngUserSenderIdMap.getEntityId();
//				stringTemplate.opsForHash().put(shortCodeMapKey, senderIdKey, senderIdMapValue);
//			}
//		}
//		return true;
//	}
//	
//	public boolean loadAllUserSenderIdTemplateData() {
//		redisTemplateForContentTemplateList.opsForHash().getOperations().delete(userSenderIdTemplateMapKey);
//		Iterable<NgContentTemplate> ngContentTemplateList = ngContentTemplateRepository.findByStatus('1');
//		for (NgContentTemplate ngContentTemplate : ngContentTemplateList) {
//			String contentTemplateMapKey = ngContentTemplate.getNgUser().getId()+"#"+ngContentTemplate.getSenderId();
//			Set<String> contentTemplateListForSenderId = (Set<String>)redisTemplateForContentTemplateList.opsForHash().get(userSenderIdTemplateMapKey, contentTemplateMapKey);
//			logger.info("Exisitng Content Template List : {}", contentTemplateListForSenderId);
//			if(contentTemplateListForSenderId == null) {
//				logger.info("Creating new  Content Template List for key: {}", contentTemplateMapKey);
//				contentTemplateListForSenderId = new HashSet<>();
//			}
//			String contentTemplateMapValue = ngContentTemplate.getTemplateText()+"!!~~!!"+ngContentTemplate.getDltTemplateId()+"!!~~!!"+ngContentTemplate.getNgServiceType().getDisplayCode();
//			contentTemplateListForSenderId.add(contentTemplateMapValue);
//			redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
//		}
//		return true;
//	}
//	
//	public boolean loadAllTemplateData() {
//		redisTemplateForContentTemplateList.opsForHash().getOperations().delete(userSenderIdTemplateMapKey);
//		Iterable<NgContentTemplate> ngContentTemplateList = ngContentTemplateRepository.findByStatus('1');
//		for (NgContentTemplate ngContentTemplate : ngContentTemplateList) {
//			String contentTemplateMapKey = ngContentTemplate.getNgUser().getId()+"#"+ngContentTemplate.getSenderId();
//			Set<String> contentTemplateListForSenderId = (Set<String>)redisTemplateForContentTemplateList.opsForHash().get(userSenderIdTemplateMapKey, contentTemplateMapKey);
//			logger.info("Exisitng Content Template List : {}", contentTemplateListForSenderId);
//			if(contentTemplateListForSenderId == null) {
//				logger.info("Creating new  Content Template List for key: {}", contentTemplateMapKey);
//				contentTemplateListForSenderId = new HashSet<>();
//			}
//			String templateText = ngContentTemplate.getTemplateText();
//			if(templateText.contains(")")){
//				templateText = templateText.replace(")", "\\)");
//			}
//			if(templateText.contains(".")){
//				templateText = templateText.replace(".", "\\.");
//			}
//			if(templateText.contains("[")){
//				templateText = templateText.replace("[", "\\[");
//			}
//			if(templateText.contains("]")){
//				templateText = templateText.replace("]", "\\]");
//			}
//			
//			if(templateText.contains("(")){
//				templateText = templateText.replace("(", "\\(");
//			}
//			if(templateText.contains("*")){
//				templateText = templateText.replace("*", "\\*");
//			}
//			if(templateText.contains("+")){
//				templateText = templateText.replace("+", "\\+");
//			}
//			if(templateText.contains("-")){
//				templateText = templateText.replace("-", "\\-");
//			}
//			if(templateText.contains("?")){
//				templateText = templateText.replace("?", "\\?");
//			}
//			if(templateText.contains("^")){
//				templateText = templateText.replace("^", "\\^");
//			}
//			if(templateText.contains("$")){
//				templateText = templateText.replace("$", "\\$");
//			}
//			if(templateText.contains("|")){
//				templateText = templateText.replace("|", "\\|");
//			}
//			String contentTemplateMapValue = templateText+"!!~~!!"+ngContentTemplate.getDltTemplateId()+"!!~~!!"+ngContentTemplate.getNgServiceType().getDisplayCode();
//			contentTemplateListForSenderId.add(contentTemplateMapValue);
//			redisTemplateForContentTemplateList.opsForHash().put(userSenderIdTemplateMapKey, contentTemplateMapKey, contentTemplateListForSenderId);
//		}
//		return true;
//	}
//	
//	/*public String getIdAndEntityIdFromSenderId(String senderId) {
//		if(stringTemplate.opsForHash().keys(senderIdAndEntityIdMapKey)!=null) {
//			if(stringTemplate.opsForHash().get(senderIdAndEntityIdMapKey, senderId) != null) {
//				String senderIdValueFromCache = (String)stringTemplate.opsForHash().get(senderIdAndEntityIdMapKey, senderId);
//				return senderIdValueFromCache;
//			}else {
//				logger.info("Sender Id {} not found in cache.",senderId);
//				return null;
//			}
//		}
//		logger.info("Sender Id {} not found in cache.",senderId);
//		return null;
//	}*/
//	
//	public Integer getIdFromSenderId(String senderId) {
//		//if(stringTemplate.opsForHash().keys(senderIdMapKey)!=null) {
//		Object id = stringTemplate.opsForHash().get(senderIdMapKey, senderId);
//			if(id != null) {
//				Integer idOfSenderId = Integer.parseInt((String)id);
//				logger.info("Sender Id {} found in cache and its id is : {}",senderId, idOfSenderId);
//				return idOfSenderId;
//			}else {
//				logger.info("Sender Id {} not found in cache.",senderId);
//				return null;
//			}
//		/*} 
//		logger.info("Sender Id {} not found in cache.",senderId);
//		return null;*/
//	}
//	
//	public String getEntityIdFromSenderId(String senderId) {
//		//if(stringTemplate.opsForHash().keys(entityIdMapKey)!=null) {
//			Object id = stringTemplate.opsForHash().get(entityIdMapKey, senderId);
//			if(id != null) {
//				String entityId = (String)id;
//				logger.info("Sender Id {} found in cache and its entity id is : {}",senderId, entityId);
//				return entityId;
//			}else {
//				logger.info("Sender Id {} not found in cache.",senderId);
//				return null;
//			}
//		/*}
//		logger.info("Sender Id {} not found in cache.",senderId);
//		return null;*/
//	}
//	
//	public String getShortCodeFromSenderId(String senderId) {
//		//if(stringTemplate.opsForHash().keys(entityIdMapKey)!=null) {
//			Object id = stringTemplate.opsForHash().get(shortCodeMapKey, senderId);
//			if(id != null) {
//				String shortCode = (String)id;
//				logger.info("Sender Id {} found in cache and its short code is : {}",senderId, shortCode);
//				return shortCode;
//			}else {
//				logger.info("Sender Id {} not found in cache.",senderId);
//				return null;
//			}
//		/*}
//		logger.info("Sender Id {} not found in cache.",senderId);
//		return null;*/
//	}
//	
//	public Set<String> getTemplateTextListForUserAndSenderId(String userAndSenderIdKey) {
//		if(redisTemplateForContentTemplateList.opsForHash().keys(userSenderIdTemplateMapKey)!=null) {
//			if(redisTemplateForContentTemplateList.opsForHash().get(userSenderIdTemplateMapKey, userAndSenderIdKey) != null) {
//				Set<String> templateTextListForSenderId = (Set<String>)redisTemplateForContentTemplateList.opsForHash().get(userSenderIdTemplateMapKey, userAndSenderIdKey);
//				logger.info("Template text List for user and sender id key {} is: {}", userAndSenderIdKey, templateTextListForSenderId);
//				return templateTextListForSenderId;
//			}else {
//				logger.info("Template text for user and sender id key {} is not found in cache.", userAndSenderIdKey);
//				return null;
//			}
//		}
//		logger.info("Template text for user and sender id key {} is not found in cache.", userAndSenderIdKey);
//		return null;
//	}
//	
//	public Map<String, Integer> getAllCircleData() {
//		Iterable<NgCircleMaster> circleMasterList = ngCircleRepository.findAll();
//		Map<String, Integer> circleDataMap = new HashMap<String, Integer>();
//		for (NgCircleMaster ngCircleMaster : circleMasterList) {
//			circleDataMap.put(ngCircleMaster.getCircleName(), ngCircleMaster.getId());
//		}
//		return circleDataMap;
//	}
//	
//	public String getCircleNameById(int circleId) {
//		NgCircleMaster ngCircleMaster = ngCircleRepository.findOne(circleId);
//		if(ngCircleMaster != null) {
//			return ngCircleMaster.getCircleName();
//		}
//		return "";
//	}
//	
//	public Map<String, Integer> getAllCarrierData() {
//		Iterable<NgCarrierMaster> carrierMasterList = ngCarrierRepository.findAll();
//		Map<String, Integer> carrierDataMap = new HashMap<String, Integer>();
//		for (NgCarrierMaster ngCarrierMaster : carrierMasterList) {
//			carrierDataMap.put(ngCarrierMaster.getCarrierName(), ngCarrierMaster.getId());
//		}
//		return carrierDataMap;
//	}
//
//	public String getCarrierNameById(int carrierId) {
//		NgCarrierMaster ngCarrierMaster = ngCarrierRepository.findOne(carrierId);
//		if(ngCarrierMaster != null) {
//			return ngCarrierMaster.getCarrierName();
//		}
//		return "";
//	}
//	
//	public List<NgRoutingGroupMaster> getRoutingGroupForUser(int userId){
//		List<NgRoutingGroupMaster> ngRoutingGroupList = ngRoutingGroupRepository.findByUserId(userId);
//		return ngRoutingGroupList;
//	}
//	public NgRoutingGroupMaster getRoutingGroupForId(int id){
//		NgRoutingGroupMaster ngRoutingGroupList = ngRoutingGroupRepository.findById(id);
//		return ngRoutingGroupList;
//	}
//	public NgRoutingGroupMaster saveGroupName(NgRoutingGroupMaster ngRoutingGroupMaster){
//		NgRoutingGroupMaster ngRoutingGroup  = null;
//		ngRoutingGroup = ngRoutingGroupRepository.save(ngRoutingGroupMaster);
//		if (ngRoutingGroup != null) {
//			return ngRoutingGroup;
//		}
//		return ngRoutingGroup;
//	}
//	public boolean updateKannelGroupMappingForGroup(Integer groupId, String kannelIds, String kannelAllowedTps) {
//		ngKannelGroupMappingRepository.delete(ngKannelGroupMappingRepository.findByGroupId(groupId));
//		NgKannelGroupMapping ngKannelGroupMapping = new NgKannelGroupMapping();
//		ngKannelGroupMapping.setGroupId(groupId);
//		ngKannelGroupMapping.setKannelAllowedTps(kannelAllowedTps);
//		ngKannelGroupMapping.setKannelId(kannelIds);
//		
//		NgKannelGroupMapping savedNgKannelGroupMapping = ngKannelGroupMappingRepository.save(ngKannelGroupMapping);
//		if(savedNgKannelGroupMapping != null) {
//			return true;
//		}
//		return false;
//	}
//	
//	public List<UserRoutingData> getAllRoutingInfoForUser(int userId, String routingType){
//		List<UserRoutingData> userRoutingDataList = new ArrayList<UserRoutingData>();
//		if(routingType.equals(Constants.ROUTING_TYPE_TRANS)) {
//			List<NgRoutingInfoTrans> routingInfoTransList = ngRoutingInfoTransRepository.findByUserId(userId);
//			for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList) {
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(),
//						ngRoutingInfoTrans.getSenderId(), ngRoutingInfoTrans.getGroupId(),Constants.ROUTING_TYPE_TRANS);
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_PROMO)) {
//			List<NgRoutingInfoPromo> routingInfoPromoList = ngRoutingInfoPromoRepository.findByUserId(userId);
//			for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
//				logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",ngRoutingInfoPromo.getSenderId(),ngRoutingInfoPromo.getCircleId(),ngRoutingInfoPromo.getCarrierId(),ngRoutingInfoPromo.getGroupId(),routingType);
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(),
//						ngRoutingInfoPromo.getSenderId(), ngRoutingInfoPromo.getGroupId(),Constants.ROUTING_TYPE_PROMO);
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_DND)) {
//			List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = ngRoutingInfoTransPromoDndRepository.findByUserId(userId);
//			for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
//				logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",ngRoutingInfoTransPromoDnd.getSenderId(),ngRoutingInfoTransPromoDnd.getCircleId(),ngRoutingInfoTransPromoDnd.getCarrierId(),ngRoutingInfoTransPromoDnd.getGroupId(),routingType);
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(),
//						ngRoutingInfoTransPromoDnd.getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(),Constants.ROUTING_TYPE_TRANS_PROMO_DND);
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND)) {
//			List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = ngRoutingInfoTransPromoNonDndRepository.findByUserId(userId);
//			for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
//				logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",ngRoutingInfoTransPromoNonDnd.getSenderId(),ngRoutingInfoTransPromoNonDnd.getCircleId(),ngRoutingInfoTransPromoNonDnd.getCarrierId(),ngRoutingInfoTransPromoNonDnd.getGroupId(),routingType);
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(),
//						ngRoutingInfoTransPromoNonDnd.getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND);
//			}
//		}
//		return userRoutingDataList;
//	}
//
//	
//	private void populateUserRoutingDataList(List<UserRoutingData> userRoutingDataList,
//			Integer circleId, Integer carrierId, Integer idOfSenderId, Integer groupId, String routingType) {
//		UserRoutingData userRoutingData = new UserRoutingData();
//		logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",idOfSenderId,circleId,carrierId,groupId,routingType);
//		//userRoutingData.setRoutingType(routingType);
//		//Map<String, Integer> operatorMap  = new HashMap<>();
//		if(carrierId != null && carrierId > 0) {
//			NgCarrierMaster ngCarrierMaster = ngCarrierRepository.findOne(carrierId);
//			userRoutingData.setOperator(ngCarrierMaster.getCarrierName());
//		}else{
//			userRoutingData.setOperator("All");
//		}
//		
//		
//		if(circleId != null && circleId > 0) {
//			NgCircleMaster ngCircleMaster = ngCircleRepository.findOne(circleId);
//			//circleMap.put(ngCircleMaster.getCircleName(), ngCircleMaster.getId());
//			userRoutingData.setCircle(ngCircleMaster.getCircleName());
//		}else {
//			userRoutingData.setCircle("All");	
//		}
//		
//		if(idOfSenderId != null && idOfSenderId > 0) {
//			NgUserSenderIdMap userSenderIdMap = userSenderIdMapRepository.findById(idOfSenderId);
//			logger.info("userSenderIdMap Sender id {}", userSenderIdMap.getSenderId());
//			if(userSenderIdMap != null)
//				userRoutingData.setSenderId(userSenderIdMap.getSenderId());
//			else
//				userRoutingData.setSenderId("All");
//		}else {
//			userRoutingData.setSenderId("All");
//		}
//		
////		NgRoutingGroupMaster ngRoutingGroupMaster = ngRoutingGroupRepository.findOne(groupId);
//		NgRoutingGroupMaster ngRoutingGroupMaster = ngRoutingGroupRepository.findById(groupId);
//		userRoutingData.setGroupName(ngRoutingGroupMaster.getGroupName());
//		logger.info("Group Name  {}", ngRoutingGroupMaster.getGroupName());
//		userRoutingDataList.add(userRoutingData);
//		logger.info("userRoutingDataList {}", userRoutingDataList.size());
//	}
//	
//	private void populateUserRoutingDataListForAllUser(List<UserRoutingDataForAllUser> userRoutingDataList,
//			Integer circleId, Integer carrierId, Integer idOfSenderId, Integer groupId,int id, String routingType) {
//		UserRoutingDataForAllUser userRoutingData = new UserRoutingDataForAllUser();
//		logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",idOfSenderId,circleId,carrierId,groupId,routingType);
//		//userRoutingData.setRoutingType(routingType);
//		//Map<String, Integer> operatorMap  = new HashMap<>();
//		
//		if(carrierId != null && carrierId > 0) {
//			NgCarrierMaster ngCarrierMaster = ngCarrierRepository.findOne(carrierId);
//			userRoutingData.setOperator(ngCarrierMaster.getCarrierName());
//		}else{
//			userRoutingData.setOperator("All");
//		}
//		
//		
//		if(circleId != null && circleId > 0) {
//			NgCircleMaster ngCircleMaster = ngCircleRepository.findOne(circleId);
//			//circleMap.put(ngCircleMaster.getCircleName(), ngCircleMaster.getId());
//			userRoutingData.setCircle(ngCircleMaster.getCircleName());
//		}else {
//			userRoutingData.setCircle("All");	
//		}
//		
//		if(idOfSenderId != null && idOfSenderId > 0) {
//			NgUserSenderIdMap userSenderIdMap = userSenderIdMapRepository.findById(idOfSenderId);
//			logger.info("userSenderIdMap Sender id {}", userSenderIdMap.getSenderId());
//			if(userSenderIdMap != null)
//				userRoutingData.setSenderId(userSenderIdMap.getSenderId());
//			else
//				userRoutingData.setSenderId("All");
//		}else {
//			userRoutingData.setSenderId("All");
//		}
//		
////		NgRoutingGroupMaster ngRoutingGroupMaster = ngRoutingGroupRepository.findOne(groupId);
//		NgRoutingGroupMaster ngRoutingGroupMaster = ngRoutingGroupRepository.findById(groupId);
//		userRoutingData.setGroupName(ngRoutingGroupMaster.getGroupName());
//		userRoutingData.setRoutingId(id);
//		logger.info("Group Name  {}", ngRoutingGroupMaster.getGroupName());
//		userRoutingDataList.add(userRoutingData);
//		logger.info("userRoutingDataList {}", userRoutingDataList.size());
//	}
//	
//	public List<UserRoutingData> getAllRoutingInfoForParent(int parentUserId, String routingType){
//		List<UserRoutingData> userRoutingDataList = new ArrayList<UserRoutingData>();
//		
//		if(routingType.equals(Constants.ROUTING_TYPE_TRANS)) {
//			List<NgRoutingInfoTrans> routingInfoTransList = ngRoutingInfoTransRepository.findByParentUserId(parentUserId);
//			for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList) {
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(),
//						ngRoutingInfoTrans.getSenderId(), ngRoutingInfoTrans.getGroupId(),Constants.ROUTING_TYPE_TRANS );
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_PROMO)) {
//			List<NgRoutingInfoPromo> routingInfoPromoList = ngRoutingInfoPromoRepository.findByParentUserId(parentUserId);
//			for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(),
//						ngRoutingInfoPromo.getSenderId(), ngRoutingInfoPromo.getGroupId(),Constants.ROUTING_TYPE_PROMO);
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_DND)) {
//			List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = ngRoutingInfoTransPromoDndRepository.findByParentUserId(parentUserId);
//			for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(),
//						ngRoutingInfoTransPromoDnd.getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(),Constants.ROUTING_TYPE_TRANS_PROMO_DND);
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND)) {
//			List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = ngRoutingInfoTransPromoNonDndRepository.findByParentUserId(parentUserId);
//			for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
//				populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(),
//						ngRoutingInfoTransPromoNonDnd.getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(),Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND);
//			}
//		}
//		return userRoutingDataList;
//	}
//
//	public Integer getFailOverRoutingGroup(Integer groupId) {
//		NgRoutingGroupMaster routingGroup = ngRoutingGroupRepository.findOne(groupId);
//		if(routingGroup != null && routingGroup.getFailOverGroupId() != 0) {
//			return routingGroup.getFailOverGroupId();
//		}
//		return groupId;
//	}
//
//	public boolean updateTransRoutingInfoForUser(Integer clientId, String routingType,
//			List<NgRoutingInfoTrans> ngRoutingInfoTransList) {
//		
//		List<NgRoutingInfoTrans> routingInfo = ngRoutingInfoTransRepository.findByUserId(clientId);
//		logger.info("clientId {}, RoutingInfo {}",clientId, routingInfo.size());
//		ngRoutingInfoTransRepository.delete(routingInfo);
//		if(ngRoutingInfoTransList !=null) {
//		Iterable<NgRoutingInfoTrans> iterable = ngRoutingInfoTransRepository.save(ngRoutingInfoTransList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean updateTransRoutingInfoForParent(Integer parentId, String routingType,
//			List<NgRoutingInfoTrans> ngRoutingInfoTransList) {
//		List<NgRoutingInfoTrans> routingInfo = ngRoutingInfoTransRepository.findByParentUserId(parentId);
//		logger.info("parentId {}, RoutingInfo {}",parentId, routingInfo.size());
//		ngRoutingInfoTransRepository.delete(routingInfo);
//		if(ngRoutingInfoTransList != null) {
//		Iterable<NgRoutingInfoTrans> iterable = ngRoutingInfoTransRepository.save(ngRoutingInfoTransList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updateTransRoutingInfoForId(String routingType,List<NgRoutingInfoTrans> ngRoutingInfoTransList) {
//		if(ngRoutingInfoTransList != null) {
//		Iterable<NgRoutingInfoTrans> iterable = ngRoutingInfoTransRepository.save(ngRoutingInfoTransList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean updatePromoRoutingInfoForUser(Integer clientId, String routingType,
//			List<NgRoutingInfoPromo> ngRoutingInfoPromoList) {
//		List<NgRoutingInfoPromo> routingInfo = ngRoutingInfoPromoRepository.findByUserId(clientId);
//		logger.info("clientId {}, RoutingInfo {}",clientId, routingInfo.size());
//		ngRoutingInfoPromoRepository.delete(routingInfo);
//		if(ngRoutingInfoPromoList != null) {
//		Iterable<NgRoutingInfoPromo> iterable = ngRoutingInfoPromoRepository.save(ngRoutingInfoPromoList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updatePromoRoutingInfoForId( String routingType,
//			List<NgRoutingInfoPromo> ngRoutingInfoPromoList) {
//		if(ngRoutingInfoPromoList != null) {
//		Iterable<NgRoutingInfoPromo> iterable = ngRoutingInfoPromoRepository.save(ngRoutingInfoPromoList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updatePromoRoutingInfoForParent(Integer parentId, String routingType,
//			List<NgRoutingInfoPromo> ngRoutingInfoPromoList) {
//		List<NgRoutingInfoPromo> routingInfo = ngRoutingInfoPromoRepository.findByParentUserId(parentId);
//		logger.info("parentId {}, RoutingInfo {}",parentId, routingInfo.size());
//		ngRoutingInfoPromoRepository.delete(routingInfo);
//		if(ngRoutingInfoPromoList != null) {
//		Iterable<NgRoutingInfoPromo> iterable = ngRoutingInfoPromoRepository.save(ngRoutingInfoPromoList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean updateTransPromoDndRoutingInfoForUser(Integer clientId, String routingType,
//			List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList) {
//		List<NgRoutingInfoTransPromoDnd> routingInfo = ngRoutingInfoTransPromoDndRepository.findByUserId(clientId);
//		logger.info("clientId {}, RoutingInfo {}",clientId, routingInfo.size());
//		ngRoutingInfoTransPromoDndRepository.delete(routingInfo);
//		if(ngRoutingInfoTransPromoDndList != null) {
//		Iterable<NgRoutingInfoTransPromoDnd> iterable = ngRoutingInfoTransPromoDndRepository.save(ngRoutingInfoTransPromoDndList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updateTransPromoDndRoutingInfoForId( String routingType,
//			List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList) {
//		if(ngRoutingInfoTransPromoDndList != null) {
//		Iterable<NgRoutingInfoTransPromoDnd> iterable = ngRoutingInfoTransPromoDndRepository.save(ngRoutingInfoTransPromoDndList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updateTransPromoDndRoutingInfoForParent(Integer parentId, String routingType,
//			List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList) {
//		List<NgRoutingInfoTransPromoDnd> routingInfo = ngRoutingInfoTransPromoDndRepository.findByParentUserId(parentId);
//		logger.info("parentId {}, RoutingInfo {}",parentId, routingInfo.size());
//		ngRoutingInfoTransPromoDndRepository.delete(routingInfo);
//		if(ngRoutingInfoTransPromoDndList != null) {
//		Iterable<NgRoutingInfoTransPromoDnd> iterable = ngRoutingInfoTransPromoDndRepository.save(ngRoutingInfoTransPromoDndList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean updateTransPromoNonDndRoutingInfoForUser(Integer clientId, String routingType,
//			List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList) {
//		List<NgRoutingInfoTransPromoNonDnd> routingInfo = ngRoutingInfoTransPromoNonDndRepository.findByUserId(clientId);
//		logger.info("clientId {}, RoutingInfo {}",clientId, routingInfo.size());
//		ngRoutingInfoTransPromoNonDndRepository.delete(routingInfo);
//		if(ngRoutingInfoTransPromoNonDndList != null) {
//		Iterable<NgRoutingInfoTransPromoNonDnd> iterable = ngRoutingInfoTransPromoNonDndRepository.save(ngRoutingInfoTransPromoNonDndList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updateTransPromoNonDndRoutingInfoForId( String routingType,
//			List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList) {
//		if(ngRoutingInfoTransPromoNonDndList != null) {
//		Iterable<NgRoutingInfoTransPromoNonDnd> iterable = ngRoutingInfoTransPromoNonDndRepository.save(ngRoutingInfoTransPromoNonDndList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//	}
//	public boolean updateTransPromoNonDndRoutingInfoForParent(Integer parentId, String routingType,
//			List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList) {
//		List<NgRoutingInfoTransPromoNonDnd> routingInfo = ngRoutingInfoTransPromoNonDndRepository.findByParentUserId(parentId);
//		logger.info("parentId {}, RoutingInfo {}",parentId, routingInfo.size());
//		ngRoutingInfoTransPromoNonDndRepository.delete(routingInfo);
//		if(ngRoutingInfoTransPromoNonDndList != null) {
//		Iterable<NgRoutingInfoTransPromoNonDnd> iterable = ngRoutingInfoTransPromoNonDndRepository.save(ngRoutingInfoTransPromoNonDndList);
//		if(iterable !=null) {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		}
//		else {
//			loadSpecificRoutingInFoInCache(routingType);
//			return true;
//		}
//		return false;
//		
//	}
//
//	
//	public Iterable<NgCarrierMaster> loadCarrierDataList() {
//		Iterable<NgCarrierMaster> ngCarrierList = ngCarrierRepository.findAll();	
//		return ngCarrierList;
//	}
//
//	public Iterable<NgCircleMaster>  loadCircleDataList() {
//		Iterable<NgCircleMaster> ngCircleList = ngCircleRepository.findAll();	
//		return ngCircleList;
//	}
//	public List<NgRoutingInfoTrans>  getUserDetailsFromTransByGroupId(int groupId) {
//		List<NgRoutingInfoTrans> getUserDatails= ngRoutingInfoTransRepository.findByGroupId(groupId);
//		return getUserDatails;
//	}
//	public List<NgRoutingInfoPromo>  getUserDetailsFromPromoByGroupId(int groupId) {
//		List<NgRoutingInfoPromo> getUserDatails= ngRoutingInfoPromoRepository.findByGroupId(groupId);
//		return getUserDatails;
//	}
//	public List<NgRoutingInfoTransPromoDnd>  getUserDetailsFromTransPromoDNDByGroupId(int groupId) {
//		List<NgRoutingInfoTransPromoDnd> getUserDatails = ngRoutingInfoTransPromoDndRepository.findByGroupId(groupId);
//		return getUserDatails;
//	}
//	public List<NgRoutingInfoTransPromoNonDnd>  getUserDetailsFromTransPromoNonDNDByGroupId(int groupId) {
//		List<NgRoutingInfoTransPromoNonDnd> getUserDatails = ngRoutingInfoTransPromoNonDndRepository.findByGroupId(groupId);
//		return getUserDatails;
//	}
//	
//	public NgRoutingInfoTrans getUserDetailsFromTransById(int id) {
//		NgRoutingInfoTrans getUserDatails= ngRoutingInfoTransRepository.findById(id);
//		return getUserDatails;
//	}
//	public NgRoutingInfoPromo  getUserDetailsFromPromoById(int id) {
//		NgRoutingInfoPromo getUserDatails= ngRoutingInfoPromoRepository.findById(id);
//		return getUserDatails;
//	}
//	public NgRoutingInfoTransPromoDnd  getUserDetailsFromTransPromoDNDById(int id) {
//		NgRoutingInfoTransPromoDnd getUserDatails = ngRoutingInfoTransPromoDndRepository.findById(id);
//		return getUserDatails;
//	}
//	public NgRoutingInfoTransPromoNonDnd  getUserDetailsFromTransPromoNonDNDById(int id) {
//		NgRoutingInfoTransPromoNonDnd getUserDatails = ngRoutingInfoTransPromoNonDndRepository.findById(id);
//		return getUserDatails;
//	}
//	public List<UserRoutingDataForAllUser> getAllRoutingInfoForParentId(int parentUserId, String groupName, String routingType){
//			List<UserRoutingDataForAllUser> userRoutingDataList = new ArrayList<UserRoutingDataForAllUser>();
//			
//			if(routingType.equals(Constants.ROUTING_TYPE_TRANS)) {
//				List<NgRoutingInfoTrans> routingInfoTransList = ngRoutingInfoTransRepository.findByParentUserId(parentUserId);
//				for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList) {
//					if (groupName.equalsIgnoreCase("all") ||groupName.equals(String.valueOf( ngRoutingInfoTrans.getGroupId())) ) {
//					populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(),
//							ngRoutingInfoTrans.getSenderId(), ngRoutingInfoTrans.getGroupId(),ngRoutingInfoTrans.getId(),Constants.ROUTING_TYPE_TRANS );
//				}
//				}
//			}else if(routingType.equals(Constants.ROUTING_TYPE_PROMO)) {
//				List<NgRoutingInfoPromo> routingInfoPromoList = ngRoutingInfoPromoRepository.findByParentUserId(parentUserId);
//				for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
//					if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf( ngRoutingInfoPromo.getGroupId())) ) {
//					populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(),
//							ngRoutingInfoPromo.getSenderId(), ngRoutingInfoPromo.getGroupId(),ngRoutingInfoPromo.getId(),Constants.ROUTING_TYPE_PROMO);
//				}
//				}
//			}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_DND)) {
//				List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = ngRoutingInfoTransPromoDndRepository.findByParentUserId(parentUserId);
//				for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
//					if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf( ngRoutingInfoTransPromoDnd.getGroupId())) ) {
//					populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(),
//							ngRoutingInfoTransPromoDnd.getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(),ngRoutingInfoTransPromoDnd.getId(),Constants.ROUTING_TYPE_TRANS_PROMO_DND);
//				}
//				}
//			}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND)) {
//				List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = ngRoutingInfoTransPromoNonDndRepository.findByParentUserId(parentUserId);
//				for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
//					if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf( ngRoutingInfoTransPromoNonDnd.getGroupId())) ) {
//					populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(),
//							ngRoutingInfoTransPromoNonDnd.getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(),ngRoutingInfoTransPromoNonDnd.getId(),Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND);
//				}
//				}
//			}
//			return userRoutingDataList;
//		}
//	public List<UserRoutingDataForAllUser> getAllRoutingInfoForUserId(int userId, String groupName, String routingType){
//		List<UserRoutingDataForAllUser> userRoutingDataList = new ArrayList<UserRoutingDataForAllUser>();
//		if(routingType.equals(Constants.ROUTING_TYPE_TRANS)) {
//			List<NgRoutingInfoTrans> routingInfoTransList = ngRoutingInfoTransRepository.findByUserId(userId);
//			for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList) {
//				if (groupName.equalsIgnoreCase("all") ||groupName.equals(String.valueOf( ngRoutingInfoTrans.getGroupId())) ) {
//				populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(),
//						ngRoutingInfoTrans.getSenderId(), ngRoutingInfoTrans.getGroupId(),ngRoutingInfoTrans.getId(),Constants.ROUTING_TYPE_TRANS);
//			}
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_PROMO)) {
//			List<NgRoutingInfoPromo> routingInfoPromoList = ngRoutingInfoPromoRepository.findByUserId(userId);
//			for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
//				if (groupName.equalsIgnoreCase("all") ||groupName.equals(String.valueOf( ngRoutingInfoPromo.getGroupId())) ) {
//				logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",ngRoutingInfoPromo.getSenderId(),ngRoutingInfoPromo.getCircleId(),ngRoutingInfoPromo.getCarrierId(),ngRoutingInfoPromo.getGroupId(),routingType);
//				populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(),
//						ngRoutingInfoPromo.getSenderId(), ngRoutingInfoPromo.getGroupId(),ngRoutingInfoPromo.getId(),Constants.ROUTING_TYPE_PROMO);
//			}
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_DND)) {
//			List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = ngRoutingInfoTransPromoDndRepository.findByUserId(userId);
//			for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
//				if (groupName.equalsIgnoreCase("all") ||groupName.equals(String.valueOf( ngRoutingInfoTransPromoDnd.getGroupId())) ) {
//				logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",ngRoutingInfoTransPromoDnd.getSenderId(),ngRoutingInfoTransPromoDnd.getCircleId(),ngRoutingInfoTransPromoDnd.getCarrierId(),ngRoutingInfoTransPromoDnd.getGroupId(),routingType);
//				populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(),
//						ngRoutingInfoTransPromoDnd.getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(),ngRoutingInfoTransPromoDnd.getId(),Constants.ROUTING_TYPE_TRANS_PROMO_DND);
//			}
//			}
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND)) {
//			List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = ngRoutingInfoTransPromoNonDndRepository.findByUserId(userId);
//			for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
//				if (groupName.equalsIgnoreCase("all") ||groupName.equals(String.valueOf( ngRoutingInfoTransPromoNonDnd.getGroupId())) ) {
//				logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}",ngRoutingInfoTransPromoNonDnd.getSenderId(),ngRoutingInfoTransPromoNonDnd.getCircleId(),ngRoutingInfoTransPromoNonDnd.getCarrierId(),ngRoutingInfoTransPromoNonDnd.getGroupId(),routingType);
//				populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(),
//						ngRoutingInfoTransPromoNonDnd.getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(),ngRoutingInfoTransPromoNonDnd.getId(), Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND);
//			}
//		}
//		}
//		return userRoutingDataList;
//	}
//
//	public void loadSpecificRoutingInFoInCache(String routingType) {
//		if(routingType.equals(Constants.ROUTING_TYPE_TRANS)) {
//			loadRoutingInfoTrans();
//		}else if(routingType.equals(Constants.ROUTING_TYPE_PROMO)) {
//			loadRoutingInfoPromo();
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_DND)) {
//			loadRoutingInfoTransPromoDnd();
//		}else if(routingType.equals(Constants.ROUTING_TYPE_TRANS_PROMO_NON_DND)) {
//			loadRoutingInfoTransPromoNonDnd();
//		}
//	}
//	
//	public static void main(String[] args) {
//		String senderId = "134#DALYRT";
//		senderId = senderId.toLowerCase();
//		System.out.println(senderId);
//	}
//}
// production class ----------------------.............................................




package com.noesis.domain.service;

import com.noesis.domain.dto.UserRoutingData;
import com.noesis.domain.dto.UserRoutingDataForAllUser;
import com.noesis.domain.persistence.NgCarrierMaster;
import com.noesis.domain.persistence.NgCircleMaster;
import com.noesis.domain.persistence.NgContentTemplate;
import com.noesis.domain.persistence.NgKannelGroupMapping;
import com.noesis.domain.persistence.NgNumberCarrierCircleMapping;
import com.noesis.domain.persistence.NgRoutingGroupMaster;
import com.noesis.domain.persistence.NgRoutingInfoPromo;
import com.noesis.domain.persistence.NgRoutingInfoTrans;
import com.noesis.domain.persistence.NgRoutingInfoTransPromoDnd;
import com.noesis.domain.persistence.NgRoutingInfoTransPromoNonDnd;
import com.noesis.domain.persistence.NgRoutingTypeMaster;
import com.noesis.domain.persistence.NgUserSenderIdMap;
import com.noesis.domain.repository.NgCarrierRepository;
import com.noesis.domain.repository.NgCircleRepository;
import com.noesis.domain.repository.NgContentTemplateRepository;
import com.noesis.domain.repository.NgKannelGroupMappingRepository;
import com.noesis.domain.repository.NgNumberSeriesRepository;
import com.noesis.domain.repository.NgRoutingGroupRepository;
import com.noesis.domain.repository.NgRoutingInfoPromoRepository;
import com.noesis.domain.repository.NgRoutingInfoTransPromoDndRepository;
import com.noesis.domain.repository.NgRoutingInfoTransPromoNonDndRepository;
import com.noesis.domain.repository.NgRoutingInfoTransRepository;
import com.noesis.domain.repository.NgRoutingTypeRepository;
import com.noesis.domain.repository.UserSenderIdMapRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StaticDataService {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  
  private static final String carrierDataMapKey = "CARRIER_DATA_MAP";
  
  private static final String circleDataMapKey = "CIRCLE_DATA_MAP";
  
  private static final String numberSeriesMapKey = "NUM_SERIES_DATA_MAP";
  
  private static final String routingTypeMapKey = "ROUTING_TYPE_MAP";
  
  private static final String routingInfoTransMapKey = "ROUTING_INFO_TRANS_MAP";
  
  private static final String routingInfoPromoMapKey = "ROUTING_INFO_PROMO_MAP";
  
  private static final String routingInfoTransPromoDndMapKey = "ROUTING_INFO_TRANS_PROMO_DND_MAP";
  
  private static final String routingInfoTransPromoNonDndMapKey = "ROUTING_INFO_TRANS_PROMO_NON_DND_MAP";
  
  private static final String routingGroupMapKey = "ROUTING_GROUP_MAP";
  
  private static final String kannelGroupMapKey = "KANNEL_GROUP_MAP";
  
  private static final String kannelGroupTpsMapKey = "KANNEL_GROUP_TPS_MAP";
  
  private static final String routingSubmitterQueueMapKey = "ROUTING_SUBMITTER_QUEUE_MAP";
  
  private static final String senderIdMapKey = "SENDER_ID_MAP";
  
  private static final String entityIdMapKey = "ENTITY_ID_MAP";
  
  private static final String shortCodeMapKey = "SHORT_CODE_MAP";
  
  private static final String senderIdAndEntityIdMapKey = "SENDER_ID_AND_ENTITY_ID_MAP";
  
  private static final String userSenderIdTemplateMapKey = "USER_SENDER_ID_TEMPLATE_MAP_KEY";
  
  @Autowired
  StringRedisTemplate stringTemplate;
  
  @Autowired
  private RedisTemplate<String, Set<String>> redisTemplateForContentTemplateList;
  
  @Autowired
  UserSenderIdMapRepository userSenderIdMapRepository;
  
  @Autowired
  NgCarrierRepository ngCarrierRepository;
  
  @Autowired
  NgCircleRepository ngCircleRepository;
  
  @Autowired
  NgRoutingGroupRepository ngRoutingGroupRepository;
  
  @Autowired
  NgRoutingInfoTransRepository ngRoutingInfoTransRepository;
  
  @Autowired
  NgRoutingInfoTransPromoDndRepository ngRoutingInfoTransPromoDndRepository;
  
  @Autowired
  NgRoutingInfoTransPromoNonDndRepository ngRoutingInfoTransPromoNonDndRepository;
  
  @Autowired
  NgRoutingInfoPromoRepository ngRoutingInfoPromoRepository;
  
  @Autowired
  NgRoutingTypeRepository ngRoutingTypeRepository;
  
  @Autowired
  NgKannelGroupMappingRepository ngKannelGroupMappingRepository;
  
  @Autowired
  NgNumberSeriesRepository ngNumberSeriesRepository;
  
  @Autowired
  UserSenderIdMapRepository senderIdMapRepository;
  
  @Autowired
  NgContentTemplateRepository ngContentTemplateRepository;
  
  public boolean loadCarrierData() {
    this.stringTemplate.opsForHash().getOperations().delete("CARRIER_DATA_MAP");
    Iterable<NgCarrierMaster> ngCarrierList = this.ngCarrierRepository.findAll();
    for (NgCarrierMaster ngCarrierMaster : ngCarrierList)
      this.stringTemplate.opsForHash().put("CARRIER_DATA_MAP", Integer.toString(ngCarrierMaster.getId()), ngCarrierMaster.getCarrierName()); 
    return true;
  }
  
  public boolean loadCircleData() {
    this.stringTemplate.opsForHash().getOperations().delete("CIRCLE_DATA_MAP");
    Iterable<NgCircleMaster> ngCircleList = this.ngCircleRepository.findAll();
    for (NgCircleMaster ngCircleMaster : ngCircleList)
      this.stringTemplate.opsForHash().put("CIRCLE_DATA_MAP", Integer.toString(ngCircleMaster.getId()), ngCircleMaster.getCircleName()); 
    return true;
  }
  
  public boolean loadNumberSeriesData() {
    this.stringTemplate.opsForHash().getOperations().delete("NUM_SERIES_DATA_MAP");
    Iterable<NgNumberCarrierCircleMapping> ngNumSeriesMappingList = this.ngNumberSeriesRepository.findAll();
    for (NgNumberCarrierCircleMapping ngNumberCarrierCircleMapping : ngNumSeriesMappingList) {
      String numSeriesKey = ngNumberCarrierCircleMapping.getNumSeries();
      String numSeriesValue = ngNumberCarrierCircleMapping.getCarrierId() + "#" + ngNumberCarrierCircleMapping.getCircleId();
      this.stringTemplate.opsForHash().put("NUM_SERIES_DATA_MAP", numSeriesKey, numSeriesValue);
    } 
    return true;
  }
  
  public boolean loadRoutingTypes() {
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_TYPE_MAP");
    Iterable<NgRoutingTypeMaster> ngRoutingTypeList = this.ngRoutingTypeRepository.findAll();
    for (NgRoutingTypeMaster ngRoutingTypeMaster : ngRoutingTypeList) {
      String routingTypeKey = ngRoutingTypeMaster.getRoutingType() + "#" + ngRoutingTypeMaster.getPriority();
      String routingTypeValue = ngRoutingTypeMaster.getRoutingType() + "#" + ngRoutingTypeMaster.getPriority();
      this.stringTemplate.opsForHash().put("ROUTING_TYPE_MAP", routingTypeKey, routingTypeValue);
    } 
    return true;
  }
  
  public boolean loadRoutingGroups() {
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_GROUP_MAP");
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_SUBMITTER_QUEUE_MAP");
    Iterable<NgRoutingGroupMaster> ngRoutingGroupList = this.ngRoutingGroupRepository.findAll();
    for (NgRoutingGroupMaster ngRoutingGroupMaster : ngRoutingGroupList) {
      String routingGroupKey = Integer.toString(ngRoutingGroupMaster.getId());
      String routingGroupValue = ngRoutingGroupMaster.getGroupName();
      this.stringTemplate.opsForHash().put("ROUTING_GROUP_MAP", routingGroupKey, routingGroupValue);
      routingGroupValue = ngRoutingGroupMaster.getSubmitterQueueName();
      this.stringTemplate.opsForHash().put("ROUTING_SUBMITTER_QUEUE_MAP", routingGroupKey, routingGroupValue);
    } 
    return true;
  }
  
  public boolean loadKannelGroupMapping() {
    this.stringTemplate.opsForHash().getOperations().delete("KANNEL_GROUP_MAP");
    this.stringTemplate.opsForHash().getOperations().delete("KANNEL_GROUP_TPS_MAP");
    Iterable<NgKannelGroupMapping> ngKannelGroupMappingList = this.ngKannelGroupMappingRepository.findAll();
    for (NgKannelGroupMapping ngKannelGroupMapping : ngKannelGroupMappingList) {
      String kannelGroupIdKey = Integer.toString(ngKannelGroupMapping.getGroupId());
      String kannelIds = ngKannelGroupMapping.getKannelId();
      this.stringTemplate.opsForHash().put("KANNEL_GROUP_MAP", kannelGroupIdKey, kannelIds);
      String kannelTps = ngKannelGroupMapping.getKannelAllowedTps();
      this.stringTemplate.opsForHash().put("KANNEL_GROUP_TPS_MAP", kannelGroupIdKey, kannelTps);
    } 
    return true;
  }
  
  public boolean loadKannelGroupMappingForGroup(Integer groupId) {
    if (this.stringTemplate.opsForHash().get("KANNEL_GROUP_MAP", Integer.toString(groupId.intValue())) != null)
      this.stringTemplate.opsForHash().delete("KANNEL_GROUP_MAP", new Object[] { Integer.toString(groupId.intValue()) }); 
    if (this.stringTemplate.opsForHash().get("KANNEL_GROUP_MAP", Integer.toString(groupId.intValue())) != null)
      this.stringTemplate.opsForHash().delete("KANNEL_GROUP_MAP", new Object[] { Integer.toString(groupId.intValue()) }); 
    Iterable<NgKannelGroupMapping> ngKannelGroupMappingList = this.ngKannelGroupMappingRepository.findByGroupId(groupId);
    for (NgKannelGroupMapping ngKannelGroupMapping : ngKannelGroupMappingList) {
      String kannelGroupIdKey = Integer.toString(ngKannelGroupMapping.getGroupId());
      String kannelIds = ngKannelGroupMapping.getKannelId();
      this.stringTemplate.opsForHash().put("KANNEL_GROUP_MAP", kannelGroupIdKey, kannelIds);
      String kannelTps = ngKannelGroupMapping.getKannelAllowedTps();
      this.stringTemplate.opsForHash().put("KANNEL_GROUP_TPS_MAP", kannelGroupIdKey, kannelTps);
    } 
    return true;
  }
  
  public String getKannelIdsForGroupId(String groupId) {
    if (this.stringTemplate.opsForHash().get("KANNEL_GROUP_MAP", groupId) != null) {
      String kannelIds = (String)this.stringTemplate.opsForHash().get("KANNEL_GROUP_MAP", groupId);
      return kannelIds;
    } 
    return null;
  }
  
  public boolean loadRoutingInfoTrans() {
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_INFO_TRANS_MAP");
    Iterable<NgRoutingInfoTrans> ngRoutingInfoList = this.ngRoutingInfoTransRepository.findAll();
    for (NgRoutingInfoTrans ngRoutingInfo : ngRoutingInfoList) {
      StringBuffer sb = new StringBuffer();
      if (ngRoutingInfo.getUserId() != null)
        sb = sb.append(ngRoutingInfo.getUserId()); 
      if (ngRoutingInfo.getParentUserId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getParentUserId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getParentUserId());
        }  
      if (ngRoutingInfo.getCarrierId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCarrierId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCarrierId());
        }  
      if (ngRoutingInfo.getCircleId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCircleId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCircleId());
        }  
      if (ngRoutingInfo.getSenderId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getSenderId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getSenderId());
        }  
      this.stringTemplate.opsForHash().put("ROUTING_INFO_TRANS_MAP", sb.toString(), Integer.toString(ngRoutingInfo.getGroupId().intValue()));
    } 
    return true;
  }
  
  public boolean loadRoutingInfoPromo() {
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_INFO_PROMO_MAP");
    Iterable<NgRoutingInfoPromo> ngRoutingInfoList = this.ngRoutingInfoPromoRepository.findAll();
    for (NgRoutingInfoPromo ngRoutingInfo : ngRoutingInfoList) {
      StringBuffer sb = new StringBuffer();
      if (ngRoutingInfo.getUserId() != null)
        sb = sb.append(ngRoutingInfo.getUserId()); 
      if (ngRoutingInfo.getParentUserId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getParentUserId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getParentUserId());
        }  
      if (ngRoutingInfo.getCarrierId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCarrierId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCarrierId());
        }  
      if (ngRoutingInfo.getCircleId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCircleId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCircleId());
        }  
      if (ngRoutingInfo.getSenderId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getSenderId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getSenderId());
        }  
      this.stringTemplate.opsForHash().put("ROUTING_INFO_PROMO_MAP", sb.toString(), Integer.toString(ngRoutingInfo.getGroupId().intValue()));
    } 
    return true;
  }
  
  public boolean loadRoutingInfoTransPromoDnd() {
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_INFO_TRANS_PROMO_DND_MAP");
    Iterable<NgRoutingInfoTransPromoDnd> ngRoutingInfoList = this.ngRoutingInfoTransPromoDndRepository.findAll();
    for (NgRoutingInfoTransPromoDnd ngRoutingInfo : ngRoutingInfoList) {
      StringBuffer sb = new StringBuffer();
      if (ngRoutingInfo.getUserId() != null)
        sb = sb.append(ngRoutingInfo.getUserId()); 
      if (ngRoutingInfo.getParentUserId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getParentUserId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getParentUserId());
        }  
      if (ngRoutingInfo.getCarrierId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCarrierId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCarrierId());
        }  
      if (ngRoutingInfo.getCircleId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCircleId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCircleId());
        }  
      if (ngRoutingInfo.getSenderId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getSenderId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getSenderId());
        }  
      this.stringTemplate.opsForHash().put("ROUTING_INFO_TRANS_PROMO_DND_MAP", sb.toString(), Integer.toString(ngRoutingInfo.getGroupId().intValue()));
    } 
    return true;
  }
  
  public boolean loadRoutingInfoTransPromoNonDnd() {
    this.stringTemplate.opsForHash().getOperations().delete("ROUTING_INFO_TRANS_PROMO_NON_DND_MAP");
    Iterable<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoList = this.ngRoutingInfoTransPromoNonDndRepository.findAll();
    for (NgRoutingInfoTransPromoNonDnd ngRoutingInfo : ngRoutingInfoList) {
      StringBuffer sb = new StringBuffer();
      if (ngRoutingInfo.getUserId() != null)
        sb = sb.append(ngRoutingInfo.getUserId()); 
      if (ngRoutingInfo.getParentUserId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getParentUserId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getParentUserId());
        }  
      if (ngRoutingInfo.getCarrierId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCarrierId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCarrierId());
        }  
      if (ngRoutingInfo.getCircleId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getCircleId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getCircleId());
        }  
      if (ngRoutingInfo.getSenderId() != null)
        if (sb.length() == 0) {
          sb = sb.append(ngRoutingInfo.getSenderId());
        } else {
          sb = sb.append("#");
          sb = sb.append(ngRoutingInfo.getSenderId());
        }  
      this.stringTemplate.opsForHash().put("ROUTING_INFO_TRANS_PROMO_NON_DND_MAP", sb.toString(), Integer.toString(ngRoutingInfo.getGroupId().intValue()));
    } 
    return true;
  }
  
  public Integer getRoutingGroupForKeyForTrans(String key) {
    this.logger.info("Going to find group for key {} in map {}", key, "ROUTING_INFO_TRANS_MAP");
    if (this.stringTemplate.opsForHash().get("ROUTING_INFO_TRANS_MAP", key) != null) {
      Integer routingGroup = Integer.valueOf(Integer.parseInt((String)this.stringTemplate.opsForHash().get("ROUTING_INFO_TRANS_MAP", key)));
      return routingGroup;
    } 
    return null;
  }
  
  public Integer getRoutingGroupForKeyForPromo(String key) {
    if (this.stringTemplate.opsForHash().get("ROUTING_INFO_PROMO_MAP", key) != null) {
      Integer routingGroup = Integer.valueOf(Integer.parseInt((String)this.stringTemplate.opsForHash().get("ROUTING_INFO_PROMO_MAP", key)));
      return routingGroup;
    } 
    return null;
  }
  
  public Integer getRoutingGroupForKeyForTransPromoDnd(String key) {
    if (this.stringTemplate.opsForHash().get("ROUTING_INFO_TRANS_PROMO_DND_MAP", key) != null) {
      Integer routingGroup = Integer.valueOf(Integer.parseInt((String)this.stringTemplate.opsForHash().get("ROUTING_INFO_TRANS_PROMO_DND_MAP", key)));
      return routingGroup;
    } 
    return null;
  }
  
  public Integer getRoutingGroupForKeyForTransPromoNonDnd(String key) {
    if (this.stringTemplate.opsForHash().get("ROUTING_INFO_TRANS_PROMO_NON_DND_MAP", key) != null) {
      Integer routingGroup = Integer.valueOf(Integer.parseInt((String)this.stringTemplate.opsForHash().get("ROUTING_INFO_TRANS_PROMO_NON_DND_MAP", key)));
      return routingGroup;
    } 
    return null;
  }
  
  public String getCarrierCircleForSeries(String key) {
    if (this.stringTemplate.opsForHash().get("NUM_SERIES_DATA_MAP", key) != null) {
      String carrierCircleData = (String)this.stringTemplate.opsForHash().get("NUM_SERIES_DATA_MAP", key);
      return carrierCircleData;
    } 
    return "999#999";
  }
  
  public Set<Object> getAllRoutingTypes() {
    if (this.stringTemplate.opsForHash().keys("ROUTING_TYPE_MAP") != null) {
      Set<Object> routingTypes = this.stringTemplate.opsForHash().keys("ROUTING_TYPE_MAP");
      return routingTypes;
    } 
    return null;
  }
  
  public String getSubmitterQueueForGroupId(String groupId) {
    if (this.stringTemplate.opsForHash().keys("ROUTING_SUBMITTER_QUEUE_MAP") != null) {
      String submitterQueueName = (String)this.stringTemplate.opsForHash().get("ROUTING_SUBMITTER_QUEUE_MAP", groupId);
      return submitterQueueName;
    } 
    return null;
  }
  
  public boolean loadAllSenderId() {
    this.stringTemplate.opsForHash().getOperations().delete("SENDER_ID_MAP");
    Iterable<NgUserSenderIdMap> ngSenderIdList = this.senderIdMapRepository.findAll();
    for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
      String senderIdKey = ngUserSenderIdMap.getNgUser().getId() + "#" + ngUserSenderIdMap.getSenderId();
      String senderIdMapValue = Integer.toString(ngUserSenderIdMap.getId());
      this.stringTemplate.opsForHash().put("SENDER_ID_MAP", senderIdKey, senderIdMapValue);
    } 
    return true;
  }
  
  public boolean loadSpecificSenderIdForUser(int userId, String senderId) {
    NgUserSenderIdMap ngUserSenderIdMap = this.senderIdMapRepository.findBySenderIdAndUserId(senderId, userId);
    String senderIdKey = ngUserSenderIdMap.getNgUser().getId() + "#" + ngUserSenderIdMap.getSenderId();
    String senderIdMapValue = Integer.toString(ngUserSenderIdMap.getId());
    this.stringTemplate.opsForHash().put("SENDER_ID_MAP", senderIdKey, senderIdMapValue);
    return true;
  }
  
  public boolean loadAllEntityIdData() {
    this.stringTemplate.opsForHash().getOperations().delete("ENTITY_ID_MAP");
    Iterable<NgUserSenderIdMap> ngSenderIdList = this.senderIdMapRepository.findAll();
    for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
      if (ngUserSenderIdMap.getEntityId() != null) {
        String senderIdKey = ngUserSenderIdMap.getNgUser().getId() + "#" + ngUserSenderIdMap.getSenderId();
        String senderIdMapValue = ngUserSenderIdMap.getEntityId();
        this.stringTemplate.opsForHash().put("ENTITY_ID_MAP", senderIdKey, senderIdMapValue);
      } 
    } 
    return true;
  }
  
  public boolean loadAllShortCodeData() {
    this.stringTemplate.opsForHash().getOperations().delete("SHORT_CODE_MAP");
    Iterable<NgUserSenderIdMap> ngSenderIdList = this.senderIdMapRepository.findAll();
    for (NgUserSenderIdMap ngUserSenderIdMap : ngSenderIdList) {
      if (ngUserSenderIdMap.getEntityId() != null) {
        String senderIdKey = ngUserSenderIdMap.getNgUser().getId() + "#" + ngUserSenderIdMap.getSenderId();
        String senderIdMapValue = ngUserSenderIdMap.getEntityId();
        this.stringTemplate.opsForHash().put("SHORT_CODE_MAP", senderIdKey, senderIdMapValue);
      } 
    } 
    return true;
  }
  
  public boolean loadAllUserSenderIdTemplateData() {
    this.redisTemplateForContentTemplateList.opsForHash().getOperations().delete("USER_SENDER_ID_TEMPLATE_MAP_KEY");
    Iterable<NgContentTemplate> ngContentTemplateList = this.ngContentTemplateRepository.findByStatus('1');
    for (NgContentTemplate ngContentTemplate : ngContentTemplateList) {
      String contentTemplateMapKey = ngContentTemplate.getNgUser().getId() + "#" + ngContentTemplate.getSenderId();
      Set<String> contentTemplateListForSenderId = (Set<String>)this.redisTemplateForContentTemplateList.opsForHash().get("USER_SENDER_ID_TEMPLATE_MAP_KEY", contentTemplateMapKey);
      this.logger.info("Exisitng Content Template List : {}", contentTemplateListForSenderId);
      if (contentTemplateListForSenderId == null) {
        this.logger.info("Creating new  Content Template List for key: {}", contentTemplateMapKey);
        contentTemplateListForSenderId = new HashSet<>();
      } 
      String contentTemplateMapValue = ngContentTemplate.getTemplateText() + "!!~~!!" + ngContentTemplate.getDltTemplateId() + "!!~~!!" + ngContentTemplate.getNgServiceType().getDisplayCode();
      contentTemplateListForSenderId.add(contentTemplateMapValue);
      this.redisTemplateForContentTemplateList.opsForHash().put("USER_SENDER_ID_TEMPLATE_MAP_KEY", contentTemplateMapKey, contentTemplateListForSenderId);
    } 
    return true;
  }
  
  public boolean loadAllTemplateData() {
    this.redisTemplateForContentTemplateList.opsForHash().getOperations().delete("USER_SENDER_ID_TEMPLATE_MAP_KEY");
    Iterable<NgContentTemplate> ngContentTemplateList = this.ngContentTemplateRepository.findByStatus('1');
    for (NgContentTemplate ngContentTemplate : ngContentTemplateList) {
      String contentTemplateMapKey = ngContentTemplate.getNgUser().getId() + "#" + ngContentTemplate.getSenderId();
      Set<String> contentTemplateListForSenderId = (Set<String>)this.redisTemplateForContentTemplateList.opsForHash().get("USER_SENDER_ID_TEMPLATE_MAP_KEY", contentTemplateMapKey);
      this.logger.info("Exisitng Content Template List : {}", contentTemplateListForSenderId);
      if (contentTemplateListForSenderId == null) {
        this.logger.info("Creating new  Content Template List for key: {}", contentTemplateMapKey);
        contentTemplateListForSenderId = new HashSet<>();
      } 
      String templateText = ngContentTemplate.getTemplateText();
      if (templateText.contains(")"))
        templateText = templateText.replace(")", "\\)"); 
      if (templateText.contains("."))
        templateText = templateText.replace(".", "\\."); 
      if (templateText.contains("["))
        templateText = templateText.replace("[", "\\["); 
      if (templateText.contains("]"))
        templateText = templateText.replace("]", "\\]"); 
      if (templateText.contains("("))
        templateText = templateText.replace("(", "\\("); 
      if (templateText.contains("*"))
        templateText = templateText.replace("*", "\\*"); 
      if (templateText.contains("+"))
        templateText = templateText.replace("+", "\\+"); 
      if (templateText.contains("-"))
        templateText = templateText.replace("-", "\\-"); 
      if (templateText.contains("?"))
        templateText = templateText.replace("?", "\\?"); 
      if (templateText.contains("^"))
        templateText = templateText.replace("^", "\\^"); 
      if (templateText.contains("$"))
        templateText = templateText.replace("$", "\\$"); 
      if (templateText.contains("|"))
        templateText = templateText.replace("|", "\\|"); 
      String contentTemplateMapValue = templateText + "!!~~!!" + ngContentTemplate.getDltTemplateId() + "!!~~!!" + ngContentTemplate.getNgServiceType().getDisplayCode();
      contentTemplateListForSenderId.add(contentTemplateMapValue);
      this.redisTemplateForContentTemplateList.opsForHash().put("USER_SENDER_ID_TEMPLATE_MAP_KEY", contentTemplateMapKey, contentTemplateListForSenderId);
    } 
    return true;
  }
  
  public Integer getIdFromSenderId(String senderId) {
    Object id = this.stringTemplate.opsForHash().get("SENDER_ID_MAP", senderId);
    if (id != null) {
      Integer idOfSenderId = Integer.valueOf(Integer.parseInt((String)id));
      this.logger.info("Sender Id {} found in cache and its id is : {}", senderId, idOfSenderId);
      return idOfSenderId;
    } 
    this.logger.info("Sender Id {} not found in cache.", senderId);
    return null;
  }
  
  public String getEntityIdFromSenderId(String senderId) {
    Object id = this.stringTemplate.opsForHash().get("ENTITY_ID_MAP", senderId);
    if (id != null) {
      String entityId = (String)id;
      this.logger.info("Sender Id {} found in cache and its entity id is : {}", senderId, entityId);
      return entityId;
    } 
    this.logger.info("Sender Id {} not found in cache.", senderId);
    return null;
  }
  
  public String getShortCodeFromSenderId(String senderId) {
    Object id = this.stringTemplate.opsForHash().get("SHORT_CODE_MAP", senderId);
    if (id != null) {
      String shortCode = (String)id;
      this.logger.info("Sender Id {} found in cache and its short code is : {}", senderId, shortCode);
      return shortCode;
    } 
    this.logger.info("Sender Id {} not found in cache.", senderId);
    return null;
  }
  
  public Set<String> getTemplateTextListForUserAndSenderId(String userAndSenderIdKey) {
    if (this.redisTemplateForContentTemplateList.opsForHash().keys("USER_SENDER_ID_TEMPLATE_MAP_KEY") != null) {
      if (this.redisTemplateForContentTemplateList.opsForHash().get("USER_SENDER_ID_TEMPLATE_MAP_KEY", userAndSenderIdKey) != null) {
        Set<String> templateTextListForSenderId = (Set<String>)this.redisTemplateForContentTemplateList.opsForHash().get("USER_SENDER_ID_TEMPLATE_MAP_KEY", userAndSenderIdKey);
        this.logger.info("Template text List for user and sender id key {} is: {}", userAndSenderIdKey, templateTextListForSenderId);
        return templateTextListForSenderId;
      } 
      this.logger.info("Template text for user and sender id key {} is not found in cache.", userAndSenderIdKey);
      return null;
    } 
    this.logger.info("Template text for user and sender id key {} is not found in cache.", userAndSenderIdKey);
    return null;
  }
  
  public Map<String, Integer> getAllCircleData() {
    Iterable<NgCircleMaster> circleMasterList = this.ngCircleRepository.findAll();
    Map<String, Integer> circleDataMap = new HashMap<>();
    for (NgCircleMaster ngCircleMaster : circleMasterList)
      circleDataMap.put(ngCircleMaster.getCircleName(), Integer.valueOf(ngCircleMaster.getId())); 
    return circleDataMap;
  }
  
  public String getCircleNameById(int circleId) {
    NgCircleMaster ngCircleMaster = (NgCircleMaster)this.ngCircleRepository.findOne(Integer.valueOf(circleId));
    if (ngCircleMaster != null)
      return ngCircleMaster.getCircleName(); 
    return "";
  }
  
  public Map<String, Integer> getAllCarrierData() {
    Iterable<NgCarrierMaster> carrierMasterList = this.ngCarrierRepository.findAll();
    Map<String, Integer> carrierDataMap = new HashMap<>();
    for (NgCarrierMaster ngCarrierMaster : carrierMasterList)
      carrierDataMap.put(ngCarrierMaster.getCarrierName(), Integer.valueOf(ngCarrierMaster.getId())); 
    return carrierDataMap;
  }
  
  public String getCarrierNameById(int carrierId) {
    NgCarrierMaster ngCarrierMaster = (NgCarrierMaster)this.ngCarrierRepository.findOne(Integer.valueOf(carrierId));
    if (ngCarrierMaster != null)
      return ngCarrierMaster.getCarrierName(); 
    return "";
  }
  
  public List<NgRoutingGroupMaster> getRoutingGroupForUser(int userId) {
    List<NgRoutingGroupMaster> ngRoutingGroupList = this.ngRoutingGroupRepository.findByUserId(userId);
    return ngRoutingGroupList;
  }
  
  public NgRoutingGroupMaster getRoutingGroupForId(int id) {
    NgRoutingGroupMaster ngRoutingGroupList = this.ngRoutingGroupRepository.findById(id);
    return ngRoutingGroupList;
  }
  
  public NgRoutingGroupMaster saveGroupName(NgRoutingGroupMaster ngRoutingGroupMaster) {
    NgRoutingGroupMaster ngRoutingGroup = null;
    ngRoutingGroup = (NgRoutingGroupMaster)this.ngRoutingGroupRepository.save(ngRoutingGroupMaster);
    if (ngRoutingGroup != null)
      return ngRoutingGroup; 
    return ngRoutingGroup;
  }
  
  public boolean updateKannelGroupMappingForGroup(Integer groupId, String kannelIds, String kannelAllowedTps) {
    this.ngKannelGroupMappingRepository.delete(this.ngKannelGroupMappingRepository.findByGroupId(groupId));
    NgKannelGroupMapping ngKannelGroupMapping = new NgKannelGroupMapping();
    ngKannelGroupMapping.setGroupId(groupId.intValue());
    ngKannelGroupMapping.setKannelAllowedTps(kannelAllowedTps);
    ngKannelGroupMapping.setKannelId(kannelIds);
    NgKannelGroupMapping savedNgKannelGroupMapping = (NgKannelGroupMapping)this.ngKannelGroupMappingRepository.save(ngKannelGroupMapping);
    if (savedNgKannelGroupMapping != null)
      return true; 
    return false;
  }
  
  public List<UserRoutingData> getAllRoutingInfoForUser(int userId, String routingType) {
    List<UserRoutingData> userRoutingDataList = new ArrayList<>();
    if (routingType.equals("TRANS")) {
      List<NgRoutingInfoTrans> routingInfoTransList = this.ngRoutingInfoTransRepository.findByUserId(userId);
      for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList)
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(), ngRoutingInfoTrans
            .getSenderId(), ngRoutingInfoTrans.getGroupId(), "TRANS"); 
    } else if (routingType.equals("PROMO")) {
      List<NgRoutingInfoPromo> routingInfoPromoList = this.ngRoutingInfoPromoRepository.findByUserId(userId);
      for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
        this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { ngRoutingInfoPromo.getSenderId(), ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(), ngRoutingInfoPromo.getGroupId(), routingType });
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(), ngRoutingInfoPromo
            .getSenderId(), ngRoutingInfoPromo.getGroupId(), "PROMO");
      } 
    } else if (routingType.equals("TRANS_PROMO_DND")) {
      List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = this.ngRoutingInfoTransPromoDndRepository.findByUserId(userId);
      for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
        this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { ngRoutingInfoTransPromoDnd.getSenderId(), ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(), ngRoutingInfoTransPromoDnd.getGroupId(), routingType });
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(), ngRoutingInfoTransPromoDnd
            .getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(), "TRANS_PROMO_DND");
      } 
    } else if (routingType.equals("TRANS_PROMO_NON_DND")) {
      List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = this.ngRoutingInfoTransPromoNonDndRepository.findByUserId(userId);
      for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
        this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { ngRoutingInfoTransPromoNonDnd.getSenderId(), ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), routingType });
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(), ngRoutingInfoTransPromoNonDnd
            .getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), "TRANS_PROMO_NON_DND");
      } 
    } 
    return userRoutingDataList;
  }
  
  private void populateUserRoutingDataList(List<UserRoutingData> userRoutingDataList, Integer circleId, Integer carrierId, Integer idOfSenderId, Integer groupId, String routingType) {
    UserRoutingData userRoutingData = new UserRoutingData();
    this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { idOfSenderId, circleId, carrierId, groupId, routingType });
    if (carrierId != null && carrierId.intValue() > 0) {
      NgCarrierMaster ngCarrierMaster = (NgCarrierMaster)this.ngCarrierRepository.findOne(carrierId);
      userRoutingData.setOperator(ngCarrierMaster.getCarrierName());
    } else {
      userRoutingData.setOperator("All");
    } 
    if (circleId != null && circleId.intValue() > 0) {
      NgCircleMaster ngCircleMaster = (NgCircleMaster)this.ngCircleRepository.findOne(circleId);
      userRoutingData.setCircle(ngCircleMaster.getCircleName());
    } else {
      userRoutingData.setCircle("All");
    } 
    if (idOfSenderId != null && idOfSenderId.intValue() > 0) {
      NgUserSenderIdMap userSenderIdMap = this.userSenderIdMapRepository.findById(idOfSenderId.intValue());
      this.logger.info("userSenderIdMap Sender id {}", userSenderIdMap.getSenderId());
      if (userSenderIdMap != null) {
        userRoutingData.setSenderId(userSenderIdMap.getSenderId());
      } else {
        userRoutingData.setSenderId("All");
      } 
    } else {
      userRoutingData.setSenderId("All");
    } 
    NgRoutingGroupMaster ngRoutingGroupMaster = this.ngRoutingGroupRepository.findById(groupId.intValue());
    userRoutingData.setGroupName(ngRoutingGroupMaster.getGroupName());
    this.logger.info("Group Name  {}", ngRoutingGroupMaster.getGroupName());
    userRoutingDataList.add(userRoutingData);
    this.logger.info("userRoutingDataList {}", Integer.valueOf(userRoutingDataList.size()));
  }
  
  private void populateUserRoutingDataListForAllUser(List<UserRoutingDataForAllUser> userRoutingDataList, Integer circleId, Integer carrierId, Integer idOfSenderId, Integer groupId, int id, String routingType) {
    UserRoutingDataForAllUser userRoutingData = new UserRoutingDataForAllUser();
    this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { idOfSenderId, circleId, carrierId, groupId, routingType });
    if (carrierId != null && carrierId.intValue() > 0) {
      NgCarrierMaster ngCarrierMaster = (NgCarrierMaster)this.ngCarrierRepository.findOne(carrierId);
      userRoutingData.setOperator(ngCarrierMaster.getCarrierName());
    } else {
      userRoutingData.setOperator("All");
    } 
    if (circleId != null && circleId.intValue() > 0) {
      NgCircleMaster ngCircleMaster = (NgCircleMaster)this.ngCircleRepository.findOne(circleId);
      userRoutingData.setCircle(ngCircleMaster.getCircleName());
    } else {
      userRoutingData.setCircle("All");
    } 
    if (idOfSenderId != null && idOfSenderId.intValue() > 0) {
      NgUserSenderIdMap userSenderIdMap = this.userSenderIdMapRepository.findById(idOfSenderId.intValue());
      this.logger.info("userSenderIdMap Sender id {}", userSenderIdMap.getSenderId());
      if (userSenderIdMap != null) {
        userRoutingData.setSenderId(userSenderIdMap.getSenderId());
      } else {
        userRoutingData.setSenderId("All");
      } 
    } else {
      userRoutingData.setSenderId("All");
    } 
    NgRoutingGroupMaster ngRoutingGroupMaster = this.ngRoutingGroupRepository.findById(groupId.intValue());
    userRoutingData.setGroupName(ngRoutingGroupMaster.getGroupName());
    userRoutingData.setRoutingId(id);
    this.logger.info("Group Name  {}", ngRoutingGroupMaster.getGroupName());
    userRoutingDataList.add(userRoutingData);
    this.logger.info("userRoutingDataList {}", Integer.valueOf(userRoutingDataList.size()));
  }
  
  public List<UserRoutingData> getAllRoutingInfoForParent(int parentUserId, String routingType) {
    List<UserRoutingData> userRoutingDataList = new ArrayList<>();
    if (routingType.equals("TRANS")) {
      List<NgRoutingInfoTrans> routingInfoTransList = this.ngRoutingInfoTransRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList)
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(), ngRoutingInfoTrans
            .getSenderId(), ngRoutingInfoTrans.getGroupId(), "TRANS"); 
    } else if (routingType.equals("PROMO")) {
      List<NgRoutingInfoPromo> routingInfoPromoList = this.ngRoutingInfoPromoRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList)
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(), ngRoutingInfoPromo
            .getSenderId(), ngRoutingInfoPromo.getGroupId(), "PROMO"); 
    } else if (routingType.equals("TRANS_PROMO_DND")) {
      List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = this.ngRoutingInfoTransPromoDndRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList)
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(), ngRoutingInfoTransPromoDnd
            .getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(), "TRANS_PROMO_DND"); 
    } else if (routingType.equals("TRANS_PROMO_NON_DND")) {
      List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = this.ngRoutingInfoTransPromoNonDndRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList)
        populateUserRoutingDataList(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(), ngRoutingInfoTransPromoNonDnd
            .getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), "TRANS_PROMO_NON_DND"); 
    } 
    return userRoutingDataList;
  }
  
  public Integer getFailOverRoutingGroup(Integer groupId) {
    NgRoutingGroupMaster routingGroup = (NgRoutingGroupMaster)this.ngRoutingGroupRepository.findOne(groupId);
    if (routingGroup != null && routingGroup.getFailOverGroupId() != 0)
      return Integer.valueOf(routingGroup.getFailOverGroupId()); 
    return groupId;
  }
  
  public boolean updateTransRoutingInfoForUser(Integer clientId, String routingType, List<NgRoutingInfoTrans> ngRoutingInfoTransList) {
    List<NgRoutingInfoTrans> routingInfo = this.ngRoutingInfoTransRepository.findByUserId(clientId.intValue());
    this.logger.info("clientId {}, RoutingInfo {}", clientId, Integer.valueOf(routingInfo.size()));
    this.ngRoutingInfoTransRepository.delete(routingInfo);
    if (ngRoutingInfoTransList != null) {
      Iterable<NgRoutingInfoTrans> iterable = this.ngRoutingInfoTransRepository.save(ngRoutingInfoTransList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransRoutingInfoForParent(Integer parentId, String routingType, List<NgRoutingInfoTrans> ngRoutingInfoTransList) {
    List<NgRoutingInfoTrans> routingInfo = this.ngRoutingInfoTransRepository.findByParentUserId(parentId.intValue());
    this.logger.info("parentId {}, RoutingInfo {}", parentId, Integer.valueOf(routingInfo.size()));
    this.ngRoutingInfoTransRepository.delete(routingInfo);
    if (ngRoutingInfoTransList != null) {
      Iterable<NgRoutingInfoTrans> iterable = this.ngRoutingInfoTransRepository.save(ngRoutingInfoTransList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransRoutingInfoForId(String routingType, List<NgRoutingInfoTrans> ngRoutingInfoTransList) {
    if (ngRoutingInfoTransList != null) {
      Iterable<NgRoutingInfoTrans> iterable = this.ngRoutingInfoTransRepository.save(ngRoutingInfoTransList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updatePromoRoutingInfoForUser(Integer clientId, String routingType, List<NgRoutingInfoPromo> ngRoutingInfoPromoList) {
    List<NgRoutingInfoPromo> routingInfo = this.ngRoutingInfoPromoRepository.findByUserId(clientId.intValue());
    this.logger.info("clientId {}, RoutingInfo {}", clientId, Integer.valueOf(routingInfo.size()));
    this.ngRoutingInfoPromoRepository.delete(routingInfo);
    if (ngRoutingInfoPromoList != null) {
      Iterable<NgRoutingInfoPromo> iterable = this.ngRoutingInfoPromoRepository.save(ngRoutingInfoPromoList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updatePromoRoutingInfoForId(String routingType, List<NgRoutingInfoPromo> ngRoutingInfoPromoList) {
    if (ngRoutingInfoPromoList != null) {
      Iterable<NgRoutingInfoPromo> iterable = this.ngRoutingInfoPromoRepository.save(ngRoutingInfoPromoList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updatePromoRoutingInfoForParent(Integer parentId, String routingType, List<NgRoutingInfoPromo> ngRoutingInfoPromoList) {
    List<NgRoutingInfoPromo> routingInfo = ngRoutingInfoPromoRepository.findByParentUserId(parentId.intValue());
    this.logger.info("parentId {}, RoutingInfo {}", parentId, Integer.valueOf(routingInfo.size()));
    this.ngRoutingInfoPromoRepository.delete(routingInfo);
    if (ngRoutingInfoPromoList != null) {
      Iterable<NgRoutingInfoPromo> iterable = ngRoutingInfoPromoRepository.save(ngRoutingInfoPromoList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransPromoDndRoutingInfoForUser(Integer clientId, String routingType, List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList) {
    List<NgRoutingInfoTransPromoDnd> routingInfo = ngRoutingInfoTransPromoDndRepository.findByUserId(clientId.intValue());
      logger.info("clientId {}, RoutingInfo {}", clientId, Integer.valueOf(routingInfo.size()));
      ngRoutingInfoTransPromoDndRepository.delete(routingInfo);
    if (ngRoutingInfoTransPromoDndList != null) {
      Iterable<NgRoutingInfoTransPromoDnd> iterable = ngRoutingInfoTransPromoDndRepository.save(ngRoutingInfoTransPromoDndList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransPromoDndRoutingInfoForId(String routingType, List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList) {
    if (ngRoutingInfoTransPromoDndList != null) {
      Iterable<NgRoutingInfoTransPromoDnd> iterable = ngRoutingInfoTransPromoDndRepository.save(ngRoutingInfoTransPromoDndList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransPromoDndRoutingInfoForParent(Integer parentId, String routingType, List<NgRoutingInfoTransPromoDnd> ngRoutingInfoTransPromoDndList) {
    List<NgRoutingInfoTransPromoDnd> routingInfo = ngRoutingInfoTransPromoDndRepository.findByParentUserId(parentId.intValue());
         logger.info("parentId {}, RoutingInfo {}", parentId, Integer.valueOf(routingInfo.size()));
        ngRoutingInfoTransPromoDndRepository.delete(routingInfo);
    if (ngRoutingInfoTransPromoDndList != null) {
      Iterable<NgRoutingInfoTransPromoDnd> iterable = ngRoutingInfoTransPromoDndRepository.save(ngRoutingInfoTransPromoDndList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransPromoNonDndRoutingInfoForUser(Integer clientId, String routingType, List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList) {
    List<NgRoutingInfoTransPromoNonDnd> routingInfo = ngRoutingInfoTransPromoNonDndRepository.findByUserId(clientId.intValue());
        logger.info("clientId {}, RoutingInfo {}", clientId, Integer.valueOf(routingInfo.size()));
         ngRoutingInfoTransPromoNonDndRepository.delete(routingInfo);
    if (ngRoutingInfoTransPromoNonDndList != null) {
      Iterable<NgRoutingInfoTransPromoNonDnd> iterable =  ngRoutingInfoTransPromoNonDndRepository.save(ngRoutingInfoTransPromoNonDndList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransPromoNonDndRoutingInfoForId(String routingType, List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList) {
    if (ngRoutingInfoTransPromoNonDndList != null) {
      Iterable<NgRoutingInfoTransPromoNonDnd> iterable = ngRoutingInfoTransPromoNonDndRepository.save(ngRoutingInfoTransPromoNonDndList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public boolean updateTransPromoNonDndRoutingInfoForParent(Integer parentId, String routingType, List<NgRoutingInfoTransPromoNonDnd> ngRoutingInfoTransPromoNonDndList) {
    List<NgRoutingInfoTransPromoNonDnd> routingInfo = this.ngRoutingInfoTransPromoNonDndRepository.findByParentUserId(parentId.intValue());
    this.logger.info("parentId {}, RoutingInfo {}", parentId, Integer.valueOf(routingInfo.size()));
    this.ngRoutingInfoTransPromoNonDndRepository.delete(routingInfo);
    if (ngRoutingInfoTransPromoNonDndList != null) {
      Iterable<NgRoutingInfoTransPromoNonDnd> iterable = this.ngRoutingInfoTransPromoNonDndRepository.save(ngRoutingInfoTransPromoNonDndList);
      if (iterable != null) {
        loadSpecificRoutingInFoInCache(routingType);
        return true;
      } 
    } else {
      loadSpecificRoutingInFoInCache(routingType);
      return true;
    } 
    return false;
  }
  
  public Iterable<NgCarrierMaster> loadCarrierDataList() {
    Iterable<NgCarrierMaster> ngCarrierList = this.ngCarrierRepository.findAll();
    return ngCarrierList;
  }
  
  public Iterable<NgCircleMaster> loadCircleDataList() {
    Iterable<NgCircleMaster> ngCircleList = this.ngCircleRepository.findAll();
    return ngCircleList;
  }
  
  public List<NgRoutingInfoTrans> getUserDetailsFromTransByGroupId(int groupId) {
    List<NgRoutingInfoTrans> getUserDatails = this.ngRoutingInfoTransRepository.findByGroupId(groupId);
    return getUserDatails;
  }
  
  public List<NgRoutingInfoPromo> getUserDetailsFromPromoByGroupId(int groupId) {
    List<NgRoutingInfoPromo> getUserDatails = this.ngRoutingInfoPromoRepository.findByGroupId(groupId);
    return getUserDatails;
  }
  
  public List<NgRoutingInfoTransPromoDnd> getUserDetailsFromTransPromoDNDByGroupId(int groupId) {
    List<NgRoutingInfoTransPromoDnd> getUserDatails = this.ngRoutingInfoTransPromoDndRepository.findByGroupId(groupId);
    return getUserDatails;
  }
  
  public List<NgRoutingInfoTransPromoNonDnd> getUserDetailsFromTransPromoNonDNDByGroupId(int groupId) {
    List<NgRoutingInfoTransPromoNonDnd> getUserDatails = this.ngRoutingInfoTransPromoNonDndRepository.findByGroupId(groupId);
    return getUserDatails;
  }
  
  public NgRoutingInfoTrans getUserDetailsFromTransById(int id) {
    NgRoutingInfoTrans getUserDatails = this.ngRoutingInfoTransRepository.findById(id);
    return getUserDatails;
  }
  
  public NgRoutingInfoPromo getUserDetailsFromPromoById(int id) {
    NgRoutingInfoPromo getUserDatails = this.ngRoutingInfoPromoRepository.findById(id);
    return getUserDatails;
  }
  
  public NgRoutingInfoTransPromoDnd getUserDetailsFromTransPromoDNDById(int id) {
    NgRoutingInfoTransPromoDnd getUserDatails = this.ngRoutingInfoTransPromoDndRepository.findById(id);
    return getUserDatails;
  }
  
  public NgRoutingInfoTransPromoNonDnd getUserDetailsFromTransPromoNonDNDById(int id) {
    NgRoutingInfoTransPromoNonDnd getUserDatails = this.ngRoutingInfoTransPromoNonDndRepository.findById(id);
    return getUserDatails;
  }
  
  public List<UserRoutingDataForAllUser> getAllRoutingInfoForParentId(int parentUserId, String groupName, String routingType) {
    List<UserRoutingDataForAllUser> userRoutingDataList = new ArrayList<>();
    if (routingType.equals("TRANS")) {
      List<NgRoutingInfoTrans> routingInfoTransList = this.ngRoutingInfoTransRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoTrans.getGroupId())))
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(), ngRoutingInfoTrans
              .getSenderId(), ngRoutingInfoTrans.getGroupId(), ngRoutingInfoTrans.getId(), "TRANS"); 
      } 
    } else if (routingType.equals("PROMO")) {
      List<NgRoutingInfoPromo> routingInfoPromoList = this.ngRoutingInfoPromoRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoPromo.getGroupId())))
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(), ngRoutingInfoPromo
              .getSenderId(), ngRoutingInfoPromo.getGroupId(), ngRoutingInfoPromo.getId(), "PROMO"); 
      } 
    } else if (routingType.equals("TRANS_PROMO_DND")) {
      List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = this.ngRoutingInfoTransPromoDndRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoTransPromoDnd.getGroupId())))
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(), ngRoutingInfoTransPromoDnd
              .getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(), ngRoutingInfoTransPromoDnd.getId(), "TRANS_PROMO_DND"); 
      } 
    } else if (routingType.equals("TRANS_PROMO_NON_DND")) {
      List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = this.ngRoutingInfoTransPromoNonDndRepository.findByParentUserId(parentUserId);
      for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoTransPromoNonDnd.getGroupId())))
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(), ngRoutingInfoTransPromoNonDnd
              .getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), ngRoutingInfoTransPromoNonDnd.getId(), "TRANS_PROMO_NON_DND"); 
      } 
    } 
    return userRoutingDataList;
  }
  
  public List<UserRoutingDataForAllUser> getAllRoutingInfoForUserId(int userId, String groupName, String routingType) {
    List<UserRoutingDataForAllUser> userRoutingDataList = new ArrayList<>();
    if (routingType.equals("TRANS")) {
      List<NgRoutingInfoTrans> routingInfoTransList = this.ngRoutingInfoTransRepository.findByUserId(userId);
      for (NgRoutingInfoTrans ngRoutingInfoTrans : routingInfoTransList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoTrans.getGroupId())))
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTrans.getCircleId(), ngRoutingInfoTrans.getCarrierId(), ngRoutingInfoTrans
              .getSenderId(), ngRoutingInfoTrans.getGroupId(), ngRoutingInfoTrans.getId(), "TRANS"); 
      } 
    } else if (routingType.equals("PROMO")) {
      List<NgRoutingInfoPromo> routingInfoPromoList = this.ngRoutingInfoPromoRepository.findByUserId(userId);
      for (NgRoutingInfoPromo ngRoutingInfoPromo : routingInfoPromoList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoPromo.getGroupId()))) {
          this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { ngRoutingInfoPromo.getSenderId(), ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(), ngRoutingInfoPromo.getGroupId(), routingType });
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoPromo.getCircleId(), ngRoutingInfoPromo.getCarrierId(), ngRoutingInfoPromo
              .getSenderId(), ngRoutingInfoPromo.getGroupId(), ngRoutingInfoPromo.getId(), "PROMO");
        } 
      } 
    } else if (routingType.equals("TRANS_PROMO_DND")) {
      List<NgRoutingInfoTransPromoDnd> routingInfoTransPromoDndList = this.ngRoutingInfoTransPromoDndRepository.findByUserId(userId);
      for (NgRoutingInfoTransPromoDnd ngRoutingInfoTransPromoDnd : routingInfoTransPromoDndList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoTransPromoDnd.getGroupId()))) {
          this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { ngRoutingInfoTransPromoDnd.getSenderId(), ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(), ngRoutingInfoTransPromoDnd.getGroupId(), routingType });
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoDnd.getCircleId(), ngRoutingInfoTransPromoDnd.getCarrierId(), ngRoutingInfoTransPromoDnd
              .getSenderId(), ngRoutingInfoTransPromoDnd.getGroupId(), ngRoutingInfoTransPromoDnd.getId(), "TRANS_PROMO_DND");
        } 
      } 
    } else if (routingType.equals("TRANS_PROMO_NON_DND")) {
      List<NgRoutingInfoTransPromoNonDnd> routingInfoTransPromoNonDndList = this.ngRoutingInfoTransPromoNonDndRepository.findByUserId(userId);
      for (NgRoutingInfoTransPromoNonDnd ngRoutingInfoTransPromoNonDnd : routingInfoTransPromoNonDndList) {
        if (groupName.equalsIgnoreCase("all") || groupName.equals(String.valueOf(ngRoutingInfoTransPromoNonDnd.getGroupId()))) {
          this.logger.info("idOfSenderId {}, circleId {} , carrierId {} , groupId {} , routingType {}", new Object[] { ngRoutingInfoTransPromoNonDnd.getSenderId(), ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), routingType });
          populateUserRoutingDataListForAllUser(userRoutingDataList, ngRoutingInfoTransPromoNonDnd.getCircleId(), ngRoutingInfoTransPromoNonDnd.getCarrierId(), ngRoutingInfoTransPromoNonDnd
              .getSenderId(), ngRoutingInfoTransPromoNonDnd.getGroupId(), ngRoutingInfoTransPromoNonDnd.getId(), "TRANS_PROMO_NON_DND");
        } 
      } 
    } 
    return userRoutingDataList;
  }
  
  public void loadSpecificRoutingInFoInCache(String routingType) {
    if (routingType.equals("TRANS")) {
      loadRoutingInfoTrans();
    } else if (routingType.equals("PROMO")) {
      loadRoutingInfoPromo();
    } else if (routingType.equals("TRANS_PROMO_DND")) {
      loadRoutingInfoTransPromoDnd();
    } else if (routingType.equals("TRANS_PROMO_NON_DND")) {
      loadRoutingInfoTransPromoNonDnd();
    } 
  }
  
  public static void main(String[] args) {
    String senderId = "134#DALYRT";
    senderId = senderId.toLowerCase();
    System.out.println(senderId);
  }
}
