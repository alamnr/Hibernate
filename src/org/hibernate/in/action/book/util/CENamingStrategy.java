package org.hibernate.in.action.book.util;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.util.StringHelper;

public class CENamingStrategy extends ImprovedNamingStrategy {
	
	public String classToTableName(String className) {
		return StringHelper.unqualify(className);
	}

	public String propertyToColumnName(String propertyName) {
		return propertyName;
	}

	public String tableName(String tableName) {
		return "CE_" + tableName;
	}

	public String columnName(String columnName) {
		return columnName;
	}

	public String propertyToTableName(String className, String propertyName) {
		return "CE_" + classToTableName(className) + '_' + propertyToColumnName(propertyName);
	}
}
