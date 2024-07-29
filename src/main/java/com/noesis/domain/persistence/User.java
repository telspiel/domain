package com.noesis.domain.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;

	
	//@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@Id
	String accid;
	
	@Column(nullable=false)
	String password;
	
	String created_date;
	String expiry_date;
	int status;
	String bill_type;
	int multiple_senderid;
	int dynamic_senderid;
	String senderid;
	int intl_delivery;
	int landline_delivery;
	int client_encrypt;
	int db_encrypt;
	String encrypt_algm;
	String encrypt_key;
	int is_http;
	int is_https;
	int is_priority;
	String split_algm;
	int is_advt_footer;
	String advt_footer_msg;
	int is_dnd_check;
	int is_dlr_req;
	int is_dlr_post;
	int dlr_type;
	String dlr_url;
	String dlr_url_resp;
	int is_dlr_store;
	String dlr_protocol;
	int dlr_internal_route;
	int is_blockout;
	String blockout_start;
	String blockout_end;
	int is_email_delivery;
	String email_sender_id;
	String email_subject;
	int delv_ts_adjust;
	int dlr_client_q;
	int msgclass;
	int servicetype;
	int reportid;
	String httpdn_handover_ts_format;
	int is_blacklist;
	int is_schedule;
	int is_msg_filter;
	String actual_bill_type;
	int is_trai_bo_reject;
	String promo_senderid;
	String intl_senderid;
	char is_dlr_retry;
	int is_concat_16bit;
	int dupcheck;
	int is_dnd_delivery;
	int product;
	int is_storefront;
	String newline_char;
	int is_dnd_check_api;
	int lastts_adjust;
	String email_protocol;
	int is_concat_template_check;
	int is_optin;
	int is_bulk_allowed;
	int prioritylevel;
	int rep_id;
	int expiry_sec;

	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public int getMultiple_senderid() {
		return multiple_senderid;
	}

	public void setMultiple_senderid(int multiple_senderid) {
		this.multiple_senderid = multiple_senderid;
	}

	public int getDynamic_senderid() {
		return dynamic_senderid;
	}

	public void setDynamic_senderid(int dynamic_senderid) {
		this.dynamic_senderid = dynamic_senderid;
	}

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public int getIntl_delivery() {
		return intl_delivery;
	}

	public void setIntl_delivery(int intl_delivery) {
		this.intl_delivery = intl_delivery;
	}

	public int getLandline_delivery() {
		return landline_delivery;
	}

	public void setLandline_delivery(int landline_delivery) {
		this.landline_delivery = landline_delivery;
	}

	public int getClient_encrypt() {
		return client_encrypt;
	}

	public void setClient_encrypt(int client_encrypt) {
		this.client_encrypt = client_encrypt;
	}

	public int getDb_encrypt() {
		return db_encrypt;
	}

	public void setDb_encrypt(int db_encrypt) {
		this.db_encrypt = db_encrypt;
	}

	public String getEncrypt_algm() {
		return encrypt_algm;
	}

	public void setEncrypt_algm(String encrypt_algm) {
		this.encrypt_algm = encrypt_algm;
	}

	public String getEncrypt_key() {
		return encrypt_key;
	}

	public void setEncrypt_key(String encrypt_key) {
		this.encrypt_key = encrypt_key;
	}

	public int getIs_http() {
		return is_http;
	}

	public void setIs_http(int is_http) {
		this.is_http = is_http;
	}

	public int getIs_https() {
		return is_https;
	}

	public void setIs_https(int is_https) {
		this.is_https = is_https;
	}

	public int getIs_priority() {
		return is_priority;
	}

	public void setIs_priority(int is_priority) {
		this.is_priority = is_priority;
	}

	public String getSplit_algm() {
		return split_algm;
	}

	public void setSplit_algm(String split_algm) {
		this.split_algm = split_algm;
	}

	public int getIs_advt_footer() {
		return is_advt_footer;
	}

	public void setIs_advt_footer(int is_advt_footer) {
		this.is_advt_footer = is_advt_footer;
	}

	public String getAdvt_footer_msg() {
		return advt_footer_msg;
	}

	public void setAdvt_footer_msg(String advt_footer_msg) {
		this.advt_footer_msg = advt_footer_msg;
	}

	public int getIs_dnd_check() {
		return is_dnd_check;
	}

	public void setIs_dnd_check(int is_dnd_check) {
		this.is_dnd_check = is_dnd_check;
	}

	public int getIs_dlr_req() {
		return is_dlr_req;
	}

	public void setIs_dlr_req(int is_dlr_req) {
		this.is_dlr_req = is_dlr_req;
	}

	public int getIs_dlr_post() {
		return is_dlr_post;
	}

	public void setIs_dlr_post(int is_dlr_post) {
		this.is_dlr_post = is_dlr_post;
	}

	public int getDlr_type() {
		return dlr_type;
	}

	public void setDlr_type(int dlr_type) {
		this.dlr_type = dlr_type;
	}

	public String getDlr_url() {
		return dlr_url;
	}

	public void setDlr_url(String dlr_url) {
		this.dlr_url = dlr_url;
	}

	public String getDlr_url_resp() {
		return dlr_url_resp;
	}

	public void setDlr_url_resp(String dlr_url_resp) {
		this.dlr_url_resp = dlr_url_resp;
	}

	public int getIs_dlr_store() {
		return is_dlr_store;
	}

	public void setIs_dlr_store(int is_dlr_store) {
		this.is_dlr_store = is_dlr_store;
	}

	public String getDlr_protocol() {
		return dlr_protocol;
	}

	public void setDlr_protocol(String dlr_protocol) {
		this.dlr_protocol = dlr_protocol;
	}

	public int getDlr_internal_route() {
		return dlr_internal_route;
	}

	public void setDlr_internal_route(int dlr_internal_route) {
		this.dlr_internal_route = dlr_internal_route;
	}

	public int getIs_blockout() {
		return is_blockout;
	}

	public void setIs_blockout(int is_blockout) {
		this.is_blockout = is_blockout;
	}

	public String getBlockout_start() {
		return blockout_start;
	}

	public void setBlockout_start(String blockout_start) {
		this.blockout_start = blockout_start;
	}

	public String getBlockout_end() {
		return blockout_end;
	}

	public void setBlockout_end(String blockout_end) {
		this.blockout_end = blockout_end;
	}

	public int getIs_email_delivery() {
		return is_email_delivery;
	}

	public void setIs_email_delivery(int is_email_delivery) {
		this.is_email_delivery = is_email_delivery;
	}

	public String getEmail_sender_id() {
		return email_sender_id;
	}

	public void setEmail_sender_id(String email_sender_id) {
		this.email_sender_id = email_sender_id;
	}

	public String getEmail_subject() {
		return email_subject;
	}

	public void setEmail_subject(String email_subject) {
		this.email_subject = email_subject;
	}

	public int getDelv_ts_adjust() {
		return delv_ts_adjust;
	}

	public void setDelv_ts_adjust(int delv_ts_adjust) {
		this.delv_ts_adjust = delv_ts_adjust;
	}

	public int getDlr_client_q() {
		return dlr_client_q;
	}

	public void setDlr_client_q(int dlr_client_q) {
		this.dlr_client_q = dlr_client_q;
	}

	public int getMsgclass() {
		return msgclass;
	}

	public void setMsgclass(int msgclass) {
		this.msgclass = msgclass;
	}

	public int getServicetype() {
		return servicetype;
	}

	public void setServicetype(int servicetype) {
		this.servicetype = servicetype;
	}

	public int getReportid() {
		return reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public String getHttpdn_handover_ts_format() {
		return httpdn_handover_ts_format;
	}

	public void setHttpdn_handover_ts_format(String httpdn_handover_ts_format) {
		this.httpdn_handover_ts_format = httpdn_handover_ts_format;
	}

	public int getIs_blacklist() {
		return is_blacklist;
	}

	public void setIs_blacklist(int is_blacklist) {
		this.is_blacklist = is_blacklist;
	}

	public int getIs_schedule() {
		return is_schedule;
	}

	public void setIs_schedule(int is_schedule) {
		this.is_schedule = is_schedule;
	}

	public int getIs_msg_filter() {
		return is_msg_filter;
	}

	public void setIs_msg_filter(int is_msg_filter) {
		this.is_msg_filter = is_msg_filter;
	}

	public String getActual_bill_type() {
		return actual_bill_type;
	}

	public void setActual_bill_type(String actual_bill_type) {
		this.actual_bill_type = actual_bill_type;
	}

	public int getIs_trai_bo_reject() {
		return is_trai_bo_reject;
	}

	public void setIs_trai_bo_reject(int is_trai_bo_reject) {
		this.is_trai_bo_reject = is_trai_bo_reject;
	}

	public String getPromo_senderid() {
		return promo_senderid;
	}

	public void setPromo_senderid(String promo_senderid) {
		this.promo_senderid = promo_senderid;
	}

	public String getIntl_senderid() {
		return intl_senderid;
	}

	public void setIntl_senderid(String intl_senderid) {
		this.intl_senderid = intl_senderid;
	}

	public char getIs_dlr_retry() {
		return is_dlr_retry;
	}

	public void setIs_dlr_retry(char is_dlr_retry) {
		this.is_dlr_retry = is_dlr_retry;
	}

	public int getIs_concat_16bit() {
		return is_concat_16bit;
	}

	public void setIs_concat_16bit(int is_concat_16bit) {
		this.is_concat_16bit = is_concat_16bit;
	}

	public int getDupcheck() {
		return dupcheck;
	}

	public void setDupcheck(int dupcheck) {
		this.dupcheck = dupcheck;
	}

	public int getIs_dnd_delivery() {
		return is_dnd_delivery;
	}

	public void setIs_dnd_delivery(int is_dnd_delivery) {
		this.is_dnd_delivery = is_dnd_delivery;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getIs_storefront() {
		return is_storefront;
	}

	public void setIs_storefront(int is_storefront) {
		this.is_storefront = is_storefront;
	}

	public String getNewline_char() {
		return newline_char;
	}

	public void setNewline_char(String newline_char) {
		this.newline_char = newline_char;
	}

	public int getIs_dnd_check_api() {
		return is_dnd_check_api;
	}

	public void setIs_dnd_check_api(int is_dnd_check_api) {
		this.is_dnd_check_api = is_dnd_check_api;
	}

	public int getLastts_adjust() {
		return lastts_adjust;
	}

	public void setLastts_adjust(int lastts_adjust) {
		this.lastts_adjust = lastts_adjust;
	}

	public String getEmail_protocol() {
		return email_protocol;
	}

	public void setEmail_protocol(String email_protocol) {
		this.email_protocol = email_protocol;
	}

	public int getIs_concat_template_check() {
		return is_concat_template_check;
	}

	public void setIs_concat_template_check(int is_concat_template_check) {
		this.is_concat_template_check = is_concat_template_check;
	}

	public int getIs_optin() {
		return is_optin;
	}

	public void setIs_optin(int is_optin) {
		this.is_optin = is_optin;
	}

	public int getIs_bulk_allowed() {
		return is_bulk_allowed;
	}

	public void setIs_bulk_allowed(int is_bulk_allowed) {
		this.is_bulk_allowed = is_bulk_allowed;
	}

	public int getPrioritylevel() {
		return prioritylevel;
	}

	public void setPrioritylevel(int prioritylevel) {
		this.prioritylevel = prioritylevel;
	}

	public int getRep_id() {
		return rep_id;
	}

	public void setRep_id(int rep_id) {
		this.rep_id = rep_id;
	}

	public int getExpiry_sec() {
		return expiry_sec;
	}

	public void setExpiry_sec(int expiry_sec) {
		this.expiry_sec = expiry_sec;
	}

	@Override
	public String toString() {
		return "User [accid=" + accid + ", password=" + password + ", created_date=" + created_date + ", expiry_date="
				+ expiry_date + ", status=" + status + ", bill_type=" + bill_type + ", multiple_senderid="
				+ multiple_senderid + ", dynamic_senderid=" + dynamic_senderid + ", senderid=" + senderid
				+ ", intl_delivery=" + intl_delivery + ", landline_delivery=" + landline_delivery + ", client_encrypt="
				+ client_encrypt + ", db_encrypt=" + db_encrypt + ", encrypt_algm=" + encrypt_algm + ", encrypt_key="
				+ encrypt_key + ", is_http=" + is_http + ", is_https=" + is_https + ", is_priority=" + is_priority
				+ ", split_algm=" + split_algm + ", is_advt_footer=" + is_advt_footer + ", advt_footer_msg="
				+ advt_footer_msg + ", is_dnd_check=" + is_dnd_check + ", is_dlr_req=" + is_dlr_req + ", is_dlr_post="
				+ is_dlr_post + ", dlr_type=" + dlr_type + ", dlr_url=" + dlr_url + ", dlr_url_resp=" + dlr_url_resp
				+ ", is_dlr_store=" + is_dlr_store + ", dlr_protocol=" + dlr_protocol + ", dlr_internal_route="
				+ dlr_internal_route + ", is_blockout=" + is_blockout + ", blockout_start=" + blockout_start
				+ ", blockout_end=" + blockout_end + ", is_email_delivery=" + is_email_delivery + ", email_sender_id="
				+ email_sender_id + ", email_subject=" + email_subject + ", delv_ts_adjust=" + delv_ts_adjust
				+ ", dlr_client_q=" + dlr_client_q + ", msgclass=" + msgclass + ", servicetype=" + servicetype
				+ ", reportid=" + reportid + ", httpdn_handover_ts_format=" + httpdn_handover_ts_format
				+ ", is_blacklist=" + is_blacklist + ", is_schedule=" + is_schedule + ", is_msg_filter=" + is_msg_filter
				+ ", actual_bill_type=" + actual_bill_type + ", is_trai_bo_reject=" + is_trai_bo_reject
				+ ", promo_senderid=" + promo_senderid + ", intl_senderid=" + intl_senderid + ", is_dlr_retry="
				+ is_dlr_retry + ", is_concat_16bit=" + is_concat_16bit + ", dupcheck=" + dupcheck
				+ ", is_dnd_delivery=" + is_dnd_delivery + ", product=" + product + ", is_storefront=" + is_storefront
				+ ", newline_char=" + newline_char + ", is_dnd_check_api=" + is_dnd_check_api + ", lastts_adjust="
				+ lastts_adjust + ", email_protocol=" + email_protocol + ", is_concat_template_check="
				+ is_concat_template_check + ", is_optin=" + is_optin + ", is_bulk_allowed=" + is_bulk_allowed
				+ ", prioritylevel=" + prioritylevel + ", rep_id=" + rep_id + ", expiry_sec=" + expiry_sec + "]";
	}



}