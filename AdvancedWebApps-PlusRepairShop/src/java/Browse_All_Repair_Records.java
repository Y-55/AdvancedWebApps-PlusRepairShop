/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohammed
 */
public class Browse_All_Repair_Records extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            /* TODO output your page here. You may use following sample code. */
            out.print("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "  <head>\n"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                    + "    <title>JSP Page</title>\n"
                    + "    <link rel=\"stylesheet\" href=\"CSS/style.css\" />\n"
                    + "    <script src=\"js/site.js\"></script>\n"
                    + "  </head>\n"
                    + "  <body>\n"
                    + /*"<h1>Servlet Browse_All_Repair_Records at " + request.getContextPath() + "</h1>\n"+*/ "    <header>\n"
                    + "      <div id=\"logo\">\n"
                    + "        <div>\n"
                    + "          <img src=\"images/logo3.png\" alt=\"\" />\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "      <div id=\"menu-list\">\n"
                    + "        <ul>\n"
                    + "          <li><a href=\"index.html\">Home</a></li>\n"
                    + "          <li>\n"
                    + "            <a href=\"Add_New_Repair_Request.html\">Add New Repair Request</a>\n"
                    + "          </li>\n"
                    + "          <li>\n"
                    + "            <a id=\"current\" href=\"Browse_All_Repair_Records\"\n"
                    + "              >Browse All Repair Records</a\n"
                    + "            >\n"
                    + "          </li>\n"
                    + "          <li><a href=\"Add_Feedback.html\">Add Feedback</a></li>\n"
                    + "        </ul>\n"
                    + "      </div>\n"
                    + "    </header>\n"
                    + "\n"
                    + "    \n");

            //code for table 
            out.println("<div class=\"flat-table\">");
            out.print("<h1 id=\"topic\">All Repair Records”</h1>");

            MySQLDatabase db = new MySQLDatabase();
            Connection conn = db.getConnection();

            String sql = "select * from repairs";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                out.println("<p> No registration records in database! </p>");
            } else {
                out.println("<table border='1'>");

                out.println("<tr> <th> ID </th> <th> Computer Owner </th> <th> Type </th> <th> Model </th>"
                        + " <th> Problems </th> <th> Repair Status </th> <th> Repair Cost </th> <th> Repair Finish  </th> "
                        + "<th> Repair Delivery </th></tr>");

                  while (rs.next()) {

                    out.println("<tr>");

                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("Computer_Owner") + "</td>");
                    out.println("<td>" + rs.getString("Type") + "</td>");
                    out.println("<td>" + rs.getString("Model") + "</td>");
                    out.println("<td>" + rs.getString("Problems") + "</td>");
                    out.println("<td>" + rs.getString("Repair_Status") + "</td>");
                    out.println("<td>" + rs.getInt("Repair_Cost") + "</td>");
                    out.println("<td>" + rs.getTimestamp("Repair_Finish") + "</td>");
                    out.println("<td>" + rs.getTimestamp("Repair_Delivery_DateTime") + "</td>");
                    out.println("</tr>");

                }
                out.println("</table>");
            }

            conn.close();

            //out.println("</div>");
            //out.println("<hr />");
            //out.println("</body>");
            //out.println("</html>");
            out.print("   </div>"
                    + " <footer>\n"
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

        } finally {


            out.close();
        }
    }

}
