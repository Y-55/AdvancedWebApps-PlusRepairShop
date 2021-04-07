/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author yoooo
 */
public class NewRequestProcess extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //to get all form values
            String Computer_Owner = request.getParameter("Computer_Owner");
            String Computer_Serial_Number = request.getParameter("Computer_Serial_Number");
            String Type = request.getParameter("Type");
            String Model = request.getParameter("Model");
            int Memory_GB = Integer.parseInt(request.getParameter("Memory_GB"));//casting from string to integer
            int HardDisk_GB = Integer.parseInt(request.getParameter("HardDisk_GB"));//casting from string to integer
            String Problems = request.getParameter("Problems");

            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n"
                    + "  <head>\n"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                    + "    <title>JSP Page</title>\n"
                    + "    <link rel=\"stylesheet\" href=\"CSS/style.css\" />\n"
                    + "  </head>\n"
                    + "  <body>\n"
                    + "    <header>\n"
                    + "      <div id=\"logo\">\n"
                    + "        <div>\n"
                    + "          <img src=\"images/logo3.png\" alt=\"\" />\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "      <div id=\"menu-list\">\n"
                    + "        <ul>\n"
                    + "          <li><a id=\"current\" href=\"index.html\">Home</a></li>\n"
                    + "          <li>\n"
                    + "            <a href=\"Add_New_Repair_Request.html\">Add New Repair Request</a>\n"
                    + "          </li>\n"
                    + "          <li><a href=\"\">Browse All Repair Records</a></li>\n"
                    + "          <li><a href=\"Add_Feedback.html\">Add Feedback</a></li>\n"
                    + "        </ul>\n"
                    + "      </div>\n"
                    + "    </header>"
                    + "<div id=\"responsePage\">\n"
                    + "<a href=\"index.html\">Click here to go home</a> <br>");

            MySQLDatabase db = new MySQLDatabase();

            int k = db.insertIntoRepairs(Computer_Owner, Computer_Serial_Number, Type, Model, Memory_GB, HardDisk_GB, Problems);;     // returns number of affected rows

            if (k == 1) {
                //insert a record success
                out.println("<p class=\"correct\"> Data was added successfully. </p>");
            } else // i.e.  k = 0
            {
                //insert a record error
                out.println("<p class=\"error\"> There was an error in adding the data! Try again. </p>");
            }

            out.println("</div>");
            out.println("<footer>\n"
                    + "      <p>\n"
                    + "        copyright preserved for the site 2020 |\n"
                    + "        YusufAbdulwahab_MuhammedAl-Rammah\n"
                    + "      </p>\n"
                    + "    </footer>\n"
                    + "  </body>\n"
                    + "</html>");

        } catch (Exception ex) {
            //throw new ServletException(ex);
            out.println("<p class=\"error\"> There was an error exception meesage: " + ex + "</p>");
            out.println("</div>");
            out.println("<footer>\n"
                    + "      <p>\n"
                    + "        copyright preserved for the site 2020 |\n"
                    + "        YusufAbdulwahab_MuhammedAl-Rammah\n"
                    + "      </p>\n"
                    + "    </footer>\n"
                    + "  </body>\n"
                    + "</html>");
        } finally {
            out.close();
        }

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
