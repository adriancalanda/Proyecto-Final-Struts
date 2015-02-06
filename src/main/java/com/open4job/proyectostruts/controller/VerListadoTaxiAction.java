package com.open4job.proyectostruts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.open4job.proyectostruts.model.dao.ParadaTaxiDAO;
import com.open4job.proyectostruts.model.vo.ParadaTaxiVO;

public class VerListadoTaxiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ParadaTaxiDAO paradaTaxi = new ParadaTaxiDAO();
		List<ParadaTaxiVO> lstParadaTaxi = paradaTaxi.getListadoParadaTaxi();

		request.setAttribute("lstParadaTaxi", lstParadaTaxi);

		return mapping.findForward("success");

	}

}
