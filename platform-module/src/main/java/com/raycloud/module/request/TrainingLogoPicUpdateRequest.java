package com.raycloud.module.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class TrainingLogoPicUpdateRequest extends Request {

    private static final long serialVersionUID = 8238734792486751207L;
    private MultipartFile logoPic;

    public MultipartFile getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(MultipartFile logoPic) {
        this.logoPic = logoPic;
    }
}
