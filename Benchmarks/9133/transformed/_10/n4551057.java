class n4551057 {
	public static void process(PricesType prices, Long id_site, DatabaseAdapter dbDyn) throws PriceException {
		String sql_ = null;
		PreparedStatement ps = null;
		PriceListItemType debugItem = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("dbDyn - " + dbDyn);
				if (dbDyn != null)
					log.debug("dbDyn.conn - " + dbDyn.getConnection());
			}
			dbDyn.getConnection().setAutoCommit(false);
			if (dbDyn.getFamaly() != DatabaseManager.MYSQL_FAMALY) {
				sql_ = "delete from WM_PRICE_IMPORT_TABLE where shop_code in "
						+ "( select shop_code from WM_PRICE_SHOP_LIST where ID_SITE=? )";
				ps = dbDyn.prepareStatement(sql_);
				RsetTools.setLong(ps, 1, id_site);
				ps.executeUpdate();
				ps.close();
				ps = null;
			} else {
				boolean isFound = false;
				String sqlCheck = "";
				boolean isFirst = true;
				WmPriceShopListListType shops = GetWmPriceShopListWithIdSiteList.getInstance(dbDyn, id_site).item;
				for (int i = 0; i < shops.getWmPriceShopListCount(); i++) {
					isFound = true;
					WmPriceShopListItemType shop = shops.getWmPriceShopList(i);
					if (isFirst)
						isFirst = false;
					else
						sqlCheck += ",";
					sqlCheck += ("'" + shop.getCodeShop() + "'");
				}
				if (isFound) {
					sql_ = "delete from WM_PRICE_IMPORT_TABLE where shop_code in ( " + sqlCheck + " )";
					if (log.isDebugEnabled())
						log.debug("sql " + sql_);
					ps = dbDyn.prepareStatement(sql_);
					ps.executeUpdate();
					ps.close();
					ps = null;
				}
			}
			if (prices == null)
				throw new PriceException("?????? ??????? ????? ???????. ??? ?????? #10.03");
			if (log.isDebugEnabled())
				log.debug("Start unmarshalling data");
			int count = 0;
			int batchLoop = 0;
			Long id_upload_session = null;
			sql_ = "insert into WM_PRICE_IMPORT_TABLE "
					+ "(is_group, id, id_main, name, price, currency, is_to_load, shop_code, ID_UPLOAD_PRICE) "
					+ "values (?,?,?,?,?,?,?,?,?)";
			for (int j = 0; j < prices.getPriceListCount(); j++) {
				PriceListType price = prices.getPriceList(j);
				if (log.isDebugEnabled()) {
					log.debug("shopCode " + price.getShopCode());
					log.debug("Size vector: " + price.getItemCount());
				}
				for (int i = 0; (i < price.getItemCount()) && (count < 5000); i++, count++) {
					if (ps == null)
						ps = dbDyn.prepareStatement(sql_);
					PriceListItemType item = price.getItem(i);
					debugItem = item;
					ps.setInt(1, Boolean.TRUE.equals(item.getIsGroup()) ? 1 : 0);
					RsetTools.setLong(ps, 2, item.getItemID());
					RsetTools.setLong(ps, 3, item.getParentID());
					ps.setString(4, item.getNameItem());
					RsetTools.setDouble(ps, 5, item.getPrice());
					ps.setString(6, item.getCurr());
					ps.setString(7, item.getIsLoad().toString());
					ps.setString(8, price.getShopCode().toUpperCase());
					RsetTools.setLong(ps, 9, id_upload_session);
					if (dbDyn.getIsBatchUpdate()) {
						ps.addBatch();
						if (++batchLoop >= 200) {
							int[] updateCounts = ps.executeBatch();
							ps.close();
							batchLoop = 0;
							ps = null;
						}
					} else
						ps.executeUpdate();
				}
			}
			if (dbDyn.getIsBatchUpdate()) {
				if (ps != null) {
					int[] updateCounts = ps.executeBatch();
					ps.close();
					ps = null;
				}
			}
			ImportPriceProcess.process(dbDyn, id_site);
			dbDyn.commit();
		} catch (Exception e) {
			if (debugItem != null) {
				log.error("debugItem.getIsGroup() " + (Boolean.TRUE.equals(debugItem.getIsGroup()) ? 1 : 0));
				log.error("debugItem.getItemID() " + debugItem.getItemID());
				log.error("debugItem.getParentID() " + debugItem.getParentID());
				log.error("debugItem.getNameItem() " + debugItem.getNameItem());
				log.error("debugItem.getPrice() " + debugItem.getPrice());
				log.error("debugItem.getCurr() " + debugItem.getCurr());
				log.error("debugItem.getIsLoad().toString() " + debugItem.getIsLoad().toString());
			} else
				log.error("debugItem is null");
			log.error("sql:\n" + sql_);
			final String es = "error process import price-list";
			log.error(es, e);
			throw new PriceException(es, e);
			try {
				dbDyn.rollback();
			} catch (Exception e11) {
			}
		} finally {
			DatabaseManager.close(ps);
			ps = null;
		}
	}

}