package com.qhit.lx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class POIExcelDemo4 {

	public static void main(String[] args) throws Exception {
        String title = "流程信息";
        String[] name = {"序号","流程名称","斗轮机","装船机","皮带机","所属企业"};
        //获取数据
        Connection connection = CommonUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT bf.flowid,bf.flowname,bv1.devname AS 'dljname',bv2.devname AS 'zcjname',bv3.devname AS 'pdjname',bc.compname AS 'compname'\n" +
                "FROM base_flow bf\n" +
                "LEFT JOIN base_company bc ON bf.compid=bc.compid\n" +
                "LEFT JOIN base_device bv1 ON bf.dljid=bv1.devid\n" +
                "LEFT JOIN base_device bv2 ON bf.zcjid=bv2.devid\n" +
                "LEFT JOIN base_device bv3 ON bf.pdjid=bv3.devid";
        ResultSet rs = statement.executeQuery(sql);
        CommonUtil.exportExcel(title,name,rs,"流程信息");
    }
		
	}

