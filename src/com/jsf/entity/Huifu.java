package com.jsf.entity;

import java.util.Date;

public class Huifu {
    private Integer hfid;

    private String hfauthor;

    private String hfcontext;

    private String hfdate;

    private Integer tieid;

    private Integer userid;

    public Integer getHfid() {
        return hfid;
    }

    public void setHfid(Integer hfid) {
        this.hfid = hfid;
    }

    public String getHfauthor() {
        return hfauthor;
    }

    public void setHfauthor(String hfauthor) {
        this.hfauthor = hfauthor;
    }

    public String getHfcontext() {
        return hfcontext;
    }

    public void setHfcontext(String hfcontext) {
        this.hfcontext = hfcontext;
    }

    

    public String getHfdate() {
		return hfdate;
	}

	public void setHfdate(String hfdate) {
		this.hfdate = hfdate;
	}

	public Integer getTieid() {
        return tieid;
    }

    public void setTieid(Integer tieid) {
        this.tieid = tieid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}