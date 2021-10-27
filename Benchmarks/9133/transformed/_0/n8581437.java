class n8581437 {
	protected String doIt() throws java.lang.Exception {
		StringBuffer oHRmeGNy = null;
		int OY21C3Jk = 0;
		String IiXGFiEE = " AND AD_Client_ID=" + m_AD_Client_ID;
		String[] aE0jrFk2 = new String[] { "Value", "Name", "Description", "DocumentNote", "Help", "UPC", "SKU",
				"Classification", "ProductType", "Discontinued", "DiscontinuedBy", "ImageURL", "DescriptionURL" };
		for (int nYitBDv7 = 0; nYitBDv7 < aE0jrFk2.length; nYitBDv7++) {
			oHRmeGNy = new StringBuffer("UPDATE I_PRODUCT i " + "SET ").append(aE0jrFk2[nYitBDv7]).append(" = (SELECT ")
					.append(aE0jrFk2[nYitBDv7])
					.append(" FROM M_Product p"
							+ " WHERE i.M_Product_ID=p.M_Product_ID AND i.AD_Client_ID=p.AD_Client_ID) "
							+ "WHERE M_Product_ID IS NOT NULL" + " AND EXISTS (SELECT * FROM M_Product p WHERE "
							+ aE0jrFk2[nYitBDv7]
							+ " IS NOT NULL AND p.M_Product_ID = i.M_Product_ID AND i.AD_Client_ID=p.AD_Client_ID)"
							+ " AND I_IsImported='N'")
					.append(IiXGFiEE);
			OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
			if (OY21C3Jk != 0) {
				log.fine("doIt - " + aE0jrFk2[nYitBDv7] + " - default from existing Product=" + OY21C3Jk);
			}
		}
		String[] ucITj0yl = new String[] { "C_UOM_ID", "M_Product_Category_ID", "Volume", "Weight", "ShelfWidth",
				"ShelfHeight", "ShelfDepth", "UnitsPerPallet", "M_Product_Family_ID" };
		for (int EW9kd24l = 0; EW9kd24l < ucITj0yl.length; EW9kd24l++) {
			oHRmeGNy = new StringBuffer("UPDATE I_PRODUCT i " + "SET ").append(ucITj0yl[EW9kd24l]).append(" = (SELECT ")
					.append(ucITj0yl[EW9kd24l])
					.append(" FROM M_Product p"
							+ " WHERE i.M_Product_ID=p.M_Product_ID AND i.AD_Client_ID=p.AD_Client_ID) "
							+ "WHERE M_Product_ID IS NOT NULL" + " AND EXISTS (SELECT * FROM M_Product p WHERE "
							+ ucITj0yl[EW9kd24l]
							+ " IS NOT NULL AND p.M_Product_ID = i.M_Product_ID AND i.AD_Client_ID=p.AD_Client_ID)"
							+ " AND I_IsImported='N'")
					.append(IiXGFiEE);
			OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
			if (OY21C3Jk != 0) {
				log.fine("doIt - " + ucITj0yl[EW9kd24l] + " default from existing Product=" + OY21C3Jk);
			}
		}
		String[] llIkNfv2 = new String[] { "UPC", "PriceEffective", "VendorProductNo", "VendorCategory", "Manufacturer",
				"Discontinued", "DiscontinuedBy" };
		for (int UU2hjW59 = 0; UU2hjW59 < llIkNfv2.length; UU2hjW59++) {
			oHRmeGNy = new StringBuffer("UPDATE I_PRODUCT i " + "SET ").append(llIkNfv2[UU2hjW59]).append(" = (SELECT ")
					.append(llIkNfv2[UU2hjW59])
					.append(" FROM M_Product_PO p"
							+ " WHERE i.M_Product_ID=p.M_Product_ID AND i.C_BPartner_ID=p.C_BPartner_ID AND i.AD_Client_ID=p.AD_Client_ID) "
							+ "WHERE M_Product_ID IS NOT NULL AND C_BPartner_ID IS NOT NULL"
							+ " AND EXISTS (SELECT * FROM M_Product_PO p WHERE " + llIkNfv2[UU2hjW59]
							+ " IS NOT NULL AND p.M_Product_ID = i.M_Product_ID AND i.AD_Client_ID=p.AD_Client_ID)"
							+ " AND I_IsImported='N'")
					.append(IiXGFiEE);
			OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
			if (OY21C3Jk != 0) {
				log.fine("doIt - " + llIkNfv2[UU2hjW59] + " default from existing Product PO=" + OY21C3Jk);
			}
		}
		String[] HwiLOarY = new String[] { "C_UOM_ID", "C_Currency_ID", "RoyaltyAmt", "Order_Min", "Order_Pack",
				"CostPerOrder", "DeliveryTime_Promised" };
		for (int iGLX5KmT = 0; iGLX5KmT < HwiLOarY.length; iGLX5KmT++) {
			oHRmeGNy = new StringBuffer("UPDATE I_PRODUCT i " + "SET ").append(HwiLOarY[iGLX5KmT]).append(" = (SELECT ")
					.append(HwiLOarY[iGLX5KmT])
					.append(" FROM M_Product_PO p"
							+ " WHERE i.M_Product_ID=p.M_Product_ID AND i.C_BPartner_ID=p.C_BPartner_ID AND i.AD_Client_ID=p.AD_Client_ID) "
							+ "WHERE M_Product_ID IS NOT NULL AND C_BPartner_ID IS NOT NULL"
							+ " AND EXISTS (SELECT * FROM M_Product_PO p WHERE " + HwiLOarY[iGLX5KmT]
							+ " IS NOT NULL AND p.M_Product_ID = i.M_Product_ID AND i.AD_Client_ID=p.AD_Client_ID)"
							+ " AND I_IsImported='N'")
					.append(IiXGFiEE);
			OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
			if (OY21C3Jk != 0) {
				log.fine("doIt - " + HwiLOarY[iGLX5KmT] + " default from existing Product PO=" + OY21C3Jk);
			}
		}
		HwiLOarY = new String[] { "PriceList", "PricePO" };
		for (int neJITVWW = 0; neJITVWW < HwiLOarY.length; neJITVWW++) {
			oHRmeGNy = new StringBuffer("UPDATE I_PRODUCT i " + "SET ").append(HwiLOarY[neJITVWW]).append(" = (SELECT ")
					.append(HwiLOarY[neJITVWW])
					.append(" FROM M_Product_PO p"
							+ " WHERE i.M_Product_ID=p.M_Product_ID AND i.C_BPartner_ID=p.C_BPartner_ID AND i.AD_Client_ID=p.AD_Client_ID) "
							+ "WHERE M_Product_ID IS NOT NULL AND C_BPartner_ID IS NOT NULL" + " AND (")
					.append(HwiLOarY[neJITVWW]).append(" IS NULL OR ").append(HwiLOarY[neJITVWW])
					.append("=0)" + " AND I_IsImported='N'").append(IiXGFiEE);
			OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
			if (OY21C3Jk != 0) {
				log.fine("doIt - " + HwiLOarY[neJITVWW] + " default from existing Product PO=" + OY21C3Jk);
			}
		}
		oHRmeGNy = new StringBuffer("UPDATE I_Product i " + "SET X12DE355 = "
				+ "(SELECT X12DE355 FROM C_UOM u WHERE u.IsDefault='Y' AND u.AD_Client_ID IN (0,i.AD_Client_ID) AND ROWNUM=1) "
				+ "WHERE X12DE355 IS NULL AND C_UOM_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.fine("doIt - Set UOM Default=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer("UPDATE I_Product i "
				+ "SET C_UOM_ID = (SELECT C_UOM_ID FROM C_UOM u WHERE u.X12DE355=i.X12DE355 AND u.AD_Client_ID IN (0,i.AD_Client_ID)) "
				+ "WHERE C_UOM_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.info("doIt - Set UOM=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid UOM, ' "
						+ "WHERE C_UOM_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.fine("doIt - Invalid UOM=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product " + "SET ProductCategory_Value=(SELECT Value FROM M_Product_Category"
						+ " WHERE IsDefault='Y' AND AD_Client_ID=")
								.append(m_AD_Client_ID)
								.append(" AND ROWNUM=1) "
										+ "WHERE ProductCategory_Value IS NULL AND M_Product_Category_ID IS NULL"
										+ " AND I_IsImported<>'Y'")
								.append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.fine("doIt - Set Category Default=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer("UPDATE I_Product i "
				+ "SET M_Product_Category_ID=(SELECT M_Product_Category_ID FROM M_Product_Category c"
				+ " WHERE i.ProductCategory_Value=c.Value AND i.AD_Client_ID=c.AD_Client_ID) "
				+ "WHERE M_Product_Category_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.info("doIt - Set Category=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid ProdCategorty,' "
						+ "WHERE M_Product_Category_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.fine("doIt - Invalid Category=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer("UPDATE I_Product i " + "SET ISO_Code=(SELECT ISO_Code FROM C_Currency c"
				+ " INNER JOIN C_AcctSchema a ON (a.C_Currency_ID=c.C_Currency_ID)"
				+ " INNER JOIN AD_ClientInfo fo ON (a.C_AcctSchema_ID=fo.C_AcctSchema1_ID)"
				+ " WHERE fo.AD_Client_ID=i.AD_Client_ID) " + "WHERE C_Currency_ID IS NULL AND ISO_Code IS NULL"
				+ " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.fine("doIt - Set Currency Default=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer("UPDATE I_Product i " + "SET C_Currency_ID=(SELECT C_Currency_ID FROM C_Currency c"
				+ " WHERE i.ISO_Code=c.ISO_Code AND c.AD_Client_ID IN (0,i.AD_Client_ID)) "
				+ "WHERE C_Currency_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.info("doIt- Set Currency=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Currency,' "
						+ "WHERE C_Currency_ID IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.fine("doIt - Invalid Currency=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Invalid ProductType,' "
						+ "WHERE ProductType NOT IN ('I','S')" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.fine("doIt - Invalid ProductType=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer("UPDATE I_Product i "
				+ "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=Value not unique,' " + "WHERE I_IsImported<>'Y'"
				+ " AND Value IN (SELECT Value FROM I_Product pr WHERE i.AD_Client_ID=pr.AD_Client_ID GROUP BY Value HAVING COUNT(*) > 1)")
						.append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.warning("doIt - Not Unique Value=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer("UPDATE I_Product i "
				+ "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=UPC not unique,' " + "WHERE I_IsImported<>'Y'"
				+ " AND UPC IN (SELECT UPC FROM I_Product pr WHERE i.AD_Client_ID=pr.AD_Client_ID GROUP BY UPC HAVING COUNT(*) > 1)")
						.append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.warning("doIt - Not Unique UPC=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=No Mandatory Value,' "
						+ "WHERE Value IS NULL" + " AND I_IsImported<>'Y'").append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.warning("doIt - No Mandatory Value=" + OY21C3Jk);
		}
		oHRmeGNy = new StringBuffer("UPDATE I_Product " + "SET VendorProductNo=Value "
				+ "WHERE C_BPartner_ID IS NOT NULL AND VendorProductNo IS NULL" + " AND I_IsImported='N'")
						.append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		log.info("doIt - VendorProductNo Set to Value=" + OY21C3Jk);
		oHRmeGNy = new StringBuffer("UPDATE I_Product i "
				+ "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||'ERR=VendorProductNo not unique,' "
				+ "WHERE I_IsImported<>'Y'" + " AND C_BPartner_ID IS NOT NULL"
				+ " AND (C_BPartner_ID, VendorProductNo) IN "
				+ " (SELECT C_BPartner_ID, VendorProductNo FROM I_Product pr WHERE i.AD_Client_ID=pr.AD_Client_ID GROUP BY C_BPartner_ID, VendorProductNo HAVING COUNT(*) > 1)")
						.append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		if (OY21C3Jk != 0) {
			log.warning("doIt - Not Unique VendorProductNo=" + OY21C3Jk);
		}
		int NtpZknhQ = 0;
		try {
			PreparedStatement uG19dcr2 = DB
					.prepareStatement("SELECT C_TaxCategory_ID FROM C_TaxCategory WHERE IsDefault='Y'" + IiXGFiEE);
			ResultSet Qpf4j9r3 = uG19dcr2.executeQuery();
			if (Qpf4j9r3.next()) {
				NtpZknhQ = Qpf4j9r3.getInt(1);
			}
			Qpf4j9r3.close();
			uG19dcr2.close();
		} catch (SQLException mEyRz6wa) {
			throw new Exception("doIt - TaxCategory", mEyRz6wa);
		}
		log.fine("doIt - C_TaxCategory_ID=" + NtpZknhQ);
		int fGoCtC9w = 0;
		int NnARNF7D = 0;
		int fqXs7TkD = 0;
		int zTnWgwFo = 0;
		log.fine("doIt - start inserting/updating ...");
		oHRmeGNy = new StringBuffer(
				"SELECT I_Product_ID, M_Product_ID, C_BPartner_ID " + "FROM I_Product WHERE I_IsImported='N'")
						.append(IiXGFiEE);
		Connection YTjmPZZq = DB.createConnection(false, Connection.TRANSACTION_READ_COMMITTED);
		try {
			PreparedStatement Xr5Kvndv = YTjmPZZq.prepareStatement("INSERT INTO M_Product (M_Product_ID,"
					+ "AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,"
					+ "Value,Name,Description,DocumentNote,Help,"
					+ "UPC,SKU,C_UOM_ID,IsSummary,M_Product_Category_ID,C_TaxCategory_ID,"
					+ "ProductType,ImageURL,DescriptionURL,M_Product_Family_ID) " + "SELECT ?,"
					+ "AD_Client_ID,AD_Org_ID,'Y',CURRENT_TIMESTAMP,CreatedBy,CURRENT_TIMESTAMP,UpdatedBy,"
					+ "Value,Name,Description,DocumentNote,Help," + "UPC,SKU,C_UOM_ID,'N',M_Product_Category_ID,"
					+ NtpZknhQ + "," + "ProductType,ImageURL,DescriptionURL,M_Product_Category_ID " + "FROM I_Product "
					+ "WHERE I_Product_ID=?");
			PreparedStatement mcL6Ctgv = YTjmPZZq.prepareStatement("UPDATE M_PRODUCT " + "SET Value=aux.value"
					+ ",Name=aux.Name" + ",Description=aux.Description" + ",DocumentNote=aux.DocumentNote"
					+ ",Help=aux.Help" + ",UPC=aux.UPC" + ",SKU=aux.SKU" + ",C_UOM_ID=aux.C_UOM_ID"
					+ ",M_Product_Category_ID=aux.M_Product_Category_ID" + ",Classification=aux.Classification"
					+ ",ProductType=aux.ProductType" + ",Volume=aux.Volume" + ",Weight=aux.Weight"
					+ ",ShelfWidth=aux.ShelfWidth" + ",ShelfHeight=aux.ShelfHeight" + ",ShelfDepth=aux.ShelfDepth"
					+ ",UnitsPerPallet=aux.UnitsPerPallet" + ",Discontinued=aux.Discontinued"
					+ ",DiscontinuedBy=aux.DiscontinuedBy" + ",Updated=current_timestamp" + ",UpdatedBy=aux.UpdatedBy"
					+ " from (SELECT Value,Name,Description,DocumentNote,Help,UPC,SKU,C_UOM_ID,M_Product_Category_ID,Classification,ProductType,Volume,Weight,ShelfWidth,ShelfHeight,ShelfDepth,UnitsPerPallet,Discontinued,DiscontinuedBy,UpdatedBy FROM I_Product WHERE I_Product_ID=?) as aux"
					+ " WHERE M_Product_ID=?");
			PreparedStatement TT3fNsaJ = YTjmPZZq.prepareStatement("UPDATE M_Product_PO " + "SET IsCurrentVendor='Y'"
					+ ",C_UOM_ID=aux1.C_UOM_ID" + ",C_Currency_ID=aux1.C_Currency_ID" + ",UPC=aux1.UPC"
					+ ",PriceList=aux1.PriceList" + ",PricePO=aux1.PricePO" + ",RoyaltyAmt=aux1.RoyaltyAmt"
					+ ",PriceEffective=aux1.PriceEffective" + ",VendorProductNo=aux1.VendorProductNo"
					+ ",VendorCategory=aux1.VendorCategory" + ",Manufacturer=aux1.Manufacturer"
					+ ",Discontinued=aux1.Discontinued" + ",DiscontinuedBy=aux1.DiscontinuedBy"
					+ ",Order_Min=aux1.Order_Min" + ",Order_Pack=aux1.Order_Pack" + ",CostPerOrder=aux1.CostPerOrder"
					+ ",DeliveryTime_Promised=aux1.DeliveryTime_Promised" + ",Updated=current_timestamp"
					+ ",UpdatedBy=aux1.UpdatedBy"
					+ " from (SELECT 'Y',C_UOM_ID,C_Currency_ID,UPC,PriceList,PricePO,RoyaltyAmt,PriceEffective,VendorProductNo,VendorCategory,Manufacturer,Discontinued,DiscontinuedBy,Order_Min,Order_Pack,CostPerOrder,DeliveryTime_Promised,UpdatedBy FROM I_Product WHERE I_Product_ID=?) as aux1"
					+ " WHERE M_Product_ID=? AND C_BPartner_ID=?");
			PreparedStatement CgkJFTBH = YTjmPZZq
					.prepareStatement("INSERT INTO M_Product_PO (M_Product_ID,C_BPartner_ID, "
							+ "AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,"
							+ "IsCurrentVendor,C_UOM_ID,C_Currency_ID,UPC,"
							+ "PriceList,PricePO,RoyaltyAmt,PriceEffective,"
							+ "VendorProductNo,VendorCategory,Manufacturer,"
							+ "Discontinued,DiscontinuedBy,Order_Min,Order_Pack,"
							+ "CostPerOrder,DeliveryTime_Promised) " + "SELECT ?,?, "
							+ "AD_Client_ID,AD_Org_ID,'Y',d,CreatedBy,CURRENT_TIMESTAMP,UpdatedBy,"
							+ "'Y',C_UOM_ID,C_Currency_ID,UPC," + "PriceList,PricePO,RoyaltyAmt,PriceEffective,"
							+ "VendorProductNo,VendorCategory,Manufacturer,"
							+ "Discontinued,DiscontinuedBy,Order_Min,Order_Pack,"
							+ "CostPerOrder,DeliveryTime_Promised " + "FROM I_Product " + "WHERE I_Product_ID=?");
			PreparedStatement IWE5vQEw = YTjmPZZq
					.prepareStatement("UPDATE I_Product SET I_IsImported='Y', M_Product_ID=?, "
							+ "Updated=CURRENT_TIMESTAMP, Processed='Y' WHERE I_Product_ID=?");
			PreparedStatement KfKNuZGE = DB.prepareStatement(oHRmeGNy.toString());
			ResultSet mC5LQEcG = KfKNuZGE.executeQuery();
			while (mC5LQEcG.next()) {
				int nz1DrE3U = mC5LQEcG.getInt(1);
				int FueCscyg = mC5LQEcG.getInt(2);
				int cPKH0tYB = mC5LQEcG.getInt(3);
				boolean RjU8QoxP = FueCscyg == 0;
				log.fine("I_Product_ID=" + nz1DrE3U + ", M_Product_ID=" + FueCscyg + ", C_BPartner_ID=" + cPKH0tYB);
				if (RjU8QoxP) {
					FueCscyg = DB.getNextID(m_AD_Client_ID, "M_Product", null);
					Xr5Kvndv.setInt(1, FueCscyg);
					Xr5Kvndv.setInt(2, nz1DrE3U);
					try {
						OY21C3Jk = Xr5Kvndv.executeUpdate();
						log.finer("Insert Product = " + OY21C3Jk);
						fGoCtC9w++;
					} catch (SQLException AtjHtd5a) {
						log.warning("Insert Product - " + AtjHtd5a.toString());
						oHRmeGNy = new StringBuffer(
								"UPDATE I_Product i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Insert Product: " + AtjHtd5a.toString()))
										.append("WHERE I_Product_ID=").append(nz1DrE3U);
						DB.executeUpdate(oHRmeGNy.toString());
						continue;
					}
				} else {
					mcL6Ctgv.setInt(1, nz1DrE3U);
					mcL6Ctgv.setInt(2, FueCscyg);
					try {
						OY21C3Jk = mcL6Ctgv.executeUpdate();
						log.finer("Update Product = " + OY21C3Jk);
						NnARNF7D++;
					} catch (SQLException D0grDZBu) {
						log.warning("Update Product - " + D0grDZBu.toString());
						oHRmeGNy = new StringBuffer(
								"UPDATE I_Product i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
										.append(DB.TO_STRING("Update Product: " + D0grDZBu.toString()))
										.append("WHERE I_Product_ID=").append(nz1DrE3U);
						DB.executeUpdate(oHRmeGNy.toString());
						continue;
					}
				}
				if (cPKH0tYB != 0) {
					OY21C3Jk = 0;
					if (!RjU8QoxP) {
						TT3fNsaJ.setInt(1, nz1DrE3U);
						TT3fNsaJ.setInt(2, FueCscyg);
						TT3fNsaJ.setInt(3, cPKH0tYB);
						try {
							OY21C3Jk = TT3fNsaJ.executeUpdate();
							log.finer("Update Product_PO = " + OY21C3Jk);
							zTnWgwFo++;
						} catch (SQLException CAPrx2al) {
							log.warning("Update Product_PO - " + CAPrx2al.toString());
							NnARNF7D--;
							YTjmPZZq.rollback();
							oHRmeGNy = new StringBuffer(
									"UPDATE I_Product i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
											.append(DB.TO_STRING("Update Product_PO: " + CAPrx2al.toString()))
											.append("WHERE I_Product_ID=").append(nz1DrE3U);
							DB.executeUpdate(oHRmeGNy.toString());
							continue;
						}
					}
					if (OY21C3Jk == 0) {
						CgkJFTBH.setInt(1, FueCscyg);
						CgkJFTBH.setInt(2, cPKH0tYB);
						CgkJFTBH.setInt(3, nz1DrE3U);
						try {
							OY21C3Jk = CgkJFTBH.executeUpdate();
							log.finer("Insert Product_PO = " + OY21C3Jk);
							fqXs7TkD++;
						} catch (SQLException ebaiXQ3C) {
							log.warning("Insert Product_PO - " + ebaiXQ3C.toString());
							fGoCtC9w--;
							YTjmPZZq.rollback();
							oHRmeGNy = new StringBuffer(
									"UPDATE I_Product i " + "SET I_IsImported='E', I_ErrorMsg=I_ErrorMsg||")
											.append(DB.TO_STRING("Insert Product_PO: " + ebaiXQ3C.toString()))
											.append("WHERE I_Product_ID=").append(nz1DrE3U);
							DB.executeUpdate(oHRmeGNy.toString());
							continue;
						}
					}
				}
				IWE5vQEw.setInt(1, FueCscyg);
				IWE5vQEw.setInt(2, nz1DrE3U);
				OY21C3Jk = IWE5vQEw.executeUpdate();
				YTjmPZZq.commit();
			}
			mC5LQEcG.close();
			KfKNuZGE.close();
			Xr5Kvndv.close();
			mcL6Ctgv.close();
			CgkJFTBH.close();
			TT3fNsaJ.close();
			IWE5vQEw.close();
			YTjmPZZq.close();
			YTjmPZZq = null;
		} catch (SQLException UooCOghv) {
			try {
				if (YTjmPZZq != null) {
					YTjmPZZq.close();
				}
				YTjmPZZq = null;
			} catch (SQLException K9iAZlY4) {
			}
			log.log(Level.SEVERE, "doIt", UooCOghv);
			throw new Exception("doIt", UooCOghv);
		} finally {
			if (YTjmPZZq != null) {
				YTjmPZZq.close();
			}
			YTjmPZZq = null;
		}
		oHRmeGNy = new StringBuffer(
				"UPDATE I_Product " + "SET I_IsImported='N', Updated=CURRENT_TIMESTAMP " + "WHERE I_IsImported<>'Y'")
						.append(IiXGFiEE);
		OY21C3Jk = DB.executeUpdate(oHRmeGNy.toString());
		StringBuffer W93zbDlF = new StringBuffer("");
		W93zbDlF.append("<tr><td>@Errors@</td><td>").append(OY21C3Jk).append("</td></tr>");
		W93zbDlF.append("<tr><td>@M_Product_ID@: @Inserted@</td><td>").append(fGoCtC9w).append("</td></tr>");
		W93zbDlF.append("<tr><td>@M_Product_ID@: @Updated@</td><td>").append(NnARNF7D).append("</td></tr>");
		W93zbDlF.append("<tr><td>@M_Product_ID@ @Purchase@: @Inserted@</td><td>").append(fqXs7TkD).append("</td></tr>");
		W93zbDlF.append("<tr><td>@M_Product_ID@ @Purchase@: @Updated@</td><td>").append(zTnWgwFo).append("</td></tr>");
		return W93zbDlF.toString();
	}

}