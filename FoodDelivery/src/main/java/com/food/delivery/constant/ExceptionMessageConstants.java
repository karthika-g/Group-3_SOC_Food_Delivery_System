package com.food.delivery.constant;

/**
 * @author z003yz0d Akshay Sahu
 */

public class ExceptionMessageConstants {


    private ExceptionMessageConstants() {
    }
    public static final String TYPE_MISMATCH = "Value provided for the param is either incorrect datatype or empty";
    public static final String MESSAGE_BODY_NOT_READABLE = "Method Body NotReadable";
    public static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION = "Method Argument NotValid";
    public static final String AUTHORIZATION_SERVICE_UNAVAILABLE = "Could not authorize your request. Please try again after some time";
    public static final String NO_FEATURE_AUTHORIZATION = "No Authorization to perform this operation";
    public static final String UNKNOWN_ERROR = "Something went wrong, please check the logs for details";
    public static final String UNABLE_TO_PROCESS_REQUEST = "Server was unable to process request. Request Parameter missing or invalid";
    public static final String GROUP_SERVICE_UNAVAILABLE = "Could not validate permissions for this operations. Please try again after some time";
    public static final String INVALID_OR_MISSING_TOKEN = "Could not authorize your request make sure valid token is provided";
    public static final String ERROR_IN_TOKEN_PARSING = "Error occurred during token parsing";
    public static final String MISSING_TOKEN = "Please provide token with the request";
    public static final String INVALID_EQUIPMENT = "Invalid Equipment Id";
    public static final String NULL_EQUIPMENT_NAME = "Equipment Name cannot be null";
    public static final String EMPTY_EQUIPMENT_NAME = "Equipment Name cannot be blank";
    public static final String NULL_MAC_ADDRESS = "MacAddress cannot be null";
    public static final String EMPTY_MAC_ADDRESS = "MacAddress cannot be blank";
    public static final String INVALID_GROUP_ID = "Group Id cannot be blank or null";
    public static final String INVALID_BASIC_ID = "Invalid Basic Config Id";
    public static final String INVALID_EQUIPMENT_ID = "Equipment Id cannot be blank or null";
    public static final String INVALID_EQUIPMENT_MAC_COMBINATION = "Invalid equipment id and macAddress combination ";
    public static final String INVALID_MAC_ADDRESS = "Invalid Mac Address";

