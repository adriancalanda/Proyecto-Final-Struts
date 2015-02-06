package com.open4job.proyectostruts.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.open4job.proyectostruts.model.vo.ParadaTaxiVO;

public class ParadaTaxiDAO {
	public ParadaTaxiDAO() {
	}

	// Listado de las paradas de taxi

	public ArrayList<ParadaTaxiVO> getListadoParadaTaxi() throws Exception {

		Connection conexion = getDataSource().getConnection();
		ArrayList<ParadaTaxiVO> lista = new ArrayList<ParadaTaxiVO>();

		PreparedStatement st = conexion.prepareStatement("SELECT * FROM PARADA_TAXI");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			lista.add(new ParadaTaxiVO(rs.getInt(1), rs.getString(2), rs
					.getDate(3), rs.getFloat(4), rs.getFloat(5), rs
					.getString(6)));
		}
		return lista;
	}

	// Metodo DataSource

	public DataSource getDataSource() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");

		return ds;

	}
}
