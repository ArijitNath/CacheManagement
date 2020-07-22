package org.midas.analytics.simplecache.constants;

public interface ErrorCodes {
	String SUCCESS_CODE = "JWTERR_200";
	String SUCCESS_MESSAGE = "Success";
	
	String JWT_SAVE_ERROR_CODE = "JWTERR_101";
	String JWT_SAVE_ERROR_MESSAGE = "Error while saving jwt details to DB";
	
	String JWT_FETCH_ERROR_CODE = "JWTERR_102";
	String JWT_FETCH_ERROR_MESSAGE = "Error while fetching jwt details from DB.";
			
	String JWT_DEACTIVATE_ERROR_CODE = "JWTERR_103";		
	String JWT_DEACTIVATE_ERROR_MESSAGE = "Error while deactivating jwt in DB.";
	
	String JWT_INACTIVE_ERROR_CODE = "JWTERR_104";
	String JWT_INACTIVE_ERROR_MESSAGE = "The JWT requested is inactive!";
}
