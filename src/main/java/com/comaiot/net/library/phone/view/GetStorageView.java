package com.comaiot.net.library.phone.view;

import com.comaiot.net.library.device.view.ComaiotView;
import com.comaiot.net.library.phone.bean.BaseAppEntity;

public interface GetStorageView extends ComaiotView {

    void onGetStorageToken(BaseAppEntity data, String fileName, String msgType, String fileType, String fromWhere, String filePath, int msg_Type, long createMsgTime);

    void onGetStorageToken(BaseAppEntity data, String filePath);
}
