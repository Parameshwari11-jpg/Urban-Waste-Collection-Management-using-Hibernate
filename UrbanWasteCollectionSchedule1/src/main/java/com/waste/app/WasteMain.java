package com.waste.app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.waste.bean.Citizen;
import com.waste.bean.WasteServiceRow;
import com.waste.service.WasteService;
import com.waste.util.ActiveComplaintsExistException;
import com.waste.util.ComplaintStatusException;
import com.waste.util.ValidationException;

public class WasteMain {

    private static WasteService service = new WasteService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n===== URBAN WASTE COLLECTION SYSTEM =====");
                System.out.println("1. Register Citizen");
                System.out.println("2. View All Citizens");
                System.out.println("3. Log Scheduled Visit");
                System.out.println("4. Register Complaint");
                System.out.println("5. Update Complaint Status");
                System.out.println("6. List Complaints by Citizen");
                System.out.println("7. Deactivate Citizen");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        registerCitizen();
                        break;

                    case 2:
                        viewAllCitizens();
                        break;

                    case 3:
                        logScheduledVisit();
                        break;

                    case 4:
                        registerComplaint();
                        break;

                    case 5:
                        updateComplaintStatus();
                        break;

                    case 6:
                        listComplaints();
                        break;

                    case 7:
                        deactivateCitizen();
                        break;

                    case 8:
                        System.out.println("Exiting system...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }
    private static void registerCitizen() {

        Citizen c = new Citizen();

        System.out.print("Citizen ID: ");
        c.setCitizenID(sc.nextLine());

        System.out.print("Full Name: ");
        c.setFullName(sc.nextLine());

        System.out.print("House/Building No: ");
        c.setHouseOrBuildingName(sc.nextLine());

        System.out.print("Street Name: ");
        c.setStreetName(sc.nextLine());

        System.out.print("Area: ");
        c.setAreaOrLocality(sc.nextLine());

        System.out.print("Ward Code: ");
        c.setWardCode(sc.nextLine());

        System.out.print("Route Code: ");
        c.setRouteCode(sc.nextLine());

        System.out.print("Mobile: ");
        c.setMobile(sc.nextLine());

        System.out.print("Email: ");
        c.setEmail(sc.nextLine());

        boolean result = service.registerNewCitizen(c);

        if (result)
            System.out.println("Citizen Registered Successfully.");
        else
            System.out.println("Failed to Register Citizen.");
    }
    private static void viewAllCitizens() {

        List<Citizen> list = service.viewAllCitizens();

        if (list == null || list.isEmpty()) {
            System.out.println("No citizens found.");
            return;
        }

        for (Citizen c : list) {
            System.out.println("--------------------------------");
            System.out.println("ID: " + c.getCitizenID());
            System.out.println("Name: " + c.getFullName());
            System.out.println("Ward: " + c.getWardCode());
            System.out.println("Route: " + c.getRouteCode());
            System.out.println("Status: " + c.getStatus());
        }
    }
    private static void logScheduledVisit() {

        System.out.print("Ward Code: ");
        String ward = sc.nextLine();

        System.out.print("Route Code: ");
        String route = sc.nextLine();

        System.out.print("Vehicle No: ");
        String vehicle = sc.nextLine();

        System.out.print("Crew Shift: ");
        String shift = sc.nextLine();

        Date today = new Date();

        boolean result = service.logScheduledVisit(
                ward, route, today, vehicle, shift);

        if (result)
            System.out.println("Scheduled Visit Logged.");
        else
            System.out.println("Failed to log scheduled visit.");
    }
    private static void registerComplaint() {

        System.out.print("Citizen ID: ");
        String id = sc.nextLine();

        System.out.print("Complaint Type: ");
        String type = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Priority (LOW/MEDIUM/HIGH): ");
        String priority = sc.nextLine();

        Date today = new Date();

        boolean result = service.registerComplaint(
                id, type, desc, priority, today, null);

        if (result)
            System.out.println("Complaint Registered Successfully.");
        else
            System.out.println("Failed to register complaint.");
    }
    private static void updateComplaintStatus() {

        System.out.print("Service Row ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("New Status (OPEN/IN_PROGRESS/RESOLVED/CLOSED): ");
        String status = sc.nextLine();

        System.out.print("Closure Remarks: ");
        String remarks = sc.nextLine();

        boolean result =
                service.updateComplaintStatus(id, status, remarks);

        if (result)
            System.out.println("Complaint Updated Successfully.");
        else
            System.out.println("Failed to update complaint.");
    }
    private static void listComplaints() {

        System.out.print("Citizen ID: ");
        String id = sc.nextLine();

        List<WasteServiceRow> list =
                service.listComplaintsByCitizen(id);

        if (list == null || list.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        for (WasteServiceRow row : list) {
            System.out.println("--------------------------------");
            System.out.println("Service ID: " + row.getServiceRowId());
            System.out.println("Type: " + row.getComplaintType());
            System.out.println("Status: " + row.getComplaintStatus());
            System.out.println("Priority: " + row.getPriorityLevel());
        }
    }
    private static void deactivateCitizen() {

        System.out.print("Citizen ID: ");
        String id = sc.nextLine();

        boolean result =
                service.deactivateOrRemoveCitizen(id);

        if (result)
            System.out.println("Citizen Deactivated Successfully.");
        else
            System.out.println("Cannot deactivate citizen.");
    }
}
