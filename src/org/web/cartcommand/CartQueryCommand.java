package org.web.cartcommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CartQueryCommand {

	void CartCommand(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
