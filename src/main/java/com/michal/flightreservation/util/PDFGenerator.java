package com.michal.flightreservation.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.michal.flightreservation.entities.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

    public void generateItinerary(Reservation reservation, String filePath){
        Document document = new Document();
        LOGGER.info("Preparing PDF file started");
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();
            LOGGER.info("Successfully created PDF file");
        } catch (FileNotFoundException | DocumentException e){
            LOGGER.error("PDF file was not created " + e);
        }
    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable table = new PdfPTable(2);

        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Flight Itinerary:"));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Flight Details:"));
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("Airlines");
        table.addCell(reservation.getFlight().getOperatingAirlines());
        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());
        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());
        table.addCell("Flight number");
        table.addCell(reservation.getFlight().getFlightNumber());
        table.addCell("Departure date");
        table.addCell(reservation.getFlight().getDateOfDeparture().toString());
        table.addCell("Departure time");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        cell = new PdfPCell(new Phrase("Passenger Details:"));
        cell.setColspan(2);
        table.addCell(cell);
        table.addCell("First name");
        table.addCell(reservation.getPassenger().getFirstName());
        table.addCell("Last name");
        table.addCell(reservation.getPassenger().getLastName());
        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());
        table.addCell("Phone");
        table.addCell(reservation.getPassenger().getPhone());

        return table;
        }
}
