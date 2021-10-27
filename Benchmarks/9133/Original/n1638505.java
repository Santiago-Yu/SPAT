class n1638505{
    private Vendor createVendor() throws SQLException, IOException {
        Connection conn = null;
        Statement st = null;
        String query = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            st = conn.createStatement();
            query = "insert into " + DB.Tbl.vend + "(" + col.title + "," + col.addDate + "," + col.authorId + ") values('" + title + "',now()," + user.getId() + ")";
            st.executeUpdate(query, new String[] { col.id });
            rs = st.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §á§à§Ý§å§é§Ú§ä§î generated key 'id' §Ó §ä§Ñ§Ò§Ý§Ú§è§Ö vendors.");
            }
            int genId = rs.getInt(1);
            rs.close();
            saveDescr(genId);
            conn.commit();
            Vendor v = new Vendor();
            v.setId(genId);
            v.setTitle(title);
            v.setDescr(descr);
            VendorViewer.getInstance().vendorListChanged();
            return v;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (Exception e1) {
            }
            throw e;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                st.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

}