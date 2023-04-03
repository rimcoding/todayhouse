<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
RequestDispatcher dis = request.getRequestDispatcher("/borderService?cmd=oneclick");
dis.forward(request, response);
%>