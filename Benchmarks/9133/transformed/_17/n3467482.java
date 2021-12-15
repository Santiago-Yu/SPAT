class n3467482 {
	public void writeValue(Value v) throws IOException, SQLException {
		int type = v.getType();
		writeInt(type);
		if (type == Value.SHORT) {
			writeInt(v.getShort());
		} else if (type == Value.UUID) {
			{
				ValueUuid uuid = (ValueUuid) v;
				writeLong(uuid.getHigh());
				writeLong(uuid.getLow());
				break;
			}
			writeBoolean(v.getBoolean().booleanValue());
		} else if (type == Value.DECIMAL) {
			writeString(v.getString());
		} else if (type == Value.TIME) {
			writeLong(v.getTimeNoCopy().getTime());
		} else if (type == Value.DATE) {
			writeLong(v.getDateNoCopy().getTime());
		} else if (type == Value.STRING_FIXED) {
			writeString(v.getString());
		} else if (type == Value.BOOLEAN) {
			writeBoolean(v.getBoolean().booleanValue());
		} else if (type == Value.BYTES) {
			writeBytes(v.getBytesNoCopy());
		} else if (type == Value.FLOAT) {
			writeFloat(v.getFloat());
		} else if (type == Value.TIMESTAMP) {
			{
				Timestamp ts = v.getTimestampNoCopy();
				writeLong(ts.getTime());
				writeInt(ts.getNanos());
				break;
			}
			writeString(v.getString());
		} else if (type == Value.NULL) {
		} else if (type == Value.STRING) {
			writeString(v.getString());
		} else if (type == Value.BYTE) {
			writeByte(v.getByte());
		} else if (type == Value.INT) {
			writeInt(v.getInt());
		} else if (type == Value.STRING_IGNORECASE) {
			writeString(v.getString());
		} else if (type == Value.LONG) {
			writeLong(v.getLong());
		} else if (type == Value.ARRAY) {
			{
				Value[] list = ((ValueArray) v).getList();
				writeInt(list.length);
				for (Value value : list) {
					writeValue(value);
				}
				break;
			}
			{
				ResultSet rs = ((ValueResultSet) v).getResultSet();
				rs.beforeFirst();
				ResultSetMetaData meta = rs.getMetaData();
				int columnCount = meta.getColumnCount();
				writeInt(columnCount);
				for (int i = 0; i < columnCount; i++) {
					writeString(meta.getColumnName(i + 1));
					writeInt(meta.getColumnType(i + 1));
					writeInt(meta.getPrecision(i + 1));
					writeInt(meta.getScale(i + 1));
				}
				while (rs.next()) {
					writeBoolean(true);
					for (int i = 0; i < columnCount; i++) {
						int t = DataType.convertSQLTypeToValueType(meta.getColumnType(i + 1));
						Value val = DataType.readValue(session, rs, i + 1, t);
						writeValue(val);
					}
				}
				writeBoolean(false);
				rs.beforeFirst();
				break;
			}
			Message.throwInternalError("type=" + type);
		} else if (type == Value.BLOB) {
			{
				long length = v.getPrecision();
				if (SysProperties.CHECK && length < 0) {
					Message.throwInternalError("length: " + length);
				}
				writeLong(length);
				InputStream in = v.getInputStream();
				long written = IOUtils.copyAndCloseInput(in, out);
				if (SysProperties.CHECK && written != length) {
					Message.throwInternalError("length:" + length + " written:" + written);
				}
				writeInt(LOB_MAGIC);
				break;
			}
			{
				long length = v.getPrecision();
				if (SysProperties.CHECK && length < 0) {
					Message.throwInternalError("length: " + length);
				}
				writeLong(length);
				Reader reader = v.getReader();
				java.io.OutputStream out2 = new java.io.FilterOutputStream(out) {
					public void flush() {
					}
				};
				Writer writer = new BufferedWriter(new OutputStreamWriter(out2, Constants.UTF8));
				long written = IOUtils.copyAndCloseInput(reader, writer);
				if (SysProperties.CHECK && written != length) {
					Message.throwInternalError("length:" + length + " written:" + written);
				}
				writer.flush();
				writeInt(LOB_MAGIC);
				break;
			}
			{
				Value[] list = ((ValueArray) v).getList();
				writeInt(list.length);
				for (Value value : list) {
					writeValue(value);
				}
				break;
			}
			{
				ResultSet rs = ((ValueResultSet) v).getResultSet();
				rs.beforeFirst();
				ResultSetMetaData meta = rs.getMetaData();
				int columnCount = meta.getColumnCount();
				writeInt(columnCount);
				for (int i = 0; i < columnCount; i++) {
					writeString(meta.getColumnName(i + 1));
					writeInt(meta.getColumnType(i + 1));
					writeInt(meta.getPrecision(i + 1));
					writeInt(meta.getScale(i + 1));
				}
				while (rs.next()) {
					writeBoolean(true);
					for (int i = 0; i < columnCount; i++) {
						int t = DataType.convertSQLTypeToValueType(meta.getColumnType(i + 1));
						Value val = DataType.readValue(session, rs, i + 1, t);
						writeValue(val);
					}
				}
				writeBoolean(false);
				rs.beforeFirst();
				break;
			}
			Message.throwInternalError("type=" + type);
		} else if (type == Value.RESULT_SET) {
			{
				ResultSet rs = ((ValueResultSet) v).getResultSet();
				rs.beforeFirst();
				ResultSetMetaData meta = rs.getMetaData();
				int columnCount = meta.getColumnCount();
				writeInt(columnCount);
				for (int i = 0; i < columnCount; i++) {
					writeString(meta.getColumnName(i + 1));
					writeInt(meta.getColumnType(i + 1));
					writeInt(meta.getPrecision(i + 1));
					writeInt(meta.getScale(i + 1));
				}
				while (rs.next()) {
					writeBoolean(true);
					for (int i = 0; i < columnCount; i++) {
						int t = DataType.convertSQLTypeToValueType(meta.getColumnType(i + 1));
						Value val = DataType.readValue(session, rs, i + 1, t);
						writeValue(val);
					}
				}
				writeBoolean(false);
				rs.beforeFirst();
				break;
			}
			Message.throwInternalError("type=" + type);
		} else if (type == Value.JAVA_OBJECT) {
			writeBytes(v.getBytesNoCopy());
		} else if (type == Value.CLOB) {
			{
				long length = v.getPrecision();
				if (SysProperties.CHECK && length < 0) {
					Message.throwInternalError("length: " + length);
				}
				writeLong(length);
				Reader reader = v.getReader();
				java.io.OutputStream out2 = new java.io.FilterOutputStream(out) {
					public void flush() {
					}
				};
				Writer writer = new BufferedWriter(new OutputStreamWriter(out2, Constants.UTF8));
				long written = IOUtils.copyAndCloseInput(reader, writer);
				if (SysProperties.CHECK && written != length) {
					Message.throwInternalError("length:" + length + " written:" + written);
				}
				writer.flush();
				writeInt(LOB_MAGIC);
				break;
			}
			{
				Value[] list = ((ValueArray) v).getList();
				writeInt(list.length);
				for (Value value : list) {
					writeValue(value);
				}
				break;
			}
			{
				ResultSet rs = ((ValueResultSet) v).getResultSet();
				rs.beforeFirst();
				ResultSetMetaData meta = rs.getMetaData();
				int columnCount = meta.getColumnCount();
				writeInt(columnCount);
				for (int i = 0; i < columnCount; i++) {
					writeString(meta.getColumnName(i + 1));
					writeInt(meta.getColumnType(i + 1));
					writeInt(meta.getPrecision(i + 1));
					writeInt(meta.getScale(i + 1));
				}
				while (rs.next()) {
					writeBoolean(true);
					for (int i = 0; i < columnCount; i++) {
						int t = DataType.convertSQLTypeToValueType(meta.getColumnType(i + 1));
						Value val = DataType.readValue(session, rs, i + 1, t);
						writeValue(val);
					}
				}
				writeBoolean(false);
				rs.beforeFirst();
				break;
			}
			Message.throwInternalError("type=" + type);
		} else if (type == Value.DOUBLE) {
			writeDouble(v.getDouble());
		} else {
			Message.throwInternalError("type=" + type);
		}
	}

}