package tech.alvaroemanuel.userscrud.resources.exceptions;

import java.io.Serializable;
import java.util.Date;

public class StandardError implements Serializable {

	private Date timestamp;
	private String error;
	private Integer status;
	private String message;
	private String path;
	
	private static final long serialVersionUID = 1L;

	public StandardError() {}
	
	public StandardError(Date timestamp, String error, Integer status, String message, String path) {
		this.timestamp = timestamp;
		this.error = error;
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setError(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
