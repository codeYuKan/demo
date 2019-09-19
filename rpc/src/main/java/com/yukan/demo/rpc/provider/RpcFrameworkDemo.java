package com.yukan.demo.rpc.provider;

/**
 * RPCFramework
 *
 * @author yukan
 * @date 2019/8/30
 * @email yukan.cn.mail@gmail.com
 */
public class RpcFrameworkDemo {

    /**
     * 暴露服务
     */
    public static void export(final Object service, int port){
        if(service == null){
            throw new IllegalArgumentException("service is null");
        }
        if(port < 0 || port > (1 << 16) - 1){
            throw new IllegalArgumentException("port:" + port + " is illegal");
        }

    }

}
