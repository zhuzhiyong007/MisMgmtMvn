package net.zx.lims.dom;

public class Table {
	private Field fields;
	private Row rows;
	/**
	 * @return the fields
	 */
	public Field getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(Field fields) {
		this.fields = fields;
	}

	/**
	 * @return the rows
	 */
	public Row getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Row rows) {
		this.rows = rows;
	}


	//加载数据库信息到datadom中
	public void refresh(){
		
	}
}
