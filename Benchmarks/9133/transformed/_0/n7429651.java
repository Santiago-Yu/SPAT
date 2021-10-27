class n7429651 {
	protected void execute(Context o4s1oBUo) throws java.lang.Exception {
		Connection aFnr5ZJV = null;
		Statement gtRYi8MR = null;
		Integer s5VqLVxQ = o4s1oBUo.getValueAsInteger("Total");
		System.err.println("In BuyWidget.execute()");
		try {
			aFnr5ZJV = o4s1oBUo.getConnection();
			aFnr5ZJV.setAutoCommit(false);
			gtRYi8MR = aFnr5ZJV.createStatement();
			int APHcNBL5 = computeCheckoutTotal(o4s1oBUo, gtRYi8MR);
			if (s5VqLVxQ == null) {
				throw new Exception("Shouldn't: No total?");
			}
			if (s5VqLVxQ.intValue() != APHcNBL5) {
				throw new Exception(
						"Shouldn't: Basket changed? " + "total was " + APHcNBL5 + "; checksum was " + s5VqLVxQ);
			}
			StringBuffer IkhyHvZb = new StringBuffer("select BIDSTATE.Bid, BIDSTATE.Amount, "
					+ "BIDSTATE.QShipping, BIDSTATE.QInsure " + "from BID, BIDSTATE " + "where  BIDSTATE.Bid = BID.Bid "
					+ "and ( BIDSTATE.BidStatus = 0 " + "or BIDSTATE.BidStatus = 15) " + "and BID.Customer = ");
			IkhyHvZb.append(o4s1oBUo.get("customer"));
			IkhyHvZb.append(" and bidstate.bidstate =  " + "( select max( bidstate.bidstate) " + "from bidstate "
					+ "where bid = bid.bid) ");
			System.err.println(IkhyHvZb.toString());
			Contexts gBsIrK08 = new RSContexts(gtRYi8MR.executeQuery(IkhyHvZb.toString()));
			Enumeration QSgls3Rm = gBsIrK08.elements();
			while (QSgls3Rm.hasMoreElements()) {
				Context ml1I8MV9 = (Context) QSgls3Rm.nextElement();
				ml1I8MV9.merge((Map) o4s1oBUo);
				ml1I8MV9.put("Username", o4s1oBUo.get(ConnectionPool.DBUSERMAGICTOKEN));
				ml1I8MV9.put("BidStatus", BidStatus.OFFER);
				gtRYi8MR.executeUpdate(bidStateInsert(ml1I8MV9));
				gtRYi8MR.execute(bidPrivateInsert(o4s1oBUo, ml1I8MV9));
			}
			aFnr5ZJV.commit();
		} catch (Exception axNFuW4S) {
			aFnr5ZJV.rollback();
			throw new DataStoreException("Your card will not be debited: " + axNFuW4S.getMessage());
		} finally {
			try {
				if (gtRYi8MR != null) {
					gtRYi8MR.close();
				}
				if (aFnr5ZJV != null) {
					o4s1oBUo.releaseConnection(aFnr5ZJV);
				}
			} catch (SQLException yt8VTeIJ) {
			} catch (DataStoreException fY0jQI5H) {
			}
		}
		o4s1oBUo.put(REDIRECTMAGICTOKEN, "account");
	}

}