    public static final String REGISTER_BEFORE_FUTHER_PING = "Router needs to be registered before further pings.";
    public static final String ERR_DIAGNOSIS_GASES_LATEST_VALUE_NOT_FOUND = "Diagnosis gases latest value not found";
    public static final String ERR_DIAGNOSIS_GASES_NOT_CONFIGURED = "Diagnosis gases not configured";
    public static final String INVALID_EQUIPMENT_TYPE_ID = "Invalid equipment type id";
    public static final String ALREADY_REGISTERED_MAC_ADDRESS = "MacAddress already registered";
    public static final String CONFIG_NOT_FOUND = "No configuration found for given equipment type id";
    public static final String INVALID_ROUTER_OR_APPLICATION = "Invalid router type or application name";
    public static final String INVALID_ROUTER_TYPE = "router type cannot be blank or null";
    public static final String NO_SIGNAL_CONFIGURED_FOR_EQUIPMENT = "No Signals are configured for given Equipment Id :";
    public static final String ERROR_IN_CRL_SERVICE = "Could not revoke certificate, please try again later";
    public static final String INVALID_CERTIFICATE_NUMBER = "Valid certificate number not found";
    public static final String AT_LEAST_ONE_VALID_ROUTER_TYPE = "Please give at least one valid router type";
    public static final String INVALID_ALARM_RULES_CONFIGURATION = "Invalid Alarm Rules configuration";
    public static final String DUPLICATE_SIGNAL_ID = "Duplicate Signal Id";
    public static final String NO_GIVEN_SIGNAL_ID_CONFIGURED_FOR_EQUIPMENT = "None of the given singal Ids are configured for given equipment Id : ";
    public static final String INVALID_EQUIPMENT_OR_MAC = "Invalid equipmentId or macAddress";
    public static final String NOT_FOUND_EQUIPMENT = "Equipment not found with given id or macAddress";
    public static final String NO_GIVEN_ALARM_RULE_ID_CONFIGURED_FOR_EQUIPMENT = "None of the given alarm rule Ids are configured for given equipment Id : ";
    public static final String DUPLICATE_OR_MISSING_ALARM_RULE_ID = "Duplicate or Missing alarm rule Id";
    public static final String INVALID_SIGNAL_ID = "Invalid Signal Id";
    public static final String INVALID_ALARM_RULE_ID = "Invalid Alarm Rule Id";
    public static final String NULL_ALARM_DATA = "Alarm Data cannot be null";
    public static final String INVALID_SIGNAL_ACTION = "Allowed actions are add, update or delete only for signal label ";
    public static final String SIGNAL_NOT_FOUND = "signal is not available which is send as update action for signal label : ";
    public static final String CHANNEL_NOT_FOUND = "Invalid channel id in request signals for sensor label ";
    public static final String FORMULA_NOT_FOUND = "Invalid channel id in request signals for sensor label ";
    public static final String SIGNAL_ID_ALREADY_PRESENT = "Generated Signal id is already available for other signal";
    public static final String UNKNOWN_ROUTER_TYPE = "Router type does not exist";
    public static final String INVALID_FIRMWARE = "Invalid Firmware Id";
    public static final String FIRMWARE_FILE_MISSING = "Firmware file is missing";
    public static final String FIRMWARE_FILE_TYPE_NOT_SUPPORTED = "File type not supported";
    public static final String INCORRECT_FILE_NAME_FORMAT = "File name is not in correct format";
    public static final String INVALID_FIRMWARE_ID = "FirmwareId doesn't exist";
    public static final String INVALID_REQUEST_PARAMS = "Request parameter(s) either missing or null";
    public static final String INVALID_EQUIPMENT_TYPE_MAC_COMBINATION = "Invalid equipment type id and macAddress combination ";
    public static final String UNKNOWN_ERROR_FILE_STORAGE_ADAPTER= "Something went wrong while uploading the file, please check the logs for details" ;
    public static final String DEACTIVATED_DEVICE= "Device is deactivated";
    public static final String INVALID_NO_OF_RETRIES= "Number of retries must be integer and greater then 1!";
    public static final String INVALID_RETRY_INTERVAL= "Retry interval must be integer and greater then 0!";
    public static final String TOKEN_NOT_FOUND = "Token not found!";
    public static final String TOKEN_USED_OR_EXPIRED = "Token is used, expired or type is different!";
    public static final String UPLOAD_CONFIG_BEFORE_FUTURE_LOGIN = "Please upload your configuration before future login!";
    public static final String MAC_DEACTIVATED_LOGIN_NOT_ALLOWED = "Mac Address is deactivated. Login not allowed!!";
    public static final String FILE_DOES_NOT_EXISTS = "File does not exists : ";
    public static final String FIRMWARE_BUCKET_NOT_FOUND = "Firmware bucket not found";
    public static final String INVALID_FILE_NAME = "Invalid file name";
    public static final String MAC_DEACTIVATED_NO_OPERATION_ALLOWED = "Mac Address is deactivated. Operation not allowed!!";
    public static final String INVALID_CATEGORY_ID = "Invalid Category Id";
    public static final String INVALID_MEDIUM_ID = "Invalid Medium Id";
    public static final String INVALID_NOTIFICATION_DATA = "Invalid Notification Data";
    public static final String NOTIFICATION_ALREADY_EXISTS = "Notification details already exists for EquipmentId : ";
    public static final String NOTIFICATION_NOT_FOUND = "No notification found for given EquipmentId : ";
    public static final String NOTIFICATION_SAVED = "Notification Saved Successfully.";
    public static final String NOTIFICATION_UPDATED = "Notification Updated Successfully.";
    public static final String NOTIFICATION_DELETED = "Notification Deleted Successfully.";
    public static final String INVALID_CATEGORY_AND_MEDIUM_COMBINATION = "Invalid Category and Medium Id combination : ";

}
