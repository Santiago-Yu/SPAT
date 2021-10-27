class n2525684 {
	private void add(Hashtable vkHQQKPO) throws Exception {
		String QC3HzzNR = "".equals(getParam("applicant_id_gen").trim()) ? "update" : "insert";
		String z7VfTWgv = getParam("applicant_id");
		String sgNybWhr = getParam("password");
		if ("".equals(z7VfTWgv))
			z7VfTWgv = getParam("applicant_id_gen");
		if ("".equals(getParam("applicant_name")))
			throw new Exception("Can not have empty fields!");
		vkHQQKPO.put("id", z7VfTWgv);
		vkHQQKPO.put("password", sgNybWhr);
		vkHQQKPO.put("name", getParam("applicant_name"));
		vkHQQKPO.put("address1", getParam("address1"));
		vkHQQKPO.put("address2", getParam("address2"));
		vkHQQKPO.put("address3", getParam("address3"));
		vkHQQKPO.put("city", getParam("city"));
		vkHQQKPO.put("state", getParam("state"));
		vkHQQKPO.put("poscode", getParam("poscode"));
		vkHQQKPO.put("country_code", getParam("country_list"));
		vkHQQKPO.put("email", getParam("email"));
		vkHQQKPO.put("phone", getParam("phone"));
		String bapRUeCa = getParam("birth_year");
		String kKpRnR9z = getParam("birth_month");
		String XpPhy4ha = getParam("birth_day");
		vkHQQKPO.put("birth_year", bapRUeCa);
		vkHQQKPO.put("birth_month", kKpRnR9z);
		vkHQQKPO.put("birth_day", XpPhy4ha);
		vkHQQKPO.put("gender", getParam("gender"));
		String SGdRARhg = bapRUeCa + "-" + fmt(kKpRnR9z) + "-" + fmt(XpPhy4ha);
		vkHQQKPO.put("birth_date", SGdRARhg);
		Db sTVzxY4f = null;
		String iVNdS1CL = "";
		Connection jsJDkKGx = null;
		try {
			sTVzxY4f = new Db();
			jsJDkKGx = sTVzxY4f.getConnection();
			jsJDkKGx.setAutoCommit(false);
			Statement FEOzLgh2 = sTVzxY4f.getStatement();
			SQLRenderer N988A8WP = new SQLRenderer();
			boolean vfcr5WX5 = false;
			{
				N988A8WP.add("applicant_id");
				N988A8WP.add("applicant_id", (String) vkHQQKPO.get("id"));
				iVNdS1CL = N988A8WP.getSQLSelect("adm_applicant");
				ResultSet NpoX4NJI = FEOzLgh2.executeQuery(iVNdS1CL);
				if (NpoX4NJI.next())
					vfcr5WX5 = true;
				else
					vfcr5WX5 = false;
			}
			if (vfcr5WX5 && !"update".equals(QC3HzzNR))
				throw new Exception("Applicant Id was invalid!");
			{
				N988A8WP.clear();
				N988A8WP.add("password", (String) vkHQQKPO.get("password"));
				N988A8WP.add("applicant_name", (String) vkHQQKPO.get("name"));
				N988A8WP.add("address1", (String) vkHQQKPO.get("address1"));
				N988A8WP.add("address2", (String) vkHQQKPO.get("address2"));
				N988A8WP.add("address3", (String) vkHQQKPO.get("address3"));
				N988A8WP.add("city", (String) vkHQQKPO.get("city"));
				N988A8WP.add("state", (String) vkHQQKPO.get("state"));
				N988A8WP.add("poscode", (String) vkHQQKPO.get("poscode"));
				N988A8WP.add("country_code", (String) vkHQQKPO.get("country_code"));
				N988A8WP.add("phone", (String) vkHQQKPO.get("phone"));
				N988A8WP.add("birth_date", (String) vkHQQKPO.get("birth_date"));
				N988A8WP.add("gender", (String) vkHQQKPO.get("gender"));
			}
			if (!vfcr5WX5) {
				N988A8WP.add("applicant_id", (String) vkHQQKPO.get("id"));
				iVNdS1CL = N988A8WP.getSQLInsert("adm_applicant");
				FEOzLgh2.executeUpdate(iVNdS1CL);
			} else {
				N988A8WP.update("applicant_id", (String) vkHQQKPO.get("id"));
				iVNdS1CL = N988A8WP.getSQLUpdate("adm_applicant");
				FEOzLgh2.executeUpdate(iVNdS1CL);
			}
			jsJDkKGx.commit();
		} catch (DbException ZeTChHNj) {
			throw ZeTChHNj;
		} catch (SQLException AGAoBU6G) {
			try {
				jsJDkKGx.rollback();
			} catch (SQLException ya5WSiVb) {
			}
			throw AGAoBU6G;
		} finally {
			if (sTVzxY4f != null)
				sTVzxY4f.close();
		}
	}

}