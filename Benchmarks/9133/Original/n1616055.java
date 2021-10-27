class n1616055{
    public void run() throws Exception {
        logger.debug("#run enter");
        PreparedStatement psNextId = null;
        ResultSet rsNextId = null;
        PreparedStatement ps = null;
        try {
            PreparedStatement psCount = connection.prepareStatement(COUNT_ACTIVE_ORDERS);
            psCount.setString(1, login);
            ResultSet rsCount = psCount.executeQuery();
            if (rsCount.next()) {
                Integer count = rsCount.getInt(1);
                if (count > 0) {
                    DBHelper.closeAll(null, rsCount, psCount);
                    throw new RuntimeException("§µ §Ó§Ñ§ã §å§Ø§Ö §Ö§ã§ä§î §à§Õ§Ú§ß §Ñ§Ü§ä§Ú§Ó§ß§í§Û §Ù§Ñ§Ü§Ñ§Ù. §£§í §ß§Ö §Þ§à§Ø§Ö§ä§Ö §ã§à§Ù§Õ§Ñ§ä§î §Ó§ä§à§â§à§Û.");
                }
            }
            connection.setAutoCommit(false);
            psNextId = connection.prepareStatement(NEXT_ORDER);
            rsNextId = psNextId.executeQuery();
            if (rsNextId.next()) {
                orderId = rsNextId.getInt(1);
            }
            rsNextId.close();
            psNextId.close();
            logger.info("#run orderId  = " + orderId);
            ps = connection.prepareStatement(INSERT_ORDER);
            ps.setInt(1, orderId);
            if (order.getCustomerId() != null) {
                ps.setInt(2, order.getCustomerId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setString(3, order.getSellerLogin());
            ps.executeUpdate();
            ps.close();
            logger.info("#run order insert OK");
            Iterator<OrderLine> lines = order.getLines().iterator();
            while (lines.hasNext()) {
                OrderLine line = lines.next();
                CreateOrderLineAction action = new CreateOrderLineAction();
                action.execute(connection, orderId, line);
            }
            connection.commit();
        } catch (SQLException ex) {
            logger.error("SQLException", ex);
            connection.rollback();
            throw new Exception("§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §ã§à§Ù§Õ§Ñ§ä§î §Ù§Ñ§Ü§Ñ§Ù. §°§ê§Ú§Ò§Ü§Ñ : " + ex.getMessage());
        } finally {
            connection.setAutoCommit(true);
        }
        logger.debug("#run exit");
    }

}