package net.wvffle.servlet.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

import java.util.List;
import java.util.stream.Collectors;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        List<Integer> list = (List<Integer>) sre.getServletContext().getAttribute("list");
        list.add((int) Math.round(Math.random() * 10000));
        sre.getServletContext().setAttribute("list", list.stream().sorted().collect(Collectors.toList()));
    }
}
