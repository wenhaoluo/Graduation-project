package com.jsf.entity;

import java.util.Date;

public class Course {
    private Integer courseid;

    private String yytime;

    private Boolean classover;

    private Integer teacherid;

    private Integer studentid;

    private Integer cid;
    
    private String cname;
    
	private String truename;
	
	private String phone;
	

    public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getYytime() {
        return yytime;
    }

    public void setYytime(String yytime) {
        this.yytime = yytime;
    }

    public Boolean getClassover() {
        return classover;
    }

    public void setClassover(Boolean classover) {
        this.classover = classover;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}