class n8400507 {
	public int updatewuliao(Addwuliao hq2yagfS) {
		int uYCYGPRR = 0;
		Connection tPTH4u35 = null;
		PreparedStatement vtSrsrV9 = null;
		try {
			tPTH4u35 = Pool.getConnection();
			tPTH4u35.setAutoCommit(false);
			vtSrsrV9 = tPTH4u35
					.prepareStatement("update addwuliao set inname=?,innum=?,inprice=?,productsdetail=?where pid=?");
			vtSrsrV9.setString(1, hq2yagfS.getInname());
			vtSrsrV9.setInt(2, hq2yagfS.getInnum());
			vtSrsrV9.setDouble(3, hq2yagfS.getInprice());
			vtSrsrV9.setString(4, hq2yagfS.getProductsdetail());
			vtSrsrV9.setString(5, hq2yagfS.getPid());
			uYCYGPRR = vtSrsrV9.executeUpdate();
			tPTH4u35.commit();
			Pool.close(vtSrsrV9);
			Pool.close(tPTH4u35);
		} catch (Exception ziYzSMw9) {
			ziYzSMw9.printStackTrace();
			try {
				tPTH4u35.rollback();
			} catch (Exception i7NulRo1) {
				i7NulRo1.printStackTrace();
			}
			Pool.close(vtSrsrV9);
			Pool.close(tPTH4u35);
		} finally {
			Pool.close(vtSrsrV9);
			Pool.close(tPTH4u35);
		}
		return uYCYGPRR;
	}

}