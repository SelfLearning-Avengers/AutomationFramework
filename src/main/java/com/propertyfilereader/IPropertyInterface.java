package com.propertyfilereader;

import com.exceptionhandling.PropertyFileReaderExceptions;

public interface IPropertyInterface {

	public String getDriverPath() throws PropertyFileReaderExceptions;

	public String getApplicationUrl() throws PropertyFileReaderExceptions;

	public String getBrowser() throws PropertyFileReaderExceptions;

	public String getMCUserName() throws PropertyFileReaderExceptions;

	public String getMCPwd() throws PropertyFileReaderExceptions;

	public String getUploadFile() throws PropertyFileReaderExceptions;

}
