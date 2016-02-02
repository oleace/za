package com.boya.kites.liberator.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 适用于JSON的组织机构对象。
 *
 * @author lz (Mail:lzazmy@163.com) <br>
 * @version 1.00.000
 */
public class OrganizationJSON implements Serializable {

    /**
     * <code>serialVersionUID</code> 的注释
     */
    private static final long serialVersionUID = -7683428951868158476L;
    private String id;
    private String code;
    private String name;
    private String shortName;
    private String description;
    private String parentId;
    private String grantLevel;
    private String areaId;
    private String areaName;
    private String organType;
    private String organTypeName;
    private String addr;
    private String phone;
    private Integer state;
    private String oddis;
    private int childCount;
    private List<OrganQuota> quotaList;

    public List<OrganQuota> getQuotaList() {
        return quotaList;
    }

    public void setQuotaList(List<OrganQuota> quotaList) {
        this.quotaList = quotaList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getGrantLevel() {
        return grantLevel;
    }

    public void setGrantLevel(String grantLevel) {
        this.grantLevel = grantLevel;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOddis() {
        return oddis;
    }

    public void setOddis(String oddis) {
        this.oddis = oddis;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public String getOrganTypeName() {
        return organTypeName;
    }

    public void setOrganTypeName(String organTypeName) {
        this.organTypeName = organTypeName;
    }
}
