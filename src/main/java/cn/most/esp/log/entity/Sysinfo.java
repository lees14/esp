package cn.most.esp.log.entity;

import java.util.Date;

import cn.most.esp.base.entity.BaseEntity;

/**
 * t_l_sysinfo
 * @author 
 */
public class Sysinfo extends BaseEntity {
    private Integer sid;

    private String suid;

    private Integer outpid;

    private String saction;

    private String sip;

    private String scomputer;

    private String stag;

    private Date stime;

    private String slogname;

    private String scpmc;

    private static final long serialVersionUID = 1L;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public Integer getOutpid() {
        return outpid;
    }

    public void setOutpid(Integer outpid) {
        this.outpid = outpid;
    }

    public String getSaction() {
        return saction;
    }

    public void setSaction(String saction) {
        this.saction = saction;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getScomputer() {
        return scomputer;
    }

    public void setScomputer(String scomputer) {
        this.scomputer = scomputer;
    }

    public String getStag() {
        return stag;
    }

    public void setStag(String stag) {
        this.stag = stag;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public String getSlogname() {
        return slogname;
    }

    public void setSlogname(String slogname) {
        this.slogname = slogname;
    }

    public String getScpmc() {
        return scpmc;
    }

    public void setScpmc(String scpmc) {
        this.scpmc = scpmc;
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
        Sysinfo other = (Sysinfo) that;
        return (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getSuid() == null ? other.getSuid() == null : this.getSuid().equals(other.getSuid()))
            && (this.getOutpid() == null ? other.getOutpid() == null : this.getOutpid().equals(other.getOutpid()))
            && (this.getSaction() == null ? other.getSaction() == null : this.getSaction().equals(other.getSaction()))
            && (this.getSip() == null ? other.getSip() == null : this.getSip().equals(other.getSip()))
            && (this.getScomputer() == null ? other.getScomputer() == null : this.getScomputer().equals(other.getScomputer()))
            && (this.getStag() == null ? other.getStag() == null : this.getStag().equals(other.getStag()))
            && (this.getStime() == null ? other.getStime() == null : this.getStime().equals(other.getStime()))
            && (this.getSlogname() == null ? other.getSlogname() == null : this.getSlogname().equals(other.getSlogname()))
            && (this.getScpmc() == null ? other.getScpmc() == null : this.getScpmc().equals(other.getScpmc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getSuid() == null) ? 0 : getSuid().hashCode());
        result = prime * result + ((getOutpid() == null) ? 0 : getOutpid().hashCode());
        result = prime * result + ((getSaction() == null) ? 0 : getSaction().hashCode());
        result = prime * result + ((getSip() == null) ? 0 : getSip().hashCode());
        result = prime * result + ((getScomputer() == null) ? 0 : getScomputer().hashCode());
        result = prime * result + ((getStag() == null) ? 0 : getStag().hashCode());
        result = prime * result + ((getStime() == null) ? 0 : getStime().hashCode());
        result = prime * result + ((getSlogname() == null) ? 0 : getSlogname().hashCode());
        result = prime * result + ((getScpmc() == null) ? 0 : getScpmc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", suid=").append(suid);
        sb.append(", outpid=").append(outpid);
        sb.append(", saction=").append(saction);
        sb.append(", sip=").append(sip);
        sb.append(", scomputer=").append(scomputer);
        sb.append(", stag=").append(stag);
        sb.append(", stime=").append(stime);
        sb.append(", slogname=").append(slogname);
        sb.append(", scpmc=").append(scpmc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}