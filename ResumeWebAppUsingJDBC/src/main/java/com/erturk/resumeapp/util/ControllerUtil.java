package com.erturk.resumeapp.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerUtil {
    public static void errorPage(HttpServletResponse response, Exception ex) {
        try {
            ex.printStackTrace();
            response.sendRedirect("error?message=" + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
