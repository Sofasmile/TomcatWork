package com.tomcat.controller;

import com.tomcat.dao.StudentDao;
import com.tomcat.dao.impl.StudentDaoImpl;
import com.tomcat.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private StudentDao repository = StudentDaoImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("id");
        if (Objects.isNull(studentId))
            request.getRequestDispatcher("/list").forward(request, response);
        else {
            Long id = Long.parseLong(studentId);
            Student student = repository.getById(id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("/list").forward(request, response);
        }
    }
}
