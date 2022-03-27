package net.wvffle.servlet.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "index", value = "/")
public class ListAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> list = (List<Integer>) req.getServletContext().getAttribute("list");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.write('[');
        out.write(list.stream().map(integer -> "" + integer).collect(Collectors.joining(", ")));
        out.write(']');
    }
}