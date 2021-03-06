
package com.felix.main.turbobuss.controll;

import com.felix.main.data.LineData;
import com.felix.main.data.TravelRoute;
import com.felix.main.turbobuss.model.IModel;
import com.felix.turbobuss.persistence.util.Guest;
import com.felix.turbobuss.persistence.util.GuestCollection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felix
 */
@WebServlet(name = "MainServlett", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

    @EJB private GuestCollection library;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        HttpSession session = request.getSession();
        IModel backend = (IModel) getServletContext().getAttribute(Keys.BACKEND.toString());
                
        String action = request.getParameter("action");
        String view = request.getParameter("view");
        String content = "home";

        // State changes and navigation
        if (action != null) {
            switch (action) {
                case "filter":  // A POST
                    String filter = request.getParameter("filt");
                    List<LineData> lines = backend.getLineData();
                    // Filter here
                    if (filter.equals("")){
                        request.setAttribute(Keys.LINES.toString(), lines);
                    } else {
                        List<LineData> newLines = new ArrayList<>();
                        for (LineData l : lines){
                            if (l.acceptedByFilter(filter)){
                                newLines.add(l);
                            }
                        }
                        request.setAttribute(Keys.LINES.toString(), newLines);
                    }
                    content = "partials/lineTables";
                    view = null;
                    break;
                case "plan":
                    String from = request.getParameter("from");
                    String to = request.getParameter("to");
                    String arrival = request.getParameter("arrival");
                    
                    if(from == null || to == null || arrival == null || arrival.length() != 5){
                        view = "travelPlanner";
                        break;
                    }
                    
                    List<TravelRoute> result = backend.copmutePath(arrival, from, to);
                    if (result == null){
                        view = "travelPlanner";
                        break;
                    }
                    request.setAttribute(Keys.PATH.toString(), result);
                    content = "partials/travelRoute";
                    break;
                case "newGuest":
                    String guest = request.getParameter("guest");
                    if (guest != null && guest.length() != 0){
                        library.create(new Guest(guest));
                    }
                    view = "guestList";
                    break;
                default:
                    ;
            }
        }

        // Navigation
        if (view != null) {
            switch (view) {
                case "home":
                    content = "partials/" + view;
                    break;
                case "lineTables":
                    content = "partials/" + view;
                    List<LineData> lines = backend.getLineData();
                    request.setAttribute(Keys.LINES.toString(), lines);
                    break;
                case "travelPlanner":
                    request.setAttribute(Keys.STOP_NAMES.toString(), backend.getStopNames());
                    content = "partials/" + view;
                    break;
                case "about":
                    content = "partials/" + view;
                    break;
                case "timeTable":
                    content = "partials/" + view;
                    String line = request.getParameter("line");
                    request.setAttribute(Keys.LINE.toString(), backend.getLine(line));
                    break;
                case "guestList":
                    content = "partials/" + view;
                    request.setAttribute(Keys.GUESTS.toString(), library.findAll());
                    break;
                default:
                    request.getRequestDispatcher("WEB-INF/jsp/main.jspx").forward(request, response);
                    break;
            }
        }
        request.setAttribute("content", content);
        request.getRequestDispatcher("WEB-INF/jsp/template.jspx").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
