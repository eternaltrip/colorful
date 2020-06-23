package com.colorful.nuoche.entity;

import java.io.Serializable;
import java.util.Date;

public class Chepaiinfo implements Serializable {
	private String id;

	private String chepai;

	private String contactnum;

	private String contactpersonname;

	private Date createtime;

	private Date updatetime;

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getChepai() {
		return chepai;
	}

	public void setChepai(String chepai) {
		this.chepai = chepai == null ? null : chepai.trim();
	}

	public String getContactnum() {
		return contactnum;
	}

	public void setContactnum(String contactnum) {
		this.contactnum = contactnum == null ? null : contactnum.trim();
	}

	public String getContactpersonname() {
		return contactpersonname;
	}

	public void setContactpersonname(String contactpersonname) {
		this.contactpersonname = contactpersonname == null ? null : contactpersonname.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Chepaiinfo other = (Chepaiinfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getChepai() == null ? other.getChepai() == null : this.getChepai().equals(other.getChepai()))
				&& (this.getContactnum() == null ? other.getContactnum() == null
						: this.getContactnum().equals(other.getContactnum()))
				&& (this.getContactpersonname() == null ? other.getContactpersonname() == null
						: this.getContactpersonname().equals(other.getContactpersonname()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null
						: this.getCreatetime().equals(other.getCreatetime()))
				&& (this.getUpdatetime() == null ? other.getUpdatetime() == null
						: this.getUpdatetime().equals(other.getUpdatetime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getChepai() == null) ? 0 : getChepai().hashCode());
		result = prime * result + ((getContactnum() == null) ? 0 : getContactnum().hashCode());
		result = prime * result + ((getContactpersonname() == null) ? 0 : getContactpersonname().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", chepai=").append(chepai);
		sb.append(", contactnum=").append(contactnum);
		sb.append(", contactpersonname=").append(contactpersonname);
		sb.append(", createtime=").append(createtime);
		sb.append(", updatetime=").append(updatetime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}