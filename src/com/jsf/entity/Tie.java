package com.jsf.entity;

import java.util.Date;

public class Tie {
    private Integer tieid;

    private String tietitle;

    private String tieauthor;

    private String tiecontext;

    private String tiedate;

    private Integer userid;

    public Integer getTieid() {
        return tieid;
    }

    public void setTieid(Integer tieid) {
        this.tieid = tieid;
    }

    public String getTietitle() {
        return tietitle;
    }

    public void setTietitle(String tietitle) {
        this.tietitle = tietitle;
    }

    public String getTieauthor() {
        return tieauthor;
    }

    public void setTieauthor(String tieauthor) {
        this.tieauthor = tieauthor;
    }

    public String getTiecontext() {
        return tiecontext;
    }

    public void setTiecontext(String tiecontext) {
        this.tiecontext = tiecontext;
    }
    
    

    public String getTiedate() {
		return tiedate;
	}

	public void setTiedate(String tiedate) {
		this.tiedate = tiedate;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}