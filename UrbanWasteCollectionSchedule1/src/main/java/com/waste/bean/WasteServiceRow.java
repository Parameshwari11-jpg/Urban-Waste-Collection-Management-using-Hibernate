package com.waste.bean;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WASTE_SERVICE_TBL")
public class WasteServiceRow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waste_seq_gen")
    @SequenceGenerator(name = "waste_seq_gen",
            sequenceName = "WASTE_SEQ",
            allocationSize = 1)
    @Column(name = "SERVICE_ROW_ID")
    private int serviceRowId;

    @Column(name = "CITIZEN_ID")
    private String citizenId;

    @Column(name = "SERVICE_TYPE")
    private String serviceType;

    @Column(name = "WARD_CODE")
    private String wardCode;

    @Column(name = "ROUTE_CODE")
    private String routeCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "SCHEDULED_DATE")
    private Date scheduledDate;

    @Column(name = "VEHICLE_NO")
    private String vehicleNo;

    @Column(name = "CREW_SHIFT")
    private String crewShift;

    @Temporal(TemporalType.DATE)
    @Column(name = "COMPLAINT_DATE")
    private Date complaintDate;

    @Column(name = "COMPLAINT_TYPE")
    private String complaintType;

    @Column(name = "COMPLAINT_DESCRIPTION")
    private String complaintDescription;

    @Column(name = "PRIORITY_LEVEL")
    private String priorityLevel;

    @Column(name = "COMPLAINT_STATUS")
    private String complaintStatus;

    @Column(name = "CLOSURE_REMARKS")
    private String closureRemarks;

	public int getServiceRowId() {
		return serviceRowId;
	}
	public void setServiceRowId(int serviceRowId) {
		this.serviceRowId = serviceRowId;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getWardCode() {
		return wardCode;
	}
	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public Date getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getCrewShift() {
		return crewShift;
	}
	public void setCrewShift(String crewShift) {
		this.crewShift = crewShift;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getComplaintDescription() {
		return complaintDescription;
	}
	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}
	public String getPriorityLevel() {
		return priorityLevel;
	}
	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	public String getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	public String getClosureRemarks() {
		return closureRemarks;
	}
	public void setClosureRemarks(String closureRemarks) {
		this.closureRemarks = closureRemarks;
	}
}
