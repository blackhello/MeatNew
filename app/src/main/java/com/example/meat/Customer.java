package com.example.meat;

import android.app.Application;
import android.util.Base64DataException;

import java.sql.Date;

public class Customer extends Application {
    private Integer CustomerID;
    private Boolean IsSaler;
    private Integer MemberTypeID;
    private String RealName;
    private String PYCode;
    private Boolean Gender;
    private String BirthPlace;
    private String Phone;
    private String Mobile;
    private String FAX;
    private String PostCode;
    private String Address;
    private String SaleAddress;
    private String Domicile;
    private Boolean LicenseType;
    private String LicenseNo;
    private String HealthNo;
    private String Immunization;
    private String HealthCardNo;
    private String UnitName;
    private String NickName;
    private String UnitAddress;
    private String BankName;
    private String BankAccount;
    private Integer IDTypeID;
    private String IDCode;
    private String ProvisionalNo;
    private Base64DataException Picture;
    private Base64DataException Seal;
    private Date RegDate;
    private Boolean State;
    private Boolean IsFreezed;
    private Boolean AutoVirement;
    private String Remark;
    private Base64DataException Privilege;
    private String CityID;

    public Customer(Integer CustomerID,Boolean IsSaler,Integer MemberTypeID,String RealName,String PYCode,Boolean Gender,String BirthPlace,String Phone,
                    String Mobile,String FAX,String PostCode,String Address,String SaleAddress,String Domicile,Boolean LicenseType,String LicenseNo,
                    String HealthNo,String Immunization,String HealthCardNo,String UnitName,String NickName,String UnitAddress,String BankName,
                    String BankAccount,Integer IDTypeID,String IDCode,String ProvisionalNo,Base64DataException Picture,Base64DataException Seal,
                    Date RegDate,Boolean State,Boolean IsFreezed,Boolean AutoVirement,String Remark,Base64DataException Privilege,String CityID){

        this.CustomerID=CustomerID;
        this.IsSaler=IsSaler;
        this.MemberTypeID=MemberTypeID;
        this.RealName=RealName;
        this.PYCode=PYCode;
        this.Gender=Gender;
        this.BirthPlace=BirthPlace;
        this.Phone=Phone;
        this.Mobile=Mobile;
        this.FAX=FAX;
        this.PostCode=PostCode;
        this.Address=Address;
        this.SaleAddress=SaleAddress;
        this.Domicile=Domicile;
        this.LicenseType=LicenseType;
        this.LicenseNo=LicenseNo;
        this.HealthNo=HealthNo;
        this.Immunization=Immunization;
        this.HealthCardNo=HealthCardNo;
        this.UnitName=UnitName;
        this.NickName=NickName;
        this.UnitAddress=UnitAddress;
        this.BankName=BankName;
        this.BankAccount=BankAccount;
        this.IDTypeID=IDTypeID;
        this.IDCode=IDCode;
        this.ProvisionalNo=ProvisionalNo;
        this.Picture=Picture;
        this.Seal=Seal;
        this.RegDate=RegDate;
        this.State=State;
        this.IsFreezed=IsFreezed;
        this.AutoVirement=AutoVirement;
        this.Remark= Remark;
        this.Privilege=Privilege;
        this.CityID=CityID;
    }

    public Customer() {
        super();
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Boolean getIsSaler() {
        return IsSaler;
    }

    public void setIsSaler(Boolean IsSaler) {
        this.IsSaler = IsSaler;
    }
    public Integer getMemberTypeID() {
        return MemberTypeID;
    }

    public void setMemberTypeID(Integer MemberTypeID) {
        this.MemberTypeID = MemberTypeID;
    }
    public String getRealName() {
        return RealName;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }
}
