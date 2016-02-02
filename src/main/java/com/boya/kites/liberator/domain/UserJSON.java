package com.boya.kites.liberator.domain;

import java.io.Serializable;

/**
 * 登录服务返回结果。
 *
 * @author lz (Mail:lzazmy@163.com) <br>
 * @version 1.00.000
 */
public class UserJSON implements Serializable {

    protected String id;
    protected String name;
    protected String password;
    protected String description;
    private OrganizationJSON organ;
    private String phone;
    private String mail;
    private String mobile;
    private String addr;
    private Integer permit;
    private Integer state;
    private String oddis;
    private String roleList;
    private String actions;
    private String signature;
    private String modifier;
    private String authorityKey;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public UserJSON() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrganizationJSON getOrgan() {
        return organ;
    }

    public void setOrgan(OrganizationJSON organ) {
        this.organ = organ;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
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

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getAuthorityKey() {
        return authorityKey;
    }

    public void setAuthorityKey(String authorityKey) {
        this.authorityKey = authorityKey;
    }
}
