package com.ecommerce.dao;

import java.sql.*;
import java.util.List;

import org.springframework.jdbc.core.*;

import com.ecommerce.EProduct;

public class EProductDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// Business methods
	public List<EProduct> getProducts() {

		return template.query("select * from eproduct", new RowMapper<EProduct>() {

			public EProduct mapRow(ResultSet rs, int row) throws SQLException {

				EProduct e = new EProduct();

				e.setID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPrice(rs.getBigDecimal(3));
				e.setDateAdded(rs.getDate(4));

				return e;
			}

		});

	}

}
