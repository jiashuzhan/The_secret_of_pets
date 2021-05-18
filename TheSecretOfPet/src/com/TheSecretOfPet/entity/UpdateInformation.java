package com.TheSecretOfPet.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 数据库更新信息实体类
 * @author Administrator
 *
 */
public class UpdateInformation implements Serializable{


	private static final long serialVersionUID = 7326368552806550996L;

	private String tableName;
	
	private Date updateTime;
	
	public UpdateInformation(){
		
	}

	public UpdateInformation(String tableName, Date updateTime) {
		this.tableName = tableName;
		this.updateTime = updateTime;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UpdateInformation [tableName=" + tableName + ", updateTime="
				+ updateTime + "]";
	}
	
	
}
