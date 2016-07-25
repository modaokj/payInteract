package com.softright.hibernate;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.connection.ConnectionProvider;

import com.alibaba.appengine.api.ds.DataSourceFactory;

public class DataSourceJuaeProvider implements ConnectionProvider {
	protected DataSource dataSource;
	private static final String DS_ALIAS = "juae.ds.alias";
  
	@Override
	public void configure(Properties paramProperties) throws HibernateException {
		// TODO Auto-generated method stub
		String alias = null;
		Iterator keys = paramProperties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			if (DS_ALIAS.equalsIgnoreCase(key)) {
				alias = paramProperties.getProperty(key);
			}
		}
		try {
            
			if(alias==null)
				dataSource = DataSourceFactory.getDataSource();
			else
				dataSource=DataSourceFactory.getDataSource(alias);
		} catch (Exception e) {
			throw new HibernateException(e);
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return dataSource.getConnection();

	}

	@Override
	public void closeConnection(Connection paramConnection) throws SQLException {
		// TODO Auto-generated method stub
		if (paramConnection != null && !paramConnection.isClosed())
			paramConnection.close();
	}

	@Override
	public void close() throws HibernateException {
		// TODO Auto-generated method stub
		if (dataSource != null)
			try {
				Method mClose = dataSource.getClass().getMethod("close", null);
				mClose.invoke(dataSource, null);
			} catch (Exception e) {
				throw new HibernateException(e);
			}
		dataSource = null;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
