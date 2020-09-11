package com.yukan.demo.basic.string;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2020/9/2
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StringDemo {

    public static void main(String[] args) {
        String a = "首次报审时间\n" +
                "baodan_time\n" +
                "首次报审人员\n" +
                "baodan_user_name\n" +
                "订单编号\n" +
                "apply_no\n" +
                "审查时间\n" +
                "sc_date\n" +
                "风险等级\n" +
                "risk_grade\n" +
                "面签/审批顺序\n" +
                "man_check_first\n" +
                "版本\n" +
                "product_version\n" +
                "审查结果\n" +
                "sc_status\n" +
                "审查人员\n" +
                "sc_user_name\n" +
                "首次审批时间\n" +
                "sp_time\n" +
                "首次审批结果\n" +
                "sp_status\n" +
                "首次审批人员\n" +
                "sp_user_name\n" +
                "审查意见\n" +
                "sc_opinion\n" +
                "首次审批意见\n" +
                "sp_opinion\n" +
                "审查时效(小时)\n" +
                "s\n" +
                "审批时效(小时)\n" +
                "s1\n" +
                "审查时效2(小时)\n" +
                "s2\n" +
                "审批处理时间(小时)\n" +
                "sp_use_time\n" +
                "审查处理时间(小时)\n" +
                "sc_use_time\n" +
                "审查处理时间2(小时)\n" +
                "spbj_use_time\n" +
                "原贷借款人类型\n" +
                "ydkjkrlx\n" +
                "难易程度\n" +
                "rule_level\n" +
                "审查锁定时间\n" +
                "scsd_date\n" +
                "是否转人工审查\n" +
                "xtzrgsc\n" +
                "转人工原因\n" +
                "zrgyy\n" +
                "人工审查时间\n" +
                "rgsc_time\n" +
                "人工审查人员\n" +
                "rgsc_user\n" +
                "人工审查结果\n" +
                "rgsc_status\n" +
                "人工审查意见\n" +
                "rgsc_opinion\n" +
                "补件一级原因\n" +
                "remark_level_1\n" +
                "补件二级原因\n" +
                "remark_level_2\n" +
                "补件三级原因\n" +
                "remark_level_3\n" +
                "特批一级事项\n" +
                "first_type_desc\n" +
                "特批二级事项\n" +
                "second_type_desc\n" +
                "特批发起人\n" +
                "special_approve_apply_user\n" +
                "风险特批人员\n" +
                "fxtp_user\n" +
                "风险特批意见\n" +
                "fxtp_status\n" +
                "风险特批备注\n" +
                "fxtp_opinion\n" +
                "调用规则(录入)\n" +
                "zzlrdygz\n" +
                "调用规则(录入完成)\n" +
                "zzlrwcdygz\n" +
                "首次调用规则(录入)\n" +
                "sclrdygz\n" +
                "补件通知时间\n" +
                "spbj_time\n" +
                "处理时间\n" +
                "clsj_date_use\n" +
                "是否二次补件\n" +
                "if_second_supply\n" +
                "是否人工审批征信\n" +
                "rule_mancheck\n" +
                "追加担保人\n" +
                "append_guarantee_name_flag\n" +
                "时效\n" +
                "sx_date_use";
        String[] str =  a.split("\\n");
        for (int i = 0; i < str.length; i++) {

            System.out.print(str [++i] + "      STRING COMMENT '" + str[i - 1] + "',\n" +
                    "    ");
        }
    }
}
