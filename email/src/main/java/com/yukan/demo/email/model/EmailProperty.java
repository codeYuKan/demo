package com.yukan.demo.email.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yukan
 * @date 2019/12/13
 * @email yukan.cn.mail@gmail.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailProperty {

    private String stmpHost;

    private String sendMailAccount;

    private String mailSubject;

    private String sendTo;

    private String fileUrl;

    private String password;

}
