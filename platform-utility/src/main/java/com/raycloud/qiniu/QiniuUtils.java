package com.raycloud.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/10.
 */
public class QiniuUtils {

    private static final Logger logger = Logger.getLogger(QiniuUtils.class);
    private static QiniuUtils qiniuUtils = null;//单例
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = "SqaAAOxVR83xZNA8GK1wXZxGK05xbRX0wrjOIJz6";
    private static String SECRET_KEY = "SZ5KytmCShsuZ5tpccRWd8yrgFlJ7t39mNceCjNo";
    //密钥配置
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //要上传的空间
    private static String bucketname = "osscache";
    //osscache绑定的外链地址
    private String domain = "http://o8y9vs86j.bkt.clouddn.com/";

    private QiniuUtils(){

    }

    public static QiniuUtils getInstance(){
        if(qiniuUtils == null) {
            synchronized (QiniuUtils.class) {
                if (qiniuUtils == null) {
                    qiniuUtils = new QiniuUtils();
                }
            }
        }
        return qiniuUtils;
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    /**
     * 简单文件上传功能
     * @param fileName 远程云保存的文件名字
     * @param localFilePath 本地服务器文件路径
     * @throws IOException
     */
    public void upload(String fileName,String localFilePath) throws IOException {
        int count = 0;
        while(count++ < 3) {
            try {
                //创建上传对象
                UploadManager uploadManager = new UploadManager();
                //调用put方法上传
                Response res = uploadManager.put(localFilePath, fileName, getUpToken());
                //System.out.println(res.bodyString());
                break;
            } catch (QiniuException e) {
                Response r = e.response;
                logger.error(MessageFormat.format("七牛上传文件失败,fileName:{0}",new Object[]{fileName}),e);
                try {
                    //响应的文本信息
                    System.out.println(r.bodyString());
                } catch (QiniuException e1) {
                    //ignore
                }
            }
        }
    }

    /**
     * 获取下载链接
     */
    public String getDownloadLink(String fileName){
        return auth.privateDownloadUrl(new StringBuilder(domain).append(fileName).toString(),3600);
    }

    public static void main(String args[]) throws IOException{

        String u = "http://o8y9vs86j.bkt.clouddn.com/my-java.jpg";
        String downloadRUL = auth.privateDownloadUrl(u);
        System.out.println(downloadRUL);
    }


}
