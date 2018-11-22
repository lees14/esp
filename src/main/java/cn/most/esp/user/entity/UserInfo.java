package cn.most.esp.user.entity;

import java.util.Date;

import cn.most.esp.base.entity.BaseEntity;

public class UserInfo extends BaseEntity {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String loginname;

    private String loginpwd;

    private String userpwdkey;

    private String pwdmd;

    private String pwdcld;

    private String logintruename;

    private String loginpower;

    private Integer savantid;

    private Date savantdate;

    private Date savantsend;

    private Integer savanttype;

    private Date locktime;

    private Integer wronglogtimes;

    private String bfloginname;

    private String bfloginpwd;

    private String xid;

    private String roles;

    private String dwid;

    private String dwmc;

    private String ispwdupdate;

    private String isuseagain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getUserpwdkey() {
        return userpwdkey;
    }

    public void setUserpwdkey(String userpwdkey) {
        this.userpwdkey = userpwdkey == null ? null : userpwdkey.trim();
    }

    public String getPwdmd() {
        return pwdmd;
    }

    public void setPwdmd(String pwdmd) {
        this.pwdmd = pwdmd == null ? null : pwdmd.trim();
    }

    public String getPwdcld() {
        return pwdcld;
    }

    public void setPwdcld(String pwdcld) {
        this.pwdcld = pwdcld == null ? null : pwdcld.trim();
    }

    public String getLogintruename() {
        return logintruename;
    }

    public void setLogintruename(String logintruename) {
        this.logintruename = logintruename == null ? null : logintruename.trim();
    }

    public String getLoginpower() {
        return loginpower;
    }

    public void setLoginpower(String loginpower) {
        this.loginpower = loginpower == null ? null : loginpower.trim();
    }

    public Integer getSavantid() {
        return savantid;
    }

    public void setSavantid(Integer savantid) {
        this.savantid = savantid;
    }

    public Date getSavantdate() {
        return savantdate;
    }

    public void setSavantdate(Date savantdate) {
        this.savantdate = savantdate;
    }

    public Date getSavantsend() {
        return savantsend;
    }

    public void setSavantsend(Date savantsend) {
        this.savantsend = savantsend;
    }

    public Integer getSavanttype() {
        return savanttype;
    }

    public void setSavanttype(Integer savanttype) {
        this.savanttype = savanttype;
    }

    public Date getLocktime() {
        return locktime;
    }

    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    public Integer getWronglogtimes() {
        return wronglogtimes;
    }

    public void setWronglogtimes(Integer wronglogtimes) {
        this.wronglogtimes = wronglogtimes;
    }

    public String getBfloginname() {
        return bfloginname;
    }

    public void setBfloginname(String bfloginname) {
        this.bfloginname = bfloginname == null ? null : bfloginname.trim();
    }

    public String getBfloginpwd() {
        return bfloginpwd;
    }

    public void setBfloginpwd(String bfloginpwd) {
        this.bfloginpwd = bfloginpwd == null ? null : bfloginpwd.trim();
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid == null ? null : xid.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public String getDwid() {
        return dwid;
    }

    public void setDwid(String dwid) {
        this.dwid = dwid == null ? null : dwid.trim();
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc == null ? null : dwmc.trim();
    }

    public String getIspwdupdate() {
        return ispwdupdate;
    }

    public void setIspwdupdate(String ispwdupdate) {
        this.ispwdupdate = ispwdupdate == null ? null : ispwdupdate.trim();
    }

    public String getIsuseagain() {
        return isuseagain;
    }

    public void setIsuseagain(String isuseagain) {
        this.isuseagain = isuseagain == null ? null : isuseagain.trim();
    }
}
