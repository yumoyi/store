package com.cy.ssm.pojo;

public class Category {
    private String cid;//商品分类id

    private String cname;//商品分类名称

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
    
}