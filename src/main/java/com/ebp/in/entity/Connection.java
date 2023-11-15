package com.ebp.in.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import com.ebp.in.enums.ConnectionStatus;
import com.ebp.in.enums.ConnectionType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Connection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long connectionId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long consumerNumber;

	@OneToOne(cascade = CascadeType.MERGE)
<<<<<<< HEAD
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable=true)
=======
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
>>>>>>> b423192b85408e1fe090b5a59aa16a47da93172b
	@JsonIgnore
	private Customer customerConnection;
	
	@Transient
<<<<<<< HEAD
	@Nullable
=======
>>>>>>> b423192b85408e1fe090b5a59aa16a47da93172b
	private Long userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address connectionAddress;

	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;

	private Date applicationDate;

	private Date connectionDate;

	@Enumerated(EnumType.STRING)
	private ConnectionStatus connectionStatus;

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public Customer getCustomerConnection() {
		return customerConnection;
	}

	public void setCustomerConnection(Customer customerConnection) {
		this.customerConnection = customerConnection;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Address getConnectionAddress() {
		return connectionAddress;
	}

	public void setConnectionAddress(Address connectionAddress) {
		this.connectionAddress = connectionAddress;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}

	public ConnectionStatus getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", consumerNumber=" + consumerNumber
				+ ", customerConnection=" + customerConnection + ", userId=" + userId + ", connectionAddress="
				+ connectionAddress + ", connectionType=" + connectionType + ", applicationDate=" + applicationDate
				+ ", connectionDate=" + connectionDate + ", connectionStatus=" + connectionStatus + "]";
	}

	public Connection(Long connectionId, Long consumerNumber, Customer customerConnection, Long userId,
			Address connectionAddress, ConnectionType connectionType, Date applicationDate, Date connectionDate,
			ConnectionStatus connectionStatus) {
		super();
		this.connectionId = connectionId;
		this.consumerNumber = consumerNumber;
		this.customerConnection = customerConnection;
		this.userId = userId;
		this.connectionAddress = connectionAddress;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}

	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}

	
<<<<<<< HEAD

	
=======
>>>>>>> b423192b85408e1fe090b5a59aa16a47da93172b
}
