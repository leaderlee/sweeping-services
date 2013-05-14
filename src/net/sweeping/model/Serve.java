package net.sweeping.model;

import java.io.Serializable;

/**
 * 服务
 * @author hk
 *
 */
public class Serve implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6321388440194178732L;
	
	/**
	 *服务id 
	 */
	private int serveId;
	
	/**
	 * 服务名称
	 */
	private String serveName;
	
	/**
	 * 服务单价
	 */
	private int servePrice;

	public int getServeId() {
		return serveId;
	}

	public void setServeId(int serveId) {
		this.serveId = serveId;
	}

	public String getServeName() {
		return serveName;
	}

	public void setServeName(String serveName) {
		this.serveName = serveName;
	}

	public int getServePrice() {
		return servePrice;
	}

	public void setServePrice(int servePrice) {
		this.servePrice = servePrice;
	}
	
}
