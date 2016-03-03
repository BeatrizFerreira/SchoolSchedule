package org.eclipse.wtp.sample.classschedule;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleServlet extends HttpServlet implements Servlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(request, response);
		
		String title = request.getParameter("title");
		int starttime = Integer.parseInt(request.getParameter("starttime"));
		int endtime = Integer.parseInt(request.getParameter("endtime"));
		String[] days = request.getParameterValues("day");

		SchoolSchedule schedule = (SchoolSchedule) request.getSession(true).getAttribute("schoolschedule");
		if (schedule == null){
			schedule = new SchoolSchedule();
		}
				
		if(days != null){
			for (int i = 0; i < days.length; i++){
				String dayString = days[i];
				int day;
				if(dayString.equalsIgnoreCase("SUN")) day = 0;
				else if (dayString.equalsIgnoreCase("MON")) day = 1;
				else if (dayString.equalsIgnoreCase("TUE")) day = 2;
				else if (dayString.equalsIgnoreCase("WED")) day = 3;
				else if (dayString.equalsIgnoreCase("THU")) day = 4;
				else if (dayString.equalsIgnoreCase("FRI")) day = 5;
				else day = 6;
				
				SchoolClass clazz = new SchoolClass(title, day, starttime, endtime);
				schedule.addClass(clazz);
				
				System.out.println("Title: " + title);
				System.out.println("StartTime: " + starttime);
				System.out.println("EndTime " + endtime);
				System.out.println("day: " + String.valueOf(day));
			}
		}
		
		
		request.getSession().setAttribute("schoolschedule", schedule);
		getServletContext().getRequestDispatcher("/Schedule.jsp").forward(request, response);
	}

}
