/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.naukma.javaee.hw1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "login", value = "/login" )
public class LoginServlet extends HttpServlet {

  private static String USERNAME = "username";
  private static String PASSWORD = "password";

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n" +
            "    <title>User Login Form</title>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "<h2>User Login Form</h2>\n" +
            "<form method=\"post\" action=\"/login\">\n" +
            "    <fieldset>\n" +
            "        Name: <input type=\"text\" name=\"username\" /><br /><br />\n" +
            "        Password: <input type=\"password\" name=\"password\" /><br /><br />\n" +
            "    </fieldset>\n" +
            "\n" +
            "    <input type=\"submit\" value=\"SEND\" />\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    PrintWriter out = resp.getWriter();

    if(USERNAME.equals(username) && PASSWORD.equals(password)) {
        out.println("SUCCESS!!!!!!");
    } else {
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n" +
                "    <title>User Login Form</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "ERROR!!! Try again... <br>" +
                "<a href='/login'>Back to form</a>" +
                "</body>\n" +
                "</html>");
    }

  }
}
