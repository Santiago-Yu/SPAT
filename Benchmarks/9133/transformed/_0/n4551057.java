class n4551057 {
	public static void process(PricesType u8PO6R12, Long mVAGqBTk, DatabaseAdapter cnx0Fkes) throws PriceException {
		PreparedStatement bJP75743 = null;
		String z6SmdiDQ = null;
		PriceListItemType PxI1IbYs = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("dbDyn - " + cnx0Fkes);
				if (cnx0Fkes != null)
					log.debug("dbDyn.conn - " + cnx0Fkes.getConnection());
			}
			cnx0Fkes.getConnection().setAutoCommit(false);
			if (cnx0Fkes.getFamaly() != DatabaseManager.MYSQL_FAMALY) {
				z6SmdiDQ = "delete from WM_PRICE_IMPORT_TABLE where shop_code in "
						+ "( select shop_code from WM_PRICE_SHOP_LIST where ID_SITE=? )";
				bJP75743 = cnx0Fkes.prepareStatement(z6SmdiDQ);
				RsetTools.setLong(bJP75743, 1, mVAGqBTk);
				bJP75743.executeUpdate();
				bJP75743.close();
				bJP75743 = null;
			} else {
				String yxUFuUtK = "";
				boolean qnyHYiUr = false;
				WmPriceShopListListType HwdnW7Rb = GetWmPriceShopListWithIdSiteList.getInstance(cnx0Fkes,
						mVAGqBTk).item;
				boolean eyZExtu6 = true;
				for (int kCseoAvB = 0; kCseoAvB < HwdnW7Rb.getWmPriceShopListCount(); kCseoAvB++) {
					WmPriceShopListItemType eLUdFO6Z = HwdnW7Rb.getWmPriceShopList(kCseoAvB);
					qnyHYiUr = true;
					if (eyZExtu6)
						eyZExtu6 = false;
					else
						yxUFuUtK += ",";
					yxUFuUtK += ("'" + eLUdFO6Z.getCodeShop() + "'");
				}
				if (qnyHYiUr) {
					z6SmdiDQ = "delete from WM_PRICE_IMPORT_TABLE where shop_code in ( " + yxUFuUtK + " )";
					if (log.isDebugEnabled())
						log.debug("sql " + z6SmdiDQ);
					bJP75743 = cnx0Fkes.prepareStatement(z6SmdiDQ);
					bJP75743.executeUpdate();
					bJP75743.close();
					bJP75743 = null;
				}
			}
			if (log.isDebugEnabled())
				log.debug("Start unmarshalling data");
			if (u8PO6R12 == null)
				throw new PriceException("?????? ??????? ????? ???????. ??? ?????? #10.03");
			int pi0gOd9S = 0;
			int EzmxOAgb = 0;
			z6SmdiDQ = "insert into WM_PRICE_IMPORT_TABLE "
					+ "(is_group, id, id_main, name, price, currency, is_to_load, shop_code, ID_UPLOAD_PRICE) "
					+ "values (?,?,?,?,?,?,?,?,?)";
			Long wdMZWj9n = null;
			for (int aDInOdAM = 0; aDInOdAM < u8PO6R12.getPriceListCount(); aDInOdAM++) {
				PriceListType rTEhUXGt = u8PO6R12.getPriceList(aDInOdAM);
				if (log.isDebugEnabled()) {
					log.debug("shopCode " + rTEhUXGt.getShopCode());
					log.debug("Size vector: " + rTEhUXGt.getItemCount());
				}
				for (int M8ZfFOnv = 0; (M8ZfFOnv < rTEhUXGt.getItemCount())
						&& (EzmxOAgb < 5000); M8ZfFOnv++, EzmxOAgb++) {
					if (bJP75743 == null)
						bJP75743 = cnx0Fkes.prepareStatement(z6SmdiDQ);
					PriceListItemType uWY0AA2J = rTEhUXGt.getItem(M8ZfFOnv);
					PxI1IbYs = uWY0AA2J;
					bJP75743.setInt(1, Boolean.TRUE.equals(uWY0AA2J.getIsGroup()) ? 1 : 0);
					RsetTools.setLong(bJP75743, 2, uWY0AA2J.getItemID());
					RsetTools.setLong(bJP75743, 3, uWY0AA2J.getParentID());
					bJP75743.setString(4, uWY0AA2J.getNameItem());
					RsetTools.setDouble(bJP75743, 5, uWY0AA2J.getPrice());
					bJP75743.setString(6, uWY0AA2J.getCurr());
					bJP75743.setString(7, uWY0AA2J.getIsLoad().toString());
					bJP75743.setString(8, rTEhUXGt.getShopCode().toUpperCase());
					RsetTools.setLong(bJP75743, 9, wdMZWj9n);
					if (cnx0Fkes.getIsBatchUpdate()) {
						bJP75743.addBatch();
						if (++pi0gOd9S >= 200) {
							int[] rxyzMd7N = bJP75743.executeBatch();
							bJP75743.close();
							bJP75743 = null;
							pi0gOd9S = 0;
						}
					} else
						bJP75743.executeUpdate();
				}
			}
			if (cnx0Fkes.getIsBatchUpdate()) {
				if (bJP75743 != null) {
					int[] bmxgNjPj = bJP75743.executeBatch();
					bJP75743.close();
					bJP75743 = null;
				}
			}
			ImportPriceProcess.process(cnx0Fkes, mVAGqBTk);
			cnx0Fkes.commit();
		} catch (Exception NhpBKvKk) {
			if (PxI1IbYs != null) {
				log.error("debugItem.getIsGroup() " + (Boolean.TRUE.equals(PxI1IbYs.getIsGroup()) ? 1 : 0));
				log.error("debugItem.getItemID() " + PxI1IbYs.getItemID());
				log.error("debugItem.getParentID() " + PxI1IbYs.getParentID());
				log.error("debugItem.getNameItem() " + PxI1IbYs.getNameItem());
				log.error("debugItem.getPrice() " + PxI1IbYs.getPrice());
				log.error("debugItem.getCurr() " + PxI1IbYs.getCurr());
				log.error("debugItem.getIsLoad().toString() " + PxI1IbYs.getIsLoad().toString());
			} else
				log.error("debugItem is null");
			log.error("sql:\n" + z6SmdiDQ);
			final String rEFe6ykT = "error process import price-list";
			log.error(rEFe6ykT, NhpBKvKk);
			try {
				cnx0Fkes.rollback();
			} catch (Exception gItNA4dF) {
			}
			throw new PriceException(rEFe6ykT, NhpBKvKk);
		} finally {
			DatabaseManager.close(bJP75743);
			bJP75743 = null;
		}
	}

}