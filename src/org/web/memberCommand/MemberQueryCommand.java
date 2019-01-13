package org.web.memberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberQueryCommand {

	void memberQuery(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
