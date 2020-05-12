package com.propertyfilereader;

import com.exceptionhandling.PropertyFileReaderExceptions;

public class PropertyFileReader {

	private static PropertyFileReader propertyfilereader = null;
	private static IPropertyInterface propertyreader = null;

	private PropertyFileReader() {
	}

	public static synchronized PropertyFileReader getInstance() {
		if (propertyfilereader == null) {
			propertyfilereader = new PropertyFileReader();
			return propertyfilereader;
		}
		return propertyfilereader;
	}

	public IPropertyInterface getPropertyReader() throws PropertyFileReaderExceptions {
		if (propertyreader == null) {
			propertyreader = new PropertyConfigReader();
			return propertyreader;
		}
		return propertyreader;
	}

}
